package com.example.bookstore.model;

import java.util.List;

public class User {
    private String email;
    private String name;
    private String uid;
    private String userType;
    private List<String> listCart;


    public User(String email, String name, String uid, String userType, List<String> listCart, String profileImage) {
        this.email = email;
        this.name = name;
        this.uid = uid;
        this.userType = userType;
        this.listCart = listCart;
        this.profileImage = profileImage;
    }


    public List<String> getListCart() {
        return listCart;
    }

    public void setListCart(List<String> listCart) {
        this.listCart = listCart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    private String profileImage;

    public User(){

    }

}
