package com.heady.ecommerce.domain.cartdetails;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.heady.ecommerce.BaseApplication;
import com.heady.ecommerce.BaseFragment;
import com.heady.ecommerce.R;
import com.heady.ecommerce.model.CartSummary;
import com.heady.ecommerce.model.roomentities.relation.CartDetail;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Cart Fragment.
 *
 * @author SandeepD
 */
public class CartFragment extends BaseFragment implements Contracts.View
{
    @BindView(R.id.rv_movie_list)
    RecyclerView rvCategoryList;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.tv_info)
    AppCompatTextView tvInfo;
    @BindView(R.id.tv_total)
    TextView tvTotal;

    @BindView(R.id.ll_summary)
    LinearLayout llSummary;
    Unbinder unbinder;

    @Inject
    CartPresenter presenter;

    private LinearLayoutManager linearLayoutManager;

    private CartAdapter cartAdapter;

    public static CartFragment newInstance()
    {
        Bundle args = new Bundle();
        CartFragment fragment = new CartFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getActivity().getApplication())
                .getAppComponent()
                .newCartComponent(new CartModule(this))
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
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

    //View methods
    @Override
    public void initView()
    {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rvCategoryList.setLayoutManager(linearLayoutManager);
        //cartAdapter = new cartAdapter(getContext(), this);
        //rvCategoryList.setAdapter(categoryListAdapter);
        presenter.fetchCartProductDetails();
    }

    @Override
    public void populateData(List<CartDetail> categoryGroupList, CartSummary cartSummary)
    {
        cartAdapter = new CartAdapter(getActivity(), categoryGroupList, cartSummary, this);
        rvCategoryList.setAdapter(cartAdapter);
        tvTotal.setText(getString(R.string.str_rs, cartSummary.getTotalPayable()));
        hideLoading();
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
        llSummary.setVisibility(View.GONE);
        rvCategoryList.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        tvInfo.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading()
    {
        progressBar.setVisibility(View.GONE);
        tvInfo.setVisibility(View.GONE);
        rvCategoryList.setVisibility(View.VISIBLE);
        llSummary.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeFromCart()
    {
    }

    @OnClick(R.id.ll_total)
    public void showTotalDetails()
    {
        rvCategoryList.smoothScrollToPosition(cartAdapter.getItemCount());
    }
}
