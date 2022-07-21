package view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.City;
import view.enums.Images;

import java.util.HashMap;

public class CityClickAction {
    private City city;
    private static Images images;
    private final AnchorPane finalRoot;
    private final HashMap<String, Button> buttons = new HashMap<>();
    private final HashMap<String, ImageView> imageViews = new HashMap<>();

    public CityClickAction(AnchorPane finalRoot, Images images) {
        CityClickAction.images = images;
        this.finalRoot = finalRoot;
    }

    public void setCity(City city) {
        this.city = city;
    }

    private void cityClickHandler(){
        ImageView food = new ImageView(images.food);
        ImageView gold = new ImageView(images.gold);
        ImageView science = new ImageView(images.science);
        ImageView production = new ImageView(images.production);
        Rectangle cityInfoBackground = new Rectangle(0, 0, 122, 200);
        cityInfoBackground.setFill(new Color(0, 0, 0, 0.6));
        finalRoot.getChildren().add(cityInfoBackground);
    }
}
