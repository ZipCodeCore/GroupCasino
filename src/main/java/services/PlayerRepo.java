package services;

import models.people.players.Player;

import java.util.ArrayList;

public class PlayerRepo {
    ArrayList<Player> playerRepo;
    PlayerService playerService = new PlayerService();

    public PlayerRepo() {
        this.playerRepo = new ArrayList();
    }

    public Boolean addPlayer(Player player) {
       return this.playerRepo.add(player);
    }

    public Player getPlayerById(Integer id) {
        for (Player player : playerRepo) {
            if (playerService.getId() == id) {
                return player;
            }
        }
        return null;
    }


}
