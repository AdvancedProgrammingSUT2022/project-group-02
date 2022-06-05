package model;

public class Message {
    private String content;
    private final User sender;
    private final User receiver;
    private final String time;
    private boolean sent;
    private boolean seen;

    public Message(String content, User sender, User receiver, String time, boolean sent, boolean seen) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
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

    public User getReceiver() {
        return receiver;
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
}
