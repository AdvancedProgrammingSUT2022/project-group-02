package view;

import controller.GameController;
import controller.MapController;
import controller.TechController;
import controller.UsersController;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.*;
import view.enums.Images;
import java.util.ArrayList;
import java.util.HashMap;

public class GameEnvironment {
    private UsersController users;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private AnchorPane root;
    private AnchorPane finalRoot;
    private final Images images = Images.getInstance();
    private User user;
    public User getUser(){
        return user;
    }
    private Maps map;
    private ArrayList<User> players;
    public static final HashMap<ImageView, Object> imageViewObjects = new HashMap<>();
    public static final ArrayList<ImageView> imageViews =  new ArrayList<>();
    private MapController mapController;
    private GameController gameController;
    public static ArrayList<ImageView> topBarImageViews;
    public static ArrayList<Label> topBarLabels;
    public static Rectangle topBarBackground;
    public static final HashMap<Integer, Boolean> hashMap = new HashMap<>();
    private int playerNumber;
    private ImageView nextTurnView;
    private AnchorPane settingPane;
    private final AnchorPane diplomacyPane = new AnchorPane();
    private User tradeUser;
    public boolean stop = false;
    String unhappinessValueString;
    String happinessValueString;
    String goldValueString;
    String scienceValueString;
    String foodValueString;

    Label goldValue = new Label();
    Label scienceValue = new Label();
    Label foodValue = new Label();
    Label unhappinessValue = new Label();
    Label happinessValue = new Label();

    private ClickRunnable clickRunnable;
    private TurnRunnable turnRunnable;

    private Thread clickThread;
    private Thread nextTurnThread;



    public GameEnvironment(MediaPlayer mediaPlayer, Stage stage, UsersController users, User user, ArrayList<User> players){
        this.users = users;
        this.mediaPlayer = mediaPlayer;
        this.stage = stage;
        this.user = user;
        map = users.readFromJsonMap();
        finalRoot = new AnchorPane();
        this.players = players;
        mapController = MapController.getInstance(map);
        gameController = GameController.getInstance(players, map);
        playerNumber = 0;
    }

    public GameEnvironment(){}

    public void run(){
        root = new AnchorPane();
        finalRoot.getChildren().add(root);
        finalRoot.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Style.css")));
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        Scene scene = new Scene(finalRoot, 10, 5);
        scene.setRoot(finalRoot);
        stage.setScene(scene);
        root.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Style.css")));
        stage.setMaximized(true);
        stage.setFullScreen(true);
        mapController.firstSetOfSettlers(players);
        mapController.firstRuin();
        gameController.assignNeighbor(mapController);
        MapMaker.setPrice(map);
        showAllInfo();
        showSetting();
        createMap();
        clickRunnable = new ClickRunnable(this);
        clickThread = new Thread(clickRunnable);
        clickThread.start();
    }

