import controller.UsersController;
import view.RegisterMenu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner("5\n6");
        Scanner scanner = new Scanner(System.in);
        new RegisterMenu().run(scanner, new UsersController());
    }
}
