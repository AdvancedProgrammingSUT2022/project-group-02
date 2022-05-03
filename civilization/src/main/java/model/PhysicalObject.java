package model;

public class PhysicalObject {

    boolean isCity;
    private int attackPoint;
    private int HP;
    private User owner;
    private Tile tile;

    public PhysicalObject(boolean isCity, int attackPoint, int HP, User user, Tile tile) {
        this.owner = user;
        this.isCity = isCity;
        this.attackPoint = attackPoint;
        this.HP = HP;
        this.tile = tile;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    public boolean isCity() {
        return isCity;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
