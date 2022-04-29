package controller;

import model.Technology;

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
}
