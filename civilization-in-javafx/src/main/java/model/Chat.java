package model;

import java.util.ArrayList;

public class Chat {
    private int id;
    private String nickname;
    private ArrayList<Message> messages = new ArrayList<>();

    public String getName() {
        return nickname;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public void setName(String name) {
        this.nickname = name;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
