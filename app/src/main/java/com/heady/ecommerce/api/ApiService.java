package com.heady.ecommerce.api;

import com.heady.ecommerce.model.response.MasterdataDTO;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService
{
    @GET("/json")
	Observable<MasterdataDTO> getCategoryAndProductDetails();
}
