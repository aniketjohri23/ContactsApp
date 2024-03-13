package com.example.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MainActivityClicckHandler {

    Context context;


    public MainActivityClicckHandler(Context context){
        this.context = context;
    }

    public void onFABclick(View view){

        Intent i = new Intent(view.getContext(),AddNewContactActivity.class);
        context.startActivity(i);

    }

}
