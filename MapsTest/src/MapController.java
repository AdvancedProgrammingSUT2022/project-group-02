public class MapController {

    private Map map;

    public MapController(Map map) {
        this.map = map;
    }


    public void printMap() {

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {
                System.out.print("  " + printBorder(map.getTileBoard()[2 * i][j], true)
                        + "" + printBorder(map.getTileBoard()[2 * i][j], false) + "  ");
            }
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(" " + printBorder(map.getTileBoard()[2 * i][j], true)
                        + "  " + printBorder(map.getTileBoard()[2 * i][j], false) + " ");
            }
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(printBorder(map.getTileBoard()[2 * i][j], true)
                        + "    " + printBorder(map.getTileBoard()[2 * i][j], false));
            }
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print("|    |");
            }
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print("|    |");
            }
            System.out.println();

        }
    }

    private String printBorder(Tile tile, boolean slash){
        if (slash)return "/";
        else return "\\";
    }

}
