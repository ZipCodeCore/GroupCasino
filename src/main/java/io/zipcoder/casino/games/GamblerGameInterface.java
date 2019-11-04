package io.zipcoder.casino.games;

interface GamblerGameInterface {

     Double calcPayment(Double bet, Double odds);

     void withdraw(Double num);

     void deposit(Double num);

}
