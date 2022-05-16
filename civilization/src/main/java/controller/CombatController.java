package controller;

import model.*;

import java.util.ArrayList;

public class CombatController extends UnitController {

    //combat handling : first version of code
    public boolean checkDefenderHill(Tile tile) {
        if (tile.getTerrain().getName().equals("Hill")) return true;
        return false;
    }

    public String combatHandler(User attackerUser, Tile selectedTileForAttack, Tile selectedTileForDefend) {
        if (!attackerUser.getTerritory().contains(selectedTileForAttack)) return "this tile is not for you";
        if (selectedTileForAttack.getMilitaryUnit() == null) return "you don't have any military unit in this tile";
        if (selectedTileForAttack.getOwner().equals(selectedTileForDefend.getOwner()))
            return "you can not attack to your own tiles";
        if (selectedTileForAttack.getMilitaryUnit().getRangeCombatStrength() >= 2)
            return remoteCombat(selectedTileForAttack.getMilitaryUnit(), selectedTileForDefend);
        if (selectedTileForAttack.getMilitaryUnit().getRangeCombatStrength() < 2)
            return coldWeaponCombat(selectedTileForAttack.getMilitaryUnit(), selectedTileForDefend);
        return "";
    }

    public String remoteCombat(Unit militaryUnit, Tile selectedTileForDefend) {
        if (checkDefenderHill(selectedTileForDefend))
            selectedTileForDefend.getMilitaryUnit().setHP(selectedTileForDefend.getMilitaryUnit().getHP() + 8);
        militaryUnit.setXP(militaryUnit.getXP() + 5);
        selectedTileForDefend.getMilitaryUnit().setXP(selectedTileForDefend.getMilitaryUnit().getXP() + 5);
        militaryUnit.setMP(militaryUnit.getMP() - 5);
        selectedTileForDefend.getMilitaryUnit().setMP(selectedTileForDefend.getMilitaryUnit().getMP() - 5);
        if (militaryUnit.getHP() > selectedTileForDefend.getMilitaryUnit().getHP()) {
            selectedTileForDefend.getCity().setDefence(selectedTileForDefend.getCity().getDefence() - selectedTileForDefend.getMilitaryUnit().getHP());
            if (selectedTileForDefend.getCity().getDefence() <= 0)
                captureCity(selectedTileForDefend.getCity(), militaryUnit, "destroy");
            selectedTileForDefend.setMilitaryUnit(militaryUnit);
            selectedTileForDefend.setOwner(militaryUnit.getOwner());
            selectedTileForDefend.getCivilianUnit().setOwner(militaryUnit.getOwner());
//            if (militaryUnit.isCity())
//                selectedTileForDefend.setCity(militaryUnit.getTile().getCity());
            ArrayList<Tile> usersNewTiles1 = militaryUnit.getOwner().getTerritory();
            usersNewTiles1.add(selectedTileForDefend);
            militaryUnit.getOwner().setTerritory(usersNewTiles1);
            ArrayList<Tile> usersNewTiles2 = selectedTileForDefend.getMilitaryUnit().getOwner().getTerritory();
            usersNewTiles2.remove(selectedTileForDefend);
            selectedTileForDefend.getOwner().setTerritory(usersNewTiles2);
//            militaryUnit.getTile().getCity().setOwnerShipTiles(usersNewTiles1);
//            selectedTileForDefend.getCity().setOwnerShipTiles(usersNewTiles2);
            return "you got a victory in this attack";
        } else if (militaryUnit.getHP() == selectedTileForDefend.getMilitaryUnit().getHP()) {
            selectedTileForDefend.setMilitaryUnit(null);
            return "you could not get this tile. but you destroyed the military unit of adversary";
        } else if (militaryUnit.getHP() < selectedTileForDefend.getMilitaryUnit().getHP()) {
            selectedTileForDefend.getMilitaryUnit().setHP(selectedTileForDefend.getMilitaryUnit().getHP() - militaryUnit.getHP());
            return "you made a damage to adversary military unit but you could not destroy and get the tile";
        }
        return "";
    }

    public String coldWeaponCombat(Unit militaryUnit, Tile selectedTileForDefend) {
        if (checkDefenderHill(selectedTileForDefend))
            selectedTileForDefend.getMilitaryUnit().setHP(selectedTileForDefend.getMilitaryUnit().getHP() + 8);
        militaryUnit.setXP(militaryUnit.getXP() + 5);
        selectedTileForDefend.getMilitaryUnit().setXP(selectedTileForDefend.getMilitaryUnit().getXP() + 5);
        militaryUnit.setMP(militaryUnit.getMP() - 5);
        selectedTileForDefend.getMilitaryUnit().setMP(selectedTileForDefend.getMilitaryUnit().getMP() - 5);
        if (militaryUnit.getHP() > selectedTileForDefend.getMilitaryUnit().getHP()) {
            militaryUnit.setHP(militaryUnit.getHP() - selectedTileForDefend.getMilitaryUnit().getHP());
            selectedTileForDefend.getCity().setDefence(selectedTileForDefend.getCity().getDefence() - selectedTileForDefend.getMilitaryUnit().getHP());
            if (selectedTileForDefend.getCity().getDefence() <= 0)
                captureCity(selectedTileForDefend.getCity(), militaryUnit, "destroy");
            selectedTileForDefend.setMilitaryUnit(militaryUnit);
            selectedTileForDefend.setOwner(militaryUnit.getOwner());
            selectedTileForDefend.getCivilianUnit().setOwner(militaryUnit.getOwner());
//            if (militaryUnit.isCity())
//                selectedTileForDefend.setCity(militaryUnit.getTile().getCity());
            ArrayList<Tile> usersNewTiles1 = militaryUnit.getOwner().getTerritory();
            usersNewTiles1.add(selectedTileForDefend);
            militaryUnit.getOwner().setTerritory(usersNewTiles1);
            ArrayList<Tile> usersNewTiles2 = selectedTileForDefend.getMilitaryUnit().getOwner().getTerritory();
            usersNewTiles2.remove(selectedTileForDefend);
            selectedTileForDefend.getOwner().setTerritory(usersNewTiles2);
//            militaryUnit.getTile().getCity().setOwnerShipTiles(usersNewTiles1);
//            selectedTileForDefend.getCity().setOwnerShipTiles(usersNewTiles2);
            return "you got a victory in this attack";
        } else if (militaryUnit.getHP() == selectedTileForDefend.getMilitaryUnit().getHP()) {
            militaryUnit.getTile().setMilitaryUnit(null);
            selectedTileForDefend.setMilitaryUnit(null);
            return "you missed your military unit but the unit of adversary is also killed";
        } else if (militaryUnit.getHP() < selectedTileForDefend.getMilitaryUnit().getHP()) {
            selectedTileForDefend.getMilitaryUnit().setHP(selectedTileForDefend.getMilitaryUnit().getHP() - militaryUnit.getHP());
            militaryUnit.getTile().setMilitaryUnit(null);
            return "you missed this attack and your military unit";
        }
        return "";
    }

    public void captureCity(City city, Unit unit, String command) {
        if (command.equals("destroy")) destroyCity(city);
        else annexCity(city, unit);
    }

    public void destroyCity(City city) {
        User previous = city.getOwner();
        previous.removeCity(city);
        for (Tile ownerShipTile : city.getOwnerShipTiles()) {
            ownerShipTile.setOwner(null);
            ownerShipTile.setCity(null);
            previous.removeTerritory(ownerShipTile);
        }
        city = null;
    }

    public void annexCity(City city, Unit unit) {
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
}
