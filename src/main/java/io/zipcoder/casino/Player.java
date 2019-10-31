package io.zipcoder.casino;

public class Player {

    private String firstName;
    private String lastName;
    private int age;
    private double balance;
    private double chipsInHand;

    public Player(String firstName, String lastName, int age, double balance, double chipsInHand) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.balance = balance;
        this.chipsInHand = chipsInHand;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public double getChipsInHand() {
        return chipsInHand;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setChipsInHand(double chipsInHand) {
        this.chipsInHand = chipsInHand;
    }

}
