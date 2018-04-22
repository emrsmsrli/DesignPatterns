package iztechify.models.user;

public class PlaylistEntry {
    private String artistName;
    private String albumName;
    private String songName;

    public PlaylistEntry(String artistName, String albumName, String songName) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.songName = songName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongName() {
        return songName;
    }
}
