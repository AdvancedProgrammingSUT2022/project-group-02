package model;

import javafx.stage.Stage;

import java.util.ArrayList;

public class Database {

    private Stage stage;
    private static Database instance;
    private String nickname = "";
    private int userId = 0;
    private ArrayList<Chat> chats = new ArrayList<>();

    private Database() {

    }

    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setChats(ArrayList<Chat> chats) {
        this.chats = chats;
    }

    public String getNickname() {
        return nickname;
    }

    public ArrayList<Chat> getChats() {
        return chats;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
