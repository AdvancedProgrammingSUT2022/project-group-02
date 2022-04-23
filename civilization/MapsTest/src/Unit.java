public class Unit {

    private String name;
    private Tile tile;
    private int HP;
    private int price;
    private int level;
    private int MP;
    private boolean intact;
    private int XP;
    private int combatStrength;
    private int rangeCombatStrength;

    public Unit(String name, Tile tile, int HP, int price, int level, int MP, int combatStrength, int rangeCombatStrength) {
        this.name = name;
        this.tile = tile;
        this.HP = HP;
        this.price = price;
        this.level = level;
        this.MP = MP;
        this.combatStrength = combatStrength;
        this.rangeCombatStrength = rangeCombatStrength;
        intact = true;
        XP = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
}
