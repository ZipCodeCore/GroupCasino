//<<<<<<< HEAD
//<<<<<<< HEAD
//package com.github.zipcodewilmington.casino.games.roulette;
//
//import com.github.zipcodewilmington.casino.CasinoAccount;
//import com.github.zipcodewilmington.casino.GamblingPlayer;
//import com.github.zipcodewilmington.casino.Player;
//<<<<<<< HEAD
//
//public class RoulettePlayer implements GamblingPlayer {
//
//    Player player;
//    float playerWinnings;
//=======
//import com.github.zipcodewilmington.casino.objects.RouletteBet;
//
//public class RoulettePlayer implements GamblingPlayer {
//    Player player;
//
//    public RoulettePlayer(Player player) {
//        this.player = player;
//    }
//>>>>>>> 666a7ebd027305c66dc5c3332249a92bb4ffd763
//
//    @Override
//    public CasinoAccount getArcadeAccount() {
//        return null;
//    }
//
//    @Override
//    public <SomeReturnType> SomeReturnType play() {
//        return null;
//    }
//<<<<<<< HEAD
//
//    public boolean finalizeBet(){
//        return false;
//    }
//
//    public void increaseBet(float raise){
//=======
//    @Override
//    public void increaseBet(float raise) {
//        player.setCurrentBet(player.getCurrentBet() + raise);
//        player.setBalance(player.getBalance()-raise);
//>>>>>>> 666a7ebd027305c66dc5c3332249a92bb4ffd763
//
//    }
//
//    @Override
//    public void decreaseBet(float deposit) {
//<<<<<<< HEAD
//
//=======
//        player.setCurrentBet(player.getCurrentBet()-deposit);
//        player.setBalance(player.getBalance()+deposit);
//>>>>>>> 666a7ebd027305c66dc5c3332249a92bb4ffd763
//    }
//
//    @Override
//    public float amountWagered() {
//<<<<<<< HEAD
//=======
//
//>>>>>>> 666a7ebd027305c66dc5c3332249a92bb4ffd763
//        return 0;
//    }
//
//    @Override
//    public float amountWon() {
//        return 0;
//    }
//
//    @Override
//    public float payOut() {
//        return 0;
//    }
//
//<<<<<<< HEAD
//    void placeOutsideBet(){}
//
//    void placeInsideBet(){}
//=======
//    public RouletteBet placeBet(){
//        return null;
//    }
//
//
//
//>>>>>>> 666a7ebd027305c66dc5c3332249a92bb4ffd763
//}
//=======
//package com.github.zipcodewilmington.casino.games.roulette;
//
//import com.github.zipcodewilmington.casino.CasinoAccount;
//import com.github.zipcodewilmington.casino.GamblingPlayer;
//import com.github.zipcodewilmington.casino.Player;
//import com.github.zipcodewilmington.casino.objects.RouletteBet;
//
//public class RoulettePlayer implements GamblingPlayer {
//
//    Player player;
//    float playerWinnings;
//
//
//    public RoulettePlayer(Player player) {
//        this.player = player;
//    }
//
//    @Override
//    public CasinoAccount getArcadeAccount() {
//        return null;
//    }
//
//    @Override
//    public <SomeReturnType> SomeReturnType play() {
//        return null;
//    }
//
//    public boolean finalizeBet(){
//        return false;
//    }
//
//
//    @Override
//    public void increaseBet(float raise) {
//        player.setCurrentBet(player.getCurrentBet() + raise);
//        player.setBalance(player.getBalance()-raise);
//
//    }
//
//    @Override
//    public void decreaseBet(float deposit) {
//        player.setCurrentBet(player.getCurrentBet()-deposit);
//        player.setBalance(player.getBalance()+deposit);
//    }
//
//    @Override
//    public float amountWagered() {
//
//        return 0;
//    }
//
//    @Override
//    public float amountWon() {
//        return 0;
//    }
//
//    @Override
//    public float payOut() {
//        return 0;
//    }
//
//    void placeOutsideBet(){}
//
//    void placeInsideBet(){}
//    public RouletteBet placeBet(){
//        return null;
//    }
//
//}
//>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
//=======
//package com.github.zipcodewilmington.casino.games.roulette;
//
//import com.github.zipcodewilmington.casino.CasinoAccount;
//import com.github.zipcodewilmington.casino.GamblingPlayer;
//import com.github.zipcodewilmington.casino.Player;
//<<<<<<< HEAD
//
//=======
//import com.github.zipcodewilmington.casino.objects.RouletteBet;
//>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
//
//public class RoulettePlayer implements GamblingPlayer {
//
//    Player player;
//    float playerWinnings;
//<<<<<<< HEAD
//
//import com.github.zipcodewilmington.casino.objects.RouletteBet;
//=======
//>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
//
//
//    public RoulettePlayer(Player player) {
//        this.player = player;
//    }
//<<<<<<< HEAD
//
//=======
//>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
//
//    @Override
//    public CasinoAccount getArcadeAccount() {
//        return null;
//    }
//
//    @Override
//    public <SomeReturnType> SomeReturnType play() {
//        return null;
//    }
//<<<<<<< HEAD
//
//=======
//>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
//
//    public boolean finalizeBet(){
//        return false;
//    }
//
//<<<<<<< HEAD
//    public void increaseBet(float raise){
//=======
//>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
//
//    @Override
//    public void increaseBet(float raise) {
//        player.setCurrentBet(player.getCurrentBet() + raise);
//        player.setBalance(player.getBalance()-raise);
//<<<<<<< HEAD
//
//=======
//>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
//
//    }
//
//    @Override
//    public void decreaseBet(float deposit) {
//<<<<<<< HEAD
//
//
//
//        player.setCurrentBet(player.getCurrentBet()-deposit);
//        player.setBalance(player.getBalance()+deposit);
//
//=======
//        player.setCurrentBet(player.getCurrentBet()-deposit);
//        player.setBalance(player.getBalance()+deposit);
//>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
//    }
//
//    @Override
//    public float amountWagered() {
//
//<<<<<<< HEAD
//
//
//
//=======
//>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
//        return 0;
//    }
//
//    @Override
//    public float amountWon() {
//        return 0;
//    }
//
//    @Override
//    public float payOut() {
//        return 0;
//    }
//
//<<<<<<< HEAD
//
//    void placeOutsideBet(){}
//
//    void placeInsideBet(){}
//
//=======
//    void placeOutsideBet(){}
//
//    void placeInsideBet(){}
//>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
//    public RouletteBet placeBet(){
//        return null;
//    }
//
//<<<<<<< HEAD
//
//
//=======
//>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
//}
//>>>>>>> 89bffbba1f25bd42d6d243911d15ced2c349355f
