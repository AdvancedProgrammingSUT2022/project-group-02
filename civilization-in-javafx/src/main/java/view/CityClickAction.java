package view;

import controller.MapController;
import controller.SettlerController;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import model.*;
import view.enums.Images;
import java.util.ArrayList;
import java.util.HashMap;

public class CityClickAction {
    private City city;
    private final Images images = Images.getInstance();
    private final AnchorPane finalRoot;
    private final ArrayList<Node> cityPagePanes = new ArrayList<>();
    private final ArrayList<Button> buttons = new ArrayList<>();
    private final HashMap<Button, Boolean> clickButtons = new HashMap();
    private final MapController mapController;

    public CityClickAction(AnchorPane finalRoot, MapController mapController) {
        this.finalRoot = finalRoot;
        this.mapController = mapController;
    }

    public void setCity(City city) {
        this.city = city;
        Product product = new Product("worker", 10);
        this.city.setCurrentProduction(product);
        this.city.setProductTurnLeft(product.getTurnCost());
    }

    public void cityClickHandler(){
        cityInfo();
        if (city.getProductTurnLeft() == 0) {
            initialiseBuyingProductPane();
        } else if (city.getProductTurnLeft() > 0){
            cityHasProduct();
        } else {
            System.out.println("city turn left is negative!");
        }
        initialiseExitCityPanel();
        initialiseBuyTile();
        buttonsAction();
    }

    private void initialiseBuyTile() {
        Button buyTile = new Button("Buy tiles");
        buyTile.setId("buy tile");
        buyTile.setAlignment(Pos.CENTER);
        buyTile.setLayoutX(615);
        buyTile.setLayoutY(750);
        buyTile.setPrefSize(250, 25);
        buyTile.getStyleClass().add("exit-city-panel");
        cityPagePanes.add(buyTile);
        clickButtons.put(buyTile, false);
        buttons.add(buyTile);
        finalRoot.getChildren().add(buyTile);
    }

    private void initialiseExitCityPanel() {
        Button exitPanel = new Button("Exit from City Panel");
        exitPanel.setId("exit panel");
        exitPanel.setAlignment(Pos.CENTER);
        exitPanel.setLayoutX(615);
        exitPanel.setLayoutY(700);
        exitPanel.setPrefSize(250, 25);
        exitPanel.getStyleClass().add("exit-city-panel");
        cityPagePanes.add(exitPanel);
        buttons.add(exitPanel);
        finalRoot.getChildren().add(exitPanel);
    }

    private void cityInfo() {
        AnchorPane cityInfo = new AnchorPane();
        cityInfo.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Style.css")));
        cityInfo.relocate(0, 0);
        cityPagePanes.add(cityInfo);
        Rectangle cityInfoBackground = new Rectangle(0, 0, 122, 200);
        cityInfoBackground.setFill(new Color(0, 0, 0, 0.8));
        cityInfo.getChildren().add(cityInfoBackground);
        foodInfo(cityInfo);
        goldInfo(cityInfo);
        scienceInfo(cityInfo);
        productionInfo(cityInfo);
        finalRoot.getChildren().add(cityInfo);
        initialiseCityInfoLines(cityInfo);
    }

    private void foodInfo(AnchorPane cityInfoPane) {
        ImageView food = new ImageView(images.food);
        food.setLayoutX(86);
        food.setLayoutY(5);
        food.setFitHeight(32);
        food.setFitWidth(32);
        Label foodLabel = new Label("food : " + city.getFood());
        Label foodPerTurnLabel = new Label("food pur turn : " + city.getFoodPerTurn());
        foodLabel.getStyleClass().add("city-info-panel");
        foodPerTurnLabel.getStyleClass().add("city-info-panel");
        foodLabel.setLayoutY(3);
        foodLabel.setLayoutX(0);
        foodLabel.setTextFill(new Color(0.66, 0.835, 0.125, 1));
        foodPerTurnLabel.setLayoutX(0);
        foodPerTurnLabel.setLayoutY(25);
        foodPerTurnLabel.setTextFill(new Color(0.66, 0.835, 0.125, 1));
        cityInfoPane.getChildren().add(food);
        cityInfoPane.getChildren().add(foodLabel);
        cityInfoPane.getChildren().add(foodPerTurnLabel);
    }

