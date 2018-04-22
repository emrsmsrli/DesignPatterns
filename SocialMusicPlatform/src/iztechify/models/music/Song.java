package iztechify.models.music;

public class Song {
    private String title;
    private String length;

    public Song(String title, String length) {
        this.title = title;
        this.length = length;
    }

    public void setTitle(String newTitle){
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

}
