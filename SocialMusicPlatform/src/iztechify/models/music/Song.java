package iztechify.models.music;

public class Song {
    private Album album;
    private String title;
    private String length;

    public Song(Album album, String title, String length) {
        this.album = album;
        this.title = title;
        this.length = length;
    }

    public Album getAlbum() {
        return album;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLength() {
        return length;
    }

    @Override
    public String toString() {
        return title + " by " + getAlbum().getArtist().getName();
    }
}
