package controller;

import model.Terrain;
import model.Tile;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import view.enums.Colors;

import java.util.ArrayList;
import java.util.HashMap;

public class ColorControllerTest {
    ArrayList<String> colors = new ArrayList<>();
    HashMap<String, String> colorsHashMap = new HashMap<>();
    ColorsController colorsController = new ColorsController();
    User user1 = new User("AmirHossein", "AmirHossein", "AmirHossein12");
    Terrain Desert = new Terrain("Desert", "yellow", 1, 0, -0.33, 0, 0, true);
    Tile tile = new Tile(0, 0, user1, Desert, 1, false, null, null, null);

    @Before
    public void Setup() {
        colors.add("white");
        colors.add("black");
        colors.add("green");
        colors.add("red");
        colors.add("yellow");
        colors.add("purple");
        colors.add("cyan");
        colors.add("blue");
        colors.add("brightBlue");
        colors.add("brightBlack");
        colors.add("something");
        colorsHashMap.put("white", Colors.WHITE);
        colorsHashMap.put("black", Colors.BLACK);
        colorsHashMap.put("green", Colors.GREEN);
        colorsHashMap.put("red", Colors.RED);
        colorsHashMap.put("yellow", Colors.YELLOW);
        colorsHashMap.put("purple", Colors.PURPLE);
        colorsHashMap.put("cyan", Colors.CYAN);
        colorsHashMap.put("blue", Colors.BLUE);
        colorsHashMap.put("brightBlue", Colors.BLUE_BACKGROUND_BRIGHT);
        colorsHashMap.put("brightBlack", Colors.BLACK_BACKGROUND_BRIGHT);
        colorsHashMap.put("something", Colors.BLACK);
    }

    @Test //get Color terminal code with color string
    public void checkGetColorOfString() {
        colorsHashMap.put("brightBlue", Colors.BLACK);
        colorsHashMap.put("brightBlack", Colors.BLACK);
        for (String color : colors) {
            Assertions.assertEquals(colorsController.getColorOfString(color), colorsHashMap.get(color));
        }
    }


    @Test //get Color terminal code with user color
    public void checkGetColorOfUser() {
        colorsHashMap.put("white", Colors.BLUE);
        colorsHashMap.put("brightBlue", Colors.BLUE);
        colorsHashMap.put("brightBlack", Colors.BLUE);
        colorsHashMap.put("something", Colors.BLUE);
        for (String color : colors) {
            user1.setColor(color);
            Assertions.assertEquals(colorsController.getColorOfUser(user1), colorsHashMap.get(color));
        }
    }

    @Test //get Color terminal code for background
    public void checkGetColorOfTile(){
        colorsHashMap.put("red", Colors.RED_BACKGROUND);
        colorsHashMap.put("yellow", Colors.YELLOW_BACKGROUND);
        colorsHashMap.put("purple", Colors.PURPLE_BACKGROUND);
        colorsHashMap.put("green", Colors.GREEN_BACKGROUND);
        colorsHashMap.put("cyan", Colors.CYAN_BACKGROUND_BRIGHT);
        colorsHashMap.put("white", Colors.WHITE_BACKGROUND_BRIGHT);
        colorsHashMap.put("brightBlack", Colors.BLACK_BACKGROUND_BRIGHT);
        colorsHashMap.put("brightBlue", Colors.BLUE_BACKGROUND_BRIGHT);
        colorsHashMap.put("something", Colors.GREEN_BACKGROUND_BRIGHT);
        colorsHashMap.put("blue", Colors.GREEN_BACKGROUND_BRIGHT);
        colorsHashMap.put("black", Colors.GREEN_BACKGROUND_BRIGHT);
        for (String color : colors) {
            tile.getTerrain().setColor(color);
            Assertions.assertEquals(colorsController.getColorOfTile(tile), colorsHashMap.get(color));
        }
    }
}