package com.androidlearn.digiandroid.di;

import javax.inject.Inject;

public class User {

    Contact contact;


    @Inject
    public User(Contact contact) {
        this.contact = contact;



    }

    public void addUser(String email) {
        contact.setEmail(email);
    }

    public String getUser() {
        return contact.getEmail();
    }

    public void clear() {
        contact.deleteEmail();
    }


}
