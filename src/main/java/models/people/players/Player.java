package models.people.players;


public class Player {
    Double balance = 0.00;
    String name;
    Integer age;
    Integer id;

    public Player() {
    }

    public Player(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double newBalance) {
        this.balance = newBalance;
    }

    public void generatePlayerID() {
        this.id = (int)(Math.random() * ((9999999 - 1000000) + 1)) + 1000000;
    }

    public Integer getId() {
        return this.id;
    }
}
