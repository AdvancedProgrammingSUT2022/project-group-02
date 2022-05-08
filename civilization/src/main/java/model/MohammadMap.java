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
        //20th row
        /*
        Tile tile20_1 = new Tile(19, 0, null, Ocean, 0, false, null, null, null);
        Tile tile20_2 = new Tile(19, 1, null, Ocean, 0, false, null, null, null);
        Tile tile20_3 = new Tile(19, 2, null, Ocean, 0, false, null, null, null);
        Tile tile20_4 = new Tile(19, 3, null, Ocean, 0, false, null, null, null);
        Tile tile20_5 = new Tile(19, 4, null, Ocean, 0, false, null, null, null);
        Tile tile20_6 = new Tile(19, 5, null, Ocean, 0, false, null, null, null);
        Tile tile20_7 = new Tile(19, 6, null, Ocean, 0, false, null, null, null);
        Tile tile20_8 = new Tile(19, 7, null, Ocean, 0, false, null, null, null);
        */

        for (int i = 0; i < 8; i++) {
            tile = new Tile(19, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(19, 8, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 9, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 10, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 11, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 12, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(19, 13, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(19, 14, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(19, 15, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 16, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 17, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*
        Tile tile20_19 = new Tile(19, 18, null, Ocean, 0, false, null, null, null);
        Tile tile20_20 = new Tile(19, 19, null, Ocean, 0, false, null, null, null);
        Tile tile20_21 = new Tile(19, 20, null, Ocean, 0, false, null, null, null);
        Tile tile20_22 = new Tile(19, 21, null, Ocean, 0, false, null, null, null);
        Tile tile20_23 = new Tile(19, 22, null, Ocean, 0, false, null, null, null);
        Tile tile20_24 = new Tile(19, 23, null, Ocean, 0, false, null, null, null);
        Tile tile20_25 = new Tile(19, 24, null, Ocean, 0, false, null, null, null);
        Tile tile20_26 = new Tile(19, 25, null, Ocean, 0, false, null, null, null);
        Tile tile20_27 = new Tile(19, 26, null, Ocean, 0, false, null, null, null);
        Tile tile20_28 = new Tile(19, 27, null, Ocean, 0, false, null, null, null);
        Tile tile20_29 = new Tile(19, 28, null, Ocean, 0, false, null, null, null);
        Tile tile20_30 = new Tile(19, 29, null, Ocean, 0, false, null, null, null);
        Tile tile20_31 = new Tile(19, 30, null, Ocean, 0, false, null, null, null);
        Tile tile20_32 = new Tile(19, 31, null, Ocean, 0, false, null, null, null);
        */

        for (int i = 18; i < 32; i++) {
            tile = new Tile(19, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(19, 32, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 33, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 34, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 35, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 36, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 37, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 38, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(19, 39, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(19, 40, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 41, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 42, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 43, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 44, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 45, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 46, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 47, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 48, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 49, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        /*
        Tile tile20_51 = new Tile(19, 50, null, Desert, 0, false, null, null, null);
        Tile tile20_52 = new Tile(19, 51, null, Desert, 0, false, null, null, null);
        Tile tile20_53 = new Tile(19, 52, null, Desert, 0, false, null, null, null);
        Tile tile20_54 = new Tile(19, 53, null, Desert, 0, false, null, null, null);
        Tile tile20_55 = new Tile(19, 54, null, Desert, 0, false, null, null, null);
        Tile tile20_56 = new Tile(19, 55, null, Desert, 0, false, null, null, null);
        Tile tile20_57 = new Tile(19, 56, null, Desert, 0, false, null, null, null);
        Tile tile20_58 = new Tile(19, 57, null, Desert, 0, false, null, null, null);
        Tile tile20_59 = new Tile(19, 58, null, Desert, 0, false, null, null, null);
        Tile tile20_60 = new Tile(19, 59, null, Desert, 0, false, null, null, null);
        Tile tile20_61 = new Tile(19, 60, null, Desert, 0, false, null, null, null);
        */
        for (int i = 50; i < 61; i++) {
            tile = new Tile(19, i, null, Desert, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(19, 61, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 62, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 63, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(19, 64, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 65, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(19, 66, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(19, 67, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 68, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 69, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 70, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 71, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        /*
        Tile tile20_73 = new Tile(19, 72, null, Ocean, 0, false, null, null, null);
        Tile tile20_74 = new Tile(19, 73, null, Ocean, 0, false, null, null, null);
        Tile tile20_75 = new Tile(19, 74, null, Ocean, 0, false, null, null, null);
        Tile tile20_76 = new Tile(19, 75, null, Ocean, 0, false, null, null, null);
        Tile tile20_77 = new Tile(19, 76, null, Ocean, 0, false, null, null, null);
        Tile tile20_78 = new Tile(19, 77, null, Ocean, 0, false, null, null, null);
        Tile tile20_79 = new Tile(19, 78, null, Ocean, 0, false, null, null, null);
        Tile tile20_80 = new Tile(19, 79, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 72; i < 80; i++) {
            tile = new Tile(19, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        //21th row
        /*
        Tile tile21_1 = new Tile(20, 0, null, Ocean, 0, false, null, null, null);
        Tile tile21_2 = new Tile(20, 1, null, Ocean, 0, false, null, null, null);
        Tile tile21_3 = new Tile(20, 2, null, Ocean, 0, false, null, null, null);
        Tile tile21_4 = new Tile(20, 3, null, Ocean, 0, false, null, null, null);
        Tile tile21_5 = new Tile(20, 4, null, Ocean, 0, false, null, null, null);
        Tile tile21_6 = new Tile(20, 5, null, Ocean, 0, false, null, null, null);
        Tile tile21_7 = new Tile(20, 6, null, Ocean, 0, false, null, null, null);
        Tile tile21_8 = new Tile(20, 7, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 0; i < 8; i++) {
            tile = new Tile(20, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(20, 8, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 9, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 10, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 11, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 12, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 13, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 14, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 15, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 16, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 17, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile21_19 = new Tile(20, 18, null, Ocean, 0, false, null, null, null);
        Tile tile21_20 = new Tile(20, 19, null, Ocean, 0, false, null, null, null);
        Tile tile21_21 = new Tile(20, 20, null, Ocean, 0, false, null, null, null);
        Tile tile21_22 = new Tile(20, 21, null, Ocean, 0, false, null, null, null);
        Tile tile21_23 = new Tile(20, 22, null, Ocean, 0, false, null, null, null);
        Tile tile21_24 = new Tile(20, 23, null, Ocean, 0, false, null, null, null);
        Tile tile21_25 = new Tile(20, 24, null, Ocean, 0, false, null, null, null);
        Tile tile21_26 = new Tile(20, 25, null, Ocean, 0, false, null, null, null);
        Tile tile21_27 = new Tile(20, 26, null, Ocean, 0, false, null, null, null);
        Tile tile21_28 = new Tile(20, 27, null, Ocean, 0, false, null, null, null);
        Tile tile21_29 = new Tile(20, 28, null, Ocean, 0, false, null, null, null);
        Tile tile21_30 = new Tile(20, 29, null, Ocean, 0, false, null, null, null);
        Tile tile21_31 = new Tile(20, 30, null, Ocean, 0, false, null, null, null);
        Tile tile21_32 = new Tile(20, 31, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 18; i < 32; i++) {
            tile = new Tile(20, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(20, 32, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 33, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 34, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        /*
        Tile tile21_36 = new Tile(20, 35, null, Ocean, 0, false, null, null, null);
        Tile tile21_37 = new Tile(20, 36, null, Ocean, 0, false, null, null, null);
        Tile tile21_38 = new Tile(20, 37, null, Ocean, 0, false, null, null, null);
        Tile tile21_39 = new Tile(20, 38, null, Ocean, 0, false, null, null, null);
        Tile tile21_40 = new Tile(20, 39, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 35; i < 40; i++) {
            tile = new Tile (20, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(20, 40, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        /*
        Tile tile21_42 = new Tile(20, 41, null, Ocean, 0, false, null, null, null);
        Tile tile21_43 = new Tile(20, 42, null, Ocean, 0, false, null, null, null);
        Tile tile21_44 = new Tile(20, 43, null, Ocean, 0, false, null, null, null);
        Tile tile21_45 = new Tile(20, 44, null, Ocean, 0, false, null, null, null);
        Tile tile21_46 = new Tile(20, 45, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 41; i < 46; i++) {
            tile = new Tile(20, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }
        /*
        Tile tile21_47 = new Tile(20, 46, null, Desert, 0, false, null, null, null);
        Tile tile21_48 = new Tile(20, 47, null, Desert, 0, false, null, null, null);
        Tile tile21_49 = new Tile(20, 48, null, Desert, 0, false, null, null, null);
        Tile tile21_50 = new Tile(20, 49, null, Desert, 0, false, null, null, null);
        */
        for (int i = 46; i < 50; i++) {
            tile = new Tile (20, i, null, Desert, 0, false, null, null, null);
            map.setTileBoard(tile);
        }
        /*
        Tile tile21_51 = new Tile(20, 50, null, Plain, 0, false, null, null, null);
        Tile tile21_52 = new Tile(20, 51, null, Plain, 0, false, null, null, null);
        Tile tile21_53 = new Tile(20, 52, null, Plain, 0, false, null, null, null);
        */
        for  (int i = 50; i < 53; i++) {
            tile = new Tile (20, i, null, Plain, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        /*
        Tile tile21_54 = new Tile(20, 53, null, Mountain, 0, false, null, null, null);
        Tile tile21_55 = new Tile(20, 54, null, Mountain, 0, false, null, null, null);
        Tile tile21_56 = new Tile(20, 55, null, Mountain, 0, false, null, null, null);
        Tile tile21_57 = new Tile(20, 56, null, Mountain, 0, false, null, null, null);
        Tile tile21_58 = new Tile(20, 57, null, Mountain, 0, false, null, null, null);
        Tile tile21_59 = new Tile(20, 58, null, Mountain, 0, false, null, null, null);
        */
        for (int i = 53; i < 59; i++) {
            tile = new Tile(20, i, null, Mountain, 0, false, null, null, null);
            map.setTileBoard(tile);
        }
        /*
        Tile tile21_60 = new Tile(20, 59, null, GrassLand, 0, false, null, null, Forest);
        Tile tile21_61 = new Tile(20, 60, null, GrassLand, 0, false, null, null, Forest);
        Tile tile21_62 = new Tile(20, 61, null, GrassLand, 0, false, null, null, Forest);
        Tile tile21_63 = new Tile(20, 62, null, GrassLand, 0, false, null, null, Forest);
        Tile tile21_64 = new Tile(20, 63, null, GrassLand, 0, false, null, null, Forest);
        Tile tile21_65 = new Tile(20, 64, null, GrassLand, 0, false, null, null, Forest);
        Tile tile21_66 = new Tile(20, 65, null, GrassLand, 0, false, null, null, Forest);
        */
        for (int i = 59; i < 66; i++) {
            tile = new Tile(20, i, null, GrassLand, 0, false, null, null, Forest);
            map.setTileBoard(tile);
        }

        tile = new Tile(20, 66, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 67, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 68, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 69, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        /*
        Tile tile21_71 = new Tile(20, 70, null, Ocean, 0, false, null, null, null);
        Tile tile21_72 = new Tile(20, 71, null, Ocean, 0, false, null, null, null);
        Tile tile21_73 = new Tile(20, 72, null, Ocean, 0, false, null, null, null);
        Tile tile21_74 = new Tile(20, 73, null, Ocean, 0, false, null, null, null);
        Tile tile21_75 = new Tile(20, 74, null, Ocean, 0, false, null, null, null);
        Tile tile21_76 = new Tile(20, 75, null, Ocean, 0, false, null, null, null);
        Tile tile21_77 = new Tile(20, 76, null, Ocean, 0, false, null, null, null);
        Tile tile21_78 = new Tile(20, 77, null, Ocean, 0, false, null, null, null);
        Tile tile21_79 = new Tile(20, 78, null, Ocean, 0, false, null, null, null);
        Tile tile21_80 = new Tile(20, 79, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 70; i < 80; i++) {
            tile = new Tile(20, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }



        //22th row
        /*
        Tile tile22_1 = new Tile(21, 0, null, Ocean, 0, false, null, null, null);
        Tile tile22_2 = new Tile(21, 1, null, Ocean, 0, false, null, null, null);
        Tile tile22_3 = new Tile(21, 2, null, Ocean, 0, false, null, null, null);
        Tile tile22_4 = new Tile(21, 3, null, Ocean, 0, false, null, null, null);
        Tile tile22_5 = new Tile(21, 4, null, Ocean, 0, false, null, null, null);
        Tile tile22_6 = new Tile(21, 5, null, Ocean, 0, false, null, null, null);
        Tile tile22_7 = new Tile(21, 6, null, Ocean, 0, false, null, null, null);
        Tile tile22_8 = new Tile(21, 7, null, Ocean, 0, false, null, null, null);
        Tile tile22_9 = new Tile(21, 8, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 0; i < 9; i++) {
            tile = new Tile (21, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(21, 9, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 10, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 11, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 12, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 13, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 14, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 15, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 16, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 17, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 18, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 19, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        /*
        Tile tile22_21 = new Tile(21, 20, null, Ocean, 0, false, null, null, null);
        Tile tile22_22 = new Tile(21, 21, null, Ocean, 0, false, null, null, null);
        Tile tile22_23 = new Tile(21, 22, null, Ocean, 0, false, null, null, null);
        Tile tile22_24 = new Tile(21, 23, null, Ocean, 0, false, null, null, null);
        Tile tile22_25 = new Tile(21, 24, null, Ocean, 0, false, null, null, null);
        Tile tile22_26 = new Tile(21, 25, null, Ocean, 0, false, null, null, null);
        Tile tile22_27 = new Tile(21, 26, null, Ocean, 0, false, null, null, null);
        Tile tile22_28 = new Tile(21, 27, null, Ocean, 0, false, null, null, null);
        Tile tile22_29 = new Tile(21, 28, null, Ocean, 0, false, null, null, null);
        Tile tile22_30 = new Tile(21, 29, null, Ocean, 0, false, null, null, null);
        Tile tile22_31 = new Tile(21, 30, null, Ocean, 0, false, null, null, null);
        Tile tile22_32 = new Tile(21, 31, null, Ocean, 0, false, null, null, null);
        Tile tile22_33 = new Tile(21, 32, null, Ocean, 0, false, null, null, null);
        Tile tile22_34 = new Tile(21, 33, null, Ocean, 0, false, null, null, null);
        Tile tile22_35 = new Tile(21, 34, null, Ocean, 0, false, null, null, null);
        Tile tile22_36 = new Tile(21, 35, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 20; i < 36; i++) {
            tile = new Tile(21, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(21, 36, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 37, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 38, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        /*
        Tile tile22_40 = new Tile(21, 39, null, Ocean, 0, false, null, null, null);
        Tile tile22_41 = new Tile(21, 40, null, Ocean, 0, false, null, null, null);
        Tile tile22_42 = new Tile(21, 41, null, Ocean, 0, false, null, null, null);
        Tile tile22_43 = new Tile(21, 42, null, Ocean, 0, false, null, null, null);
        Tile tile22_44 = new Tile(21, 43, null, Ocean, 0, false, null, null, null);
        Tile tile22_45 = new Tile(21, 44, null, Ocean, 0, false, null, null, null);
        Tile tile22_46 = new Tile(21, 45, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 39; i < 46; i++) {
            tile = new Tile(21, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(21, 46, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 47, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 48, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 49, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 50, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 51, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 52, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 53, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 54, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        /*
        Tile tile22_56 = new Tile(21, 55, null, GrassLand, 0, false, null, null, Forest);
        Tile tile22_57 = new Tile(21, 56, null, GrassLand, 0, false, null, null, Forest);
        Tile tile22_58 = new Tile(21, 57, null, GrassLand, 0, false, null, null, Forest);
        Tile tile22_59 = new Tile(21, 58, null, GrassLand, 0, false, null, null, Forest);
        Tile tile22_60 = new Tile(21, 59, null, GrassLand, 0, false, null, null, Forest);
        */
        for (int i = 55; i < 60; i++) {
            tile = new Tile(21, i, null, GrassLand, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(21, 60, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 61, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 62, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 63, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 64, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 65, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 66, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 67, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile22_69 = new Tile(21, 68, null, Ocean, 0, false, null, null, null);
        Tile tile22_70 = new Tile(21, 69, null, Ocean, 0, false, null, null, null);
        Tile tile22_71 = new Tile(21, 70, null, Ocean, 0, false, null, null, null);
        Tile tile22_72 = new Tile(21, 71, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 68; i < 72; i++) {
            tile = new Tile (21, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(21, 72, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile22_74 = new Tile(21, 73, null, Ocean, 0, false, null, null, null);
        Tile tile22_75 = new Tile(21, 74, null, Ocean, 0, false, null, null, null);
        Tile tile22_76 = new Tile(21, 75, null, Ocean, 0, false, null, null, null);
        Tile tile22_77 = new Tile(21, 76, null, Ocean, 0, false, null, null, null);
        Tile tile22_78 = new Tile(21, 77, null, Ocean, 0, false, null, null, null);
        Tile tile22_79 = new Tile(21, 78, null, Ocean, 0, false, null, null, null);
        Tile tile22_80 = new Tile(21, 79, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 73; i < 80; i++) {
            tile = new Tile (21, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        //23th row
        /*
        Tile tile23_1 = new Tile(22, 0, null, Ocean, 0, false, null, null, null);
        Tile tile23_2 = new Tile(22, 1, null, Ocean, 0, false, null, null, null);
        Tile tile23_3 = new Tile(22, 2, null, Ocean, 0, false, null, null, null);
        Tile tile23_4 = new Tile(22, 3, null, Ocean, 0, false, null, null, null);
        Tile tile23_5 = new Tile(22, 4, null, Ocean, 0, false, null, null, null);
        Tile tile23_6 = new Tile(22, 5, null, Ocean, 0, false, null, null, null);
        Tile tile23_7 = new Tile(22, 6, null, Ocean, 0, false, null, null, null);
        Tile tile23_8 = new Tile(22, 7, null, Ocean, 0, false, null, null, null);
        Tile tile23_9 = new Tile(22, 8, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 0; i < 9; i++) {
            tile = new Tile (22, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(22, 9, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 10, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 11, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 12, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 13, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile23_15 = new Tile(22, 14, null, Ocean, 0, false, null, null, null);
        Tile tile23_16 = new Tile(22, 15, null, Ocean, 0, false, null, null, null);
        Tile tile23_17 = new Tile(22, 16, null, Ocean, 0, false, null, null, null);
        Tile tile23_18 = new Tile(22, 17, null, Ocean, 0, false, null, null, null);
        Tile tile23_19 = new Tile(22, 18, null, Ocean, 0, false, null, null, null);
        Tile tile23_20 = new Tile(22, 19, null, Ocean, 0, false, null, null, null);
        Tile tile23_21 = new Tile(22, 20, null, Ocean, 0, false, null, null, null);
        Tile tile23_22 = new Tile(22, 21, null, Ocean, 0, false, null, null, null);
        Tile tile23_23 = new Tile(22, 22, null, Ocean, 0, false, null, null, null);
        Tile tile23_24 = new Tile(22, 23, null, Ocean, 0, false, null, null, null);
        Tile tile23_25 = new Tile(22, 24, null, Ocean, 0, false, null, null, null);
        Tile tile23_26 = new Tile(22, 25, null, Ocean, 0, false, null, null, null);
        Tile tile23_27 = new Tile(22, 26, null, Ocean, 0, false, null, null, null);
        Tile tile23_28 = new Tile(22, 27, null, Ocean, 0, false, null, null, null);
        Tile tile23_29 = new Tile(22, 28, null, Ocean, 0, false, null, null, null);
        Tile tile23_30 = new Tile(22, 29, null, Ocean, 0, false, null, null, null);
        Tile tile23_31 = new Tile(22, 30, null, Ocean, 0, false, null, null, null);
        Tile tile23_32 = new Tile(22, 31, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 14; i < 32; i++) {
            tile = new Tile(22, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(22, 32, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 33, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 34, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 35, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 36, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 37, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 38, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 39, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 40, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 41, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 42, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 43, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 44, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 45, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 46, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 47, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 48, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 49, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 50, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 51, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 52, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 53, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 54, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 55, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 56, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 57, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 58, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 59, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 60, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 61, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 62, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 63, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 64, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 65, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 66, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(22, 67, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile23_69 = new Tile(22, 68, null, Ocean, 0, false, null, null, null);
        Tile tile23_70 = new Tile(22, 69, null, Ocean, 0, false, null, null, null);
        Tile tile23_71 = new Tile(22, 70, null, Ocean, 0, false, null, null, null);
        Tile tile23_72 = new Tile(22, 71, null, Ocean, 0, false, null, null, null);
        Tile tile23_73 = new Tile(22, 72, null, Ocean, 0, false, null, null, null);
        Tile tile23_74 = new Tile(22, 73, null, Ocean, 0, false, null, null, null);
        Tile tile23_75 = new Tile(22, 74, null, Ocean, 0, false, null, null, null);
        Tile tile23_76 = new Tile(22, 75, null, Ocean, 0, false, null, null, null);
        Tile tile23_77 = new Tile(22, 76, null, Ocean, 0, false, null, null, null);
        Tile tile23_78 = new Tile(22, 77, null, Ocean, 0, false, null, null, null);
        Tile tile23_79 = new Tile(22, 78, null, Ocean, 0, false, null, null, null);
        Tile tile23_80 = new Tile(22, 79, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 68; i < 80; i++) {
            tile = new Tile (22, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        //24th row
        tile = new Tile(23, 0, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile24_2 = new Tile(23, 1, null, Ocean, 0, false, null, null, null);
        Tile tile24_3 = new Tile(23, 2, null, Ocean, 0, false, null, null, null);
        Tile tile24_4 = new Tile(23, 3, null, Ocean, 0, false, null, null, null);
        Tile tile24_5 = new Tile(23, 4, null, Ocean, 0, false, null, null, null);
        Tile tile24_6 = new Tile(23, 5, null, Ocean, 0, false, null, null, null);
        Tile tile24_7 = new Tile(23, 6, null, Ocean, 0, false, null, null, null);
        Tile tile24_8 = new Tile(23, 7, null, Ocean, 0, false, null, null, null);
        Tile tile24_9 = new Tile(23, 8, null, Ocean, 0, false, null, null, null);
        Tile tile24_10 = new Tile(23, 9, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 1; i < 10; i++) {
            tile = new Tile (23, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(23, 10, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 11, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 12, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 13, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 14, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 15, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 16, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 17, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 18, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 19, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 20, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile24_22 = new Tile(23, 21, null, Ocean, 0, false, null, null, null);
        Tile tile24_23 = new Tile(23, 22, null, Ocean, 0, false, null, null, null);
        Tile tile24_24 = new Tile(23, 23, null, Ocean, 0, false, null, null, null);
        Tile tile24_25 = new Tile(23, 24, null, Ocean, 0, false, null, null, null);
        Tile tile24_26 = new Tile(23, 25, null, Ocean, 0, false, null, null, null);
        Tile tile24_27 = new Tile(23, 26, null, Ocean, 0, false, null, null, null);
        Tile tile24_28 = new Tile(23, 27, null, Ocean, 0, false, null, null, null);
        Tile tile24_29 = new Tile(23, 28, null, Ocean, 0, false, null, null, null);
        Tile tile24_30 = new Tile(23, 29, null, Ocean, 0, false, null, null, null);
        Tile tile24_31 = new Tile(23, 30, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 21; i < 31; i++) {
            tile = new Tile (23, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(23, 31, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        /*
        Tile tile24_33 = new Tile(23, 32, null, Desert, 0, false, null, null, null);
        Tile tile24_34 = new Tile(23, 33, null, Desert, 0, false, null, null, null);
        Tile tile24_35 = new Tile(23, 34, null, Desert, 0, false, null, null, null);
        Tile tile24_36 = new Tile(23, 35, null, Desert, 0, false, null, null, null);
        Tile tile24_37 = new Tile(23, 36, null, Desert, 0, false, null, null, null);
        Tile tile24_38 = new Tile(23, 37, null, Desert, 0, false, null, null, null);
        Tile tile24_39 = new Tile(23, 38, null, Desert, 0, false, null, null, null);
        */
        for (int i = 32; i < 39; i++) {
            tile = new Tile (23, i, null, Desert, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(23, 39, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 40, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 41, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 42, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 43, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 44, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 45, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 46, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 47, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 48, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 49, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 50, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 51, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 52, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 53, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 54, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 55, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 56, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile24_58 = new Tile(23, 57, null, GrassLand, 0, false, null, null, Forest);
        Tile tile24_59 = new Tile(23, 58, null, GrassLand, 0, false, null, null, Forest);
        Tile tile24_60 = new Tile(23, 59, null, GrassLand, 0, false, null, null, Forest);
        Tile tile24_61 = new Tile(23, 60, null, GrassLand, 0, false, null, null, Forest);
        Tile tile24_62 = new Tile(23, 61, null, GrassLand, 0, false, null, null, Forest);
        Tile tile24_63 = new Tile(23, 62, null, GrassLand, 0, false, null, null, Forest);
        Tile tile24_64 = new Tile(23, 63, null, GrassLand, 0, false, null, null, Forest);
        Tile tile24_65 = new Tile(23, 64, null, GrassLand, 0, false, null, null, Forest);
        Tile tile24_66 = new Tile(23, 65, null, GrassLand, 0, false, null, null, Forest);
        Tile tile24_67 = new Tile(23, 66, null, GrassLand, 0, false, null, null, Forest);
        */
        for (int i = 57; i < 67; i++) {
            tile = new Tile (23, i, null, GrassLand, 0, false, null, null, Forest);
            map.setTileBoard(tile);
        }
        /*
        Tile tile24_68 = new Tile(23, 67, null, Ocean, 0, false, null, null, null);
        Tile tile24_69 = new Tile(23, 68, null, Ocean, 0, false, null, null, null);
        Tile tile24_70 = new Tile(23, 69, null, Ocean, 0, false, null, null, null);
        Tile tile24_71 = new Tile(23, 70, null, Ocean, 0, false, null, null, null);
        Tile tile24_72 = new Tile(23, 71, null, Ocean, 0, false, null, null, null);
        Tile tile24_73 = new Tile(23, 72, null, Ocean, 0, false, null, null, null);
        Tile tile24_74 = new Tile(23, 73, null, Ocean, 0, false, null, null, null);
        Tile tile24_75 = new Tile(23, 74, null, Ocean, 0, false, null, null, null);
        Tile tile24_76 = new Tile(23, 75, null, Ocean, 0, false, null, null, null);
        Tile tile24_77 = new Tile(23, 76, null, Ocean, 0, false, null, null, null);
        Tile tile24_78 = new Tile(23, 77, null, Ocean, 0, false, null, null, null);
        Tile tile24_79 = new Tile(23, 78, null, Ocean, 0, false, null, null, null);
        Tile tile24_80 = new Tile(23, 79, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 67; i < 80; i++) {
            tile = new Tile (23, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        //25th row
        tile = new Tile(24, 0, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile25_2 = new Tile(24, 1, null, Ocean, 0, false, null, null, null);
        Tile tile25_3 = new Tile(24, 2, null, Ocean, 0, false, null, null, null);
        Tile tile25_4 = new Tile(24, 3, null, Ocean, 0, false, null, null, null);
        Tile tile25_5 = new Tile(24, 4, null, Ocean, 0, false, null, null, null);
        Tile tile25_6 = new Tile(24, 5, null, Ocean, 0, false, null, null, null);
        Tile tile25_7 = new Tile(24, 6, null, Ocean, 0, false, null, null, null);
        Tile tile25_8 = new Tile(24, 7, null, Ocean, 0, false, null, null, null);
        Tile tile25_9 = new Tile(24, 8, null, Ocean, 0, false, null, null, null);
        Tile tile25_10 = new Tile(24, 9, null, Ocean, 0, false, null, null, null);
        Tile tile25_11 = new Tile(24, 10, null, Ocean, 0, false, null, null, null);
        Tile tile25_12 = new Tile(24, 11, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 1; i < 12; i++) {
            tile = new Tile (24, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(24, 12, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 13, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 14, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 15, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 16, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 17, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 18, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 19, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile25_21 = new Tile(24, 20, null, Ocean, 0, false, null, null, null);
        Tile tile25_22 = new Tile(24, 21, null, Ocean, 0, false, null, null, null);
        Tile tile25_23 = new Tile(24, 22, null, Ocean, 0, false, null, null, null);
        Tile tile25_24 = new Tile(24, 23, null, Ocean, 0, false, null, null, null);
        Tile tile25_25 = new Tile(24, 24, null, Ocean, 0, false, null, null, null);
        Tile tile25_26 = new Tile(24, 25, null, Ocean, 0, false, null, null, null);
        Tile tile25_27 = new Tile(24, 26, null, Ocean, 0, false, null, null, null);
        Tile tile25_28 = new Tile(24, 27, null, Ocean, 0, false, null, null, null);
        Tile tile25_29 = new Tile(24, 28, null, Ocean, 0, false, null, null, null);
        Tile tile25_30 = new Tile(24, 29, null, Ocean, 0, false, null, null, null);
        Tile tile25_31 = new Tile(24, 30, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 20; i < 31; i++) {
            tile = new Tile (24, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(24, 31, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        /*
        Tile tile25_33 = new Tile(24, 32, null, Desert, 0, false, null, null, null);
        Tile tile25_34 = new Tile(24, 33, null, Desert, 0, false, null, null, null);
        Tile tile25_35 = new Tile(24, 34, null, Desert, 0, false, null, null, null);
        Tile tile25_36 = new Tile(24, 35, null, Desert, 0, false, null, null, null);
        Tile tile25_37 = new Tile(24, 36, null, Desert, 0, false, null, null, null);
        Tile tile25_38 = new Tile(24, 37, null, Desert, 0, false, null, null, null);
        Tile tile25_39 = new Tile(24, 38, null, Desert, 0, false, null, null, null);
        Tile tile25_40 = new Tile(24, 39, null, Desert, 0, false, null, null, null);
        Tile tile25_41 = new Tile(24, 40, null, Desert, 0, false, null, null, null);
        Tile tile25_42 = new Tile(24, 41, null, Desert, 0, false, null, null, null);
        */
        for (int i = 32; i < 42; i++) {
            tile = new Tile (24, i, null, Desert, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(24, 42, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 43, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 44, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 45, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 46, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 47, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 48, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 49, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 50, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 51, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 52, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        tile = new Tile(24, 53, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 54, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 55, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 56, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 57, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 58, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 59, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 60, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 61, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 62, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 63, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 64, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 65, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(24, 66, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);

        tile = new Tile(24, 67, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 68, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile25_70 = new Tile(24, 69, null, Ocean, 0, false, null, null, null);
        Tile tile25_71 = new Tile(24, 70, null, Ocean, 0, false, null, null, null);
        Tile tile25_72 = new Tile(24, 71, null, Ocean, 0, false, null, null, null);
        Tile tile25_73 = new Tile(24, 72, null, Ocean, 0, false, null, null, null);
        Tile tile25_74 = new Tile(24, 73, null, Ocean, 0, false, null, null, null);
        Tile tile25_75 = new Tile(24, 74, null, Ocean, 0, false, null, null, null);
        Tile tile25_76 = new Tile(24, 75, null, Ocean, 0, false, null, null, null);
        Tile tile25_77 = new Tile(24, 76, null, Ocean, 0, false, null, null, null);
        Tile tile25_78 = new Tile(24, 77, null, Ocean, 0, false, null, null, null);
        Tile tile25_79 = new Tile(24, 78, null, Ocean, 0, false, null, null, null);
        Tile tile25_80 = new Tile(24, 79, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 69; i < 80; i++) {
            tile = new Tile (24, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        //26th row
        tile = new Tile(25, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 2, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile26_4 = new Tile(25, 3, null, Ocean, 0, false, null, null, null);
        Tile tile26_5 = new Tile(25, 4, null, Ocean, 0, false, null, null, null);
        Tile tile26_6 = new Tile(25, 5, null, Ocean, 0, false, null, null, null);
        Tile tile26_7 = new Tile(25, 6, null, Ocean, 0, false, null, null, null);
        Tile tile26_8 = new Tile(25, 7, null, Ocean, 0, false, null, null, null);
        Tile tile26_9 = new Tile(25, 8, null, Ocean, 0, false, null, null, null);
        Tile tile26_10 = new Tile(25, 9, null, Ocean, 0, false, null, null, null);
        Tile tile26_11 = new Tile(25, 10, null, Ocean, 0, false, null, null, null);
        Tile tile26_12 = new Tile(25, 11, null, Ocean, 0, false, null, null, null);
        Tile tile26_13 = new Tile(25, 12, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 3; i < 13; i++) {
            tile = new Tile (25, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(25, 13, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 14, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 15, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile26_17 = new Tile(25, 16, null, Ocean, 0, false, null, null, null);
        Tile tile26_18 = new Tile(25, 17, null, Ocean, 0, false, null, null, null);
        Tile tile26_19 = new Tile(25, 18, null, Ocean, 0, false, null, null, null);
        Tile tile26_20 = new Tile(25, 19, null, Ocean, 0, false, null, null, null);
        Tile tile26_21 = new Tile(25, 20, null, Ocean, 0, false, null, null, null);
        Tile tile26_22 = new Tile(25, 21, null, Ocean, 0, false, null, null, null);
        Tile tile26_23 = new Tile(25, 22, null, Ocean, 0, false, null, null, null);
        Tile tile26_24 = new Tile(25, 23, null, Ocean, 0, false, null, null, null);
        Tile tile26_25 = new Tile(25, 24, null, Ocean, 0, false, null, null, null);
        Tile tile26_26 = new Tile(25, 25, null, Ocean, 0, false, null, null, null);
        Tile tile26_27 = new Tile(25, 26, null, Ocean, 0, false, null, null, null);
        Tile tile26_28 = new Tile(25, 27, null, Ocean, 0, false, null, null, null);
        Tile tile26_29 = new Tile(25, 28, null, Ocean, 0, false, null, null, null);
        Tile tile26_30 = new Tile(25, 29, null, Ocean, 0, false, null, null, null);
        Tile tile26_31 = new Tile(25, 30, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 16; i < 31; i++) {
            tile = new Tile (25, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(25, 31, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile26_33 = new Tile(25, 32, null, Desert, 0, false, null, null, null);
        Tile tile26_34 = new Tile(25, 33, null, Desert, 0, false, null, null, null);
        Tile tile26_35 = new Tile(25, 34, null, Desert, 0, false, null, null, null);
        Tile tile26_36 = new Tile(25, 35, null, Desert, 0, false, null, null, null);
        Tile tile26_37 = new Tile(25, 36, null, Desert, 0, false, null, null, null);
        Tile tile26_38 = new Tile(25, 37, null, Desert, 0, false, null, null, null);
        Tile tile26_39 = new Tile(25, 38, null, Desert, 0, false, null, null, null);
        Tile tile26_40 = new Tile(25, 39, null, Desert, 0, false, null, null, null);
        Tile tile26_41 = new Tile(25, 40, null, Desert, 0, false, null, null, null);
        Tile tile26_42 = new Tile(25, 41, null, Desert, 0, false, null, null, null);
        Tile tile26_43 = new Tile(25, 42, null, Desert, 0, false, null, null, null);
        */
        for (int i = 32; i < 43; i++) {
            tile = new Tile (25, i, null, Desert, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

        tile = new Tile(25, 43, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 44, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 45, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 46, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 47, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 48, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 49, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 50, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 51, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 52, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 53, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 54, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 55, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 56, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 57, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 58, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 59, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 60, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 61, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 62, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 63, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 64, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 65, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        /*
        Tile tile26_67 = new Tile(25, 66, null, Ocean, 0, false, null, null, null);
        Tile tile26_68 = new Tile(25, 67, null, Ocean, 0, false, null, null, null);
        Tile tile26_69 = new Tile(25, 68, null, Ocean, 0, false, null, null, null);
        Tile tile26_70 = new Tile(25, 69, null, Ocean, 0, false, null, null, null);
        Tile tile26_71 = new Tile(25, 70, null, Ocean, 0, false, null, null, null);
        Tile tile26_72 = new Tile(25, 71, null, Ocean, 0, false, null, null, null);
        Tile tile26_73 = new Tile(25, 72, null, Ocean, 0, false, null, null, null);
        Tile tile26_74 = new Tile(25, 73, null, Ocean, 0, false, null, null, null);
        Tile tile26_75 = new Tile(25, 74, null, Ocean, 0, false, null, null, null);
        Tile tile26_76 = new Tile(25, 75, null, Ocean, 0, false, null, null, null);
        Tile tile26_77 = new Tile(25, 76, null, Ocean, 0, false, null, null, null);
        Tile tile26_78 = new Tile(25, 77, null, Ocean, 0, false, null, null, null);
        Tile tile26_79 = new Tile(25, 78, null, Ocean, 0, false, null, null, null);
        Tile tile26_80 = new Tile(25, 79, null, Ocean, 0, false, null, null, null);
        */
        for (int i = 66; i < 80; i++) {
            tile = new Tile (25, i, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }

    }
}
