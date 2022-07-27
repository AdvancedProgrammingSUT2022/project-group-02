package view;

import controller.ColorsController;
import controller.NetworkController;
import controller.UsersController;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Request;
import model.Response;
import view.enums.Colors;
import view.enums.Images;
import view.enums.RegexEnums;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileMenu {
    public final Images images = Images.getInstance();
    private String whichMenu;
    private UsersController users;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private Scene scene;
    private User user;

    public ProfileMenu(MediaPlayer mediaPlayer, Stage stage, Scene scene, UsersController users, User user) {
        this.users = users;
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
        graphicButtons(root);
    }

    private void graphicButtons(AnchorPane root) {
        ImageView buttonBackground = new ImageView(images.mainMenuButtonBackGround);
        Button changePassword = new Button("Change Password");
        Button changeNickname = new Button("Change Nickname");
        Button changeAvatar = new Button("Change Avatar");
        Button exit = new Button("exit");
        TextField currentPassword = new TextField();
        TextField newPassword = new TextField();
        TextField newNickName = new TextField();
        Label message = new Label();
        Rectangle background = new Rectangle(550, 165, 450, 550);
        background.setFill(new Color(0, 0, 0, 0.5));
        graphicInitialiseButtons(changePassword, changeNickname, changeAvatar,exit, currentPassword, newPassword, newNickName, message, buttonBackground);
        root.getChildren().add(background);
        root.getChildren().add(buttonBackground);
        root.getChildren().add(changePassword);
        root.getChildren().add(changeNickname);
        root.getChildren().add(changeAvatar);
        root.getChildren().add(exit);
        root.getChildren().add(currentPassword);
        root.getChildren().add(newPassword);
        root.getChildren().add(newNickName);
        root.getChildren().add(message);
        graphicButtonsAction(changePassword, changeNickname, changeAvatar,exit, currentPassword, newPassword, newNickName, message);
    }

    private void graphicInitialiseButtons(Button changePassword, Button changeNickname, Button changeAvatar,Button exit,
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
        currentPassword.getStyleClass().add("search-friend-text-field");
        currentPassword.setPrefSize(312, 38);

        newPassword.setPromptText("NewPassword");
        newPassword.setLayoutX(614);
        newPassword.setLayoutY(275);
        newPassword.getStyleClass().add("search-friend-text-field");
        newPassword.setPrefSize(312, 38);

        changePassword.setLayoutX(614);
        changePassword.setLayoutY(332);
        changePassword.getStyleClass().add("main-menu-buttons");
        changePassword.setPrefSize(312, 38);

        newNickName.setPromptText("NewNickname");
        newNickName.setLayoutX(614);
        newNickName.setLayoutY(389.5);
        newNickName.getStyleClass().add("search-friend-text-field");
        newNickName.setPrefSize(312, 38);

        changeNickname.setLayoutX(614);
        changeNickname.setLayoutY(447);
        changeNickname.getStyleClass().add("main-menu-buttons");
        changeNickname.setPrefSize(312, 38);

        changeAvatar.setLayoutX(614);
        changeAvatar.setLayoutY(505);
        changeAvatar.getStyleClass().add("main-menu-buttons");
        changeAvatar.setPrefSize(312, 38);

        exit.setLayoutX(614);
        exit.setLayoutY(648);
        exit.getStyleClass().add("main-menu-buttons");
        exit.setPrefSize(312, 38);
    }

    private void graphicButtonsAction(Button changePassword, Button changeNickname, Button changeAvatar,Button exit,
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
        changeAvatar.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            //todo : make a menu to select avatar
            selectAvatarView(user);
        });
    }

    public void selectAvatarView(User user){
        URL fxmlAddress = getClass().getResource("/Fxml/main-menu.fxml");
        if (fxmlAddress == null) System.exit(0);
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
        graphicPlayBackgroundMusic();
        Rectangle background = new Rectangle(550, 165, 500, 504);
        background.setFill(new Color(0, 0, 0, 0.5));
        Rectangle avatar1 = new Rectangle(560,220,118,124);
        ImagePattern avatar1Image = new ImagePattern(images.avatar1);
        avatar1.setFill(avatar1Image);
        avatar1.setCursor(Cursor.HAND);
        avatar1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                user.setAvatarUrl("/Media/avatars/avatar1.png");
        });
        Rectangle avatar2 = new Rectangle(680,220,118,124);
        ImagePattern avatar2Image = new ImagePattern(images.avatar2);
        avatar2.setFill(avatar2Image);
        avatar2.setCursor(Cursor.HAND);
        avatar2.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                user.setAvatarUrl("/Media/avatars/avatar2.png");
        });
        Rectangle avatar3 = new Rectangle(800,220,118,124);
        ImagePattern avatar3Image = new ImagePattern(images.avatar3);
        avatar3.setFill(avatar3Image);
        avatar3.setCursor(Cursor.HAND);
        avatar3.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                user.setAvatarUrl("/Media/avatars/avatar3.png");
        });
        Rectangle avatar4 = new Rectangle(920,220,118,124);
        ImagePattern avatar4Image = new ImagePattern(images.avatar4);
        avatar4.setFill(avatar4Image);
        avatar4.setCursor(Cursor.HAND);
        avatar4.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                user.setAvatarUrl("/Media/avatars/avatar4.png");
        });
        Rectangle avatar5 = new Rectangle(560,350,118,124);
        ImagePattern avatar5Image = new ImagePattern(images.avatar5);
        avatar5.setFill(avatar5Image);
        avatar5.setCursor(Cursor.HAND);
        avatar5.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                user.setAvatarUrl("/Media/avatars/avatar5.png");
        });
        Rectangle avatar6 = new Rectangle(680,350,118,124);
        ImagePattern avatar6Image = new ImagePattern(images.avatar6);
        avatar6.setFill(avatar6Image);
        avatar6.setCursor(Cursor.HAND);
        avatar6.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                user.setAvatarUrl("/Media/avatars/avatar6.png");
        });
        Rectangle avatar7 = new Rectangle(800,350,118,124);
        ImagePattern avatar7Image = new ImagePattern(images.avatar7);
        avatar7.setFill(avatar7Image);
        avatar7.setCursor(Cursor.HAND);
        avatar7.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                user.setAvatarUrl("/Media/avatars/avatar7.png");
        });
        Rectangle avatar8 = new Rectangle(920,350,118,124);
        ImagePattern avatar8Image = new ImagePattern(images.avatar8);
        avatar8.setFill(avatar8Image);
        avatar8.setCursor(Cursor.HAND);
        avatar8.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                user.setAvatarUrl("/Media/avatars/avatar8.png");
        });
        Rectangle avatar9 = new Rectangle(680,480,118,124);
        ImagePattern avatar9Image = new ImagePattern(images.avatar9);
        avatar9.setFill(avatar9Image);
        avatar9.setCursor(Cursor.HAND);
        avatar9.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                user.setAvatarUrl("/Media/avatars/avatar9.png");
        });
        Rectangle avatar10 = new Rectangle(800,480,118,124);
        ImagePattern avatar10Image = new ImagePattern(images.avatar10);
        avatar10.setFill(avatar10Image);
        avatar10.setCursor(Cursor.HAND);
        avatar10.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> user.setAvatarUrl("/Media/avatars/avatar10.png"));
        Button back = new Button("BACK");
        back.setLayoutX(614);
        back.setLayoutY(800);
        back.getStyleClass().add("main-menu-buttons");
        back.setPrefSize(312, 38);
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            start();
        });
        root.getChildren().add(background);
        root.getChildren().add(avatar1);
        root.getChildren().add(avatar2);
        root.getChildren().add(avatar3);
        root.getChildren().add(avatar4);
        root.getChildren().add(avatar5);
        root.getChildren().add(avatar6);
        root.getChildren().add(avatar7);
        root.getChildren().add(avatar8);
        root.getChildren().add(avatar9);
        root.getChildren().add(avatar10);
        root.getChildren().add(back);
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
