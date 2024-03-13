package com.example.contactsapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {


    private Repository myRepository;
    private LiveData<List<Contacts>> allContacts;                            //View model helps in cretingn bridge between UI and Data
                                                                            //It is similar to repository providing Data (to UI)


    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);

    }

    public LiveData<List<Contacts>> getAllContacts(){
        allContacts = myRepository.getContacts();
        return allContacts;
    }

    public void AddContact(Contacts contact){
        myRepository.AddContact(contact);
    }
    public void DeleteContact(Contacts contact){
        myRepository.DeleteContact(contact);
    }


}
