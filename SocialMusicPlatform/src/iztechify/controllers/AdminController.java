package iztechify.controllers;

import iztechify.models.Music;

import javax.swing.*;

public class AdminController {
    private Music music;

    public AdminController(Music music) {
        this.music = music;
    }

    public void remove(String artist) {
        music.remove(artist);
    }

    public void remove(String artist, String album) {
        music.remove(artist, album);
    }

    public void remove(String artist, String album, String song) {
        music.remove(artist, album, song);
    }

    public void newArtist() {
        String name = JOptionPane.showInputDialog("Enter artist name");
        if(name == null)
            return;
        music.addArtist(name);
    }

    public void newAlbum(String artist) {
        String name = JOptionPane.showInputDialog("Enter album name for " + artist);
        if(name == null)
            return;
        String description = JOptionPane.showInputDialog("Enter description for " + name);
        if(description == null)
            return;
        music.addAlbum(artist, name, description);
    }

    public void newSong(String artist, String album) {
        String name = JOptionPane.showInputDialog("Enter song name for " + album + " by " + artist);
        if(name == null)
            return;
        String length = JOptionPane.showInputDialog("Enter length for " + name + " - (mm:ss)");
        if(length == null || !length.matches("\\d{2}:\\d{2}"))
            return;
        music.addSong(artist, album, name, length);
    }

    public void editArtist(String artist) {
        String name = JOptionPane.showInputDialog("Enter new artist name for " + artist);
        if(name == null)
            return;
        music.editArtist(artist, name);
    }

    public void editAlbum(String artist, String album) {
        String name = JOptionPane.showInputDialog("Enter new album name for " + album);
        if(name == null)
            return;
        String description = JOptionPane.showInputDialog("Enter new description for " + album);
        if(description == null)
            return;
        music.editAlbum(artist, album, name, description);
    }

    public void editSong(String artist, String album, String song) {
        String name = JOptionPane.showInputDialog("Enter new song name for " + album + " by " + artist);
        if(name == null)
            return;
        String length = JOptionPane.showInputDialog("Enter length for " + name + " - (mm:ss)");
        if(length == null || !length.matches("\\d{2}:\\d{2}"))
            return;
        music.editSong(artist, album, song, name, length);
    }
}
