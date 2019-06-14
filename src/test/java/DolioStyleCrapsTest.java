import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DolioStyleCrapsTest {

    @Test
    public void didWin() {
        DStyleCrapsPlayer[] player = {new DStyleCrapsPlayer(new Person(500.00, "Jon", 25))};
        DolioStyleCraps dCraps = new DolioStyleCraps(player);
        dCraps.playGame();
        System.out.println(dCraps.getDice().sum());
        System.out.println(dCraps.didWin(player[0]));
        if (dCraps.getDice().sum() == 2) {
            Assert.assertFalse(dCraps.didWin(player[0]));
        }
    }


    @Test
       public void didWin1() {
        DStyleCrapsPlayer[] player = {new DStyleCrapsPlayer(new Person(500.00, "Jon", 25))};
        DolioStyleCraps dCraps = new DolioStyleCraps(player);
        dCraps.playGame();
        if (dCraps.getDice().sum() != 11 || dCraps.getDice().sum() != 7||dCraps.getDice().sum() == 2) {
            Assert.assertFalse(dCraps.didWin(player[0]));
        }
    }
    @Test
    public void didWin3() {
        DStyleCrapsPlayer[] player = {new DStyleCrapsPlayer(new Person(500.00, "Jon", 25))};
        DolioStyleCraps dCraps = new DolioStyleCraps(player);
        dCraps.playGame();
        if (dCraps.getDice().sum() == 11 || dCraps.getDice().sum() == 7) {
            Assert.assertTrue(dCraps.didWin(player[0]));
        }
    }
        @Test
    public void playGame() {
            DStyleCrapsPlayer[] player= {new DStyleCrapsPlayer(new Person(500.00,"Jon",25))};
            DolioStyleCraps dCraps = new DolioStyleCraps(player);
            dCraps.playGame();
            if(dCraps.getDice().sum()!=0)
                Assert.assertTrue(dCraps.getDice().sum()!=0);
        }

    @Test
    public void endOfGame() {

        DStyleCrapsPlayer[] player= {new DStyleCrapsPlayer(new Person(500.00,"Jon",25))};
        DolioStyleCraps dCraps=new DolioStyleCraps(player);
        Boolean b = false;
        dCraps.playGame();
        int j = dCraps.getDice().sum();
        if (j == 2) {
           dCraps.didWin(player[0]);
        }
        Assert.assertEquals(false, dCraps.didWin(player[0]));
    }

}