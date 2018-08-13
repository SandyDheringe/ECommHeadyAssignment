package com.heady.ecommerce.domain.productlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.heady.ecommerce.R;
import com.heady.ecommerce.model.roomentities.relation.ProductDetails;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author shishank
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.CategoryViewHolder>
{
    private Context context;

    private List<ProductDetails> productDetailsList;
    private LayoutInflater layoutInflater;
    private Contracts.View categoryView;

    public ProductListAdapter(Context context, Contracts.View categoryView)
    {
        this.context = context;
        productDetailsList = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
        this.categoryView = categoryView;
    }

    public void addAll(List<ProductDetails> results)
    {
        productDetailsList.addAll(results);
        notifyDataSetChanged();
    }

    public void setAll(List<ProductDetails> productDetailsList)
    {
        this.productDetailsList = productDetailsList;
        notifyDataSetChanged();
    }

    public List<ProductDetails> getList()
    {
        return productDetailsList;
    }

    public void clear()
    {
        if (productDetailsList != null)
        {
            productDetailsList.clear();
        }
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new CategoryViewHolder(layoutInflater.inflate(R.layout.item_product, parent,
                false));
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position)
    {
        holder.bindViews(productDetailsList.get(position));
    }

    @Override
    public int getItemCount()
    {
        return productDetailsList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        @BindView(R.id.tv_product_name)
        TextView tvProductName;
        @BindView(R.id.tv_product_price)
        TextView tvProductPrice;
        @BindView(R.id.tv_product_size)
        TextView tvProductSize;

        CategoryViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bindViews(ProductDetails result)
        {
            tvProductName.setText(result.getProductName());
            tvProductPrice.setText(String.format("Price: %d", result.getPrice()));
            tvProductSize.setText(String.format("MO: %d, MV: %d, MS: %d", result.getMostOrdered(), result.getMostViewed(), result.getMostShared()));
        }

        @Override
        public void onClick(View v)
        {
            categoryView.onCategoryItemSelected(productDetailsList.get(getAdapterPosition()));
        }
    }
}
