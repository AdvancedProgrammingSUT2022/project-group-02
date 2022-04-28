package controller;

import model.*;

public class WorkerController extends UnitController {

    public boolean buildRoad(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean buildRailRoad(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean buildFarm(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean buildMine(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean buildTradingPost(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean buildSawmill(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean buildPasture(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean buildCamp(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean buildPlantation(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean buildQuarry(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean removeForest(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean removeJungle(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean removeMarsh(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean removeAnyRoad(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

    public boolean repairCell(int x, int y, Unit unit, User user, Maps map) {
        return false;
    }

//    public void workersReturns(City city, Worker worker) {
//        if (worker.isWorking()) {
//            if (worker.getTile().getLand().getName().equals("Grassland")) {
//                city.setFood(city.getFood() + worker.getTile().getLand().getFoodRate());
//            } else if (worker.getTile().getLand().getName().equals("Hill")) {
//                city.setProduction(city.getProduction() + worker.getTile().getLand().getProductionRate());
//            } else if (worker.getTile().getLand().getName().equals("Plain")) {
//                city.setFood(city.getFood() + worker.getTile().getLand().getFoodRate());
//                city.setProduction(city.getProduction() + worker.getTile().getLand().getProductionRate());
//            } else if (worker.getTile().getLand().getName().equals("Tundra")) {
//                city.setFood(city.getFood() + worker.getTile().getLand().getFoodRate());
//            }
//        }
//    }
}
