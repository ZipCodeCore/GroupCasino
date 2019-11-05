package MainApplication;


import models.Lobby;
import services.PlayerRepo;

public class Casino {
    public static void main(String[] args) {
        // write your tests before you start fucking with this
        PlayerRepo playerRepo = new PlayerRepo();
        Lobby lobby = new Lobby(playerRepo);
    }
}
