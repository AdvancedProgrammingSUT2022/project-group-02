public class MapController {

    private Tile[][] tileBoard;

    public MapController(Tile[][] tileBoard){
        this.tileBoard = tileBoard;
    }

    public void setTileBoard(Tile[][] tileBoard){
        this.tileBoard = tileBoard;
    }

    public void printMap(){

        //first top sides of left tiles of game board
        for (int j = 0; j < 4; j++)
            System.out.print("   ___________              ");
        System.out.println();

        //print the game board
        for(int i = 0; i < 4; i++) {

            leftCoordinatesPlace(i);

            leftOwnerName(i);

            //units on the left tiles and top sides of right tiles
            for (int j = 0; j < 4; j++)
                System.out.print("/    " + civilianUnit(tileBoard[2 * i][j])
                        + "   " + militaryUnit(tileBoard[2 * i][j]) + "    \\___________");

            if (i != 0) System.out.println("/");
            else System.out.println();

            leftResourceAndTerrain(i);

            rightOwnerName(i);

            leftBottomSides(i);

        }

    }

    private void leftCoordinatesPlace(int i){

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

    private void leftOwnerName(int i){

        //owner name and color of left tiles
        for (int j = 0; j < 4; j++) {
            if (i != 0)
                System.out.print(" /     " + tileOwner(tileBoard[2 * i][j]) + "     \\     "
                        + tileImprovement(tileBoard[2 * i + 1][j]) + "    ");
            else System.out.print(" /     " + tileOwner(tileBoard[2 * i][j]) + "     \\            ");
        }
        if (i != 0) System.out.println(" /");
        else System.out.println();

    }

    private void leftResourceAndTerrain(int i){

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

    private void rightOwnerName(int i){

        //owner name and color of right tiles
        for (int j = 0; j < 4; j++) {
            if (i != 3)
                System.out.print(" \\     " + tileImprovement(tileBoard[2 * i][j])
                        + "     /     " + tileOwner(tileBoard[2 * i][j]) + "    ");
            else System.out.print(" \\     " + tileImprovement(tileBoard[2 * i][j])
                        + "     /            ");
        }
        if (i != 3) System.out.println(" \\");
        else System.out.println();

    }

    private void leftBottomSides(int i){

        //bottom sides of left tiles and units on the right tiles
        for (int j = 0; j < 4; j++) {
            if (i != 3)
                System.out.print("  \\___________/    " + civilianUnit(tileBoard[2 * i + 1][0])
                        + "   " + militaryUnit(tileBoard[2 * i + 1][j]) + "  ");
            else System.out.print("  \\___________/             ");
        }
        if (i != 3) System.out.println("  \\");
        else System.out.println();

    }

    private String tileImprovement(Tile tile){
        if (tile.getImprovement() == null) return "NIY";
        else return tile.getImprovement().getName().substring(0 , 3);
    }

    private String tileOwner(Tile tile){
        if (tile.getOwner() == null) return "FT0";
        else return tile.getOwner().getName().substring(0 , 3);
    }

    private String civilianUnit(Tile tile){
        if (tile.getCivilianUnit() == null) return "11";
        else return tile.getCivilianUnit().getName().substring(0 , 2);
    }

    private String militaryUnit(Tile tile){
        if (tile.getMilitaryUnit() == null) return "22";
        else return tile.getMilitaryUnit().getName().substring(0 , 2);
    }

    private String tileResource(Tile tile , boolean isFirstRightRow) {
        if (isFirstRightRow || tile.getLand().getResource() == null) return "33";
        else return tile.getLand().getResource().getName().substring(0 , 2);
    }

    private String tileTerrain(Tile tile , boolean isFirstRightRow){
        if (isFirstRightRow || tile.getLand().getTerrain() == null) return "44";
        else return tile.getLand().getTerrain().getName().substring(0 , 2);
    }

}
