import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DolioStyleCrapsTest {

    @Test
    public void didWin() {
        Dice dice=new Dice(2);
        DStyleCrapsPlayer[] player={new DStyleCrapsPlayer(new Person(500.00,"Jon",25))};
        DolioStyleCraps dCraps=new DolioStyleCraps(player);
        Boolean b=false;
        int j=dCraps.getDice().tossAndSum();
       if(j==7){
          b= dCraps.didWin(player[0]);
        }
            Assert.assertEquals(true, b);
    }

    @Test
       public void didWin1() {
        DStyleCrapsPlayer[] player= {new DStyleCrapsPlayer(new Person(500.00,"Jon",25))};
        DolioStyleCraps dCraps = new DolioStyleCraps(player);
        Boolean b =false;
        dCraps.playGame();
        System.out.println(dCraps.getDice().sum());
        System.out.println(dCraps.didWin(player[0]));
        if(dCraps.getDice().sum() == 11) {
          b=dCraps.didWin(player[0]);

        }
          Assert.assertTrue(b );
    }
        @Test
    public void playGame() {

    }

    @Test
    public void endOfGame() {

        DStyleCrapsPlayer[] player= {new DStyleCrapsPlayer(new Person(500.00,"Jon",25))};
        DolioStyleCraps dCraps=new DolioStyleCraps(player);
        Boolean b = false;
        dCraps.playGame();
        int j = dCraps.getDice().sum();
        if (j == 2) {
            b =  dCraps.didWin(player[0]);
        }
        Assert.assertEquals(false, dCraps.didWin(player[0]));
    }
  //  @Test
//    public void endOfGame1() {
//
//        Dice dice=new Dice(2);
//        DolioStyleCraps dCraps=new DolioStyleCraps(2);
//        int j=dice.tossAndSum();
//        j=7;
//    }
}