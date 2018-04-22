package iztechify.util;

import com.google.gson.Gson;
import iztechify.models.Music;
import iztechify.models.Users;
import iztechify.models.user.User;
import iztechify.models.music.Artist;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class GSON implements Observer {
    private static final Gson _GSON = new Gson();
    private static final String FILE_NAME_MUSIC = "music.json";
    private static final String FILE_NAME_USER = "user.json";
    private static GSON INSTANCE = null;

    public List<Artist> loadMusic() {
        try(FileReader fr = new FileReader(FILE_NAME_MUSIC)) {
            return new ArrayList<>(Arrays.asList(_GSON.fromJson(fr, Artist[].class)));
        } catch(Exception e) { e.printStackTrace(); throw new RuntimeException(); } // prevent "return null"
    }

    public List<User> loadUsers() {
        File userFile = new File(FILE_NAME_USER);
        if(!userFile.exists())
            return new ArrayList<>();

        try(FileReader fr = new FileReader(FILE_NAME_USER)) {
            return new ArrayList<>(Arrays.asList(_GSON.fromJson(fr, User[].class)));
        } catch(Exception e) { e.printStackTrace(); throw new RuntimeException(); }
    }

    private void saveMusic(List<Artist> artists) {
        try(FileWriter fw = new FileWriter(FILE_NAME_MUSIC)) {
            fw.write(_GSON.toJson(artists));
        } catch(Exception e) { e.printStackTrace(); }
    }

    private void saveUsers(List<User> users) {
        try(FileWriter fw = new FileWriter(FILE_NAME_USER)) {
            fw.write(_GSON.toJson(users));
        } catch(Exception e) { e.printStackTrace(); }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Users) {
            saveUsers(((Users)o).getUsers());
        } else if(o instanceof Music) {
            saveMusic(((Music)o).getArtists());
        }
    }

    private GSON() {}
    public static GSON get() {
        if(INSTANCE == null)
            INSTANCE = new GSON();
        return INSTANCE;
    }
}
