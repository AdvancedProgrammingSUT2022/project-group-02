package view;

import controller.*;
import model.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Receiver {
    private Maps map;
    public void run(int SERVER_PORT) {
        Maps map = new MapMaker().myTiles();
        this.map = map;
        readFromJson();

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
                        UsersController.getInstance().writeToJson();
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
                switch (request.getAction()) {
                    case "next turn":
                        return GameController.getInstance().nextTurn(request);
                    case "increase turn":
                        return GameController.getInstance().increaseTurnRequest(request);
                    case "increase gold":
                        return GameController.getInstance().increaseGoldRequest(request);
                    case "increase food":
                        return GameController.getInstance().increaseFoodRequest(request);
                    case "increase faith":
                        return GameController.getInstance().increaseFaithRequest(request);
                    case "increase science":
                        return GameController.getInstance().increaseScienceRequest(request);
                    case "increase capital citizens":
                        return GameController.getInstance().increaseCapitalCitizensRequest(request);
                    case "increase capital defence":
                        return GameController.getInstance().increaseCapitalDefenceRequest(request);
                    case "increase culture":
                        return GameController.getInstance().increaseCultureRequest(request);
                    case "increase happiness":
                        return GameController.getInstance().increaseHappinessRequest(request);
                    case "decrease research turn":
                        return GameController.getInstance().decreaseResearchTurnRequest(request);
                    case "select tile":
                        return GameController.getInstance().selectTileRequest(request);
                }
            case "tile menu":
                switch(request.getAction()) {
                    case "move unit":
                        return MapController.getInstance().moveUnitConditions(map, request);
                    case "place city":
                        return CityController.getInstance().conditionsForPlaceCity(request, map);
                    case "attack city":
                        return CityController.getInstance().conditionForAttackCity(request, map);
                    case "decision on what to do with city":
                        return CombatController.getInstance().decisionOnWhatDoDo(request, map);
                    case "attack unit":
                        return CombatController.getInstance().conditionForAttackUnit(request, map);
                }
        }
        return null;

    }

    private void readFromJson() {
        ArrayList<User> users = UsersController.getInstance().readFromJson();
        UsersController.getInstance().setUsers(users);
    }

}
