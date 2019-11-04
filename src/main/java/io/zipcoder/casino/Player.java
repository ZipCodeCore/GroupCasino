package io.zipcoder.casino;

public class Player {

    //declare a field of type String named name
    //declare a field of type double named money

    //create a constructor that takes a name
    // and set it to the field name

    //create a constructor that takes a name
    // and money. Set them to their fields

    //create a getter and setter for both fields

    //create a method called addMoney which
    // takes in a double named amount.
    // the method will add the amount to the
    // money

    //create a method called pay which
    //takes a double named amount
    //the method will substract the amount from
    //the money

    private String name;
    private double money;

    public Player (String name) {

        this.name = name;
    }

    public Player (String name, double money) {

        this.name = name;
        this.money = money;

    }

        public void setName(String playerone) {

            this.name = playerone;

        }

        public String getName(){

            return name;
        }

    public double getMoney() {
        return money;
    }
    //add a getter for money

    public double addMoney(double amount1){
        money = money + amount1;
        return money;
    }

    public double pay(double amount2){
        money = money - amount2;
        return money;

    }


}

