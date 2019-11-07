package io.zipcoder.casino.Utility;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// Java program to play an Audio
// file using Clip Object
public class Music
{

    // to store current position
    Long currentFrame;
    Clip clip;
    // current status of clip
    String status;
    AudioInputStream audioInputStream;
    public static String filePath;

    // constructor to initialize streams and clip
    public Music()
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        // create AudioInputStream object
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }


    // Method to play the audio
    public void play()
    {
        //start the clip
        clip.start();
        status = "play";
    }


    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

}

