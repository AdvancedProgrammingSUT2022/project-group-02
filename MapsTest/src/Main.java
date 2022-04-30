public class Main {
    public static void main(String[] args){
        Map map = new Map();
        MapController mapController = new MapController(map);
        map.fillMap1();
        mapController.printMap();
    }
}
