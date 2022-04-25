package model;

public class MilitaryUnit extends Unit{
    private String status;
    private Unit attackedUnit;
    private City attackedCity;
    private Resource requiredResource;
    private Technology requiredTechnology;

    public MilitaryUnit(String name, Tile tile, int HP, int price, int level, int MP, int combatStrength, int rangeCombatStrength, User user) {
        super(name, tile, HP, price, level, MP, combatStrength, rangeCombatStrength, user);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Unit getAttackedUnit() {
        return attackedUnit;
    }

    public void setAttackedUnit(Unit attackedUnit) {
        this.attackedUnit = attackedUnit;
    }

    public City getAttackedCity() {
        return attackedCity;
    }

    public void setAttackedCity(City attackedCity) {
        this.attackedCity = attackedCity;
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
}
