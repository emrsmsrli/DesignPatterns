package iztechify.util;

import com.google.gson.Gson;
import iztechify.models.user.User;
import iztechify.models.music.Artist;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class GSON {
    private static final Gson _GSON = new Gson();
    private static final String FILE_NAME_MUSIC = "music.json";
    private static final String FILE_NAME_USER = "user.json";

    public static Artist[] loadMusic() {
        try(FileReader fr = new FileReader(FILE_NAME_MUSIC)) {
            return _GSON.fromJson(fr, Artist[].class);
        } catch(Exception e) { e.printStackTrace(); throw new RuntimeException(); } // prevent "return null"
    }

    public static void saveMusic(Artist[] artists) {
        try(FileWriter fw = new FileWriter(FILE_NAME_MUSIC)) {
            fw.write(_GSON.toJson(artists));
        } catch(Exception e) { e.printStackTrace(); }
    }

    public static User[] loadUsers() {
        File userFile = new File(FILE_NAME_USER);
        if(!userFile.exists())
            return new User[0];

        try(FileReader fr = new FileReader(FILE_NAME_USER)) {
            return _GSON.fromJson(fr, User[].class);
        } catch(Exception e) { e.printStackTrace(); throw new RuntimeException(); }
    }

    public static void saveUsers(List<User> users) {
        try(FileWriter fw = new FileWriter(FILE_NAME_USER)) {
            fw.write(_GSON.toJson(users));
        } catch(Exception e) { e.printStackTrace(); }
    }
}
