package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Technology;
import model.User;

import java.io.FileWriter;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Users {
    //arraylist of registered users;
    private ArrayList<User> users;

    public Users() {
        users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    //add user
    public void addUser(User user) {
        users.add(user);
    }
    //if same username exists among the users or not
    public boolean sameUsernameExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return true;
        }
        return false;
    }
    //if same nickname exists among the users or not
    public boolean sameNicknameExists(String nickname) {
        for (User user : users) {
            if (user.getNickname().equals(nickname))
                return false;
        }
        return true;
    }
    //get user by username
    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }
    // read the information of users from .json file
    public ArrayList<User> readFromJson() {
        try {
            String usersJson = new String(Files.readAllBytes(Paths.get("usersInformation.json")));
            ArrayList<User> usersFromJson = new Gson().fromJson(usersJson, new TypeToken<List<User>>(){}.getType());
            if (usersFromJson != null)
                return usersFromJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // write the information of users to .json file
    public void writeToJson() {
        try {
            FileWriter WriterToJson = new FileWriter("usersInformation.json");
            if (users.size() > 0)
                WriterToJson.write(new Gson().toJson(users));
            WriterToJson.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // read the graph and prerequisites
    public int[][] readFromJsonGraph() {
        try {
            String all = new String(Files.readAllBytes(Paths.get("TechFile/graph.json")));
            return new Gson().fromJson(all, int[][].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // read all technologies
    public ArrayList<Technology> readFromJsonTech() {
        try {
            String all = new String(Files.readAllBytes(Paths.get("TechFile/tech.json")));
            return new Gson().fromJson(all, new TypeToken<List<Technology>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
