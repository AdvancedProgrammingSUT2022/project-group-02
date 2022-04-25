package model;

import java.util.ArrayList;

public class User {
    private final String username;
    private String nickname;
    private String password;
    private String color;
    private int turns;
    private int gold;
    private ArrayList<Tile> territory;
    private int goldPerTurn;
    private int happiness;
    private int sciencePerTurn;
    private int food;
    private int foodPerTurn;
    private int culture;
    private int culturePerTurn;
    private int faith;
    private int faithPerTurn;
    private ArrayList<Resource> resources;
    private String civilization;
    private ArrayList<Unit> Units;
    private ArrayList<City> cities;
    private City capital;
    private ArrayList<Technology> technologies;
    private ArrayList<Improvement> improvements;
    private int turnNumber;

    private ArrayList<Tile> visited;
    private ArrayList<Tile> visible;

    public User(String username, String nickname, String password) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        gold = 0;
        turns = 1;
        visited = new ArrayList<>();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Tile> getTerritory() {
        return territory;
    }

    public void setTerritory(ArrayList<Tile> territory) {
        this.territory = territory;
    }

    public int getGoldPerTurn() {
        return goldPerTurn;
    }

    public void setGoldPerTurn(int goldPerTurn) {
        this.goldPerTurn = goldPerTurn;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getSciencePerTurn() {
        return sciencePerTurn;
    }

    public void setSciencePerTurn(int sciencePerTurn) {
        this.sciencePerTurn = sciencePerTurn;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFoodPerTurn() {
        return foodPerTurn;
    }

    public void setFoodPerTurn(int foodPerTurn) {
        this.foodPerTurn = foodPerTurn;
    }

    public int getCulture() {
        return culture;
    }

    public void setCulture(int culture) {
        this.culture = culture;
    }

    public int getCulturePerTurn() {
        return culturePerTurn;
    }

    public void setCulturePerTurn(int culturePerTurn) {
        this.culturePerTurn = culturePerTurn;
    }

    public int getFaith() {
        return faith;
    }

    public void setFaith(int faith) {
        this.faith = faith;
    }

    public int getFaithPerTurn() {
        return faithPerTurn;
    }

    public void setFaithPerTurn(int faithPerTurn) {
        this.faithPerTurn = faithPerTurn;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    public String getCivilization() {
        return civilization;
    }

    public void setCivilization(String civilization) {
        this.civilization = civilization;
    }

    public ArrayList<Unit> getUnits() {
        return Units;
    }

    public void setUnits(ArrayList<Unit> units) {
        Units = units;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public ArrayList<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(ArrayList<Technology> technologies) {
        this.technologies = technologies;
    }

    public ArrayList<Improvement> getImprovements() {
        return improvements;
    }

    public void setImprovements(ArrayList<Improvement> improvements) {
        this.improvements = improvements;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public ArrayList<Tile> getVisited() {
        return visited;
    }

    public void setVisited(ArrayList<Tile> visited) {
        this.visited = visited;
    }

    public ArrayList<Tile> getVisible() {
        return visible;
    }

    public void setVisible(ArrayList<Tile> visible) {
        this.visible = visible;
    }
    public void addVisited(Tile visit) {
        visited.add(visit);
    }

    public void addVisible(Tile visible) {
        this.visible.add(visible);
    }
    public void addTerritory(Tile tile) {
        territory.add(tile);
    }
    public void removeTerritory(Tile tile) {
        int index = 0;
        for (Tile tile1 : territory) {
           if (tile1.equals(tile)) {
               territory.remove(index);
               return;
           }
           index++;
        }
    }
}
