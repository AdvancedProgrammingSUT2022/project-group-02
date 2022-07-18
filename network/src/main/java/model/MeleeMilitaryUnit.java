package model;

public class MeleeMilitaryUnit extends MilitaryUnit{

    public MeleeMilitaryUnit(String name, Tile tile, int HP, int goldPrice, int productionPrice, int level, int MP, int combatStrength, int rangeCombatStrength, User user, int attackPoint, int maintainGold) {
        super(name, tile, HP, goldPrice, productionPrice, level, MP, combatStrength, rangeCombatStrength, user, attackPoint, maintainGold);
    }

}
