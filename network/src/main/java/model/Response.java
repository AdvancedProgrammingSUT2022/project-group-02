package model;

import com.google.gson.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.graph.GraphAdapterBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class Response {
    private String statusCode;
    private String message;
    private HashMap<String, Object> parameters = new HashMap<>();
    private User user;
    private ArrayList<String> notifications = new ArrayList<>();
    private Tile tile;
    private Maps maps;

    public HashMap<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, Object> parameters) {
        this.parameters = parameters;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public String toJson2() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        GraphAdapterBuilder graphAdapterBuilder = new GraphAdapterBuilder();
        graphAdapterBuilder.registerOn(gsonBuilder);
        graphAdapterBuilder.addType(Tile.class);
        graphAdapterBuilder.addType(Citizen.class);
        graphAdapterBuilder.addType(City.class);
        graphAdapterBuilder.addType(Improvement.class);
        graphAdapterBuilder.addType(Message.class);
        graphAdapterBuilder.addType(Technology.class);
        graphAdapterBuilder.addType(Terrain.class);
        graphAdapterBuilder.addType(Unit.class);
        graphAdapterBuilder.addType(User.class);
        graphAdapterBuilder.addType(Ruin.class);
        graphAdapterBuilder.addType(PhysicalObject.class);
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(this));
        return gson.toJson(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<String> notifications) {
        this.notifications = notifications;
    }

    public void setTile(Tile tile){
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    public Maps getMaps() {
        return maps;
    }

    public void setMaps(Maps maps) {
        this.maps = maps;
    }
}
