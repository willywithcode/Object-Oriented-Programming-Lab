package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private Store store;
    private Cart cart;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        this.store = store;
        this.cart = cart;
    }

    @Override
    JPanel createCenter() {
        JTextField dvdName;
        JTextField dvdCategory;
        JTextField dvdCost;

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 2));

        center.add(new Label("Enter DVD's name"));

        dvdName = new JTextField(10);
        center.add(dvdName);

        center.add(new Label("Enter DVD's category"));

        dvdCategory = new JTextField(10);
        center.add(dvdCategory);

        center.add(new Label("Enter DVD's cost"));

        dvdCost = new JTextField(10);
        center.add(dvdCost);

        JButton submitBtn = new JButton("Add dvd");
        center.add(submitBtn);
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dvdCategory.getText().length() >= 1) {
                    float cost = Float.parseFloat(dvdCost.getText());
                    DigitalVideoDisc newDVD = new DigitalVideoDisc(dvdName.getText(), dvdCategory.getText(), cost);
                    store.addMedia(newDVD);
                } else {
                    store.addMedia(new DigitalVideoDisc(dvdName.getText()));
                }
            }
        });

        return center;
    }
}
