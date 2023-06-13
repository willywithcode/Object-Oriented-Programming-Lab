package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        //Create a new cart
        Store store = new Store();

        // Create new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
                "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);

        //print total cost of the items in the cart
        System.out.println("Total Cost is: ");
        System.out.println(store.totalCost());

        store.removeMedia(dvd3);
        //print total cost of the items in the cart
        System.out.println("Total Cost is: ");
        System.out.println(store.totalCost());
    }
}
