package model;

import com.google.gson.*;

public class Request {
    private User user;
    private String message;
    private String menu;

    public static Request fromJson(String json) {
        return new Gson().fromJson(json, Request.class);
    }
}
