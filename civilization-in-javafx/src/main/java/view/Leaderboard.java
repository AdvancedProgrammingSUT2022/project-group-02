package view;

import controller.UsersController;
import javafx.css.PseudoClass;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.User;
import view.enums.Images;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Leaderboard {

    private UsersController users;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private Scene scene;
    private static Images images;

    public Leaderboard(MediaPlayer mediaPlayer, Stage stage, Scene scene, Images images, UsersController users){
        this.users = users;
        Leaderboard.images = images;
        this.scene = scene;
        this.mediaPlayer = mediaPlayer;
        this.stage = stage;
    }

    public Leaderboard(){}

    public void run(){
        URL fxmlAddress = getClass().getResource("/Fxml/leaderboard.fxml");
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
        createTable(root);
    }

    private void createTable(AnchorPane root){
        TableView<User> table = new TableView<>();
        VBox vBox = new VBox(table);
        tableInitialise(table, vBox);
        tableStyle(table);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        root.getChildren().add(vBox);
    }

    private void tableInitialise(TableView<User> table, VBox vBox){
        TableColumn<User, String> nameColumn = new TableColumn<>("nickname");
        TableColumn<User, Integer> scoreColumn = new TableColumn<>("Score");
        TableColumn<User, String> lastWinTimeColumn = new TableColumn<>("WinTime");
        table.getColumns().add(nameColumn);
        table.getColumns().add(scoreColumn);
        table.getColumns().add(lastWinTimeColumn);
        table.getStyleClass().add("leaderboard");
        ArrayList<User> leaderboardUsers = users.getUsers();
        leaderboardUsers.sort(new   Sort());
        for (User user : leaderboardUsers) {
            table.getItems().add(user);
        }
        scoreColumn.setPrefWidth(100);
        nameColumn.setPrefWidth(200);
        lastWinTimeColumn.setPrefWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("winsCount"));
        lastWinTimeColumn.setCellValueFactory(new PropertyValueFactory<>("lastWinTimeString"));
        table.setPrefHeight(500);
        vBox.setLayoutX(500);
        vBox.setLayoutY(100);
    }

    private void tableStyle(TableView<User> table){
        
    }

    static class Sort implements Comparator<User> {
        public int compare(User user1, User user2)
        {
            int value1;
            int value2;
            value1 = user2.getWinsCount() - user1.getWinsCount();
            if (value1 == 0) {
                if (user1.getLastWinTime().isBefore(user2.getLastWinTime())) value2 = -1;
                else if (user1.getLastWinTime().isAfter(user2.getLastWinTime())) value2 = 1;
                else {
                    return user1.getNickname().compareTo(user2.getNickname());
                }
                return value2;
            }
            return value1;
        }
    }

}