    private void goldInfo(AnchorPane cityInfoPane) {
        ImageView gold = new ImageView(images.gold);
        gold.setLayoutX(85);
        gold.setLayoutY(53);
        gold.setFitHeight(32);
        gold.setFitWidth(32);
        Label goldLabel = new Label("gold : " + city.getGold());
        Label goldPerTurnLabel = new Label("gold pur turn : " + city.getGoldPerTurn());
        goldLabel.getStyleClass().add("city-info-panel");
        goldPerTurnLabel.getStyleClass().add("city-info-panel");
        goldLabel.setLayoutY(50);
        goldLabel.setLayoutX(0);
        goldLabel.setTextFill(new Color(0.97, 0.87, 0.23, 1));
        goldPerTurnLabel.setLayoutX(0);
        goldPerTurnLabel.setLayoutY(72);
        goldPerTurnLabel.setTextFill(new Color(0.97, 0.87, 0.23, 1));
        cityInfoPane.getChildren().add(gold);
        cityInfoPane.getChildren().add(goldLabel);
        cityInfoPane.getChildren().add(goldPerTurnLabel);
    }

    private void scienceInfo(AnchorPane cityInfoPane) {
        ImageView science = new ImageView(images.science);
        science.setLayoutX(85);
        science.setLayoutY(100);
        science.setFitHeight(32);
        science.setFitWidth(32);
        Label sciencePerTurnLabel = new Label("science : " + city.getScience());
        sciencePerTurnLabel.getStyleClass().add("city-info-panel");
        sciencePerTurnLabel.setLayoutX(0);
        sciencePerTurnLabel.setLayoutY(108);
        sciencePerTurnLabel.setTextFill(new Color(0.027, 0.66, 0.93, 1));
        cityInfoPane.getChildren().add(science);
        cityInfoPane.getChildren().add(sciencePerTurnLabel);
    }

    private void productionInfo(AnchorPane cityInfoPane) {
        ImageView production = new ImageView(images.production);
        production.setLayoutX(85);
        production.setLayoutY(145);
        production.setFitHeight(32);
        production.setFitWidth(32);
        Label productionPerTurnLabel = new Label("production : " + city.getProductionPerTurn());
        productionPerTurnLabel.getStyleClass().add("city-info-panel");
        productionPerTurnLabel.setLayoutX(0);
        productionPerTurnLabel.setLayoutY(155);
        productionPerTurnLabel.setTextFill(new Color(1, 0.5, 0, 1));
        cityInfoPane.getChildren().add(production);
        cityInfoPane.getChildren().add(productionPerTurnLabel);
    }

    private void initialiseBuyingProductPane() {
        ScrollPane scrollPane = new ScrollPane();
        cityPagePanes.add(scrollPane);
        AnchorPane productAnchorPane = new AnchorPane();
        scrollPane.setContent(productAnchorPane);
        scrollPane.setPrefSize(305, 519);
        scrollPane.setLayoutX(0);
        scrollPane.setLayoutY(200);
        scrollPane.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Style.css")));
        Rectangle buyProductBackground = new Rectangle(0, 200, 300, 519);
        buyProductBackground.setFill(new Color(0, 0, 0, 0.8));
        cityPagePanes.add(buyProductBackground);
        finalRoot.getChildren().add(buyProductBackground);
        initialiseProductsOfCity(productAnchorPane);
        finalRoot.getChildren().add(scrollPane);
        initialiseBuyProductLines();
    }

    private void initialiseCityInfoLines(AnchorPane cityInfoPane) {
        Line line16 = new Line(122, 200, 122, 0);
        line16.setStyle("-fx-stroke: #fff200");
        Line line17 = new Line(121, 200, 121, 0);
        line17.setStyle("-fx-stroke: #fff200");
        Line line18 = new Line(120, 200, 120, 0);
        line18.setStyle("-fx-stroke: #fff200");
        Line line19 = new Line(119, 200, 119, 0);
        line19.setStyle("-fx-stroke: #fff200");
        Line line20 = new Line(118, 200, 118, 0);
        line20.setStyle("-fx-stroke: #fff200");
        cityInfoPane.getChildren().add(line16);
        cityInfoPane.getChildren().add(line17);
        cityInfoPane.getChildren().add(line18);
        cityInfoPane.getChildren().add(line19);
        cityInfoPane.getChildren().add(line20);
    }

