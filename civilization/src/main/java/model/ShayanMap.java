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
        // todo :
        // 16th row
        // 17th row
        // 18th row
        // 19th row

    }
}
