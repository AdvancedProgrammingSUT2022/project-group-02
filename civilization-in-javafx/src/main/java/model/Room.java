package model;

import java.util.ArrayList;

public class Room {
    private final User owner;
    private String name;
    private ArrayList<User> users;
    private ArrayList<Message> messages;
    public Room(User owner, String name) {
        this.owner = owner;
        this.name = name;
        users = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getOwner() {
        return owner;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void removeMessage(Message message) {
        messages.remove(message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
