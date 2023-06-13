package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.MediaComparatorByTitleCost;

import java.util.*;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if(itemsOrdered.size() == MAX_NUMBERS_ORDERED) System.out.println("The cart is almost full");
        else {
            itemsOrdered.add(media);
            System.out.println("The media has been added");
        }
    }

    public void removeMedia(Media media) {
        if(itemsOrdered.remove(media)) {
            System.out.println("The media has been removed");
        } else System.out.println("Not have this media");
    }

    public void removeAllMedia() {
        itemsOrdered.removeAll(itemsOrdered);
    }

    public float totalCost() {
        float sum = 0;
        for(Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    public int numberOfMedia() {
        return itemsOrdered.size();
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for(int i=0;i<itemsOrdered.size();i++){
            System.out.println("" + (i+1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + this.totalCost() + "$");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        for(Media item : itemsOrdered){
            if(item.getId() == id) {
                System.out.println("Result for id: " + id);
                System.out.println(item.toString());
                System.out.println();
                return;
            }
        }
        System.out.println("No match is found!");
    }

    public void searchByTitle(String title) {
        for(Media item : itemsOrdered){
            if(item.getTitle().equals(title)) {
                System.out.println("Result for title: " + title);
                System.out.println(item.toString());
                System.out.println();
                return;
            }
        }
        System.out.println("No match is found!");
    }


    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public Media findByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (title.equals(m.getTitle())) return m;
        }
        return null;
    }
}
