package com.jsystems.api;

import sun.plugin2.message.Serializer;

import java.io.Serializable;

public class WeakUser implements Serializable {

    public WeakUser(){}

    public WeakUser(String name, String surname){
        this.name = name;
        this.surname=surname;
    }
    public String name;
    public String surname;
}
