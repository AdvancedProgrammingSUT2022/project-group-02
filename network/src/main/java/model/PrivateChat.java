package model;

import java.util.ArrayList;

public class PrivateChat {
    private final User first;
    private final User second;
    private ArrayList<Message> messages;
    public PrivateChat(User first, User second) {
        this.first = first;
        this.second = second;
        messages = new ArrayList<>();
    }

    public User getFirst() {
        return first;
    }

    public User getSecond() {
        return second;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void deleteMessage(Message message) {
        messages.remove(message);
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
