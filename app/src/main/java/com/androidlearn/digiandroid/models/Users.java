package com.androidlearn.digiandroid.models;

public class Users {

    private int id;
    private String name;

    public Users () {

    }

    public Users( String name, String family, String phoneNumber) {
        this.name = name;
        this.family = family;
        this.phoneNumber = phoneNumber;
    }

    public Users(int id, String name, String family, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.phoneNumber = phoneNumber;
    }

    private String family;
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
