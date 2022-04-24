public class MapController {
    public static final String ANSI_RESET = "\033[0m";
    public static final String ANSI_BLACK = "\033[0;30m";
    public static final String ANSI_RED = "\033[0;31m";
    public static final String ANSI_GREEN = "\033[0;32m";
    public static final String ANSI_YELLOW = "\033[0;33m";
    public static final String ANSI_BLUE = "\033[0;34m";
    public static final String ANSI_PURPLE = "\033[0;35m";
    public static final String ANSI_CYAN = "\033[0;36m";
    public static final String ANSI_WHITE = "\033[0;37m";

    private Tile[][] tileBoard;

    public MapController(Tile[][] tileBoard) {
        this.tileBoard = tileBoard;
    }

    public void setTileBoard(Tile[][] tileBoard) {
        this.tileBoard = tileBoard;
    }

    public void printMap() {
        String ANSI_COLOR = ANSI_WHITE;

        //first top sides of left tiles of game board
        for (int j = 0; j < 4; j++)
            System.out.print("   ___________              ");
        System.out.println();

        //print the game board
        for (int i = 0; i < 4; i++) {

            leftCoordinatesPlace(i);

            leftOwnerName(i);

            //units on the left tiles and top sides of right tiles
            for (int j = 0; j < 4; j++) {
                if (tileBoard[2 * i][j].getOwner().getColor() == "green") ANSI_COLOR = ANSI_GREEN;
                else if (tileBoard[2 * i][j].getOwner().getColor() == "red") ANSI_COLOR = ANSI_RED;
                else if (tileBoard[2 * i][j].getOwner().getColor() == "yellow") ANSI_COLOR = ANSI_YELLOW;
                else if (tileBoard[2 * i][j].getOwner().getColor() == "purple") ANSI_COLOR = ANSI_PURPLE;
                else if (tileBoard[2 * i][j].getOwner().getColor() == "cyan") ANSI_COLOR = ANSI_CYAN;
                System.out.print("/    " + ANSI_COLOR + civilianUnit(tileBoard[2 * i][j])
                        + "   " + militaryUnit(tileBoard[2 * i][j]) + ANSI_RESET + "    \\___________");
            }
            if (i != 0) System.out.println("/");
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
                System.out.print("  /   [" + 2 * i + "," + j + "]   \\    "
                        + tileResource(tileBoard[2 * i + 1][j], true)
                        + "   " + tileTerrain(tileBoard[2 * i + 1][j], true) + "  ");
            else System.out.print("  /   [" + 0 + "," + j + "]   \\             ");
        }
        if (i != 0) System.out.println("  /");
        else System.out.println();

    }

    private void leftOwnerName(int i) {
        String ANSI_COLOR = ANSI_WHITE;

        //owner name and color of left tiles
        for (int j = 0; j < 4; j++) {
            if (tileBoard[2 * i][j].getOwner().getColor() == "green") ANSI_COLOR = ANSI_GREEN;
            else if (tileBoard[2 * i][j].getOwner().getColor() == "red") ANSI_COLOR = ANSI_RED;
            else if (tileBoard[2 * i][j].getOwner().getColor() == "yellow") ANSI_COLOR = ANSI_YELLOW;
            else if (tileBoard[2 * i][j].getOwner().getColor() == "purple") ANSI_COLOR = ANSI_PURPLE;
            else if (tileBoard[2 * i][j].getOwner().getColor() == "cyan") ANSI_COLOR = ANSI_CYAN;
            if (i != 0)
                System.out.print(" /     " +ANSI_COLOR+ tileOwner(tileBoard[2 * i][j]) + ANSI_RESET +"     \\     "
                        + tileImprovement(tileBoard[2 * i + 1][j]) + "    ");
            else System.out.print(" /     " + ANSI_COLOR+tileOwner(tileBoard[2 * i][j]) +ANSI_RESET+ "     \\            ");
        }
        if (i != 0) System.out.println(" /");
        else System.out.println();

    }

    private void leftResourceAndTerrain(int i) {

        //resource and terrain in left tiles and Coordinates of right tiles
        for (int j = 0; j < 4; j++) {
            if (i != 3)
                System.out.print("\\    " + tileResource(tileBoard[2 * i][j], false)
                        + "   " + tileTerrain(tileBoard[2 * i][j], false)
                        + "    /   [" + (2 * i + 1) + "," + j + "]   ");
            else System.out.print("\\    " + tileResource(tileBoard[2 * i][j], false)
                    + "   " + tileTerrain(tileBoard[2 * i][0], false) + "    /           ");
        }
        if (i != 3) System.out.println("\\");
        else System.out.println();

    }

    private void rightOwnerName(int i) {
        String ANSI_COLOR = ANSI_WHITE;

        //owner name and color of right tiles
        for (int j = 0; j < 4; j++) {
            if (tileBoard[2 * i+1][j].getOwner().getColor() == "green") ANSI_COLOR = ANSI_GREEN;
            else if (tileBoard[2 * i+1][j].getOwner().getColor() == "red") ANSI_COLOR = ANSI_RED;
            else if (tileBoard[2 * i+1][j].getOwner().getColor() == "yellow") ANSI_COLOR = ANSI_YELLOW;
            else if (tileBoard[2 * i+1][j].getOwner().getColor() == "purple") ANSI_COLOR = ANSI_PURPLE;
            else if (tileBoard[2 * i+1][j].getOwner().getColor() == "cyan") ANSI_COLOR = ANSI_CYAN;
            if (i != 3)
                System.out.print(" \\     " + tileImprovement(tileBoard[2 * i][j])
                        + "     /     " + ANSI_COLOR+tileOwner(tileBoard[2 * i][j]) + ANSI_RESET+"    ");
            else System.out.print(" \\     " + tileImprovement(tileBoard[2 * i][j])
                    + "     /            ");
        }
        if (i != 3) System.out.println(" \\");
        else System.out.println();

    }

    private void leftBottomSides(int i) {

        String ANSI_COLOR = ANSI_WHITE;
        //bottom sides of left tiles and units on the right tiles
        for (int j = 0; j < 4; j++) {
            if (tileBoard[2 * i+1][j].getOwner().getColor() == "green") ANSI_COLOR = ANSI_GREEN;
            else if (tileBoard[2 * i+1][j].getOwner().getColor() == "red") ANSI_COLOR = ANSI_RED;
            else if (tileBoard[2 * i+1][j].getOwner().getColor() == "yellow") ANSI_COLOR = ANSI_YELLOW;
            else if (tileBoard[2 * i+1][j].getOwner().getColor() == "purple") ANSI_COLOR = ANSI_PURPLE;
            else if (tileBoard[2 * i+1][j].getOwner().getColor() == "cyan") ANSI_COLOR = ANSI_CYAN;
            if (i != 3)
                System.out.print("  \\___________/    " + ANSI_COLOR + civilianUnit(tileBoard[2 * i + 1][0])
                        + "   " + militaryUnit(tileBoard[2 * i + 1][j]) + ANSI_RESET + "  ");
            else System.out.print("  \\___________/             ");
        }
        if (i != 3) System.out.println("  \\");
        else System.out.println();

    }

    private String tileImprovement(Tile tile) {
        if (tile.getImprovement() == null) return "NIY";
        else return tile.getImprovement().getName().substring(0, 3);
    }

    private String tileOwner(Tile tile) {
        if (tile.getOwner() == null) return "FT0";
        else return tile.getOwner().getName().substring(0, 3);
    }

    private String civilianUnit(Tile tile) {
        if (tile.getCivilianUnit() == null) return "11";
        else return tile.getCivilianUnit().getName().substring(0, 2);
    }

    private String militaryUnit(Tile tile) {
        if (tile.getMilitaryUnit() == null) return "22";
        else return tile.getMilitaryUnit().getName().substring(0, 2);
    }

    private String tileResource(Tile tile, boolean isFirstRightRow) {
        if (isFirstRightRow || tile.getLand().getResource() == null) return "33";
        else return tile.getLand().getResource().getName().substring(0, 2);
    }

    private String tileTerrain(Tile tile, boolean isFirstRightRow) {
        if (isFirstRightRow || tile.getLand().getTerrain() == null) return "44";
        else return tile.getLand().getTerrain().getName().substring(0, 2);
    }

}
