package controller;

import model.Improvement;
import model.Technology;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class TechControllerTest {
    UsersController usersController = new UsersController();
    int[][] ancientGraph = usersController.readFromJsonGraph();
    ArrayList<Technology> ancientTechnologies = usersController.readFromJsonTech();
    TechController techController = new TechController(ancientGraph, ancientTechnologies);
    ArrayList<Improvement> improvements = new ArrayList<>();
    Technology technology;

    @Before
    public void setUp(){
        improvements.add(new Improvement("Farm", 0, 1, 0, 5, null, null));
        technology = new Technology("Agriculture", improvements, 0, 20, null);
    }

    @Test
    public void checkGetAncientTechnologies(){
        Assertions.assertEquals(ancientTechnologies, techController.getAncientTechnologies());
    }

    @Test
    public void checkGetPrerequisitesAncientTech(){
        Assertions.assertTrue(techController.getPrerequisitesAncientTech(technology).isEmpty());
    }

    @Test
    public void checkGetUserResearches(){
        User user1 = new User("AmirHossein", "AmirHossein", "AmirHossein12");
        user1.addTechnology(technology);
        Assertions.assertFalse(techController.getUserResearches(user1).isEmpty());
    }
}
