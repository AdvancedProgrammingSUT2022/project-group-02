package model;

public class Unit extends PhysicalObject{

    private String name;
    private String status;
    private int goldPrice;
    private int productionPrice;
    private int level;
    private int MP;
    private boolean intact;
    private int XP;
    private int combatStrength;
    private int rangeCombatStrength;
    private int maintainGold;

    public Unit(String name, Tile tile, int HP, int goldPrice, int productionPrice, int level, int MP, int combatStrength, int rangeCombatStrength,
                User owner, int attackPoint, int maintainGold) {
        super(false, attackPoint, HP, owner, tile);
        this.name = name;
        this.goldPrice = goldPrice;
        this.productionPrice = productionPrice;
        this.level = level;
        this.MP = MP;
        this.combatStrength = combatStrength;
        this.rangeCombatStrength = rangeCombatStrength;
        intact = true;
        XP = 0;
        this.maintainGold = maintainGold;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoldPrice() {
        return goldPrice;
    }

    public int getProductionPrice() {
        return productionPrice;
    }

    public void setGoldPrice(int goldPrice) {
        this.goldPrice = goldPrice;
    }

    public void setProductionPrice(int productionPrice) {
        this.productionPrice = productionPrice;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public boolean isIntact() {
        return intact;
    }

    public void setIntact(boolean intact) {
        this.intact = intact;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public int getCombatStrength() {
        return combatStrength;
    }

    public void setCombatStrength(int combatStrength) {
        this.combatStrength = combatStrength;
    }

    public int getRangeCombatStrength() {
        return rangeCombatStrength;
    }

    public void setRangeCombatStrength(int rangeCombatStrength) {
        this.rangeCombatStrength = rangeCombatStrength;
    }

    public void setMaintainGold(int maintainGold) {
        this.maintainGold = maintainGold;
    }

    public int getMaintainGold() {
        return maintainGold;
    }
}
