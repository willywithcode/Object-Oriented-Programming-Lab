package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class AddItemToStoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public AddItemToStoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Add Media");
        setSize(768, 300);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookBtn = new JMenuItem("Add Book");
        smUpdateStore.add(addBookBtn);
        addBookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddBookToStoreScreen(store, cart);
            }
        });

        JMenuItem addCDBtn = new JMenuItem("Add CD");
        smUpdateStore.add(addCDBtn);
        addCDBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddCompactDiscToStoreScreen(store, cart);
            }
        });

        JMenuItem addDVDBtn = new JMenuItem("Add DVD");
        smUpdateStore.add(addDVDBtn);
        addDVDBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddDigitalVideoDiscToStoreScreen(store, cart);
            }
        });

        menu.add(smUpdateStore);

        JMenuItem viewStoreBtn = new JMenuItem("View store");
        menu.add(viewStoreBtn);
        viewStoreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StoreScreen(store, cart);
            }
        });
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    abstract JPanel createCenter();
}
