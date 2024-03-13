package com.example.contactsapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsapp.databinding.ListItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {

    private ArrayList<Contacts> contacts;
    public MyAdapter(ArrayList<Contacts> contacts){
        this.contacts = contacts;
    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Crreating neew view holders for items in recycler view
        ListItemBinding listItemBinding =
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.list_item,
                        parent,
                        false
                );
        return new ContactViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contacts currContact = contacts.get(position);

        holder.listitembinding.setContact(currContact);

    }

    @Override
    public int getItemCount() {
        if(contacts!=null)return contacts.size();
        return 0;
    }


    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;

        notifyDataSetChanged();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{

        private ListItemBinding listitembinding;


//      public ContactViewHolder(@NonNull View itemView, ListItemBinding listitembinding) {
        public ContactViewHolder(@NonNull ListItemBinding listitembinding) {
            super(listitembinding.getRoot());   //gets the view
            this.listitembinding = listitembinding;
        }
    }
}
