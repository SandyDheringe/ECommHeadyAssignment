package com.heady.ecommerce.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.heady.ecommerce.model.response.CategoryDTO;
import com.heady.ecommerce.model.response.MasterdataDTO;
import com.heady.ecommerce.model.response.RankingCategoryDTO;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author SandeepD.
 */
public class MockApiService implements ApiService
{

    @Override
    public Observable<MasterdataDTO> getCategoryAndProductDetails()
    {
        MasterdataDTO masterdataDTO = new MasterdataDTO();
        String category = "{\"id\":1,\"name\":\" Casuals\",\"products\":[{\"id\":1,\"name\":\"Nike Sneakers\",\"date_added\":\"2016-12-09T11:16:11.000Z\",\"variants\":[{\"id\":1,\"color\":\"Blue\",\"size\":42,\"price\":1000},{\"id\":2,\"color\":\"Red\",\"size\":42,\"price\":1000},{\"id\":3,\"color\":\"Blue\",\"size\":44,\"price\":1200},{\"id\":4,\"color\":\"Red\",\"size\":44,\"price\":1200}],\"tax\":{\"name\":\"VAT\",\"value\":12.5}}";
        String Ranking = "[{\"ranking\":\"Most Viewed Products\",\"products\":[{\"id\":1,\"view_count\":56700},{\"id\":2,\"view_count\":60000}]},{\"ranking\":\"Most OrdeRed Products\",\"products\":[{\"id\":1,\"order_count\":5600},{\"id\":2,\"order_count\":4300}]},{\"ranking\":\"Most ShaRed Products\",\"products\":[{\"id\":10,\"shares\":1800},{\"id\":11,\"shares\":2600}]}]";

        masterdataDTO.setCategories(new Gson().fromJson(category, new TypeToken<List<CategoryDTO>>()
        {
        }.getType()));
        masterdataDTO.setRankings(new Gson().fromJson(Ranking, new TypeToken<List<RankingCategoryDTO>>()
        {
        }.getType()));
        return Observable.just(masterdataDTO);
    }
}
