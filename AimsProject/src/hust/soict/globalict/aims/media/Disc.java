package hust.soict.globalict.aims.media;

public class Disc extends Media {
    private String director;
    private int length;

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category, float cost, String director) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
}
