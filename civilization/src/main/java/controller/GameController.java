package controller;

import model.*;

import java.util.ArrayList;

public class GameController {
    private ArrayList<User> players;
    private Maps map;
    private int turnForEachPlayer;
    private int height;
    private int width;
    public GameController(ArrayList<User> players, int turnForEachPlayer, Maps map, int height, int width) {
        this.players = players;
        this.map = map;
        for (User player : players) {
            player.setTurns(turnForEachPlayer);
            player.setGold(0);
        }
        this.turnForEachPlayer = turnForEachPlayer;
        this.height = height;
        this.width = width;
    }
    // cheat code for increasing the turn of user
    public void increaseTurn(int extraTurn, User specificPlayer) {
        specificPlayer.setTurns(specificPlayer.getTurns() + extraTurn);
    }
    // cheat code for increasing the gold of user
    public void increaseGold(int extraGold, User specificPlayer) {
        specificPlayer.setGold(specificPlayer.getGold() + extraGold);
    }
    // find the tile by given x and y coordinates
    public Tile findTile(int x, int y) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map.getTileBoard()[i][j].getX() == x && map.getTileBoard()[i][j].getY() == y)
                    return map.getTileBoard()[i][j];
            }
        }
        return null;
    }
    public void moveUnit(Tile origin, Tile destination, Unit unit, boolean isMilitary) {
        if (isMilitary)
            moveMilitary(origin, destination, (MilitaryUnit) unit);
        else
            moveCivilian(origin, destination, (Civilian) unit);
    }

    private void moveMilitary(Tile origin, Tile destination, MilitaryUnit militaryUnit) {
        militaryUnit.setTile(destination);
        origin.setMilitaryUnit(null);
        origin.setMilitaryUnitExists(false);
        destination.setMilitaryUnit(militaryUnit);
        destination.setMilitaryUnitExists(true);
    }
    private void moveCivilian(Tile origin, Tile destination, Civilian civilian) {
        civilian.setTile(destination);
        origin.setCivilianUnit(null);
        origin.setCivilianUnitExists(false);
        destination.setCivilianUnit(civilian);
        destination.setCivilianUnitExists(true);
    }

    public int getTurnForEachPlayer() {
        return turnForEachPlayer;
    }

    public void setTurnForEachPlayer(int turnForEachPlayer) {
        this.turnForEachPlayer = turnForEachPlayer;
    }

    public void periodicIncreases(City city,Worker worker){
        city.setCitizens(city.getCitizens()+4);
        Citizen citizen = new Citizen(city.getExpertCitizens().get(1).getName(),city.getCityLocation(),city.getExpertCitizens().get(1).getHP(),
                city.getExpertCitizens().get(1).getPrice(),city.getExpertCitizens().get(1).getLevel(),city.getExpertCitizens().get(1).getMP(),
                city.getExpertCitizens().get(1).getCombatStrength(),city.getExpertCitizens().get(1).getRangeCombatStrength(),city.getExpertCitizens().get(1).getOwner());
        for (int i = 0; i < 4; i++) {
            city.addExpertCitizen(citizen);
        }
        if (worker.isWorking()) {
            if (worker.getTile().getLand().getName().equals("Grassland")) {
                city.setFood(city.getFood() + worker.getTile().getLand().getFoodRate());
            } else if (worker.getTile().getLand().getName().equals("Hill")) {
                city.setProduction(city.getProduction() + worker.getTile().getLand().getProductionRate());
            } else if (worker.getTile().getLand().getName().equals("Plain")) {
                city.setFood(city.getFood() + worker.getTile().getLand().getFoodRate());
                city.setProduction(city.getProduction() + worker.getTile().getLand().getProductionRate());
            } else if (worker.getTile().getLand().getName().equals("Tundra")) {
                city.setFood(city.getFood() + worker.getTile().getLand().getFoodRate());
            }
        }
    }
}
