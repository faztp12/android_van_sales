package com.casualmill.vansales.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.casualmill.vansales.data.models.Item;

import java.util.List;

@Dao
public interface ItemDao {

    @Query("SELECT * FROM items i")
    List<Item> getAll();

    @Query("SELECT * FROM items WHERE item_code = :item_code")
    Item getItem(String item_code);

    @Query("SELECT * FROM items WHERE item_code LIKE '%' || :key || '%' OR item_name LIKE '%' || :key || '%'")
    List<Item> searchItem(String key);

    @Query("SELECT * FROM items WHERE barcode = :barcode")
    Item FindByBarcode(String barcode);

    @Query("DELETE FROM items")
    void DeleteAll();

    @Insert
    void Insert(Item item);

    @Delete
    void Delete(Item item);
}
