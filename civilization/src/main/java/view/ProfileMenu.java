package view;

import controller.Users;
import enums.RegexEnums;
import model.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileMenu {
    public void run(Users users, User user, Scanner scanner) {
        String input;
        Matcher matcher;
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
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_NICKNAME1)) != null) {
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
                    (matcher = RegexEnums.getMatcher(input, RegexEnums.CHANGE_PASSWORD1)) != null) {
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
