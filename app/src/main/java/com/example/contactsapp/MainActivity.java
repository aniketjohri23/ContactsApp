package com.example.contactsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.example.contactsapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Data source
    private ContactDatabase contactDatabase;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();

    //Adapter
    private MyAdapter myAdapter;


    //BBinding
    private ActivityMainBinding mainBinding;
    private MainActivityClicckHandler clicckHandler;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Data binding
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        clicckHandler = new MainActivityClicckHandler(this);
        mainBinding.setClickHandler(clicckHandler);

        //Recycler View
        RecyclerView recyclerView = mainBinding.RecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);




        //Ddatabase
        contactDatabase = ContactDatabase.getInstance(this);

        //View Model
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);



        //Inseerrting neew contact
//        Contacts c1 = new Contacts("aniket","aniket@abc");
//        viewModel.AddContact(c1);
//         c1 = new Contacts("johri","johri@abc");
//        viewModel.AddContact(c1);






        //Loading ddata from ROOM DB
        viewModel.getAllContacts().observe(this,
                new Observer<List<Contacts>>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onChanged(List<Contacts> contacts) {

                        contactsArrayList.clear();
                        for(Contacts c : contacts){
                            Log.v("TAGY", c.getName());
                            contactsArrayList.add(c);

                        }
                        myAdapter.notifyDataSetChanged();
                    }
        });

        //Adapter

        myAdapter = new MyAdapter(contactsArrayList);
        recyclerView.setAdapter(myAdapter);

        // swipe to delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // If you swipe the item to the left
                Contacts c = contactsArrayList.get(viewHolder.getAdapterPosition());

                viewModel.DeleteContact(c);
            }
        }).attachToRecyclerView(recyclerView);



    }
}