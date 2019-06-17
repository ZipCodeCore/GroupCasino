import org.junit.Test;

import static org.junit.Assert.*;

public class ActionTest {

    @Test
    public void lookupTest() {
        //Given
        String input = "end";
        Action action = new Action(input);
        String expected = "quit";
        String actual = action.toActionString();
        assertEquals(expected, actual);
    }

    @Test
    public void getActTest() {
        String input = "QUIT";
        Action action = new Action(input);
        Act expected = Act.QUIT;
        Act actual = action.getAct();
        assertEquals(expected, actual);
    }

    @Test
    public void normalizeInput() {
        String input = "QuIT";
        Action action = new Action(input);
        String expected = "quit";
        String actual = action.normalizeInput();
        assertEquals(expected, actual);
    }

}