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
        switch (request.getMenu()) {
            case "register menu" :
                if (request.getAction().equals("signup"))
                    return signup(request);
                else
                    return login(request);
            case "main menu" :

            case "profile menu":
                if (request.getAction().equals("change password"))
                    return changePassword(request);
                else
                    return changeNickname(request);

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
        String username = (String)request.getParameters().get("username");
        String nickname = (String)request.getParameters().get("nickname");
        String password = (String)request.getParameters().get("password");
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
        Response response = new Response();
        String username = (String)request.getParameters().get("username");
        String password = (String)request.getParameters().get("password");
        User user;
        if ((user = UsersController.getInstance().getUserByUsername(username)) != null) {
            if (user.getPassword().equals(password)) {
                response.setStatusCode("200");
                response.setMessage("user logged in successfully!");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("user", user);
                response.setParameters(parameters);
                return response;
            }
        }
        response.setStatusCode("404");
        response.setMessage("Username and password didn't match!");

        return response;
    }

    private Response changePassword(Request request) {
        Response response = new Response();
        String oldPassword = (String)request.getParameters().get("old password");
        String newPassword = (String)request.getParameters().get("new password");
        String username = (String)request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        if (user.getPassword().equals(oldPassword)) {
            if (!oldPassword.equals(newPassword)) {
                user.setPassword(newPassword);
                response.setMessage("password changed successfully!");
                response.setStatusCode("200");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("user", user);
                response.setParameters(parameters);
                return response;
            }
            else {
                //old and new are the same;
                response.setStatusCode("401");
                response.setMessage("please enter a new password");
            }
        }
        else {
            //old password is not correct;
            response.setStatusCode("404");
            response.setMessage("current password is invalid");
        }
        return response;
    }

    private Response changeNickname(Request request) {
        Response response = new Response();
        String newNickname = (String)request.getParameters().get("new nickname");
        String username = (String)request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        if (!UsersController.getInstance().sameNicknameExists(newNickname)) {
            user.setNickname(newNickname);
            response.setStatusCode("200");
            response.setMessage("nickname changed successfully!");
        }
        else {
            response.setStatusCode("401");
            response.setMessage("user with nickname " + newNickname + " already exists");
        }
        return response;
    }

}
