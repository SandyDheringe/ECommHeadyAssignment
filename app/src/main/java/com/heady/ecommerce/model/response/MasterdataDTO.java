package com.heady.ecommerce.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Master data DTO
 *
 * @author SandeepD
 */
public class MasterdataDTO
{
	@SerializedName("categories")
	@Expose
	private List<CategoryDTO>        categories = null;
	@SerializedName("rankings")
	@Expose
	private List<RankingCategoryDTO> rankings   = null;


	public List<CategoryDTO> getCategories()
	{
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories)
	{
		this.categories = categories;
	}

	public List<RankingCategoryDTO> getRankings()
	{
		return rankings;
	}

	public void setRankings(List<RankingCategoryDTO> rankings)
	{
		this.rankings = rankings;
	}
}