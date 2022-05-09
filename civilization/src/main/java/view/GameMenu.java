package view;

import controller.ColorsController;
import controller.UsersController;
import enums.Colors;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameMenu {
    // provide some information for user
    private void manGameMenu(User user) {
        String userColor = new ColorsController().getColorOfUser(user);
        String boldColor = Colors.YELLOW_BOLD;
        String color = Colors.CYAN;
        System.out.println("welcome to Game Menu dear " + userColor + user.getUsername() + Colors.RESET + "!");
        System.out.println(color + "press \"menu exit\" to get back to Main Menu" + Colors.RESET);
        System.out.println(boldColor + "to Play Game :" + Colors.RESET);
        System.out.println(color + "play game --player1 <username> ... --player(k) <username>");
        System.out.println("play game -p1 <username> ... -p(k) <username>");
        System.out.println("the order of players is not important" + Colors.RESET);
    }
    public void run(UsersController users, User user, Scanner scanner) {
        String input;
        Matcher matcher;
        manGameMenu(user);
        while (true) {
            input = scanner.nextLine();
            if (Pattern.matches("\\s*menu\\s+exit\\s*", input))
                return;

            else if (Pattern.matches("\\s*menu\\s+show-current\\s*", input))
                System.out.println("Play Game");

            else if (input.startsWith("play game") && (input.contains("-p1") || input.contains("--player1"))) {
                String[] usernames = findUsernames(input, users);

                if (usernames != null && usernames.length >= 2 && checkIfUsernamesAreValid(usernames, users) && ifAllUsernamesAreUnique(usernames)) {
                    startGame(usernames, users, scanner);
                }
            }

            else
                System.out.println("invalid command");
        }
    }
    // start game
    private void startGame(String[] usernames, UsersController users, Scanner scanner) {
        System.out.println("successfully started game");
        ArrayList<User> players = new ArrayList<>();
        for (String username : usernames) {
            players.add(users.getUserByUsername(username));
        }

        int[][] ancientGraph = users.readFromJsonGraph();
        //ArrayList<Technology> technologies = ancientTechnologies();
        //users.writeToJson(technologies);
        ArrayList<Technology> ancientTechnologies = users.readFromJsonTech();
        Maps map = new MapMaker().myTiles();
        new PlayGame(players, map, ancientGraph, ancientTechnologies).run(scanner);
    }
    // get the usernames from input
    private String[] findUsernames(String input, UsersController users) {
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
                        if (assignUsernames(size, usernames, splitPlayerAndUsername, subStringForNumber)) return null;
                    }
                    else {
                        System.out.println("invalid number for player , only number after <player>");
                        return null;
                    }
                }
                else {
                    System.out.println("invalid command for players , each should start with key word <player>");
                    return null;
                }
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
                            if (assignUsernames(size, usernames, splitPlayerAndUsername, subStringForNumber))
                                return null;
                        }
                        else {
                            System.out.println("invalid number for player , only number after <p>");
                            return null;
                        }
                    }
                    else {
                        System.out.println("invalid command for players , each should start with key word <p>");
                        return null;
                    }
                }
            }
            else
                System.out.println("invalid command");
        }
        return usernames;
    }

    private boolean assignUsernames(int size, String[] usernames, String[] splitPlayerAndUsername, String subStringForNumber) {
        int indexOfPlayer;
        indexOfPlayer = Integer.parseInt(subStringForNumber);
        if (indexOfPlayer <= size) {
            if (usernames[indexOfPlayer - 1] == null)
                usernames[indexOfPlayer - 1] = splitPlayerAndUsername[1].trim();
            else {
                System.out.println("identical number for players");
                return true;
            }
        }
        else {
            System.out.println("given numbers are not proper");
            return true;
        }
        return false;
    }

    //all usernames should be valid
    private boolean checkIfUsernamesAreValid(String[] usernames, UsersController users) {

        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i] == null) {
                System.out.println("error occurred with given numbers");
                return false;
            }
        }

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
    private ArrayList<Technology> ancientTechnologies() {
        ArrayList<Technology> technologies = new ArrayList<>();
        ArrayList<Unit> units;
        ArrayList<Improvement> improvements = new ArrayList<>();
        improvements.add(new Improvement("Mekewap", 1, 0, 0, 5));
        technologies.add(new Technology("Pottery", improvements, 0, 10, null));
        //pottery
        improvements = new ArrayList<>();
        improvements.add(new Improvement("Camp", 0, 0, 1, 5));
        improvements.add(new Improvement("Pasture", 1, 0, 0, 5));
        improvements.add(new Improvement("Kurgan", 0, 0, 3, 5));
        technologies.add(new Technology("Animal Husbandry", improvements, 1, 10, null));
        //mining
        improvements = new ArrayList<>();
        improvements.add(new Improvement("Mine", 1, 0, 0, 5));
        improvements.add(new Improvement("Quarry", 1, 0, 0, 5));
        technologies.add(new Technology("Mining", improvements, 2, 10, null));
        /*//sailing
        improvements = new ArrayList<>();
        improvements.add(new Improvement("Fishing Boat", 0, 1, 0, 5));
        technologies.add(new Technology("Sailing", improvements, 3, 10));*/
        //astrology
        technologies.add(new Technology("Astrology", null, 3, 10, null));
        //irrigation
        improvements = new ArrayList<>();
        improvements.add(new Improvement("Plantation", 0, 0, 2, 5));
        improvements.add(new Improvement("Stepwell", 0, 1, 0, 5));
        technologies.add(new Technology("Irrigation", improvements, 4, 10, null));
        //writing
        technologies.add(new Technology("Writing", null, 5, 10, null));
        //archery
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("archery", null, 100, 5, 1, 2, 15, 25, null, 20));
        technologies.add(new Technology("Archery", null, 6, 10, units));
        //masonry
        improvements = new ArrayList<>();
        improvements.add(new Improvement("Great Wall", 0, 0, 0, 5));
        improvements.add(new Improvement("Nubial Pyramid", 0, 2, 0, 5));
        technologies.add(new Technology("Masonary", improvements, 7, 10, null));
        //bronze working
        technologies.add(new Technology("Bronze Working", null, 8, 10, null));
        //wheel
        technologies.add(new Technology("Wheel", null, 9, 10, null));

        return technologies;
    }
}
