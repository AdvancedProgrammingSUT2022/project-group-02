package view;

import model.Response;
import model.User;

import java.util.ArrayList;

public class Notifications {

    public static ArrayList<String> sendNotificationToInvader(User first, User second) {
        ArrayList<String> notification = new ArrayList<>();
        ArrayList<String> responseNotifications = new ArrayList<>();
        responseNotifications.add(view.enums.Colors.RED + "NOTICE!!!" + view.enums.Colors.RESET);
        notification.add(view.enums.Colors.RED + "NOTICE!!!" + view.enums.Colors.RESET);
        responseNotifications.add(view.enums.Colors.PURPLE + "Dear " + first.getUsername() + view.enums.Colors.RESET);
        notification.add(view.enums.Colors.PURPLE + "Dear " + first.getUsername() + view.enums.Colors.RESET);
        responseNotifications.add(view.enums.Colors.YELLOW + "you have started a war with " + second.getUsername() + view.enums.Colors.RESET);
        notification.add(view.enums.Colors.YELLOW + "you have started a war with " + second.getUsername() + view.enums.Colors.RESET);
        first.addHistoryOfNotification(notification);
        return responseNotifications;
    }

    public static ArrayList<String> sendNotificationToDefender(User first, User second) {
        ArrayList<String> notification = new ArrayList<>();
        ArrayList<String> responseNotifications = new ArrayList<>();
        responseNotifications.add(view.enums.Colors.RED + "NOTICE!!!" + view.enums.Colors.RESET);
        notification.add(view.enums.Colors.RED + "NOTICE!!!" + view.enums.Colors.RESET);
        responseNotifications.add(view.enums.Colors.PURPLE + "Dear " + second.getUsername() + view.enums.Colors.RESET);
        notification.add(view.enums.Colors.PURPLE + "Dear " + second.getUsername() + view.enums.Colors.RESET);
        responseNotifications.add(view.enums.Colors.YELLOW + "User : " + first.getUsername() + " have attacked you!" + view.enums.Colors.RESET);
        notification.add(view.enums.Colors.YELLOW + "User : " + first.getUsername() + " have attacked you!" + view.enums.Colors.RESET);
        second.addHistoryOfNotification(notification);
        return responseNotifications;
    }
}