    private void showSetting() {
        ImageView imageView = new ImageView(images.setting);
        Button button = new Button();
        button.setGraphic(imageView);
        button.setLayoutX(1468);
        button.setLayoutY(50);
        button.setPrefSize(60, 60);
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);
        button.getStyleClass().add("setting-button");
        finalRoot.getChildren().add(button);
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (finalRoot.getChildren().contains(settingPane)) {
                finalRoot.getChildren().remove(settingPane);
                settingPane.getChildren().clear();
            }
            else showSettingButtons();
        });
    }

    private void showSettingButtons() {
        settingPane = new AnchorPane();
        Button exit = new Button("Exit");
        exit.setAlignment(Pos.CENTER);
        exit.setLayoutX(1390);
        exit.setLayoutY(122);
        exit.getStyleClass().add("setting-button");
        exit.setPrefSize(148, 40);
        settingPane.getChildren().add(exit);

        Button unitPanel = new Button("Unit Panel");
        unitPanel.setAlignment(Pos.CENTER);
        unitPanel.setLayoutX(1390);
        unitPanel.setLayoutY(167);
        unitPanel.getStyleClass().add("setting-button");
        unitPanel.setPrefSize(148, 40);
        settingPane.getChildren().add(unitPanel);

        Button citiesPanel = new Button("City panel");
        citiesPanel.setAlignment(Pos.CENTER);
        citiesPanel.setLayoutX(1390);
        citiesPanel.setLayoutY(212);
        citiesPanel.getStyleClass().add("setting-button");
        citiesPanel.setPrefSize(148, 40);
        settingPane.getChildren().add(citiesPanel);

        Button economicPanel = new Button("Economic OverView");
        economicPanel.setAlignment(Pos.CENTER);
        economicPanel.setLayoutX(1390);
        economicPanel.setLayoutY(257);
        economicPanel.getStyleClass().add("setting-button");
        economicPanel.setPrefSize(148, 40);
        settingPane.getChildren().add(economicPanel);

        Button diplomacyPanel = new Button("Diplomacy");
        diplomacyPanel.setAlignment(Pos.CENTER);
        diplomacyPanel.setLayoutX(1390);
        diplomacyPanel.setLayoutY(302);
        diplomacyPanel.getStyleClass().add("diplomacy-button");
        diplomacyPanel.setPrefSize(148, 40);
        settingPane.getChildren().add(diplomacyPanel);

        Button stopGame = new Button("Stop");
        stopGame.setAlignment(Pos.CENTER);
        stopGame.setLayoutX(1390);
        stopGame.setLayoutY(347);
        stopGame.getStyleClass().add("setting-button");
        stopGame.setPrefSize(148, 40);
        settingPane.getChildren().add(stopGame);

        Button continueGame = new Button("Continue");
        continueGame.setAlignment(Pos.CENTER);
        continueGame.setLayoutX(1390);
        continueGame.setLayoutY(392);
        continueGame.getStyleClass().add("setting-button");
        continueGame.setPrefSize(148, 40);
        settingPane.getChildren().add(continueGame);

        Button cheat = new Button("Cheat Panel");
        cheat.setAlignment(Pos.CENTER);
        cheat.setLayoutX(1390);
        cheat.setLayoutY(437);
        cheat.getStyleClass().add("setting-button");
        cheat.setPrefSize(148, 40);
        settingPane.getChildren().add(cheat);

        finalRoot.getChildren().add(settingPane);
        settingAction(exit, unitPanel, citiesPanel, economicPanel, diplomacyPanel, stopGame, continueGame, cheat);
    }

    private void settingAction(Button exit, Button unitPanel, Button citiesPanel, Button economicPanel,
                               Button diplomacyPanel, Button stopGame, Button continueGame, Button cheat) {
        AnchorPane unitPane = new AnchorPane();
        AnchorPane citiesPane = new AnchorPane();
        AnchorPane economicPane = new AnchorPane();
        AnchorPane cheatPane = new AnchorPane();
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            clickThread.stop();
            nextTurnThread.stop();
            new RegisterMenu(mediaPlayer, stage, Main.scene).run();
        });

        unitPanel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (settingPane.getChildren().contains(unitPane)) {
                settingPane.getChildren().remove(unitPane);
                unitPane.getChildren().clear();
            } else {
                settingPane.getChildren().add(unitPane);
                Rectangle backGround = new Rectangle(600, 100, 400, 483);
                backGround.setFill(new Color(0, 0, 0, 0.88));
                unitPane.getChildren().add(backGround);
                int numberOfUnit = 0;
                for (Unit unit : user.getUnits()) {
                    ImageView unitView = ResearchMenu.findUnitIcon(unit.getName());
                    if (unitView == null) unitView = fineUnitView(unit.getName());
                    unitView.setLayoutX(610);
                    unitView.setLayoutY(110 + numberOfUnit * 65);
                    unitView.setFitHeight(55);
                    unitView.setFitWidth(55);

                    Label name = new Label(unit.getName() + " -> unit MP : " + unit.getMP() + " -> unit CS : " + unit.getCombatStrength());
                    name.setLayoutX(670);
                    name.setLayoutY(125 + numberOfUnit * 65);
                    name.setAlignment(Pos.CENTER);
                    name.setStyle("-fx-text-fill: #ff0090");
                    unitPane.getChildren().add(name);
                    unitPane.getChildren().add(unitView);
                    numberOfUnit++;
                }
            }
        });

        economicPanel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (settingPane.getChildren().contains(economicPane)) {
                settingPane.getChildren().remove(economicPane);
                economicPane.getChildren().clear();
            } else {
                settingPane.getChildren().add(economicPane);
                Rectangle backGround = new Rectangle(600, 100, 400, 483);
                backGround.setFill(new Color(0, 0, 0, 0.88));
                economicPane.getChildren().add(backGround);

                Label gold = new Label("User Gold : " + user.getGold() + " --------- " + "User Gold Pur Turn : " + user.getGoldPerTurn()
                        + "\n..............\n..............\n..............\n");
                gold.setLayoutX(652);
                gold.setLayoutY(110);
                gold.setAlignment(Pos.CENTER);
                gold.setStyle("-fx-text-fill: #ff0090");
                economicPane.getChildren().add(gold);
                Label technology = new Label("User technology number : " + user.getTechnologies().size()
                        + "\n..............\n..............\n..............");
                technology.setLayoutX(652);
                technology.setLayoutY(210);
                technology.setAlignment(Pos.CENTER);
                technology.setStyle("-fx-text-fill: #ff0090");
                economicPane.getChildren().add(technology);

                Label science = new Label("User City number : " + user.getCities().size()
                        + "\n..............\n..............\n..............");
                science.setLayoutX(652);
                science.setLayoutY(310);
                science.setAlignment(Pos.CENTER);
                science.setStyle("-fx-text-fill: #ff0090");
                economicPane.getChildren().add(science);
            }
        });

        citiesPanel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (settingPane.getChildren().contains(citiesPane)) {
                citiesPane.getChildren().clear();
                settingPane.getChildren().remove(citiesPane);
            } else {
                settingPane.getChildren().add(citiesPane);
                Rectangle backGround = new Rectangle(600, 100, 400, 483);
                backGround.setFill(new Color(0, 0, 0, 0.88));
                citiesPane.getChildren().add(backGround);
                int numberOfCity = 0;
                for (City city : user.getCities()) {
                    ImageView cityView = new ImageView(images.city);
                    cityView.setLayoutX(610);
                    cityView.setLayoutY(110 + numberOfCity * 65);
                    cityView.setFitHeight(55);
                    cityView.setFitWidth(55);

                    Label name = new Label( city.getName() + " -> city HP : " + city.getHP() + " -> city strength : " + city.getDefence());
                    name.setLayoutX(670);
                    name.setLayoutY(125 + numberOfCity * 65);
                    name.setAlignment(Pos.CENTER);
                    name.setStyle("-fx-text-fill: #ff0090");
                    citiesPane.getChildren().add(name);
                    citiesPane.getChildren().add(cityView);
                    numberOfCity++;
                }
            }
        });

        diplomacyPanel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (settingPane.getChildren().contains(diplomacyPane)) {
                diplomacyPane.getChildren().clear();
                settingPane.getChildren().remove(diplomacyPane);
            }
            else diplomacyPanel();
        });

        stopGame.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            stop = true;
            clickRunnable.stop(true);
            clickThread.resume();
        });
        continueGame.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            stop = false;
            clickRunnable.stop(false);
            clickThread.resume();
        });

        cheat.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (settingPane.getChildren().contains(cheatPane)) {
                cheatPane.getChildren().clear();
                settingPane.getChildren().remove(cheatPane);
            }
            else {
                settingPane.getChildren().add(cheatPane);
                Rectangle background = new Rectangle(1100, 80, 250, 110);
                background.setFill(new Color(0.2, 0.63, 0.59, 1));
                cheatPane.getChildren().add(background);
                TextField cheatField = new TextField();
                cheatField.setLayoutX(1110);
                cheatField.setLayoutY(150);
                cheatField.setPrefHeight(32);
                cheatField.setPrefWidth(230);
                cheatField.getStyleClass().add("search-friend-text-field");
                cheatPane.getChildren().add(cheatField);
                Button cheatButton = new Button("Enter");
                cheatButton.setLayoutX(1165);
                cheatButton.setLayoutY(100);
                cheatButton.setAlignment(Pos.CENTER);
                cheatButton.getStyleClass().add("cheat-text");
                cheatButton.setPrefSize(125, 30);
                cheatPane.getChildren().add(cheatButton);
                cheatButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    cheatHandler(cheatField);
                });
            }
        });
    }

    private void cheatHandler(TextField cheatField) {
        if (cheatField.getText().equals("increase gold")) {
            user.setGold(user.getGold() + 50);
            topBarInfoUpdate();
        }
    }

    private void diplomacyPanel(){
        Rectangle backGround = new Rectangle(600, 100, 400, 483);
        backGround.setFill(new Color(0, 0, 0, 0.88));
        diplomacyPane.getChildren().add(backGround);
        initialiseUsersForDiplomacy();
        settingPane.getChildren().add(diplomacyPane);
    }

    private void initialiseUsersForDiplomacy(){
        int numberOfPlayers = 0;
        for (User player : players) {
            if (player != user) {
                ImageView imageView = new ImageView(new Image(String.valueOf(getClass().getResource(player.getAvatarUrl()))));
                imageView.setLayoutX(620);
                imageView.setLayoutY(120 + numberOfPlayers * 100);
                imageView.setFitWidth(80);
                imageView.setFitHeight(80);
                diplomacyPane.getChildren().add(imageView);
                Button name = new Button("user name : " + player.getUsername());
                name.setLayoutX(623);
                name.setLayoutY(120 + numberOfPlayers * 100);
                name.setPrefSize(360, 80);
                name.setAlignment(Pos.CENTER);
                name.getStyleClass().add("diplomacy-user-name");
                diplomacyPane.getChildren().add(name);
                Line line1 = new Line(635, 205 + numberOfPlayers * 100, 965, 205 + numberOfPlayers * 100);
                line1.setStyle("-fx-stroke: white");
                diplomacyPane.getChildren().add(line1);
                Line line2 = new Line(635, 210 + numberOfPlayers * 100, 965, 210 + numberOfPlayers * 100);
                line2.setStyle("-fx-stroke: white");
                diplomacyPane.getChildren().add(line2);
                name.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                    tradeUser = player;
                    diplomacyPane.getChildren().clear();
                    tradePanel();
                });
                numberOfPlayers++;
            }
        }
    }

    private void initialisePeace() {
        ImageView peace = new ImageView(peaceFinder());
        Button peaceButton = new Button();
        peaceButton.setGraphic(peace);
        peaceButton.setLayoutX(585);
        peaceButton.setLayoutY(125);
        peaceButton.setPrefSize(100, 100);
        peace.setFitWidth(100);
        peace.setFitHeight(100);
        diplomacyPane.getChildren().add(peaceButton);

        peaceButton.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            peaceButton.setEffect(new DropShadow());
        });
        peaceButton.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            peaceButton.setEffect(null);
        });
        peaceButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            ImageView peace1 = new ImageView(images.peace);
            ImageView peace2 = new ImageView(images.noPeace);
            Button peace1Button = new Button();
            Button peace2Button = new Button();

            peace1Button.setGraphic(peace1);
            peace1Button.setLayoutX(1062);
            peace1Button.setLayoutY(128);
            peace1Button.setPrefSize(70, 70);
            peace1.setFitHeight(70);
            peace1.setFitWidth(70);

            peace2Button.setGraphic(peace2);
            peace2Button.setLayoutX(985);
            peace2Button.setLayoutY(120);
            peace2Button.setPrefSize(80, 90);
            peace2.setFitHeight(80);
            peace2.setFitWidth(90);

            peace1Button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                if (!user.getFriends().contains(tradeUser))user.addFriend(tradeUser);
                if (!tradeUser.getFriends().contains(user))tradeUser.addFriend(user);
                user.getEnemies().remove(tradeUser);
                tradeUser.getEnemies().remove(user);
                peace.setImage(peaceFinder());
                diplomacyPane.getChildren().remove(peaceButton);
                diplomacyPane.getChildren().remove(peace1Button);
                diplomacyPane.getChildren().remove(peace2Button);
                diplomacyPane.getChildren().add(peaceButton);
            });
            peace2Button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                if (!user.getEnemies().contains(tradeUser))user.addEnemy(tradeUser);
                if (!tradeUser.getEnemies().contains(user))tradeUser.addEnemy(user);
                user.getFriends().remove(tradeUser);
                tradeUser.getFriends().remove(user);
                peace.setImage(peaceFinder());
                diplomacyPane.getChildren().remove(peaceButton);
                diplomacyPane.getChildren().remove(peace1Button);
                diplomacyPane.getChildren().remove(peace2Button);
                diplomacyPane.getChildren().add(peaceButton);
            });

            diplomacyPane.getChildren().add(peace1Button);
            diplomacyPane.getChildren().add(peace2Button);
        });
    }

    private void tradePanel() {
        showAvatar();
        Label label = new Label("choose what you want to get from " + tradeUser.getUsername() + " : ");
        label.setAlignment(Pos.CENTER);
        label.setLayoutX(305);
        label.setLayoutY(250);
        label.getStyleClass().add("trade-notes");
        diplomacyPane.getChildren().add(label);
        Label label2 = new Label("choose what you want to give to " + tradeUser.getUsername() + " : ");
        label2.setAlignment(Pos.CENTER);
        label2.setLayoutX(745);
        label2.setLayoutY(250);
        label2.getStyleClass().add("trade-notes");
        diplomacyPane.getChildren().add(label2);
        goldTrade();
        resourceTrade();
        borderTrade();
        chatBox();
        tradeButton();
    }

    public void tradeButton() {
        Button button = new Button("Confirm");
        button.setLayoutX(680);
        button.setLayoutY(680);
        button.setPrefSize(80, 30);
        button.setAlignment(Pos.CENTER);
        button.getStyleClass().add("trade-button");
        Label label = new Label();
        label.setLayoutX(760);
        label.setLayoutY(500);
        label.setAlignment(Pos.CENTER);
        label.getStyleClass().add("register-menu-notice-Style");
        diplomacyPane.getChildren().add(label);
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            for (Node child : diplomacyPane.getChildren()) {
                if (child.getId() == null)continue;
                if (child.getId().equals("goldTextField")) {
                    if (Integer.parseInt(((TextField) child).getText()) > user.getGold()) {
                        label.setText("Not enough money! you are poor HaHaHa!");
                        break;
                    }

                }
                boolean isValid = false;
                if (child.getId().equals("resourceTextField")) {
                    for (Resource foundResource : user.getFoundResources()) {
                        if (foundResource.getName().equals(((TextField) child).getText())) {
                            isValid = true;
                            break;
                        }
                    }
                    if (!isValid) label.setText("you don't have that resource! go and die!\n\t\t    HaHaHa!");
                }
                if (isValid) label.setText("ok! we sent your demand.....");
            }
        });
        diplomacyPane.getChildren().add(button);
    }

    private void goldTrade() {
        ImageView gold1 = new ImageView(images.gold);
        gold1.setLayoutX(305);
        gold1.setLayoutY(290);
        gold1.setFitWidth(45);
        gold1.setFitHeight(45);
        diplomacyPane.getChildren().add(gold1);
        TextField goldTextField1 = new TextField();
        goldTextField1.setLayoutX(360);
        goldTextField1.setLayoutY(295);
        goldTextField1.setPrefWidth(175);
        goldTextField1.setPrefHeight(30);
        goldTextField1.setAlignment(Pos.CENTER);
        goldTextField1.getStyleClass().add("trade-text-field");
        diplomacyPane.getChildren().add(goldTextField1);

        ImageView gold2 = new ImageView(images.gold);
        gold2.setLayoutX(745);
        gold2.setLayoutY(290);
        gold2.setFitWidth(45);
        gold2.setFitHeight(45);
        diplomacyPane.getChildren().add(gold2);
        TextField goldTextField2 = new TextField();
        goldTextField2.setLayoutX(800);
        goldTextField2.setLayoutY(295);
        goldTextField2.setPrefWidth(175);
        goldTextField2.setPrefHeight(30);
        goldTextField2.setAlignment(Pos.CENTER);
        goldTextField2.getStyleClass().add("trade-text-field");
        goldTextField2.setId("goldTextField");
        diplomacyPane.getChildren().add(goldTextField2);
    }

    private void resourceTrade() {
        ImageView resource = new ImageView(images.resourceIcon);
        resource.setLayoutX(305);
        resource.setLayoutY(350);
        resource.setFitHeight(45);
        resource.setFitWidth(45);
        diplomacyPane.getChildren().add(resource);
        TextField resourceTextField = new TextField();
        resourceTextField.setLayoutX(360);
        resourceTextField.setLayoutY(355);
        resourceTextField.setPrefWidth(175);
        resourceTextField.setPrefHeight(30);
        resourceTextField.setAlignment(Pos.CENTER);
        resourceTextField.getStyleClass().add("trade-text-field");
        diplomacyPane.getChildren().add(resourceTextField);

        ImageView resource2 = new ImageView(images.resourceIcon);
        resource2.setLayoutX(745);
        resource2.setLayoutY(350);
        resource2.setFitHeight(45);
        resource2.setFitWidth(45);
        diplomacyPane.getChildren().add(resource2);
        TextField resourceTextField2 = new TextField();
        resourceTextField2.setLayoutX(800);
        resourceTextField2.setLayoutY(355);
        resourceTextField2.setPrefWidth(175);
        resourceTextField2.setPrefHeight(30);
        resourceTextField2.setAlignment(Pos.CENTER);
        resourceTextField2.getStyleClass().add("trade-text-field");
        resourceTextField2.setId("resourceTextField");
        diplomacyPane.getChildren().add(resourceTextField2);
    }

    private void borderTrade(){
        Label label1 = new Label("Open the border ?");
        label1.setLayoutX(360);
        label1.setLayoutY(405);
        label1.getStyleClass().add("trade-border");
        diplomacyPane.getChildren().add(label1);
        Button yes1 = new Button("YES");
        yes1.setLayoutX(550);
        yes1.setLayoutY(405);
        yes1.setPrefSize(55, 30);
        yes1.getStyleClass().add("trade-text-field");
        diplomacyPane.getChildren().add(yes1);
        Button no1 = new Button("NO");
        no1.setLayoutX(610);
        no1.setLayoutY(405);
        no1.setPrefSize(55, 30);
        no1.getStyleClass().add("trade-text-field");
        diplomacyPane.getChildren().add(no1);
        yes1.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            yes1.setPrefSize(48, 23);
            yes1.setEffect(new DropShadow());
        });
        yes1.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            yes1.setPrefSize(55, 30);
            yes1.setEffect(null);
        });
        no1.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            no1.setPrefSize(48, 23);
            no1.setEffect(new DropShadow());
        });
        no1.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            no1.setPrefSize(55, 30);
            no1.setEffect(null);
        });

        Label label2 = new Label("Open the border ?");
        label2.setLayoutX(800);
        label2.setLayoutY(405);
        label2.getStyleClass().add("trade-border");
        diplomacyPane.getChildren().add(label2);
        Button yes2 = new Button("YES");
        yes2.setLayoutX(990);
        yes2.setLayoutY(405);
        yes2.setPrefSize(55, 30);
        yes2.getStyleClass().add("trade-text-field");
        diplomacyPane.getChildren().add(yes2);
        Button no2 = new Button("NO");
        no2.setLayoutX(1050);
        no2.setLayoutY(405);
        no2.setPrefSize(55, 30);
        no2.getStyleClass().add("trade-text-field");
        diplomacyPane.getChildren().add(no2);
        yes2.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            yes2.setPrefSize(48, 23);
            yes2.setEffect(new DropShadow());
        });
        yes2.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            yes2.setPrefSize(55, 30);
            yes2.setEffect(null);
        });
        no2.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            no2.setPrefSize(48, 23);
            no2.setEffect(new DropShadow());
        });
        no2.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            no2.setPrefSize(55, 30);
            no2.setEffect(null);
        });

    }

    private void chatBox() {
        TextField chatField1 = new TextField();
        ImageView chatBox1 = new ImageView(images.chatBox);
        chatBox1.setLayoutX(251);
        chatBox1.setLayoutY(420);
        chatBox1.setFitWidth(480);
        chatBox1.setFitHeight(310);
        diplomacyPane.getChildren().add(chatBox1);
        chatField1.setLayoutX(360);
        chatField1.setLayoutY(497);
        chatField1.setPrefWidth(260);
        chatField1.setPrefHeight(120);
        chatField1.getStyleClass().add("trade-chat");
        diplomacyPane.getChildren().add(chatField1);
    }

    private void showAvatar() {
        Rectangle background1 = new Rectangle(300, 120, 400, 550);
        background1.setFill(new Color(0.14, 0.53, 0.87, 0.88));
        Rectangle background2 = new Rectangle(740, 120, 400, 550);
        background2.setFill(new Color(0.14, 0.53, 0.87, 0.88));
        diplomacyPane.getChildren().add(background1);
        diplomacyPane.getChildren().add(background2);
        ImageView opponentView = new ImageView(new Image(String.valueOf(getClass().getResource(tradeUser.getAvatarUrl()))));
        opponentView.setLayoutX(310);
        opponentView.setLayoutY(130);
        opponentView.setFitHeight(65);
        opponentView.setFitWidth(65);
        ImageView yourView = new ImageView(new Image(String.valueOf(getClass().getResource(user.getAvatarUrl()))));
        yourView.setLayoutX(750);
        yourView.setLayoutY(130);
        yourView.setFitHeight(65);
        yourView.setFitWidth(65);
        initialisePeace();
        diplomacyPane.getChildren().add(opponentView);
        diplomacyPane.getChildren().add(yourView);
    }

    private Image peaceFinder() {
        if (user.getFriends().contains(tradeUser)) return images.peace;
        else if (user.getEnemies().contains(tradeUser)) return images.noPeace;
        else return images.nothingInPeace;
    }

    private ImageView fineUnitView(String unitName){
        return switch (unitName) {
            case "warrior" -> new ImageView(images.warriorIcon);
            case "worker" -> new ImageView(images.workerIcon);
            case "settler" -> new ImageView(images.settlerIcon);
            case "scout" -> new ImageView(images.scoutIcon);
            case "Monument" -> new ImageView(images.Monument);
            default -> null;
        };
    }

    private void showAllInfo() {
        ImageView science = new ImageView(images.science);
        ImageView gold = new ImageView(images.gold);
        ImageView food =  new ImageView(images.food);
        ImageView happiness = new ImageView(images.happiness);
        ImageView unhappiness = new ImageView(images.unhappiness);
        topBarBackground = new Rectangle(0, 0, 1550, 50);
        topBarBackground.setFill(new Color(0, 0, 0, .87));
        if (!finalRoot.getChildren().contains(GameEnvironment.topBarBackground))
        finalRoot.getChildren().add(topBarBackground);
        initialiseIcons(science, gold, food, happiness, unhappiness);
        nextTurnIcon();
    }

    private void nextTurnIcon() {
        nextTurnView = new ImageView();
        Button nextTurn = new Button();
        nextTurn.setGraphic(nextTurnView);
        nextTurn.setLayoutX(1305);
        nextTurn.setLayoutY(640);
        nextTurnView.setFitHeight(210);
        nextTurnView.setFitWidth(210);
        nextTurn.setPrefSize(210, 210);
        nextTurn.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> nextTurn.setEffect(new DropShadow()));
        nextTurn.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> nextTurn.setEffect(null));
        finalRoot.getChildren().add(nextTurn);
        turnRunnable = new TurnRunnable(this);
        nextTurnThread = new Thread(turnRunnable);
        nextTurnThread.start();
        nextTurn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
        if (GameController.CanNextTurn(user)){
            clickThread.stop();
            nextTurnThread.stop();
            playerNumber++;
            if (playerNumber == players.size())playerNumber = 0;
            user = players.get(playerNumber);
            System.out.println(this.user);
            clickRunnable = new ClickRunnable(this);
            clickThread = new Thread(clickRunnable);
            clickThread.start();
            turnRunnable = new TurnRunnable(this);
            nextTurnThread = new Thread(turnRunnable);
            nextTurnThread.start();
            for (ImageView topBarImageView : topBarImageViews)
                finalRoot.getChildren().remove(topBarImageView);
            for (Label topBarLabel : topBarLabels) finalRoot.getChildren().remove(topBarLabel);
            finalRoot.getChildren().remove(topBarBackground);
            showAllInfo();
            finalRoot.getChildren().remove(nextTurn);
        }
        });
    }

    public void checkNextTurn() {
        boolean canNextTurn;
        while (true) {
            canNextTurn = GameController.CanNextTurn(user);
            if (canNextTurn) nextTurnView.setImage(images.nextTurn);
            else nextTurnView.setImage(images.cantNextTurn);
        }
    }

    private void initialiseIcons(ImageView science, ImageView gold, ImageView food, ImageView happiness, ImageView unhappiness) {
        topBarInfoUpdate();
        topBarImageViews = new ArrayList<>();
        topBarLabels = new ArrayList<>();
        science.setLayoutX(5);
        science.setLayoutY(5);
        science.setFitWidth(35);
        science.setFitHeight(35);
        science.getStyleClass().add("top-bar-info-icon");
        science.setId("scienceTopBarInfo");
        topBarImageViews.add(science);
        imageViewObjects.put(science, null);
        imageViews.add(science);
        scienceValue.setLayoutX(45);
        scienceValue.setLayoutY(5);
        scienceValue.setTextFill(new Color(0.027, 0.66, 0.93, 1));
        scienceValue.getStyleClass().add("top-bar-info");
        scienceValue.setId("scienceTopBarLabel");
        topBarLabels.add(scienceValue);
        finalRoot.getChildren().add(science);
        finalRoot.getChildren().add(scienceValue);
        gold.setLayoutY(5);
        gold.setLayoutX(85);
        gold.setFitHeight(35);
        gold.setFitWidth(35);
        gold.getStyleClass().add("top-bar-info-icon");
        gold.setId("goldTopBarInfo");
        topBarImageViews.add(gold);
        goldValue.setLayoutX(125);
        goldValue.setLayoutY(5);
        goldValue.setTextFill(new Color(0.97, 0.87, 0.23, 1));
        goldValue.getStyleClass().add("top-bar-info");
        goldValue.setId("goldTopBarLabel");
        topBarLabels.add(goldValue);
        finalRoot.getChildren().add(gold);
        finalRoot.getChildren().add(goldValue);
        food.setLayoutY(5);
        food.setLayoutX(185);
        food.setFitHeight(35);
        food.setFitWidth(35);
        food.getStyleClass().add("top-bar-info-icon");
        food.setId("foodTopBarInfo");
        topBarImageViews.add(food);
        foodValue.setLayoutX(223);
        foodValue.setLayoutY(5);
        foodValue.setTextFill(new Color(0.66, 0.835, 0.125, 1));
        foodValue.getStyleClass().add("top-bar-info");
        foodValue.setId("foodTopBarLabel");
        topBarLabels.add(foodValue);
        finalRoot.getChildren().add(food);
        finalRoot.getChildren().add(foodValue);
        happiness.setLayoutY(7);
        happiness.setLayoutX(287);
        happiness.setFitHeight(32);
        happiness.setFitWidth(32);
        happiness.getStyleClass().add("top-bar-info-icon");
        happiness.setId("happinessTopBarInfo");
        topBarImageViews.add(happiness);
        happinessValue.setLayoutX(325);
        happinessValue.setLayoutY(5);
        happinessValue.setTextFill(new Color(0.96, 0.95, .043, 1  ));
        happinessValue.getStyleClass().add("top-bar-info");
        happinessValue.setId("happinessTopBarLabel");
        topBarLabels.add(happinessValue);
        finalRoot.getChildren().add(happiness);
        finalRoot.getChildren().add(happinessValue);
        unhappiness.setLayoutY(5);
        unhappiness.setLayoutX(385);
        unhappiness.setFitHeight(35);
        unhappiness.setFitWidth(35);
        unhappiness.getStyleClass().add("top-bar-info-icon");
        unhappiness.setId("unhappinessTopBarInfo");
        topBarImageViews.add(unhappiness);
        unhappinessValue.setLayoutX(425);
        unhappinessValue.setLayoutY(5);
        unhappinessValue.setTextFill(new Color(0.97, 0.38, 0, 1));
        unhappinessValue.getStyleClass().add("top-bar-info");
        unhappinessValue.setId("UnhappinessTopBarLabel");
        topBarLabels.add(unhappinessValue);
        finalRoot.getChildren().add(unhappiness);
        finalRoot.getChildren().add(unhappinessValue);
    }

    public void topBarInfoUpdate(){
        unhappinessValueString = positiveOrNegative(user.getUnhappiness()) + user.getUnhappiness();
        happinessValueString = positiveOrNegative(user.getHappiness()) + user.getHappiness();
        goldValueString = user.getGold() + "(" + positiveOrNegative(user.getGoldPerTurn()) + user.getGoldPerTurn() + ")";
        scienceValueString = positiveOrNegative(user.getSciencePerTurn()) + user.getSciencePerTurn();
        foodValueString = user.getFood() + "(" + positiveOrNegative(user.getFoodPerTurn()) + user.getFoodPerTurn() + ")";
        goldValue.setText(goldValueString);
        scienceValue.setText(scienceValueString);
        foodValue.setText(foodValueString);
        unhappinessValue.setText(unhappinessValueString);
        happinessValue.setText(happinessValueString);
    }

    private String positiveOrNegative(int value) {
        if (value > 0) return "+";
        else if (value == 0)return "";
        else return "-";
    }

    private void createMap(){
        HashMap<ImageView, Boolean> canPopup = new HashMap<>();
        int i = 1;
        for (Tile[] tiles : map.getTileBoard()) {
            for (Tile tile : tiles) {
                Image TileTerrainImage = findCell(tile);
                if (TileTerrainImage == images.mountainCell && tile.getY() % 2 == 0) TileTerrainImage = images.mountainCell2;
                if (TileTerrainImage !=  null) {
                    ImageView imageView = new ImageView(TileTerrainImage);
                    imageView.setLayoutX(tile.getY() * 285 - tile.getX() % 2 * 142.5);
                    imageView.setFitWidth(285);
                    imageView.setLayoutY(tile.getX() * 360 - tile.getX() * 95);
                    imageView.setFitHeight(360);
                    imageView.setId("Tile");
                    imageViewObjects.put(imageView, tile);
                    imageViews.add(imageView);
                    canPopup.put(imageView, true);
                    root.getChildren().add(imageView);
                    resourceHandler(tile, imageView);
                    ruinChecker(tile, imageView);
                    showUnits(tile, imageView);
                    tileMouseClickHandle(tile, imageView, canPopup);
                } else {
                    System.out.println( i + " : An error happened! -> GameEnvironment -> createMap : " + tile.getTerrain().getName());
                    i++;
                }
            }
        }
        scrollHandler();
    }

    private void ruinChecker(Tile tile, ImageView tileView) {
        if (tile.isRuinBool() && tile.isRuinShow()) {

            ImageView ruinView = new ImageView(images.ruin);
            ruinView.setLayoutX(tileView.getLayoutX() + 170);
            ruinView.setLayoutY(tileView.getLayoutY() + 60);
            ruinView.setFitWidth(90);
            ruinView.setFitHeight(90);

            ImageView gold = new ImageView(images.gold);
            gold.setLayoutX(tileView.getLayoutX() + 140);
            gold.setLayoutY(tileView.getLayoutY() + 75);
            gold.setFitHeight(30);
            gold.setFitWidth(30);

            root.getChildren().add(gold);
            root.getChildren().add(ruinView);
        }
    }

    private Image findCell(Tile tile) {
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Jungle")) return images.jungleCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Forest")) return images.forestCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Ice")) return images.iceCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Marsh")) return images.marshCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("FloodPlain")) return images.floodPlainCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Oasis")) return images.oasisCell;
        return switch (tile.getTerrain().getName()) {
            case "Desert" -> images.desertCell;
            case "Grassland" -> images.grasslandCell;
            case "Hill" -> images.hillCell;
            case "Ocean" -> images.oceanCell;
            case "Plain" -> images.plainCell;
            case "Snow" -> images.snowCell;
            case "Tundra" -> images.tundraCell;
            case "Mountain" -> images.mountainCell;
            default -> null;
        };
    }

    private Image findResource(Tile tile) {
        if (tile.getResource() == null)return null;
        return switch (tile.getResource().getName()) {
            case "Banana" -> images.banana;
            case "Cow" -> images.cow;
            case "Gazelle" -> images.deer;
            case "Wheat" -> images.wheat;
            case "Sheep" -> images.sheep;
            case "Coal" -> images.coal;
            case "Horse" -> images.horse;
            case "Iron" -> images.iron;
            case "Cotton" -> images.cotton;
            case "Color" -> images.color;
            case "Fur" -> images.fur;
            case "Gemstones" -> images.gemStone;
            case "Gold" -> images.goldResource;
            case "Fumigation" -> images.fumigation;
            case "Silk" -> images.silk;
            case "Sugar" -> images.sugar;
            case "Silver" -> images.silver;
            case "Marble" -> images.marble;
            case "Ivory" -> images.ivory;
            default -> null;
        };
    }

    private void showPopupInfo(Rectangle rectangle, Tile tile, Label label,
                               ImageView foodView, ImageView goldView, ImageView productionView) {
        int food = 0;
        int production = 0;
        int gold = 0;
        if (tile.getFeature() != null) {
            food += tile.getFeature().getFoodRate();
            gold += tile.getFeature().getGoldRate();
            production += tile.getFeature().getProductionRate();
        }
        food += tile.getTerrain().getFoodRate();
        gold += tile.getTerrain().getGoldRate();
        production += tile.getTerrain().getProductionRate();
        String labelText;
        if (tile.getFeature() == null) labelText = "Terrain : " + tile.getTerrain().getName() + "\n\n"
                + food + "\n" + gold + "\n" + production;
        else labelText = "Terrain : " + tile.getTerrain().getName() + "\n" + "Feature : " + tile.getFeature().getName() + "\n"
                + food + "\n" + gold + "\n" + production;
        label.setText(labelText);
        label.setLayoutX(rectangle.getX() + 32);
        label.setLayoutY(rectangle.getY() + 3);
        label.getStyleClass().add("popup-info-text");

        foodView.setImage(images.food);
        foodView.setFitHeight(20);
        foodView.setFitWidth(20);
        foodView.setLayoutX(label.getLayoutX() - 25);
        foodView.setLayoutY(label.getLayoutY() + 52);

        goldView.setImage(images.gold);
        goldView.setFitHeight(20);
        goldView.setFitWidth(20);
        goldView.setLayoutX(label.getLayoutX() - 25);
        goldView.setLayoutY(label.getLayoutY() + 77);

        productionView.setImage(images.production);
        productionView.setFitHeight(20);
        productionView.setFitWidth(20);
        productionView.setLayoutX(label.getLayoutX() - 25);
        productionView.setLayoutY(label.getLayoutY() + 102);

        root.getChildren().add(foodView);
        root.getChildren().add(goldView);
        root.getChildren().add(productionView);
        root.getChildren().add(label);
    }

    private void resourceHandler(Tile tile, ImageView imageView) {
        Image TileResourceImage = findResource(tile);
        if(TileResourceImage != null) {
            ImageView resourceView = new ImageView(TileResourceImage);
            resourceView.setLayoutX(imageView.getLayoutX() + 25);
            resourceView.setLayoutY(imageView.getLayoutY() + 60);
            resourceView.setFitWidth(90);
            resourceView.setFitHeight(90);
            resourceView.setId("Resource");
            imageViewObjects.put(resourceView, tile.getResource());
            imageViews.add(resourceView);
            root.getChildren().add(resourceView);
        }
    }

    private void tileMouseClickHandle(Tile tile, ImageView imageView, HashMap<ImageView, Boolean> canPopup) {
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            double popupX;
            double popupY;
            if (tile.getY() > 77) popupX = imageView.getLayoutX() - 50;
            else popupX = imageView.getLayoutX() + 240;
            if (tile.getX() > 2) popupY = imageView.getLayoutY() - 125;
            else  popupY = imageView.getLayoutY() + 330;
            Rectangle rectangle = new Rectangle(popupX, popupY, 200, 132);
            rectangle.setFill(new Color(0, 0, 0, 0.6));
            Label label = new Label();
            ImageView foodView = new ImageView();
            ImageView goldView = new ImageView();
            ImageView productionView = new ImageView();
            if (canPopup.get(imageView)) {
                canPopup.replace(imageView, false);
                root.getChildren().add(rectangle);
                showPopupInfo(rectangle, tile, label, foodView, goldView, productionView);
            }
            if (tile.getCivilianUnit() != null && tile.getCivilianUnit().getName().equals("settler")){
                createCity(tile, imageView);
            }
            imageView.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                root.getChildren().remove(rectangle);
                root.getChildren().remove(label);
                root.getChildren().remove(foodView);
                root.getChildren().remove(goldView);
                root.getChildren().remove(productionView);
                canPopup.replace(imageView, true);
            });
        });
    }

    private void scrollHandler() {
        root.setOnScroll(event -> {
            if (event.isControlDown()) {
                if (root.getScaleX() + event.getDeltaY() / 1000 > 0.165 && root.getScaleX() + event.getDeltaY() / 1000 <= 1)
                    root.setScaleX(root.getScaleX() + event.getDeltaY() / 1000);
                if (root.getScaleY() + event.getDeltaY() / 1000 > 0.165 && root.getScaleY() + event.getDeltaY() / 1000 <= 1)
                    root.setScaleY(root.getScaleY() + event.getDeltaY() / 1000);
            } else {
                root.setTranslateX(root.getTranslateX() + event.getDeltaX());
                root.setTranslateY(root.getTranslateY() + event.getDeltaY());
            }
        });
    }

    //TODO : -GRAPHIC- DEBUG
    private void showUnits(Tile tile, ImageView imageView) {
        if (tile.getMilitaryUnit() != null) {
            Image MUnit = findMUnit(tile);
            ImageView MUitView = new ImageView(MUnit);
            MUitView.setLayoutX(imageView.getLayoutX() + 25);
            MUitView.setLayoutY(imageView.getLayoutY() + 300);
            MUitView.setFitHeight(90);
            MUitView.setFitWidth(90);
            MUitView.setId(tile.getMilitaryUnit().getName());
            imageViewObjects.put(MUitView, tile.getMilitaryUnit());
            imageViews.add(MUitView);
            root.getChildren().add(MUitView);
        }

        if (tile.getCivilianUnit() != null) {
            Image CUnit = findCUnit(tile);
            ImageView CUnitView = new ImageView(CUnit);
            CUnitView.setLayoutX(imageView.getLayoutX() + 180);
            CUnitView.setLayoutY(imageView.getLayoutY() + 155);
            CUnitView.setFitHeight(150);
            CUnitView.setFitWidth(150);
            CUnitView.setId(tile.getCivilianUnit().getName());
            imageViewObjects.put(CUnitView, tile.getCivilianUnit());
            imageViews.add(CUnitView);
            root.getChildren().add(CUnitView);
        }
    }

    private Image findMUnit(Tile tile) {
        return switch (tile.getMilitaryUnit().getName()) {
            case "Chariot Archer" -> images.chariotArcher;
            case "Spearman" -> images.spearman;
            case "Horseman" -> images.horseman;
            case "Swordsman" -> images.swordMan;
            case "Catapult" -> images.catapult;
            case "Knight" -> images.knight;
            case "Pikeman" -> images.pikeMan;
            case "Crossbowman" -> images.crossbowman;
            case "Trebuchet" -> images.trebuchet;
            case "Longswordsman" -> images.longSwordsman;
            case "Musketman" -> images.musketMan;
            case "Lancer" -> images.lancer;
            case "Cavalry" -> images.cavalry;
            case "Rifleman" -> images.rifleMan;
            case "Tank" -> images.tank;
            case "Panzer" -> images.panzer;
            case "Artillery" -> images.artillery;
            case "Infantry" -> images.infantry;
            case "Anti-Tank Gun" -> images.antiTankGun;
            case "warrior" -> images.warrior;
            case "Canon" -> images.canon;
            default -> null;
        };
    }

    private Image findCUnit(Tile tile) {
        if (tile.getCivilianUnit() == null) return null;
        return switch (tile.getCivilianUnit().getName()) {
            case "worker" -> images.worker;
            case "settler" -> images.settler;
            case "scout" -> images.scout;
            default -> null;
        };
    }

    //TODO : -GRAPHIC-LOGIC- DEBUG
    //TODO : -LOGIC- ADD THIS TO CREATE MAP
    private void createCity(Tile tile, ImageView imageView) {
        if (tile.getCity() != null) {
            ImageView cityView = new ImageView(images.city);
            cityView.setLayoutX(imageView.getLayoutX() + 50);
            cityView.setLayoutY(imageView.getLayoutY() + 65);
            cityView.setFitWidth(200);
            cityView.setFitHeight(200);
            root.getChildren().add(cityView);
        }
    }

    public void mouseClickHandler() {
        CityClickAction cityClickAction = new CityClickAction(finalRoot, root, MapController.getInstance(map));
        ResearchMenu researchMenu = new ResearchMenu(TechController.getInstance(), GameController.getInstance(players, map));
        UnitClickAction unitClickAction = new UnitClickAction(finalRoot, root, players, user);
        hashMap.put(1, true);
        hashMap.put(2, true);
        hashMap.put(3, true);
        hashMap.put(4, true);
        hashMap.put(5, true);
        while (true) {
            for (int i = 0; i < imageViews.size(); i++) {
                int finalI = i;
                imageViews.get(i).addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                    if (imageViews.get(finalI).getId().equals("settler") && hashMap.get(1) && !stop &&
                            ((Settler) imageViewObjects.get(imageViews.get(finalI))).getOwner().equals(user)) {
                        hashMap.replace(1, false);
                        hashMap.forEach((key1, value2) -> {
                            if (key1 != 1) hashMap.replace(key1, true);
                        });
                        for (ImageView topBarImageView : topBarImageViews)
                            finalRoot.getChildren().remove(topBarImageView);
                        for (Label topBarLabel : topBarLabels) finalRoot.getChildren().remove(topBarLabel);
                        finalRoot.getChildren().remove(topBarBackground);
                        unitClickAction.setUnit((Settler) imageViewObjects.get(imageViews.get(finalI)));
                        unitClickAction.setUnitView(imageViews.get(finalI));
                        unitClickAction.setUser(user);
                        unitClickAction.settlerClickAction();
                    } else if (imageViews.get(finalI).getId().equals("scienceTopBarInfo") && hashMap.get(2) && !stop) {
                        for (ImageView topBarImageView : topBarImageViews)
                            finalRoot.getChildren().remove(topBarImageView);
                        for (Label topBarLabel : topBarLabels) finalRoot.getChildren().remove(topBarLabel);
                        finalRoot.getChildren().remove(topBarBackground);
                        hashMap.replace(2, false);
                        hashMap.forEach((key1, value2) -> {
                            if (key1 != 2) hashMap.replace(key1, true);
                        });
                        researchMenu.setUser(user);
                        researchMenu.showGraphicTree(finalRoot);
                    } else if (imageViews.get(finalI).getId().equals("city") && hashMap.get(3) && !stop &&
                            ((City) imageViewObjects.get(imageViews.get(finalI))).getOwner().equals(user)) {
                        for (ImageView topBarImageView : topBarImageViews)
                            finalRoot.getChildren().remove(topBarImageView);
                        for (Label topBarLabel : topBarLabels) finalRoot.getChildren().remove(topBarLabel);
                        finalRoot.getChildren().remove(topBarBackground);
                        hashMap.replace(3, false);
                        hashMap.forEach((key1, value2) -> {
                            if (key1 != 3) hashMap.replace(key1, true);
                        });
                        cityClickAction.setCity((City) imageViewObjects.get(imageViews.get(finalI)));
                        cityClickAction.cityClickHandler();
                    } else if (mouseEvent.isControlDown() && imageViews.get(finalI).getId().equals("Tile") && hashMap.get(4) && !stop) {
                        hashMap.replace(4, false);
                        hashMap.forEach((key1, value2) -> {
                            if (key1 != 4) hashMap.replace(key1, true);
                        });
                        ((Tile) imageViewObjects.get(imageViews.get(finalI))).setRuinShow(true);
                    } else if (imageViews.get(finalI).getId().equals("worker") && hashMap.get(5) && !stop) {
                        hashMap.replace(5, false);
                        hashMap.forEach((key1, value2) -> {
                            if (key1 != 5) hashMap.replace(key1, true);
                        });
                        for (ImageView topBarImageView : topBarImageViews)
                            finalRoot.getChildren().remove(topBarImageView);
                        for (Label topBarLabel : topBarLabels) finalRoot.getChildren().remove(topBarLabel);
                        finalRoot.getChildren().remove(topBarBackground);
                        unitClickAction.setUnit((Worker) imageViewObjects.get(imageViews.get(finalI)));
                        unitClickAction.setUnitView(imageViews.get(finalI));
                        unitClickAction.setUser(user);
                        unitClickAction.workerClickAction();
                    }
                });
            }
            topBarInfoUpdate();
        }
    }
}
