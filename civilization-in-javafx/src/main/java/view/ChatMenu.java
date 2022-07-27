package view;

import controller.NetworkController;
import controller.UsersController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.*;
import view.enums.Images;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ChatMenu {

//    public static Images images;
//    private String whichMenu;
//    private UsersController users;
//    private MediaPlayer mediaPlayer;
//    private Stage stage;
//    private Scene scene;
//    private User user;
//    public TextField nicknameField;
//    public Label errorLabel;
//    private Callback onFinish;
//
//    public ChatMenu(MediaPlayer mediaPlayer, Stage stage, Scene scene, Images images, UsersController users, User user){
//        this.users = users;
//        ChatMenu.images = images;
//        this.scene = scene;
//        this.mediaPlayer = mediaPlayer;
//        this.stage = stage;
//        this.user = user;
//    }
//
//
//    public void start(){
//        URL fxmlAddress = getClass().getResource("/FXML/main-menu.fxml");
//        if (fxmlAddress == null) System.exit(0);
//        AnchorPane root = null;
//        try {
//            root = FXMLLoader.load(fxmlAddress);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (root == null) {
//            System.out.println("root");
//            System.exit(0);
//        }
//        if (scene == null) {
//            System.out.println("scene");
//            System.exit(0);
//        }
//        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
//        scene.setRoot(root);
//        stage.setScene(scene);
//        stage.setMaximized(true);
//        stage.setFullScreen(true);
//        try {
//            showLoginPopup();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        graphicPlayBackgroundMusic();
////        graphicButtons(root);
//    }
//
//    private void showLoginPopup() throws IOException {
//        // TODO: show on top
//        Stage popup = new Stage();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(Main.class.getResource("/FXML/login-dialog.fxml"));
//        loader.setController(new LoginDialog(new Callback() {
//            @Override
//            public void call(Object object) {
//                try {
//                    Request request = new Request();
//                    request.setAction("register");
//                    //request.addData("nickname", Database.getInstance().getNickname());
//                    Response response = NetworkController.getInstance().sendRequest(request);
//                    int id = (int) Math.floor((Double) Double.parseDouble(response.getMessage()));
//                    Database.getInstance().setUserId(id);
//                    popup.close();
//                    //NetworkController.listenForUpdates();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }));
//        Scene scene = new Scene(loader.load(), 250, 150);
//        popup.setTitle("Login");
//        popup.setScene(scene);
//        popup.show();
//    }
//
//
//
//    public void LoginDialog(Callback onFinish) {
//        this.onFinish = onFinish;
//    }
//
//
//    public void confirmClicked() {
//        String nickname = nicknameField.getText();
//        if (nickname.length() < 3) {
//            errorLabel.setText("Nickname should be at least 3 characters");
//        }
//        Database.getInstance().setNickname(nickname);
//        onFinish.call(null);
//    }
//


    public static Images images;
    private UsersController users;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private Scene scene;
    private User user;
    private ArrayList<Message> messages;
    private ArrayList<User> friends;
    private static int lsatLabelY = 220;


    public ChatMenu(MediaPlayer mediaPlayer, Stage stage, Scene scene, Images images, UsersController users, User user) {
        this.users = users;
        ChatMenu.images = images;
        this.scene = scene;
        this.mediaPlayer = mediaPlayer;
        this.stage = stage;
        this.user = user;
        this.messages = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    public void start() {
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
        graphicRectBackground(root);
        showFriends(root);
    }

    public void graphicRectBackground(AnchorPane root) {
        ImageView buttonBackGround = new ImageView(images.mainMenuButtonBackGround);
        buttonBackGround.setFitWidth(630);
        buttonBackGround.setFitHeight(780);
        buttonBackGround.setLayoutX(445);
        buttonBackGround.setLayoutY(15);

        Rectangle background = new Rectangle(550, 165, 450, 550);
        background.setFill(new Color(1, 1, 1, 0.5));

        root.getChildren().add(background);
        // root.getChildren().add(buttonBackGround);
    }

    public void showFriends(AnchorPane root) {
        user.addFriend(new User("mohammad", "ali", "0"));
        user.addFriend(new User("mohammad", "amir", "0"));
        user.addFriend(new User("mohammad", "mohammad", "0"));
        user.addFriend(new User("mohammad", "shayan", "0"));
        user.addFriend(new User("mohammad", "hossein", "0"));
        user.addFriend(new User("mohammad", "hassan", "0"));
        user.addFriend(user);
        friends = user.getFriends();
        int i = 0;
        HashMap<Button, User> buttons = new HashMap<>();
        for (User friend : friends) {
            Button friendName = new Button(friend.getNickname());
            buttons.put(friendName, friend);
            friendName.setLayoutX(550);
            friendName.setLayoutY(165 + (i * 55));
            friendName.getStyleClass().add("main-menu-buttons");
            friendName.setPrefSize(450, 50);
            i++;
            root.getChildren().add(friendName);
        }
        buttons.forEach((button, friend) -> {
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                goToPrivateChat(friend);
                root.getChildren().clear();
                friends.clear();
            });
        });
        Button back = new Button("Back");
        back.setLayoutX(550);
        back.setLayoutY(600);
        back.getStyleClass().add("main-menu-buttons");
        back.setPrefSize(450, 50);
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                new MainMenu(mediaPlayer, stage, scene, images, users).run(user, new Scanner(System.in));
            }
        });
        root.getChildren().add(back);
    }

    public void goToPrivateChat(User friend) {
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
        graphicRectBackground(root);
        privateChatRoom(friend, root);
    }

    public void privateChatRoom(User friend, AnchorPane root) {
        TextField message = new TextField("Type your message");
        message.setLayoutX(550);
        message.setLayoutY(665);
        message.setPrefSize(400, 50);
        root.getChildren().add(message);
        showMessages(friend, root, message);

        Line line = new Line(550, 215, 1000, 215);
        root.getChildren().add(line);

        Button send = new Button("->");
        send.setLayoutX(950);
        send.setLayoutY(665);
        send.getStyleClass().add("main-menu-buttons");
        send.setPrefSize(50, 50);
        send.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                sendMessage(friend, message.getText(), root, message);
                message.setText("");
            }
        });
        root.getChildren().add(send);

        Button back = new Button("<-");
        back.setLayoutX(550);
        back.setLayoutY(165);
        back.getStyleClass().add("main-menu-buttons");
        back.setPrefSize(50, 50);
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                new ChatMenu(mediaPlayer, stage, scene, images, users, user).start();
            }
        });
        root.getChildren().add(back);
    }

    public void sendMessage(User friend, String message, AnchorPane root, TextField textField) {
        ArrayList<String> receivers = new ArrayList<>();
        receivers.add(friend.getUsername());
        ArrayList<User> receiverUsers = new ArrayList<>();
        receiverUsers.add(friend);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = dateTimeFormatter.format(now);
        Message message1 = new Message(message, user.getUsername(), receivers, time, true, true, false);
        message1.setSenderUser(user);
        message1.setReceiverUsers(receiverUsers);
        addMessageToHistory(user, friend, message1);
        showMessages(friend, root, textField);
    }

    //todo : **** SERVER ****
    //todo : move this methods to server
    public void addMessageToHistory(User sender, User receiver, Message message) {
        sender.addSentMessages(message);
        receiver.addMessage(message);
//        Request request = new Request();
//        request.setMenu("chat menu");
//        request.setAction("send message");
//        request.setMessageObject(message);
//        Response response = NetworkController.getInstance().sendRequest(request);
    }

    public ArrayList<Message> getMessagesOfThisChat(User sender, User receiver) {
        ArrayList<Message> messageArrayList = new ArrayList<>();
        if (sender.getSentMessages() != null) {
            for (Message message : sender.getSentMessages()) {
                if (message.getReceiverUsers().contains(receiver)) {
                    messageArrayList.add(message);
                }
            }
        }
        if (receiver.getSentMessages() != null) {
            for (Message message : receiver.getSentMessages()) {
                if (message.getReceiverUsers().contains(sender)) {
                    messageArrayList.add(message);
                }
            }
        }
//        Request request = new Request();
//        request.setMenu("chat menu");
//        request.setAction("get messages");
//        ArrayList<String> receivers = new ArrayList<>();
//        receivers.add(receiver.getUsername());
//        request.setMessageObject(new Message("",sender.getUsername(),receivers,"",true,true,false));
//        Response response = NetworkController.getInstance().sendRequest(request);
//        messageArrayList = response.getMessageArrayList();
        return messageArrayList;
    }

    public void removeMessageFromHistory(Message message) {
        messages.remove(message);
        ArrayList<Message> newMessages;
        newMessages = message.getSenderUser().getSentMessages();
        newMessages.remove(message);
        message.getSenderUser().setSentMessages(newMessages);
        ArrayList<Message> newMessagesReceiver;
        newMessagesReceiver = message.getReceivers().get(0).getSeenMessages();
        newMessagesReceiver.remove(message);
        message.getReceivers().get(0).setSeenMessages(newMessagesReceiver);
//        Request request = new Request();
//        request.setMenu("chat menu");
//        request.setAction("delete message");
//        request.setMessageObject(message);
//        Response response = NetworkController.getInstance().sendRequest(request);
    }

    public void handleEdit(TextField textField, Label label, Message message, AnchorPane root, User friend) {
        Button edit = new Button("->");
        edit.setLayoutX(900);
        edit.setLayoutY(665);
        edit.setPrefSize(50, 50);
        edit.getStyleClass().add("main-menu-buttons");
        edit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label.setText("");
                Message olderMessage = message;
                message.setContent(textField.getText());
                root.getChildren().remove(edit);
                message.isShown = false;
//                Request request = new Request();
//                request.setMenu("chat menu");
//                request.setAction("edit message");
//                ArrayList<Message> messageArrayList = new ArrayList<>();
//                messageArrayList.add(olderMessage);
//                messageArrayList.add(message);
//                request.setMessageArrayList(messageArrayList);
//                Response response = NetworkController.getInstance().sendRequest(request);
                showMessages(friend, root, textField);
            }
        });
        root.getChildren().add(edit);
    }
    //todo : finish server part

    public void showMessages(User friend, AnchorPane root, TextField textField) {
        messages = getMessagesOfThisChat(user, friend);
        if (messages != null) {
            for (Message message : messages) {
                if (message.isShown == false) {
                    Label label = new Label(message.getSenderUser().getUsername() + " : " + message.getContent() + " : " + message.getTime() + "         ! ");
                    label.setLayoutX(550);
                    label.setLayoutY(lsatLabelY + 20);
                    label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            addDeleteAndEditAbility(message, root, label, textField, friend);
                        }
                    });
                    root.getChildren().add(label);
                    lsatLabelY += 20;
                    message.isShown = true;
                }
            }
        }
    }

    public void addDeleteAndEditAbility(Message message, AnchorPane root, Label label, TextField textField, User friend) {
        Button delete = new Button("d");
        delete.setLayoutX(label.getLayoutX() + label.getWidth() + 2);
        delete.setLayoutY(label.getLayoutY());
        delete.setPrefSize(9, 9);
        delete.getStyleClass().add("main-menu-buttons");

        Button edit = new Button("e");
        edit.setLayoutX(label.getLayoutX() + label.getWidth() + 2);
        edit.setLayoutY(label.getLayoutY() + 15);
        edit.setPrefSize(9, 9);
        edit.getStyleClass().add("main-menu-buttons");
        delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().remove(label);
                root.getChildren().remove(delete);
                root.getChildren().remove(edit);
                removeMessageFromHistory(message);
            }
        });
        root.getChildren().add(delete);
        edit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                textField.setText("Type your new edited message !");
                handleEdit(textField, label, message, root, friend);
                root.getChildren().remove(delete);
                root.getChildren().remove(edit);
            }
        });
        root.getChildren().add(edit);
    }


