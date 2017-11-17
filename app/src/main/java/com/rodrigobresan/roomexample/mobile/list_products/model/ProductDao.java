package com.rodrigobresan.roomexample.mobile.list_products.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM product")
    LiveData<List<Product>> getAll();

    @Query("SELECT * FROM product WHERE id IN (:productIds)")
    List<Product> getAllById(Long[] productIds);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(Product products);

    @Delete
    void delete(Product product);
}
