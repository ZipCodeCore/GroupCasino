package io.zipcoder.casino;
import java.util.*;



public class BeetleService {

    private String[][] completeBeetle = new String[][]{{"\\","0","/"},
            {"⎛","|","⎞"},
            {"⎝","|","⎠"},
            {"/","⏝","\\"}
    };

    private String[][] usersBeetle = new String[][]{{" "," "," "},
            {" "," "," "},
            {" "," "," "},
            {" "," "," "}
    };
    private String[][] opponentsBeetle = new String[][]{{" "," "," "},
            {" "," "," "},
            {" "," "," "},
            {" "," "," "}
    };

    private Set<Integer> usersRolls = new HashSet<Integer>();
    private Set<Integer> opponentsRolls = new HashSet<Integer>();

    public BeetleService() {

    }

    public void updateBeetleDrawing(String[][] playersBeetle, Integer diceRoll) {

        switch (diceRoll) {
            case 1:
                playersBeetle[0][0] = completeBeetle[0][0];
                break;

            case 2:
                playersBeetle[0][2] = completeBeetle[0][2];
                break;

            case 3:
                playersBeetle[3][0] = completeBeetle[3][0];
                break;

            case 4:
                playersBeetle[3][2] = completeBeetle[3][2];
                break;

            case 5:
                playersBeetle[0][1] = completeBeetle[0][1];
                playersBeetle[1][1] = completeBeetle[1][1];
                playersBeetle[2][1] = completeBeetle[2][1];
                break;

            case 6:
                playersBeetle[1][0] = completeBeetle[1][0];
                playersBeetle[1][2] = completeBeetle[1][2];
                playersBeetle[2][0] = completeBeetle[2][0];
                playersBeetle[2][2] = completeBeetle[2][2];
                playersBeetle[3][1] = completeBeetle[3][1];
                break;

            default:
                System.out.println("something went wrong");
                break;
        }
    }

    public String[][] getCompleteBeetle(){
        return completeBeetle;
    }

    public Set<Integer> getUsersRolls() {
        return usersRolls;
    }

    public Set<Integer> getOpponentsRolls() {
        return opponentsRolls;
    }

    public String[][] getUsersBeetle(){
        return usersBeetle;
    }

    public String[][] getOpponentsBeetle(){
        return opponentsBeetle;
    }




}
