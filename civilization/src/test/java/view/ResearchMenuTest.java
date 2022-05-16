package view;

import controller.GameController;
import controller.TechController;

import controller.UsersController;
import model.Technology;
import model.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import java.util.ArrayList;
import java.util.Scanner;



public class ResearchMenuTest {
    UsersController usersController = new UsersController();
    int[][] ancientGraph = usersController.readFromJsonGraph();
    ArrayList<Technology> ancientTechnologies = usersController.readFromJsonTech();
    TechController techController = new TechController(ancientGraph, ancientTechnologies);
    ResearchMenu researchMenu = new ResearchMenu(techController, null);
    User user1 = new User("AmirHossein", "AmirHossein", "AmirHossein12");

    @Test
    public void checkSelectTech(){
        Scanner scanner = new Scanner("1\nbar exit");
        researchMenu.selectTech(user1, scanner);
        Assertions.assertTrue(user1.isResearching());
        Assertions.assertEquals("Agriculture", user1.getCurrentTechnology().getName());
        Assertions.assertEquals(20, user1.getCurrentTechnology().getSciencePrice());
    }
}
