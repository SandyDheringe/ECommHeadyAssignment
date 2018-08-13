package com.heady.ecommerce.dao.repo;

import java.util.List;

public interface DataSource<T>
{

    void addItem(T item);

    void addItems(List<T> items);


}