//    public VBox usersList;
//
//    public void initialize() {
//        showUsers();
//    }
//
//    public void refreshUsers(ActionEvent actionEvent) {
//        Request request = new Request();
//        request.setAction("get_chats");
//        Response response = NetworkController.getInstance().sendRequest(request);
//        String chatsJson = new Gson().toJson(response.getMessage());
//        ArrayList<Chat> chats = new Gson().fromJson(chatsJson, new TypeToken<ArrayList<Chat>>(){}.getType());
//        Database.getInstance().setChats(chats);
//        showUsers();
//    }
//
//    private void showUsers() {
//        usersList.getChildren().clear();
//        ArrayList<Chat> chats = Database.getInstance().getChats();
//        for (Chat chat : chats) {
//            HBox holder = new HBox();
//            Label text = new Label();
//            text.setText(chat.getName());
//            text.setStyle("-fx-start-margin: 8;");
//            holder.setAlignment(Pos.CENTER_LEFT);
//            holder.setStyle("-fx-padding: 16; -fx-border-color: #000000; -fx-border-width: 0 1 1 1;");
//            holder.setMinHeight(24);
//            holder.getChildren().add(text);
//            usersList.getChildren().add(holder);
//            holder.setOnMouseClicked(mouseEvent -> {
//                try {
//                    ChatPage.run(chat.getId());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//    }
//
//    public void run(Scanner scanner, UsersController usersController, User you) {
//        String chatInput;
//        System.out.println(Colors.YELLOW + "press -public- to chat with everyone");
//        System.out.println("press -private- to find a person and chat privately");
//        System.out.println("press -rooms- to find a room and chat with it's members");
//        while (true) {
//            chatInput = scanner.nextLine();
//            if (chatInput.equals("public")) {
//                //todo public chat
//            }
//            else if (chatInput.equals("private")) {
//                //todo find a person by searching
//                String privateInput;
//                while (true) {
//                    System.out.println("enter the username or part of the username to find the user");
//                    privateInput = scanner.nextLine();
//                    if (privateInput.equals("exit searching users")) {
//                        System.out.println("exited from searching bar");
//                        break;
//                    }
//                    else {
//                        ArrayList<User> foundUsers = new ArrayList<>();
//                        for (User user : usersController.getUsers()) {
//                            if (user.getUsername().contains(privateInput) && !user.equals(you)) {
//                                //find a user containing these input
//                                foundUsers.add(user);
//                            }
//                        }
//                        if (foundUsers.size() > 0) {
//                            if (foundUsers.size() > 1) {
//                                //more than one user matched
//                                System.out.println("press the index to chat with the user");
//                                for (User user : foundUsers) {
//                                    int index = 1;
//                                    System.out.println(index + "- Username : " + user.getUsername());
//                                }
//                                while (true) {
//                                    privateInput = scanner.nextLine();
//                                    if (privateInput.equals("exit selecting users")) {
//                                        break;
//                                    }
//                                    else if (Pattern.matches("\\d+", privateInput)) {
//                                        int index = Integer.parseInt(privateInput);
//                                        if (index >= 1 && index <= foundUsers.size()) {
//                                            //user matched
//                                            chatPrivately(you, foundUsers.get(index - 1), scanner);
//                                        }
//                                        else
//                                            System.out.println("invalid number");
//                                    }
//                                    else
//                                        System.out.println("invalid command");
//                                }
//                            } else {
//                                //only one user matched
//                                chatPrivately(you, foundUsers.get(0), scanner);
//                            }
//                        } else
//                            System.out.println("didn't match with any username!");
//                    }
//                }
//            }
//            else if (chatInput.equals("rooms")) {
//                ArrayList<Room> userRooms = ChatController.getInstance().userRooms(you);
//                if (userRooms.size() >= 1) {
//                    int index = 1;
//                    for (Room room : userRooms) {
//                        System.out.println(index + "- " + room.getName());
//                        index++;
//                    }
//                    while (true) {
//                        chatInput = scanner.nextLine();
//                        if (chatInput.equals("exit room searching")) {
//                            System.out.println("exited from searching bar");
//                            break;
//                        } else if (Pattern.matches("\\d+", chatInput)) {
//                            index = Integer.parseInt(chatInput);
//                            if (index >= 1 && index <= userRooms.size()) {
//                                chatInRoom(you, userRooms.get(index - 1), scanner);
//                            }
//                        } else
//                            System.out.println("invalid command");
//                    }
//                }
//                else
//                    System.out.println("you aren't the member of any room");
//            }
//        }
//
//    }
//
//    public void chatPrivately(User you, User other, Scanner scanner) {
//        //todo show all the contents of the current chat
//        String chatInput;
//        PrivateChat current = ChatController.getInstance().getChatByUser(you, other);
//        PrivateChat forOtherUser;
//        if (current == null) {
//            current = new PrivateChat(you, other);
//            ChatController.getInstance().addPrivateChats(current);
//            forOtherUser = new PrivateChat(other, you);
//            ChatController.getInstance().addPrivateChats(forOtherUser);
//        }
//        else {
//            forOtherUser = ChatController.getInstance().getChatByUser(other, you);
//        }
//        if (forOtherUser == null) {
//            System.out.println("an error occurred!");
//            return;
//        }
//        System.out.println("Enter your message!");
//        System.out.println("press -exit chat- to quit this chat");
//        while (true) {
//            chatInput = scanner.nextLine();
//            if (chatInput.equals("exit chat")) {
//                System.out.println("exited from chat successfully!");
//                return;
//            }
//            else {
//                String time = LocalTime.now().toString();
//                ArrayList<User> receivers = new ArrayList<>();
//                receivers.add(other);
//                Message message = new Message(chatInput, you, receivers, time, false, false);
//                current.addMessage(message);
//                //todo show all the contents with the new message again
//                forOtherUser.addMessage(message);
//                message.setSent(true);
//                //todo send a notification for the other user
//            }
//        }
//    }
//
//    public void chatInRoom(User you, Room room, Scanner scanner) {
//        //todo show all the contents of the current room
//        String roomInput;
//        System.out.println("press -exit room- to get out of this panel");
//        while (true) {
//            roomInput = scanner.nextLine();
//            if (roomInput.equals("exit room")) {
//                System.out.println("exited from room successfully");
//                return;
//            }
//            else if (roomInput.equals("room setting")) {
//                if (room.getOwner().equals(you)) {
//                    System.out.println("press -room setting exit- to get out of this panel");
//                    while (true) {
//                        roomInput = scanner.nextLine();
//                        if (roomInput.equals("room setting exit"))
//                            break;
//                        else if (roomInput.equals("remove users")) {
//                            int index = 1;
//                            for (User user : room.getUsers()) {
//                                System.out.println(index + "- " + user.getUsername());
//                                index++;
//                            }
//                            System.out.println("enter an index to delete");
//                            System.out.println("press -delete exit- to get out of this panel");
//                            while (true) {
//                                roomInput = scanner.nextLine();
//                                if (roomInput.equals("delete exit"))
//                                    break;
//                                else if (Pattern.matches("\\d+", roomInput)) {
//                                    User user = room.getUsers().get(index - 1);
//                                    if (user.equals(you)) {
//                                        //todo : warn the user of the consequences
//                                        ChatController.getInstance().removeRoom(room);
//                                        System.out.println("room deleted successfully! goodbye!");
//                                        return;
//                                    }
//                                    else {
//                                        room.removeUser(user);
//                                        System.out.println("you removed " + user.getUsername() + " successfully!");
//                                        break;
//                                    }
//                                }
//                                else
//                                    System.out.println("invalid command");
//                            }
//                        }
//                    }
//                }
//                else
//                    System.out.println("you don't have access to this panel");
//            }
//            else {
//                String time = LocalTime.now().toString();
//                Message message = new Message(roomInput, you, room.getUsers(), time, false, false);
//                room.addMessage(message);
//            }
//
//        }
//    }

}

//class LoginDialog {
//    public TextField nicknameField;
//    public Label errorLabel;
//    private Callback onFinish;
//
//    public LoginDialog(Callback onFinish) {
//        this.onFinish = onFinish;
//    }
//
//
//    public void confirmClicked() {
//        String nickname = nicknameField.getText();
//        if (nickname.length() < 3) {
//            errorLabel.setText("Nickname should be at least 3 characters");
//        }
//        Database.getInstance().setNickname(nickname);
//        onFinish.call(null);
//    }
//}