    private void initialiseBuyProductLines() {
        Line line1 = new Line(0, 200, 300, 200);
        line1.setStyle("-fx-stroke: #fff200");
        Line line2 = new Line(0, 201, 300, 201);
        line2.setStyle("-fx-stroke: #fff200");
        Line line3 = new Line(0, 202, 300, 202);
        line3.setStyle("-fx-stroke: #fff200");
        Line line4 = new Line(0, 203, 300, 203);
        line4.setStyle("-fx-stroke: #fff200");
        Line line5 = new Line(0, 204, 300, 204);
        line5.setStyle("-fx-stroke: #fff200");
        Line line6 = new Line(300, 204, 300, 719);
        line6.setStyle("-fx-stroke: #fff200");
        Line line7 = new Line(299, 204, 299, 719);
        line7.setStyle("-fx-stroke: #fff200");
        Line line8 = new Line(298, 204, 298, 719);
        line8.setStyle("-fx-stroke: #fff200");
        Line line9 = new Line(297, 204, 297, 719);
        line9.setStyle("-fx-stroke: #fff200");
        Line line10 = new Line(296, 204, 296, 719);
        line10.setStyle("-fx-stroke: #fff200");
        Line line11 = new Line(0, 719, 300, 719);
        line11.setStyle("-fx-stroke: #fff200");
        Line line12 = new Line(0, 718, 300, 718);
        line12.setStyle("-fx-stroke: #fff200");
        Line line13 = new Line(0, 717, 300, 717);
        line13.setStyle("-fx-stroke: #fff200");
        Line line14 = new Line(0, 716, 300, 716);
        line14.setStyle("-fx-stroke: #fff200");
        Line line15 = new Line(0, 715, 300, 715);
        line15.setStyle("-fx-stroke: #fff200");
        finalRoot.getChildren().add(line1);
        finalRoot.getChildren().add(line2);
        finalRoot.getChildren().add(line3);
        finalRoot.getChildren().add(line4);
        finalRoot.getChildren().add(line5);
        finalRoot.getChildren().add(line6);
        finalRoot.getChildren().add(line7);
        finalRoot.getChildren().add(line8);
        finalRoot.getChildren().add(line9);
        finalRoot.getChildren().add(line10);
        finalRoot.getChildren().add(line11);
        finalRoot.getChildren().add(line12);
        finalRoot.getChildren().add(line13);
        finalRoot.getChildren().add(line14);
        finalRoot.getChildren().add(line15);
        cityPagePanes.add(line1);
        cityPagePanes.add(line2);
        cityPagePanes.add(line3);
        cityPagePanes.add(line4);
        cityPagePanes.add(line5);
        cityPagePanes.add(line6);
        cityPagePanes.add(line7);
        cityPagePanes.add(line8);
        cityPagePanes.add(line9);
        cityPagePanes.add(line10);
        cityPagePanes.add(line11);
        cityPagePanes.add(line12);
        cityPagePanes.add(line13);
        cityPagePanes.add(line14);
        cityPagePanes.add(line15);
    }

    private void initialiseProductLines(AnchorPane cityCurrentProductPane) {
        Line line1 = new Line(200, 745, 200, 867);
        line1.setStyle("-fx-stroke: #fff200");
        Line line2 = new Line(199, 745, 199, 867);
        line2.setStyle("-fx-stroke: #fff200");
        Line line3 = new Line(198, 745, 198, 867);
        line3.setStyle("-fx-stroke: #fff200");
        Line line4 = new Line(197, 745, 197, 867);
        line4.setStyle("-fx-stroke: #fff200");
        Line line5 = new Line(196, 745, 196, 867);
        line5.setStyle("-fx-stroke: #fff200");
        cityCurrentProductPane.getChildren().add(line1);
        cityCurrentProductPane.getChildren().add(line2);
        cityCurrentProductPane.getChildren().add(line3);
        cityCurrentProductPane.getChildren().add(line4);
        cityCurrentProductPane.getChildren().add(line5);
    }

    private void initialiseProduct(ImageView productView) {
        productView.setLayoutX(0);
        productView.setLayoutY(750);
        productView.setFitHeight(95);
        productView.setFitWidth(95);
    }

