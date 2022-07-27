package model;

import com.google.gson.annotations.Expose;
import controller.UsersController;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Message {
    private String content;
    private final String sender;
    private final ArrayList<String> receivers;
    private final String time;
    private boolean sent;
    private boolean seen;
    public boolean isShown;
    private User senderUser;
    private ArrayList<User> receiverUsers;

    public ArrayList<User> getReceiverUsers() {
        return receiverUsers;
    }

    public void setReceiverUsers(ArrayList<User> receiverUsers) {
        this.receiverUsers = receiverUsers;
    }

    public User getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(User senderUser) {
        this.senderUser = senderUser;
    }

    public Message(String content, String sender, ArrayList<String> receivers, String time, boolean sent, boolean seen, boolean isShown) {
        this.content = content;
        this.sender = sender;
        this.receivers = receivers;
        this.time = time;
        this.sent = sent;
        this.seen = seen;
        this.isShown = isShown;
    }

    public boolean isSeen() {
        return seen;
    }

    public boolean isSent() {
        return sent;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<User> getReceivers() {
        ArrayList<User> users = new ArrayList<>();

        this.getSender().addFriend(new User("mohammad", "ali", "0"));
        this.getSender().addFriend(new User("mohammad", "amir", "0"));
        this.getSender().addFriend(new User("mohammad", "mohammad", "0"));
        this.getSender().addFriend(new User("mohammad", "shayan", "0"));
        this.getSender().addFriend(new User("mohammad", "hossein", "0"));
        this.getSender().addFriend(new User("mohammad", "hassan", "0"));
        this.getSender().addFriend(this.getSender());
        for (User user : this.getSender().getFriends()) {
            if (receivers.contains(user.getUsername())) users.add(user);
        }
        return users;
    }

    public User getSender() {
        for (User user : UsersController.getInstance().getUsers()) {
            if (user.getUsername().equals(sender))return user;
        }
        return null;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
//private int senderId;
//    private LocalDateTime sentAt;
//    private String text;
//
//    public int getSenderId() {
//        return senderId;
//    }
//
//    public LocalDateTime getSentAt() {
//        return sentAt;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setSenderId(int senderId) {
//        this.senderId = senderId;
//    }
//
//    public void setSentAt(LocalDateTime sentAt) {
//        this.sentAt = sentAt;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
}
