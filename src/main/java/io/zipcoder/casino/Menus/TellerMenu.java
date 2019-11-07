package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Services.GameServices;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.Utility.Music;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TellerMenu implements Menu {

    Music tellerMusic = null;
    private Console console;
    private Player player;
    private String name = "Teller Menu";
    private GameServices gameServices = new GameServices();

    public TellerMenu(Player player) {
        this.player = player;
        this.console = new Console(System.in, System.out);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() throws InterruptedException {
        console.clearScreen();

        //plays music!
        try {
            Music.filePath = "src/music/(Teller) Casino slot -SOUND EFFECTS.wav";
            tellerMusic = new Music();
            tellerMusic.play();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
        console.println("          .-------.\n" +
                "       oO{-JACKPOT-}Oo\n" +
                "       .=============.  __\n" +
                "       |[\uD83E\uDD5D] [\uD83E\uDD5D] [\uD83D\uDD14]| (  )\n" +
                "       |[\uD83C\uDF52] [\uD83C\uDF52] [\uD83C\uDF52]| ||\n" +
                "       |[\uD83D\uDCB0] [\uD83D\uDD14] [\uD83D\uDCB0]| ||\n" +
                "       |             |__||\n" +
                "       | xxx ::::::: |---'\n" +
                "       | ooo ::::::: |\n" +
                "       | $$$ ::::::: |\n" +
                "       |             |\n" +
                "       |      __ === |\n" +
                "       |_____/__\\____|\n" +
                "      /###############\\\n" +
                "     /#################\\\n" +
                "    |###################|\n" +"\n" + "\n");


        console.printWithDelays("[TELLER]: What can I do for ya?\n\n",TimeUnit.MILLISECONDS, 50);

        // temporary
        console.println("1. Deposit funds");
        console.println("2. Cash out / Go home");
        console.println("3. Back to lobby");
        console.println(String.format("\nCurrent balance: $%.2f", player.getBalance()));

        handleChoice(console.getInteger(3));
    }

    @Override
    public void handleChoice(int choice) throws InterruptedException {

        switch (choice) {
            case 1:
                depositFunds();
                try {
                    tellerMusic.stop();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                cashOut();

                try {
                    tellerMusic.stop();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }

                console.clearScreen();
                Casino.displayEnding(this.player);
                break;
            case 3:
                // let's nix this, get it to just fall through back into MM
                MainMenu mainmenu = new MainMenu(this.player);
                try {
                    tellerMusic.stop();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }

                mainmenu.displayMenu();
                break;
        }
    }

    public void depositFunds() throws InterruptedException {
        double funds = console.getCurrency("\n[TELLER]: How much are you depositing?\n");
        if (funds == 0.0) {
            console.printWithDelays("\n[TELLER]: Quit wastin' my time, buddy\n", TimeUnit.MILLISECONDS, 50);
        } else if (funds > 10000.0) {
            console.printWithDelays("\n[TELLER]: Whoa, jeez, OK: you just knock over a bank or something?\n", TimeUnit.MILLISECONDS, 50);
            gameServices.deposit(funds, this.player);
            console.printWithDelays("\n[TELLER]: Good luck, fancy pants!\n", TimeUnit.MILLISECONDS, 50);
        } else if (funds <= 20.0){
            console.printWithDelays("\n[TELLER]: Wow, are you sure it's safe walkin' around with all that?\n", TimeUnit.MILLISECONDS, 50);
            gameServices.deposit(funds, this.player);
            console.printWithDelays("[TELLER]: Don't spend it all in once place! \n(He chuckles and proceeds to help another customer) \n\n", TimeUnit.MILLISECONDS, 50);
        } else {
            console.printWithDelays(String.format("\n[TELLER]: Depositing $%.2f\n",funds));
            console.printWithDelays(". . .", 750);
            gameServices.deposit(funds, this.player);
            console.printWithDelays("\n[TELLER]: Here you go! Good luck at the tables.\n", TimeUnit.MILLISECONDS, 50);
        }

        console.getInput("\n\n( Press Enter to continue )\n");
    }

    public Double cashOut () {
        Double withdrawal = gameServices.withdraw(this.player);
        if (withdrawal != null) {
            this.player.setWinnings(withdrawal - this.player.getInitialBalance());
            return withdrawal;
        } else {
            return 0.0;
        }

    }

}
