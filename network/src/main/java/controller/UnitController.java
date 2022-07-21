package controller;
import model.*;

import java.util.ArrayList;

public class UnitController {

    private static UnitController unitController;

    private final ArrayList<Unit> units = new ArrayList<>();

    public static UnitController getInstance() {
        if (unitController == null)
            unitController = new UnitController();
        return unitController;
    }

    public void removeUnit (boolean isSettler, Unit unit, User user) {
        if (!isSettler) user.setGold(user.getGold() + unit.getGoldPrice()/5);
        user.removeUnit(unit);
        units.remove(unit);
    }
    public void repairMovementPoint(User user) {
        for (Unit unit : user.getUnits())
            unit.setMP(unit.getLastingMP());
    }

    public Response deleteUnit(Request request, Maps map) {
        Response response = new Response();
        int xOrigin = (int) request.getParameters().get("xOrigin");
        int yOrigin = (int) request.getParameters().get("yOrigin");
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);

        Tile origin = map.getSpecificTile(xOrigin, yOrigin);

        if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.getMilitaryUnit().getOwner().equals(user)) {
            origin.setMilitaryUnitExists(false);
            origin.getMilitaryUnit().getOwner().removeUnit(origin.getMilitaryUnit());
            origin.setMilitaryUnit(null);
            origin.setSelectedOne(false);
            if (origin.isCivilianUnitExists())
                origin.setSelectedTwo(true);
            response.setMessage("unit deleted successfully!");
        }
        else if (origin.isCivilianUnitExists() && origin.isSelectedTwo() && origin.getCivilianUnit().getOwner().equals(user)) {
            origin.setCivilianUnitExists(false);
            origin.getCivilianUnit().getOwner().removeUnit(origin.getCivilianUnit());
            origin.setCivilianUnit(null);
            origin.setSelectedTwo(false);
            if (origin.isMilitaryUnitExists())
                origin.setSelectedOne(true);
            response.setMessage("unit deleted successfully!");
        }
        return response;
    }

    public Response sleepUnit(Request request, Maps map) {

        Response response = new Response();
        int xOrigin = (int) request.getParameters().get("xOrigin");
        int yOrigin = (int) request.getParameters().get("yOrigin");
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);

        Tile origin = map.getSpecificTile(xOrigin, yOrigin);

        if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.getMilitaryUnit().getOwner().equals(user)) {
            origin.getMilitaryUnit().setSleep(true);
            if (origin.isCivilianUnitExists()) {
                origin.setSelectedOne(false);
                origin.setSelectedTwo(true);
            }
            response.setMessage("unit sleep successfully!");
        }
        else if (origin.isCivilianUnitExists() && origin.isSelectedTwo() && origin.getCivilianUnit().getOwner().equals(user)) {
            origin.getCivilianUnit().setSleep(true);
            if (origin.isMilitaryUnitExists()) {
                origin.setSelectedOne(true);
                origin.setSelectedTwo(false);
            }
            response.setMessage("unit sleep successfully!");
        }
        return response;
    }

    public Response alertUnit(Request request, Maps map) {

        Response response = new Response();
        int xOrigin = (int) request.getParameters().get("xOrigin");
        int yOrigin = (int) request.getParameters().get("yOrigin");
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);

        Tile origin = map.getSpecificTile(xOrigin, yOrigin);

        if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.getMilitaryUnit().getOwner().equals(user)) {
            origin.getMilitaryUnit().setAlert(true);
            if (origin.isCivilianUnitExists()) {
                origin.setSelectedOne(false);
                origin.setSelectedTwo(true);
            }
            System.out.println("unit alerted successfully!");
        }
        else if (origin.isCivilianUnitExists() && origin.isSelectedTwo() && origin.getCivilianUnit().getOwner().equals(user)) {
            origin.getCivilianUnit().setAlert(true);
            if (origin.isMilitaryUnitExists()) {
                origin.setSelectedOne(true);
                origin.setSelectedTwo(false);
            }
            response.setMessage("unit alerted successfully!");
        }
        return response;
    }

    public Response garrisonUnit(Request request, Maps map) {
        Response response = new Response();
        int xOrigin = (int) request.getParameters().get("xOrigin");
        int yOrigin = (int) request.getParameters().get("yOrigin");
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);

        Tile origin = map.getSpecificTile(xOrigin, yOrigin);

        if (origin.getCity() != null) {
            if (origin.getCity().getTile().equals(origin)) {
                if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.getMilitaryUnit().getOwner().equals(user)) {
                    Unit unit = origin.getMilitaryUnit();
                    unit.setAlert(true);
                    unit.setOrdered(true);
                    origin.getCity().setHP(origin.getCity().getHP() * 2);
                    response.setMessage("assigned to defend city successfully!");
                }
                else if (origin.isCivilianUnitExists() && origin.isSelectedTwo() && origin.getCivilianUnit().getOwner().equals(user)) {
                    Unit unit = origin.getCivilianUnit();
                    unit.setAlert(true);
                    unit.setOrdered(true);
                    origin.getCity().setHP(origin.getCity().getHP() * 2);
                    response.setMessage("assigned to defend city successfully!");
                }
                else
                    response.setMessage("no unit here");
            }
            else
                response.setMessage("there is no city on this tile");
        }
        else
            response.setMessage("this tile do not belong to any user");
        return response;
    }

    public Response fortifyUnit(Request request, Maps map) {

        Response response = new Response();
        int xOrigin = (int) request.getParameters().get("xOrigin");
        int yOrigin = (int) request.getParameters().get("yOrigin");
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);

        Tile origin = map.getSpecificTile(xOrigin, yOrigin);

        if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.getMilitaryUnit().getOwner().equals(user)) {
            if (origin.getMilitaryUnit().getHP() != origin.getMilitaryUnit().getTotalHealth()) {
                origin.getMilitaryUnit().setFortify(true);
                response.setMessage("assigned to fortify successfully!");
            }
            else
                response.setMessage("no need to fortify");
        }
        else if (origin.isCivilianUnitExists() && origin.isSelectedTwo() && origin.getCivilianUnit().getOwner().equals(user)) {
            if (origin.getCivilianUnit().getHP() != origin.getCivilianUnit().getTotalHealth()) {
                origin.getCivilianUnit().setFortify(true);
                response.setMessage("assigned to fortify successfully!");
            }
            else
                response.setMessage("no need to fortify");
        }
        else
            response.setMessage("no unit here");
        return response;
    }

    public Response pillageUnit(Request request, Maps map) {

        Response response = new Response();
        int xOrigin = (int) request.getParameters().get("xOrigin");
        int yOrigin = (int) request.getParameters().get("yOrigin");
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);

        Tile origin = map.getSpecificTile(xOrigin, yOrigin);

        if (origin.isMilitaryUnitExists() && origin.isSelectedOne() && origin.getMilitaryUnit().getOwner().equals(user)) {
            if (origin.getOwner() != null && !origin.getOwner().equals(user) && origin.getImprovement() != null) {
                origin.setLooted(true);
                response.setMessage("pillaged successfully!");
            }
            else
                response.setMessage("it is not proper for pillaging");
        }
        else
            System.out.println("none of your military units are here!");
        return response;
    }

    public Response repairImprovement(Request request, Maps map) {

        Response response = new Response();
        int xOrigin = (int) request.getParameters().get("xOrigin");
        int yOrigin = (int) request.getParameters().get("yOrigin");
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);

        Tile origin = map.getSpecificTile(xOrigin, yOrigin);

        if (origin.isCivilianUnitExists() && origin.getCivilianUnit().getName().equals("worker") && origin.getOwner().equals(user) && origin.getImprovement() != null && origin.isLooted()) {
            origin.setInProgress(true);
            Worker worker = (Worker) origin.getCivilianUnit();
            worker.setWorkingStatus(true);
            worker.setRemainingTurnsToComplete(origin.getImprovement().getPrice());
            worker.setImprovement(origin.getImprovement());
            origin.setImprovement(null);
            response.setMessage("will be repaired as soon as possible!");
        }
        else
            response.setMessage("impossible to repair");
        return response;
    }

    public Response pauseImprovement(Request request, Maps map) {

        Response response = new Response();
        int xOrigin = (int) request.getParameters().get("xOrigin");
        int yOrigin = (int) request.getParameters().get("yOrigin");
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);

        Tile origin = map.getSpecificTile(xOrigin, yOrigin);

        if (origin.isInProgress() && origin.getCivilianUnit().getOwner().equals(user)) {
            Worker worker = (Worker) origin.getCivilianUnit();
            worker.setWorkingStatus(false);
            response.setMessage("pause working...!");
        }
        else
            response.setMessage("not producing anything right now!");

        return response;
    }

    public Response resumeImprovement(Request request, Maps map) {
        Response response = new Response();
        int xOrigin = (int) request.getParameters().get("xOrigin");
        int yOrigin = (int) request.getParameters().get("yOrigin");
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);

        Tile origin = map.getSpecificTile(xOrigin, yOrigin);

        if (origin.isCivilianUnitExists() && origin.getCivilianUnit().getName().equals("worker") && origin.getCivilianUnit().getOwner().equals(user)) {
            Worker worker = (Worker) origin.getCivilianUnit();
            worker.setWorkingStatus(true);
            response.setMessage("resume working...!");
        }
        else
            response.setMessage("do not have any improvement in queue");
        return response;
    }

}
