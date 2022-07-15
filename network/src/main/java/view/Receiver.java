package view;

import controller.UsersController;
import model.Request;
import model.Response;
import model.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {

    public void run(int SERVER_PORT) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        while (true) {
                            String input = dataInputStream.readUTF();
                             dataOutputStream.writeUTF(process(Request.fromJson(input)).toJson());
                             dataOutputStream.flush();
                            //process input then call dataOutputStream.writeUTF();
                        }

                    } catch (IOException e) {
                        System.out.println("client disconnected!");
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Response process(Request request) {
        switch (request.getMenu()) {
            case "register menu" :
                if (request.getAction().equals("signup"))
                    return signup(request);
                else
                    return login(request);
            case "main menu" :

            case "profile menu":

            case "game menu" :

            case "city menu" :

            case "research menu" :

            case "play game menu" :

            case "chat menu" :

            default:
                return null;
        }
    }

    private Response signup(Request request) {
        Response response = new Response();
        String username = request.getParameters().get("username");
        String nickname = request.getParameters().get("nickname");
        String password = request.getParameters().get("password");
        if (!UsersController.getInstance().sameUsernameExists(username)) {
            if (!UsersController.getInstance().sameNicknameExists(nickname)) {
                User user = new User(username, nickname, password);
                UsersController.getInstance().addUser(user);

                response.setMessage("user created successfully!");
            }
            else {

                response.setMessage("user with this nickname " + nickname + " already exists");
            }
        }
        else {
            response.setMessage("user with this username " + username + " already exists");
        }
        return response;
    }

    private Response login(Request request) {
        return null;
    }
}
