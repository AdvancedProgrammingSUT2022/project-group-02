package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Message {
    private String content;
    private final User sender;
    private final ArrayList<User> receivers;
    private final String time;
    private boolean sent;
    private boolean seen;

    public Message(String content, User sender, ArrayList<User> receivers, String time, boolean sent, boolean seen) {
        this.content = content;
        this.sender = sender;
        this.receivers = receivers;
        this.time = time;
        this.sent = sent;
        this.seen = seen;
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
        return receivers;
    }

    public User getSender() {
        return sender;
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
