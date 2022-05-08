package model;

import java.util.ArrayList;

public class MohammadMap {
    public static void mohammadTiles() {

        Maps map = new Maps(26, 80);

        Feature Jungle = new Feature("Jungle", 2, 1, 0.25, 0, 1);
        Feature Forest = new Feature("Forest", 2, 1, 0.25, 0, 1);
        Feature Marsh = new Feature("Marsh", 2, -1, -0.33, 0, 0);
        Feature Oasis = new Feature("Oasis", 1, 3, -0.33, 1, 0);
        Feature Ice = new Feature("Ice", 0, 0, 0, 0, 0);
        Feature FloodPlain = new Feature("FloodPlain", 1, 2, -0.33, 0, 0);

        Terrain Desert = new Terrain("Desert", "yellow", 1, 0, -0.33, 0, 0, true);
        Terrain GrassLand = new Terrain("Grassland", "green", 1, 2, -0.33, 0, 0, true);
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Terrain Mountain = new Terrain("Mountain", "brightBlack", 0, 0, 0, 0, 0, false);
        Terrain Ocean = new Terrain("Ocean", "brightBlue", 0, 0, 0, 0, 0, false);
        Terrain Plain = new Terrain("Plain", "red", 1, 1, -0.33, 0, 1, true);
        Terrain Snow = new Terrain("Snow", "white", 1, 0, -0.33, 0, 0, true);

        Tile tile;

    }
}
