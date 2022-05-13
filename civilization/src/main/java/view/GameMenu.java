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
   /*private ArrayList<Technology> Technologies() {

        ArrayList<Technology> technologies = new ArrayList<>();
        ArrayList<Unit> units;
        ArrayList<Improvement> improvements = new ArrayList<>();
        //ancient
        improvements.add(new Improvement("Mekewap", 1, 0, 0, 5));
        technologies.add(new Technology("Pottery", improvements, 0, 25, null));
        //pottery
        improvements = new ArrayList<>();
        improvements.add(new Improvement("Camp", 0, 0, 1, 5));
        improvements.add(new Improvement("Pasture", 1, 0, 0, 5));
        improvements.add(new Improvement("Kurgan", 0, 0, 3, 5));
        technologies.add(new Technology("Animal Husbandry", improvements, 1, 25, null));
        //mining
        improvements = new ArrayList<>();
        improvements.add(new Improvement("Mine", 1, 0, 0, 5));
        improvements.add(new Improvement("Quarry", 1, 0, 0, 5));
        technologies.add(new Technology("Mining", improvements, 2, 25, null));
        //sailing
        improvements = new ArrayList<>();
        improvements.add(new Improvement("Fishing Boat", 0, 1, 0, 5));
        technologies.add(new Technology("Sailing", improvements, 3, 10));
        //astrology
        technologies.add(new Technology("Astrology", null, 3, 50, null));
        //irrigation
        improvements = new ArrayList<>();
        improvements.add(new Improvement("Plantation", 0, 0, 2, 5));
        improvements.add(new Improvement("Stepwell", 0, 1, 0, 5));
        technologies.add(new Technology("Irrigation", improvements, 4, 50, null));
        //writing
        technologies.add(new Technology("Writing", null, 5, 50, null));
        //archery
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("archer", null, 100, 240, 60, 1, 2, 15, 25, null, 20, 1));
        technologies.add(new Technology("Archery", null, 6, 50, units));
        //masonry
        improvements = new ArrayList<>();
        improvements.add(new Improvement("Great Wall", 0, 0, 0, 5));
        improvements.add(new Improvement("Nubial Pyramid", 0, 2, 0, 5));
        technologies.add(new Technology("Masonary", improvements, 7, 80, null));
        //bronze working
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Spearman", null, 100, 260, 65, 1, 2, 25, 0, null, 25, 1));
        technologies.add(new Technology("Bronze Working", null, 8, 80, units));
        //wheel
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("Chariot Archer", null, 100, 260, 65, 1, 2, 28, 0, null, 28, 1));
        technologies.add(new Technology("Wheel", null, 9, 80, units));
        //classic
        //currency
        technologies.add(new Technology("Currency", null, 10, 120, null));
        //horseback riding
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Horseman", null, 100, 320, 80, 1,  4, 36, 0, null, 36, 2));
        technologies.add(new Technology("Horseback Riding", null, 11, 120, units));
        //iron working
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Swordsman", null, 100, 360, 90, 1, 2, 35, 0, null, 35, 2));
        units.add(new MeleeMilitaryUnit("Longswordsman", null, 100, 360, 90, 1, 2, 50, 0, null, 50, 3));
        technologies.add(new Technology("Iron Working", null, 12, 120, units));
        // mathematics
        technologies.add(new Technology("Mathematics", null, 13, 200, null));
        // construction
        technologies.add(new Technology("Construction", null, 14, 200, null));
        // engineering
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("Catapult", null, 100, 480, 120, 1, 2, 25, 35, null, 25, 2));
        technologies.add(new Technology("Engineering", null, 15, 200, units));
        // military tactics
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Pikeman", null, 100, 800, 200, 1, 2, 45, 0, null, 45, 3));
        technologies.add(new Technology("Military Tactics", null, 16, 275, units));
        // apprenticeship
        technologies.add(new Technology("Apprenticeship", null, 17, 275, null));
        // stirrups
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Knight", null, 100,720, 180, 1, 4, 50, 0, null, 50, 3));
        technologies.add(new Technology("Stirrups", null, 18, 360, units));
        // machinery
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("Crossbowman", null, 100, 720, 180, 1, 2, 30, 40, null, 30, 3));
        technologies.add(new Technology("Machinery", null, 19, 275, units));
        // education
        technologies.add(new Technology("Education", null, 20, 335, null));
        // military engineering
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("Trebuchet", null, 100, 800, 200, 1, 2, 35, 45, null, 35, 3));
        technologies.add(new Technology("Military Engineering", null, 21, 335, units));
        // castle
        technologies.add(new Technology("Castles", null, 22, 390, null));
        //renaissance
        // banking
        technologies.add(new Technology("Banking", null, 23, 540, null));
        // gunpowder
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Musketman", null, 100, 960, 240, 1, 2, 55, 0, null, 55, 4));
        technologies.add(new Technology("Gunpowder", null, 24, 490, units));
        // printing
        technologies.add(new Technology("Printing", null, 25, 490, null));
        // astronomy
        technologies.add(new Technology("Astronomy", null, 26, 600, null));
        // metal casting
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Lancer", null, 100, 1000, 270, 1, 4, 58, 0, null, 58, 4));
        technologies.add(new Technology("Metal Casting", null, 27, 660, units));
        // siege tactics
        technologies.add(new Technology("Siege Tactics", null, 28, 660, null));
        //industrialization
        technologies.add(new Technology("Industrialization", null, 29, 930, null));
        // scientific theory
        technologies.add(new Technology("Scientific Theory", null, 30, 930, null));
        // ballistics
        technologies.add(new Technology("Ballistics", null, 31, 930, null));
        // military science
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Cavalry", null, 100, 1320, 330, 1, 5, 62, 0, null, 62, 5));
        technologies.add(new Technology("Military Science", null, 32, 930, units));
        // steam power
        technologies.add(new Technology("Steam Power", null, 33, 805, null));
        // sanitation
        technologies.add(new Technology("Sanitation", null, 34, 805, null));
        // economics
        technologies.add(new Technology("Economics", null, 35, 805, null));
        // rifling
        units = new ArrayList<>();
        units.add(new Unit("Rifleman", null, 100, 1320, 330, 1, 2, 70, 0, null, 70, 5));
        technologies.add(new Technology("Rifling", null, 36, 970, units));
        // flight
        technologies.add(new Technology("Flight", null, 37, 1250, null));
        // replaceable parts
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Infantry", null, 100, 1720, 430, 1, 2, 75, 0, null, 75, 6));
        units.add(new MeleeMilitaryUnit("Anti-Tank Gun", null, 100, 1720, 430, 1, 2, 75, 0, null, 75, 6));
        technologies.add(new Technology("Replaceable Parts", null, 38, 1250, units));
        // steel
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("Artillery", null, 100, 1720, 430, 1, 2, 60, 80, null, 60, 6));
        technologies.add(new Technology("Steel", null, 39, 1140, units));
        // electricity
        technologies.add(new Technology("Electricity", null, 40, 985, null));
        // radio
        technologies.add(new Technology("Radio", null, 41, 1370, null));
        // chemistry
        units = new ArrayList<>();
        units.add(new RangeMilitaryUnit("Canon", null, 100, 1820, 450, 1, 2, 70, 70, null, 70, 6));
        technologies.add(new Technology("Chemistry", null, 42, 985, units));
        // combustion
        units = new ArrayList<>();
        units.add(new MeleeMilitaryUnit("Tank", null, 100, 1920, 480, 1, 4, 85, 0, null, 85, 6));
        units.add(new MeleeMilitaryUnit("Panzer", null, 100, 1820, 380, 1, 5, 60, 0, null, 60, 5));
        technologies.add(new Technology("Combustion", null, 43, 1250, units));

        return technologies;
    }*/

    private int[][] techGraph() {
        int[][] graph = new int[44][44];
        // 0 -> 3
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j < 44; j++)
                graph[j][i] = 0;
        }
        // 4
        graph[0][4] = 1;
        for (int i = 1; i < 44; i++)
            graph[i][4] = 0;
        //5
        graph[0][5] = 1;
        for (int i = 1; i < 44; i++)
            graph[i][5] = 0;
        //6
        graph[0][6] = 0;
        graph[1][6] = 1;
        for (int i = 2; i < 44; i++)
            graph[i][6] = 0;
        //7 -> 9
        for (int i = 7; i <= 9; i++) {
            for (int j = 0; j < 44; j++) {
                if (j == 2)
                    graph[j][i] = 1;
                else
                    graph[j][i] = 0;
            }
        }
        //10
        for (int i = 0; i < 44; i++){
            if (i == 5)
                graph[i][10] = 1;
            else
                graph[i][10] = 0;
        }
        //11
        for (int i = 0; i < 44; i++) {
            if (i == 6)
                graph[i][11] = 1;
            else
                graph[i][11] = 0;
        }
        //12
        for (int i = 0; i < 44; i++) {
            if (i == 8)
                graph[i][12] = 1;
            else
                graph[i][12] = 0;
        }
        //13
        for (int i = 0; i < 44; i++) {
            if (i == 10)
                graph[i][13] = 1;
            else
                graph[i][13] = 0;
        }
        //14
        for (int i = 0; i < 44; i++) {
            if (i == 11 || i == 7)
                graph[i][14] = 1;
            else
                graph[i][14] = 0;
        }
        //15
        for (int i = 0; i < 44; i++){
            if (i == 9)
                graph[i][15] = 1;
            else
                graph[i][15] = 0;
        }
        // 16
        for (int i = 0; i < 44; i++) {
            if (i == 13)
                graph[i][16] = 1;
            else
                graph[i][16] = 0;
        }
        // 17
        for (int i = 0; i < 44; i++) {
            if (i == 10 || i == 11)
                graph[i][17] = 1;
            else
                graph[i][17] = 0;
        }
        // 18
        for (int i = 0; i < 44; i++) {
            if (i == 11)
                graph[i][18] = 1;
            else
                graph[i][18] = 0;
        }
        // 19
        for (int i = 0; i < 44; i++) {
            if (i == 12 || i == 15)
                graph[i][19] = 1;
            else
                graph[i][19] = 0;
        }
        // 20
        for (int i = 0; i < 44; i++) {
            if (i == 13 || i == 17)
                graph[i][20] = 1;
            else
                graph[i][20] = 0;
        }
        // 21
        for (int i = 0; i < 44; i++) {
            if (i == 14)
                graph[i][21] = 1;
            else
                graph[i][21] = 0;
        }
        // 22
        for (int i = 0; i < 44; i++) {
            if (i == 14)
                graph[i][22] = 1;
            else
                graph[i][22] = 0;
        }
        // 23
        for (int i = 0; i < 44; i++) {
            if (i == 18 || i == 20)
                graph[i][23] = 1;
            else
                graph[i][23] = 0;
        }
        // 24
        for (int i = 0; i < 44; i++) {
            if (i == 17 || i == 18 || i == 21)
                graph[i][24] = 1;
            else
                graph[i][24] = 0;
        }
        // 25
        for (int i = 0; i < 44; i++) {
            if (i == 19)
                graph[i][25] = 1;
            else
                graph[i][25] = 0;
        }
        // 26
        for (int i = 0; i < 44; i++) {
            if (i == 20)
                graph[i][26] = 1;
            else
                graph[i][26] = 0;
        }
        // 27
        for (int i = 0; i < 44; i++) {
            if (i == 24)
                graph[i][27] = 1;
            else
                graph[i][27] = 0;
        }
        // 28
        for (int i = 0; i < 44; i++) {
            if (i == 22)
                graph[i][28] = 1;
            else
                graph[i][28] = 0;
        }
        // 29
        for (int i = 0; i < 44; i++) {
            if (i == 23 || i == 25)
                graph[i][29] = 1;
            else
                graph[i][29] = 0;
        }
        // 30
        for (int i = 0; i < 44; i++) {
            if (i == 26)
                graph[i][30] = 1;
            else
                graph[i][30] = 0;
        }
        // 31
        for (int i = 0; i < 44; i++) {
            if (i == 27)
                graph[i][31] = 1;
            else
                graph[i][31] = 0;
        }
        // 32
        for (int i = 0; i < 44; i++) {
            if (i == 25 || i == 28)
                graph[i][32] = 1;
            else
                graph[i][32] = 0;
        }
        // 33
        for (int i = 0; i < 44; i++) {
            if (i == 29)
                graph[i][33] = 1;
            else
                graph[i][33] = 0;
        }
        // 34
        for (int i = 0; i < 44; i++) {
            if (i == 30)
                graph[i][34] = 1;
            else
                graph[i][34] = 0;
        }
        // 35
        for (int i = 0; i < 44; i++) {
            if (i == 27 || i == 30)
                graph[i][35] = 1;
            else
                graph[i][35] = 0;
        }
        // 36
        for (int i = 0; i < 44; i++) {
            if (i == 31 || i == 32)
                graph[i][36] = 1;
            else
                graph[i][36] = 0;
        }
        // 37
        for (int i = 0; i < 44; i++) {
            if (i == 29 || i == 30)
                graph[i][37] = 1;
            else
                graph[i][37] = 0;
        }
        // 38
        for (int i = 0; i < 44; i++) {
            if (i == 35)
                graph[i][37] = 1;
            else
                graph[i][37] = 0;
        }
        // 39
        for (int i = 0; i < 44; i++) {
            if (i == 36)
                graph[i][36] = 1;
            else
                graph[i][36] = 0;
        }
        // 40
        for (int i = 0; i < 44; i++) {
            if (i == 33)
                graph[i][40] = 1;
            else
                graph[i][40] = 0;
        }
        // 41
        for (int i = 0; i < 44; i++) {
            if (i == 33 || i == 37)
                graph[i][41] = 1;
            else
                graph[i][41] = 0;
        }
        // 42
        for (int i = 0; i < 44; i++) {
            if (i == 34 || i == 38)
                graph[i][42] = 1;
            else
                graph[i][42] = 0;
        }
        // 43
        for (int i = 0; i < 44; i++) {
            if (i == 39 || i == 36)
                graph[i][43] = 1;
            else
                graph[i][43] = 0;
        }
        return graph;
    }
}
