import controller.Users;
import view.PlayGame;
import view.RegisterMenu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new RegisterMenu().run(scanner, new Users());
    }
}
