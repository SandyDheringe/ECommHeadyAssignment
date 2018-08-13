package com.heady.ecommerce.domain.categorylist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heady.ecommerce.R;
import com.heady.ecommerce.domain.categorylist.Contracts;
import com.heady.ecommerce.model.response.CategoryDTO;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Sub category adapter
 *
 * @author SandeepD
 */
public class SubCategoryListAdapter extends ExpandableRecyclerViewAdapter<ParentCategoryViewHolder, ChildCategoryViewHolder>
{

    Contracts.View categoryView;
    Context context;

    public SubCategoryListAdapter(List<? extends ExpandableGroup> groups, Context context, Contracts.View categoryView)
    {
        super(groups);
        this.categoryView = categoryView;
        this.context = context;
    }

    @Override
    public ParentCategoryViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_parent_category, parent, false);
        return new ParentCategoryViewHolder(view);
    }

    @Override
    public ChildCategoryViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child_category, parent, false);
        return new ChildCategoryViewHolder(view, categoryView);
    }

    @Override
    public void onBindChildViewHolder(ChildCategoryViewHolder holder, int flatPosition, ExpandableGroup group,
                                      int childIndex)
    {
        final CategoryDTO artist = ((CategoryGroup) group).getItems().get(childIndex);
        holder.onBind(artist);
    }

    @Override
    public void onBindGroupViewHolder(ParentCategoryViewHolder holder, int flatPosition,
                                      ExpandableGroup group)
    {
        final CategoryDTO categoryDTO = ((CategoryGroup) group).getParentCategory();

        holder.onBind(categoryDTO);
    }


}