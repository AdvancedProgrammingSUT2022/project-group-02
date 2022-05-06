package model;

public class amirMap {
    //Features
    Feature FloodPlain = new Feature("FloodPlain", 1, 2, -0.33, 0, 0);
    Feature Jungle = new Feature("Jungle", 2, 1, 0.25, 0, 1);
    Feature Forest = new Feature("Forest", 2, 1, 0.25, 0, 1);
    Feature Marsh = new Feature("Marsh", 2, -1, -0.33, 0, 0);
    Feature Ice = new Feature("Ice", 0, 0, 0, 0, 0);
    Feature Oasis = new Feature("Oasis", 1, 3, -0.33, 1, 0);

    //Terrains
    Terrain Desert = new Terrain("Desert", "yellow", 1, 0, -0.33, 0, 0, true);
    Terrain GrassLand = new Terrain("Grassland", "green", 1, 2, -0.33, 0, 0, true);
    Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
    Terrain Mountain = new Terrain("Mountain", "brightBlack", 0, 0, 0, 0, 0, false);
    Terrain Ocean = new Terrain("Ocean", "brightBlue", 0, 0, 0, 0, 0, false);
    Terrain Plain = new Terrain("Plain", "red", 1, 1, -0.33, 0, 1, true);
    Terrain Snow = new Terrain("Snow", "white", 1, 0, -0.33, 0, 0, true);
    //TODO : color for Tundra
    Terrain Tundra = new Terrain("Tundra", "", 1, 1, -0.33, 0, 0, true);

    public void mapmaker(){
        Maps map = new Maps(52, 80);
        //1st row
        for (int i = 0; i < 80; i++){
            if (i > 38 && i < 43){
                Tile tile = new Tile(0, i, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            Tile tile = new Tile(0, i, null, Ocean, 3, false, null, null, Ice);
            map.setTileBoard(tile);
        }
        //2nd row
        for (int i = 0; i < 80; i++){
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
        }
        //3rd row
        for (int i = 0; i < 80; i++){
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
        }
        //4th row
        for (int i = 0; i < 80; i++){
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
        }
        //5th row
        for (int i = 0; i < 80; i++){
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
                    Tile tile = new Tile(4, 59, null, Tundra, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    continue;
                }
                Tile tile = new Tile(4, i, null, Snow, 3, false, null, null, null);
                map.setTileBoard(tile);
                continue;
            }
            Tile tile = new Tile(4, i, null, Ocean, 3, false, null, null, Ice);
            map.setTileBoard(tile);
        }
        //6th row
        for (int i = 0; i < 80; i++){
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
        }
        //7th row
        for (int i = 0; i < 80; i++){
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
            Tile tile = new Tile(4, i, null, Ocean, 3, false, null, null, Ice);
            map.setTileBoard(tile);
        }
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
            if (i == 3){
                Tile tile = new Tile(9, 3, null, Hill, 3, false, null, null, FloodPlain);
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
                tile = new Tile(9, 57, null, GrassLand, 3, false, null, null, Forest);
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
        for (int i = 0; i < 80; i++){
            if (i > 8 && i < 22){
                if (i == 14){
                    Tile tile = new Tile(11, i, null, Ocean, 3, false, null, null, null);
                    map.setTileBoard(tile);
                    continue;
                }
                Tile tile = new Tile(11, i, null, GrassLand, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                continue;
            }
            if (i == 22){
                Tile tile = new Tile(11, 22, null, Hill, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                tile = new Tile(11, 23, null, Hill, 3, false, null, null, Forest);
                map.setTileBoard(tile);
                i = 23;
                continue;
            }
            if (i == 34){
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
    }

}
