package model;

import com.google.gson.*;

public class Response {
    private String statusCode;
    private String message;


    public String toJson(Response response) {
        return new Gson().toJson(response);
    }
}
