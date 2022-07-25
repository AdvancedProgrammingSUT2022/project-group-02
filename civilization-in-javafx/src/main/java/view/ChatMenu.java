package view;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.ChatController;
import controller.NetworkController;
import controller.UsersController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.*;
import view.enums.Colors;
import view.enums.Images;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ChatMenu {
    public static Images images;
    private String whichMenu;
    private UsersController users;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private Scene scene;
    private User user;


    public ChatMenu(MediaPlayer mediaPlayer, Stage stage, Scene scene, Images images, UsersController users, User user){
        this.users = users;
        ChatMenu.images = images;
        this.scene = scene;
        this.mediaPlayer = mediaPlayer;
        this.stage = stage;
        this.user = user;
    }

    public void start(){
        URL fxmlAddress = getClass().getResource("/Fxml/main-menu.fxml");
        if (fxmlAddress == null) System.exit(0);
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(fxmlAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (root == null) {
            System.out.println("root");
            System.exit(0);
        }
        if (scene == null) {
            System.out.println("scene");
            System.exit(0);
        }
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        scene.setRoot(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        initialize();
    }

//    public void graphicRectBackground(AnchorPane root){
//        ImageView buttonBackGround = new ImageView(images.mainMenuButtonBackGround);
//        buttonBackGround.setFitWidth(630);
//        buttonBackGround.setFitHeight(780);
//        buttonBackGround.setLayoutX(445);
//        buttonBackGround.setLayoutY(15);
//        root.getChildren().add(buttonBackGround);
//
//    }

    public VBox usersList;

    public void initialize() {
        showUsers();
    }

    public void refreshUsers(ActionEvent actionEvent) {
        Request request = new Request();
        request.setAction("get_chats");
        Response response = NetworkController.getInstance().sendRequest(request);
        String chatsJson = new Gson().toJson(response.getMessage());
        ArrayList<Chat> chats = new Gson().fromJson(chatsJson, new TypeToken<ArrayList<Chat>>(){}.getType());
        Database.getInstance().setChats(chats);
        showUsers();
    }

    private void showUsers() {
        usersList.getChildren().clear();
        ArrayList<Chat> chats = Database.getInstance().getChats();
        for (Chat chat : chats) {
            HBox holder = new HBox();
            Label text = new Label();
            text.setText(chat.getName());
            text.setStyle("-fx-start-margin: 8;");
            holder.setAlignment(Pos.CENTER_LEFT);
            holder.setStyle("-fx-padding: 16; -fx-border-color: #000000; -fx-border-width: 0 1 1 1;");
            holder.setMinHeight(24);
            holder.getChildren().add(text);
            usersList.getChildren().add(holder);
            holder.setOnMouseClicked(mouseEvent -> {
                try {
                    ChatPage.run(chat.getId());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
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
                ArrayList<Room> userRooms = ChatController.getInstance().userRooms(you);
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
        PrivateChat current = ChatController.getInstance().getChatByUser(you, other);
        PrivateChat forOtherUser;
        if (current == null) {
            current = new PrivateChat(you, other);
            ChatController.getInstance().addPrivateChats(current);
            forOtherUser = new PrivateChat(other, you);
            ChatController.getInstance().addPrivateChats(forOtherUser);
        }
        else {
            forOtherUser = ChatController.getInstance().getChatByUser(other, you);
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
        System.out.println("press -exit room- to get out of this panel");
        while (true) {
            roomInput = scanner.nextLine();
            if (roomInput.equals("exit room")) {
                System.out.println("exited from room successfully");
                return;
            }
            else if (roomInput.equals("room setting")) {
                if (room.getOwner().equals(you)) {
                    System.out.println("press -room setting exit- to get out of this panel");
                    while (true) {
                        roomInput = scanner.nextLine();
                        if (roomInput.equals("room setting exit"))
                            break;
                        else if (roomInput.equals("remove users")) {
                            int index = 1;
                            for (User user : room.getUsers()) {
                                System.out.println(index + "- " + user.getUsername());
                                index++;
                            }
                            System.out.println("enter an index to delete");
                            System.out.println("press -delete exit- to get out of this panel");
                            while (true) {
                                roomInput = scanner.nextLine();
                                if (roomInput.equals("delete exit"))
                                    break;
                                else if (Pattern.matches("\\d+", roomInput)) {
                                    User user = room.getUsers().get(index - 1);
                                    if (user.equals(you)) {
                                        //todo : warn the user of the consequences
                                        ChatController.getInstance().removeRoom(room);
                                        System.out.println("room deleted successfully! goodbye!");
                                        return;
                                    }
                                    else {
                                        room.removeUser(user);
                                        System.out.println("you removed " + user.getUsername() + " successfully!");
                                        break;
                                    }
                                }
                                else
                                    System.out.println("invalid command");
                            }
                        }
                    }
                }
                else
                    System.out.println("you don't have access to this panel");
            }
            else {
                String time = LocalTime.now().toString();
                Message message = new Message(roomInput, you, room.getUsers(), time, false, false);
                room.addMessage(message);
            }

        }
    }

}
