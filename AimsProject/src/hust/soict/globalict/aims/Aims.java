package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.Store;

import java.util.Scanner;

public class Aims {
    public static void showMenu() {

        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

    }

    public static void storeMenu() {

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void menuFilterOptions() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media by ID");
        System.out.println("2. Filter media by title");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 1-2");
    }

    public static void menuSortOptions() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort media by title");
        System.out.println("2. Sort media by cost");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 1-2");
    }

    public static Media searchMediaByName(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter media's name: ");
        String mediaName = scanner.nextLine();
        return store.findByTitle(mediaName);
    }

    public static Media searchMediaByNameCart(Cart cart) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter media's name: ");
        String mediaName = scanner.nextLine();
        return cart.findByTitle(mediaName);
    }

    public static void seeCurrentCart(Cart anOrder) {
        Scanner scanner = new Scanner(System.in);
        int choice4;
        do {
            anOrder.printCart();
            cartMenu();
            choice4 = scanner.nextInt(); scanner.nextLine();
            switch (choice4) {
                case 1 -> {
                    int filterChoice;
                    menuFilterOptions();
                    filterChoice = scanner.nextInt(); scanner.nextLine();
                    if (filterChoice == 1) {
                        System.out.println("Enter the media id:");
                        int mediaId = scanner.nextInt(); scanner.nextLine();
                        anOrder.searchById(mediaId);
                    } else if (filterChoice == 2) {
                        System.out.println("Enter the media title:");
                        String mediaTitle = scanner.nextLine();
                        anOrder.searchByTitle(mediaTitle);
                    }
                }
                case 2 -> {
                    int sortChoice;
                    menuSortOptions();
                    sortChoice = scanner.nextInt(); scanner.nextLine();
                    if (sortChoice == 1) {
                        anOrder.sortByTitle();
                        anOrder.printCart();
                    } else if (sortChoice == 2) {
                        anOrder.sortByCost();
                        anOrder.printCart();
                    }
                }
                case 3 -> {
                    Media m = searchMediaByNameCart(anOrder);
                    anOrder.removeMedia(m);
                }
                case 4 -> {
                    Media m = searchMediaByNameCart(anOrder);
                    if (m instanceof DigitalVideoDisc || m instanceof CompactDisc) {
                        try {
                            ((Playable) m).play();
                        } catch (PlayerException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else System.out.println("Wrong media's name or media cannot play!");
                }
                case 5 -> {
                    System.out.println("The order is created!");
                    anOrder.removeAllMedia();
                }
            }
        } while (choice4 != 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);

        CompactDisc cd1 = new CompactDisc("Lovely", "Ballad",
                "George Lucas", 87, 24.95f);
        store.addMedia(cd1);

        Book book1 = new Book("DevUp", "Soft Skill", 10.4f);
        store.addMedia(book1);

        //Create a new cart
        Cart anOrder = new Cart();

        int choice1;
        do {
            showMenu();
            choice1 = scanner.nextInt(); scanner.nextLine();
            switch (choice1) {
                case 1 -> {
                    int choice2;
                    store.showProduct();
                    do {
                        storeMenu();
                        choice2 = scanner.nextInt(); scanner.nextLine();
                        switch (choice2) {
                            case 1 -> {
                                int choice3;
                                Media m = searchMediaByName(store);
                                if (m != null) {
                                    System.out.println(m.toString());
                                    mediaDetailsMenu();
                                    choice3 = scanner.nextInt(); scanner.nextLine();
                                    if (choice3 ==1) anOrder.addMedia(m);
                                    else if (choice3 == 2) {
                                        if (m instanceof DigitalVideoDisc || m instanceof CompactDisc) {
                                            try {
                                                ((Playable) m).play();
                                            } catch (PlayerException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }
                                        else System.out.println("Wrong media's name or media cannot play!");
                                    }
                                }
                            }
                            case 2 -> {
                                Media m = searchMediaByName(store);
                                if (m != null) anOrder.addMedia(m);
                                System.out.println("The number of media in cart: " + anOrder.numberOfMedia());
                            }
                            case 3 -> {
                                Media m = searchMediaByName(store);
                                if (m instanceof DigitalVideoDisc || m instanceof CompactDisc) {
                                    try {
                                        ((Playable) m).play();
                                    } catch (PlayerException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                else System.out.println("Wrong media's name or media cannot play!");
                            }
                            case 4 -> seeCurrentCart(anOrder);
                        }
                    } while (choice2 != 0);
                }
                case 3 -> seeCurrentCart(anOrder);
            }
        } while (choice1 != 0);

    }
}
