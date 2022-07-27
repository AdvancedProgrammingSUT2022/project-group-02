package controller;

import model.*;

import java.util.ArrayList;

public class ChatController {

    private static ChatController chatController;


    private ArrayList<PrivateChat> privateChats;
    private ArrayList<Room> rooms;
    private ArrayList<Message> messages;
    private ChatController() {
        privateChats = new ArrayList<>();
        rooms = new ArrayList<>();
        messages = new ArrayList<>();
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

    public Response addMessageToHistory(Request request) {
        Response response = new Response();
        User sender = request.getMessageObject().getSender();
        User receiver = request.getMessageObject().getReceivers().get(0);
        Message message = request.getMessageObject();
        sender.addSentMessages(message);
        receiver.addMessage(message);
        response.setMessage("message added to chat");
        return response;
    }

    public Response getMessagesOfThisChat(Request request) {
        Response response = new Response();
        User sender = request.getMessageObject().getSender();
        User receiver = request.getMessageObject().getReceivers().get(0);
        ArrayList<Message> messageArrayList = new ArrayList<>();
        if (sender.getSentMessages() != null) {
            for (Message message : sender.getSentMessages()) {
                if (message.getReceivers().contains(receiver)) {
                    messageArrayList.add(message);
                }
            }
        }
        if (receiver.getSentMessages() != null) {
            for (Message message : receiver.getSentMessages()) {
                if (message.getReceivers().contains(sender)) {
                    messageArrayList.add(message);
                }
            }
        }
        //return messageArrayList;
        response.setMessage("chat messages: ");
        response.setMessageArrayList(messageArrayList);
        return response;
    }

    public Response removeMessageFromHistory(Request request) {
        Response response = new Response();
        Message message = request.getMessageObject();
        messages.remove(message);
        ArrayList<Message> newMessages;
        newMessages = message.getSender().getSentMessages();
        newMessages.remove(message);
        message.getSender().setSentMessages(newMessages);
        ArrayList<Message> newMessagesReceiver;
        newMessagesReceiver = message.getReceivers().get(0).getSeenMessages();
        newMessagesReceiver.remove(message);
        message.getReceivers().get(0).setSeenMessages(newMessagesReceiver);
        response.setMessage("message removed from this chat");
        return response;
    }

    public Response editAMessage(Request request){
        Response response = new Response();
        ArrayList<Message> messageArrayList = request.getMessageArrayList();
        messages.remove(messageArrayList.get(0));
        messages.add(messageArrayList.get(1));
        response.setMessage("message edited");
        return response;
    }

}
