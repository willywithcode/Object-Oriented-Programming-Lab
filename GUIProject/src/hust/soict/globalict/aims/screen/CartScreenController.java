package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


public class CartScreenController {

    private Cart cart;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label totalCost;

    @FXML
    private Text play_content;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title")
        );
        colMediacategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category")
        );
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost")
        );
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        totalCost.setText(String.format("%.2f", cart.totalCost()) + " $");

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                        if(newValue!=null) updateButtonBar(newValue);
                    }
                }
        );
    }

    @FXML
    void btnRemovePressed(ActionEvent e) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        totalCost.setText(String.format("%.2f", cart.totalCost()) + " $");
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        } else btnPlay.setVisible(false);
    }

    @FXML
    void btnPlayPressed(ActionEvent e) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        String playContent = null;
        try {
            playContent = ((DigitalVideoDisc) media).play();
        } catch (PlayerException ex) {
            System.out.println(ex.getMessage());
        }

        play_content.setText(playContent);
    }
}
