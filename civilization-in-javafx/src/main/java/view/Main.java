package view;

import controller.UsersController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Graphic parts
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new RegisterMenu().run(scanner, new UsersController());
        //launch();
    }
}