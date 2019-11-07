package io.zipcoder.casino.Interfaces;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface Menu {

    void displayMenu();

    void handleChoice(int choice);

    String getName ();

}
