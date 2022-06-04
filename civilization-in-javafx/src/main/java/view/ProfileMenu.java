package view;

import controller.ColorsController;
import controller.UsersController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import view.enums.Colors;
import view.enums.Images;
import view.enums.RegexEnums;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileMenu {
    private String whichMenu;
    private UsersController users;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private Scene scene;
    private static Images images = new Images();
    private User user;

    public ProfileMenu(MediaPlayer mediaPlayer, Stage stage, Scene scene, Images images, UsersController users, User user) {
        this.users = users;
        ProfileMenu.images = images;
        this.scene = scene;
        this.mediaPlayer = mediaPlayer;
        this.stage = stage;
        this.user = user;
    }
    /*graphic part*/
//    public void setUsers(UsersController users) {
//        this.users = users;
//    }
//
//    public void setMediaPlayer(MediaPlayer mediaPlayer) {
//        this.mediaPlayer = mediaPlayer;
//    }
//
//    public void setStage(Stage stage) {
//        this.stage = stage;
//    }
//
//    public void setScene(Scene scene) {
//        this.scene = scene;
//    }
//
//    public static void setImages(Images images) {
//        ProfileMenu.images = images;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    // @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(ProfileMenu.class.getResource("/FXML/profile-menu.fxml"));
//        BorderPane root = fxmlLoader.load();
//        Scene scene = new Scene(root);
//        stage.setTitle("PROFILE");
//        stage.setScene(scene);
//        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
//        stage.setMaximized(true);
//        stage.setFullScreen(true);
//        graphicPlayBackgroundMusic();
//    }

    public void start() {
//        URL fxmlAddress = getClass().getResource("/FXML/profile-menu.fxml");
//        if (fxmlAddress == null)System.exit(0);
//        assert fxmlAddress != null;
//        AnchorPane root = null;
//        try {
//            root = FXMLLoader.load(fxmlAddress);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (root == null){
//            System.out.println("root");
//            System.exit(0);
//        }
//        if (scene == null){
//            System.out.println("scene");
//            System.exit(0);
//        }
//        assert root != null;
//        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
//        scene.setRoot(root);
//        stage.setScene(scene);
//        stage.setMaximized(true);
//        stage.setFullScreen(true);
//        graphicButtons(root);
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
        Button changePassword = new Button("CHAMGEPASSWORD");
        Button changeNickname = new Button("CHANGENICKNAME");
        Button exit = new Button("EXIT");
        TextField currentPassword = new TextField();
        TextField newPassword = new TextField();
        TextField newNickName = new TextField();
        Label message = new Label();
        Rectangle background = new Rectangle(550, 165, 450, 550);
        background.setFill(new Color(0, 0, 0, 0.5));
        graphicInitialiseButtons(changePassword, changeNickname, exit, currentPassword, newPassword, newNickName, message, buttonBackground);
        root.getChildren().add(background);
        root.getChildren().add(buttonBackground);
        root.getChildren().add(changePassword);
        root.getChildren().add(changeNickname);
        root.getChildren().add(exit);
        root.getChildren().add(currentPassword);
        root.getChildren().add(newPassword);
        root.getChildren().add(newNickName);
        root.getChildren().add(message);
        graphicButtonsAction(changePassword, changeNickname, exit, currentPassword, newPassword, newNickName, message);
    }

    private void graphicInitialiseButtons(Button changePassword, Button changeNickname, Button exit,
                                          TextField currentPassword, TextField newPassword, TextField newNickName,
                                          Label message, ImageView buttonBackGround) {
        buttonBackGround.setFitWidth(630);
        buttonBackGround.setFitHeight(780);
        buttonBackGround.setLayoutX(445);
        buttonBackGround.setLayoutY(15);

        message.setLayoutX(614);
        message.setLayoutY(150);
        message.getStyleClass().add("register-signup-and-login-error");
        message.setPrefSize(312, 38);
        message.setEffect(new DropShadow());

        currentPassword.setPromptText("CurrentPassword");
        currentPassword.setLayoutX(614);
        currentPassword.setLayoutY(215.7);
        currentPassword.getStyleClass().add("profile-text-field");
        currentPassword.setPrefSize(312, 38);

        newPassword.setPromptText("NewPassword");
        newPassword.setLayoutX(614);
        newPassword.setLayoutY(275);
        newPassword.getStyleClass().add("profile-text-field");
        newPassword.setPrefSize(312, 38);

        changePassword.setLayoutX(614);
        changePassword.setLayoutY(332);
        changePassword.getStyleClass().add("main-menu-buttons");
        changePassword.setPrefSize(312, 38);

        newNickName.setPromptText("NewNickname");
        newNickName.setLayoutX(614);
        newNickName.setLayoutY(389.5);
        newNickName.getStyleClass().add("profile-text-field");
        newNickName.setPrefSize(312, 38);

        changeNickname.setLayoutX(614);
        changeNickname.setLayoutY(447);
        changeNickname.getStyleClass().add("main-menu-buttons");
        changeNickname.setPrefSize(312, 38);

        exit.setLayoutX(614);
        exit.setLayoutY(505);
        exit.getStyleClass().add("main-menu-buttons");
        exit.setPrefSize(312, 38);
    }

    private void graphicButtonsAction(Button changePassword, Button changeNickname, Button exit,
                                      TextField currentPassword, TextField newPassword, TextField newNickName,
                                      Label message) {
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            new MainMenu(mediaPlayer, stage, scene, images, users).run(user, new Scanner(System.in));
        });
        changePassword.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            changePasswordClicked(currentPassword, newPassword, message);
        });
        changeNickname.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            changeNickNameClicked(newNickName, message);
        });
    }

    /*end of graphic part*/
    //provide some information for user
    private void manProfileMenu(User user) {
        String userColor = new ColorsController().getColorOfUser(user);
        String boldColor = Colors.YELLOW_BOLD;
        String color = Colors.CYAN;
        System.out.println("welcome to Profile Menu dear " + userColor + user.getUsername() + Colors.RESET + "!");
        System.out.println(boldColor + "to change nickname :" + Colors.RESET);
        System.out.println(color + "profile change --nickname <new nickname>");
        System.out.println("profile change -n <new nickname" + Colors.RESET);
        System.out.println(boldColor + "to change password :" + Colors.RESET);
        System.out.println(color + "profile change --password --current <current password> --new <new password>");
        System.out.println("profile change -p -c <current password> -n <new password>" + Colors.RESET);
    }

    public String run(String input) {
        //String input;
        Matcher matcher;
        //manProfileMenu(user);
//        while (true) {
        //input = scanner.nextLine();
        //exit
//            if (Pattern.matches("\\s*menu\\s+exit\\s*", input))
//                return;
        //show current menu
        if (Pattern.matches("\\s*menu\\s+show-current\\s*", input))
            System.out.println("Profile");
            //change the nickname
        else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_NICKNAME1)) != null ||
                (matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_NICKNAME2)) != null) {
            String nickname = matcher.group("nickname");
            if (!users.sameNicknameExists(nickname)) {
                user.setNickname(nickname);
                System.out.println("nickname changed successfully!");
                return "nickname changed successfully!";
            } else {
                System.out.println("user with nickname " + nickname + " already exists");
                return "user with nickname " + nickname + " already exists";
            }
        }
        //change the password
        else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_PASSWORD1)) != null ||
                (matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_PASSWORD2)) != null ||
                (matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_PASSWORD3)) != null ||
                (matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_PASSWORD4)) != null) {
            String currentPassword = matcher.group("currentPassword");
            String newPassword = matcher.group("newPassword");
            //if the current username has entered correctly
            if (user.getPassword().equals(currentPassword)) {
                //if two username are not the same
                if (!newPassword.equals(currentPassword)) {
                    user.setPassword(newPassword);
                    System.out.println("password changed successfully!");
                    return "password changed successfully!";
                } else {
                    System.out.println("please enter a new password");
                    return "please enter a new password";
                }
            } else {
                System.out.println("current password is invalid");
                return "current password is invalid";
            }

        }
        return "";
    }
    /*graphic part*/

//    @FXML
//    private TextField currentPassword;
//    @FXML
//    private TextField newPassword;
//    @FXML
//    private TextField newNickName;

    //    public void exitClicked(MouseEvent mouseEvent) {
//        run("menu exit");
//    }
//
    public void changePasswordClicked(TextField currentPassword, TextField newPassword, Label message) {
        String status = run("profile change -p -c " + currentPassword.getText() + " -n " + newPassword.getText());
        message.setText(status);
    }

    public void changeNickNameClicked(TextField newNickName, Label message) {
        String status = run("profile change -n " + newNickName.getText());
        message.setText(status);
    }

    public void graphicPlayBackgroundMusic() {
        String path = String.valueOf(this.getClass().getResource("/Media/background themes/background-music.mp3"));
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(100);
    }
    /*end of graphic part*/

}
