package controller;

import model.PrivateChat;
import model.Room;
import model.User;
import view.ChatMenu;

import java.util.ArrayList;

public class ChatController {

    private static ChatController chatController;


    private ArrayList<PrivateChat> privateChats;
    private ArrayList<Room> rooms;
    private ChatController() {
        privateChats = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    public static ChatController getInstance() {
        if (chatController == null)
            chatController = new ChatController();
        return chatController;
    }

    public ArrayList<PrivateChat> getPrivateChats() {
        return privateChats;
    }

    public void setPrivateChats(ArrayList<PrivateChat> privateChats) {
        this.privateChats = privateChats;
    }

    public void addPrivateChats(PrivateChat privateChat) {
        privateChats.add(privateChat);
    }

    public void removePrivateChats(PrivateChat privateChat) {
        privateChats.remove(privateChat);
    }

    public PrivateChat getChatByUser(User first, User second) {
        for (PrivateChat privateChat : privateChats) {
            if (privateChat.getFirst().equals(first) && privateChat.getSecond().equals(second))
                return privateChat;
        }
        return null;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public ArrayList<Room> userRooms(User user) {
        ArrayList<Room> userRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getUsers().contains(user))
                userRooms.add(room);
        }
        return userRooms;
    }
}
