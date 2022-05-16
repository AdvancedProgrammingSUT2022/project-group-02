package view;

import controller.ColorsController;
import controller.GameController;
import view.enums.Colors;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPanel {
    private GameController gameController;
    private final ColorsController colorsController = new ColorsController();

    public UserPanel(GameController gameController) {
        this.gameController = gameController;
    }

    public void run(Scanner scanner, User user) {
        System.out.println("welcome to user panel dear " + colorsController.getColorOfUser(user) + user.getUsername() + Colors.RESET);
        System.out.println(Colors.YELLOW + "to see history of notification press -show history-");
        System.out.println("to see military information and overview press -military overview-");
        System.out.println("to see all the details about units press -unit panel-");
        System.out.println("to see notification history press -show history-");
        System.out.println("to see economic information and overview press -economic overview-" + Colors.RESET);
        String userInput;
        while (true){
            userInput = scanner.nextLine();
            if (userInput.equals("user exit"))
                return;
            else if (userInput.equals("show history")) {
                if (user.getHistoryOfNotification() != null) {
                    for (ArrayList<String> notifications : user.getHistoryOfNotification()) {
                        for (String notification : notifications) {
                            System.out.println(notification);
                        }
                    }
                }
            }
            else if (userInput.equals("military overview")) {
                militaryOverview(user);
            }
            else if (userInput.equals("economic overview")) {
                economicOverview(user);
            }
            else if (userInput.equals("unit panel")) {
                unitPanel(user);
            }
            else
                System.out.println("invalid command");
        }
    }

    private void militaryOverview(User user) {
        System.out.println(user.getUsername() + " have " + user.getUnits().size() + " units");
        if (user.getUnits() != null && user.getUnits().size() > 0) {
            int numberOfWorkers = 0;
            int numberOfSettlers = 0;
            int numberOfScout = 0;
            for (Unit unit : user.getUnits()) {
                if (unit.getName().equals("worker")) numberOfWorkers++;
                if (unit.getName().equals("settler")) numberOfSettlers++;
                if (unit.getName().equals("scout")) numberOfScout++;
                // all information of the unit
                unitInformation(unit);
            }
            int numberOfMilitary = user.getUnits().size() - (numberOfSettlers + numberOfWorkers + numberOfScout);
            System.out.println(numberOfMilitary + " of this units are military units");
            System.out.println(numberOfWorkers + " of this units are workers");
            System.out.println(numberOfSettlers + " of this units are settlers");
            System.out.println(numberOfScout + " of this units are scout");
        }
        else
            System.out.println("user do not have any unit");
    }

    private void economicOverview(User user) {
        System.out.println("Dear " + colorsController.getColorOfUser(user) + user.getUsername() + Colors.RESET);
        System.out.println(Colors.GREEN + "Gold per turn : " + user.getGoldPerTurn());
        System.out.println("Production per turn : " + user.getProductPerTurn());
        System.out.println("Food per turn : " + user.getFoodPerTurn() + Colors.RESET);
    }

    private void unitPanel(User user) {
        System.out.println("welcome to unit panel");
        if (user.getUnits() != null) {
            System.out.println("**********");
            for (Unit unit : user.getUnits()) {
                unitInformation(unit);
                System.out.println("**********");
            }
        }
    }

    private void unitInformation(Unit unit) {
        System.out.println("Name : " + unit.getName());
        if (!unit.getName().equals("worker") && !unit.getName().equals("scout") && !unit.getName().equals("settler"))
            System.out.println("this unit is military");
        else
            System.out.println("this unit is civilian");
        System.out.println("Position : -x " + unit.getTile().getX() + " -y " + unit.getTile().getY());
        System.out.println("Health point : " + unit.getHP());
        System.out.println("Movement point : " + unit.getMP());
        System.out.println("Level : " + unit.getLevel());
        System.out.println("Combat Strength : " + unit.getCombatStrength());
        System.out.println("Ranged Combat Strength : " + unit.getRangeCombatStrength());
        System.out.println("Cost of maintain : " + unit.getMaintainGold());
    }

    public static void researchDoneNotification(User user, Technology technology) {
        ColorsController colorsController = new ColorsController();
        ArrayList<String> notification = new ArrayList<>();
        System.out.println(Colors.RED + "NOTICE!!!" + Colors.RESET);
        notification.add(Colors.RED + "NOTICE!!!" + Colors.RESET);
        System.out.println("Dear " + colorsController.getColorOfUser(user) + user.getUsername() + Colors.RESET);
        notification.add("Dear " + colorsController.getColorOfUser(user) + user.getUsername() + Colors.RESET);
        System.out.println("you have completed research on " + colorsController.getColorOfUser(user)
                + technology.getName() + Colors.RESET);
        notification.add("you have completed research on " + colorsController.getColorOfUser(user)
                + technology.getName() + Colors.RESET);
        if (technology.getGivenImprovement() != null) {
            System.out.println("this technology will enable you to work on this improvements :");
            notification.add("this technology will enable you to work on this improvements :");
            for (Improvement improvement : technology.getGivenImprovement()) {
                System.out.println(Colors.BLUE + "Improvement name : " + improvement.getName());
                notification.add(Colors.BLUE + "Improvement name : " + improvement.getName());
                System.out.println("Food rate : " + improvement.getFoodRate());
                notification.add("Food rate : " + improvement.getFoodRate());
                System.out.println("Production rate : " + improvement.getProductionRate());
                notification.add("Production rate : " + improvement.getProductionRate());
                System.out.println("Gold rate : " + improvement.getGoldRate());
                notification.add("Gold rate : " + improvement.getGoldRate());
                System.out.println("price : " + improvement.getPrice() + Colors.RESET);
                notification.add("price : " + improvement.getPrice() + Colors.RESET);
                improvementResourceNotification(improvement, notification);
            }
        }
        if (technology.getGivenUnits() != null) {
            System.out.println("this technology will enable you to build this units :");
            notification.add("this technology will enable you to build this units :");
            for (Unit givenUnit : technology.getGivenUnits()) {
                unitNotification(notification, givenUnit);
            }
        }
        // add this notification to the history
        user.addHistoryOfNotification(notification);
    }
    public static void improvementDoneNotification(User user, Improvement improvement) {
        ColorsController colorsController = new ColorsController();
        ArrayList<String> notification = new ArrayList<>();
        System.out.println(Colors.RED + "NOTICE!!!" + Colors.RESET);
        notification.add(Colors.RED + "NOTICE!!!" + Colors.RESET);
        System.out.println("Dear " + colorsController.getColorOfUser(user) + user.getUsername() + Colors.RESET);
        notification.add("Dear " + colorsController.getColorOfUser(user) + user.getUsername() + Colors.RESET);
        System.out.println("you have completed working on " + colorsController.getColorOfUser(user) + improvement.getName() + Colors.RESET);
        notification.add("you have completed working on " + colorsController.getColorOfUser(user) + improvement.getName() + Colors.RESET);
        System.out.println(Colors.YELLOW + "this improvement will give you : ");
        notification.add(Colors.YELLOW + "this improvement will give you : ");
        System.out.println("Food rate : " + improvement.getFoodRate());
        notification.add("Food rate : " + improvement.getFoodRate());
        System.out.println("Production rate : " + improvement.getProductionRate());
        notification.add("Production rate : " + improvement.getProductionRate());
        System.out.println("Gold rate : " + improvement.getGoldRate() + Colors.RESET);
        notification.add("Gold rate : " + improvement.getGoldRate() + Colors.RESET);
        improvementResourceNotification(improvement, notification);
        user.addHistoryOfNotification(notification);
    }

    private static void improvementResourceNotification(Improvement improvement, ArrayList<String> notification) {
        if (improvement.getGivenResources() != null) {
            for (Resource resource : improvement.getGivenResources()) {
                System.out.println(Colors.GREEN + "Resource name : " + resource.getName());
                notification.add(Colors.GREEN + "Resource name : " + resource.getName());
                System.out.println("Resource type : " + resource.getResourceType());
                notification.add("Resource type : " + resource.getResourceType());
                System.out.println("Food rate : " + resource.getFoodRate());
                notification.add("Food rate : " + resource.getFoodRate());
                System.out.println("Production rate : " + resource.getProductionRate());
                notification.add("Production rate : " + resource.getProductionRate());
                System.out.println("Gold rate : " + resource.getGoldRate() + Colors.RESET);
                notification.add("Gold rate : " + resource.getGoldRate() + Colors.RESET);
            }
        }
    }

    public static void productDoneNotification(User user, City city, Unit unit, GameController gameController) {
        ArrayList<String> notification = new ArrayList<>();
        System.out.println(Colors.RED + "NOTICE!!!" + Colors.RESET);
        notification.add(Colors.RED + "NOTICE!!!" + Colors.RESET);
        System.out.println("Dear " + user.getColor() + user.getUsername() + Colors.RESET);
        notification.add("Dear " + user.getColor() + user.getUsername() + Colors.RESET);
        System.out.println("you have completed producing " + user.getColor() + unit.getName() + Colors.RESET);
        notification.add("you have completed producing " + user.getColor() + unit.getName() + Colors.RESET);
        System.out.println("Unit coordinate : -x " + unit.getTile().getX() + " -y " + unit.getTile().getY());
        unitNotification(notification, unit);
        user.addHistoryOfNotification(notification);
    }

    private static void unitNotification(ArrayList<String> notification, Unit unit) {
        System.out.println(Colors.PURPLE + "Unit name : " + unit.getName());
        notification.add(Colors.PURPLE + "Unit name : " + unit.getName());
        System.out.println("Unit product price : " + unit.getProductionPrice());
        notification.add("Unit product price : " + unit.getProductionPrice());
        System.out.println("Unit gold price : " + unit.getGoldPrice());
        notification.add("Unit gold price : " + unit.getGoldPrice());
        System.out.println("Maintain price : " + unit.getMaintainGold());
        notification.add("Maintain price : " + unit.getMaintainGold());
        System.out.println("Combat strength : " + unit.getCombatStrength());
        notification.add("Combat strength : " + unit.getCombatStrength());
        System.out.println("Ranged combat strength : " + unit.getRangeCombatStrength());
        notification.add("Ranged combat strength : " + unit.getRangeCombatStrength());
        System.out.println("Movement point : " + unit.getMP() + Colors.RESET);
        notification.add("Movement point : " + unit.getMP() + Colors.RESET);
    }

    public void citizensIncreased(User user, City city){
        ArrayList<String> notification = new ArrayList<>();
        System.out.println(Colors.RED + "NOTICE!!!" + Colors.RESET);
        notification.add(Colors.RED + "NOTICE!!!" + Colors.RESET);
        System.out.println("Dear " + colorsController.getColorOfUser(user) + user.getNickname() + Colors.RESET);
        notification.add("Dear " + colorsController.getColorOfUser(user) + user.getNickname() + Colors.RESET);
        System.out.println("Citizens of your city: " + city.getName() + " increased");
        notification.add("Citizens of your city: " + city.getName() + " increased");
        user.addHistoryOfNotification(notification);
    }
}
