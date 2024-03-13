package com.example.contactsapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


//Entity class makes use of class as a table. each attribbute is used a a collumn(needs to beb menntioned)
@Entity(tableName = "Contacts_table") //can define table name(name of class on no input), primary key, indices
public class Contacts {


    @ColumnInfo(name = "contacts_id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "contact_name")
    private String name;

    @ColumnInfo(name = "contact_email")
    private String email;





    public Contacts( String name, String email) {

        this.name = name;
        this.email = email;
    }
    public Contacts() {
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
