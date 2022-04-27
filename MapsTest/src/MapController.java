public class MapController {

    private Tile[][] tileBoard;

    public MapController(Tile[][] tileBoard) {
        this.tileBoard = tileBoard;
    }

    public void setTileBoard(Tile[][] tileBoard) {
        this.tileBoard = tileBoard;
    }

    public void printMap() {
        String ANSI_COLOR;
        //first top sides of left tiles of game board
        for (int j = 0; j < 4; j++)
            System.out.print("   " + riverFinder(tileBoard[0][j], 0) + "              ");
        System.out.println();

        //print the game board
        for (int i = 0; i < 4; i++) {

            leftCoordinatesPlace(i);

            leftOwnerName(i);

            //units on the left tiles and top sides of right tiles
            for (int j = 0; j < 4; j++) {
                ANSI_COLOR = getColorOfTileOwner(tileBoard[2 * i][j]);
                System.out.print(riverFinder(tileBoard[2 * i][j], 5) + "    "
                        + ANSI_COLOR + civilianUnit(tileBoard[2 * i][j])
                        + "   " + ANSI_COLOR+militaryUnit(tileBoard[2 * i][j]) + "    "
                        + Colors.RESET+ Colors.RESET + riverFinder(tileBoard[2 * i][j], 1)
                );
                if (i != 0) System.out.print(riverFinder(tileBoard[2 * i - 1][j], 3));
                else System.out.print(riverFinder(tileBoard[1][j], 0));
            }
            if (i != 0) System.out.println(riverFinder(tileBoard[2 * i][3], 2));
            else System.out.println();

            leftResourceAndTerrain(i);

            rightOwnerName(i);

            leftBottomSides(i);

        }

    }

    private void leftCoordinatesPlace(int i) {

        //Coordinates of left tiles and resource and terrain in right tiles
        for (int j = 0; j < 4; j++) {
            if (i != 0)
                System.out.print("  " + riverFinder(tileBoard[2 * i][j], 5)
                        + getColorOfTile(tileBoard[2 * i][j]) + "   [" + 2 * i + "," + j + "]   "
                        + Colors.RESET + riverFinder(tileBoard[2 * i][j], 1)
                        + "    " + tileResource(tileBoard[2 * i - 1][j], true)
                        + "   " + tileTerrain(tileBoard[2 * i - 1][j], true) + "  ");
            else System.out.print("  " + riverFinder(tileBoard[2 * i][j], 5)
                    + getColorOfTile(tileBoard[2 * i][j])
                    + "   [" + 0 + "," + j + "]   " + Colors.RESET + riverFinder(tileBoard[2 * i][j], 1) + "             ");
        }
        if (i != 0) System.out.println("  " + riverFinder(tileBoard[2 * i - 1][3], 2));
        else System.out.println();

    }

    private void leftOwnerName(int i) {
        String ANSI_COLOR = Colors.WHITE;

        //owner name and color of left tiles
        for (int j = 0; j < 4; j++) {
            ANSI_COLOR = getColorOfTileOwner(tileBoard[2 * i][j]);
            if (i != 0)
                System.out.print(" " + riverFinder(tileBoard[2 * i][j], 5)
                        + "     " + ANSI_COLOR + tileOwner(tileBoard[2 * i][j]) + Colors.RESET + "     "
                        + riverFinder(tileBoard[2 * i][j], 1)
                        + "     " + tileImprovement(tileBoard[2 * i - 1][j]) + "    ");
            else System.out.print(" " + riverFinder(tileBoard[2 * i][j], 5)
                    + "     " + ANSI_COLOR + tileOwner(tileBoard[2 * i][j]) + Colors.RESET + "     "
                    + riverFinder(tileBoard[2 * i][j], 1)
                    + "            ");
        }
        if (i != 0) System.out.println(" " + riverFinder(tileBoard[2 * i][0], 2));
        else System.out.println();

    }

    private void leftResourceAndTerrain(int i) {

        //resource and terrain in left tiles and Coordinates of right tiles
        for (int j = 0; j < 4; j++) {
            if (i != 3)
                System.out.print(riverFinder(tileBoard[2 * i][j], 4)
                        + "    " + tileResource(tileBoard[2 * i][j], false)
                        + "   " + tileTerrain(tileBoard[2 * i][j], false)
                        + "    " + riverFinder(tileBoard[2 * i][j], 2)
                        + getColorOfTile(tileBoard[2 * i+1][j]) + "   [" + (2 * i + 1) + "," + j + "]   " + Colors.RESET);
            else System.out.print(riverFinder(tileBoard[2 * i][j], 4)
                    + "    " + tileResource(tileBoard[2 * i][j], false)
                    + "   " + tileTerrain(tileBoard[2 * i][0], false) + "    "
                    + riverFinder(tileBoard[2 * i][j], 2) + "           ");
        }
        if (i != 3) System.out.println(riverFinder(tileBoard[2 * i + 1][3], 1));
        else System.out.println();

    }

    private void rightOwnerName(int i) {
        String ANSI_COLOR = Colors.WHITE;

        //owner name and color of right tiles
        for (int j = 0; j < 4; j++) {
            ANSI_COLOR = getColorOfTileOwner(tileBoard[2 * i][j]);

            if (i != 3)
                System.out.print(" " + riverFinder(tileBoard[2 * i][j], 4)
                        + "     " + tileImprovement(tileBoard[2 * i][j])
                        + "     " + riverFinder(tileBoard[2 * i][j], 2)
                        + "     " + ANSI_COLOR + tileOwner(tileBoard[2 * i][j]) + Colors.RESET + "    ");
            else System.out.print(" " + riverFinder(tileBoard[2 * i][j], 4)
                    + "     " + tileImprovement(tileBoard[2 * i][j])
                    + "     " + riverFinder(tileBoard[2 * i][j], 2) + "            ");
        }
        if (i != 3) System.out.println(" " + riverFinder(tileBoard[2 * i + 1][3], 1));
        else System.out.println();

    }

    private void leftBottomSides(int i) {
        String ANSI_COLOR = Colors.WHITE;

        //bottom sides of left tiles and units on the right tiles
        for (int j = 0; j < 4; j++) {
            if (i != 3)ANSI_COLOR = getColorOfTileOwner(tileBoard[2 * i + 1][j]);

            if (i != 3)
                System.out.print("  " + riverFinder(tileBoard[2 * i][j], 4)
                        + riverFinder(tileBoard[2 * i][j], 3) + riverFinder(tileBoard[2 * i][j], 2)
                        + "    " + ANSI_COLOR + civilianUnit(tileBoard[2 * i + 1][0])
                        + "   " + ANSI_COLOR+militaryUnit(tileBoard[2 * i + 1][j]) +Colors.RESET+ Colors.RESET + "  ");
            else System.out.print("  " + riverFinder(tileBoard[2 * i][j], 4) + riverFinder(tileBoard[2 * i][j], 3)
                    + riverFinder(tileBoard[2 * i][j], 2) + "             ");
        }
        if (i != 3) System.out.println("  " + riverFinder(tileBoard[2 * i + 1][3], 1));
        else System.out.println();

    }

    private String tileImprovement(Tile tile) {
        if (tile.getImprovement() == null) return "NIY";
        else return tile.getImprovement().getName().substring(0, 3);
    }

    private String tileOwner(Tile tile) {
        if (tile.getOwner() == null) return "   ";
        else return tile.getOwner().getName().substring(0, 3);
    }

    private String civilianUnit(Tile tile) {
        if (tile.getCivilianUnit() == null) return "  ";
        else return tile.getCivilianUnit().getName().substring(0, 2);
    }

    private String militaryUnit(Tile tile) {
        if (tile.getMilitaryUnit() == null) return "  ";
        else return tile.getMilitaryUnit().getName().substring(0, 2);
    }

    private String tileResource(Tile tile, boolean isFirstRightRow) {
        if (isFirstRightRow || tile.getLand().getResource() == null) return "  ";
        else return tile.getLand().getResource().getName().substring(0, 2);
    }

    private String tileTerrain(Tile tile, boolean isFirstRightRow) {
        if (isFirstRightRow || tile.getLand().getTerrain() == null) return "  ";
        else return tile.getLand().getTerrain().getName().substring(0, 2);
    }

    private String getColorOfTileOwner(Tile tile) {
        String ANSI_COLOR = Colors.BLUE;
        if (tile.getOwner() == null) ANSI_COLOR = Colors.BLACK;
        else if (tile.getOwner().getColor().equals("green")) ANSI_COLOR = Colors.GREEN;
        else if (tile.getOwner().getColor().equals("red")) ANSI_COLOR = Colors.RED;
        else if (tile.getOwner().getColor().equals("yellow")) ANSI_COLOR = Colors.YELLOW;
        else if (tile.getOwner().getColor().equals("purple")) ANSI_COLOR = Colors.PURPLE;
        else if (tile.getOwner().getColor().equals("cyan")) ANSI_COLOR = Colors.CYAN;
        return ANSI_COLOR;
    }

    private String riverFinder(Tile tile, int x) {
        //print the river or normal border
        if (tile.getBorderRiver(x) && (x == 0 || x == 3)) return Colors.BLUE_BACKGROUND + "___________" + Colors.RESET;
        if (tile.getBorderRiver(x) && (x == 2 || x == 5)) return Colors.BLUE_BACKGROUND + "/" + Colors.RESET;
        else if (tile.getBorderRiver(x) && (x == 1 || x == 4))
            return Colors.BLUE_BACKGROUND + "\\" + Colors.RESET;
        else if (x == 0 || x == 3) return "___________";
        else if (x == 2 || x == 5) return "/";
        else return "\\";
    }

    private String getColorOfTile(Tile tile) {
        String BACKGROUND_COLOR = Colors.CYAN_BACKGROUND;
        if (tile.getLand().getColor().equals("red")) {
            BACKGROUND_COLOR = Colors.RED_BACKGROUND;
        } else if (tile.getLand().getColor().equals("yellow")) {
            BACKGROUND_COLOR = Colors.YELLOW_BACKGROUND;
        }else if(tile.getLand().getColor().equals("purple")){
            BACKGROUND_COLOR = Colors.PURPLE_BACKGROUND;
        }else if(tile.getLand().getColor().equals("green")){
            BACKGROUND_COLOR = Colors.GREEN_BACKGROUND;
        }else if(tile.getLand().getColor().equals("cyan")){
            BACKGROUND_COLOR = Colors.CYAN_BACKGROUND;
        }
        return BACKGROUND_COLOR;
    }

}
