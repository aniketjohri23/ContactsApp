package com.example.contactsapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDAO { //Interfacee for DAO. defining(defining) methods for database

    @Insert
    Void Insert(Contacts contact);

    @Delete
    Void Delete(Contacts contact);

    @Query("SELECT * FROM contacts_table")
    LiveData<List<Contacts>> getAllContacts();

}
