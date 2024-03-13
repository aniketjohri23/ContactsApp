package com.example.contactsapp;

import android.app.Application;
import android.os.Looper;

import android.os.Handler;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Repository { //specify all the data reetrieeval methodds forr all ddata sources here
//    Availabble ddata sourcees:
//                      -ROOM ddatabase

    //Sincee weee have only one data source(database) wee will ddeefine only those methods from ContactDAO Interface class

    private final ContactDAO contactDAO;

    ExecutorService executor;// gets the background thread
    Handler handler;//gets the main thread.helps in updating UI
    public Repository(Application application){
    //Since we'll be having only application context,we need to call database from getinstancee(cccontexxt)

        ContactDatabase contactDatabase = ContactDatabase.getInstance(application);

    //Then DDAO is called dfrrmm database;

        this.contactDAO = contactDatabase.getContactDAO();
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());

    }

    //Methods of DAO being used in Repository

    public void AddContact(Contacts contact){
        executor.execute(new Runnable() { //// Runnable: Executing Tasks on Separate Thread
            @Override
            public void run() {
                //runs asynchronously on seperate thrread
                contactDAO.Insert(contact);
            }
        });
    }

    public void DeleteContact(Contacts contact){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.Delete(contact);
            }
        });

    }

    public LiveData<List<Contacts>> getContacts() {
        return contactDAO.getAllContacts();
    }



}
