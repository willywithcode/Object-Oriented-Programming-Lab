package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public abstract class Media {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();
    private static int nbMedia = 0;

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
        setId(nbMedia);
    }

    public Media(String title) {
        this.title = title;
        nbMedia++;
        setId(nbMedia);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Media) {
            return Objects.equals(this.title, ((Media) obj).title);
        }
        return false;
    }

    public static void main(String[] args) {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        CompactDisc cd = new CompactDisc("Hello", "Ballad", 5f);
        Book book = new Book("Jungle", "Alan Kay", 12f);

        List<Media> media = new ArrayList<Media>();
        media.add(dvd);
        media.add(cd);
        media.add(book);

        for(Media item : media) {
            System.out.println(item.toString());
        }
    }
}
