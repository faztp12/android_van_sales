package com.casualmill.vansales.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.casualmill.vansales.data.models.InvoiceItem;

import java.util.List;

@Dao
public interface InvoiceItemDao {

    @Query("SELECT * FROM invoice_items WHERE invoice_no = :invoice_no")
    List<InvoiceItem> get_all_for_invoice_no(String invoice_no);

    @Insert
    void InsertAll(InvoiceItem... items);

    @Query("DELETE FROM invoice_items WHERE invoice_no = :invoice_no")
    void Delete(String invoice_no);
}
