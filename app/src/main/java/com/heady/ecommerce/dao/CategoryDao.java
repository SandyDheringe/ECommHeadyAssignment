package com.heady.ecommerce.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.heady.ecommerce.model.roomentities.Category;
import com.heady.ecommerce.model.roomentities.relation.CategoryAndMappingNew;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface CategoryDao
{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Category category);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Category> categories);

    @Query("SELECT DISTINCT Category.* FROM Category INNER JOIN ParentChildCategoryMapping ON" +
            " Category.category_id = ParentChildCategoryMapping.parent_id " +
            "WHERE Category.category_id NOT IN (SELECT DISTINCT ParentChildCategoryMapping.child_id FROM ParentChildCategoryMapping)")
    Single<List<Category>> getParentCategories();

    @Query("SELECT Category.*,ParentChildCategoryMapping.* FROM Category INNER JOIN ParentChildCategoryMapping ON" +
            " Category.category_id = ParentChildCategoryMapping.child_id WHERE ParentChildCategoryMapping.parent_id=:categoryId")
    Single<List<Category>> getChildCategories(int categoryId);


    @Query("SELECT * FROM Category WHERE Category.category_id= :id")
    Single<Category> getCategoryById(int id);

    @Query("SELECT * FROM Category")
    Single<List<Category>> getCategories();


    @Query("SELECT Category.* FROM Category INNER JOIN ParentChildCategoryMapping ON" +
            " Category.category_id = ParentChildCategoryMapping.child_id WHERE ParentChildCategoryMapping.parent_id=:parentCategoryId")
    Single<List<Category>> getParentSubCategoriesByParentCategoryId(int parentCategoryId);


    @Query("SELECT Category.*,ParentChildCategoryMapping.parent_id FROM Category " +
            "INNER JOIN ParentChildCategoryMapping ON Category.category_id = ParentChildCategoryMapping.child_id " +
            "WHERE ParentChildCategoryMapping.parent_id IN (SELECT ParentChildCategoryMapping.child_id " +
            "FROM ParentChildCategoryMapping WHERE ParentChildCategoryMapping.parent_id=:parentCategoryId)")
    Single<List<CategoryAndMappingNew>> getChildSubCategoriesByParentCategoryId(int parentCategoryId);


}
