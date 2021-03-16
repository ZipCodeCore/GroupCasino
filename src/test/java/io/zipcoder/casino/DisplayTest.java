package io.zipcoder.casino;

import org.junit.Test;

public class DisplayTest {

    @Test
    public void testPrintStartScreen() {
        Display disp = new Display();
        disp.printWelcomeMessage();
    }

}
