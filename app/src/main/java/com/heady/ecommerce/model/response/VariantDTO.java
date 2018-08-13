package com.heady.ecommerce.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VariantDTO
{
	@SerializedName("id")
	@Expose
	private int    id;
	@SerializedName("color")
	@Expose
	private String color;
	@SerializedName("size")
	@Expose
	private int    size;
	@SerializedName("price")
	@Expose
	private int    price;


	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}
}