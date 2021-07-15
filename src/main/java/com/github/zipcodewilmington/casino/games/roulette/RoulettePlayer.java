package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.casino.Player;
<<<<<<< HEAD

=======
import com.github.zipcodewilmington.casino.objects.RouletteBet;
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e

public class RoulettePlayer implements GamblingPlayer {

    Player player;
    float playerWinnings;
<<<<<<< HEAD

import com.github.zipcodewilmington.casino.objects.RouletteBet;
=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e


    public RoulettePlayer(Player player) {
        this.player = player;
    }
<<<<<<< HEAD

=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
<<<<<<< HEAD

=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e

    public boolean finalizeBet(){
        return false;
    }

<<<<<<< HEAD
    public void increaseBet(float raise){
=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e

    @Override
    public void increaseBet(float raise) {
        player.setCurrentBet(player.getCurrentBet() + raise);
        player.setBalance(player.getBalance()-raise);
<<<<<<< HEAD

=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e

    }

    @Override
    public void decreaseBet(float deposit) {
<<<<<<< HEAD



        player.setCurrentBet(player.getCurrentBet()-deposit);
        player.setBalance(player.getBalance()+deposit);

=======
        player.setCurrentBet(player.getCurrentBet()-deposit);
        player.setBalance(player.getBalance()+deposit);
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
    }

    @Override
    public float amountWagered() {

<<<<<<< HEAD



=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
        return 0;
    }

    @Override
    public float amountWon() {
        return 0;
    }

    @Override
    public float payOut() {
        return 0;
    }

<<<<<<< HEAD

    void placeOutsideBet(){}

    void placeInsideBet(){}

=======
    void placeOutsideBet(){}

    void placeInsideBet(){}
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
    public RouletteBet placeBet(){
        return null;
    }

<<<<<<< HEAD


=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
}
