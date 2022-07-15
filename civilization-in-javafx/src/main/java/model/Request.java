package model;

import com.google.gson.*;

public class Request {
    private User user;
    private String message;
    private String menu;


    public String toJson(Request request) {
        return new Gson().toJson(request, Request.class);
    }
}
