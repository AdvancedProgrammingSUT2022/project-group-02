package view;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.ChatController;
import controller.NetworkController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Message;
import model.Request;
import model.Response;

import java.io.IOException;
import java.util.ArrayList;

public class ChatPage {

    private int chatId;

    @FXML
    public VBox messagesList;

    @FXML
    public TextField newMessageField;

    public ChatPage(int chatId) {
        this.chatId = chatId;
    }

    public static void run(int chatId) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("chat-page.fxml"));
        ChatPage controller = new ChatPage(chatId);
        loader.setController(controller);
        Scene scene = new Scene(loader.load(), 400, 600);
        //SceneController.push(scene, controller);
    }

    public void initialize() {
        Request request = new Request();
        request.setAction("get_messages");
        Response response = NetworkController.getInstance().sendRequest(request);
        String messagesJson = new Gson().toJson(response.getMessage());
        ArrayList<Message> messages = new Gson().fromJson(messagesJson, new TypeToken<ArrayList<Message>>(){}.getType());
        //ChatController.setMessagesOfChat(chatId, messages);
        showMessages();
        newMessageField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().getCode() == 10) {
                Request request1 = new Request();
                request1.setAction("send");
                //request1.addData("text", newMessageField.getText());
                //request1.addData("chatId", chatId);
                //NetworkController.se(request1);
                //ChatController.addNewMessage(newMessageField.getText(), chatId);
                newMessageField.setText("");
                showMessages();
            }
        });
    }

    public void showMessages() {
        messagesList.getChildren().clear();
        //ArrayList<Message> messages = ChatController.getMessagesOfChat(chatId);
//        for (Message message : messages) {
//            int senderId = message.getSenderId();
//            HBox holder = new HBox();
//            Label text = new Label();
//            text.setText(message.getText());
//            holder.getChildren().add(text);
//            if (senderId != chatId) {
//                text.setStyle("-fx-background-color: #effdde; -fx-padding: 12; -fx-background-radius: 12");
//                holder.setAlignment(Pos.CENTER_RIGHT);
//            } else {
//                text.setStyle("-fx-background-color: #ffffff; -fx-padding: 12; -fx-background-radius: 12");
//                holder.setAlignment(Pos.CENTER_LEFT);
//            }
//            messagesList.getChildren().add(holder);
//        }
    }

   // public void backClicked() {
//        SceneController.pop();
//    }
}
