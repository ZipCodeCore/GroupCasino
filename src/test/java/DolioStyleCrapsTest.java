import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DolioStyleCrapsTest {

    @Test
    public void didWin() {
        Dice dice=new Dice(2);
        Player[] player= {new DStyleCrapsPlayer(new Person(500,"Jon",25))};
        DolioStyleCraps dCraps=new DolioStyleCraps(player,2);

        Boolean b=false;
        int j=dice.tossAndSum();

        if(j==7){
            b=true;
        }
            Assert.assertEquals(true, dCraps.didWin(player[0]));
    }
    @Test
    public void didWin1() {
        Dice dice = new Dice(2);
        DolioStyleCraps dCraps = new DolioStyleCraps(2);
        Player[] player= {new DStyleCrapsPlayer(new Person(500,"Jon",25))};
        Boolean b = false;
        int j = dice.tossAndSum();

        if (j == 11) {
            dCraps.didWin(player[0]);
        }
          Assert.assertEquals(true, dCraps.didWin(player[0]));
    }

    @Test
    public void endOfGame() {

        Dice dice=new Dice(2);
        DolioStyleCraps dCraps=new DolioStyleCraps(2);
        Player[] player= {new DStyleCrapsPlayer(new Person(500,"Jon",25))};
        Boolean b = false;
        int j = dice.tossAndSum();

        if (j == 2) {
            b =  dCraps.didWin(player[0]);
        }
        Assert.assertEquals(false, dCraps.didWin(player[0]));
    }
    @Test
    public void endOfGame1() {

        Dice dice=new Dice(2);
        DolioStyleCraps dCraps=new DolioStyleCraps(2);
        int j=dice.tossAndSum();
        j=7;
    }
}