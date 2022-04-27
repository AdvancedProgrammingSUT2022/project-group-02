package view;
import controller.Users;
import enums.RegexEnums;
import model.User;

import java.util.*;
import java.util.regex.*;

public class RegisterMenu {
    public void run(Scanner scanner, Users users) {
        String input;
        Matcher matcher;
        ArrayList<User> usersFromJson = users.readFromJson();
        System.out.println("to create new user :");
        System.out.println("the order of username and nickname and password is not important");
        System.out.println("user create --username <username> --nickname <nickname> --password <password>");
        System.out.println("user create -u <username> -n <nickname> -p <password>");
        System.out.println("**********************");
        System.out.println("to login :");
        System.out.println("the order of username and password is not important");
        System.out.println("user login --username <username> --password <password>");
        System.out.println("user login -u <username> -p <password>");
        System.out.println("**********************");
        System.out.println("press \"menu show-current\" to see the menu you are in");
        System.out.println("press \"menu exit\" to exit the menu");
        if (usersFromJson != null)
            users.setUsers(usersFromJson);
        while (true) {
            input = scanner.nextLine();
            //exit the game
            if (Pattern.matches("\\s*menu\\s+exit\\s*", input)) {
                users.writeToJson();
                return;
            }
                //show current menu
            else if (Pattern.matches("\\s*menu\\s+show-current\\s*", input))
                System.out.println("Login Menu");
                //register user
            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER1)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER2)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER3)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER4)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER5)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER6)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER7)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER8)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER9)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER10)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER11)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER12)) != null) {
                String username = matcher.group("username");
                String nickname = matcher.group("nickname");
                String password = matcher.group("password");
                //check if there is a same username
                if (!users.sameUsernameExists(username)) {
                    //check if there is a same nickname
                    if (users.sameNicknameExists(nickname)) {
                        users.addUser(new User(username, nickname, password));
                        System.out.println("user created successfully!");
                    }
                    else
                        System.out.println("user with this nickname " + nickname + " already exists");
                }
                else
                    System.out.println("user with this username " + username + " already exists");
            }
            //login handling
            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.LOGIN1)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.LOGIN2)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.LOGIN3)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.LOGIN4)) != null) {
                String username = matcher.group("username");
                String password = matcher.group("password");
                User user;
                //check if username exists and the password is correct
                if (users.sameUsernameExists(username) && (user = users.getUserByUsername(username)).getPassword().equals(password)) {
                    System.out.println("user logged in successfully!");
                    new MainMenu().run(users, user, scanner);
                }
                else
                    System.out.println("Username and password didn't match!");
            }
            //if the user tried to change the menu
            else if (RegexEnums.getMatcher(input, RegexEnums.CHANGE_MENU) != null)
                System.out.println("please login first");
            else
                System.out.println("invalid command");
        }
    }
}
