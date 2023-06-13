package hust.soict.globalict.aims.media;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title) {
        this.title = title;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            return Objects.equals(this.title, ((Track) obj).title)
                    && this.length == ((Track) obj).length;
        }
        return false;
    }
}