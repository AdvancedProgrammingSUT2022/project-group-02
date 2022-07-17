package view;

import controller.UsersController;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.Maps;
import model.Tile;
import model.User;
import view.enums.Images;

public class GameEnvironment {
    private UsersController users;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private AnchorPane root;
    private static Images images;
    private User user;
    private Maps map;

    public GameEnvironment(MediaPlayer mediaPlayer, Stage stage, Images images, UsersController users, User user){
        this.users = users;
        GameEnvironment.images = images;
        this.mediaPlayer = mediaPlayer;
        this.stage = stage;
        this.user = user;
        map = users.readFromJsonMap();
    }

    public GameEnvironment(){}

    public void run(){
        root = new AnchorPane();
        System.out.println(root.computeAreaInScreen());
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        Scene scene = new Scene(root, 10, 5);
        scene.setRoot(root);
        stage.setScene(scene);
        root.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Style.css")));
        stage.setMaximized(true);
        stage.setFullScreen(true);
        createMap();
    }

    private void createMap(){
        ImageView leftUpCorner = null;
        ImageView rightDownCorner;
        int i = 1;
        for (Tile[] tiles : map.getTileBoard()) {
            for (Tile tile : tiles) {
                Image image = findCell(tile);
                if (image == images.mountainCell && tile.getY() % 2 == 0) {
                    image = images.mountainCell2;
                }
                if (image !=  null) {
                    ImageView imageView = new ImageView(image);
                    imageView.setLayoutX(tile.getY() * 250 - tile.getX() % 2 * 125);
                    imageView.setFitWidth(250);
                    imageView.setLayoutY(tile.getX() * 360 - tile.getX() * 120);
                    imageView.setFitHeight(360);
                    if (tile.getX() == 0 && tile.getY() == 0) leftUpCorner = imageView;
                    if (tile.getX() == 25 && tile.getY() == 79) rightDownCorner = imageView;
                    root.getChildren().add(imageView);
                } else {
                    System.out.println( i + " : An error happened! -> GameEnvironment -> createMap : " + tile.getTerrain().getName());
                    i++;
                }
            }
        }
        ImageView finalLeftUpCorner = leftUpCorner;
        root.setOnScroll(event -> {
            if (event.isControlDown()) {
                if (root.getScaleX() + event.getDeltaY() / 1000 > 0.165 && root.getScaleX() + event.getDeltaY() / 1000 <= 1)
                    root.setScaleX(root.getScaleX() + event.getDeltaY() / 1000);
                if (root.getScaleY() + event.getDeltaY() / 1000 > 0.165 && root.getScaleY() + event.getDeltaY() / 1000 <= 1)
                    root.setScaleY(root.getScaleY() + event.getDeltaY() / 1000);
            } else {
                assert finalLeftUpCorner != null;
                if (root.getTranslateX() + event.getDeltaX() <= finalLeftUpCorner.getLayoutX())
                    root.setTranslateX(root.getTranslateX() + event.getDeltaX());
                root.setTranslateY(root.getTranslateY() + event.getDeltaY());
            }
        });
        /* scale 1 */
        // start y : -96
        // end y : -5408
        // start x : 0
        // end x : -18336
        /* scale 0.968 */
        // start y : -128
        // start x : -32
        /* 608 ###### */
        /* scale 0.936 */
        // start y : -128
        // start x : -64
        /* scale 0.904 */
        // start y : -128
        // start x : -96
        /* scale 0.872 */
        // start y : -160
        // start x : -128
        /* scale  0.16799 */
        // start y : -384
        // end y : -544
        // start x : -640
        // end x : -2432
        /* scale 0.52 */
        // start y : -256
        // start x : -384
    }

    private Image findCell(Tile tile) {
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Jungle")){
            return images.jungleCell;
        }
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


}
