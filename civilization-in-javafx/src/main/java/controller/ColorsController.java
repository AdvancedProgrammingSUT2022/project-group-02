package controller;

import view.enums.Colors;
import model.Tile;
import model.User;

public class ColorsController {

    private static ColorsController colorsController;

    public static ColorsController getInstance() {
        if (colorsController == null)
            colorsController = new ColorsController();
        return colorsController;
    }

    public String getColorOfString(String color){
        return switch (color) {
            case "white" -> Colors.WHITE;
            case "green" -> Colors.GREEN;
            case "red" -> Colors.RED;
            case "yellow" -> Colors.YELLOW;
            case "purple" -> Colors.PURPLE;
            case "cyan" -> Colors.CYAN;
            case "blue" -> Colors.BLUE;
            default -> Colors.BLACK;
        };
    }

    public String getColorOfUser(User user) {
        String ANSI_COLOR = Colors.BLUE;
        if (user == null) return ANSI_COLOR;
        else if (user.getColor().equals("black")) ANSI_COLOR = Colors.BLACK;
        else if (user.getColor().equals("green")) ANSI_COLOR = Colors.GREEN;
        else if (user.getColor().equals("red")) ANSI_COLOR = Colors.RED;
        else if (user.getColor().equals("yellow")) ANSI_COLOR = Colors.YELLOW;
        else if (user.getColor().equals("purple")) ANSI_COLOR = Colors.PURPLE;
        else if (user.getColor().equals("cyan")) ANSI_COLOR = Colors.CYAN;
        else if (user.getColor().equals("blue")) ANSI_COLOR = Colors.BLUE;
        return ANSI_COLOR;
    }

    public String getColorOfTile(Tile tile) {
        return switch (tile.getTerrain().getColor()) {
            case "red" -> Colors.RED_BACKGROUND;
            case "yellow" -> Colors.YELLOW_BACKGROUND;
            case "purple" -> Colors.PURPLE_BACKGROUND;
            case "green" -> Colors.GREEN_BACKGROUND;
            case "cyan" -> Colors.CYAN_BACKGROUND_BRIGHT;
            case "brightBlue" -> Colors.BLUE_BACKGROUND_BRIGHT;
            case "brightBlack" -> Colors.BLACK_BACKGROUND_BRIGHT;
            case "white" -> Colors.WHITE_BACKGROUND_BRIGHT;
            default -> Colors.GREEN_BACKGROUND_BRIGHT;
        };
    }
}
