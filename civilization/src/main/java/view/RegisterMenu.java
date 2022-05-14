package view;
import controller.ColorsController;
import controller.UsersController;
import controller.enums.Colors;
import controller.enums.RegexEnums;
import model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.*;

public class RegisterMenu {
    private final HashMap<String , Boolean> availableColors = new HashMap<>();
    public RegisterMenu(){
        availableColors.put("white" , true);
        availableColors.put("red" , true);
        availableColors.put("green" , true);
        availableColors.put("yellow" , true);
        availableColors.put("blue" , true);
        availableColors.put("purple" , true);
        availableColors.put("cyan" , true);
    }
    // provide some information for user
    private void manRegisterMenu() {
        String boldColor = Colors.YELLOW_BOLD;
        String Color = Colors.CYAN;
        System.out.println(boldColor + "to create new user :" + Colors.RESET);
        System.out.println(Color + "the order of username and nickname and password is not important");
        System.out.println("user create --username <username> --nickname <nickname> --password <password>");
        System.out.println("user create -u <username> -n <nickname> -p <password>" + Colors.RESET);
        System.out.println("**********************");
        System.out.println(boldColor + "to login :" + Colors.RESET);
        System.out.println(Color + "the order of username and password is not important");
        System.out.println("user login --username <username> --password <password>");
        System.out.println("user login -u <username> -p <password>" + Colors.RESET);
        System.out.println("**********************");
        System.out.println(Color + "press \"menu show-current\" to see the menu you are in");
        System.out.println("press \"menu exit\" to exit the menu" + Colors.RESET);
    }
    public void run(Scanner scanner, UsersController users) {
        String input;
        Matcher matcher;
        manRegisterMenu();
        ArrayList<User> usersFromJson = users.readFromJson();
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
                    if (!users.sameNicknameExists(nickname)) {
                        User user = new User(username, nickname, password);
                        System.out.println("select your Avatar Color");
                        printRemainColors();
                        String color = scanner.nextLine();
                        while (!isSelectedColorValid(color)){
                            color = scanner.nextLine();
                        }
                        users.setUserColor(color , user, availableColors);
                        users.addUser(user);
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

    private void printRemainColors(){
        AtomicInteger number = new AtomicInteger(1);
        availableColors.forEach((key , value) -> {
            if (value){
                String color = new ColorsController().getColorOfString(key);
                System.out.println(number + "- " + color + key + Colors.RESET);
                number.getAndIncrement();
            }
        });
    }

    private Boolean isSelectedColorValid(String color){
        if (!availableColors.containsKey(color)){
            System.out.println("The selected color is not an available color");
            return false;
        } else if (!availableColors.get(color)){
            System.out.println("The selected color is taken by another user");
            return false;
        } else return true;
    }
}
