package view;

import controller.ChatController;
import controller.UsersController;
import model.Message;
import model.PrivateChat;
import model.Room;
import model.User;
import view.enums.Colors;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ChatMenu {

    private static ChatMenu chatMenu;

    private ChatController chatController;

    private ChatMenu() {
        this.chatController = new ChatController();
    }

    public static ChatMenu getInstance() {
        if (chatMenu == null)
            chatMenu = new ChatMenu();

        return chatMenu;
    }

    public void run(Scanner scanner, UsersController usersController, User you) {
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
                        System.out.println("exited from searching bar");
                        break;
                    }
                    else {
                        ArrayList<User> foundUsers = new ArrayList<>();
                        for (User user : usersController.getUsers()) {
                            if (user.getUsername().contains(privateInput) && !user.equals(you)) {
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
                                        int index = Integer.parseInt(privateInput);
                                        if (index >= 1 && index <= foundUsers.size()) {
                                            //user matched
                                            chatPrivately(you, foundUsers.get(index - 1), scanner);
                                        }
                                        else
                                            System.out.println("invalid number");
                                    }
                                    else
                                        System.out.println("invalid command");
                                }
                            } else {
                                //only one user matched
                                chatPrivately(you, foundUsers.get(0), scanner);
                            }
                        } else
                            System.out.println("didn't match with any username!");
                    }
                }
            }
            else if (chatInput.equals("rooms")) {
                ArrayList<Room> userRooms = chatController.userRooms(you);
                if (userRooms.size() >= 1) {
                    int index = 1;
                    for (Room room : userRooms) {
                        System.out.println(index + "- " + room.getName());
                        index++;
                    }
                    while (true) {
                        chatInput = scanner.nextLine();
                        if (chatInput.equals("exit room searching")) {
                            System.out.println("exited from searching bar");
                            break;
                        } else if (Pattern.matches("\\d+", chatInput)) {
                            index = Integer.parseInt(chatInput);
                            if (index >= 1 && index <= userRooms.size()) {
                                chatInRoom(you, userRooms.get(index - 1), scanner);
                            }
                        } else
                            System.out.println("invalid command");
                    }
                }
                else
                    System.out.println("you aren't the member of any room");
            }
        }

    }

    public void chatPrivately(User you, User other, Scanner scanner) {
        //todo show all the contents of the current chat
        String chatInput;
        PrivateChat current = chatController.getChatByUser(you, other);
        PrivateChat forOtherUser;
        if (current == null) {
            current = new PrivateChat(you, other);
            chatController.addPrivateChats(current);
            forOtherUser = new PrivateChat(other, you);
            chatController.addPrivateChats(forOtherUser);
        }
        else {
            forOtherUser = chatController.getChatByUser(other, you);
        }
        if (forOtherUser == null) {
            System.out.println("an error occurred!");
            return;
        }
        System.out.println("Enter your message!");
        System.out.println("press -exit chat- to quit this chat");
        while (true) {
            chatInput = scanner.nextLine();
            if (chatInput.equals("exit chat")) {
                System.out.println("exited from chat successfully!");
                return;
            }
            else {
                String time = LocalTime.now().toString();
                ArrayList<User> receivers = new ArrayList<>();
                receivers.add(other);
                Message message = new Message(chatInput, you, receivers, time, false, false);
                current.addMessage(message);
                //todo show all the contents with the new message again
                forOtherUser.addMessage(message);
                message.setSent(true);
                //todo send a notification for the other user
            }
        }
    }

    public void chatInRoom(User you, Room room, Scanner scanner) {
        //todo show all the contents of the current room
        String roomInput;
        while (true) {
            roomInput = scanner.nextLine();
            if (roomInput.equals("exit room")) {
                System.out.println("exited from room successfully");
                return;
            }
            else {
                String time = LocalTime.now().toString();
                Message message = new Message(roomInput, you, room.getUsers(), time, false, false);
                room.addMessage(message);
                

            }
        }
    }

}
