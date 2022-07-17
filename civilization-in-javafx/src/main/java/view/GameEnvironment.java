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
        int i = 1;
        for (Tile[] tiles : map.getTileBoard()) {
            for (Tile tile : tiles) {
                Image TileResourceImage = findResource(tile);
                Image TileTerrainImage = findCell(tile);
                Image TileFeatureImage = findFeature(tile);
                if (TileTerrainImage == images.mountainCell && tile.getY() % 2 == 0) TileTerrainImage = images.mountainCell2;
                if (TileTerrainImage !=  null) {
                    ImageView imageView = new ImageView(TileTerrainImage);
                    imageView.setLayoutX(tile.getY() * 250 - tile.getX() % 2 * 125);
                    imageView.setFitWidth(250);
                    imageView.setLayoutY(tile.getX() * 360 - tile.getX() * 120);
                    imageView.setFitHeight(360);
                    root.getChildren().add(imageView);
                    if(TileResourceImage != null) {
                        ImageView resourceView = new ImageView(TileResourceImage);
                        resourceView.setLayoutX(imageView.getLayoutX() + 25);
                        resourceView.setLayoutY(imageView.getLayoutY() + 60);
                        resourceView.setFitWidth(90);
                        resourceView.setFitHeight(90);
                        root.getChildren().add(resourceView);
                    }
//                    if (TileFeatureImage != null) {
//                        ImageView featureView = new ImageView(TileFeatureImage);
//                        featureView.setLayoutX(imageView.getLayoutX() + 135);
//                        featureView.setLayoutY(imageView.getLayoutY() + 60);
//                        featureView.setFitWidth(90);
//                        featureView.setFitHeight(90);
//                        root.getChildren().add(featureView);
//                    }
                } else {
                    System.out.println( i + " : An error happened! -> GameEnvironment -> createMap : " + tile.getTerrain().getName());
                    i++;
                }
            }
        }
        root.setOnScroll(event -> {
            if (event.isControlDown()) {
                if (root.getScaleX() + event.getDeltaY() / 1000 > 0.165 && root.getScaleX() + event.getDeltaY() / 1000 <= 1)
                    root.setScaleX(root.getScaleX() + event.getDeltaY() / 1000);
                if (root.getScaleY() + event.getDeltaY() / 1000 > 0.165 && root.getScaleY() + event.getDeltaY() / 1000 <= 1)
                    root.setScaleY(root.getScaleY() + event.getDeltaY() / 1000);
            } else {
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
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Jungle")) return images.jungleCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Forest")) return images.forestCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Ice")) return images.iceCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Marsh")) return images.marshCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("FloodPlain")) return images.floodPlainCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Oasis")) return images.oasisCell;
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

    private Image findResource(Tile tile) {
        if (tile.getResource() == null)return null;
        return switch (tile.getResource().getName()) {
            case "Banana" -> images.banana;
            case "Cow" -> images.cow;
            case "Gazelle" -> images.deer;
            case "Wheat" -> images.wheat;
            case "Sheep" -> images.sheep;
            case "Coal" -> images.coal;
            case "Horse" -> images.horse;
            case "Iron" -> images.iron;
            case "Cotton" -> images.cotton;
            case "Color" -> images.color;
            case "Fur" -> images.fur;
            case "Gemstones" -> images.gemStone;
            case "Gold" -> images.gold;
            case "Fumigation" -> images.fumigation;
            case "Silk" -> images.silk;
            case "Sugar" -> images.sugar;
            case "Silver" -> images.silver;
            case "Marble" -> images.marble;
            case "Ivory" -> images.ivory;
            default -> null;
        };
    }

    private Image findFeature(Tile tile) {
        if (tile.getFeature() == null)return null;
        return switch (tile.getFeature().getName()) {
            case "Marsh" -> images.marsh;
            case "FloodPlain" -> images.floodPlain;
            case "Oasis" -> images.oasis;
            case "Ice" -> images.ice;
            case "Jungle" -> images.jungle;
            case "forest" -> images.forest;
            default -> null;
        };
    }

}
