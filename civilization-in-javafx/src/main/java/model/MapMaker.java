package model;

public class MapMaker {
    public Maps myTiles() {

        Maps map = new Maps(26, 80);
        //all features of map
        Feature Jungle = new Feature("Jungle", 2, 1, 0.25, 0, 1);
        Feature Forest = new Feature("Forest", 2, 1, 0.25, 0, 1);
        Feature Marsh = new Feature("Marsh", 2, -1, -0.33, 0, 0);
        Feature Oasis = new Feature("Oasis", 1, 3, -0.33, 1, 0);
        Feature Ice = new Feature("Ice", 0, 0, 0, 0, 0);
        Feature FloodPlain = new Feature("FloodPlain", 1, 2, -0.33, 0, 0);
        //all terrains of map
        Terrain Desert = new Terrain("Desert", "yellow", 1, 0, -0.33, 0, 0, true);
        Terrain GrassLand = new Terrain("Grassland", "green", 1, 2, -0.33, 0, 0, true);
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Terrain Mountain = new Terrain("Mountain", "brightBlack", 0, 0, 0, 0, 0, false);
        Terrain Ocean = new Terrain("Ocean", "brightBlue", 0, 0, 0, 0, 0, false);
        Terrain Plain = new Terrain("Plain", "red", 1, 1, -0.33, 0, 1, true);
        Terrain Snow = new Terrain("Snow", "white", 1, 0, -0.33, 0, 0, true);
        Terrain Tundra = new Terrain("Tundra", "cyan", 1, 1, -0.33, 0, 0, true);
        //all Bonus Resources of map
        Resource Banana = new Resource("Banana", "Bonus", "Plantation", 0, 1, 0, 0);
        Resource Cow = new Resource("Cow", "Bonus", "Pasture", 0, 1, 0, 0);
        Resource Gazelle = new Resource("Gazelle", "Bonus", "Camp", 0, 1, 0, 0);
        Resource Wheat = new Resource("Wheat", "Bonus", "Farm", 0, 1, 0, 0);
        Resource Sheep = new Resource("Sheep", "Bonus", "Pasture", 0, 2, 0, 0);
        //all Strategic Resources of map
        Resource Coal = new Resource("Coal", "Strategic", "Mine", 0, 0, 1, 0);
        Resource Horse = new Resource("Horse", "Strategic", "Pasture", 0, 0, 1, 0);
        Resource Iron = new Resource("Iron", "Strategic", "Mine", 0, 0, 1, 0);
        //all Luxury Resources of map
        Resource Cotton = new Resource("Cotton", "Luxury", "Plantation", 2, 0, 0, 3);
        Resource Color = new Resource("Color", "Luxury", "Plantation", 2, 0, 0, 2);
        Resource Fur = new Resource("Fur", "Luxury", "Camp", 2, 0, 0, 3);
        Resource Gemstones = new Resource("Gemstones", "Luxury", "Mine", 3, 0, 0, 5);
        Resource Gold = new Resource("Gold", "Luxury", "Mine", 2, 0, 0, 4);
        Resource Fumigation = new Resource("Fumigation", "Luxury", "Plantation", 2, 0, 0, 2);
        Resource Ivory = new Resource("Ivory", "Luxury", "Camp", 2, 0, 0, 3);
        Resource Silk = new Resource("Silk", "Luxury", "Plantation", 2, 0, 0, 3);
        Resource Sugar = new Resource("Sugar", "Luxury", "Plantation", 2, 0, 0, 2);
        Resource Silver = new Resource("Silver", "Luxury", "Mine", 2, 0, 0, 3);
        Resource Marble = new Resource("Marble", "Luxury", "Quarry", 2, 0, 0, 3);
        Tile tile;
        //1st row

        tile = new Tile(0, 0, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 1, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 2, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 3, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 4, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 5, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 6, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 7, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 8, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 9, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 10, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 11, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 12, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 13, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 14, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 15, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 16, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 17, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 18, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 19, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 20, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 21, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 22, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 23, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 24, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 25, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 26, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 27, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 28, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 29, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 30, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 31, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 32, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 33, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 34, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 35, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 36, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 37, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 38, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 39, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(0, 40, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(0, 41, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(0, 42, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(0, 43, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 44, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 45, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 46, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 47, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 48, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 49, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 50, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 51, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 52, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 53, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 54, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 55, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 56, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 57, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 58, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 59, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 60, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 61, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 62, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 63, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 64, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 65, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 66, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 67, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 68, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 69, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 70, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 71, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 72, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 73, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 74, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 75, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 76, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 77, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 78, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(0, 79, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);


        /*
        for (int i = 0; i < 80; i++){
            if (i > 38 && i < 43){
                Tile tile = new Tile(0, i, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            Tile tile = new Tile(0, i, null, Ocean, 3, false, null, null, Ice);
            map.setTileBoard(tile);
        }*/
        //2nd row

        tile = new Tile(1, 0, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 1, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 2, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 3, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 4, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 5, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 6, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 7, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 8, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 9, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 10, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 11, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 12, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 13, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 14, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 15, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 16, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 17, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 18, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 19, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 30, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 31, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 32, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 33, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 34, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 35, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 36, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 37, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(1, 38, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(1, 39, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(1, 40, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(1, 41, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(1, 42, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(1, 43, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(1, 44, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(1, 45, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(1, 46, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(1, 47, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(1, 48, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 49, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 50, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 51, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 52, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 53, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 54, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 55, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 56, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 57, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 58, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 59, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 60, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 61, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 62, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 63, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 64, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 65, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 66, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 67, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 68, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 69, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 70, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 71, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 72, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 73, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 74, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 75, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 76, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 77, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 78, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(1, 79, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);

        /*for (int i = 0; i < 80; i++){
            if (i > 36 && i < 41){
                Tile tile = new Tile(1, i, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            if (i > 40 && i < 45){
                Tile tile = new Tile(1, i, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            if (i > 44 && i < 48){
                Tile tile = new Tile(1, i, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            Tile tile = new Tile(1, i, null, Ocean, 3, false, null, null, Ice);
            map.setTileBoard(tile);
        }*/


        //3rd row

        tile = new Tile(2, 0, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 1, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 2, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 3, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 4, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 5, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 6, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 7, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 8, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 9, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 10, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 11, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 12, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 13, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 14, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 15, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 16, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 17, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 18, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 19, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 20, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 21, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 22, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 23, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 24, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 25, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 26, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 27, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 28, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 29, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 30, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 31, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 32, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 33, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 34, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 35, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 36, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 37, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(2, 38, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(2, 39, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(2, 40, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(2, 41, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(2, 42, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(2, 43, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(2, 44, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(2, 45, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(2, 46, null, GrassLand, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(2, 47, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(2, 48, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 49, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 50, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 51, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 52, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 53, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 54, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 55, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 56, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 57, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 58, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 59, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 60, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 61, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 62, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 63, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 64, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 65, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 66, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 67, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 68, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 69, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 70, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 71, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 72, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 73, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 74, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 75, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 76, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 77, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 78, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(2, 79, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);

        /*for (int i = 0; i < 80; i++){
            if (i == 37){
                Tile tile = new Tile(2, 37, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(2, 38, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(2, 39, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(2, 40, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(2, 41, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(2, 42, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(2, 43, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(2, 44, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(2, 45, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(2, 46, null, GrassLand, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(2, 47, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                i = 47;
                continue;
            }
            Tile tile = new Tile(2, i, null, Ocean, 3, false, null, null, Ice);
            map.setTileBoard(tile);
        }*/

        //4th row

        tile = new Tile(3, 0, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 1, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 2, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 3, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 4, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 5, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 6, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 7, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 8, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 9, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 10, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 11, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 12, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 13, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 14, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 15, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 16, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 17, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 18, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 19, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 20, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 21, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 22, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 23, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 24, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 25, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 26, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 27, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 28, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 29, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 30, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 31, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 32, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 33, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 34, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 35, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 36, null, Ocean, 3, false, null, null, Ice);

        tile = new Tile(3, 37, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(3, 38, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(3, 39, null, Plain, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(3, 40, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(3, 41, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(3, 42, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(3, 43, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(3, 44, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(3, 45, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(3, 46, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(3, 47, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);

        tile = new Tile(3, 48, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 49, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 50, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 51, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 52, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 53, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 54, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 55, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 56, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 57, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 58, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 59, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 60, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 61, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 62, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 63, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 64, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 65, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 66, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 67, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 68, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 69, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 70, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 71, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 72, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 73, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 74, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 75, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 76, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 77, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 78, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(3, 79, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);

        /*for (int i = 0; i < 80; i++){
            if (i == 37){
                Tile tile = new Tile(3, 37, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(3, 38, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(3, 39, null, Plain, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(3, 40, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(3, 41, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(3, 42, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(3, 43, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(3, 44, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(3, 45, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(3, 46, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(3, 47, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                i = 47;
                continue;
            }
            Tile tile = new Tile(3, i, null, Ocean, 3, false, null, null, Ice);
            map.setTileBoard(tile);
        }*/
        //5th row

        tile = new Tile(4, 0, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 1, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 2, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 3, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 4, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 5, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 6, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 7, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 8, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 9, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 10, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 11, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 12, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 13, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 14, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 15, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 16, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 17, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 18, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 19, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 20, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 21, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 22, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 23, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 24, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 25, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 26, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 27, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 28, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 29, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 30, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 31, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 32, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 33, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 34, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 35, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 36, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 37, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 38, null, Plain, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(4, 39, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 40, null, GrassLand, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(4, 41, null, GrassLand, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(4, 42, null, Tundra, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(4, 43, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 44, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 45, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 46, null, Hill, 3, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(4, 47, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 48, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 49, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 50, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 51, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 52, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 53, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 54, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 55, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 56, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 57, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 58, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 59, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 60, null, Tundra, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 61, null, Tundra, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 62, null, Tundra, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 63, null, Tundra, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 64, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 65, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 66, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 67, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 68, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 69, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 70, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 71, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 72, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 73, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 74, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 75, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 76, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 77, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(4, 78, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(4, 79, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);

        /*for (int i = 0; i < 80; i++){
            if (i > 1 && i < 22){
                Tile tile = new Tile(4, i, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            if (i == 38){
                Tile tile = new Tile(4, 38, null, Plain, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(4, 39, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(4, 40, null, GrassLand, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(4, 41, null, GrassLand, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(4, 42, null, Tundra, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(4, 43, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(4, 44, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(4, 45, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(4, 46, null, Hill, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                i = 46;
                continue;
            }
            if (i > 49 && i < 78){
                if (i > 59 && i < 64){
                    Tile tile = new Tile(4, i, null, Tundra, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    continue;
                }
                Tile tile = new Tile(4, i, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            Tile tile = new Tile(4, i, null, Ocean, 3, false, null, null, Ice);
            map.setTileBoard(tile);
        }*/
        //6th row
        tile = new Tile(5, 0, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 1, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 2, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 3, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 4, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 5, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 6, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 7, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 8, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 9, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 10, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 11, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 12, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 13, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 14, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 15, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 16, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 17, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 18, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 19, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 20, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 21, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 22, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 23, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 24, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 25, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 26, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 27, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 28, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 29, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 30, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 31, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 32, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 33, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 34, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 35, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 36, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 37, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 38, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 39, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 40, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 41, null, GrassLand, 3, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(5, 42, null, GrassLand, 3, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(5, 43, null, GrassLand, 3, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(5, 44, null, GrassLand, 3, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(5, 45, null, GrassLand, 3, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(5, 46, null, GrassLand, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(5, 47, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 48, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 49, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 50, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 51, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 52, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 53, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 54, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 55, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 56, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 57, null, Tundra, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 58, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 59, null, Tundra, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 60, null, Tundra, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 61, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 62, null, Hill, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 63, null, GrassLand, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(5, 64, null, GrassLand, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(5, 65, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 66, null, GrassLand, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(5, 67, null, GrassLand, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(5, 68, null, GrassLand, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(5, 69, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 70, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 71, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 72, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 73, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 74, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 75, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 76, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(5, 77, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 78, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);
        tile = new Tile(5, 79, null, Ocean, 3, false, null, null,null);
        map.setTileBoard(tile);

        /*for (int i = 0; i < 80; i++){
            if (i > 2 && i < 21){
                Tile tile = new Tile(5, i, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            if (i == 33){
                Tile tile = new Tile(5, 33, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(5, 34, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                i = 34;
                continue;
            }
            if (i > 37 && i < 77){
                if (i == 38){
                    Tile tile = new Tile(5, 38, null, Hill, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 39, null, Mountain, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 40, null, Hill, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 41, null, GrassLand, 3, false, null, null, Forest);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 42, null, GrassLand, 3, false, null, null, Forest);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 43, null, GrassLand, 3, false, null, null, Forest);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 44, null, GrassLand, 3, false, null, null, Forest);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 45, null, GrassLand, 3, false, null, null, Forest);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 46, null, GrassLand, 3, false, null, null, Jungle);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 47, null, Mountain, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 48, null, Mountain, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 49, null, Mountain, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 50, null, Mountain, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    i = 50;
                    continue;
                }
                if (i == 57){
                    Tile tile = new Tile(5, 57, null, Tundra, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 58, null, Snow, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 59, null, Tundra, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 60, null, Tundra, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 61, null, Hill, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 62, null, Hill, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 63, null, GrassLand, 3, false, null, null, FloodPlain);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 64, null, GrassLand, 3, false, null, null, FloodPlain);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 65, null, Snow, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 66, null, GrassLand, 3, false, null, null, FloodPlain);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 67, null, GrassLand, 3, false, null, null, FloodPlain);
                    map.setTileBoard(tile);
                    tile = new Tile(5, 68, null, GrassLand, 3, false, null, null, FloodPlain);
                    map.setTileBoard(tile);
                    i = 68;
                    continue;
                }
                Tile tile = new Tile(5, i, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            Tile tile = new Tile(5, i, null, Ocean, 3, false, null, null,null);
            map.setTileBoard(tile);
        }*/

        //7th row

        tile = new Tile(6, 0, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 1, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 2, null, GrassLand, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(6, 3, null, GrassLand, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(6, 4, null, GrassLand, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(6, 5, null, GrassLand, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(6, 6, null, Tundra, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(6, 7, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 8, null, GrassLand, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(6, 9, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 10, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 11, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 12, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 13, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 14, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 15, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 16, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 17, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 18, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 19, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 20, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 21, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 22, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 23, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 24, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 25, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 26, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 27, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 28, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 29, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 30, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 31, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 32, null, Hill, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(6, 33, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 34, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 35, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 36, null, Plain, 3, false, null, null, Marsh);
        map.setTileBoard(tile);
        tile = new Tile(6, 37, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 38, null, GrassLand, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(6, 39, null, GrassLand, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(6, 40, null, GrassLand, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(6, 41, null, Ocean, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 42, null, Ocean, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 43, null, GrassLand, 3, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(6, 44, null, Ocean, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 45, null, Plain, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(6, 46, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 47, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 48, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 49, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 50, null, Plain, 3, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(6, 51, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 52, null, Tundra, 3, false, null, null, Marsh);
        map.setTileBoard(tile);
        tile = new Tile(6, 53, null, Tundra, 3, false, null, null, Marsh);
        map.setTileBoard(tile);
        tile = new Tile(6, 54, null, Tundra, 3, false, null, null, Marsh);
        map.setTileBoard(tile);
        tile = new Tile(6, 55, null, Tundra, 3, false, null, null, Marsh);
        map.setTileBoard(tile);
        tile = new Tile(6, 56, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 57, null, Tundra, 3, false, null, null, Marsh);
        map.setTileBoard(tile);
        tile = new Tile(6, 58, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 59, null, Tundra, 3, false, null, null, Marsh);
        map.setTileBoard(tile);
        tile = new Tile(6, 60, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 61, null, Mountain, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 62, null, Tundra, 3, false, null, null, Marsh);
        map.setTileBoard(tile);
        tile = new Tile(6, 63, null, Tundra, 3, false, null, null, Marsh);
        map.setTileBoard(tile);
        tile = new Tile(6, 64, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 65, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 66, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 67, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 68, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 69, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 70, null, Snow, 3, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(6, 71, null, Tundra, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(6, 72, null, Tundra, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(6, 73, null, Tundra, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(6, 74, null, Tundra, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(6, 75, null, Tundra, 3, false, null, null, FloodPlain);
        map.setTileBoard(tile);
        tile = new Tile(6, 76, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 77, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 78, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);
        tile = new Tile(6, 79, null, Ocean, 3, false, null, null, Ice);
        map.setTileBoard(tile);

        /*for (int i = 0; i < 80; i++){
            if (i > 1 && i < 22) {
                if (i == 2) {
                    Tile tile = new Tile(6, 2, null, GrassLand, 3, false, null, null, Jungle);
                    map.setTileBoard(tile);
                    tile = new Tile(6, 3, null, GrassLand, 3, false, null, null, Jungle);
                    map.setTileBoard(tile);
                    tile = new Tile(6, 4, null, GrassLand, 3, false, null, null, Jungle);
                    map.setTileBoard(tile);
                    tile = new Tile(6, 5, null, GrassLand, 3, false, null, null, Jungle);
                    map.setTileBoard(tile);
                    tile = new Tile(6, 6, null, Tundra, 3, false, null, null, FloodPlain);
                    map.setTileBoard(tile);
                    tile = new Tile(6, 7, null, Mountain, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    tile = new Tile(6, 8, null, GrassLand, 3, false, null, null, FloodPlain);
                    map.setTileBoard(tile);
                    i = 8;
                    continue;
                }
                Tile tile = new Tile(6, i, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            if (i == 32){
                Tile tile = new Tile(6, 32, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
            }
            if (i == 36){
                Tile tile = new Tile(6, 36, null, Plain, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(6, 37, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 38, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(6, 39, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(6, 40, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(6, 41, null, Ocean, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 42, null, Ocean, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 43, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(6, 44, null, Ocean, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 45, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(6, 46, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 47, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 48, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 49, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 50, null, Plain, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(6, 51, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 52, null, Tundra, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(6, 53, null, Tundra, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(6, 54, null, Tundra, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(6, 55, null, Tundra, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(6, 56, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 57, null, Tundra, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(6, 58, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 59, null, Tundra, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(6, 60, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 61, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(6, 62, null, Tundra, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(6, 63, null, Tundra, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                i = 63;
                continue;
            }
            if (i > 63 && i < 71){
                Tile tile = new Tile(6, i, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            if (i == 71){
                Tile tile = new Tile(6, 71, null, Tundra, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(6, 72, null, Tundra, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(6, 73, null, Tundra, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(6, 74, null, Tundra, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(6, 75, null, Tundra, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                i = 75;
                continue;
            }
            Tile tile = new Tile(6, i, null, Ocean, 3, false, null, null, Ice);
            map.setTileBoard(tile);
        }*/
        //8th row
        for (int i = 0; i < 80; i++){
            if (i == 2){
                Tile tile = new Tile(7, 2, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(7, 3, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(7, 4, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(7, 5, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(7, 6, null, GrassLand, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 7, null, Tundra, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(7, 8, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(7, 9, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(7, 10, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                i = 10;
                continue;
            }
            if (i == 32){
                Tile tile = new Tile(7, 32, null, Hill, 3, false, null, null,null );
                map.setTileBoard(tile);
                tile = new Tile(7, 33, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                i = 33;
                continue;
            }
            if (i == 36){
                Tile tile = new Tile(7, 36, null, Hill, 3, false, null, null, FloodPlain );
                map.setTileBoard(tile);
                tile = new Tile(7, 37, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(7, 38, null, Ocean, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 39, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                i = 39;
                continue;
            }
            if (i == 42){
                Tile tile = new Tile(7, 42, null, Plain, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(7, 43, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(7, 44, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(7, 45, null, Plain, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(7, 46, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(7, 47, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(7, 48, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(7, 49, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(7, 50, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(7, 51, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 52, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 53, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(7, 54, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(7, 55, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(7, 56, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(7, 57, null, Hill, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(7, 58, null, GrassLand, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(7, 59, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(7, 60, null, Hill, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(7, 61, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(7, 62, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 63, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(7, 64, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 65, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(7, 66, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(7, 67, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 68, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(7, 69, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 70, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(7, 71, null, Tundra, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 72, null, Tundra, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 73, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 74, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 75, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(7, 76, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                i = 76;
                continue;
            }
            Tile tile = new Tile(7, i, null, Ocean, 3, false, null, null, null);
            map.setTileBoard(tile);
        }
        //9th row
        for (int i = 0; i < 80; i++){
            if (i == 2){
                Tile tile = new Tile(8, 2, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(8, 3, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                i = 3;
                continue;
            }
            if (i == 8){
                Tile tile = new Tile(8, 8, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 9, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 10, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 11, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 12, null, GrassLand, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(8, 13, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 14, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 15, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                i = 15;
                continue;
            }
            if (i == 20){
                Tile tile = new Tile(8, 20, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 21, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                i = 21;
                continue;
            }
            if (i == 33){
                Tile tile = new Tile(8, 33, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(8, 34, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                i = 34;
                continue;
            }
            if (i == 38){
                Tile tile = new Tile(8, 38, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                continue;
            }
            if (i == 43){
                Tile tile = new Tile(8, 43, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 44, null, Plain, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 45, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 46, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 47, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 48, null, Hill, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 49, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(8, 50, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(8, 51, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 52, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 53, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(8, 54, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 55, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 56, null, Plain, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 57, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 58, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(8, 59, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(8, 60, null, Plain, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(8, 61, null, Ocean, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 62, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 63, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(8, 64, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 65, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 66, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 67, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 68, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(8, 69, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 70, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 71, null, Ocean, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 72, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 73, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(8, 74, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                i = 74;
                continue;
            }
            Tile tile = new Tile(8, i, null, Ocean, 3, false, null, null, null);
            map.setTileBoard(tile);
        }
        //10th row
        for (int i = 0; i < 80; i++){
            if (i == 2){
                Tile tile = new Tile(9, 2, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                continue;
            }
            if (i > 8 && i < 17){
                Tile tile = new Tile(9, i, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                continue;
            }
            if (i > 19 && i < 23){
                Tile tile = new Tile(9, i, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                continue;
            }
            if (i == 31){
                Tile tile = new Tile(9, 31, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(9, 32, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(9, 33, null, Tundra, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(9, 34, null, Plain, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(9, 35, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                i = 35;
                continue;
            }
            if (i == 40){
                Tile tile = new Tile(9, 40, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                continue;
            }
            if (i == 44){
                Tile tile = new Tile(9, 44, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(9, 45, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(9, 46, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(9, 47, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(9, 48, null, Plain, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(9, 49, null, GrassLand, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(9, 50, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(9, 51, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(9, 52, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(9, 53, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(9, 54, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(9, 55, null, Plain, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(9, 56, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(9, 57, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(9, 58, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(9, 59, null, Plain, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(9, 60, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(9, 61, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(9, 62, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(9, 63, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(9, 63, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(9, 64, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(9, 65, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(9, 66, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(9, 67, null, Plain, 3, false, null, null, Oasis);
                map.setTileBoard(tile);
                tile = new Tile(9, 68, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                i = 68;
                continue;
            }
            if (i == 74){
                Tile tile = new Tile(9, 74, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            Tile tile = new Tile(9, i, null, Ocean, 3, false, null, null, null);
            map.setTileBoard(tile);
        }
        //11th row
        for (int i = 0; i < 80; i++){
            if (i == 8){
                Tile tile = new Tile(10, 8, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            if (i > 8 && i < 22){
                if (i == 18){
                    Tile tile = new Tile(10, i, null, Ocean, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    continue;
                }
                Tile tile = new Tile(10, i, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                continue;
            }
            if (i == 30){
                Tile tile = new Tile(10, 30, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(10, 31, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(10, 32, null, Tundra, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(10, 33, null, Plain, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(10, 34, null, Plain, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(10, 35, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                i = 35;
                continue;
            }
            if (i > 38 && i < 43){
                Tile tile = new Tile(10, i, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                continue;
            }
            if (i == 43){
                Tile tile = new Tile(10, 43, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(10, 44, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(10, 45, null, GrassLand, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(10, 46, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(10, 47, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(10, 48, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(10, 49, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(10, 50, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(10, 51, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(10, 52, null, Plain, 3, false, null, null, Marsh);
                map.setTileBoard(tile);
                tile = new Tile(10, 53, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(10, 54, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(10, 55, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(10, 56, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(10, 57, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(10, 58, null, Plain, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(10, 59, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(10, 60, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(10, 61, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(10, 62, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(10, 63, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(10, 64, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(10, 65, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(10, 66, null, Hill, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(10, 67, null, Plain, 3, false, null, null, Oasis);
                map.setTileBoard(tile);
                tile = new Tile(10, 68, null, Plain, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(10, 69, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                i = 69;
                continue;
            }
            if (i == 73){
                Tile tile = new Tile(10, 73, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            Tile tile = new Tile(10, i, null, Ocean, 3, false, null, null, null);
            map.setTileBoard(tile);
        }
        //12th row
        for (int i = 0; i < 80; i++) {
            if (i > 8 && i < 22) {
                if (i == 14) {
                    Tile tile = new Tile(11, i, null, Ocean, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    continue;
                }
                Tile tile = new Tile(11, i, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                continue;
            }
            if (i == 22) {
                Tile tile = new Tile(11, 22, null, Hill, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 23, null, Hill, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                i = 23;
                continue;
            }
            if (i == 34) {
                Tile tile = new Tile(11, 34, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(11, 35, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 36, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(11, 37, null, Ocean, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 38, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 39, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 40, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 41, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 42, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 43, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 44, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 45, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 46, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 47, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 48, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 49, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 50, null, Plain, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(11, 51, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(11, 51, null, GrassLand, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(11, 52, null, Plain, 3, false, null, null, FloodPlain);
                map.setTileBoard(tile);
                tile = new Tile(11, 53, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 54, null, Plain, 3, false, null, null, Oasis);
                map.setTileBoard(tile);
                tile = new Tile(11, 55, null, Plain, 3, false, null, null, Oasis);
                map.setTileBoard(tile);
                tile = new Tile(11, 56, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 57, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 58, null, Plain, 3, false, null, null, Oasis);
                map.setTileBoard(tile);
                tile = new Tile(11, 59, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 60, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 61, null, Hill, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 62, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(11, 63, null, Plain, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(11, 64, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 65, null, Plain, 3, false, null, null, Oasis);
                map.setTileBoard(tile);
                tile = new Tile(11, 66, null, Plain, 3, false, null, null, Oasis);
                map.setTileBoard(tile);
                tile = new Tile(11, 67, null, Hill, 3, false, null, null, Jungle);
                map.setTileBoard(tile);
                tile = new Tile(11, 68, null, Plain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 69, null, Ocean, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 70, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 71, null, Ocean, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 72, null, Ocean, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 73, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                tile = new Tile(11, 74, null, Mountain, 3, false, null, null, null);
                map.setTileBoard(tile);
                i = 74;
                continue;
            }
            Tile tile = new Tile(11, i, null, Ocean, 3, false, null, null, null);
            map.setTileBoard(tile);
        }



        //13th row
        // between asia and america
        tile = new Tile(12, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 8, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // america
        tile = new Tile(12, 9, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 10, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 11, null, GrassLand, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 12, null, GrassLand, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 13, null, GrassLand, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 14, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 15, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 16, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 17, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 18, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 19, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 20, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 21, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 22, null, Mountain, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 23, null, Mountain, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        //between europe and america
        tile = new Tile(12, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 31, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 32, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // england
        tile = new Tile(12, 33, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 34, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 35, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // between england and france
        tile = new Tile(12, 36, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // 33 europe and asia
        tile = new Tile(12, 37, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 38, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 39, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 40, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 41, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 42, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 43, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 44, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 45, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 46, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 47, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 48, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 49, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 50, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 51, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 52, null, Mountain, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 53, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 54, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 55, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 56, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 57, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 58, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 59, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 60, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 61, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 62, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 63, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 64, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 65, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 66, null, Plain, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 67, null, Plain, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 68, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 69, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // between china and japan
        tile = new Tile(12, 70, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 71, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 72, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 73, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // japan
        tile = new Tile(12, 74, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 75, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // between Japan and america
        tile = new Tile(12, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 77, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(12, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(12, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        //14th row between america and asia

        tile = new Tile(13, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        //west america
        tile = new Tile(13, 8, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 9, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 10, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 11, null, GrassLand, 0, false, null, null, Marsh);
        map.setTileBoard(tile);
        tile = new Tile(13, 12, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 13, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // a lake
        tile = new Tile(13, 14, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // east America
        tile = new Tile(13, 15, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 16, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 17, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 18, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 19, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 20, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 21, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 22, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 23, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // between america and europe
        tile = new Tile(13, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 31, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 32, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 33, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 34, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 35, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // europe to asia
        tile = new Tile(13, 36, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 37, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 38, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 39, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 40, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 41, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 42, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 43, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 44, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 45, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 46, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 47, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 48, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 49, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 50, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 51, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 52, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 53, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 54, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 55, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 56, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 57, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 58, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 59, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 60, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 61, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 62, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 63, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 64, null, GrassLand, 0, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(13, 65, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 66, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 67, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 68, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 69, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 70, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(13, 71, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // east asian sea
        tile = new Tile(13, 72, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 73, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 74, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(13, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        //15th row

        // between asia and america
        tile = new Tile(14, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 8, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        //west america
        tile = new Tile(14, 9, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 10, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 11, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 12, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 13, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 14, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 15, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        //a lake
        tile = new Tile(14, 16, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // east america
        tile = new Tile(14, 17, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 18, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 19, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 20, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 21, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 22, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // america to europe
        tile = new Tile(14, 23, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 31, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 32, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        //europe and asia 38
        tile = new Tile(14, 33, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 34, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 35, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 36, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 37, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 38, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 39, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 40, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 41, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 42, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 43, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 44, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 45, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 46, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 47, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 48, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 49, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 50, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 51, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 52, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 53, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 54, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 55, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 56, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 57, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 58, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 59, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 60, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 61, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 62, null, Desert, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 63, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 64, null, Plain, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 65, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 66, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 67, null, Plain, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 68, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 69, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 70, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // east asian sea
        tile = new Tile(14, 71, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 72, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 73, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 74, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(14, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(14, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        // 16th row
        //between asia and america
        tile = new Tile(15, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // west america
        tile = new Tile(15, 8, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 9, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 10, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 11, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 12, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 13, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 14, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 15, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // a lake
        tile = new Tile(15, 16, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 17, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        //east america
        tile = new Tile(15, 18, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 19, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 20, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 21, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 22, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // between america and europe
        tile = new Tile(15, 23, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 31, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 32, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // europe
        tile = new Tile(15, 33, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 34, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 35, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 36, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 37, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 38, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 39, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 40, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 41, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 42, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 43, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 44, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 45, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 46, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 47, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 48, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        // Caspian sea
        tile = new Tile(15, 49, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // asia
        tile = new Tile(15, 50, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 51, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 52, null, Desert, 0, false, null, null, Oasis);
        map.setTileBoard(tile);
        tile = new Tile(15, 53, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 54, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 55, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 56, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 57, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 58, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 59, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 60, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 61, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 62, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 63, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 64, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 65, null, Desert, 0, false, null, null, Oasis);
        map.setTileBoard(tile);
        tile = new Tile(15, 66, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 67, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 68, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(15, 69, null, Mountain, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // east asian sea
        tile = new Tile(15, 70, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 71, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // japan
        tile = new Tile(15, 72, null, GrassLand, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 73, null, GrassLand, 0, false, null, null, null);
        map.setTileBoard(tile);
        // between asia and europe
        tile = new Tile(15, 74, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(15, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        // 17th row
        // between asia and america
        tile = new Tile(16, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 8, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        //west america
        tile = new Tile(16, 9, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 10, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 11, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 12, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 13, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 14, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 15, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // a lake
        tile = new Tile(16, 16, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // east america
        tile = new Tile(16, 17, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 18, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 19, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 20, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 21, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // between america and europe
        tile = new Tile(16, 22, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 23, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 31, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 32, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 33, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // europe
        tile = new Tile(16, 34, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 35, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 36, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 37, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 38, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 39, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 40, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 41, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 42, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 43, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 44, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // Black Sea
        tile = new Tile(16, 45, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 46, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 47, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // island
        tile = new Tile(16, 48, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        // caspian sea
        tile = new Tile(16, 49, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 50, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // asia
        tile = new Tile(16, 51, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 52, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 53, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 54, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 55, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 56, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 57, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 58, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 59, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 60, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 61, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 62, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 63, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 64, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 65, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 66, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 67, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 68, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(16, 69, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // east asian sea
        tile = new Tile(16, 70, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 71, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // japan
        tile = new Tile(16, 72, null, GrassLand, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 73, null, GrassLand, 0, false, null, null, null);
        map.setTileBoard(tile);
        // between asia and america
        tile = new Tile(16, 74, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(16, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        // 18th row

        tile = new Tile(17, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // america
        tile = new Tile(17, 8, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 9, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 10, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 11, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 12, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 13, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 14, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 15, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 16, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 17, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 18, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 19, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // between america and europe
        tile = new Tile(17, 20, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 21, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 22, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 23, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 31, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 32, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 33, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // europe
        tile = new Tile(17, 34, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 35, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 36, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 37, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 38, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 39, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 40, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 41, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 42, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 43, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 44, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // Black Sea
        tile = new Tile(17, 45, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 46, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // island
        tile = new Tile(17, 47, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 48, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        // caspian sea
        tile = new Tile(17, 49, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // asia
        tile = new Tile(17, 50, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 51, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 52, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 53, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 54, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 55, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 56, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 57, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 58, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 59, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 60, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 61, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 62, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 63, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 64, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 65, null, Plain, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 66, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 67, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 68, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // east asian sea
        tile = new Tile(17, 69, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 70, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // japan
        tile = new Tile(17, 71, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(17, 72, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // between asia and america
        tile = new Tile(17, 73, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 74, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(17, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        // 19th row
        // between asia and america
        tile = new Tile(18, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 8, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // america
        tile = new Tile(18, 9, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 10, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 11, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 12, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 13, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 14, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(18, 15, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(18, 16, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(18, 17, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(18, 18, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // between america and europe
        tile = new Tile(18, 19, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 20, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 21, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 22, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 23, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 31, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // europe
        tile = new Tile(18, 32, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(18, 33, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(18, 34, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 35, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 36, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // sea
        tile = new Tile(18, 37, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 38, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // europe
        tile = new Tile(18, 39, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(18, 40, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // sea
        tile = new Tile(18, 41, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // europe
        tile = new Tile(18, 42, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(18, 43, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        // sea
        tile = new Tile(18, 44, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // asia
        tile = new Tile(18, 45, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 46, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 47, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 48, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 49, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 50, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 51, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 52, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 53, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 54, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 55, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 56, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 57, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 58, null, Desert, 0, false, null, null, Oasis);
        map.setTileBoard(tile);
        tile = new Tile(18, 59, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 60, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 61, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 62, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 63, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 64, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 65, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 66, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 67, null, GrassLand, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 68, null, GrassLand, 0, false, null, null, null);
        map.setTileBoard(tile);
        // east asian sea
        tile = new Tile(18, 69, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 70, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        // japan
        tile = new Tile(18, 71, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(18, 72, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(18, 73, null, Hill, 0, false, null, null, null);
        map.setTileBoard(tile);
        // between america and asia
        tile = new Tile(18, 74, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(18, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        //20th row

        tile = new Tile(19, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 0; j < 8; j++) {
            tile = new Tile(19, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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


        tile = new Tile(19, 18, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 19, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 20, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 21, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 22, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 23, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 31, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);


        /*for (int j = 18; j < 32; j++) {
            tile = new Tile(19, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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

        tile = new Tile(19, 50, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 51, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 52, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 53, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 54, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 55, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 56, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 57, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 58, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 59, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 60, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 50; j < 61; j++) {
            tile = new Tile(19, j, null, Desert, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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

        tile = new Tile(19, 72, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 73, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 74, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(19, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 72; j < 80; j++) {
            tile = new Tile(19, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        //21th row

        tile = new Tile(20, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 0; j < 8; j++) {
            tile = new Tile(20, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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

        tile = new Tile(20, 18, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 19, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 20, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 21, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 22, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 23, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 31, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 18; j < 32; j++) {
            tile = new Tile(20, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(20, 32, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 33, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 34, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);

        tile = new Tile(20, 35, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 36, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 37, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 38, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 39, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 35; j < 40; j++) {
            tile = new Tile (20, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(20, 40, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);

        tile = new Tile(20, 41, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 42, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 43, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 44, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 45, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 41; j < 46; j++) {
            tile = new Tile(20, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(20, 46, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 47, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 48, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 49, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 46; j < 50; j++) {
            tile = new Tile (20, j, null, Desert, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(20, 50, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 51, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 52, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for  (int j = 50; j < 53; j++) {
            tile = new Tile (20, j, null, Plain, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/


        tile = new Tile(20, 53, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 54, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 55, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 56, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 57, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 58, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 53; j < 59; j++) {
            tile = new Tile(20, j, null, Mountain, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(20, 59, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 60, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 61, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 62, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 63, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 64, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 65, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);

        /*for (int j = 59; j < 66; j++) {
            tile = new Tile(20, j, null, GrassLand, 0, false, null, null, Forest);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(20, 66, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 67, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 68, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(20, 69, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);

        tile = new Tile(20, 70, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 71, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 72, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 73, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 74, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(20, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 70; j < 80; j++) {
            tile = new Tile(20, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/



        //22th row

        tile = new Tile(21, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 8, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 0; j < 9; j++) {
            tile = new Tile (21, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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

        tile = new Tile(21, 20, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 21, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 22, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 23, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 31, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 32, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 33, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 34, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 35, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 20; j < 36; j++) {
            tile = new Tile(21, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(21, 36, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 37, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 38, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);

        tile = new Tile(21, 39, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 40, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 41, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 42, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 43, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 44, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 45, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 39; j < 46; j++) {
            tile = new Tile(21, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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
        tile = new Tile(21, 53, null, GrassLand, 0, false, null, null, Jungle);
        map.setTileBoard(tile);
        tile = new Tile(21, 54, null, Mountain, 0, false, null, null, null);
        map.setTileBoard(tile);

        tile = new Tile(21, 55, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 56, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 57, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 58, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(21, 59, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);

        /*for (int j = 55; j < 60; j++) {
            tile = new Tile(21, j, null, GrassLand, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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

        tile = new Tile(21, 68, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 69, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 70, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 71, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 68; j < 72; j++) {
            tile = new Tile (21, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(21, 72, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);

        tile = new Tile(21, 73, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 74, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(21, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 73; j < 80; j++) {
            tile = new Tile (21, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        //23th row

        tile = new Tile(22, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 8, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 0; j < 9; j++) {
            tile = new Tile (22, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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

        tile = new Tile(22, 14, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 15, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 16, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 17, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 18, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 19, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 20, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 21, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 22, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 23, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 31, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 14; j < 32; j++) {
            tile = new Tile(22, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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

        tile = new Tile(22, 68, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 69, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 70, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 71, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 72, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 73, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 74, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(22, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 68; j < 80; j++) {
            tile = new Tile (22, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        //24th row
        tile = new Tile(23, 0, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);

        tile = new Tile(23, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 8, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 9, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 1; j < 10; j++) {
            tile = new Tile (23, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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

        tile = new Tile(23, 21, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 22, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 23, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 21; j < 31; j++) {
            tile = new Tile (23, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(23, 31, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);

        tile = new Tile(23, 32, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 33, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 34, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 35, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 36, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 37, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 38, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 32; j < 39; j++) {
            tile = new Tile (23, j, null, Desert, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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
        tile = new Tile(23, 56, null, Hill, 0, false, null, null, Jungle);
        map.setTileBoard(tile);

        tile = new Tile(23, 57, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 58, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 59, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 60, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 61, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 62, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 63, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 64, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 65, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(23, 66, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);

        /*for (int j = 57; j < 67; j++) {
            tile = new Tile (23, j, null, GrassLand, 0, false, null, null, Forest);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(23, 67, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 68, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 69, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 70, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 71, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 72, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 73, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 74, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(23, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 67; j < 80; j++) {
            tile = new Tile (23, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        //25th row
        tile = new Tile(24, 0, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);

        tile = new Tile(24, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 2, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 8, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 9, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 10, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 11, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 1; j < 12; j++) {
            tile = new Tile (24, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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

        tile = new Tile(24, 20, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 21, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 22, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 23, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 20; j < 31; j++) {
            tile = new Tile (24, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(24, 31, null, Plain, 0, false, null, null, null);
        map.setTileBoard(tile);

        tile = new Tile(24, 32, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 33, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 34, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 35, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 36, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 37, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 38, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 39, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 40, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 41, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 32; j < 42; j++) {
            tile = new Tile (24, j, null, Desert, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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

        tile = new Tile(24, 69, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 70, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 71, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 72, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 73, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 74, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(24, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 69; j < 80; j++) {
            tile = new Tile (24, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        //26th row
        tile = new Tile(25, 0, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 1, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 2, null, Hill, 0, false, null, null, Forest);
        map.setTileBoard(tile);

        tile = new Tile(25, 3, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 4, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 5, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 6, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 7, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 8, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 9, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 10, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 11, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 12, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 3; j < 13; j++) {
            tile = new Tile (25, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(25, 13, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 14, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);
        tile = new Tile(25, 15, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);

        tile = new Tile(25, 16, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 17, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 18, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 19, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 20, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 21, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 22, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 23, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 24, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 25, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 26, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 27, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 28, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 29, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 30, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 16; j < 31; j++) {
            tile = new Tile (25, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        tile = new Tile(25, 31, null, GrassLand, 0, false, null, null, Forest);
        map.setTileBoard(tile);

        tile = new Tile(25, 32, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 33, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 34, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 35, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 36, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 37, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 38, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 39, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 40, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 41, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 42, null, Desert, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 32; j < 43; j++) {
            tile = new Tile (25, j, null, Desert, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

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

        tile = new Tile(25, 66, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 67, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 68, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 69, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 70, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 71, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 72, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 73, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 74, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 75, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 76, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 77, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 78, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);
        tile = new Tile(25, 79, null, Ocean, 0, false, null, null, null);
        map.setTileBoard(tile);

        /*for (int j = 66; j < 80; j++) {
            tile = new Tile (25, j, null, Ocean, 0, false, null, null, null);
            map.setTileBoard(tile);
        }*/

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 80; j++) {
                if (map.getTileBoard()[i][j] == null) {
                    System.out.println("**********");
                    System.out.println(i + " --> " + j);
                    System.out.println("**********");
                }
            }
        }

        addResource(3 , 39, map, Banana);
        addResource(7, 4, map, Banana);
        addResource(9, 34, map, Banana);
        addResource(11, 51, map, Banana);
        addResource(10, 46, map, Banana);
        addResource(11, 34, map, Banana);
        addResource(21, 12, map, Banana);
        addResource(17, 13, map, Banana);
        addResource(9, 12, map, Cow);
        addResource(10, 16, map, Cow);
        addResource(13, 12, map, Cow);
        addResource(17, 36, map, Cow);
        addResource(15, 34, map, Cow);
        addResource(22, 35, map, Cow);
        addResource(20, 14, map, Cow);
        addResource(4, 42 , map, Gazelle);
        addResource(6, 52 , map, Gazelle);
        addResource(8, 48 , map, Gazelle);
        addResource(11, 22 , map, Gazelle);
        addResource(18, 54 , map, Gazelle);
        addResource(8, 59 , map, Gazelle);
        addResource(16, 58 , map, Gazelle);
        addResource(9, 33 , map, Gazelle);
        addResource(8, 49 , map, Gazelle);
        addResource(6, 45 , map, Sheep);
        addResource(8, 47 , map, Sheep);
        addResource(9, 32 , map, Sheep);
        addResource(20, 53 , map, Sheep);
        addResource(19, 43 , map, Sheep);
        addResource(14, 67 , map, Sheep);
        addResource(13, 70 , map, Sheep);
        addResource(11, 68 , map, Sheep);
        addResource(9, 63 , map, Sheep);
        addResource(17, 11 , map, Wheat);
        addResource(18, 13 , map, Wheat);
        addResource(19, 41 , map, Wheat);
        addResource(19, 35 , map, Wheat);
        addResource(25, 31 , map, Wheat);
        addResource(10, 44 , map, Wheat);
        addResource(18, 45 , map, Wheat);
        addResource(18, 45 , map, Wheat);
        addResource(13, 60 , map, Coal);
        addResource(18, 12 , map, Coal);
        addResource(19, 33 , map, Coal);
        addResource(23, 31 , map, Coal);
        addResource(14, 43 , map, Coal);
        addResource(10, 48 , map, Coal);
        addResource(12, 68 , map, Coal);
        addResource(6, 72 , map, Horse);
        addResource(4, 61 , map, Horse);
        addResource(11, 59 , map, Horse);
        addResource(18, 32 , map, Horse);
        addResource(23, 41 , map, Horse);
        addResource(18, 46 , map, Horse);
        addResource(14, 51 , map, Horse);
        addResource(17, 54 , map, Horse);
        addResource(6, 55 , map, Horse);
        addResource(23, 32 , map, Iron);
        addResource(22, 44 , map, Iron);
        addResource(23, 52 , map, Iron);
        addResource(17, 50 , map, Iron);
        addResource(19, 59 , map, Iron);
        addResource(14, 58 , map, Iron);
        addResource(9, 55 , map, Iron);
        addResource(7, 57 , map, Iron);
        addResource(8, 60 , map, Iron);
        addResource(8, 60 , map, Iron);
        addResource(23, 46 , map, Cotton);
        addResource(18, 50 , map, Cotton);
        addResource(17, 52 , map, Cotton);
        addResource(8, 62 , map, Cotton);
        addResource(18, 10 , map, Cotton);
        addResource(17, 8 , map, Cotton);
        addResource(12, 40 , map, Cotton);
        addResource(11, 35 , map, Cotton);
        addResource(14, 50 , map, Color);
        addResource(10, 21 , map, Color);
        addResource(6, 43 , map, Color);
        addResource(12, 37 , map, Color);
        addResource(16, 35 , map, Color);
        addResource(20, 32 , map, Color);
        addResource(12, 53 , map, Color);
        addResource(8, 57 , map, Color);
        addResource(9, 33 , map, Fur);
        addResource(10, 32 , map, Fur);
        addResource(8, 50 , map, Fur);
        addResource(6, 62 , map, Fur);
        addResource(6, 71 , map, Fur);
        addResource(8, 50 , map, Fur);
        addResource(8, 53 , map, Fur);
        addResource(8, 21 , map, Fur);
        addResource(10, 35 , map, Gemstones);
        addResource(11, 38 , map, Gemstones);
        addResource(14, 38 , map, Gemstones);
        addResource(18, 35 , map, Gemstones);
        addResource(10, 47 , map, Gemstones);
        addResource(21, 50 , map, Gemstones);
        addResource(15, 55 , map, Gemstones);
        addResource(11, 59 , map, Gemstones);
        addResource(5, 59 , map, Gemstones);
        addResource(9, 53 , map, Gemstones);
        addResource(16, 53 , map, Gold);
        addResource(19, 60 , map, Gold);
        addResource(16, 63 , map, Gold);
        addResource(9, 59 , map, Gold);
        addResource(8, 56 , map, Gold);
        addResource(12, 47 , map, Gold);
        addResource(13, 44 , map, Gold);
        addResource(11, 20 , map, Gold);
        addResource(16, 18 , map, Gold);
        addResource(14, 46 , map, Fumigation);
        addResource(11, 38 , map, Fumigation);
        addResource(10, 34 , map, Fumigation);
        addResource(22, 36 , map, Fumigation);
        addResource(24, 32 , map, Fumigation);
        addResource(23, 52 , map, Fumigation);
        addResource(19, 62 , map, Fumigation);
        addResource(14, 64 , map, Fumigation);
        addResource(11, 63 , map, Ivory);
        addResource(20, 8 , map, Ivory);
        addResource(16, 11 , map, Ivory);
        addResource(3, 39 , map, Ivory);
        addResource(11, 38 , map, Ivory);
        addResource(9, 45 , map, Ivory);
        addResource(18, 47 , map, Ivory);
        addResource(19, 43 , map, Ivory);
        addResource(23, 41 , map, Ivory);
        addResource(22, 49 , map, Marble);
        addResource(12, 9 , map, Marble);
        addResource(6, 8 , map, Marble);
        addResource(9, 22 , map, Marble);
        addResource(18, 43 , map, Marble);
        addResource(19, 39, map, Marble);
        addResource(22, 51 , map, Marble);
        addResource(21, 59 , map, Marble);
        addResource(13, 59 , map, Marble);
        addResource(6, 2 , map, Silk);
        addResource(6, 5 , map, Silk);
        addResource(10, 33 , map, Silk);
        addResource(6, 38 , map, Silk);
        addResource(10, 49 , map, Silk);
        addResource(21, 53 , map, Silk);
        addResource(23, 56 , map, Silk);
        addResource(13, 64 , map, Silk);
        addResource(9, 57 , map, Silk);
        addResource(7, 68 , map, Silver);
        addResource(16, 61 , map, Silver);
        addResource(17, 50 , map, Silver);
        addResource(14, 52 , map, Silver);
        addResource(15, 40 , map, Silver);
        addResource(8, 33 , map, Silver);
        addResource(10, 30, map, Silver);
        addResource(9, 33 , map, Silver);
        addResource(23, 0 , map, Silver);
        addResource(6, 75 , map, Sugar);
        addResource(10, 52 , map, Sugar);
        addResource(10, 59 , map, Sugar);
        addResource(10, 61 , map, Sugar);
        addResource(8, 30 , map, Sugar);
        addResource(4, 40 , map, Sugar);
        addResource(10, 43 , map, Sugar);
        riverMaker(map);
        setPrice(map);

        return map;
    }

    private void addResource(int x, int y, Maps map, Resource resource){
        Resource resource1 = new Resource(resource.getName(), resource.getResourceType(), resource.getRequiredImprovement(),
                resource.getGoldRate(), resource.getFoodRate(), resource.getProductionRate(), resource.getHappiness());
        map.getSpecificTile(x, y).setResource(resource1);
        resource1.setTileX(x);
        resource1.setTileY(y);
    }

    private void riverMaker(Maps map){

        for (int i = 8, j = 9; i < 20; i++){
            boolean[] riverBoarder = {false, false, false, true, true, false};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
            if (i % 2 == 1)j++;
        }

        for (int i = 10, j = 9; i < 21; i++){
            boolean[] riverBoarder = {true, true, false, false, false, false};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
            if (i % 2 == 1)j++;
        }

        for (int i = 8, j = 20; i < 18; i+=2){
            boolean[] riverBoarder = {false, true, true, false, true, true};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
        }

        for (int i = 11, j = 19; i < 18; i+=2){
            boolean[] riverBoarder = {false, true, true, false, false, false};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
        }

        for (int i = 9, j = 20; i < 16; i+=2){
            boolean[] riverBoarder = {false, false, false, false, true, true};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
        }

        for (int i = 4, j = 69; i < 14; i++){
            boolean[] riverBoarder = {false, false, true, true, false, false};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
            if (i % 2 == 0)j--;
        }

        for (int i = 6, j = 69; i < 15; i++){
            boolean[] riverBoarder = {true, false, false, false, false, true};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
            if (i % 2 == 0)j--;
        }

        for (int i = 4, j = 59; i < 14; i++){
            boolean[] riverBoarder = {false, false, false, true, true, false};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
            if (i % 2 == 1)j++;
        }

        for (int i = 6, j = 59; i < 15; i++){
            boolean[] riverBoarder = {true, true, false, false, false, false};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
            if (i % 2 == 1)j++;
        }

        for (int i = 19, j = 64; i < 24; i++){
            boolean[] riverBoarder = {true, true, false, false, false, false};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
            if (i % 2 == 1)j++;
        }

        for (int i = 18, j = 65; i < 23; i++){
            boolean[] riverBoarder = {false, false, false, true, true, false};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
            if (i % 2 == 1)j++;
        }

        for (int i = 19, j = 63; i < 25; i++){
            boolean[] riverBoarder = {true, false, false, false, false, true};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
            if (i % 2 == 0)j--;
        }

        for (int i = 18, j = 63; i < 24; i++){
            boolean[] riverBoarder = {false, false, true, true, false, false};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
            if (i % 2 == 0)j--;
        }
        boolean[] riverBoarder14_64 = {true, true, false, false, false, true};
        map.getSpecificTile(14, 64).setRiverBorder(riverBoarder14_64);
        map.getSpecificTile(14, 64).setNearRiver(true);

        boolean[] riverBoarder15_64 = {true, true, true, false, false, false};
        map.getSpecificTile(15, 64).setRiverBorder(riverBoarder15_64);
        map.getSpecificTile(15, 64).setNearRiver(true);

        boolean[] riverBoarder17_64 = {false, true, true, true, false, false};
        map.getSpecificTile(17, 64).setRiverBorder(riverBoarder17_64);
        map.getSpecificTile(17, 64).setNearRiver(true);

        boolean[] riverBoarder18_64 = {false, false, true, true, true, false};
        map.getSpecificTile(18, 64).setRiverBorder(riverBoarder18_64);
        map.getSpecificTile(18, 64).setNearRiver(true);

        boolean[] riverBoarder17_63 = {false, false, false, true, true, true};
        map.getSpecificTile(17, 63).setRiverBorder(riverBoarder17_63);
        map.getSpecificTile(17, 63).setNearRiver(true);

        boolean[] riverBoarder15_63 = {true, false, false, false, true, true};
        map.getSpecificTile(15, 63).setRiverBorder(riverBoarder15_63);
        map.getSpecificTile(15, 63).setNearRiver(true);

        map.getSpecificTile(14, 65).setRiverBorder(riverBoarder15_63);
        map.getSpecificTile(14, 65).setNearRiver(true);

        map.getSpecificTile(18, 65).setRiverBorder(riverBoarder17_63);
        map.getSpecificTile(18, 65).setNearRiver(true);

        map.getSpecificTile(18, 63).setRiverBorder(riverBoarder17_64);
        map.getSpecificTile(18, 63).setNearRiver(true);

        map.getSpecificTile(14, 63).setRiverBorder(riverBoarder15_64);
        map.getSpecificTile(14, 63).setNearRiver(true);

        boolean[] riverBoarder16_65 = {false, false, false, false, true, true};
        map.getSpecificTile(16, 65).setRiverBorder(riverBoarder16_65);
        map.getSpecificTile(16, 65).setNearRiver(true);

        boolean[] riverBoarder16_63 = {false, true, true, false, false, false};
        map.getSpecificTile(16, 63).setRiverBorder(riverBoarder16_63);
        map.getSpecificTile(16, 63).setNearRiver(true);

        boolean[] riverBoarder12_64 = {false, false, false, true, false, false};
        map.getSpecificTile(12, 64).setRiverBorder(riverBoarder12_64);
        map.getSpecificTile(12, 64).setNearRiver(true);

        boolean[] riverBoarder20_64 = {true, false, false, false, false, false};
        map.getSpecificTile(20, 64).setRiverBorder(riverBoarder20_64);
        map.getSpecificTile(20, 64).setNearRiver(true);

        for (int i = 19, j = 41; i > 5; i--){
            boolean[] riverBoarder = {true, false, false, false, false, true};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
            if (i % 2 == 1)j++;
        }
        for (int i = 17, j = 41; i > 4; i--){
            boolean[] riverBoarder = {false, false, true, true, false, false};
            map.getSpecificTile(i, j).setRiverBorder(riverBoarder);
            map.getSpecificTile(i, j).setNearRiver(true);
            if (i % 2 == 1)j++;
        }
    }

    public void setPrice(Maps map) {
        for (int i = 0; i < 25; i++)
            for (int j = 0; j < 80; j++)
                map.getSpecificTile(i, j).setPrice();

    }
}
