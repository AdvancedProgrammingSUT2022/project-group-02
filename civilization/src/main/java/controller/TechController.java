package controller;

import model.Technology;
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
            if (ancientEraTechnologiesGraph[i][index] == 1) {
                prerequisites.add(ancientTechnologies.get(i));
            }
        }
        return prerequisites;
    }

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