    private void cityHasProduct() {
        AnchorPane cityCurrentProductPane = new AnchorPane();
        cityPagePanes.add(cityCurrentProductPane);
        Rectangle productionBackground = new Rectangle(0, 745, 200, 122);
        productionBackground.setFill(new Color(0, 0, 0, 0.8));
        ImageView productView = findProduct(city.getCurrentProduction().getName());
        initialiseProduct(productView);
        Label turnLeft = new Label(city.getProductTurnLeft() + " turn");
        turnLeft.setLayoutY(800);
        turnLeft.setLayoutX(116);
        turnLeft.getStyleClass().add("product-text-turn-left");
        Label productName = new Label(city.getCurrentProduction().getName());
        productName.setLayoutY(765);
        productName.setLayoutX(116);
        productName.getStyleClass().add("product-text-name");
        Button changeProductButton = new Button("Change Product");
        changeProductButton.setLayoutY(719);
        changeProductButton.setLayoutX(40);
        changeProductButton.setPrefSize(120, 15);
        changeProductButton.setId("changeProduct");
        changeProductButton.getStyleClass().add("change-product-button");
        buttons.add(changeProductButton);
        clickButtons.put(changeProductButton, false);
        initialiseProductLines(cityCurrentProductPane);
        cityCurrentProductPane.getChildren().add(changeProductButton);
        cityCurrentProductPane.getChildren().add(productionBackground);
        cityCurrentProductPane.getChildren().add(productView);
        cityCurrentProductPane.getChildren().add(turnLeft);
        cityCurrentProductPane.getChildren().add(productName);
        finalRoot.getChildren().add(cityCurrentProductPane);
    }

    private void initialiseProductsOfCity(AnchorPane productAnchorPane) {
        int numberOfProducts = 0;
        setUnitHead(productAnchorPane);
        for (Unit possibleUnit : city.getPossibleUnits()) {
            if (city.getCurrentProduction() != null && city.getCurrentProduction().getName().equals(possibleUnit.getName()))continue;
            initialiseBuyUnitsButtons(productAnchorPane, possibleUnit, numberOfProducts);
            numberOfProducts++;
        }
        setBuildingHead(productAnchorPane, numberOfProducts);
        for (Building possibleBuilding : city.getPossibleBuildings()) {
            if (city.getCurrentProduction() != null && city.getCurrentProduction().getName().equals(possibleBuilding.getName()))continue;
            initialiseBuyBuildingsButtons(productAnchorPane, possibleBuilding, numberOfProducts);
            numberOfProducts++;
        }
    }

    private void initialiseBuyBuildingsButtons(AnchorPane productAnchorPane, Building building, int numberOfProducts) {
        ImageView buildingView = findProduct(building.getName());
        ImageView productionView = new ImageView(images.production);
        Button buildingButton = new Button(building.getName());
        Label buildingPrice = new Label(String.valueOf(building.getCost()));
        buildingPrice.setLayoutX((3 - buildingPrice.getText().length()) * 7 + 232);
        buildingPrice.setTextFill(new Color(1, 0.5, 0, 1));
        buildingPrice.setLayoutY(numberOfProducts * 50 + 115);
        buildingPrice.setStyle("-fx-font-size: 15px");
        buildingButton.setAlignment(Pos.CENTER);
        buildingView.setLayoutY(numberOfProducts * 50 + 105);
        buildingView.setLayoutX(10);
        buildingView.setFitWidth(40);
        buildingView.setFitHeight(40);
        buildingButton.setLayoutX(60);
        buildingButton.setLayoutY(numberOfProducts * 50 + 105);
        buildingButton.setPrefSize(185, 40);
        buildingButton.getStyleClass().add("buy-product-button");
        productionView.setLayoutX(255);
        productionView.setLayoutY(numberOfProducts * 50 + 115);
        productionView.setFitHeight(20);
        productionView.setFitWidth(20);
        Line line = new Line(50, numberOfProducts * 50 + 150, 245, numberOfProducts * 50 + 150);
        line.setStyle("-fx-stroke: #75a2b2");
        productAnchorPane.getChildren().add(line);
        productAnchorPane.getChildren().add(buildingView);
        productAnchorPane.getChildren().add(buildingButton);
        productAnchorPane.getChildren().add(productionView);
        productAnchorPane.getChildren().add(buildingPrice);
    }

