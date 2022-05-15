package controller;

import model.Tile;
import model.Unit;
import model.User;
import org.junit.Test;

public class UnitLogicTest {

    User user1 = new User("AmirHossein", "AmirHossein", "AmirHossein12");
    Tile tile = new Tile(1, 1, user1, null, 1, false, null, null, null);
    Unit unit = new Unit("Archer", null, 100, 10, 10, 1, 4, 5, 5, null, 5, 3);
    UnitController unitController = new UnitController();

    @Test // step 1: create a unit
    public void checkCreateUnit(){

    }
}
