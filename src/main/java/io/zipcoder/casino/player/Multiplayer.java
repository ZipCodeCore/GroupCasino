package io.zipcoder.casino.player;

import jdk.internal.org.objectweb.asm.TypeReference;

import java.util.HashMap;

public class Multiplayer {
    private HashMap<Long, Player> playerDatabase;

    public Multiplayer(){

    }

//    public void loadPlayerDataBase(){
//        this.playerDatabase = JSON load Multiplayer.JSON
//    }

//    public void savePlayerDataBase(){
//        ObjectMapper objectMapper = new ObjectMapper();
//        mapper.writerWithType(new TypeReference<HashMap<Long, Player>>() {}).writeValue(new File("players.json"), playerDatabase);
//    }
}
