package view;

import controller.MapController;
import controller.UsersController;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class CityMenuTest {
    Maps maps = new Maps(25, 80);
    UsersController usersController = new UsersController();
    ArrayList<User> users = new ArrayList<>();
    User user1 = new User("AmirHossein", "AmirHossein", "AmirHossein12");
    User user2 = new User("Mohammad", "Mohammad", "Mohammad12");
    User user3 = new User("Shayan", "Shayan", "Shayan12");
    MilitaryUnit meleeUnit = new MilitaryUnit("swordMan", maps.getSpecificTile(4, 5), 2, 2, 2, 1, 2, 2, 0,user1, 2, 2);
    MilitaryUnit rangeUnit = new MilitaryUnit("swordMan", maps.getSpecificTile(4, 5), 2, 2, 2, 1, 2, 2, 2,user1, 2, 2);
    MilitaryUnit defMeleeUnit = new MilitaryUnit("swordMan", maps.getSpecificTile(5, 5), 2, 2, 2, 1, 2, 2, 0,user1, 2, 2);
    MilitaryUnit defRangeUnit = new MilitaryUnit("swordMan", maps.getSpecificTile(5, 5), 2, 2, 2, 1, 2, 2, 2,user1, 2, 2);
    @Before
    public void SetUp() {
        usersController.addUser(user1);
        usersController.addUser(user2);
        usersController.addUser(user3);
    }

    @Test
    public void checkSetProduction1(){
        Product product1 = new Product("name1",12);
        Product product2 = new Product("name2",11);
        Product product3 = new Product("name3",10);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        City city = new City("nameOfCity", maps.getSpecificTile(5, 5), user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        Scanner scanner = new Scanner("\n2\n2\n2\n2\nproduction exit");
        city.setProducts(products);
        MapController mapController = new MapController(maps);
        CityMenu cityMenu = new CityMenu(mapController,null,null,null,null);
        cityMenu.setProduction(city,user1,scanner);
        Assert.assertTrue(city.isProductStatus());
    }

    @Test
    public void checkSetProduction2(){
        Product product1 = new Product("name1",12);
        Product product2 = new Product("name2",11);
        Product product3 = new Product("name3",10);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        City city = new City("nameOfCity", maps.getSpecificTile(5, 5), user1, null, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);
        Scanner scanner = new Scanner("\nadd product 2\nproduction exit");
        city.setProducts(products);
        MapController mapController = new MapController(maps);
        CityMenu cityMenu = new CityMenu(mapController,null,null,null,null);
        cityMenu.setProduction(city,user1,scanner);
        Assert.assertEquals(50,city.getProductTurnLeft());
    }

    @Test
    public void checkSetCitizens(){
        Terrain Hill = new Terrain("Hill", "purple", 2, 0, 0.25, 0, 2, true);
        Tile tile1 = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        Tile tile2 = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        Tile tile3 = new Tile(18, 20, null, Hill, 0, false, null, null, null);
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile1);
        tiles.add(tile2);
        tiles.add(tile3);
        City city = new City("nameOfCity", maps.getSpecificTile(5, 5), user1, tiles, 100, 100, null, null,
                50, 1, 1, 1, 1, 1, 1, 1, 1,
                null, null, false, null, 20);

        Citizen citizen1 = new Citizen(tile1);
        Citizen citizen2 = new Citizen(tile2);
        Citizen citizen3 = new Citizen(tile3);
        ArrayList<Citizen> citizens = new ArrayList<>();
        citizens.add(citizen1);
        citizens.add(citizen2);
        citizens.add(citizen3);
        city.setCitizens(citizens);
        MapController mapController = new MapController(maps);
        CityMenu cityMenu = new CityMenu(mapController,null,null,null,null);
        Scanner scanner = new Scanner("\n2\n2\n2\n2");
        cityMenu.setCitizen(scanner,city);
        Assert.assertTrue(city.getOwnerShipTiles().get(1).isCitizenExist());
    }
}
