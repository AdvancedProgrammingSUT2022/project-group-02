package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import model.Unit;
import view.enums.Images;

import java.util.HashMap;
import java.util.Objects;

public class UnitClickAction {

    private Unit unit;
    private final AnchorPane finalRoot;
    private static Images images;
    private final HashMap<String, Button> buttons = new HashMap<>();
    private final HashMap<String, ImageView> imageViews = new HashMap<>();
    private final Button alertAndWakeButton = new Button();

    public UnitClickAction(AnchorPane finalRoot, Images images){
        this.finalRoot = finalRoot;
        UnitClickAction.images = images;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void settlerClickAction() {
        ImageView unitIconView = new ImageView(images.settlerIcon);
        ImageView infoView = new ImageView(images.unitInfoBackground);
        ImageView moreActionView = new ImageView(images.otherActionIcon);
        ImageView alertView = new ImageView(images.alertIcon);
        ImageView wakeView = new ImageView(images.wakeIcon);
        ImageView movingView = new ImageView(images.movingIcon);
        ImageView foundCityView = new ImageView(images.foundCityIcon);
        ImageView doNothingView = new ImageView(images.doNothingIcon);
        initialiseUnitInfo(infoView);
        initialiseUnitSameButtons(moreActionView, alertView, movingView, doNothingView);
        Button foundCityButton = new Button();
        initialiseFoundCity(foundCityView, foundCityButton);
        initialiseUnitSameInfo(unitIconView);
        mouseClickHandler(alertView, wakeView);
    }

    private void mouseClickHandler(ImageView alertView, ImageView wakeView) {
        buttons.forEach((key, value) -> {
            value.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
                AudioClip clickSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/sounds/click.mp3")).toExternalForm());
                clickSound.play();
            });
            value.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                switch (key) {
                    case "moreActionButton" -> {
                        if (imageViews.containsKey("workerMoreActionBackground")) {
                            finalRoot.getChildren().remove(buttons.get("deleteUnitButton"));
                            finalRoot.getChildren().remove(buttons.get("autoPlayingButton"));
                            finalRoot.getChildren().remove(imageViews.get("workerMoreActionBackground"));
                            buttons.remove("deleteUnitButton");
                            buttons.remove("autoPlayingButton");
                            imageViews.remove("workerMoreActionBackground");
                        } else initialiseMoreActionBackground();
                    }
                    case "foundCityButton" -> {}
                    case "alertAndWakeButton" -> {
                        //TODO : -GRAPHIC- SHOW SOMETHING ON UNIT TO SHOW THIS
                        //TODO : -LOGIC- WHAT HAPPENED WHEN WE CLICK THIS
                        if (value.getId().equals("alertMode")) {
                            initialiseWake(wakeView);
                        } else {
                            initialiseAlert(alertView);
                        }
                    }
                }

            });
        });
    }

    private void initialiseMoreActionBackground() {
        if (unit.getName().equals("settler") || unit.getName().equals("scout") || unit.getName().equals("worker")) {
            ImageView workerMoreActionBackground = new ImageView(images.workerMoreActionInfoBackground);
            imageViews.put("workerMoreActionBackground", workerMoreActionBackground);
            workerMoreActionBackground.setLayoutX(85);
            workerMoreActionBackground.setLayoutY(500);
            workerMoreActionBackground.setFitHeight(130);
            workerMoreActionBackground.setFitWidth(80);
            finalRoot.getChildren().add(workerMoreActionBackground);
            initialiseMoreActionButtons(false);
        } else {
            ImageView unitMoreActionBackground = new ImageView(images.unitMoreActionInfoBackground);
            imageViews.put("unitMoreActionBackground", unitMoreActionBackground);
            unitMoreActionBackground.setLayoutX(85);
            unitMoreActionBackground.setLayoutY(440);
            unitMoreActionBackground.setFitHeight(185);
            unitMoreActionBackground.setFitWidth(80);
            finalRoot.getChildren().add(unitMoreActionBackground);
            initialiseMoreActionButtons(true);
        }
    }

    private void initialiseMoreActionButtons(boolean isMilitary) {
        ImageView deleteUnitView = new ImageView(images.deleteUnitIcon);
        Button deleteUnitButton = new Button();
        deleteUnitButton.setId("deleteUnitButton");
        buttons.put("deleteUnitButton", deleteUnitButton);
        deleteUnitButton.getStyleClass().add("unit-action-buttons");
        deleteUnitButton.setGraphic(deleteUnitView);
        deleteUnitButton.setLayoutX(92);
        deleteUnitButton.setLayoutY(564);
        deleteUnitView.setFitWidth(50);
        deleteUnitView.setFitHeight(50);
        deleteUnitButton.setPrefSize(50, 50);
        finalRoot.getChildren().add(deleteUnitButton);

        ImageView autoPlatingView = new ImageView(images.autoPlayingIcon);
        Button autoPlayingButton = new Button();
        autoPlayingButton.setId("autoPlayingButton");
        buttons.put("autoPlayingButton", autoPlayingButton);
        autoPlayingButton.getStyleClass().add("unit-action-buttons");
        autoPlayingButton.setGraphic(autoPlatingView);
        autoPlayingButton.setLayoutX(92);
        autoPlayingButton.setLayoutY(508);
        autoPlatingView.setFitWidth(50);
        autoPlatingView.setFitHeight(50);
        autoPlayingButton.setPrefSize(50, 50);
        finalRoot.getChildren().add(autoPlayingButton);
        if (isMilitary){
            ImageView fortifyView = new ImageView(images.fortifyIcon);
            Button fortifyButton = new Button();
            fortifyButton.setId("fortifyButton");
            buttons.put("fortifyButton", fortifyButton);
            fortifyButton.getStyleClass().add("unit-action-buttons");
            fortifyButton.setGraphic(fortifyView);
            fortifyButton.setLayoutX(86);
            fortifyButton.setLayoutY(451);
            fortifyView.setFitWidth(56);
            fortifyView.setFitHeight(56);
            fortifyButton.setPrefSize(56, 56);
            finalRoot.getChildren().add(fortifyButton);
        }
    }

    private void initialiseUnitSameButtons(ImageView moreActionView, ImageView alertView, ImageView movingView,
                                           ImageView doNothingView){
        initialiseMoreAction(moreActionView);
        initialiseAlert(alertView);
        buttons.put("alertAndWakeButton" , alertAndWakeButton);
        finalRoot.getChildren().add(alertAndWakeButton);
        initialiseDoNothing(doNothingView);
        initialiseMoving(movingView);
    }

    private void initialiseMoreAction(ImageView moreActionView){
        Button moreActionButton = new Button();
        moreActionButton.setId("moreActionButton");
        buttons.put("moreActionButton", moreActionButton);
        moreActionButton.getStyleClass().add("unit-action-buttons");
        moreActionButton.setGraphic(moreActionView);
        moreActionView.setFitHeight(50);
        moreActionView.setFitWidth(50);
        moreActionButton.setLayoutX(3);
        moreActionButton.setLayoutY(564);
        moreActionButton.setPrefSize(50, 50);
        finalRoot.getChildren().add(moreActionButton);
    }

    private void initialiseAlert(ImageView alertView) {
        alertAndWakeButton.setId("alertMode");
        alertAndWakeButton.getStyleClass().add("unit-action-buttons");
        alertAndWakeButton.setGraphic(alertView);
        alertView.setFitHeight(50);
        alertView.setFitWidth(50);
        alertAndWakeButton.setLayoutX(3);
        alertAndWakeButton.setLayoutY(509);
        alertAndWakeButton.setPrefSize(50, 50);
    }

    private void initialiseWake(ImageView WakeView) {
        alertAndWakeButton.setId("wakeMode");
        alertAndWakeButton.getStyleClass().add("unit-action-buttons");
        alertAndWakeButton.setGraphic(WakeView);
        WakeView.setFitHeight(50);
        WakeView.setFitWidth(50);
        alertAndWakeButton.setLayoutX(3);
        alertAndWakeButton.setLayoutY(509);
        alertAndWakeButton.setPrefSize(50, 50);
    }

    private void initialiseDoNothing(ImageView doNothingView) {
        Button doNothingButton = new Button();
        doNothingButton.setId("doNothingButton");
        buttons.put("doNothingButton", doNothingButton);
        doNothingButton.getStyleClass().add("unit-action-buttons");
        doNothingButton.setGraphic(doNothingView);
        doNothingView.setFitHeight(50);
        doNothingView.setFitWidth(50);
        doNothingButton.setLayoutX(3);
        doNothingButton.setLayoutY(454);
        doNothingButton.setPrefSize(50, 50);
        finalRoot.getChildren().add(doNothingButton);
    }

    private void initialiseMoving(ImageView movingView) {
        Button movingButton = new Button();
        movingButton.setId("movingButton");
        buttons.put("movingButton", movingButton);
        movingButton.getStyleClass().add("unit-action-buttons");
        movingButton.setGraphic(movingView);
        movingView.setFitHeight(52);
        movingView.setFitWidth(52);
        movingButton.setLayoutX(2);
        movingButton.setLayoutY(397);
        movingButton.setPrefSize(52, 52);
        finalRoot.getChildren().add(movingButton);
    }

    private void initialiseFoundCity(ImageView foundCityView, Button foundCityButton) {
        foundCityButton.setId("foundCityButton");
        buttons.put("foundCityButton", foundCityButton);
        foundCityButton.getStyleClass().add("unit-action-buttons");
        foundCityButton.setGraphic(foundCityView);
        foundCityView.setFitHeight(51);
        foundCityView.setFitWidth(51);
        foundCityButton.setLayoutX(3);
        foundCityButton.setLayoutY(344);
        foundCityButton.setPrefSize(51, 51);
        finalRoot.getChildren().add(foundCityButton);
    }

    private void initialiseUnitInfo(ImageView imageView) {
        imageView.setLayoutX(0);
        imageView.setLayoutY(335);
        imageView.setFitHeight(530);
        imageView.setFitWidth(530);
        finalRoot.getChildren().add(imageView);
    }

    private void initialiseUnitSameInfo(ImageView unitIconView) {
        initialiseNameLabel();
        initialiseUnitIcon(unitIconView);
        initialiseUnitMovement();
    }

    private void initialiseNameLabel() {
        Label label = new Label(unit.getName().toUpperCase());
        label.setLayoutY(639);
        label.setLayoutX(300 - 17 * unit.getName().length());
        label.getStyleClass().add("unit-info-name");
        finalRoot.getChildren().add(label);
    }

    private void initialiseUnitIcon(ImageView unitIconView) {
        ImageView goldenRing = new ImageView(images.goldenRing);
        goldenRing.setLayoutX(-21);
        goldenRing.setLayoutY(674);
        goldenRing.setFitWidth(195);
        goldenRing.setFitHeight(197);
        unitIconView.setLayoutX(10);
        unitIconView.setLayoutY(700);
        unitIconView.setFitWidth(140);
        unitIconView.setFitHeight(140);
        finalRoot.getChildren().add(goldenRing);
        finalRoot.getChildren().add(unitIconView);
    }

    private void initialiseUnitMovement() {
        Label label = new Label("MOVEMENT  :  " + unit.getMP() + "/" + unit.getLastingMP());
        label.setLayoutX(185);
        label.setLayoutY(700);
        label.getStyleClass().add("unit-info-movement");
        finalRoot.getChildren().add(label);
    }
}
