package view;

import controller.MapController;
import controller.Users;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameMenu {
    public void run(Users users, User user, Scanner scanner) {
        String input;
        Matcher matcher;
        while (true) {
            input = scanner.nextLine();
            if (Pattern.matches("\\s*menu\\s+exit\\s*", input))
                return;
            else if (Pattern.matches("\\s*menu\\s+show-current\\s*", input))
                System.out.println("Play Game");
            else if (input.startsWith("play game")) {

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

                boolean allUsernamesExist = true;
                for (int i = 0; i < size; i++) {
                    if (!users.sameUsernameExists(usernames[i])) {
                        System.out.println("no such user exists");
                        allUsernamesExist = false;
                        break;
                    }
                }
                if (allUsernamesExist) {
                    System.out.println("successfully started game");
                    ArrayList<User> players = new ArrayList<>();
                    for (String username : usernames) {
                        players.add(users.getUserByUsername(username));
                    }
                    // temporary
                    int height = 7;
                    int width = 4;
                    new PlayGame(players, height, width).run(scanner);
                }
            }

            else
                System.out.println("invalid command");
        }
    }
}
