package services;

import models.people.players.Player;

import java.util.ArrayList;

public class PlayerRepo {
    ArrayList<Player> playerRepo;

    public PlayerRepo() {
        this.playerRepo = new ArrayList();

    }

    public ArrayList<Player> getPlayers() //changedtogetPlayers and returns arrayList
    {
        return playerRepo;
    }

    public Player getPlayerByName(String name)
    {

        Player p1 = new Player();
        for (Player player1: playerRepo)
        {
            if (playerRepo.contains(name))
            {
                p1 = player1;
                break;
            }
        }
        return p1;

    }

    public Boolean addPlayer(Player p1)  //added argument Player p1 to this method
    {
        if (playerRepo.add(p1)) return true; else return false;
    }



}
