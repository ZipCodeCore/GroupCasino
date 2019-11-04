package models.people.players;

public class Player {
    Double balance = 0.00;
    String name;
    Integer age;

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
}
