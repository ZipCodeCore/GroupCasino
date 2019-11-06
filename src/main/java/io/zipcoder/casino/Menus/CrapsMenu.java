package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Craps.CrapsGame;
import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.utilities.Console;

public class CrapsMenu implements Menu {

    private Console console;
    private String name = "Craps Menu";


    public CrapsMenu(CrapsGame crapsGame) {
        this.console = new Console (System.in, System.out);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() {
        console.clearScreen();

        console.print("                                                                                     \n" +
                "    ,o888888o.     8 888888888o.             .8.           8 888888888o      d888888o.   \n" +
                "   8888     `88.   8 8888    `88.           .888.          8 8888    `88.  .`8888:' `88. \n" +
                ",8 8888       `8.  8 8888     `88          :88888.         8 8888     `88  8.`8888.   Y8 \n" +
                "88 8888            8 8888     ,88         . `88888.        8 8888     ,88  `8.`8888.     \n" +
                "88 8888            8 8888.   ,88'        .8. `88888.       8 8888.   ,88'   `8.`8888.    \n" +
                "88 8888            8 888888888P'        .8`8. `88888.      8 888888888P'     `8.`8888.   \n" +
                "88 8888            8 8888`8b           .8' `8. `88888.     8 8888             `8.`8888.  \n" +
                "`8 8888       .8'  8 8888 `8b.        .8'   `8. `88888.    8 8888         8b   `8.`8888. \n" +
                "   8888     ,88'   8 8888   `8b.     .888888888. `88888.   8 8888         `8b.  ;8.`8888 \n" +
                "    `8888888P'     8 8888     `88.  .8'       `8. `88888.  8 8888          `Y8888P ,88P'  \n\n\n");
    }

    @Override
    public void handleChoice(int choice) {

    }



}
