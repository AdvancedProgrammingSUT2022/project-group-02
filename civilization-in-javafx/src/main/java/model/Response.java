package model;

import com.google.gson.*;

import java.util.HashMap;

public class Response {
    private String statusCode;
    private String message;
    private HashMap<String, Object> parameters = new HashMap<>();

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

    public static Response fromJson(String json) {
        return new Gson().fromJson(json, Response.class);
    }
}
