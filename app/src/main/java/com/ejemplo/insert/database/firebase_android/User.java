package com.ejemplo.insert.database.firebase_android;

public class User {
    public String user;
    public int edad;
    public String correo;

    public  User(){}

    public User(String user,int edad,String correo){
        this.user=user;
        this.edad=edad;
        this.correo=correo;
    }
}
