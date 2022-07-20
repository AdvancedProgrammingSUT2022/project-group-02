package controller;

import model.*;
import view.Notifications;

import java.util.ArrayList;
import java.util.HashMap;

public class CombatController extends UnitController {

    private static CombatController combatController;

    public static CombatController getInstance() {
        if (combatController == null) {
            combatController = new CombatController();
        }
        return combatController;
    }

    //combat handling : first version of code

    private void destroyCity(City city) {
        User previous = city.getOwner();
        previous.removeCity(city);
        for (Tile ownerShipTile : city.getOwnerShipTiles()) {
            ownerShipTile.setOwner(null);
            ownerShipTile.setCity(null);
            previous.removeTerritory(ownerShipTile);
        }
        city = null;
    }

    private void annexCity(City city, Unit unit) {
        User previous = city.getOwner();

        previous.removeCity(city);
        city.setOwner(unit.getOwner());
        for (Tile ownerShipTile : city.getOwnerShipTiles()) {
            ownerShipTile.setOwner(unit.getOwner());
            unit.getOwner().addTerritory(ownerShipTile);
            previous.removeTerritory(ownerShipTile);
        }
        unit.getOwner().addCity(city);
    }

    public void attackCity(City city, Unit unit) {
        if (city.getTile() != null && city.getTile().getTerrain().getName().equals("Hill")) {
            city.setHP(city.getHP() - (unit.getAttackPoint() / 2));
        }
        else {
            city.setHP(city.getHP() - unit.getAttackPoint());
        }
    }

    public void attackUnit(Unit first, Unit second) {
        second.setHP(second.getHP() - first.getAttackPoint());
        if (second.getHP() <= 0) {
            Tile tile = second.getTile();
            second.getOwner().removeUnit(second);
            tile.setMilitaryUnit(null);
            tile.setMilitaryUnitExists(false);
            moveWinnerUnitToDestination(first, tile);
        }
    }

    private void moveWinnerUnitToDestination(Unit unit, Tile destination) {
        Tile origin = unit.getTile();
        origin.setMilitaryUnitExists(false);
        origin.setMilitaryUnit(null);
        destination.setMilitaryUnitExists(true);
        destination.setMilitaryUnit(unit);
        unit.setTile(destination);
    }

    public void annexCivilianUnit(User user, Unit unit) {
        unit.setOwner(user);
        user.addUnit(unit);
    }

    public Response decisionOnWhatDoDo(Request request, Maps map) {
        Response response = new Response();
        int index = (int) request.getParameters().get("index");

        int xOrigin = (int) request.getParameters().get("xOrigin");
        int yOrigin = (int) request.getParameters().get("yOrigin");
        int xDestination = (int) request.getParameters().get("xDestination");
        int yDestination = (int) request.getParameters().get("yDestination");
        Tile origin = map.getSpecificTile(xOrigin, yOrigin);
        Tile destination = map.getSpecificTile(xDestination, yDestination);


        if (index == 1) {
            //destroy city
            destroyCity(destination.getCity());
            origin.getMilitaryUnit().getOwner().setHappiness(origin.getMilitaryUnit().getOwner().getHappiness() - 10);
            response.setMessage("city destroyed successfully!");
        }
        else if (index == 2) {
            //annex city
            annexCity(destination.getCity(), origin.getMilitaryUnit());
            response.setMessage("city annexed successfully!");
        }
        return response;
    }

    public Response conditionForAttackUnit(Request request, Maps map) {
        Response response = new Response();
        HashMap<String, Object> parameters = new HashMap<>();
        int xOrigin = (int) request.getParameters().get("xOrigin");
        String username = (String) request.getParameters().get("username");
        int yOrigin = (int) request.getParameters().get("yOrigin");
        int xDestination = (int) request.getParameters().get("xDestination");
        User user = UsersController.getInstance().getUserByUsername(username);
        int yDestination = (int) request.getParameters().get("yDestination");
        Tile origin = map.getSpecificTile(xOrigin, yOrigin);
        Tile destination = map.getSpecificTile(xDestination, yDestination);


        if (MapController.getInstance().findDistance(origin, destination) == 1 ||
                (MapController.getInstance().findDistance(origin, destination) == 2 && origin.getMilitaryUnit().getRangeCombatStrength() > 0)) {
            if (destination.isMilitaryUnitExists() && !destination.getMilitaryUnit().getOwner().equals(user)) {
                if (!user.getEnemies().contains(destination.getMilitaryUnit().getOwner())) {
                    user.addEnemy(destination.getMilitaryUnit().getOwner());
                    response.setNotifications(Notifications.sendNotificationToInvader(user, destination.getMilitaryUnit().getOwner()));
                    response.setNotifications(Notifications.sendNotificationToDefender(user, destination.getMilitaryUnit().getOwner()));
                    parameters.put("notification", true);
                }
                else
                    parameters.put("notification", false);
                attackUnit(origin.getMilitaryUnit(), destination.getMilitaryUnit());

            } else if (destination.isCivilianUnitExists() && !destination.getCivilianUnit().getOwner().equals(user)) {
                if (!user.getEnemies().contains(destination.getCivilianUnit().getOwner())) {
                    user.addEnemy(destination.getCivilianUnit().getOwner());
                    response.setNotifications(Notifications.sendNotificationToInvader(user, destination.getCivilianUnit().getOwner()));
                    response.setNotifications(Notifications.sendNotificationToDefender(user, destination.getCivilianUnit().getOwner()));
                    parameters.put("notification", true);
                }
                else
                    parameters.put("notification", false);
                annexCivilianUnit(user, destination.getCivilianUnit());

                response.setMessage("you own this unit now!");
            } else {
                response.setMessage("there is no unit on this tile");
                parameters.put("notification", false);
            }
        }
        else {
            response.setMessage("this tile is not in your range");
            parameters.put("notification", false);
        }
        response.setParameters(parameters);
        return response;
    }
}
