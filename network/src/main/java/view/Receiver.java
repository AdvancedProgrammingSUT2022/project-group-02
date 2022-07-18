package view;

import controller.GameController;
import controller.UsersController;
import model.Request;
import model.Response;
import model.Unit;
import model.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

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
        /*
        if (request.getMenu().equals("register menu")) {
            if (request.getAction().equals("signup"))
                return UsersController.getInstance().signup(request);
            else
                return UsersController.getInstance().login(request);
        }
        else if (request.getMenu().equals("profile menu")) {
            if (request.getAction().equals("change password"))
                return UsersController.getInstance().changePassword(request);
            else
                return UsersController.getInstance().changeNickname(request);
        }
        else {
            return null;
        }
        */

        switch (request.getMenu()) {
            case "register menu" :
                if (request.getAction().equals("signup"))
                    return UsersController.getInstance().signup(request);
                else
                    return UsersController.getInstance().login(request);


            case "profile menu":
                if (request.getAction().equals("change password"))
                    return UsersController.getInstance().changePassword(request);
                else
                    return UsersController.getInstance().changeNickname(request);


            case "play game" :
                if (request.getAction().equals("next turn"))
                    return GameController.getInstance().nextTurn(request);
        }
        return null;

    }



}
