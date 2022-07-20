package controller;

import model.Technology;
import model.User;
import view.ResearchMenu;

import java.util.ArrayList;

public class TechController {
    private ArrayList<Technology> technologies;
    private int[][] technologiesGraph;

    private static TechController techController;

    public static TechController getInstance() {
        if (techController == null)
            techController = new TechController();
        return techController;
    }

    public ArrayList<Technology> getTechnologies() {
        return technologies;
    }

//    public int[][] getAncientEraTechnologiesGraph() {
//        return technologiesGraph;
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

    public void setTechnologies(ArrayList<Technology> technologies) {
        this.technologies = technologies;
    }

    public void setTechnologiesGraph(int[][] technologiesGraph) {
        this.technologiesGraph = technologiesGraph;
    }
}
