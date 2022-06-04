package view;

import controller.UsersController;
import model.User;
import view.enums.Colors;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ChatMenu {

    public void run(Scanner scanner, UsersController usersController) {
        String chatInput;
        System.out.println(Colors.YELLOW + "press -public- to chat with everyone");
        System.out.println("press -private- to find a person and chat privately");
        System.out.println("press -rooms- to find a room and chat with it's members");
        while (true) {
            chatInput = scanner.nextLine();
            if (chatInput.equals("public")) {
                //todo public chat
            }
            else if (chatInput.equals("private")) {
                //todo find a person by searching
                String privateInput;
                while (true) {
                    System.out.println("enter the username or part of the username to find the user");
                    privateInput = scanner.nextLine();
                    if (privateInput.equals("exit searching users")) {
                        break;
                    }
                    else {
                        ArrayList<User> foundUsers = new ArrayList<>();
                        for (User user : usersController.getUsers()) {
                            if (user.getUsername().contains(privateInput)) {
                                //find a user containing these input
                                foundUsers.add(user);
                            }
                        }
                        if (foundUsers.size() > 0) {
                            if (foundUsers.size() > 1) {
                                //more than one user matched
                                System.out.println("press the index to chat with the user");
                                for (User user : foundUsers) {
                                    int index = 1;
                                    System.out.println(index + "- Username : " + user.getUsername());
                                }
                                while (true) {
                                    privateInput = scanner.nextLine();
                                    if (privateInput.equals("exit selecting users")) {
                                        break;
                                    }
                                    else if (Pattern.matches("\\d+", privateInput)) {

                                    }
                                    else
                                        System.out.println("invalid command");
                                }
                            } else {
                                //only one user matched
                            }
                        } else
                            System.out.println("didn't match with any username!");
                    }
                }
            }
            else if (chatInput.equals("rooms")) {
                //todo enter or create a room
            }
        }

    }

}
