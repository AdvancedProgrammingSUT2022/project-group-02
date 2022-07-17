package controller;

import model.User;

import java.util.HashMap;

public class ServerController {
    private HashMap<Integer, String> userPorts = new HashMap<>();



    public HashMap<Integer, String> getUserPorts() {
        return userPorts;
    }

    public void setUserPorts(HashMap<Integer, String> userPorts) {
        this.userPorts = userPorts;
    }
}
