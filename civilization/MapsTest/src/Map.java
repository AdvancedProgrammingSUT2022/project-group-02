public class Map {

    public Tile[][] tileBoard = new Tile[10][10];

    private MapController mapController = new MapController(tileBoard);

    public Map (){}

    public void fillMap (){

        //TODO : for graphic part should increase number of tiles

        User user1 = new User("U11" , "B");
        User user2 = new User("U22" , "R");
        User user3 = new User("U33" , "Y");
        User[] users = new User[4];
        users[0] = user1;
        users[1] = user1;
        users[2] = user2;
        users[3] = user3;
        boolean[] borderRiver = {false , false , false , false , false , false};
        Land land = new Land("L" , "W",0 ,0 , 0 , 0, 0 ,false , false , null , borderRiver);
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 4; j++){
                Tile tile = new Tile(i , j , users[j] , land , j);
                tileBoard[i][j] = tile;
            }
        }

    }

    public void printMapBoard(){
        mapController.setTileBoard(tileBoard);
        mapController.printMap();
    }


    /*for (int i = 0; i < 4; i++){
            System.out.println("  /    [" + 2 * i + ",0]   \\             " + "  /    [" + 2 * i + ",1]   \\             " + "  /    [" + 2 * i + ",2]   \\             " + "  /    [" + 2 * i + ",3]   \\  \n" +
                    " /   " + tileBoard[2 * i][0].getLand().getColor() + "      " + tileBoard[2 * i][0].getOwner().getColor() + "   \\            " + " /   " + tileBoard[2 * i][1].getLand().getColor() + "      " + tileBoard[2 * i][1].getOwner().getColor() + "   \\            " + " /   " + tileBoard[2 * i][2].getLand().getColor() + "      " + tileBoard[2 * i][2].getOwner().getColor() + "   \\            " + " /   " + tileBoard[2 * i][3].getLand().getColor() + "      " + tileBoard[2 * i][3].getOwner().getColor() + "   \\  \n" +
                    "/       " + tileBoard[2 * i][0].getOwner().getName() + "       \\___________" + "/       " + tileBoard[2 * i][1].getOwner().getName() + "       \\___________" + "/       " + tileBoard[2 * i][2].getOwner().getName() + "       \\___________" + "/       " + tileBoard[2 * i][3].getOwner().getName() + "       \\\n" +
                    "\\                /   [" + (2 * i + 1) + ",0]   " + "\\                /   [" + (2 * i + 1) + ",1]   " + "\\                /   [" + (2 * i + 1) + ",2]   " + "\\                /\n" +
                    " \\              /   " + tileBoard[2 * i + 1][0].getLand().getColor() + "     " + tileBoard[2 * i + 1][0].getOwner().getColor() + "   \\              /   " + tileBoard[2 * i + 1][1].getLand().getColor() + "     " + tileBoard[2 * i + 1][1].getOwner().getColor() + "   \\              /   " + tileBoard[2 * i + 1][2].getLand().getColor() + "     " + tileBoard[2 * i + 1][2].getOwner().getColor() + "   \\              /\n" +
                    "  \\____________/       " + tileBoard[2 * i + 1][0].getOwner().getName() + "      \\____________/       " + tileBoard[2 * i + 1][1].getOwner().getName() + "      \\____________/       " + tileBoard[2 * i + 1][2].getOwner().getName() + "      \\____________/");
        }
    */

}
