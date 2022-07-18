package view;

import controller.ColorsController;
import controller.UsersController;
import javafx.fxml.FXMLLoader;
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
import java.util.regex.Pattern;

public class GameMenu {


    /*graphic parts*/

    private String whichMenu;
    private UsersController users;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private Scene scene;
    private static Images images = new Images();
    private User user;
    private String gameMapSize;
    private int gameSpeed;

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
        graphicButtons(root);
    }

    private void graphicButtons(AnchorPane root) {
        ImageView buttonBackground = new ImageView(images.mainMenuButtonBackGround);
        Button startNewGame = new Button("Start New Game");
        Button continueGame = new Button("Continue Previous Game");
        Button playWithFriends = new Button("Play With Friends");
        Button chooseMap = new Button("Choose Map");
        Button chooseSpeed = new Button("Choose Speed");
        Button exit = new Button("exit");
        Rectangle background = new Rectangle(550, 165, 450, 550);
        background.setFill(new Color(0, 0, 0, 0.5));
        graphicInitialiseButtons(startNewGame, continueGame, playWithFriends, chooseMap, chooseSpeed, exit, buttonBackground);
        root.getChildren().add(background);
        root.getChildren().add(buttonBackground);
        root.getChildren().add(startNewGame);
        root.getChildren().add(continueGame);
        root.getChildren().add(playWithFriends);
        root.getChildren().add(chooseMap);
        root.getChildren().add(chooseSpeed);
        root.getChildren().add(exit);
        graphicButtonsAction(startNewGame, continueGame, playWithFriends, chooseMap, chooseSpeed, exit);

    }

    private void graphicInitialiseButtons(Button startNewGame, Button continueGame, Button playWithFriends, Button chooseMap,
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

        playWithFriends.setLayoutX(614);
        playWithFriends.setLayoutY(332);
        playWithFriends.getStyleClass().add("main-menu-buttons");
        playWithFriends.setPrefSize(312, 38);

        chooseMap.setLayoutX(614);
        chooseMap.setLayoutY(389.5);
        chooseMap.getStyleClass().add("main-menu-buttons");
        chooseMap.setPrefSize(312, 38);

        chooseSpeed.setLayoutX(614);
        chooseSpeed.setLayoutY(447);
        chooseSpeed.getStyleClass().add("main-menu-buttons");
        chooseSpeed.setPrefSize(312, 38);

        exit.setLayoutX(614);
        exit.setLayoutY(648);
        exit.getStyleClass().add("main-menu-buttons");
        exit.setPrefSize(312, 38);
    }

    private void graphicButtonsAction(Button startNewGame, Button continueGame, Button playWithFriends, Button chooseMap,
                                      Button chooseSpeed, Button exit) {
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            new MainMenu(mediaPlayer, stage, scene, images, users).run(user, new Scanner(System.in));
        });
        startNewGame.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            //todo : go to play game
        });
        continueGame.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            //todo : go to play special game
        });
        playWithFriends.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            //todo : go to a menu to choose friends
            chooseFriendsView();
        });
        chooseMap.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            chooseMapView();
        });
        chooseSpeed.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            chooseSpeedView();
        });
    }

    public void chooseFriendsView() {
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
        TextField numberOfPlayers = new TextField();
        numberOfPlayers.setLayoutX(614);
        numberOfPlayers.setLayoutY(180);
        numberOfPlayers.setPromptText("put the number of players");
        numberOfPlayers.getStyleClass().add("profile-text-field");
        numberOfPlayers.setPrefSize(312, 38);
        root.getChildren().add(background);
        root.getChildren().add(buttonBackground);
        root.getChildren().add(numberOfPlayers);
        Button submit = new Button("submit");
        submit.setLayoutX(614);
        submit.setLayoutY(215.7);
        submit.getStyleClass().add("main-menu-buttons");
        submit.setPrefSize(312, 38);
        Button back = new Button("back");
        back.setLayoutX(614);
        back.setLayoutY(267.7);
        back.getStyleClass().add("main-menu-buttons");
        back.setPrefSize(312, 38);
        AnchorPane finalRoot = root;
        submit.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            searchNicknamesView(numberOfPlayers, finalRoot, submit, back, numberOfPlayers);
        });
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            start();
        });
        root.getChildren().add(back);
        root.getChildren().add(submit);
    }

    public void searchNicknamesView(TextField numberOfPlayers, AnchorPane root, Button removableButton, Button removableButton2, TextField removableTextField) {
        root.getChildren().remove(removableButton);
        root.getChildren().remove(removableTextField);
        root.getChildren().remove(removableButton2);
        int number = 0;
        if (numberOfPlayers.getText().matches("\s*\\d+\s*")) {
            number = Integer.parseInt(numberOfPlayers.getText());
        }
        ArrayList<TextField> playersNickname = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int j = i + 1;
            TextField playerNickname = new TextField();
            playerNickname.setLayoutX(614);
            playerNickname.setLayoutY(215.7 + (i * 42));
            playerNickname.setPromptText("put the player " + j + " nickname");
            playerNickname.getStyleClass().add("profile-text-field");
            playerNickname.setPrefSize(312, 38);
            playersNickname.add(playerNickname);
            root.getChildren().add(playerNickname);
        }
        Button submit = new Button("submit");
        submit.setLayoutX(614);
        submit.setLayoutY(605);
        submit.getStyleClass().add("main-menu-buttons");
        submit.setPrefSize(312, 38);
        submit.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            
            //todo : send request to play for friends
        });
        root.getChildren().add(submit);
        Button back = new Button("back");
        back.setLayoutX(614);
        back.setLayoutY(648);
        back.getStyleClass().add("main-menu-buttons");
        back.setPrefSize(312, 38);
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            start();
        });
        root.getChildren().add(back);
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
            gameSpeed = 1;
            message.setText("the speed 1 selected for this game");
        });
        Button speed2 = new Button("speed 2");
        speed2.setLayoutX(614);
        speed2.setLayoutY(275);
        speed2.getStyleClass().add("main-menu-buttons");
        speed2.setPrefSize(312, 38);
        speed2.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            gameSpeed = 2;
            message.setText("the speed 2 selected for this game");
        });
        Button speed3 = new Button("speed 3");
        speed3.setLayoutX(614);
        speed3.setLayoutY(332);
        speed3.getStyleClass().add("main-menu-buttons");
        speed3.setPrefSize(312, 38);
        speed3.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            gameSpeed = 3;
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
            gameMapSize = "10*10";
            message.setText("the map 1 selected for this game");
        });
        Button map2 = new Button("map 2");
        map2.setLayoutX(614);
        map2.setLayoutY(275);
        map2.getStyleClass().add("main-menu-buttons");
        map2.setPrefSize(312, 38);
        map2.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            gameMapSize = "20*20";
            message.setText("the map 2 selected for this game");
        });
        Button map3 = new Button("map 3");
        map3.setLayoutX(614);
        map3.setLayoutY(332);
        map3.getStyleClass().add("main-menu-buttons");
        map3.setPrefSize(312, 38);
        map3.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            gameMapSize = "30*30";
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

    
}