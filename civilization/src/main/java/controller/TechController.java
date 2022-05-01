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
    public ArrayList<Improvement> possibleImprovements(Tile tile, User user) {
        ArrayList<Improvement> improvements = new ArrayList<>();
        ArrayList<Technology> technologies = user.getTechnologies();
        if (tile.getLand().isPassable() && tile.getOwner().equals(user)) {
            for (Technology technology : technologies) {
                if (technology.getIndex() == 0) {
                    improvements.addAll(technology.getGivenImprovement());
                }
            }
            return improvements;
        }
        else
            return null;
    }
}
