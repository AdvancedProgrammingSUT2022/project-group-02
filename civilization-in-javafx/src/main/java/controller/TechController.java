package controller;

import model.Technology;
import model.User;
import view.ResearchMenu;

import java.util.ArrayList;

public class TechController {
    private final ArrayList<Technology> technologies;
    private final int[][] technologiesGraph;

    private static TechController techController;

    private TechController(int[][] technologiesGraph, ArrayList<Technology> technologies) {
        this.technologiesGraph = technologiesGraph;
        this.technologies = technologies;

    }

    public static TechController getInstance(int[][] technologiesGraph, ArrayList<Technology> technologies) {
        if (techController == null)
            techController = new TechController(technologiesGraph, technologies);
        return techController;
    }

    public ArrayList<Technology> getTechnologies() {
        return technologies;
    }

//    public int[][] getAncientEraTechnologiesGraph() {
//        return ancientEraTechnologiesGraph;
//    }

    public ArrayList<Technology> getPrerequisitesTech(Technology technology) {
        int index = technology.getIndex();
        ArrayList<Technology> prerequisites = new ArrayList<>();
        for (int i = 0; i < technologies.size(); i++) {
            if (technologiesGraph[i][index] == 1) {
                prerequisites.add(technologies.get(i));
            }
        }
        return prerequisites;
    }

    public ArrayList<Technology> getUserResearches(User user) {
        ArrayList<Technology> userTechnologies = user.getTechnologies();
        ArrayList<Technology> prerequisites;
        boolean treeTech = true;
        for (Technology ancientTechnology : technologies) {
            // first check user do not have this
            if (!userTechnologies.contains(ancientTechnology)) {
                prerequisites = getPrerequisitesTech(ancientTechnology);
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
