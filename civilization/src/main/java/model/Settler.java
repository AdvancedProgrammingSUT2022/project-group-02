package model;

import controller.SettlerController;

import java.util.ArrayList;

public class Settler extends Civilian{

    private ArrayList<Tile> possibleTilesForCities;
    public Settler(String name, Tile tile, int HP, int goldPrice, int productionPrice, int level, int MP, int combatStrength, int rangeCombatStrength, ArrayList<Tile> possibleTilesForCities, User user, int attackPoint, int maintainGold) {
        super(name, tile, HP, goldPrice, productionPrice, level, MP, combatStrength, rangeCombatStrength, user, attackPoint, maintainGold);
        this.possibleTilesForCities = possibleTilesForCities;

    }

    public ArrayList<Tile> getPossibleTilesForCities() {
        return possibleTilesForCities;
    }

    public void setPossibleTilesForCities(ArrayList<Tile> possibleTilesForCities) {
        this.possibleTilesForCities = possibleTilesForCities;
    }
}
