package controller;
import model.*;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class UnitController {

    private ArrayList<Unit> units;
    public UnitController() {
        units = new ArrayList<>();
    }
    public boolean moving (Unit unit, User user, int x, int y, Maps map) {

        return false;
    }
    public void createUnit (Unit unit, User user) {
        units.add(unit);
    }
    public void repair (Unit unit, User user) {
        int specificAmount = 1;
        unit.setHP(unit.getHP());
    }
    public void loot (Unit unit, User user) {

    }
    public void removeUnit (Unit unit, User user) {
        units.remove(unit);
    }

//    public void increaseCitizens(City city){
//        city.setCitizens(city.getCitizens()+4);
//        Citizen citizen = new Citizen(city.getExpertCitizens().get(1).getName(),city.getCityLocation(),city.getExpertCitizens().get(1).getHP(),
//                city.getExpertCitizens().get(1).getPrice(),city.getExpertCitizens().get(1).getLevel(),city.getExpertCitizens().get(1).getMP(),
//                city.getExpertCitizens().get(1).getCombatStrength(),city.getExpertCitizens().get(1).getRangeCombatStrength(),city.getExpertCitizens().get(1).getOwner());
//        for (int i = 0; i < 4; i++) {
//            city.addExpertCitizen(citizen);
//        }
//    }
}
