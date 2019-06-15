package io.zipcoder.casino.player;

public class Player {
private String name;
private Double account;
private Boolean isPlaying = false;

    public Boolean getPlaying() {
        return isPlaying;
    }

    public void setPlaying(Boolean playing) {
        isPlaying = playing;
    }


    public Player(){}

    public Player(String name, Double account) {
        this.account = account;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double sum) {
        this.account = sum;
    }
}
