package controller;

import model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class UserLoginTest {

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

    @Test //step 1: username check
    public void checkSameUserName(){
        String username = "AmirHossein";
        Assertions.assertTrue(usersController.sameUsernameExists(username));
    }

    @Test //step 2: nickname check
    public void checkSameNickName(){
        String nickName = "AmirHossein";
        Assertions.assertTrue(usersController.sameNicknameExists(nickName));
    }

    @Test //step 3: set a color for user
    public void checkSetColor(){
        HashMap<String , Boolean> availableColor = new HashMap<>();
        availableColor.put("Blur", true);
        boolean result1 = user1.getColor() == null;
        usersController.setUserColor("Blue", user1, availableColor);
        boolean result2 = user1.getColor().equals("Blue");
        Assertions.assertTrue(result1 && result2);
    }

    @Test //step 4: for login we get username and find user and check the password
    public void checkGetUserByUsername(){
        String username = "AmirHossein";
        Assertions.assertEquals(usersController.getUserByUsername(username), user1);
    }

}
