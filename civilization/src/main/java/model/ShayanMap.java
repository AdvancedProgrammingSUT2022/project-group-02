package model;

import java.util.ArrayList;

public class ShayanMap {
    public static ArrayList<Tile> myTiles() {
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
        //13th row
        // between asia and america
        Tile tile13_1 = new Tile(12, 0, null, Ocean, 0, false, null, null, null);
        Tile tile13_2 = new Tile(12, 1, null, Ocean, 0, false, null, null, null);
        Tile tile13_3 = new Tile(12, 2, null, Ocean, 0, false, null, null, null);
        Tile tile13_4 = new Tile(12, 3, null, Ocean, 0, false, null, null, null);
        Tile tile13_5 = new Tile(12, 4, null, Ocean, 0, false, null, null, null);
        Tile tile13_6 = new Tile(12, 5, null, Ocean, 0, false, null, null, null);
        Tile tile13_7 = new Tile(12, 6, null, Ocean, 0, false, null, null, null);
        Tile tile13_8 = new Tile(12, 7, null, Ocean, 0, false, null, null, null);
        Tile tile13_9 = new Tile(12, 8, null, Ocean, 0, false, null, null, null);
        // america
        Tile tile13_10 = new Tile(12, 9, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_11 = new Tile(12, 10, null, Mountain, 0, false, null, null, null);
        Tile tile13_12 = new Tile(12, 11, null, GrassLand, 0, false, null, null, null);
        Tile tile13_13 = new Tile(12, 12, null, GrassLand, 0, false, null, null, null);
        Tile tile13_14 = new Tile(12, 13, null, GrassLand, 0, false, null, null, null);
        Tile tile13_15 = new Tile(12, 14, null, Ocean, 0, false, null, null, null);
        Tile tile13_16 = new Tile(12, 15, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_17 = new Tile(12, 16, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_18 = new Tile(12, 17, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_19 = new Tile(12, 18, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_20 = new Tile(12, 19, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_21 = new Tile(12, 20, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_22 = new Tile(12, 21, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_23 = new Tile(12, 22, null, Mountain, 0, false, null, null, Forest);
        Tile tile13_24 = new Tile(12, 23, null, Mountain, 0, false, null, null, Forest);
        //between europe and america
        Tile tile13_25 = new Tile(12, 24, null, Ocean, 0, false, null, null, null);
        Tile tile13_26 = new Tile(12, 25, null, Ocean, 0, false, null, null, null);
        Tile tile13_27 = new Tile(12, 26, null, Ocean, 0, false, null, null, null);
        Tile tile13_28 = new Tile(12, 27, null, Ocean, 0, false, null, null, null);
        Tile tile13_29 = new Tile(12, 28, null, Ocean, 0, false, null, null, null);
        Tile tile13_30 = new Tile(12, 39, null, Ocean, 0, false, null, null, null);
        Tile tile13_31 = new Tile(12, 30, null, Ocean, 0, false, null, null, null);
        Tile tile13_32 = new Tile(12, 31, null, Ocean, 0, false, null, null, null);
        Tile tile13_33 = new Tile(12, 32, null, Ocean, 0, false, null, null, null);
        // england
        Tile tile13_34 = new Tile(12, 33, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_35 = new Tile(12, 34, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_36 = new Tile(12, 35, null, GrassLand, 0, false, null, null, Forest);
        // between england and france
        Tile tile13_37 = new Tile(12, 36, null, Ocean, 0, false, null, null, null);
        // 33 europe and asia
        Tile tile13_38 = new Tile(12, 37, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_39 = new Tile(12, 38, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_40 = new Tile(12, 39, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_41 = new Tile(12, 40, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_42 = new Tile(12, 41, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_43 = new Tile(12, 42, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_44 = new Tile(12, 43, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_45 = new Tile(12, 44, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_46 = new Tile(12, 45, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_47 = new Tile(12, 46, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_48 = new Tile(12, 47, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_49 = new Tile(12, 48, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_50 = new Tile(12, 49, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_51 = new Tile(12, 50, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_52 = new Tile(12, 51, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_53 = new Tile(12, 52, null, Mountain, 0, false, null, null, Forest);
        Tile tile13_54 = new Tile(12, 53, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_55 = new Tile(12, 54, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_56 = new Tile(12, 55, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_57 = new Tile(12, 56, null, Hill, 0, false, null, null, Forest);
        Tile tile13_58 = new Tile(12, 57, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_59 = new Tile(12, 58, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_60 = new Tile(12, 59, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_61 = new Tile(12, 60, null, Hill, 0, false, null, null, Forest);
        Tile tile13_62 = new Tile(12, 61, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_63 = new Tile(12, 62, null, Hill, 0, false, null, null, Forest);
        Tile tile13_64 = new Tile(12, 63, null, Hill, 0, false, null, null, Forest);
        Tile tile13_65 = new Tile(12, 64, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_66 = new Tile(12, 65, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_67 = new Tile(12, 66, null, Plain, 0, false, null, null, Forest);
        Tile tile13_68 = new Tile(12, 67, null, Plain, 0, false, null, null, Forest);
        Tile tile13_69 = new Tile(12, 68, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_70 = new Tile(12, 69, null, GrassLand, 0, false, null, null, Forest);
        // between china and japan
        Tile tile13_71 = new Tile(12, 70, null, Ocean, 0, false, null, null, null);
        Tile tile13_72 = new Tile(12, 71, null, Ocean, 0, false, null, null, null);
        Tile tile13_73 = new Tile(12, 72, null, Ocean, 0, false, null, null, null);
        Tile tile13_74 = new Tile(12, 73, null, Ocean, 0, false, null, null, null);
        // japan
        Tile tile13_75 = new Tile(12, 74, null, Hill, 0, false, null, null, Forest);
        Tile tile13_76 = new Tile(12, 75, null, Hill, 0, false, null, null, Forest);
        // between Japan and america
        Tile tile13_77 = new Tile(12, 76, null, Ocean, 0, false, null, null, null);
        Tile tile13_78 = new Tile(12, 77, null, GrassLand, 0, false, null, null, Forest);
        Tile tile13_79 = new Tile(12, 78, null, Ocean, 0, false, null, null, null);
        Tile tile13_80 = new Tile(12, 79, null, Ocean, 0, false, null, null, null);

        //14th row between america and asia

        Tile tile14_1 = new Tile(13, 0, null, Ocean, 0, false, null, null, null);
        Tile tile14_2 = new Tile(13, 1, null, Ocean, 0, false, null, null, null);
        Tile tile14_3 = new Tile(13, 2, null, Ocean, 0, false, null, null, null);
        Tile tile14_4 = new Tile(13, 3, null, Ocean, 0, false, null, null, null);
        Tile tile14_5 = new Tile(13, 4, null, Ocean, 0, false, null, null, null);
        Tile tile14_6 = new Tile(13, 5, null, Ocean, 0, false, null, null, null);
        Tile tile14_7 = new Tile(13, 6, null, Ocean, 0, false, null, null, null);
        Tile tile14_8 = new Tile(13, 7, null, Ocean, 0, false, null, null, null);
        //west america
        Tile tile14_9 = new Tile(13, 8, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_10 = new Tile(13, 9, null, Hill, 0, false, null, null, Forest);
        Tile tile14_11 = new Tile(13, 10, null, Hill, 0, false, null, null, Forest);
        Tile tile14_12 = new Tile(13, 11, null, GrassLand, 0, false, null, null, Marsh);
        Tile tile14_13 = new Tile(13, 12, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_14 = new Tile(13, 13, null, GrassLand, 0, false, null, null, Forest);
        // a lake
        Tile tile14_15 = new Tile(13, 14, null, Ocean, 0, false, null, null, null);
        // east america
        Tile tile14_16 = new Tile(13, 15, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_17 = new Tile(13, 16, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_18 = new Tile(13, 17, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_19 = new Tile(13, 18, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_20 = new Tile(13, 19, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_21 = new Tile(13, 20, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_22 = new Tile(13, 21, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_23 = new Tile(13, 22, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_24 = new Tile(13, 23, null, GrassLand, 0, false, null, null, Forest);
        // between america and europe
        Tile tile14_25 = new Tile(13, 24, null, Ocean, 0, false, null, null, null);
        Tile tile14_26 = new Tile(13, 25, null, Ocean, 0, false, null, null, null);
        Tile tile14_27 = new Tile(13, 26, null, Ocean, 0, false, null, null, null);
        Tile tile14_28 = new Tile(13, 27, null, Ocean, 0, false, null, null, null);
        Tile tile14_29 = new Tile(13, 28, null, Ocean, 0, false, null, null, null);
        Tile tile14_30 = new Tile(13, 29, null, Ocean, 0, false, null, null, null);
        Tile tile14_31 = new Tile(13, 30, null, Ocean, 0, false, null, null, null);
        Tile tile14_32 = new Tile(13, 31, null, Ocean, 0, false, null, null, null);
        Tile tile14_33 = new Tile(13, 32, null, Ocean, 0, false, null, null, null);
        Tile tile14_34 = new Tile(13, 33, null, Ocean, 0, false, null, null, null);
        Tile tile14_35 = new Tile(13, 34, null, Ocean, 0, false, null, null, null);
        Tile tile14_36 = new Tile(13, 35, null, Ocean, 0, false, null, null, null);
        // europe to asia
        Tile tile14_37 = new Tile(13, 36, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_38 = new Tile(13, 37, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_39 = new Tile(13, 38, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_40 = new Tile(13, 39, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_41 = new Tile(13, 40, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_42 = new Tile(13, 41, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_43 = new Tile(13, 42, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_44 = new Tile(13, 43, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_45 = new Tile(13, 44, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_46 = new Tile(13, 45, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_47 = new Tile(13, 46, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_48 = new Tile(13, 47, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_49 = new Tile(13, 48, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_50 = new Tile(13, 49, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_51 = new Tile(13, 50, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_52 = new Tile(13, 51, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_53 = new Tile(13, 52, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_54 = new Tile(13, 53, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_55 = new Tile(13, 54, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_56 = new Tile(13, 55, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_57 = new Tile(13, 56, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_58 = new Tile(13, 57, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_59 = new Tile(13, 58, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_60 = new Tile(13, 59, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_61 = new Tile(13, 60, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_62 = new Tile(13, 61, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_63 = new Tile(13, 62, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_64 = new Tile(13, 63, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_65 = new Tile(13, 64, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_66 = new Tile(13, 65, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_67 = new Tile(13, 66, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_68 = new Tile(13, 67, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_69 = new Tile(13, 68, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_70 = new Tile(13, 69, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_71 = new Tile(13, 70, null, GrassLand, 0, false, null, null, Forest);
        Tile tile14_72 = new Tile(13, 71, null, GrassLand, 0, false, null, null, Forest);
        // east asian sea
        Tile tile14_73 = new Tile(13, 72, null, Ocean, 0, false, null, null, null);
        Tile tile14_74 = new Tile(13, 73, null, Ocean, 0, false, null, null, null);
        Tile tile14_75 = new Tile(13, 74, null, Ocean, 0, false, null, null, null);
        Tile tile14_76 = new Tile(13, 75, null, Ocean, 0, false, null, null, null);
        Tile tile14_77 = new Tile(13, 76, null, Ocean, 0, false, null, null, null);
        Tile tile14_78 = new Tile(13, 77, null, Ocean, 0, false, null, null, null);
        Tile tile14_79 = new Tile(13, 78, null, Ocean, 0, false, null, null, null);
        Tile tile14_80 = new Tile(13, 79, null, Ocean, 0, false, null, null, null);

        //15th row

        // between asia and america
        Tile tile15_1 = new Tile(14, 0, null, Ocean, 0, false, null, null, null);
        Tile tile15_2 = new Tile(14, 1, null, Ocean, 0, false, null, null, null);
        Tile tile15_3 = new Tile(14, 2, null, Ocean, 0, false, null, null, null);
        Tile tile15_4 = new Tile(14, 3, null, Ocean, 0, false, null, null, null);
        Tile tile15_5 = new Tile(14, 4, null, Ocean, 0, false, null, null, null);
        Tile tile15_6 = new Tile(14, 5, null, Ocean, 0, false, null, null, null);
        Tile tile15_7 = new Tile(14, 6, null, Ocean, 0, false, null, null, null);
        Tile tile15_8 = new Tile(14, 7, null, Ocean, 0, false, null, null, null);
        Tile tile15_9 = new Tile(14, 8, null, Ocean, 0, false, null, null, null);
        //west america
        Tile tile15_10 = new Tile(14, 9, null, Mountain, 0, false, null, null, null);
        Tile tile15_11 = new Tile(14, 10, null, Hill, 0, false, null, null, Forest);
        Tile tile15_12 = new Tile(14, 11, null, Mountain, 0, false, null, null, null);
        Tile tile15_13 = new Tile(14, 12, null, Hill, 0, false, null, null, Forest);
        Tile tile15_14 = new Tile(14, 13, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_15 = new Tile(14, 14, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_16 = new Tile(14, 15, null, GrassLand, 0, false, null, null, Forest);
        //a lake
        Tile tile15_17 = new Tile(14, 16, null, Ocean, 0, false, null, null, null);
        // east america
        Tile tile15_18 = new Tile(14, 17, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_19 = new Tile(14, 18, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_20 = new Tile(14, 19, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_21 = new Tile(14, 20, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_22 = new Tile(14, 21, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_23 = new Tile(14, 22, null, GrassLand, 0, false, null, null, Forest);
        // america to europe
        Tile tile15_24 = new Tile(14, 23, null, Ocean, 0, false, null, null, null);
        Tile tile15_25 = new Tile(14, 24, null, Ocean, 0, false, null, null, null);
        Tile tile15_26 = new Tile(14, 25, null, Ocean, 0, false, null, null, null);
        Tile tile15_27 = new Tile(14, 26, null, Ocean, 0, false, null, null, null);
        Tile tile15_28 = new Tile(14, 27, null, Ocean, 0, false, null, null, null);
        Tile tile15_29 = new Tile(14, 28, null, Ocean, 0, false, null, null, null);
        Tile tile15_30 = new Tile(14, 29, null, Ocean, 0, false, null, null, null);
        Tile tile15_31 = new Tile(14, 30, null, Ocean, 0, false, null, null, null);
        Tile tile15_32 = new Tile(14, 31, null, Ocean, 0, false, null, null, null);
        Tile tile15_33 = new Tile(14, 32, null, Ocean, 0, false, null, null, null);
        //europe and asia 38
        Tile tile15_34 = new Tile(14, 33, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_35 = new Tile(14, 34, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_36 = new Tile(14, 35, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_37 = new Tile(14, 36, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_38 = new Tile(14, 37, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_39 = new Tile(14, 38, null, Hill, 0, false, null, null, Forest);
        Tile tile15_40 = new Tile(14, 39, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_41 = new Tile(14, 40, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_42 = new Tile(14, 41, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_43 = new Tile(14, 42, null, Hill, 0, false, null, null, Forest);
        Tile tile15_44 = new Tile(14, 43, null, Hill, 0, false, null, null, Forest);
        Tile tile15_45 = new Tile(14, 44, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_46 = new Tile(14, 45, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_47 = new Tile(14, 46, null, Plain, 0, false, null, null, null);
        Tile tile15_48 = new Tile(14, 47, null, Plain, 0, false, null, null, null);
        Tile tile15_49 = new Tile(14, 48, null, Plain, 0, false, null, null, null);
        Tile tile15_50 = new Tile(14, 49, null, Plain, 0, false, null, null, null);
        Tile tile15_51 = new Tile(14, 50, null, Plain, 0, false, null, null, null);
        Tile tile15_52 = new Tile(14, 51, null, Plain, 0, false, null, null, null);
        Tile tile15_53 = new Tile(14, 52, null, Hill, 0, false, null, null, null);
        Tile tile15_54 = new Tile(14, 53, null, Plain, 0, false, null, null, null);
        Tile tile15_55 = new Tile(14, 54, null, Plain, 0, false, null, null, null);
        Tile tile15_56 = new Tile(14, 55, null, Desert, 0, false, null, null, null);
        Tile tile15_57 = new Tile(14, 56, null, Desert, 0, false, null, null, null);
        Tile tile15_58 = new Tile(14, 57, null, Desert, 0, false, null, null, null);
        Tile tile15_59 = new Tile(14, 58, null, Desert, 0, false, null, null, null);
        Tile tile15_60 = new Tile(14, 59, null, Mountain, 0, false, null, null, null);
        Tile tile15_61 = new Tile(14, 60, null, Mountain, 0, false, null, null, null);
        Tile tile15_62 = new Tile(14, 61, null, Mountain, 0, false, null, null, null);
        Tile tile15_63 = new Tile(14, 62, null, Desert, 0, false, null, null, Forest);
        Tile tile15_64 = new Tile(14, 63, null, Mountain, 0, false, null, null, null);
        Tile tile15_65 = new Tile(14, 64, null, Plain, 0, false, null, null, Forest);
        Tile tile15_66 = new Tile(14, 65, null, Mountain, 0, false, null, null, null);
        Tile tile15_67 = new Tile(14, 66, null, Mountain, 0, false, null, null, null);
        Tile tile15_68 = new Tile(14, 67, null, Plain, 0, false, null, null, Forest);
        Tile tile15_69 = new Tile(14, 68, null, Hill, 0, false, null, null, Forest);
        Tile tile15_70 = new Tile(14, 69, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_71 = new Tile(14, 70, null, GrassLand, 0, false, null, null, Forest);
        // east asian sea
        Tile tile15_72 = new Tile(14, 71, null, Ocean, 0, false, null, null, null);
        Tile tile15_73 = new Tile(14, 72, null, Ocean, 0, false, null, null, null);
        Tile tile15_74 = new Tile(14, 73, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_75 = new Tile(14, 74, null, GrassLand, 0, false, null, null, Forest);
        Tile tile15_76 = new Tile(14, 75, null, Ocean, 0, false, null, null, null);
        Tile tile15_77 = new Tile(14, 76, null, Ocean, 0, false, null, null, null);
        Tile tile15_78 = new Tile(14, 77, null, Ocean, 0, false, null, null, null);
        Tile tile15_79 = new Tile(14, 78, null, Ocean, 0, false, null, null, null);
        Tile tile15_80 = new Tile(14, 79, null, Ocean, 0, false, null, null, null);

        // 16th row
        //between asia and america
        Tile tile16_1 = new Tile(15, 0, null, Ocean, 0, false, null, null, null);
        Tile tile16_2 = new Tile(15, 1, null, Ocean, 0, false, null, null, null);
        Tile tile16_3 = new Tile(15, 2, null, Ocean, 0, false, null, null, null);
        Tile tile16_4 = new Tile(15, 3, null, Ocean, 0, false, null, null, null);
        Tile tile16_5 = new Tile(15, 4, null, Ocean, 0, false, null, null, null);
        Tile tile16_6 = new Tile(15, 5, null, Ocean, 0, false, null, null, null);
        Tile tile16_7 = new Tile(15, 6, null, Ocean, 0, false, null, null, null);
        Tile tile16_8 = new Tile(15, 7, null, Ocean, 0, false, null, null, null);
        // west america
        Tile tile16_9 = new Tile(15, 8, null, Hill, 0, false, null, null, Forest);
        Tile tile16_10 = new Tile(15, 9, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_11 = new Tile(15, 10, null, Hill, 0, false, null, null, Forest);
        Tile tile16_12 = new Tile(15, 11, null, Mountain, 0, false, null, null, null);
        Tile tile16_13 = new Tile(15, 12, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_14 = new Tile(15, 13, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_15 = new Tile(15, 14, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_16 = new Tile(15, 15, null, GrassLand, 0, false, null, null, Forest);
        // a lake
        Tile tile16_17 = new Tile(15, 16, null, Ocean, 0, false, null, null, null);
        Tile tile16_18 = new Tile(15, 17, null, Ocean, 0, false, null, null, null);
        //east america
        Tile tile16_19 = new Tile(15, 18, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_20 = new Tile(15, 19, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_21 = new Tile(15, 20, null, Hill, 0, false, null, null, Forest);
        Tile tile16_22 = new Tile(15, 21, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_23 = new Tile(15, 22, null, GrassLand, 0, false, null, null, Forest);
        // between america and europe
        Tile tile16_24 = new Tile(15, 23, null, Ocean, 0, false, null, null, null);
        Tile tile16_25 = new Tile(15, 24, null, Ocean, 0, false, null, null, null);
        Tile tile16_26 = new Tile(15, 25, null, Ocean, 0, false, null, null, null);
        Tile tile16_27 = new Tile(15, 26, null, Ocean, 0, false, null, null, null);
        Tile tile16_28 = new Tile(15, 27, null, Ocean, 0, false, null, null, null);
        Tile tile16_29 = new Tile(15, 28, null, Ocean, 0, false, null, null, null);
        Tile tile16_30 = new Tile(15, 29, null, Ocean, 0, false, null, null, null);
        Tile tile16_31 = new Tile(15, 30, null, Ocean, 0, false, null, null, null);
        Tile tile16_32 = new Tile(15, 31, null, Ocean, 0, false, null, null, null);
        Tile tile16_33 = new Tile(15, 32, null, Ocean, 0, false, null, null, null);
        // europe
        Tile tile16_34 = new Tile(15, 33, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_35 = new Tile(15, 34, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_36 = new Tile(15, 35, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_37 = new Tile(15, 36, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_38 = new Tile(15, 37, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_39 = new Tile(15, 38, null, Hill, 0, false, null, null, Forest);
        Tile tile16_40 = new Tile(15, 39, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_41 = new Tile(15, 40, null, Hill, 0, false, null, null, Forest);
        Tile tile16_42 = new Tile(15, 41, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_43 = new Tile(15, 42, null, Hill, 0, false, null, null, Forest);
        Tile tile16_44 = new Tile(15, 43, null, Hill, 0, false, null, null, Forest);
        Tile tile16_45 = new Tile(15, 44, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_46 = new Tile(15, 45, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_47 = new Tile(15, 46, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_48 = new Tile(15, 47, null, Plain, 0, false, null, null, null);
        Tile tile16_49 = new Tile(15, 48, null, Plain, 0, false, null, null, null);
        // Caspian sea
        Tile tile16_50 = new Tile(15, 49, null, Ocean, 0, false, null, null, null);
        // asia
        Tile tile16_51 = new Tile(15, 50, null, Plain, 0, false, null, null, null);
        Tile tile16_52 = new Tile(15, 51, null, Desert, 0, false, null, null, null);
        Tile tile16_53 = new Tile(15, 52, null, Desert, 0, false, null, null, Oasis);
        Tile tile16_54 = new Tile(15, 53, null, Desert, 0, false, null, null, null);
        Tile tile16_55 = new Tile(15, 54, null, Desert, 0, false, null, null, null);
        Tile tile16_56 = new Tile(15, 55, null, Hill, 0, false, null, null, null);
        Tile tile16_57 = new Tile(15, 56, null, Mountain, 0, false, null, null, null);
        Tile tile16_58 = new Tile(15, 57, null, Mountain, 0, false, null, null, null);
        Tile tile16_59 = new Tile(15, 58, null, Desert, 0, false, null, null, null);
        Tile tile16_60 = new Tile(15, 59, null, Desert, 0, false, null, null, null);
        Tile tile16_61 = new Tile(15, 60, null, Desert, 0, false, null, null, null);
        Tile tile16_62 = new Tile(15, 61, null, Desert, 0, false, null, null, null);
        Tile tile16_63 = new Tile(15, 62, null, Desert, 0, false, null, null, null);
        Tile tile16_64 = new Tile(15, 63, null, Plain, 0, false, null, null, null);
        Tile tile16_65 = new Tile(15, 64, null, Plain, 0, false, null, null, null);
        Tile tile16_66 = new Tile(15, 65, null, Desert, 0, false, null, null, Oasis);
        Tile tile16_67 = new Tile(15, 66, null, Plain, 0, false, null, null, null);
        Tile tile16_68 = new Tile(15, 67, null, Hill, 0, false, null, null, Forest);
        Tile tile16_69 = new Tile(15, 68, null, GrassLand, 0, false, null, null, Forest);
        Tile tile16_70 = new Tile(15, 69, null, Mountain, 0, false, null, null, Forest);
        // east asian sea
        Tile tile16_71 = new Tile(15, 70, null, Ocean, 0, false, null, null, null);
        Tile tile16_72 = new Tile(15, 71, null, Ocean, 0, false, null, null, null);
        // japan
        Tile tile16_73 = new Tile(15, 72, null, GrassLand, 0, false, null, null, null);
        Tile tile16_74 = new Tile(15, 73, null, GrassLand, 0, false, null, null, null);
        // between asia and europe
        Tile tile16_75 = new Tile(15, 74, null, Ocean, 0, false, null, null, null);
        Tile tile16_76 = new Tile(15, 75, null, Ocean, 0, false, null, null, null);
        Tile tile16_77 = new Tile(15, 76, null, Ocean, 0, false, null, null, null);
        Tile tile16_78 = new Tile(15, 77, null, Ocean, 0, false, null, null, null);
        Tile tile16_79 = new Tile(15, 78, null, Ocean, 0, false, null, null, null);
        Tile tile16_80 = new Tile(15, 79, null, Ocean, 0, false, null, null, null);

        // 17th row
        // between asia and america
        Tile tile17_1 = new Tile(16, 0, null, Ocean, 0, false, null, null, null);
        Tile tile17_2 = new Tile(16, 1, null, Ocean, 0, false, null, null, null);
        Tile tile17_3 = new Tile(16, 2, null, Ocean, 0, false, null, null, null);
        Tile tile17_4 = new Tile(16, 3, null, Ocean, 0, false, null, null, null);
        Tile tile17_5 = new Tile(16, 4, null, Ocean, 0, false, null, null, null);
        Tile tile17_6 = new Tile(16, 5, null, Ocean, 0, false, null, null, null);
        Tile tile17_7 = new Tile(16, 6, null, Ocean, 0, false, null, null, null);
        Tile tile17_8 = new Tile(16, 7, null, Ocean, 0, false, null, null, null);
        Tile tile17_9 = new Tile(16, 8, null, Ocean, 0, false, null, null, null);
        //west america
        Tile tile17_10 = new Tile(16, 9, null, Hill, 0, false, null, null, null);
        Tile tile17_11 = new Tile(16, 10, null, Mountain, 0, false, null, null, null);
        Tile tile17_12 = new Tile(16, 11, null, Plain, 0, false, null, null, null);
        Tile tile17_13 = new Tile(16, 12, null, Plain, 0, false, null, null, null);
        Tile tile17_14 = new Tile(16, 13, null, Hill, 0, false, null, null, null);
        Tile tile17_15 = new Tile(16, 14, null, GrassLand, 0, false, null, null, Forest);
        Tile tile17_16 = new Tile(16, 15, null, GrassLand, 0, false, null, null, Forest);
        // a lake
        Tile tile17_17 = new Tile(16, 16, null, Ocean, 0, false, null, null, null);
        // east america
        Tile tile17_18 = new Tile(16, 17, null, GrassLand, 0, false, null, null, Forest);
        Tile tile17_19 = new Tile(16, 18, null, GrassLand, 0, false, null, null, Forest);
        Tile tile17_20 = new Tile(16, 19, null, GrassLand, 0, false, null, null, Forest);
        Tile tile17_21 = new Tile(16, 20, null, GrassLand, 0, false, null, null, Forest);
        Tile tile17_22 = new Tile(16, 21, null, GrassLand, 0, false, null, null, Forest);
        // between america and europe
        Tile tile17_23 = new Tile(16, 22, null, Ocean, 0, false, null, null, null);
        Tile tile17_24 = new Tile(16, 23, null, Ocean, 0, false, null, null, null);
        Tile tile17_25 = new Tile(16, 24, null, Ocean, 0, false, null, null, null);
        Tile tile17_26 = new Tile(16, 25, null, Ocean, 0, false, null, null, null);
        Tile tile17_27 = new Tile(16, 26, null, Ocean, 0, false, null, null, null);
        Tile tile17_28 = new Tile(16, 27, null, Ocean, 0, false, null, null, null);
        Tile tile17_29 = new Tile(16, 28, null, Ocean, 0, false, null, null, null);
        Tile tile17_30 = new Tile(16, 29, null, Ocean, 0, false, null, null, null);
        Tile tile17_31 = new Tile(16, 30, null, Ocean, 0, false, null, null, null);
        Tile tile17_32 = new Tile(16, 31, null, Ocean, 0, false, null, null, null);
        Tile tile17_33 = new Tile(16, 32, null, Ocean, 0, false, null, null, null);
        Tile tile17_34 = new Tile(16, 33, null, Ocean, 0, false, null, null, null);
        // europe
        Tile tile17_35 = new Tile(16, 34, null, GrassLand, 0, false, null, null, Forest);
        Tile tile17_36 = new Tile(16, 35, null, GrassLand, 0, false, null, null, Forest);
        Tile tile17_37 = new Tile(16, 36, null, GrassLand, 0, false, null, null, Forest);
        Tile tile17_38 = new Tile(16, 37, null, GrassLand, 0, false, null, null, Forest);
        Tile tile17_39 = new Tile(16, 38, null, Mountain, 0, false, null, null, null);
        Tile tile17_40 = new Tile(16, 39, null, Mountain, 0, false, null, null, null);
        Tile tile17_41 = new Tile(16, 40, null, Mountain, 0, false, null, null, null);
        Tile tile17_42 = new Tile(16, 41, null, Hill, 0, false, null, null, Forest);
        Tile tile17_43 = new Tile(16, 42, null, GrassLand, 0, false, null, null, Forest);
        Tile tile17_44 = new Tile(16, 43, null, GrassLand, 0, false, null, null, Forest);
        Tile tile17_45 = new Tile(16, 44, null, Hill, 0, false, null, null, Forest);
        // Black Sea
        Tile tile17_46 = new Tile(16, 45, null, Ocean, 0, false, null, null, null);
        Tile tile17_47 = new Tile(16, 46, null, Ocean, 0, false, null, null, null);
        Tile tile17_48 = new Tile(16, 47, null, Ocean, 0, false, null, null, null);
        // island
        Tile tile17_49 = new Tile(16, 48, null, Plain, 0, false, null, null, null);
        // caspian sea
        Tile tile17_50 = new Tile(16, 49, null, Ocean, 0, false, null, null, null);
        Tile tile17_51 = new Tile(16, 50, null, Ocean, 0, false, null, null, null);
        // asia
        Tile tile17_52 = new Tile(16, 51, null, Desert, 0, false, null, null, null);
        Tile tile17_53 = new Tile(16, 52, null, Desert, 0, false, null, null, null);
        Tile tile17_54 = new Tile(16, 53, null, Desert, 0, false, null, null, null);
        Tile tile17_55 = new Tile(16, 54, null, Mountain, 0, false, null, null, null);
        Tile tile17_56 = new Tile(16, 55, null, Mountain, 0, false, null, null, null);
        Tile tile17_57 = new Tile(16, 56, null, Mountain, 0, false, null, null, null);
        Tile tile17_58 = new Tile(16, 57, null, Hill, 0, false, null, null, null);
        Tile tile17_59 = new Tile(16, 58, null, Hill, 0, false, null, null, null);
        Tile tile17_60 = new Tile(16, 59, null, Desert, 0, false, null, null, null);
        Tile tile17_61 = new Tile(16, 60, null, Hill, 0, false, null, null, null);
        Tile tile17_62 = new Tile(16, 61, null, Desert, 0, false, null, null, null);
        Tile tile17_63 = new Tile(16, 62, null, Desert, 0, false, null, null, null);
        Tile tile17_64 = new Tile(16, 63, null, Desert, 0, false, null, null, null);
        Tile tile17_65 = new Tile(16, 64, null, Desert, 0, false, null, null, null);
        Tile tile17_66 = new Tile(16, 65, null, Desert, 0, false, null, null, null);
        Tile tile17_67 = new Tile(16, 66, null, Hill, 0, false, null, null, null);
        Tile tile17_68 = new Tile(16, 67, null, Plain, 0, false, null, null, null);
        Tile tile17_69 = new Tile(16, 68, null, GrassLand, 0, false, null, null, Forest);
        Tile tile17_70 = new Tile(16, 69, null, GrassLand, 0, false, null, null, Forest);
        // east asian sea
        Tile tile17_71 = new Tile(16, 70, null, Ocean, 0, false, null, null, null);
        Tile tile17_72 = new Tile(16, 71, null, Ocean, 0, false, null, null, null);
        // japan
        Tile tile17_73 = new Tile(16, 72, null, GrassLand, 0, false, null, null, null);
        Tile tile17_74 = new Tile(16, 73, null, GrassLand, 0, false, null, null, null);
        // between asia and america
        Tile tile17_75 = new Tile(16, 74, null, Ocean, 0, false, null, null, null);
        Tile tile17_76 = new Tile(16, 75, null, Ocean, 0, false, null, null, null);
        Tile tile17_77 = new Tile(16, 76, null, Ocean, 0, false, null, null, null);
        Tile tile17_78 = new Tile(16, 77, null, Ocean, 0, false, null, null, null);
        Tile tile17_79 = new Tile(16, 78, null, Ocean, 0, false, null, null, null);
        Tile tile17_80 = new Tile(16, 79, null, Ocean, 0, false, null, null, null);

        // 18th row

        Tile tile18_1 = new Tile(17, 0, null, Ocean, 0, false, null, null, null);
        Tile tile18_2 = new Tile(17, 1, null, Ocean, 0, false, null, null, null);
        Tile tile18_3 = new Tile(17, 2, null, Ocean, 0, false, null, null, null);
        Tile tile18_4 = new Tile(17, 3, null, Ocean, 0, false, null, null, null);
        Tile tile18_5 = new Tile(17, 4, null, Ocean, 0, false, null, null, null);
        Tile tile18_6 = new Tile(17, 5, null, Ocean, 0, false, null, null, null);
        Tile tile18_7 = new Tile(17, 6, null, Ocean, 0, false, null, null, null);
        Tile tile18_8 = new Tile(17, 7, null, Ocean, 0, false, null, null, null);
        // america
        Tile tile18_9 = new Tile(17, 8, null, Plain, 0, false, null, null, null);
        Tile tile18_10 = new Tile(17, 9, null, Hill, 0, false, null, null, null);
        Tile tile18_11 = new Tile(17, 10, null, Mountain, 0, false, null, null, null);
        Tile tile18_12 = new Tile(17, 11, null, Plain, 0, false, null, null, null);
        Tile tile18_13 = new Tile(17, 12, null, Plain, 0, false, null, null, null);
        Tile tile18_14 = new Tile(17, 13, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_15 = new Tile(17, 14, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_16 = new Tile(17, 15, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_17 = new Tile(17, 16, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_18 = new Tile(17, 17, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_19 = new Tile(17, 18, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_20 = new Tile(17, 19, null, GrassLand, 0, false, null, null, Forest);
        // between america and europe
        Tile tile18_21 = new Tile(17, 20, null, Ocean, 0, false, null, null, null);
        Tile tile18_22 = new Tile(17, 21, null, Ocean, 0, false, null, null, null);
        Tile tile18_23 = new Tile(17, 22, null, Ocean, 0, false, null, null, null);
        Tile tile18_24 = new Tile(17, 23, null, Ocean, 0, false, null, null, null);
        Tile tile18_25 = new Tile(17, 24, null, Ocean, 0, false, null, null, null);
        Tile tile18_26 = new Tile(17, 25, null, Ocean, 0, false, null, null, null);
        Tile tile18_27 = new Tile(17, 26, null, Ocean, 0, false, null, null, null);
        Tile tile18_28 = new Tile(17, 27, null, Ocean, 0, false, null, null, null);
        Tile tile18_29 = new Tile(17, 28, null, Ocean, 0, false, null, null, null);
        Tile tile18_30 = new Tile(17, 29, null, Ocean, 0, false, null, null, null);
        Tile tile18_31 = new Tile(17, 30, null, Ocean, 0, false, null, null, null);
        Tile tile18_32 = new Tile(17, 31, null, Ocean, 0, false, null, null, null);
        Tile tile18_33 = new Tile(17, 32, null, Ocean, 0, false, null, null, null);
        Tile tile18_34 = new Tile(17, 33, null, Ocean, 0, false, null, null, null);
        // europe
        Tile tile18_35 = new Tile(17, 34, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_36 = new Tile(17, 35, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_37 = new Tile(17, 36, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_38 = new Tile(17, 37, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_39 = new Tile(17, 38, null, Hill, 0, false, null, null, null);
        Tile tile18_40 = new Tile(17, 39, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_41 = new Tile(17, 40, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_42 = new Tile(17, 41, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_43 = new Tile(17, 42, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_44 = new Tile(17, 43, null, Hill, 0, false, null, null, null);
        Tile tile18_45 = new Tile(17, 44, null, GrassLand, 0, false, null, null, Forest);
        // Black Sea
        Tile tile18_46 = new Tile(17, 45, null, Ocean, 0, false, null, null, null);
        Tile tile18_47 = new Tile(17, 46, null, Ocean, 0, false, null, null, null);
        // island
        Tile tile18_48 = new Tile(17, 47, null, Mountain, 0, false, null, null, null);
        Tile tile18_49 = new Tile(17, 48, null, Hill, 0, false, null, null, null);
        // caspian sea
        Tile tile18_50 = new Tile(17, 49, null, Ocean, 0, false, null, null, null);
        // asia
        Tile tile18_51 = new Tile(17, 50, null, Desert, 0, false, null, null, null);
        Tile tile18_52 = new Tile(17, 51, null, Desert, 0, false, null, null, null);
        Tile tile18_53 = new Tile(17, 52, null, Desert, 0, false, null, null, null);
        Tile tile18_54 = new Tile(17, 53, null, Mountain, 0, false, null, null, null);
        Tile tile18_55 = new Tile(17, 54, null, Hill, 0, false, null, null, null);
        Tile tile18_56 = new Tile(17, 55, null, Desert, 0, false, null, null, null);
        Tile tile18_57 = new Tile(17, 56, null, Desert, 0, false, null, null, null);
        Tile tile18_58 = new Tile(17, 57, null, Desert, 0, false, null, null, null);
        Tile tile18_59 = new Tile(17, 58, null, Desert, 0, false, null, null, null);
        Tile tile18_60 = new Tile(17, 59, null, Desert, 0, false, null, null, null);
        Tile tile18_61 = new Tile(17, 60, null, Desert, 0, false, null, null, null);
        Tile tile18_62 = new Tile(17, 61, null, Desert, 0, false, null, null, null);
        Tile tile18_63 = new Tile(17, 62, null, Mountain, 0, false, null, null, null);
        Tile tile18_64 = new Tile(17, 63, null, Plain, 0, false, null, null, null);
        Tile tile18_65 = new Tile(17, 64, null, Plain, 0, false, null, null, null);
        Tile tile18_66 = new Tile(17, 65, null, Plain, 0, false, null, null, Forest);
        Tile tile18_67 = new Tile(17, 66, null, Plain, 0, false, null, null, null);
        Tile tile18_68 = new Tile(17, 67, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_69 = new Tile(17, 68, null, Hill, 0, false, null, null, Forest);
        // east asian sea
        Tile tile18_70 = new Tile(17, 69, null, Ocean, 0, false, null, null, null);
        Tile tile18_71 = new Tile(17, 70, null, Ocean, 0, false, null, null, null);
        // japan
        Tile tile18_72 = new Tile(17, 71, null, GrassLand, 0, false, null, null, Forest);
        Tile tile18_73 = new Tile(17, 72, null, Hill, 0, false, null, null, Forest);
        // between asia and america
        Tile tile18_74 = new Tile(17, 73, null, Ocean, 0, false, null, null, null);
        Tile tile18_75 = new Tile(17, 74, null, Ocean, 0, false, null, null, null);
        Tile tile18_76 = new Tile(17, 75, null, Ocean, 0, false, null, null, null);
        Tile tile18_77 = new Tile(17, 76, null, Ocean, 0, false, null, null, null);
        Tile tile18_78 = new Tile(17, 77, null, Ocean, 0, false, null, null, null);
        Tile tile18_79 = new Tile(17, 78, null, Ocean, 0, false, null, null, null);
        Tile tile18_80 = new Tile(17, 79, null, Ocean, 0, false, null, null, null);

        // 19th row
        // between asia and america
        Tile tile19_1 = new Tile(18, 0, null, Ocean, 0, false, null, null, null);
        Tile tile19_2 = new Tile(18, 1, null, Ocean, 0, false, null, null, null);
        Tile tile19_3 = new Tile(18, 2, null, Ocean, 0, false, null, null, null);
        Tile tile19_4 = new Tile(18, 3, null, Ocean, 0, false, null, null, null);
        Tile tile19_5 = new Tile(18, 4, null, Ocean, 0, false, null, null, null);
        Tile tile19_6 = new Tile(18, 5, null, Ocean, 0, false, null, null, null);
        Tile tile19_7 = new Tile(18, 6, null, Ocean, 0, false, null, null, null);
        Tile tile19_8 = new Tile(18, 7, null, Ocean, 0, false, null, null, null);
        Tile tile19_9 = new Tile(18, 8, null, Ocean, 0, false, null, null, null);
        // america
        Tile tile19_10 = new Tile(18, 9, null, Plain, 0, false, null, null, null);
        Tile tile19_11 = new Tile(18, 10, null, Plain, 0, false, null, null, null);
        Tile tile19_12 = new Tile(18, 11, null, Plain, 0, false, null, null, null);
        Tile tile19_13 = new Tile(18, 12, null, Plain, 0, false, null, null, null);
        Tile tile19_14 = new Tile(18, 13, null, Plain, 0, false, null, null, null);
        Tile tile19_15 = new Tile(18, 14, null, GrassLand, 0, false, null, null, Forest);
        Tile tile19_16 = new Tile(18, 15, null, GrassLand, 0, false, null, null, Forest);
        Tile tile19_17 = new Tile(18, 16, null, GrassLand, 0, false, null, null, Forest);
        Tile tile19_18 = new Tile(18, 17, null, Hill, 0, false, null, null, Forest);
        Tile tile19_19 = new Tile(18, 18, null, GrassLand, 0, false, null, null, Forest);
        // between america and europe
        Tile tile19_20 = new Tile(18, 19, null, Ocean, 0, false, null, null, null);
        Tile tile19_21 = new Tile(18, 20, null, Ocean, 0, false, null, null, null);
        Tile tile19_22 = new Tile(18, 21, null, Ocean, 0, false, null, null, null);
        Tile tile19_23 = new Tile(18, 22, null, Ocean, 0, false, null, null, null);
        Tile tile19_24 = new Tile(18, 23, null, Ocean, 0, false, null, null, null);
        Tile tile19_25 = new Tile(18, 24, null, Ocean, 0, false, null, null, null);
        Tile tile19_26 = new Tile(18, 25, null, Ocean, 0, false, null, null, null);
        Tile tile19_27 = new Tile(18, 26, null, Ocean, 0, false, null, null, null);
        Tile tile19_28 = new Tile(18, 27, null, Ocean, 0, false, null, null, null);
        Tile tile19_29 = new Tile(18, 28, null, Ocean, 0, false, null, null, null);
        Tile tile19_30 = new Tile(18, 29, null, Ocean, 0, false, null, null, null);
        Tile tile19_31 = new Tile(18, 30, null, Ocean, 0, false, null, null, null);
        Tile tile19_32 = new Tile(18, 31, null, Ocean, 0, false, null, null, null);
        // europe
        Tile tile19_33 = new Tile(18, 32, null, Hill, 0, false, null, null, Forest);
        Tile tile19_34 = new Tile(18, 33, null, GrassLand, 0, false, null, null, Forest);
        Tile tile19_35 = new Tile(18, 34, null, Mountain, 0, false, null, null, null);
        Tile tile19_36 = new Tile(18, 35, null, Mountain, 0, false, null, null, null);
        Tile tile19_37 = new Tile(18, 36, null, GrassLand, 0, false, null, null, Forest);
        // sea
        Tile tile19_38 = new Tile(18, 37, null, Ocean, 0, false, null, null, null);
        Tile tile19_39 = new Tile(18, 38, null, Ocean, 0, false, null, null, null);
        // europe
        Tile tile19_40 = new Tile(18, 39, null, GrassLand, 0, false, null, null, Forest);
        Tile tile19_41 = new Tile(18, 40, null, GrassLand, 0, false, null, null, Forest);
        // sea
        Tile tile19_42 = new Tile(18, 41, null, Ocean, 0, false, null, null, null);
        // europe
        Tile tile19_43 = new Tile(18, 42, null, GrassLand, 0, false, null, null, Forest);
        Tile tile19_44 = new Tile(18, 43, null, GrassLand, 0, false, null, null, Forest);
        // sea
        Tile tile19_45 = new Tile(18, 44, null, Ocean, 0, false, null, null, null);
        // asia
        Tile tile19_46 = new Tile(18, 45, null, Plain, 0, false, null, null, null);
        Tile tile19_47 = new Tile(18, 46, null, Plain, 0, false, null, null, null);
        Tile tile19_48 = new Tile(18, 47, null, Plain, 0, false, null, null, null);
        Tile tile19_49 = new Tile(18, 48, null, Mountain, 0, false, null, null, null);
        Tile tile19_50 = new Tile(18, 49, null, Plain, 0, false, null, null, null);
        Tile tile19_51 = new Tile(18, 50, null, Plain, 0, false, null, null, null);
        Tile tile19_52 = new Tile(18, 51, null, Plain, 0, false, null, null, null);
        Tile tile19_53 = new Tile(18, 52, null, Desert, 0, false, null, null, null);
        Tile tile19_54 = new Tile(18, 53, null, Hill, 0, false, null, null, null);
        Tile tile19_55 = new Tile(18, 54, null, Hill, 0, false, null, null, null);
        Tile tile19_56 = new Tile(18, 55, null, Desert, 0, false, null, null, null);
        Tile tile19_57 = new Tile(18, 56, null, Desert, 0, false, null, null, null);
        Tile tile19_58 = new Tile(18, 57, null, Desert, 0, false, null, null, null);
        Tile tile19_59 = new Tile(18, 58, null, Desert, 0, false, null, null, Oasis);
        Tile tile19_60 = new Tile(18, 59, null, Desert, 0, false, null, null, null);
        Tile tile19_61 = new Tile(18, 60, null, Hill, 0, false, null, null, null);
        Tile tile19_62 = new Tile(18, 61, null, Hill, 0, false, null, null, null);
        Tile tile19_63 = new Tile(18, 62, null, Mountain, 0, false, null, null, null);
        Tile tile19_64 = new Tile(18, 63, null, Plain, 0, false, null, null, null);
        Tile tile19_65 = new Tile(18, 64, null, Plain, 0, false, null, null, null);
        Tile tile19_66 = new Tile(18, 65, null, Mountain, 0, false, null, null, null);
        Tile tile19_67 = new Tile(18, 66, null, Plain, 0, false, null, null, null);
        Tile tile19_68 = new Tile(18, 67, null, GrassLand, 0, false, null, null, null);
        Tile tile19_69 = new Tile(18, 68, null, GrassLand, 0, false, null, null, null);
        // east asian sea
        Tile tile19_70 = new Tile(18, 69, null, Ocean, 0, false, null, null, null);
        Tile tile19_71 = new Tile(18, 70, null, Ocean, 0, false, null, null, null);
        // japan
        Tile tile19_72 = new Tile(18, 71, null, GrassLand, 0, false, null, null, Forest);
        Tile tile19_73 = new Tile(18, 72, null, GrassLand, 0, false, null, null, Forest);
        Tile tile19_74 = new Tile(18, 73, null, Hill, 0, false, null, null, null);
        // between america and asia
        Tile tile19_75 = new Tile(18, 74, null, Ocean, 0, false, null, null, null);
        Tile tile19_76 = new Tile(18, 75, null, Ocean, 0, false, null, null, null);
        Tile tile19_77 = new Tile(18, 76, null, Ocean, 0, false, null, null, null);
        Tile tile19_78 = new Tile(18, 77, null, Ocean, 0, false, null, null, null);
        Tile tile19_79 = new Tile(18, 78, null, Ocean, 0, false, null, null, null);
        Tile tile19_80 = new Tile(18, 79, null, Ocean, 0, false, null, null, null);





    }
}
