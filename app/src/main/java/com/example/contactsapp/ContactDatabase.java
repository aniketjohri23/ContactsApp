package com.example.contactsapp;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contacts.class},version = 2) //@Databasee heelps in makinng class into a datbabse. all entities are mentioned to
//                                                        store in database


public abstract class ContactDatabase extends RoomDatabase {

    public abstract ContactDAO getContactDAO();//gets a DAO to interact with database


//    singleton Pattern
    public static ContactDatabase dbInstance; //creeates thee only instannce too use during wholee life cycle

    public static synchronized ContactDatabase getInstance(Context context){
        if(dbInstance == null){
            dbInstance = Room.databaseBuilder(context.getApplicationContext(),
                    ContactDatabase.class,
                    "Contacts_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return dbInstance;
    }
}
