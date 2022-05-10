package model;

public class MilitaryUnit extends Unit{

    private PhysicalObject attackingTarget;
    private Resource requiredResource;
    private Technology requiredTechnology;
    private City garrisonMood;

    public MilitaryUnit(String name, Tile tile, int HP, int goldPrice, int productionPrice, int level, int MP, int combatStrength, int rangeCombatStrength, User user, int attackPoint, int maintainGold) {
        super(name, tile, HP, goldPrice, productionPrice, level, MP, combatStrength, rangeCombatStrength, user, attackPoint, maintainGold);
    }


    public PhysicalObject getAttackingTarget() {
        return attackingTarget;
    }

    public void setAttackingTarget(PhysicalObject attackingTarget) {
        this.attackingTarget = attackingTarget;
    }

    public Resource getRequiredResource() {
        return requiredResource;
    }

    public void setRequiredResource(Resource requiredResource) {
        this.requiredResource = requiredResource;
    }

    public Technology getRequiredTechnology() {
        return requiredTechnology;
    }

    public void setRequiredTechnology(Technology requiredTechnology) {
        this.requiredTechnology = requiredTechnology;
    }

    public City getGarrisonMood() {
        return garrisonMood;
    }

    public void setGarrisonMood(City garrisonMood) {
        this.garrisonMood = garrisonMood;
    }
}
