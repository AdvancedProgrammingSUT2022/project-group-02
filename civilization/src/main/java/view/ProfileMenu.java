package view;

import controller.ColorsController;
import controller.UsersController;
import enums.Colors;
import enums.RegexEnums;
import model.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileMenu {
    //provide some information for user
    private void manProfileMenu(User user) {
        String userColor = new ColorsController().getColorOfUser(user);
        String boldColor = Colors.YELLOW_BOLD;
        String color = Colors.CYAN;
        System.out.println("welcome to Profile Menu dear " + userColor + user.getUsername() + Colors.RESET + "!");
        System.out.println(boldColor + "to change nickname :" + Colors.RESET);
        System.out.println(color + "profile change --nickname <new nickname>");
        System.out.println("profile change -n <new nickname" + Colors.RESET);
        System.out.println(boldColor + "to change password :" + Colors.RESET);
        System.out.println(color + "profile change --password --current <current password> --new <new password>");
        System.out.println("profile change -p -c <current password> -n <new password>" + Colors.RESET);
    }
    public void run(UsersController users, User user, Scanner scanner) {
        String input;
        Matcher matcher;
        manProfileMenu(user);
        while (true) {
            input = scanner.nextLine();
            //exit
            if (Pattern.matches("\\s*menu\\s+exit\\s*", input))
                return;
                //show current menu
            else if (Pattern.matches("\\s*menu\\s+show-current\\s*", input))
                System.out.println("Profile");
                //change the nickname
            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_NICKNAME1)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_NICKNAME2)) != null) {
                String nickname = matcher.group("nickname");
                if (users.sameNicknameExists(nickname)) {
                    user.setNickname(nickname);
                    System.out.println("nickname changed successfully!");
                }
                else
                    System.out.println("user with nickname " + nickname + " already exists");
            }
            //change the password
            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_PASSWORD1)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_PASSWORD2)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_PASSWORD3)) != null ||
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_PASSWORD4)) != null) {
                String currentPassword = matcher.group("currentPassword");
                String newPassword = matcher.group("newPassword");
                //if the current username has entered correctly
                if (user.getPassword().equals(currentPassword)) {
                    //if two username are not the same
                    if (!newPassword.equals(currentPassword)) {
                        user.setPassword(newPassword);
                        System.out.println("password changed successfully!");
                    }
                    else
                        System.out.println("please enter a new password");
                }
                else
                    System.out.println("current password is invalid");
            }
        }
    }
}
