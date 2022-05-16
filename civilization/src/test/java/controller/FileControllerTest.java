package controller;

import model.Technology;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class FileControllerTest {
    User user1 = new User("AmirHossein", "AmirHossein", "AmirHossein12");
    User user2 = new User("Mohammad", "Mohammad", "Mohammad12");
    User user3 = new User("Shayan", "Shayan", "Shayan12");
    UsersController usersController = new UsersController();



    @Before
    public void setUp(){
        usersController.addUser(user1);
        usersController.addUser(user2);
        usersController.addUser(user3);
    }

    @Test //write a file of users
    public void checkWriteToJson(){
        usersController.writeToJson();
    }

    @Test //read a file of users
    public void checkReadFromJson(){
        boolean result;
        usersController.writeToJson();
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        ArrayList<User> users1 = new ArrayList<>(usersController.readFromJson());
        for (User user : users) {
            result = false;
            for (User user4 : users1) {
                if (user4.getNickname().equals(user.getNickname()))result = true;
            }
            Assertions.assertTrue(result);
        }
    }

    @Test //read a file of graph
    public void checkReadFromGraphJson(){
        int[][] ancientGraph = usersController.readFromJsonGraph();
        Assertions.assertNotEquals(usersController.readFromJsonGraph(), ancientGraph);
    }

    @Test //read a file of tech
    public void checkReadFromTechJson(){
        ArrayList<Technology> ancientTechnologies = usersController.readFromJsonTech();
        Assertions.assertNotEquals(usersController.readFromJsonTech(), ancientTechnologies);
    }
}
