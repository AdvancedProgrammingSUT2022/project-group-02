package model;

import com.google.gson.*;

public class Response {
    private String statusCode;
    private String message;

    public static Response fromJson(String json) {
        return new Gson().fromJson(json, Response.class);
    }
}
