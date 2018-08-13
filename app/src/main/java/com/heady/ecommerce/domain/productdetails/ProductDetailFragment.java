package com.heady.ecommerce.domain.productdetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.heady.ecommerce.BaseApplication;
import com.heady.ecommerce.BaseFragment;
import com.heady.ecommerce.R;
import com.heady.ecommerce.domain.cartdetails.CartActivity;
import com.heady.ecommerce.model.roomentities.relation.ProductDetails;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Product details fragment.
 *
 * @author SandeepD
 */
public class ProductDetailFragment extends BaseFragment implements Contracts.View
{
    @BindView(R.id.ll_details)
    LinearLayout llDetails;

    @BindView(R.id.ll_loading)
    LinearLayout llLoading;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.tv_info)
    AppCompatTextView tvInfo;

    @BindView(R.id.tv_product_name)
    TextView tvProductName;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_color)
    TextView tvColor;
    @BindView(R.id.tv_size)
    TextView tvSize;

    @BindView(R.id.btn_add_to_cart)
    Button btnAddToCart;
    Unbinder unbinder;

    @Inject
    ProductDetailPresenter presenter;

    public static final String PARAM_PRODUCT_DETAIL = "param_product_detail";

    private ProductDetails productDetails;

    public static ProductDetailFragment newInstance(ProductDetails productDetails)
    {

        Bundle args = new Bundle();
        args.putParcelable(PARAM_PRODUCT_DETAIL, productDetails);
        ProductDetailFragment fragment = new ProductDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getActivity().getApplication())
                .getAppComponent()
                .newProductDetailComponent(new ProductDetailModule(this))
                .inject(this);

        productDetails = getArguments().getParcelable(PARAM_PRODUCT_DETAIL);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_product_detail, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        presenter.init();
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_go_to_cart:
                Intent intent = new Intent(getActivity(), CartActivity.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //View methods
    @Override
    public void initView()
    {
        tvProductName.setText(productDetails.getProductName());
        tvPrice.setText(String.format("Rs. %d ", productDetails.getPrice()));

        if (productDetails.getColor() != null)
            tvColor.setText(String.format("Available in %s color", productDetails.getColor()));

        if (productDetails.getSize() != 0)
            tvSize.setText(String.format("Available in %s size", productDetails.getSize()));
    }

    @Override
    public void onError(Throwable throwable)
    {
        hideLoading();
        Snackbar.make(tvInfo, R.string.something_went_wrong, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading()
    {
        llDetails.setVisibility(View.GONE);
        llLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading()
    {
        llLoading.setVisibility(View.GONE);
        llDetails.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.btn_add_to_cart)
    public void addToCart()
    {
        presenter.addtoCart(productDetails);
    }

    @Override
    public void onSuccess()
    {
        btnAddToCart.setText("Go To Cart");
    }
}
