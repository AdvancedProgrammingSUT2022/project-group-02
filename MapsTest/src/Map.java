public class Map {

    public Tile[][] tileBoard = new Tile[10][10];

    private final MapController mapController = new MapController(tileBoard);

    public Map (){}

    public void fillMap1 (){

        User user1 = new User("U11" , "green");
        User user2 = new User("U22" , "red");
        User user3 = new User("U33" , "yellow");
        Terrain jungle = new Terrain("jungle", 2, 1, 0.25, 0, 1);
        Land Desert = new Land("Ocean", "yellow", 1, 0, -0.33, 0, 0, true, null, jungle);
        Land GrassLand = new Land("Grassland", "green", 1, 2, -0.33, 0, 0, true, null, jungle);
        Land Hill = new Land("Hill", "purple", 2, 0, 0.25, 0, 2, true, null, jungle);
        Land Mountain = new Land("Mountain", "cyan", 0, 0, 0, 0, 0, false, null, jungle);
        Land Ocean = new Land("Ocean", "black", 0, 0,0, 0, 0, false, null, null);
        Land Plain = new Land("Plain", "green", 1, 1, -0.33, 0, 1, true, null, jungle);
        Land SnowLand = new Land("Snow", "white", 1, 0 ,-0.33, 0, 0, true, null, jungle);

        boolean[] noRiver = {false ,false ,false ,false ,false ,false};
        boolean[] riverBorder1 = {false ,true ,false ,false ,false ,false};
        boolean[] riverBorder2 = {false ,false ,true ,true ,true ,false};
        boolean[] riverBorder3 = {false ,false ,false ,true ,true ,false};
        boolean[] riverBorder4 = {false ,false ,true ,true ,false ,false};
        boolean[] riverBorder5 = {true ,false ,false ,false ,false ,true};
        boolean[] riverBorder6 = {false ,false ,false ,true ,false ,false};
        boolean[] riverBorder7 = {true ,true ,false ,false ,false ,false};
        boolean[] riverBorder8 = {true ,false ,false ,false ,false ,false};
        Tile tile1 = new Tile(0 , 0, null, Ocean, 0, false, noRiver);
        Tile tile2 = new Tile(0, 1, null, Mountain, 0, false, noRiver);
        Tile tile3 = new Tile(0, 2, null, Mountain, 0, false, noRiver);
        Tile tile4 = new Tile(0, 3, null, Mountain, 0, true, riverBorder6);
        Tile tile5 = new Tile(1, 0, user2, GrassLand, 0, true, riverBorder3);
        Tile tile6 = new Tile(1, 1, user2, GrassLand, 0, false, noRiver);
        Tile tile7 = new Tile(1, 2, user3, Plain, 0, true, riverBorder4);
        Tile tile8 = new Tile(1, 3, null, Ocean, 0, false, noRiver);
        Tile tile9 = new Tile(2, 0, null, Ocean, 0, true, riverBorder1);
        Tile tile10 = new Tile(2, 1, user1, GrassLand, 0, true, riverBorder3);
        Tile tile11 = new Tile(2, 2, user2, GrassLand, 0, true, riverBorder4);
        Tile tile12 = new Tile(2, 3, user3, Plain, 0, true, riverBorder5);
        Tile tile13 = new Tile(3, 0, user1, Hill, 0, true, riverBorder7);
        Tile tile14 = new Tile(3, 1, null, Mountain, 0, true, riverBorder2);
        Tile tile15 = new Tile(3, 2, user3, SnowLand, 0, true, riverBorder5);
        Tile tile16 = new Tile(3, 3, null, Ocean, 0, false, noRiver);
        Tile tile17 = new Tile(4, 0, null, Ocean, 0, false, noRiver);
        Tile tile18 = new Tile(4, 1, user3, Desert, 0, true, riverBorder7);
        Tile tile19 = new Tile(4, 2, user1, Desert, 0, true, riverBorder5);
        Tile tile20 = new Tile(4, 3, user1, Desert, 0, false, noRiver);
        Tile tile21 = new Tile(5, 0, user3, Desert, 0, false, noRiver);
        Tile tile22 = new Tile(5, 1, user2, Desert, 0, true, riverBorder8);
        Tile tile23 = new Tile(5, 2, user1, Desert, 0, false, noRiver);
        Tile tile24 = new Tile(5, 3, null, Ocean, 0, false, noRiver);
        Tile tile25 = new Tile(6, 0, null, Ocean, 0, false, noRiver);
        Tile tile26 = new Tile(6, 1, user1, Plain, 0, false, noRiver);
        Tile tile27 = new Tile(6, 2, user2, Plain, 0, false, noRiver);
        Tile tile28 = new Tile(6, 3, user3, Plain, 0, false, noRiver);
        tileBoard[0][0] = tile1;
        tileBoard[0][1] = tile2;
        tileBoard[0][2] = tile3;
        tileBoard[0][3] = tile4;
        tileBoard[1][0] = tile5;
        tileBoard[1][1] = tile6;
        tileBoard[1][2] = tile7;
        tileBoard[1][3] = tile8;
        tileBoard[2][0] = tile9;
        tileBoard[2][1] = tile10;
        tileBoard[2][2] = tile11;
        tileBoard[2][3] = tile12;
        tileBoard[3][0] = tile13;
        tileBoard[3][1] = tile14;
        tileBoard[3][2] = tile15;
        tileBoard[3][3] = tile16;
        tileBoard[4][0] = tile17;
        tileBoard[4][1] = tile18;
        tileBoard[4][2] = tile19;
        tileBoard[4][3] = tile20;
        tileBoard[5][0] = tile21;
        tileBoard[5][1] = tile22;
        tileBoard[5][2] = tile23;
        tileBoard[5][3] = tile24;
        tileBoard[6][0] = tile25;
        tileBoard[6][1] = tile26;
        tileBoard[6][2] = tile27;
        tileBoard[6][3] = tile28;


    }

    public void printMapBoard(){
        mapController.setTileBoard(tileBoard);
        mapController.printMap();
    }


}
