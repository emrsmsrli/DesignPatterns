package iztechify.util;

import com.google.gson.Gson;
import iztechify.models.Music;
import iztechify.models.Users;
import iztechify.models.music.Album;
import iztechify.models.music.Song;
import iztechify.models.user.User;
import iztechify.models.music.Artist;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

@SuppressWarnings("all")
public class GSON implements Observer {
    private static class _Artist {
        String name;
        List<_Album> albums;
        public _Artist() {}
        public _Artist(String name, List<_Album> albums) {
            this.name = name;
            this.albums = albums;
        }
    }
    private static class _Album {
        String title;
        String description;
        List<_Song> songs;

        public _Album() {}
        public _Album(String title, String description, List<_Song> songs) {
            this.title = title;
            this.description = description;
            this.songs = songs;
        }
    }
    private static class _Song {
        String title;
        String length;
        public _Song() {}
        public _Song(String title, String length) {
            this.title = title;
            this.length = length;
        }
    }

    private static final Gson _GSON = new Gson();
    private static final String FILE_NAME_MUSIC = "music.json";
    private static final String FILE_NAME_USER = "user.json";
    private static GSON INSTANCE = null;

    public List<Artist> loadMusic() {
        try(FileReader fr = new FileReader(FILE_NAME_MUSIC)) {
            List<_Artist> loadedArtists = new ArrayList<>(Arrays.asList(_GSON.fromJson(fr, _Artist[].class)));

            List<Artist> artists = new ArrayList<>();
            for(_Artist loadedArtist : loadedArtists) {
                Artist artist = new Artist(loadedArtist.name);
                for(_Album loadedAlbum : loadedArtist.albums) {
                    Album album = new Album(artist, loadedAlbum.title, loadedAlbum.description);
                    for(_Song loadedSong : loadedAlbum.songs)
                        album.addSong(new Song(album, loadedSong.title, loadedSong.length));
                    artist.addAlbum(album);
                }
                artists.add(artist);
            }

            return artists;
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

    private void saveMusic(List<Artist> arr) {
        try(FileWriter fw = new FileWriter(FILE_NAME_MUSIC)) {
            List<_Artist> artists = new ArrayList<>();
            for(Artist artist : arr) {
                List<_Album> albums = new ArrayList<>();
                for(Album album : artist.getAlbums()) {
                    List<_Song> songs = new ArrayList<>();
                    for(Song song : album.getSongs())
                        songs.add(new _Song(song.getTitle(), song.getLength()));
                    albums.add(new _Album(album.getTitle(), album.getDescription(), songs));
                }
                artists.add(new _Artist(artist.getName(), albums));
            }
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
