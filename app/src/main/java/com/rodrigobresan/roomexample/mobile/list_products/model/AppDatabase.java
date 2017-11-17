package com.rodrigobresan.roomexample.mobile.list_products.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();

    public static AppDatabase getDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "products")
                .allowMainThreadQueries()
                .build();
    }
}
