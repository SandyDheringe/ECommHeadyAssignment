package com.heady.ecommerce.dao.repo;

import java.util.List;

/**
 * @author SandeepD
 * Base datasource
 * @param <T>
 */
public interface DataSource<T>
{

    void addItem(T item);

    void addItems(List<T> items);


}
