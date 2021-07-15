//<<<<<<< HEAD
//package com.github.zipcodewilmington.casino.games.roulette;
//
//<<<<<<< HEAD
//import com.github.zipcodewilmington.casino.GambleableGame;
//import com.github.zipcodewilmington.casino.PlayerInterface;
//
//import java.util.List;
//
//public class RouletteGame implements GambleableGame {
//    List<RoulettePlayer> activePlayers;
//
//
//    @Override
//    public void add(PlayerInterface player) {
//=======
//import com.github.zipcodewilmington.casino.*;
//import com.github.zipcodewilmington.casino.objects.RouletteBet;
//import com.github.zipcodewilmington.casino.objects.Wheel;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class RouletteGame implements GambleableGame {
//    String gameName;
//    Wheel wheel;
//    List<PlayerInterface> activePlayers;
//    RoulettePlayer player;
//
//    public RouletteGame(String gameName, List<PlayerInterface> activePlayers, RoulettePlayer player) {
//        this.gameName = gameName;
//        this.activePlayers = activePlayers;
//        this.player = player;
//    }
//
//    @Override
//    public void add(PlayerInterface player) {
//        activePlayers.add(this.player);
//>>>>>>> 666a7ebd027305c66dc5c3332249a92bb4ffd763
//
//    }
//
//    @Override
//    public void remove(PlayerInterface player) {
//
//    }
//
//    @Override
//    public void run() {
//<<<<<<< HEAD
//=======
//        wheel.getSpinValue();
//>>>>>>> 666a7ebd027305c66dc5c3332249a92bb4ffd763
//
//    }
//
//    @Override
//    public int getNumberOfPlayers() {
//        return 0;
//    }
//
//    @Override
//    public boolean playerWins() {
//<<<<<<< HEAD
//        return false;
//=======
//        Scanner scanner = new Scanner(System.in);
//        //return (userInput == wheel.getSpinValue());
//        return false;
//
//>>>>>>> 666a7ebd027305c66dc5c3332249a92bb4ffd763
//    }
//
//    @Override
//    public boolean playerLoses() {
//        return false;
//    }
//
//<<<<<<< HEAD
//=======
//    public float calculateWinnings(RouletteBet bet){
//       return 0;
//    }
//
//>>>>>>> 666a7ebd027305c66dc5c3332249a92bb4ffd763
//    @Override
//    public void clearGame() {
//
//    }
//<<<<<<< HEAD
//=======
//
//
//>>>>>>> 666a7ebd027305c66dc5c3332249a92bb4ffd763
//}
//=======
//package com.github.zipcodewilmington.casino.games.roulette;
//import com.github.zipcodewilmington.casino.GambleableGame;
//import com.github.zipcodewilmington.casino.PlayerInterface;
//import java.util.List;
//import com.github.zipcodewilmington.casino.objects.RouletteBet;
//import com.github.zipcodewilmington.casino.objects.Wheel;
//import java.util.Scanner;
//
//public class RouletteGame implements GambleableGame {
//    String gameName;
//    Wheel wheel;
//    List<PlayerInterface> activePlayers;
//    RoulettePlayer player;
//
//    public RouletteGame(String gameName, List<PlayerInterface> activePlayers, RoulettePlayer player) {
//        this.gameName = gameName;
//        this.activePlayers = activePlayers;
//        this.player = player;
//    }
//
//    @Override
//    public void add(PlayerInterface player) {
//        activePlayers.add(this.player);
//
//
//    }
//
//    @Override
//    public void remove(PlayerInterface player) {
//
//    }
//
//    @Override
//    public void run() {
//        wheel.getSpinValue();
//
//
//    }
//
//    @Override
//    public int getNumberOfPlayers() {
//        return 0;
//    }
//
//    @Override
//    public boolean playerWins() {
//        Scanner scanner = new Scanner(System.in);
//        //return (userInput == wheel.getSpinValue());
//        return false;
//
//    }
//
//    @Override
//    public boolean playerLoses() {
//        return false;
//    }
//
//
//    public float calculateWinnings(RouletteBet bet){
//       return 0;
//    }
//
//
//    @Override
//    public void clearGame() {
//
//    }
//}
//>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
