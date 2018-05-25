package com.jsystems.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements Serializable {

    public String imie;

//    public String getName() {
//        return imie;
//    }

//    public void setName(String name) {
//        this.imie = name;
//    }
//
//    public String getSurname() {
//        return nazwisko;
//    }
//
//    public void setSurname(String surname) {
//        this.nazwisko = surname;
//    }

    public String nazwisko;

    public List<Device> device;

    @Override
    public String toString() {
        return "User{" +
                "name='" + imie + '\'' +
                ", surname='" + nazwisko + '\'' +
                ", device=" + device +
                '}';
    }
}
