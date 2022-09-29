package com.sheve;

import java.util.List;
import java.util.Random;

public class MusicPlayer {
    private List<Music> musicList;

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic(Genre genre) {
        int index = new Random().nextInt(3);
       if (genre == Genre.ROCK) {
           System.out.println("Player: " + musicList.get(0).getSong().get(index));
       } else {
           System.out.println("Player: " + musicList.get(1).getSong().get(index));
       }
    }
}
