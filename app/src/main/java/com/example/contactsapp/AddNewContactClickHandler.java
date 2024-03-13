package com.example.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNewContactClickHandler  {

    Contacts contact;
    Context context;

    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contact, Context context,MyViewModel myViewModel) {
        this.contact = contact;
        this.context = context;
        this.myViewModel = myViewModel;
    }

    public void onSubmitClick(View view){
        if (contact.getName()==null || contact.getEmail()==null){
            Toast.makeText(context,"no empty fields allowed ",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(context,MainActivity.class);
            Contacts c = new Contacts(
                    contact.getName(),
                    contact.getEmail()
            );

            myViewModel.AddContact(c);
            context.startActivity(i);
        }

    }
}
