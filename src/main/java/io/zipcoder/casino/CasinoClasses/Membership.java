package io.zipcoder.casino.CasinoClasses;

public class Membership {
    String name = "";
    Integer idNumber = 0;
    Integer balance = 0;
    Integer age = 0;

    public Membership(String name, Integer idNumber, Integer balance, Integer age) {
        this.name = name;
        this.idNumber = idNumber;
        this.balance = balance;
        this.age = age;

    }
}