package controller;

import model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class WorkerUnitLogicTest {

    User user1 = new User("AmirHossein", "AmirHossein", "AmirHossein12");
    Feature Jungle = new Feature("Jungle", 2, 1, 0.25, 0, 1);
    Feature Forest = new Feature("Forest", 2, 1, 0.25, 0, 1);
    Feature Marsh = new Feature("Marsh", 2, -1, -0.33, 0, 0);
    Tile forestTile = new Tile(1, 1, user1, null, 1, false, null, null, Forest);
    Tile jungleTile = new Tile(1, 1, user1, null, 1, false, null, null, Jungle);
    Tile marshTile = new Tile(1, 1, user1, null, 1, false, null, null, Marsh);
    Worker worker = new Worker("Archer", forestTile, 100, 10, 10, 1, 4, 5, 5,false, user1, 5, 3);
    UnitController unitController = new UnitController();

    @Before
    public void setUp(){
        unitController.createUnit(worker);
        user1.addUnit(worker);
    }

    @Test // step 1.1: create a unit
    public void checkCreateUnit(){
        Assertions.assertEquals(unitController.getUnits().get(0), worker);
    }

    @Test // step 1.2: check that creat worker save correctly in Arraylist
    public void checkUnitsSave(){
        ArrayList<Unit> units = new ArrayList<>();
        Unit unit = new Unit("Archer", forestTile, 100, 10, 10, 1, 4, 5, 5, user1, 5, 3);
        units.add(worker);
        units.add(unit);
        unitController.createUnit(unit);
        Assertions.assertNotNull(unitController.getUnits());
        Assertions.assertTrue(unitController.getUnits().containsAll(units));
    }

    @Test // step 2: check its working status to command to work on someThing
    public void checkWorking(){
        worker.setWorkingStatus(false);
        Assertions.assertTrue(unitController.workingWorker(worker));
    }

    @Test // step 3: check its MP to command to work on someThing
    public void checkMP(){
        worker.setMP(0);
        Assertions.assertFalse(unitController.MPCheckerForImprovement(worker));
    }

    @Test // step 4.1: check the destination tile to have forest to command worker to chop down it
    public void checkForestExits(){
        Assertions.assertTrue(unitController.isForestExistOnTile(forestTile));
    }

    @Test // step 4.2: check the destination tile to have jungle to command worker to chop down it
    public void checkJungleExist(){
        Assertions.assertTrue(unitController.isJungleExistOnTile(jungleTile));
    }

    @Test // step 4.3: check the destination tile to have marsh to command worker to remove it
    public void checkMarshExist(){
        Assertions.assertTrue(unitController.isMarshExistOnTile(marshTile));
    }

    @Test // step 5: maybe worker get damaged, so it should repair itself
    public void checkRepair(){
        int workerHPBeforeRun = worker.getHP();
        unitController.repair(worker);
        int workerHPAfterRun = worker.getHP();
        boolean result = workerHPAfterRun > workerHPBeforeRun;
        Assertions.assertTrue(result);
    }

    @Test // step 6: maybe we want to remove unit from our units -> 20% of unit gold price should add to user Gold
    public void checkRemoveUnit(){
        user1.setGold(5);
        int userGoldBeforeRun = user1.getGold();
        unitController.removeUnit(false, worker, user1);
        int userGoldAfterRun = user1.getGold();
        boolean result = userGoldAfterRun > userGoldBeforeRun;
        Assertions.assertTrue(result && !user1.getUnits().contains(worker));
    }

    @Test //cheat code : repair mp of units
    public void checkRepairMovement(){
        Tile tile = new Tile(0, 0, user1, null, 1, false, null, null, Jungle);
        Unit militaryUnit1 = new MilitaryUnit("settler", tile, 0, 0, 0, 0, 0, 0, 0, user1, 0, 0);
        user1.addUnit(militaryUnit1);
        int unitMPBeforeRun = militaryUnit1.getMP();
        unitController.repairMovementPoint(user1);
        int unitMPAfterRun = militaryUnit1.getMP();
        Assertions.assertEquals(unitMPBeforeRun, unitMPAfterRun);
    }
}
