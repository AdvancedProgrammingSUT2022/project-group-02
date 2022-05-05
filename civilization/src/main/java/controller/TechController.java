package controller;

import model.Improvement;
import model.Technology;
import model.Tile;
import model.User;

import java.util.ArrayList;

public class TechController {
    private final ArrayList<Technology> ancientTechnologies;
    private final int[][] ancientEraTechnologiesGraph;

    public TechController(int[][] ancientEraTechnologiesGraph, ArrayList<Technology> ancientTechnologies) {
        this.ancientEraTechnologiesGraph = ancientEraTechnologiesGraph;
        this.ancientTechnologies = ancientTechnologies;
    }

    public ArrayList<Technology> getAncientTechnologies() {
        return ancientTechnologies;
    }

    public int[][] getAncientEraTechnologiesGraph() {
        return ancientEraTechnologiesGraph;
    }

    public ArrayList<Technology> getPrerequisitesAncientTech(Technology technology) {
        int index = technology.getIndex();
        ArrayList<Technology> prerequisites = new ArrayList<>();
        for (int i = 0; i < ancientTechnologies.size(); i++) {
            if (getAncientEraTechnologiesGraph()[i][index] == 1) {
                prerequisites.add(ancientTechnologies.get(i));
            }
        }
        return prerequisites;
    }
    /*
    public ArrayList<Improvement> possibleImprovements(Tile tile, User user) {
        ArrayList<Improvement> improvements = new ArrayList<>();
        ArrayList<Technology> technologies = user.getTechnologies();
        // add every possible tile to list
        if (tile.getTerrain().isPassable() && tile.getOwner().equals(user)) {
            for (Technology technology : technologies)
                improvements.addAll(technology.getGivenImprovement());
            // remove the current improvement from suggested list
            if (tile.getImprovement() != null)
                improvements.remove(tile.getImprovement());
            return improvements;
        }
        // if the user wasn't the owner of the tile or the tile wasn't proper for improving
        else
            return null;
    }
    */

    public ArrayList<Technology> getUserResearches(User user) {
        ArrayList<Technology> technologies = new ArrayList<>();
        ArrayList<Technology> userTechnologies = user.getTechnologies();
        ArrayList<Technology> prerequisites;
        boolean treeTech = true;
        for (Technology ancientTechnology : ancientTechnologies) {
            // first check user do not have this
            if (!userTechnologies.contains(ancientTechnology)) {
                prerequisites = getPrerequisitesAncientTech(ancientTechnology);
                if (prerequisites != null) {
                    // check if all prerequisites are exists in user technologies
                    for (int i = 0; i < prerequisites.size(); i++) {
                        if (!userTechnologies.contains(prerequisites.get(i))) {
                            treeTech = false;
                            i = prerequisites.size();
                        }
                    }
                }
                if (treeTech)
                    technologies.add(ancientTechnology);
                treeTech = true;
            }
        }
        return technologies;
    }
}
