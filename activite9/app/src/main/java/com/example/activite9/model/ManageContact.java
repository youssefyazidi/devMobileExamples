package com.example.activite9.model;

import java.util.ArrayList;

public class ManageContact {

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
