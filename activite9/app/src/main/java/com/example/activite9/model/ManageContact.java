package com.example.activite9.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

public class ManageContact {


    public ManageContact(Context context)
    {
        Cursor cursor= context.getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,null,null,null
        );
        while(cursor.moveToNext())
        {
            @SuppressLint("Range")
            String name =
                    cursor.getString(
                            cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            @SuppressLint("Range")
            String phonenumber=  cursor.getString(
                    cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Contact contact =new Contact(name, phonenumber);
            contacts.add(contact);
        }
        cursor.close();
    }
    private ArrayList<Contact> contacts=new ArrayList<>();

    public Contact getContactParPosition(int position)
    {
        if(position >= 0 && position < contacts.size())
        return contacts.get(position);
        else
            return  null;
    }

    public void add(Contact contact) {

        contacts.add(contact);
    }
}
