package io.zipcoder.casino.utilities;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {

    Clip clip;

    public Sound(String fileName) {
        try {
            clip = AudioSystem.getClip();
            File soundFile = new File("./sounds/" + fileName);
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);

            clip.open(inputStream);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void play() {
        stop();
        reset();
        start();
    }

    public void start() {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

    public void reset() {
        clip.setFramePosition(0);
    }
}
