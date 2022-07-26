package view;

import controller.NetworkController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import view.enums.Images;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main extends Application {

    private MediaPlayer mediaPlayer;
    private MediaView mediaView;
    private static Images images;
    public static Scene scene;

    @Override
    public void start(Stage stage){
        AtomicBoolean startGame = new AtomicBoolean(false);
        images = new Images();
        AnchorPane root = new AnchorPane();
        playOpeningVideo();
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root);
        Main.scene = scene;
        stage.setScene(scene);
        mediaPlayer.setAutoPlay(true);
        stage.setTitle("Civilization V");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        scene.setOnKeyPressed(e ->{
            if (!startGame.get()) {
                startGame.set(true);
                mediaPlayer.stop();
                graphicPlayRegisterBackgroundMusic();
                new RegisterMenu(mediaPlayer, stage, scene).run();
            }
        });
        stage.show();
    }

    public static void main(String[] args) {
        NetworkController.getInstance().initialize();
        launch();
    }

    private void playOpeningVideo(){
        String path = String.valueOf(this.getClass().getResource("/Media/background and videos/opening video.mp4"));
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaView = new MediaView(mediaPlayer);
        final DoubleProperty width = mediaView.fitWidthProperty();
        final DoubleProperty height = mediaView.fitHeightProperty();
        width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
        mediaView.setPreserveRatio(true);
    }

    public void graphicPlayRegisterBackgroundMusic(){
        String path = String.valueOf(this.getClass().getResource("/Media/background themes/background-music.mp3"));
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(100);
    }
}