package view;

import controller.ColorsController;
import controller.UsersController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import view.enums.Colors;
import model.*;
import view.enums.Images;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class GameMenu {
    /*graphic parts*/

    private final UsersController users;
    private MediaPlayer mediaPlayer;
    private final Stage stage;
    private final Scene scene;
    private static final Images images = new Images();
    private final User user;

    public GameMenu(MediaPlayer mediaPlayer, Stage stage, Scene scene, Images images, UsersController users, User user) {
        this.users = users;
        ProfileMenu.images = images;
        this.scene = scene;
        this.mediaPlayer = mediaPlayer;
        this.stage = stage;
        this.user = user;
    }

    public void start() {
        URL fxmlAddress = getClass().getResource("/Fxml/main-menu.fxml");
        if (fxmlAddress == null) System.exit(0);
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(fxmlAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        scene.setRoot(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        graphicPlayBackgroundMusic();
        assert root != null;
        graphicButtons(root);
    }

    private void graphicButtons(AnchorPane root) {
        ImageView buttonBackground = new ImageView(images.mainMenuButtonBackGround);
        Button startNewGame = new Button("Start New Game");
        Button continueGame = new Button("Continue Previous Game");
        Button chooseMap = new Button("Choose Map");
        Button chooseSpeed = new Button("Choose Speed");
        Button exit = new Button("exit");
        Rectangle background = new Rectangle(550, 165, 450, 550);
        background.setFill(new Color(0, 0, 0, 0.5));
        graphicInitialiseMenuButtons(startNewGame, continueGame, chooseMap, chooseSpeed, exit, buttonBackground);
        root.getChildren().add(background);
        root.getChildren().add(buttonBackground);
        root.getChildren().add(startNewGame);
        root.getChildren().add(continueGame);
        root.getChildren().add(chooseMap);
        root.getChildren().add(chooseSpeed);
        root.getChildren().add(exit);
        graphicButtonsAction(startNewGame, continueGame, chooseMap, chooseSpeed, exit, buttonBackground, root);
    }

    private void graphicInitialiseMenuButtons(Button startNewGame, Button continueGame, Button chooseMap,
                                          Button chooseSpeed, Button exit, ImageView buttonBackGround) {
        buttonBackGround.setFitWidth(630);
        buttonBackGround.setFitHeight(780);
        buttonBackGround.setLayoutX(445);
        buttonBackGround.setLayoutY(15);

        startNewGame.setLayoutX(614);
        startNewGame.setLayoutY(215.7);
        startNewGame.getStyleClass().add("main-menu-buttons");
        startNewGame.setPrefSize(312, 38);

        continueGame.setLayoutX(614);
        continueGame.setLayoutY(275);
        continueGame.getStyleClass().add("main-menu-buttons");
        continueGame.setPrefSize(312, 38);

        chooseMap.setLayoutX(614);
        chooseMap.setLayoutY(334.3);
        chooseMap.getStyleClass().add("main-menu-buttons");
        chooseMap.setPrefSize(312, 38);

        chooseSpeed.setLayoutX(614);
        chooseSpeed.setLayoutY(389.5);
        chooseSpeed.getStyleClass().add("main-menu-buttons");
        chooseSpeed.setPrefSize(312, 38);

        exit.setLayoutX(614);
        exit.setLayoutY(648);
        exit.getStyleClass().add("main-menu-buttons");
        exit.setPrefSize(312, 38);
    }

    private void graphicButtonsAction(Button startNewGame, Button continueGame, Button chooseMap,
                                      Button chooseSpeed, Button exit, ImageView background, AnchorPane root) {
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->
                new MainMenu(mediaPlayer, stage, scene, images, users).run(user, new Scanner(System.in)));
        startNewGame.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->
                chooseFriendsView(background));
        continueGame.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            //todo : go to play special game
        });
        chooseMap.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> chooseMapView());
        chooseSpeed.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> chooseSpeedView());
    }

    public void chooseFriendsView(ImageView menuBackground) {
        URL fxmlAddress = getClass().getResource("/Fxml/main-menu.fxml");
        if (fxmlAddress == null) System.exit(0);
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(fxmlAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (root == null) {
            System.out.println("root");
            System.exit(0);
        }
        if (scene == null) {
            System.out.println("scene");
            System.exit(0);
        }
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        scene.setRoot(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        graphicPlayBackgroundMusic();
        Rectangle background = new Rectangle(550, 165, 450, 550);
        background.setFill(new Color(0, 0, 0, 0.5));
        ArrayList<User> players = new ArrayList<>();
        players.add(user);
        TextField playerSearchTextField = new TextField("enter your friend username");
        Button addFriend = new Button("Add Friend");
        Button submit = new Button("submit");
        Button back = new Button("back");
        Label label = new Label();
        Label errorLabel = new Label();
        graphicInitialiseSearchButtons(playerSearchTextField, addFriend, submit, back, label, errorLabel);
        AtomicReference<String> playersNickname = new AtomicReference<>("player 1 : " + user.getNickname());
        label.setText(playersNickname.get());
        AnchorPane Root = root;
        addFriend.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if (!playerSearchTextField.getText().equals(user.getUsername()))
            playersNickname.set(searchNicknamesView(playerSearchTextField, Root, label, players, playersNickname.get(), errorLabel));
            else errorLabel.setText(" Enter a name other than your own!");
                });
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> start());
        submit.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if (players.size() > 1) {
                GameEnvironment gameEnvironment = new GameEnvironment(mediaPlayer, stage, images, users, user, players);
                gameEnvironment.run();
            } else {
                errorLabel.setText("you need more player to start the game!");
            }
        });
        root.getChildren().add(background);
        root.getChildren().add(menuBackground);
        root.getChildren().add(playerSearchTextField);
        root.getChildren().add(back);
        root.getChildren().add(addFriend);
        root.getChildren().add(submit);
        root.getChildren().add(label);
        root.getChildren().add(errorLabel);
    }

    private void graphicInitialiseSearchButtons(TextField playerSearchTextField, Button addFriend, Button submit,
                                                Button back, Label label, Label errorLabel) {
        playerSearchTextField.setAlignment(Pos.CENTER);
        playerSearchTextField.setLayoutX(609.5);
        playerSearchTextField.setLayoutY(218);
        playerSearchTextField.getStyleClass().add("search-friend-text-field");
        playerSearchTextField.setPrefSize(312, 38);

        addFriend.setLayoutX(614);
        addFriend.setLayoutY(274);
        addFriend.getStyleClass().add("main-menu-buttons");
        addFriend.setPrefSize(312, 38);

        submit.setLayoutX(614);
        submit.setLayoutY(332);
        submit.getStyleClass().add("main-menu-buttons");
        submit.setPrefSize(312, 38);

        back.setLayoutX(614);
        back.setLayoutY(648);
        back.getStyleClass().add("main-menu-buttons");
        back.setPrefSize(312, 38);

        label.setLayoutX(200);
        label.setLayoutY(230);
        label.getStyleClass().add("players-nickname-label");

        errorLabel.setLayoutX(614);
        errorLabel.setLayoutY(401.5);
        errorLabel.getStyleClass().add("register-signup-and-login-error");
    }

    private String searchNicknamesView(TextField playerSearchTextField, AnchorPane root, Label label, ArrayList<User> players, String playersNickname, Label errorLabel) {
        String nickname = UsersController.findPlayers(playerSearchTextField.getText(), players, users.getUsers());
        if (!nickname.equals("there is no player with this username!")) {
            playersNickname += "\nplayer " + players.size() + " : " + nickname;
            errorLabel.setText("");
        } else {
            errorLabel.setText("there is no player with this username!");
        }
        label.setText(playersNickname);
        return playersNickname;
    }

    public void chooseSpeedView() {
        URL fxmlAddress = getClass().getResource("/Fxml/main-menu.fxml");
        if (fxmlAddress == null) System.exit(0);
        assert fxmlAddress != null;
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(fxmlAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (root == null) {
            System.out.println("root");
            System.exit(0);
        }
        if (scene == null) {
            System.out.println("scene");
            System.exit(0);
        }
        assert root != null;
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        scene.setRoot(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        graphicPlayBackgroundMusic();
        ImageView buttonBackground = new ImageView(images.mainMenuButtonBackGround);
        buttonBackground.setFitWidth(630);
        buttonBackground.setFitHeight(780);
        buttonBackground.setLayoutX(445);
        buttonBackground.setLayoutY(15);
        Rectangle background = new Rectangle(550, 165, 450, 550);
        background.setFill(new Color(0, 0, 0, 0.5));
        Label message = new Label();
        message.setLayoutX(614);
        message.setLayoutY(150);
        message.getStyleClass().add("register-signup-and-login-error");
        message.setPrefSize(312, 38);
        message.setEffect(new DropShadow());

        Button speed1 = new Button("speed 1");
        speed1.setLayoutX(614);
        speed1.setLayoutY(215.7);
        speed1.getStyleClass().add("main-menu-buttons");
        speed1.setPrefSize(312, 38);
        speed1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            message.setText("the speed 1 selected for this game");
        });
        Button speed2 = new Button("speed 2");
        speed2.setLayoutX(614);
        speed2.setLayoutY(275);
        speed2.getStyleClass().add("main-menu-buttons");
        speed2.setPrefSize(312, 38);
        speed2.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            message.setText("the speed 2 selected for this game");
        });
        Button speed3 = new Button("speed 3");
        speed3.setLayoutX(614);
        speed3.setLayoutY(332);
        speed3.getStyleClass().add("main-menu-buttons");
        speed3.setPrefSize(312, 38);
        speed3.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            message.setText("the speed 3 selected for this game");
        });
        Button back = new Button("back");
        back.setLayoutX(614);
        back.setLayoutY(648);
        back.getStyleClass().add("main-menu-buttons");
        back.setPrefSize(312, 38);
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            start();
        });
        root.getChildren().add(background);
        root.getChildren().add(buttonBackground);
        root.getChildren().add(message);
        root.getChildren().add(speed1);
        root.getChildren().add(speed2);
        root.getChildren().add(speed3);
        root.getChildren().add(back);
    }

    public void chooseMapView() {
        URL fxmlAddress = getClass().getResource("/Fxml/main-menu.fxml");
        if (fxmlAddress == null) System.exit(0);
        assert fxmlAddress != null;
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(fxmlAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (root == null) {
            System.out.println("root");
            System.exit(0);
        }
        if (scene == null) {
            System.out.println("scene");
            System.exit(0);
        }
        assert root != null;
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        scene.setRoot(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        graphicPlayBackgroundMusic();
        ImageView buttonBackground = new ImageView(images.mainMenuButtonBackGround);
        buttonBackground.setFitWidth(630);
        buttonBackground.setFitHeight(780);
        buttonBackground.setLayoutX(445);
        buttonBackground.setLayoutY(15);
        Rectangle background = new Rectangle(550, 165, 450, 550);
        background.setFill(new Color(0, 0, 0, 0.5));
        Label message = new Label();
        message.setLayoutX(614);
        message.setLayoutY(150);
        message.getStyleClass().add("register-signup-and-login-error");
        message.setPrefSize(312, 38);
        message.setEffect(new DropShadow());

        Button map1 = new Button("map 1");
        map1.setLayoutX(614);
        map1.setLayoutY(215.7);
        map1.getStyleClass().add("main-menu-buttons");
        map1.setPrefSize(312, 38);
        map1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            message.setText("the map 1 selected for this game");
        });
        Button map2 = new Button("map 2");
        map2.setLayoutX(614);
        map2.setLayoutY(275);
        map2.getStyleClass().add("main-menu-buttons");
        map2.setPrefSize(312, 38);
        map2.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            message.setText("the map 2 selected for this game");
        });
        Button map3 = new Button("map 3");
        map3.setLayoutX(614);
        map3.setLayoutY(332);
        map3.getStyleClass().add("main-menu-buttons");
        map3.setPrefSize(312, 38);
        map3.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            message.setText("the map 3 selected for this game");
        });
        Button back = new Button("back");
        back.setLayoutX(614);
        back.setLayoutY(648);
        back.getStyleClass().add("main-menu-buttons");
        back.setPrefSize(312, 38);
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            start();
        });
        root.getChildren().add(background);
        root.getChildren().add(buttonBackground);
        root.getChildren().add(message);
        root.getChildren().add(map1);
        root.getChildren().add(map2);
        root.getChildren().add(map3);
        root.getChildren().add(back);
    }

    public void graphicPlayBackgroundMusic() {
        String path = String.valueOf(this.getClass().getResource("/Media/background themes/background-music.mp3"));
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(100);
    }


    /*end of graphic parts*/


    // provide some information for user
    private void manGameMenu(User user) {
        String userColor = new ColorsController().getColorOfUser(user);
        String boldColor = Colors.YELLOW_BOLD;
        String color = Colors.CYAN;
        System.out.println("welcome to Game Menu dear " + userColor + user.getUsername() + Colors.RESET + "!");
        System.out.println(color + "press \"menu exit\" to get back to view.view.Main Menu" + Colors.RESET);
        System.out.println(boldColor + "to Play Game :" + Colors.RESET);
        System.out.println(color + "play game --player1 <username> ... --player(k) <username>");
        System.out.println("play game -p1 <username> ... -p(k) <username>");
        System.out.println("the order of players is not important" + Colors.RESET);
    }

    public void run(UsersController users, User user, Scanner scanner) {
        String input;
        manGameMenu(user);
        while (true) {
            input = scanner.nextLine();
            if (Pattern.matches("\\s*menu\\s+exit\\s*", input))
                return;

            else if (Pattern.matches("\\s*menu\\s+show-current\\s*", input))
                System.out.println("Play Game");

            else if (input.startsWith("play game") && (input.contains("-p1") || input.contains("--player1"))) {
                String[] usernames = findUsernames(input, users);

                if (usernames != null && usernames.length >= 2 && checkIfUsernamesAreValid(usernames, users) && ifAllUsernamesAreUnique(usernames)) {
                    startGame(usernames, users, scanner);
                }
            } else
                System.out.println("invalid command");
        }
    }

    // start game
    private void startGame(String[] usernames, UsersController users, Scanner scanner) {
        System.out.println("successfully started game");
        ArrayList<User> players = new ArrayList<>();
        for (String username : usernames) {
            players.add(users.getUserByUsername(username));
        }
        //int[][] graph = techGraph2();
        //users.writeToJson(graph);
        int[][] graph = users.readFromJsonGraph();
        //ArrayList<Technology> technologies = better();
        //users.writeToJson(technologies);
        ArrayList<Technology> technologies = users.readFromJsonTech();
        //Maps map = new MapMaker().myTiles();
        //users.writeToJson(map);
        Maps map = users.readFromJsonMap();
        new PlayGame(players, map, graph, technologies).run(scanner);
    }

    // get the usernames from input
    private String[] findUsernames(String input, UsersController users) {
        String[] all = input.split("--");
        int size = all.length - 1;
        String[] usernames = new String[size];
        if (size >= 2) {
            // handle double dash ,,, order doesn't matter
            String[] splitPlayerAndUsername;
            int indexOfPlayer;
            String subStringForNumber;
            for (int i = 1; i <= size; i++) {
                splitPlayerAndUsername = all[i].split("\\s+");
                if (splitPlayerAndUsername[0].startsWith("player")) {
                    subStringForNumber = splitPlayerAndUsername[0].substring(6);
                    if (Pattern.matches("[0-9]+", subStringForNumber)) {
                        if (assignUsernames(size, usernames, splitPlayerAndUsername, subStringForNumber)) return null;
                    } else {
                        System.out.println("invalid number for player , only number after <player>");
                        return null;
                    }
                } else {
                    System.out.println("invalid command for players , each should start with key word <player>");
                    return null;
                }
            }
        } else {
            // handle one dash input ,,, order doesn't matter
            all = input.split("-");
            size = all.length - 1;
            usernames = new String[size];
            if (size >= 2) {
                String[] splitPlayerAndUsername;
                int indexOfPlayer;
                String subStringForNumber;
                for (int i = 1; i <= size; i++) {
                    splitPlayerAndUsername = all[i].split("\\s+");
                    if (splitPlayerAndUsername[0].startsWith("p")) {
                        subStringForNumber = splitPlayerAndUsername[0].substring(1);
                        if (Pattern.matches("[0-9]+", subStringForNumber)) {
                            if (assignUsernames(size, usernames, splitPlayerAndUsername, subStringForNumber))
                                return null;
                        } else {
                            System.out.println("invalid number for player , only number after <p>");
                            return null;
                        }
                    } else {
                        System.out.println("invalid command for players , each should start with key word <p>");
                        return null;
                    }
                }
            } else
                System.out.println("invalid command");
        }
        return usernames;
    }

    private boolean assignUsernames(int size, String[] usernames, String[] splitPlayerAndUsername, String subStringForNumber) {
        int indexOfPlayer;
        indexOfPlayer = Integer.parseInt(subStringForNumber);
        if (indexOfPlayer <= size) {
            if (usernames[indexOfPlayer - 1] == null)
                usernames[indexOfPlayer - 1] = splitPlayerAndUsername[1].trim();
            else {
                System.out.println("identical number for players");
                return true;
            }
        } else {
            System.out.println("given numbers are not proper");
            return true;
        }
        return false;
    }

    //all usernames should be valid
    private boolean checkIfUsernamesAreValid(String[] usernames, UsersController users) {

        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i] == null) {
                System.out.println("error occurred with given numbers");
                return false;
            }
        }

        for (String username : usernames) {
            if (!users.sameUsernameExists(username)) {
                System.out.println("some usernames are not valid");
                return false;
            }
        }
        return true;
    }

    // all usernames should be unique
    private boolean ifAllUsernamesAreUnique(String[] usernames) {
        for (int i = 0; i < usernames.length - 1; i++) {
            for (int j = i + 1; j < usernames.length; j++) {
                if (usernames[i].equals(usernames[j])) {
                    System.out.println("a username has been entered more than one time");
                    return false;
                }
            }
        }
        return true;
    }

    private ArrayList<Technology> better() {
        ArrayList<Technology> technologies = new ArrayList<>();
        ArrayList<Improvement> improvements = new ArrayList<>();
        ArrayList<Resource> resources = new ArrayList<>();
        ArrayList<Unit> units = new ArrayList<>();
        ArrayList<String> land = new ArrayList<>();
        ArrayList<Building> buildings = new ArrayList<>();
        ArrayList<String> requirements = new ArrayList<>();
        // ancient era
        // agriculture
        resources.add(new Resource("Wheat", "Bonus", "Farm", 0, 1, 0, 0));
        land.add("Plain");
        land.add("Desert");
        land.add("Grassland");
        improvements.add(new Improvement("Farm", 0, 1, 0, 5, resources, land));
        technologies.add(new Technology("Agriculture", improvements, 0, 20, null, null));
        //pottery
        buildings.add(new Building("Granary", 1, 100, 2, 0, 0, 0, 0, null));
        technologies.add(new Technology("Pottery", null, 1, 35, null, buildings));
        //animal husbandry
        improvements = new ArrayList<>();
        resources = new ArrayList<>();
        resources.add(new Resource("Sheep", "Bonus", "Pasture", 0, 2, 0, 0));
        resources.add(new Resource("Horse", "Strategic", "Pasture", 0, 0, 1, 0));
        resources.add(new Resource("Cow", "Bonus", "Pasture", 0, 1, 0, 0));
        land = new ArrayList<>();
        land.add("Plain");
        land.add("Desert");
        land.add("Grassland");
        land.add("Tundra");
        land.add("Hill");
        improvements.add(new Improvement("Pasture", 1, 0, 0, 5, resources, land));
        technologies.add(new Technology("Animal Husbandry", improvements, 2, 35, null, null));
        //archery
        units.add(new RangeMilitaryUnit("archer", null, 100, 240, 60, 1, 2, 15, 25, null, 20, 1));
        technologies.add(new Technology("Archery", null, 3, 35, units, null));
        //mining
        improvements = new ArrayList<>();
        resources = new ArrayList<>();
        resources.add(new Resource("Coal", "Strategic", "Mine", 0, 0, 1, 0));
        resources.add(new Resource("Iron", "Strategic", "Mine", 0, 0, 1, 0));
        resources.add(new Resource("Gemstones", "Luxury", "Mine", 3, 0, 0, 5));
        resources.add(new Resource("Gold", "Luxury", "Mine", 2, 0, 0, 4));
        resources.add(new Resource("Silver", "Luxury", "Mine", 2, 0, 0, 3));
        land = new ArrayList<>();
        land.add("Plain");
        land.add("Desert");
        land.add("Grassland");
        land.add("Tundra");
        land.add("Snow");
        land.add("Hill");
        land.add("Forest");
        land.add("Jungle");
        land.add("Marsh");
        improvements.add(new Improvement("Mine", 1, 0, 0, 5, resources, land));
        technologies.add(new Technology("Mining", improvements, 4, 35, null, null));
        // calendar
        improvements = new ArrayList<>();
        resources = new ArrayList<>();
        resources.add(new Resource("Banana", "Bonus", "Plantation", 0, 1, 0, 0));
        resources.add(new Resource("Cotton", "Luxury", "Plantation", 2, 0, 0, 3));
        resources.add(new Resource("Fumigation", "Luxury", "Plantation", 2, 0, 0, 2));
        resources.add(new Resource("Silk", "Luxury", "Plantation", 2, 0, 0, 3));
        resources.add(new Resource("Sugar", "Luxury", "Plantation", 2, 0, 0, 2));
        resources.add(new Resource("Color", "Luxury", "Plantation", 2, 0, 0, 2));
        land = new ArrayList<>();
        land.add("Plain");
        land.add("Desert");
        land.add("Grassland");
        land.add("Forest");
        land.add("Jungle");
        land.add("Marsh");
        land.add("FloodPlain");
        improvements.add(new Improvement("Plantation", 0, 0, 2, 5, resources, land));
        technologies.add(new Technology("Calendar", improvements, 5, 70, null, null));
        //writing
        buildings = new ArrayList<>();
        buildings.add(new Building("Library", 1, 80, 0, 0, 0, 1, 0, null));
        technologies.add(new Technology("Writing", null, 6, 55, null, buildings));
        //trapping
        improvements = new ArrayList<>();
        resources = new ArrayList<>();
        resources.add(new Resource("Gazelle", "Bonus", "Camp", 0, 1, 0, 0));
        resources.add(new Resource("Fur", "Luxury", "Camp", 2, 0, 0, 3));
        resources.add(new Resource("Ivory", "Luxury", "Camp", 2, 0, 0, 3));
        land = new ArrayList<>();
        land.add("Forest");
        land.add("Tundra");
        land.add("Plain");
        land.add("Hill");
        improvements.add(new Improvement("Camp", 0, 0, 1, 5, resources, land));
        land = new ArrayList<>();
        land.add("Plain");
        land.add("Desert");
        land.add("Grassland");
        land.add("Tundra");
        improvements.add(new Improvement("Trading Post", 0, 0, 1, 5, null, land));
        technologies.add(new Technology("Trapping", improvements, 7, 55, null, null));
        //the wheel
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("Chariot Archer", null, 100, 260, 65, 1, 2, 28, 0, null, 28, 1));
        buildings = new ArrayList<>();
        buildings.add(new Building("Water Mill", 2, 120, 2, 0, 0, 0, 0, null));
        technologies.add(new Technology("The Wheel", null, 8, 55, units, buildings));
        //bronze working
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Spearman", null, 100, 260, 65, 1, 2, 25, 0, null, 25, 1));
        buildings = new ArrayList<>();
        buildings.add(new Building("Barracks", 1, 80, 0, 0, 15, 0, 0, null));
        technologies.add(new Technology("Bronze Working", null, 9, 80, units, buildings));
        //masonry
        improvements = new ArrayList<>();
        resources = new ArrayList<>();
        resources.add(new Resource("Marble", "Luxury", "Quarry", 2, 0, 0, 3));
        land = new ArrayList<>();
        land.add("Plain");
        land.add("Desert");
        land.add("Grassland");
        land.add("Tundra");
        land.add("Hill");
        improvements.add(new Improvement("Quarry", 1, 0, 0, 5, resources, land));
        buildings = new ArrayList<>();
        buildings.add(new Building("Walls", 1, 100, 0, 5, 0, 0, 0, null));
        technologies.add(new Technology("Masonry", improvements, 10, 55, null, buildings));

        //classical era
        // construction
        improvements = new ArrayList<>();
        land = new ArrayList<>();
        land.add("Forest");
        improvements.add(new Improvement("Lumber Mill", 1, 0, 0, 5, null, land));
        buildings = new ArrayList<>();
        buildings.add(new Building("Colosseum", 3, 150, 0, 0, 0, 0, 4, null));
        technologies.add(new Technology("Construction", improvements, 11, 100, null, buildings));
        //horseback riding
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Horseman", null, 100, 320, 80, 1, 4, 36, 0, null, 36, 2));
        buildings = new ArrayList<>();
        buildings.add(new Building("Circus", 3, 150, 0, 0, 0, 0, 3, null));
        buildings.add(new Building("Stable", 1, 100, 0, 0, 0, 0, 0, null));
        technologies.add(new Technology("Horseback Riding", null, 12, 100, units, buildings));
        //iron working
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Swordsman", null, 100, 360, 90, 1, 2, 35, 0, null, 35, 2));
        buildings = new ArrayList<>();
        requirements.add("Barracks");
        buildings.add(new Building("Armory", 3, 130, 0, 0, 15, 0, 0, requirements));
        technologies.add(new Technology("Iron Working", null, 13, 150, units, buildings));
        //mathematics
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("Catapult", null, 100, 480, 120, 1, 2, 25, 35, null, 25, 2));
        buildings = new ArrayList<>();
        buildings.add(new Building("Courthouse", 5, 200, 0, 0, 0, 0, 0, null));
        technologies.add(new Technology("Mathematics", null, 14, 100, units, buildings));
        //philosophy
        buildings = new ArrayList<>();
        buildings.add(new Building("Burial Tomb", 0, 120, 0, 0, 0, 0, 2, null));
        requirements = new ArrayList<>();
        requirements.add("Monument");
        buildings.add(new Building("Temple", 2, 120, 0, 0, 0, 0, 0, requirements));
        technologies.add(new Technology("Philosophy", null, 15, 100, null, buildings));

        //medieval era
        //chivalry
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Knight", null, 100, 720, 180, 1, 4, 50, 0, null, 50, 3));
        buildings = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add("Walls");
        buildings.add(new Building("Castle", 3, 200, 0, 8, 0, 0, 0, requirements));
        technologies.add(new Technology("Chivalry", null, 16, 440, units, buildings));
        //civil service
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Pikeman", null, 100, 800, 200, 1, 2, 45, 0, null, 45, 3));
        technologies.add(new Technology("Civil Service", null, 17, 400, units, null));
        //currency
        buildings = new ArrayList<>();
        buildings.add(new Building("Market", 0, 120, 0, 0, 0, 0, 0, null));
        buildings.add(new Building("Mint", 0, 120, 0, 0, 0, 0, 0, null));
        technologies.add(new Technology("Currency", null, 18, 250, null, buildings));
        //education
        buildings = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add("Library");
        buildings.add(new Building("University", 3, 200, 0, 0, 0, 0, 0, requirements));
        technologies.add(new Technology("Education", null, 19, 440, null, buildings));
        //engineering
        improvements = new ArrayList<>();
        land = new ArrayList<>();
        land.add("Plain");
        land.add("Desert");
        land.add("Grassland");
        land.add("Tundra");
        land.add("Snow");
        improvements.add(new Improvement("Factory", 2, 0, 0, 5, null, land));
        technologies.add(new Technology("Engineering", improvements, 20, 250, null, null));
        // machinery
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("Crossbowman", null, 100, 720, 180, 1, 2, 30, 40, null, 30, 3));
        technologies.add(new Technology("Machinery", null, 21, 440, units, null));
        //metal casting
        buildings = new ArrayList<>();
        buildings.add(new Building("Forge", 2, 150, 0, 0, 0, 0, 0, null));
        buildings.add(new Building("Workshop", 2, 100, 0, 0, 0, 0, 0, null));
        technologies.add(new Technology("Metal Casting", null, 22, 240, null, buildings));
        //physics
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("Trebuchet", null, 100, 800, 200, 1, 2, 35, 45, null, 35, 3));
        technologies.add(new Technology("Physics", null, 23, 440, units, null));
        //steel
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Longswordsman", null, 100, 360, 90, 1, 2, 50, 0, null, 50, 3));
        technologies.add(new Technology("Steel", null, 24, 440, units, null));
        //theology
        buildings = new ArrayList<>();
        buildings.add(new Building("Garden", 2, 120, 0, 0, 0, 0, 0, null));
        buildings.add(new Building("Monastery", 2, 120, 0, 0, 0, 0, 0, null));
        technologies.add(new Technology("Theology", null, 25, 250, null, buildings));

        //renaissance era
        //acoustics
        buildings = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add("Temple");
        requirements.add("Burial Tomb");
        buildings.add(new Building("Opera House", 3, 220, 0, 0, 0, 0, 0, requirements));
        technologies.add(new Technology("Acoustics", null, 26, 650, null, buildings));
        //archaeology
        buildings = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add("Opera House");
        buildings.add(new Building("Museum", 3, 350, 0, 0, 0, 0, 0, requirements));
        technologies.add(new Technology("Archaeology", null, 27, 1300, null, buildings));
        //banking
        buildings = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add("Market");
        buildings.add(new Building("Bank", 0, 220, 0, 0, 0, 0, 0, requirements));
        buildings.add(new Building("Strap's Court", 0, 220, 0, 0, 0, 0, 0, requirements));
        technologies.add(new Technology("Banking", null, 28, 650, null, buildings));
        //chemistry

        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("Canon", null, 100, 260, 0, 1, 2, 10, 26, null, 0, 1));
        technologies.add(new Technology("Chemistry", null, 29, 900, units, null));
        //economics
        buildings = new ArrayList<>();
        buildings.add(new Building("Windmill", 2, 180, 0, 0, 0, 0, 0, null));
        technologies.add(new Technology("Economics", null, 30, 900, null, buildings));
        //fertilizer
        technologies.add(new Technology("Fertilizer", null, 31, 1300, null, null));
        // gunpowder
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Musketman", null, 100, 960, 240, 1, 2, 55, 0, null, 55, 4));
        technologies.add(new Technology("Gunpowder", null, 32, 680, units, null));
        //metallurgy
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Lancer", null, 100, 1000, 270, 1, 4, 58, 0, null, 58, 4));
        technologies.add(new Technology("Metallurgy", null, 33, 900, units, null));
        // military science
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Cavalry", null, 100, 1320, 330, 1, 5, 62, 0, null, 62, 5));
        buildings = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add("Barracks");
        buildings.add(new Building("Military Academy", 3, 350, 0, 0, 0, 0, 0, requirements));
        technologies.add(new Technology("Military Science", null, 34, 1300, units, buildings));
        // printing press
        buildings = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add("Colosseum");
        buildings.add(new Building("Theater", 5, 300, 0, 0, 0, 0, 4, requirements));
        technologies.add(new Technology("Printing Press", null, 35, 650, null, buildings));
        // rifling
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Rifleman", null, 100, 1320, 330, 1, 2, 70, 0, null, 70, 5));
        technologies.add(new Technology("Rifling", null, 36, 1425, units, null));
        // scientific theory
        buildings = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add("University");
        buildings.add(new Building("Public School", 3, 350, 0, 0, 0, 0, 0, requirements));
        technologies.add(new Technology("Scientific Theory", null, 37, 1300, null, buildings));

        //industrial era
        //biology
        buildings = new ArrayList<>();
        buildings.add(new Building("Hospital", 2, 400, 0, 0, 0, 0, 0, null));
        technologies.add(new Technology("Biology", null, 38, 1680, null, buildings));
        // combustion
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Tank", null, 100, 1920, 480, 1, 4, 85, 0, null, 85, 6));
        units.add(new MeleeMilitaryUnit("Panzer", null, 100, 1820, 380, 1, 5, 60, 0, null, 60, 5));
        technologies.add(new Technology("Combustion", null, 39, 1250, units, null));
        //dynamite
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("Artillery", null, 100, 1720, 430, 1, 2, 60, 80, null, 60, 6));
        technologies.add(new Technology("Dynamite", null, 40, 1900, units, null));
        //electricity
        buildings = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add("Bank");
        requirements.add("Strap's Court");
        buildings.add(new Building("Stock Exchange", 0,  650, 0, 0, 0, 0, 0, requirements));
        technologies.add(new Technology("Electricity", null, 41, 1900, null, buildings));
        //radio
        buildings = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add("Museum");
        buildings.add(new Building("Broadcast Tower", 3, 600, 0, 0, 0, 0, 0, requirements));
        technologies.add(new Technology("Radio", null, 42, 2200, null, buildings));
        //railroad
        buildings = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add("Military Academy");
        buildings.add(new Building("Arsenal", 3, 350, 0, 0, 0, 0, 0, requirements));
        technologies.add(new Technology("Railroad", null, 43, 1900, null, buildings));
        //replaceable parts
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Infantry", null, 100, 1720, 430, 1, 2, 75, 0, null, 75, 6));
        units.add(new MeleeMilitaryUnit("Anti-Tank Gun", null, 100, 1720, 430, 1, 2, 75, 0, null, 75, 6));
        technologies.add(new Technology("Replaceable Parts", null, 44, 1900, units, null));
        //steam power
        buildings = new ArrayList<>();
        buildings.add(new Building("Factory", 3, 300, 0, 0, 0, 0, 0, null));
        technologies.add(new Technology("Steam Power", null, 45, 1680, null, buildings));
        //telegraph
        buildings = new ArrayList<>();
        requirements = new ArrayList<>();
        requirements.add("Castle");
        buildings.add(new Building("Military Base", 4, 450, 0, 0, 0, 0, 0, requirements));
        technologies.add(new Technology("Telegraph", null, 46, 2200, null, buildings));

        return technologies;
    }

    private int[][] techGraph2() {
        int[][] graph = new int[47][47];
        //0
        for (int i = 0; i < 47; i++)
            graph[i][0] = 0;
        //1
        for (int i = 0; i < 47; i++) {
            if (i == 0) graph[i][1] = 1;
            else graph[i][1] = 0;
        }
        //2
        for (int i = 0; i < 47; i++) {
            if (i == 0) graph[i][2] = 1;
            else graph[i][2] = 0;
        }
        //3
        for (int i = 0; i < 47; i++) {
            if (i == 0) graph[i][3] = 1;
            else graph[i][3] = 0;
        }
        //4
        for (int i = 0; i < 47; i++) {
            if (i == 0) graph[i][4] = 1;
            else graph[i][4] = 0;
        }
        //5
        for (int i = 0; i < 47; i++) {
            if (i == 1) graph[i][5] = 1;
            else graph[i][5] = 0;
        }
        //6
        for (int i = 0; i < 47; i++) {
            if (i == 1) graph[i][6] = 1;
            else graph[i][6] = 0;
        }
        //7
        for (int i = 0; i < 47; i++) {
            if (i == 2) graph[i][7] = 1;
            else graph[i][7] = 0;
        }
        //8
        for (int i = 0; i < 47; i++) {
            if (i == 2) graph[i][8] = 1;
            else graph[i][8] = 0;
        }
        //9
        for (int i = 0; i < 47; i++) {
            if (i == 4) graph[i][9] = 1;
            else graph[i][9] = 0;
        }
        //10
        for (int i = 0; i < 47; i++) {
            if (i == 4) graph[i][10] = 1;
            else graph[i][10] = 0;
        }
        //11
        for (int i = 0; i < 47; i++) {
            if (i == 10) graph[i][11] = 1;
            else graph[i][11] = 0;
        }
        //12
        for (int i = 0; i < 47; i++) {
            if (i == 8) graph[i][12] = 1;
            else graph[i][12] = 0;
        }
        //13
        for (int i = 0; i < 47; i++) {
            if (i == 9) graph[i][13] = 1;
            else graph[i][13] = 0;
        }
        //14
        for (int i = 0; i < 47; i++) {
            if (i == 3 || i == 8) graph[i][14] = 1;
            else graph[i][14] = 0;
        }
        //15
        for (int i = 0; i < 47; i++) {
            if (i == 6) graph[i][15] = 1;
            else graph[i][15] = 0;
        }
        //16
        for (int i = 0; i < 47; i++) {
            if (i == 12 || i == 17 || i == 18) graph[i][16] = 1;
            else graph[i][16] = 0;
        }
        //17
        for (int i = 0; i < 47; i++) {
            if (i == 7 || i == 15) graph[i][17] = 1;
            else graph[i][17] = 0;
        }
        //18
        for (int i = 0; i < 47; i++) {
            if (i == 14) graph[i][18] = 1;
            else graph[i][18] = 0;
        }
        //19
        for (int i = 0; i < 47; i++) {
            if (i == 25) graph[i][19] = 1;
            else graph[i][19] = 0;
        }
        //20
        for (int i = 0; i < 47; i++) {
            if (i == 11 || i == 14) graph[i][20] = 1;
            else graph[i][20] = 0;
        }
        //21
        for (int i = 0; i < 47; i++) {
            if (i == 20) graph[i][21] = 1;
            else graph[i][21] = 0;
        }
        //22
        for (int i = 0; i < 47; i++) {
            if (i == 13) graph[i][22] = 1;
            else graph[i][22] = 0;
        }
        //23
        for (int i = 0; i < 47; i++) {
            if (i == 20 || i == 22) graph[i][23] = 1;
            else graph[i][23] = 0;
        }
        //24
        for (int i = 0; i < 47; i++) {
            if (i == 22) graph[i][24] = 1;
            else graph[i][24] = 0;
        }
        //25
        for (int i = 0; i < 47; i++) {
            if (i == 5 || i == 15) graph[i][25] = 1;
            else graph[i][25] = 0;
        }
        //26
        for (int i = 0; i < 47; i++) {
            if (i == 19) graph[i][26] = 1;
            else graph[i][26] = 0;
        }
        //27
        for (int i = 0; i < 47; i++) {
            if (i == 26) graph[i][27] = 1;
            else graph[i][27] = 0;
        }
        //28
        for (int i = 0; i < 47; i++) {
            if (i == 16 || i == 19) graph[i][28] = 1;
            else graph[i][28] = 0;
        }
        //29
        for (int i = 0; i < 47; i++) {
            if (i == 32) graph[i][29] = 1;
            else graph[i][29] = 0;
        }
        //30
        for (int i = 0; i < 47; i++) {
            if (i == 28 || i == 35) graph[i][30] = 1;
            else graph[i][30] = 0;
        }
        //31
        for (int i = 0; i < 47; i++) {
            if (i == 29) graph[i][31] = 1;
            else graph[i][31] = 0;
        }
        //32
        for (int i = 0; i < 47; i++) {
            if (i == 23 || i == 24) graph[i][32] = 1;
            else graph[i][32] = 0;
        }
        //33
        for (int i = 0; i < 47; i++) {
            if (i == 32) graph[i][33] = 1;
            else graph[i][33] = 0;
        }
        //34
        for (int i = 0; i < 47; i++) {
            if (i == 29 || i == 30) graph[i][34] = 1;
            else graph[i][34] = 0;
        }
        //35
        for (int i = 0; i < 47; i++) {
            if (i == 21 || i == 23) graph[i][35] = 1;
            else graph[i][35] = 0;
        }
        //36
        for (int i = 0; i < 47; i++) {
            if (i == 33) graph[i][36] = 1;
            else graph[i][36] = 0;
        }
        //37
        for (int i = 0; i < 47; i++) {
            if (i == 26) graph[i][37] = 1;
            else graph[i][37] = 0;
        }
        //38
        for (int i = 0; i < 47; i++) {
            if (i == 27 || i == 37) graph[i][38] = 1;
            else graph[i][38] = 0;
        }
        //39
        for (int i = 0; i < 47; i++) {
            if (i == 40 || i == 43 || i == 44) graph[i][39] = 1;
            else graph[i][39] = 0;
        }
        //40
        for (int i = 0; i < 47; i++) {
            if (i == 31 || i == 36) graph[i][40] = 1;
            else graph[i][40] = 0;
        }
        //41
        for (int i = 0; i < 47; i++) {
            if (i == 38 || i == 45) graph[i][41] = 1;
            else graph[i][41] = 0;
        }
        //42
        for (int i = 0; i < 47; i++) {
            if (i == 41) graph[i][42] = 1;
            else graph[i][42] = 0;
        }
        //43
        for (int i = 0; i < 47; i++) {
            if (i == 45) graph[i][43] = 1;
            else graph[i][43] = 0;
        }
        //44
        for (int i = 0; i < 47; i++) {
            if (i == 45) graph[i][44] = 1;
            else graph[i][44] = 0;
        }
        //45
        for (int i = 0; i < 47; i++) {
            if (i == 34 || i == 37) graph[i][45] = 1;
            else graph[i][45] = 0;
        }
        //46
        for (int i = 0; i < 47; i++) {
            if (i == 41) graph[i][46] = 1;
            else graph[i][46] = 0;
        }
        return graph;
    }
}