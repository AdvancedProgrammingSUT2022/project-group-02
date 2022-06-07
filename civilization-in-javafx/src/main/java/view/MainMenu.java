package view;

import controller.UsersController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import view.enums.Colors;
import view.enums.Images;
import view.enums.RegexEnums;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu {

    private UsersController users;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private Scene scene;
    private static Images images;
    private User user;

    public MainMenu(MediaPlayer mediaPlayer, Stage stage, Scene scene, Images images, UsersController users){
        this.users = users;
        MainMenu.images = images;
        this.scene = scene;
        this.mediaPlayer = mediaPlayer;
        this.stage = stage;
    }
    public MainMenu(){}
    //provide some information for user
    private void manMainMenu() {
        String color = Colors.CYAN;
        System.out.println(color + "press \"menu enter <menu name>\" to access to Play Game and Profile Menu");
        System.out.println("press \"menu exit or user logout\" to get back to Register Menu" + Colors.RESET);
    }
    public void run(User user, Scanner scanner) {
        /* graphic part */
        this.user = user;

        URL fxmlAddress = getClass().getResource("/Fxml/main-menu.fxml");
        assert fxmlAddress != null;
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(fxmlAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert root != null;
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        scene.setRoot(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        graphicButtons(root);

        /* end of graphic part */

//        String input;
//        Matcher matcher;
//        manMainMenu();
//        while (true) {
//            input = scanner.nextLine();
//            //exit the menu
//            if (Pattern.matches("\\s*menu\\s+exit\\s*", input))
//                return;
//                //logging out
//            else if (Pattern.matches("\\s*user\\s+logout\\s*", input)) {
//                System.out.println("user logged out successfully!");
//                return;
//            }
//            //show current menu
//            else if (Pattern.matches("\\s*menu\\s+show-current\\s*", input))
//                System.out.println("view.Main Menu");
//                //change the menu to Profile or Play game
//            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_MENU)) != null) {
//                String menu = matcher.group("menu");
//                if (menu.equals("Play Game")) {
//                    new GameMenu().run(users, user, scanner);
//                }
//                else if (menu.equals("Profile")) {
//                    //new ProfileMenu().run(users, user, scanner);
//                }
//                else
//                    System.out.println("invalid command");
//            }
//            else
//                System.out.println("invalid command");
//        }
    }

    private void graphicButtons(AnchorPane root){
        ImageView buttonBackground = new ImageView(images.mainMenuButtonBackGround);
        Button startGame = new Button("Game Menu");
        Button leaderboard = new Button("Leaderboard");
        Button profileMenu = new Button("Profile Menu");
        Button chatMenu = new Button("Chat Menu");
        Button mapSetting = new Button("Map Setting");
        Button logout = new Button("Logout");
        Button exit = new Button("Exit");
        Rectangle background = new Rectangle(550, 165, 450, 550);
        background.setFill(new Color(0, 0, 0, 0.5));
        graphicInitialiseButtons(startGame, profileMenu, leaderboard, chatMenu, mapSetting, logout, exit, buttonBackground);
        root.getChildren().add(background);
        root.getChildren().add(buttonBackground);
        root.getChildren().add(profileMenu);
        root.getChildren().add(startGame);
        root.getChildren().add(chatMenu);
        root.getChildren().add(mapSetting);
        root.getChildren().add(logout);
        root.getChildren().add(leaderboard);
        root.getChildren().add(exit);
        graphicButtonsAction(startGame, profileMenu, leaderboard, chatMenu, mapSetting, logout, exit);
    }

    private void graphicInitialiseButtons(Button startGame, Button profileMenu, Button leaderboard, Button chatMenu,
                                          Button mapSetting, Button logout, Button exit, ImageView buttonBackGround){
        buttonBackGround.setFitWidth(630);
        buttonBackGround.setFitHeight(780);
        buttonBackGround.setLayoutX(445);
        buttonBackGround.setLayoutY(15);

        startGame.setLayoutX(614);
        startGame.setLayoutY(215.7);
        startGame.getStyleClass().add("main-menu-buttons");
        startGame.setPrefSize(312, 38);

        profileMenu.setLayoutX(614);
        profileMenu.setLayoutY(275);
        profileMenu.getStyleClass().add("main-menu-buttons");
        profileMenu.setPrefSize(312, 38);

        leaderboard.setLayoutX(614);
        leaderboard.setLayoutY(332);
        leaderboard.getStyleClass().add("main-menu-buttons");
        leaderboard.setPrefSize(312, 38);

        chatMenu.setLayoutX(614);
        chatMenu.setLayoutY(389.5);
        chatMenu.getStyleClass().add("main-menu-buttons");
        chatMenu.setPrefSize(312, 38);

        mapSetting.setLayoutX(614);
        mapSetting.setLayoutY(447);
        mapSetting.getStyleClass().add("main-menu-buttons");
        mapSetting.setPrefSize(312, 38);

        logout.setLayoutX(614);
        logout.setLayoutY(505);
        logout.getStyleClass().add("main-menu-buttons");
        logout.setPrefSize(312, 38);

        exit.setLayoutX(614);
        exit.setLayoutY(648);
        exit.getStyleClass().add("main-menu-buttons");
        exit.setPrefSize(312, 38);
    }

    private void graphicButtonsAction(Button startGame, Button profileMenu, Button leaderboard, Button chatMenu,
                                      Button mapSetting, Button logout, Button exit){
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            users.writeToJson();
            System.exit(0);
        });
        logout.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            LocalTime localTime = LocalTime.now();
            String lastOnline = localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            user.setLastOnline(lastOnline);
            users.writeToJson();
            user.setActiveUser(false);
            new RegisterMenu(mediaPlayer, stage, scene, images, users).run(new Scanner(System.in));
        });
        profileMenu.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
//            ProfileMenu profileMenu = new ProfileMenu();
//            profileMenu.setStage(stage);
//            profileMenu.setUser(user);
//            profileMenu.setMediaPlayer(mediaPlayer);
//            profileMenu.setScene(scene);
//            profileMenu.setUsers(users);
//            profileMenu.start(stage);
            new ProfileMenu(mediaPlayer,stage,scene,images,users,user).start();
        });
        startGame.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            new GameMenu(mediaPlayer,stage,scene,images,users,user).start();
        });
        leaderboard.addEventHandler(MouseEvent.MOUSE_CLICKED, e-> {
            new Leaderboard(mediaPlayer, stage, scene, images, users, user).run();
        });
        mapSetting.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {

        });
        chatMenu.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {

        });
    }
}
