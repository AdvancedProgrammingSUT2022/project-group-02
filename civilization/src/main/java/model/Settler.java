package model;

import controller.SettlerController;

import java.util.ArrayList;

public class Settler extends Civilian{

    private ArrayList<Tile> possibleTilesForCities;
    public Settler(String name, Tile tile, int HP, int price, int level, int MP, int combatStrength, int rangeCombatStrength, ArrayList<Tile> possibleTilesForCities, User user) {
        super(name, tile, HP, price, level, MP, combatStrength, rangeCombatStrength, user);
        this.possibleTilesForCities = possibleTilesForCities;

    }

    public ArrayList<Tile> getPossibleTilesForCities() {
        return possibleTilesForCities;
    }

    public void setPossibleTilesForCities(ArrayList<Tile> possibleTilesForCities) {
        this.possibleTilesForCities = possibleTilesForCities;
    }
}
