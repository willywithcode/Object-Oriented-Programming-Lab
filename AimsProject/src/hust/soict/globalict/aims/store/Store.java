package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
import java.util.Objects;

public class Store {
    public static final int MAX_NUMBERS_MEDIAS = 20;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if(itemsInStore.size() == MAX_NUMBERS_MEDIAS) System.out.println("The store is almost full");
        else {
            itemsInStore.add(media);
            System.out.println("The store has been added");
        }
    }

    public void removeMedia(Media media) {
        if(itemsInStore.remove(media)) {
            System.out.println("The media has been removed");
        } else System.out.println("Not have this media");
    }

    public float totalCost() {
        float sum = 0;
        for(Media media : itemsInStore) {
            sum += media.getCost();
        }
        return sum;
    }

    public void showProduct() {
        for (Media m : itemsInStore) {
            System.out.println(m.toString());
        }
    }

    public Media findByTitle(String title) {
        for (Media m : itemsInStore) {
            if (title.equals(m.getTitle())) return m;
        }
        return null;
    }
}
