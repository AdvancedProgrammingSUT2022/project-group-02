package model;

import handlers.Handlers;
import handlers.WorkerWorkingHandler;

public class MilitaryUnit extends Unit{
    private String status;
    private PhysicalObject attackingTarget;
    private Resource requiredResource;
    private Technology requiredTechnology;
    Handlers IsTargetUnitExist = new WorkerWorkingHandler();

    public MilitaryUnit(String name, Tile tile, int HP, int price, int level, int MP, int combatStrength, int rangeCombatStrength, User user, int attackPoint) {
        super(name, tile, HP, price, level, MP, combatStrength, rangeCombatStrength, user, attackPoint);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
