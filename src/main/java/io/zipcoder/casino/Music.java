package io.zipcoder.casino;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Music {

    public static void main(String[] args){
        playMusic("src/music/(Roulette) Kirby Star Allies Music.wav");
        stopMusic("src/music/(Roulette) Kirby Star Allies Music.wav");
    }

    public static void playMusic(String filepath) {
        InputStream music;
        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    public static void stopMusic(String filepath) {
        InputStream music;
        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
            if (audios != null)
            {
                AudioPlayer.player.stop(audios);
            }
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }
}

