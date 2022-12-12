package com.example.pertemuan5_recycleview;

public class Model {
    private int id;
    private byte[]proavatar;
    private String username;
    private String userstar;
    private String userprice;
    //constructor
    public Model(int id, byte[] proavatar, String username, String userstar, String userprice) {
        this.id = id;
        this.proavatar = proavatar;
        this.username = username;
        this.userstar = userstar;
        this.userprice = userprice;
    }
    //getter and setter method
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public byte[] getProavatar() {
        return proavatar;
    }
    public void setProavatar(byte[] proavatar) {
        this.proavatar = proavatar;
    }
    public String getUsername() {
        return username;
    }public void setUsername(String username) {
        this.username = username;
    }
    public String getUserstar() {
        return userstar;
    }
    public void setUserstar(String userstar) {
        this.userstar = userstar;
    }
    public String getUserprice() {
        return userprice;
    }
    public void setUserprice(String userprice) {
        this.userprice = userprice;
    }
}
