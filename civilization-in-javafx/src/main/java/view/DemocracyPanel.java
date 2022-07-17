package view;

import controller.UsersController;
import model.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemocracyPanel {

    private Matcher matcher;

    public void run(Scanner scanner, User user) {
        String input;
        UserPanel.everyInformationAboutUser(user);
        System.out.println("**********");
        System.out.println("all of the users are as follows :");
        for (User user1 : UsersController.getInstance().getUsers()) {
            UserPanel.everyInformationAboutUser(user1);
            System.out.println("**********");
        }

        while (true) {
            input = scanner.nextLine();
            if (input.equals("back")) {
                System.out.println("get back to play game panel");
                return;
            }
            else if ((matcher = getMatcher(input, "declare war against -u (?<username>[\\s\\S]+)")) != null) {
                String username = matcher.group("username");
                User other = UsersController.getInstance().getUserByUsername(username);
                declareWar(user, other);
            }
            else if ((matcher = getMatcher(input, "make peace with -u (?<username>[\\s\\S]+)")) != null) {
                String username = matcher.group("username");
                User other = UsersController.getInstance().getUserByUsername(username);
                makePeace(user, other);
            }
            else if ((matcher = getMatcher(input, "trade with -u (?<username>[\\s\\S]+)")) != null) {
                String username = matcher.group("username");
                User other = UsersController.getInstance().getUserByUsername(username);
                trade(user, other);
            }
            else
                System.out.println("invalid command!");

        }
    }

    private Matcher getMatcher(String input, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.matches())
            return matcher;
        return null;
    }

    private void declareWar(User you, User other) {
        if (you.getEnemies().contains(other))
            System.out.println("you are already enemies");
        else
            you.addEnemy(other);
    }
    private void makePeace(User you, User other) {
        if (you.getEnemies().contains(other))
            System.out.println("this user is not one of your enemies");
        else
            you.getEnemies().remove(other);
    }
    private void trade(User you, User other) {

    }
}
