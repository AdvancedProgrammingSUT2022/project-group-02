package controller;


import model.City;

public class CityController {
    private static CityController cityController;

    public static CityController getInstance() {
        if (cityController == null)
            cityController = new CityController();
        return cityController;
    }

    public void buyingTile(City city) {

    }
}
