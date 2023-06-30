package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, float cost, String director) {
        super(title, category, cost, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() +
                (this.getDirector() != null ? " - " + this.getDirector() : "") +
                (this.getLength() > 0 ? " - " + this.getLength() : "") +
                ": " + this.getCost() + "$";
    }

    @Override
    public String play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
            return "Playing DVD: " + this.getTitle() + "\n" +
                    "DVD length: " + this.getLength();
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}








