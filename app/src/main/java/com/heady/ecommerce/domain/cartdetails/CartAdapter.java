package com.heady.ecommerce.domain.cartdetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.heady.ecommerce.R;
import com.heady.ecommerce.model.CartSummary;
import com.heady.ecommerce.model.roomentities.relation.CartDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Cart Adapter
 * @author SandeepD
 */
class CartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    private List<CartDetail> productDetailsList;
    private CartSummary cartSummary;
    private LayoutInflater layoutInflater;
    private Contracts.View cartView;

    public static final int VIEW_PRODUCT_ITEM = 0;
    public static final int VIEW_CART_SUMMARY = 1;

    CartAdapter(Context context, List<CartDetail> results, CartSummary cartSummary, Contracts.View cartView)
    {
        this.context = context;
        productDetailsList = results;
        layoutInflater = LayoutInflater.from(context);
        this.cartView = cartView;
        this.cartSummary = cartSummary;
    }

    public void addAll(List<CartDetail> results)
    {
        productDetailsList.addAll(results);
        notifyDataSetChanged();
    }

    public List<CartDetail> getList()
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        switch (viewType)
        {
            case VIEW_PRODUCT_ITEM:
                return new CartProductViewHolder(layoutInflater.inflate(R.layout.item_cart_product_details, parent,
                        false));
            case VIEW_CART_SUMMARY:
                return new CartSummaryViewHolder(layoutInflater.inflate(R.layout.item_price_details, parent,
                        false));
            default:
                return null;
        }
    }

    @Override
    public int getItemViewType(int position)
    {
        if (position == productDetailsList.size())
            return VIEW_CART_SUMMARY;
        else
            return VIEW_PRODUCT_ITEM;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (holder instanceof CartProductViewHolder)
            ((CartProductViewHolder) holder).bindViews(productDetailsList.get(position));
        else if (holder instanceof CartSummaryViewHolder)
            ((CartSummaryViewHolder) holder).bindViews(cartSummary);
    }

    @Override
    public int getItemCount()
    {
        return productDetailsList.size() + 1;
    }

    class CartProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        @BindView(R.id.tv_product_name)
        TextView tvProductName;
        @BindView(R.id.tv_color)
        TextView tvColor;
        @BindView(R.id.tv_size)
        TextView tvSize;
        @BindView(R.id.tv_quantity)
        TextView tvQuantity;
        @BindView(R.id.tv_price)
        TextView tvPrice;

        CartProductViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bindViews(CartDetail result)
        {

            tvProductName.setText(result.getProduct().getProductName());
            if (result.getVariant().getColor() != null)
            {
                tvColor.setVisibility(View.VISIBLE);
                tvColor.setText(context.getString(R.string.str_color, result.getVariant().getColor()));

            } else
            {
                tvColor.setVisibility(View.GONE);
            }

            if (result.getVariant().getSize() != 0)
            {
                tvSize.setVisibility(View.VISIBLE);
                tvSize.setText(context.getString(R.string.str_size, result.getVariant().getSize()));
            } else
            {
                tvSize.setVisibility(View.GONE);
            }
            tvQuantity.setText(context.getString(R.string.str_qty, result.getCart().getQuantity()));
            tvPrice.setText(context.getString(R.string.str_price, result.getVariant().getPrice(), result.getTax().getName(), result.getTax().getValue()));
        }

        @Override
        public void onClick(View v)
        {
            // cartView.onCategoryItemSelected(productDetailsList.get(getAdapterPosition()));
        }
    }


    class CartSummaryViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.tv_bag_total)
        TextView tvBagTotal;
        @BindView(R.id.tv_estimated_tax)
        TextView tvEstimatedTax;
        @BindView(R.id.tv_total_payable)
        TextView tvTotalPayable;

        CartSummaryViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindViews(CartSummary cartSummary)
        {
            tvBagTotal.setText(context.getString(R.string.str_rs, cartSummary.getCartTotal()));
            tvEstimatedTax.setText(context.getString(R.string.str_rs, cartSummary.getEstimatedTax()));
            tvTotalPayable.setText(context.getString(R.string.str_rs, cartSummary.getTotalPayable()));
        }

    }
}
