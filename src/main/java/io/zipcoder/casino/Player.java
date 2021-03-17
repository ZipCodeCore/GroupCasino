package io.zipcoder.casino;
import io.zipcoder.casino.utilities.Console;

public class Player {

        private String firstName;
        private String lastName;
        private int age;
        private double balance;
        private double initialBalance;
        private double winAmt;

        public Player(String firstName, String lastName, int age, double balance) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.balance = balance;
            this.initialBalance = this.balance;
        }


    public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }
        public void setAge(int age) {
        this.age = age;
    }

        public double getBalance() {
            return balance;
        }
        public void setBalance(double balance) {
        this.balance = balance;
    }

        public double getInitialBalance() {
            return initialBalance;
        }
        public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

        public double getWinAmt() {
            return winAmt;
        }
        public void setWinAmt(double winAmt) {
            this.winAmt = winAmt;
        }

}

