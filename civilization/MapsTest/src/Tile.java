public class Tile {

    private int X;
    private int Y;
    private PhysicalObject objectOnTile;
    private User owner;
    private Land land;
    private int fogOfWarLevel;
    private Unit militaryUnitOnTile;
    private Unit civilianUnitOnTile;
    private String userLandColor;
    private Improvement improvement;
    private boolean inProgress;

    public Tile(int x, int y ,User owner, Land land, int fogOfWarLevel) {
        X = x;
        Y = y;
        this.owner = owner;
        this.land = land;
        this.fogOfWarLevel = fogOfWarLevel;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public PhysicalObject getObjectOnTile() {
        return objectOnTile;
    }

    public void setObjectOnTile(PhysicalObject objectOnTile) {
        this.objectOnTile = objectOnTile;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User user){
        owner = user;
    }

    public Land getLand() {
        return land;
    }

    public int getFogOfWarLevel() {
        return fogOfWarLevel;
    }

    public void setFogOfWarLevel(int fogOfWarLevel) {
        this.fogOfWarLevel = fogOfWarLevel;
    }

    public Unit getMilitaryUnit() {
        return militaryUnitOnTile;
    }

    public void setMilitaryUnit(Unit militaryUnit) {
        this.militaryUnitOnTile = militaryUnit;
    }

    public Unit getCivilianUnit() {
        return civilianUnitOnTile;
    }

    public void setCivilianUnit(Unit civilianUnit) {
        this.civilianUnitOnTile = civilianUnit;
    }

    public String getUserLandColor() {
        return userLandColor;
    }

    public void setUserLandColor(String color) {this.userLandColor = color;}

    public Improvement getImprovement() {
        return improvement;
    }

    public void setImprovement(Improvement improvement) {
        this.improvement = improvement;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }
}
