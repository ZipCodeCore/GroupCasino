import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.print.attribute.standard.PrinterLocation;
import java.util.ArrayList;

public class Palace extends CardGame {

//    PileOfCards deck = new PileOfCards();
    PileOfCards discard;

    public Palace (Player[] players , Integer numberOfDecks) {
        super(players, numberOfDecks);

    }
    public Boolean didWin(Player player) {return false;}
    public void playGame() {}
    public void endOfGame() {}
}
