package services;

import models.people.players.Player;

import java.util.ArrayList;

public class PlayerRepo {
    ArrayList<Player> playerRepo;
    //PlayerService playerService = new PlayerService();

    public PlayerRepo() {
        this.playerRepo = new ArrayList();

    }

    public Boolean addPlayer(Player player) {
       return this.playerRepo.add(player);
    }

    /*public Player getPlayerById(Integer id) {
        for (Player player : playerRepo) {
            if (playerService.getId() == id) {
                return player;
            }
        }
        return null;
    }
     */

    public ArrayList<Player> getPlayers() //changed method to getPlayers and return value to arrayList
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











    public Boolean addPlayer2(Player p1)  //added argument Player p1 to this method
    {
        if (playerRepo.add(p1)) return true; else return false;
    }
}
