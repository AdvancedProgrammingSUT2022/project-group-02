package view;

import controller.UsersController;
import javafx.css.PseudoClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.User;
import view.enums.Images;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Leaderboard {

    private UsersController users;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private Scene scene;
    private final Images images = Images.getInstance();
    private User user;

    public Leaderboard(MediaPlayer mediaPlayer, Stage stage, Scene scene, UsersController users, User user){
        this.users = users;
        this.scene = scene;
        this.mediaPlayer = mediaPlayer;
        this.stage = stage;
        this.user = user;
        user.setLastOnline("Online!");
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
        createButton(root);
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
        TableColumn<User, String> avatarColumn = new TableColumn<>("avatar");
        TableColumn<User, String> nameColumn = new TableColumn<>("nickname");
        TableColumn<User, Integer> scoreColumn = new TableColumn<>("Score");
        TableColumn<User, String> lastWinTimeColumn = new TableColumn<>("lastWinTime");
        TableColumn<User, String> lastOnline = new TableColumn<>("lastOnline");
        table.getColumns().add(avatarColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(scoreColumn);
        table.getColumns().add(lastWinTimeColumn);
        table.getColumns().add(lastOnline);
        table.getStyleClass().add("leaderboard");
        ArrayList<User> leaderboardUsers = users.getUsers();
        leaderboardUsers.sort(new   Sort());
        for (User user : leaderboardUsers) {
            table.getItems().add(user);
        }
        avatarColumn.setPrefWidth(100);
        scoreColumn.setPrefWidth(100);
        nameColumn.setPrefWidth(200);
        lastWinTimeColumn.setPrefWidth(150);
        lastOnline.setPrefWidth(150);
        avatarColumn.setCellValueFactory(new PropertyValueFactory<>("avatarUrl"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("winsCount"));
        lastWinTimeColumn.setCellValueFactory(new PropertyValueFactory<>("lastWinTime"));
        lastOnline.setCellValueFactory(new PropertyValueFactory<>("lastOnline"));
        table.setPrefHeight(500);
        vBox.setLayoutX(430);
        vBox.setLayoutY(100);
    }

    private void tableStyle(TableView<User> table){
        PseudoClass Rank1 = PseudoClass.getPseudoClass("Rank1");
        PseudoClass Rank2 = PseudoClass.getPseudoClass("Rank2");
        PseudoClass Rank3 = PseudoClass.getPseudoClass("Rank3");
        PseudoClass activeUser = PseudoClass.getPseudoClass("current-user");
        table.setRowFactory(tv -> {
            TableRow<User> row = new TableRow<>();
            row.itemProperty().addListener((obs, oldItem, newItem) -> {
                if (newItem != null) {
                    int i = 1;
                    for (User item : table.getItems()) {
                        item.setRankInLeaderboard(i);
                        i++;
                    }
                    if (newItem.getRankInLeaderboard() == 1) {
                        row.pseudoClassStateChanged(activeUser, false);
                        row.pseudoClassStateChanged(Rank3, false);
                        row.pseudoClassStateChanged(Rank1, true);
                        row.pseudoClassStateChanged(Rank2, false);
                    } else if (newItem.getRankInLeaderboard() == 2) {
                        row.pseudoClassStateChanged(activeUser, false);
                        row.pseudoClassStateChanged(Rank3, false);
                        row.pseudoClassStateChanged(Rank1, false);
                        row.pseudoClassStateChanged(Rank2, true);
                    } else if (newItem.getRankInLeaderboard() == 3){
                        row.pseudoClassStateChanged(activeUser, false);
                        row.pseudoClassStateChanged(Rank3, true);
                        row.pseudoClassStateChanged(Rank1, false);
                        row.pseudoClassStateChanged(Rank2, false);
                    } else {
                        row.pseudoClassStateChanged(activeUser, false);
                        row.pseudoClassStateChanged(Rank3, false);
                        row.pseudoClassStateChanged(Rank1, false);
                        row.pseudoClassStateChanged(Rank2, false);
                    }
                    if (newItem == user){
                        row.pseudoClassStateChanged(activeUser, true);
                    }
                }
            });
            return row ;
        });
    }

    static class Sort implements Comparator<User> {
        public int compare(User user1, User user2)
        {
            int value1;
            int value2;
            value1 = user2.getWinsCount() - user1.getWinsCount();
            if (value1 == 0) {
                value2 = user2.getLastWinTime().compareTo(user1.getLastWinTime());
                if (value2 == 0) return user1.getNickname().compareTo(user2.getNickname());
                return value2;
            }
            return value1;
        }
    }

    private void createButton(AnchorPane root){
        ImageView back1 = new ImageView(images.submitMenuButton);
        ImageView back2 = new ImageView(images.selectedMenuButton);
        ImageView back3 = new ImageView(images.normalMenuButton);
        Button back = new Button("Back", back1);
        back1.setFitHeight(70);
        back1.setFitWidth(170);
        back2.setFitHeight(70);
        back2.setFitWidth(170);
        back3.setFitHeight(70);
        back3.setFitWidth(170);
        back.setPrefSize(170, 70);
        back.setLayoutY(775);
        back.setContentDisplay(ContentDisplay.CENTER);
        back.getStyleClass().add("back-button");
        root.getChildren().add(back);
        back.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            back.setGraphic(back2);
            back.setEffect(new DropShadow());
            AudioClip clickSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/sounds/click.mp3")).toExternalForm());
            clickSound.play();
        });
        back.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            back.setGraphic(back1);
            back.setEffect(null);
        });
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            back.setGraphic(back3);
            back.setEffect(null);
            AudioClip clickSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/sounds/click.mp3")).toExternalForm());
            clickSound.play();
            new MainMenu(mediaPlayer, stage, scene, images, users).run(user, new Scanner(System.in));
        });
    }

}
