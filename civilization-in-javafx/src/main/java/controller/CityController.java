package controller;


import model.*;

import java.util.HashMap;

public class CityController {
    private static CityController cityController;

    public static CityController getInstance() {
        if (cityController == null)
            cityController = new CityController();
        return cityController;
    }

    public void createCity(Tile origin, User user, Maps map) {
        System.out.println(map);
        System.out.println(origin.getX());
        Request request = new Request();
        int xDestination = origin.getX();
        int yDestination = origin.getY();
        request.setMenu("tile menu");
        request.setAction("place city");
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("xDestination", xDestination);
        parameters.put("yDestination", yDestination);
        parameters.put("username", user.getUsername());
        request.setParameters(parameters);
        Response response = NetworkController.getInstance().sendRequest(request);

        System.out.println(response.getMessage());
    }
}