    private void setBuildingHead(AnchorPane productAnchorPane, int numberOfProducts) {
        Line line1 = new Line(35, numberOfProducts * 50 + 70, 260, numberOfProducts * 50 + 70);
        line1.setStyle("-fx-stroke: white");
        Label buildingText = new Label("Buildings");
        buildingText.setLayoutX(35);
        buildingText.setLayoutY(numberOfProducts * 50 + 70);
        buildingText.setPrefSize(225, 27);
        buildingText.setAlignment(Pos.CENTER);
        buildingText.getStyleClass().add("buy-product-head-text");
        Line line2 = new Line(35, numberOfProducts * 50 + 97, 260, numberOfProducts * 50 + 97);
        line2.setStyle("-fx-stroke: white");
        productAnchorPane.getChildren().add(line1);
        productAnchorPane.getChildren().add(line2);
        productAnchorPane.getChildren().add(buildingText);
    }

    private void initialiseBuyUnitsButtons(AnchorPane productAnchorPane, Unit unit, int numberOfProducts) {
        ImageView unitView = findProduct(unit.getName());
        ImageView productionView = new ImageView(images.production);
        Button unitButton = new Button(unit.getName());
        Label unitPrice = new Label(String.valueOf(unit.getProductionPrice()));
        unitPrice.setLayoutX((3 - unitPrice.getText().length()) * 7 + 232);
        unitPrice.setTextFill(new Color(1, 0.5, 0, 1));
        unitPrice.setLayoutY(numberOfProducts * 50 + 60);
        unitPrice.setStyle("-fx-font-size: 15px");
        unitButton.setAlignment(Pos.CENTER);
        unitView.setLayoutY(numberOfProducts * 50 + 50);
        unitView.setLayoutX(10);
        unitView.setFitWidth(40);
        unitView.setFitHeight(40);
        unitButton.setLayoutX(60);
        unitButton.setLayoutY(numberOfProducts * 50 + 50);
        unitButton.setPrefSize(185, 40);
        unitButton.getStyleClass().add("buy-product-button");
        productionView.setLayoutX(255);
        productionView.setLayoutY(numberOfProducts * 50 + 60);
        productionView.setFitHeight(20);
        productionView.setFitWidth(20);
        Line line = new Line(50, numberOfProducts * 50 + 95, 245, numberOfProducts * 50 + 95);
        line.setStyle("-fx-stroke: #75a2b2");
        productAnchorPane.getChildren().add(line);
        productAnchorPane.getChildren().add(unitView);
        productAnchorPane.getChildren().add(unitButton);
        productAnchorPane.getChildren().add(productionView);
        productAnchorPane.getChildren().add(unitPrice);
    }

    private void setUnitHead(AnchorPane productAnchorPane) {
        Line line1 = new Line(35, 15, 260, 15);
        line1.setStyle("-fx-stroke: white");
        Label unitsText = new Label("Units");
        unitsText.setLayoutX(35);
        unitsText.setLayoutY(15);
        unitsText.setPrefSize(225, 27);
        unitsText.setAlignment(Pos.CENTER);
        unitsText.getStyleClass().add("buy-product-head-text");
        Line line2 = new Line(35, 42, 260, 42);
        line2.setStyle("-fx-stroke: white");
        productAnchorPane.getChildren().add(line1);
        productAnchorPane.getChildren().add(line2);
        productAnchorPane.getChildren().add(unitsText);
    }

    private ImageView findProduct (String productName) {
        ImageView imageView = ResearchMenu.findBuildingIcon(productName);
        if (imageView == null) imageView = ResearchMenu.findUnitIcon(productName);
        if (imageView == null) imageView = findFirstProducts(productName);
        return imageView;
    }

    private ImageView findFirstProducts (String productName) {
        return switch (productName) {
            case "warrior" -> new ImageView(images.warriorIcon);
            case "worker" -> new ImageView(images.workerIcon);
            case "settler" -> new ImageView(images.settlerIcon);
            case "scout" -> new ImageView(images.scoutIcon);
            case "Monument" -> new ImageView(images.Monument);
            default -> null;
        };
    }

    private void buttonsAction() {
        for (Button button : buttons) {
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                if (button.getId().equals("changeProduct") && !clickButtons.get(button)) {
                    initialiseBuyingProductPane();
                    clickButtons.put(button, true);
                } else if (button.getId().equals("exit panel")) {
                    for (Node cityPagePane : cityPagePanes) {
                        finalRoot.getChildren().remove(cityPagePane);
                        GameEnvironment.hashMap.replace(3, true);
                    }
                } else if (button.getId().equals("buy tile") && !clickButtons.get(button)) {
                    ArrayList<Tile> neighborOfCity = mapController.neighborOfCity(city);
                }
            });
        }
    }
}
