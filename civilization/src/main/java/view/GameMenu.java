package view;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.MapController;
import controller.Users;
import model.Improvement;
import model.Technology;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameMenu {
    // provide some information for user
    private void manGameMenu(User user) {
        System.out.println("welcome to Game Menu dear " + user.getUsername() + "!");
        System.out.println("press \"menu exit\" to get back to Main Menu");
        System.out.println("to Play Game :");
        System.out.println("play game --player1 <username> ... --player(k) <username>");
        System.out.println("play game -p1 <username> ... -p(k) <username>");
        System.out.println("the order of players is not important");
    }
    public void run(Users users, User user, Scanner scanner) {
        String input;
        Matcher matcher;
        manGameMenu(user);
        while (true) {
            input = scanner.nextLine();
            if (Pattern.matches("\\s*menu\\s+exit\\s*", input))
                return;

            else if (Pattern.matches("\\s*menu\\s+show-current\\s*", input))
                System.out.println("Play Game");

            else if (input.startsWith("play game")) {
                String[] usernames = findUsernames(input, users);

                if (checkIfUsernamesAreValid(usernames, users) && ifAllUsernamesAreUnique(usernames)) {
                    startGame(usernames, users, scanner);
                }
            }

            else
                System.out.println("invalid command");
        }
    }
    // start game
    private void startGame(String[] usernames, Users users, Scanner scanner) {
        System.out.println("successfully started game");
        ArrayList<String> colors = new ArrayList<>();
        colors.add("yellow");
        colors.add("purple");
        colors.add("red");
        colors.add("cyan");
        colors.add("green");
        ArrayList<User> players = new ArrayList<>();
        int userNumber = 0;
        for (String username : usernames) {
            players.add(users.getUserByUsername(username));
            players.get(userNumber).setColor(colors.get(userNumber));
            userNumber++;
        }
        // temporary
        int height = 8;
        int width = 4;
        int[][] ancientGraph = users.readFromJsonGraph();
        ArrayList<Technology> ancientTechnologies = users.readFromJsonTech();
        new PlayGame(players, height, width, ancientGraph, ancientTechnologies).run(scanner);
    }
    // get the usernames from input
    private String[] findUsernames(String input, Users users) {
        String[] all = input.split("--");
        int size = all.length - 1;
        String[] usernames = new String[size];
        if (size >= 2) {
            // handle double dash ,,, order doesn't matter
            String[] splitPlayerAndUsername;
            int indexOfPlayer;
            String subStringForNumber;
            for (int i = 1; i <= size; i++) {
                splitPlayerAndUsername = all[i].split("\\s+");
                if (splitPlayerAndUsername[0].startsWith("player")) {
                    subStringForNumber = splitPlayerAndUsername[0].substring(6);
                    if (Pattern.matches("[0-9]+", subStringForNumber)) {
                        indexOfPlayer = Integer.parseInt(subStringForNumber);
                        usernames[indexOfPlayer - 1] = splitPlayerAndUsername[1].trim();
                    }
                    else
                        System.out.println("invalid command");
                }
                else
                    System.out.println("invalid command");
            }
        }

        else {
            // handle one dash input ,,, order doesn't matter
            all = input.split("-");
            size = all.length - 1;
            usernames = new String[size];
            if (size >= 2) {
                String[] splitPlayerAndUsername;
                int indexOfPlayer;
                String subStringForNumber;
                for (int i = 1; i <= size; i++) {
                    splitPlayerAndUsername = all[i].split("\\s+");
                    if (splitPlayerAndUsername[0].startsWith("p")) {
                        subStringForNumber = splitPlayerAndUsername[0].substring(1);
                        if (Pattern.matches("[0-9]+", subStringForNumber)) {
                            indexOfPlayer = Integer.parseInt(subStringForNumber);
                            usernames[indexOfPlayer - 1] = splitPlayerAndUsername[1].trim();
                        }
                    }
                }
            }
            else
                System.out.println("invalid command");
        }
        return usernames;
    }
    //all usernames should be valid
    private boolean checkIfUsernamesAreValid(String[] usernames, Users users) {
        for (String username : usernames) {
            if (!users.sameUsernameExists(username)) {
                System.out.println("some usernames are not valid");
                return false;
            }
        }
        return true;
    }
    // all usernames should be unique
    private boolean ifAllUsernamesAreUnique(String[] usernames) {
        for (int i = 0; i < usernames.length - 1; i++) {
            for (int j = i + 1; j < usernames.length; j++) {
                if (usernames[i].equals(usernames[j])) {
                    System.out.println("a username has been entered more than one time");
                    return false;
                }
            }
        }
        return true;
    }
}
