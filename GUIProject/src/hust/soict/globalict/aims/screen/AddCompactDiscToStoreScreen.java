package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private Store store;
    private Cart cart;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        this.store = store;
        this.cart = cart;
    }

    @Override
    JPanel createCenter() {
        JTextField cdName;
        JTextField cdCategory;
        JTextField cdCost;

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 2));

        center.add(new Label("Enter CD's name"));

        cdName = new JTextField(10);
        center.add(cdName);

        center.add(new Label("Enter CD's category"));

        cdCategory = new JTextField(10);
        center.add(cdCategory);

        center.add(new Label("Enter CD's cost"));

        cdCost = new JTextField(10);
        center.add(cdCost);

        JButton submitBtn = new JButton("Add CD");
        center.add(submitBtn);
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cdCategory.getText().length() >= 1) {
                    float cost = Float.parseFloat(cdCost.getText());
                    CompactDisc newDVD = new CompactDisc(cdName.getText(), cdCategory.getText(), cost);
                    store.addMedia(newDVD);
                } else {
                    store.addMedia(new DigitalVideoDisc(cdName.getText()));
                }
            }
        });

        return center;
    }
}
