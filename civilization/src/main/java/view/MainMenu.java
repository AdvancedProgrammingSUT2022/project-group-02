package view;

import controller.UsersController;
import controller.enums.Colors;
import controller.enums.RegexEnums;
import model.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu {

    MainMenu(){
    }
    //provide some information for user
    private void manMainMenu() {
        String color = Colors.CYAN;
        System.out.println(color + "press \"menu enter <menu name>\" to access to Play Game and Profile Menu");
        System.out.println("press \"menu exit or user logout\" to get back to Register Menu" + Colors.RESET);
    }
    public void run(UsersController users, User user, Scanner scanner) {
        String input;
        Matcher matcher;
        manMainMenu();
        while (true) {
            input = scanner.nextLine();
            //exit the menu
            if (Pattern.matches("\\s*menu\\s+exit\\s*", input))
                return;
                //logging out
            else if (Pattern.matches("\\s*user\\s+logout\\s*", input)) {
                System.out.println("user logged out successfully!");
                return;
            }
            //show current menu
            else if (Pattern.matches("\\s*menu\\s+show-current\\s*", input))
                System.out.println("Main Menu");
                //change the menu to Profile or Play game
            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_MENU)) != null) {
                String menu = matcher.group("menu");
                if (menu.equals("Play Game")) {
                    new GameMenu().run(users, user, scanner);
                }
                else if (menu.equals("Profile")) {
                    new ProfileMenu().run(users, user, scanner);
                }
                else
                    System.out.println("invalid command");
            }
            else
                System.out.println("invalid command");
        }
    }
}
