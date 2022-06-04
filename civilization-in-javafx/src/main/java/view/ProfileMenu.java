package view;

import controller.ColorsController;
import controller.UsersController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import view.enums.Colors;
import view.enums.Images;
import view.enums.RegexEnums;
import model.User;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileMenu extends Application {
    private String whichMenu;
    private UsersController users;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private Scene scene;
    private static Images images = new Images();
    private User user;

    public ProfileMenu(MediaPlayer mediaPlayer, Stage stage, Scene scene, Images images, UsersController users,User user) {
        this.users = users;
        ProfileMenu.images = images;
        this.scene = scene;
        this.mediaPlayer = mediaPlayer;
        this.stage = stage;
        this.user = user;
    }
/*graphic part*/
    public void setUsers(UsersController users) {
        this.users = users;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public static void setImages(Images images) {
        ProfileMenu.images = images;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ProfileMenu.class.getResource("/FXML/profile-menu.fxml"));
        BorderPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("PROFILE");
        stage.setScene(scene);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        graphicPlayBackgroundMusic();
        stage.show();
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
    public void run(String input) {
        //String input;
        Matcher matcher;
        manProfileMenu(user);
//        while (true) {
            //input = scanner.nextLine();
            //exit
            if (Pattern.matches("\\s*menu\\s+exit\\s*", input))
                return;
                //show current menu
            else if (Pattern.matches("\\s*menu\\s+show-current\\s*", input))
                System.out.println("Profile");
                //change the nickname
            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_NICKNAME1)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_NICKNAME2)) != null) {
                String nickname = matcher.group("nickname");
                if (users.sameNicknameExists(nickname)) {
                    user.setNickname(nickname);
                    System.out.println("nickname changed successfully!");
                }
                else
                    System.out.println("user with nickname " + nickname + " already exists");
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
                    }
                    else
                        System.out.println("please enter a new password");
                }
                else
                    System.out.println("current password is invalid");

        }
    }
    /*graphic part*/

    @FXML
    private TextField currentPassword;
    @FXML
    private TextField newPassword;
    @FXML
    private TextField newNickName;

    public void exitClicked(MouseEvent mouseEvent) {
        run("menu exit");
    }

    public void changePasswordClicked(MouseEvent mouseEvent) {
        run("profile change -p -c "+ currentPassword.getText() + "-n " + newPassword.getText());
    }

    public void changeNickNameClicked(MouseEvent mouseEvent) {
        run("profile change -n " + newNickName.getText());
    }

    public void graphicPlayBackgroundMusic(){
        String path = String.valueOf(this.getClass().getResource("/Media/background themes/background-music.mp3"));
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(100);
    }
    /*end of graphic part*/

}
