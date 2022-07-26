package view;

import controller.UsersController;
import model.Resource;
import model.Trade;
import model.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemocracyPanel {

    private Matcher matcher;

    public void run(Scanner scanner, User user) {
        String input;
        UserPanel.everyInformationAboutUser(user);
        System.out.println("**********");
        System.out.println("all of the users are as follows : ");
        for (User user1 : UsersController.getInstance().getUsers()) {
            UserPanel.everyInformationAboutUser(user1);
            System.out.println("**********");
        }

        while (true) {
            input = scanner.nextLine();
            if (input.equals("back")) {
                System.out.println("get back to play game panel");
                return;
            }
            else if ((matcher = getMatcher(input, "declare war against -u (?<username>[\\s\\S]+)")) != null) {
                String username = matcher.group("username");
                User other = UsersController.getInstance().getUserByUsername(username);
                declareWar(user, other);
            }
            else if ((matcher = getMatcher(input, "make peace with -u (?<username>[\\s\\S]+)")) != null) {
                String username = matcher.group("username");
                User other = UsersController.getInstance().getUserByUsername(username);
                makePeace(user, other);
            }
            else if ((matcher = getMatcher(input, "trade with -u (?<username>[\\s\\S]+)")) != null) {
                String username = matcher.group("username");
                User other = UsersController.getInstance().getUserByUsername(username);
                trade(user, other, scanner);
            }
            else
                System.out.println("invalid command!");

        }
    }

    private Matcher getMatcher(String input, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.matches())
            return matcher;
        return null;
    }

    private void declareWar(User you, User other) {
        if (you.getEnemies().contains(other))
            System.out.println("you are already enemies");
        else
            you.addEnemy(other);
    }
    private void makePeace(User you, User other) {
        System.out.println("press -gold- to get gold and index to get resources, back to exit");
        if (you.getEnemies().contains(other))
            System.out.println("this user is not one of your enemies");
        else
            you.getEnemies().remove(other);
    }
    private void trade(User you, User other, Scanner scanner) {

        Trade trade = new Trade();
        trade.setUser(other);

        System.out.println("Gold : " + other.getGold());
        System.out.println("*********");
        int index = 1;
        System.out.println(other.getUsername() + " have these resources");
        for (Resource foundResource : other.getFoundResources()) {
            System.out.println(index + "- " + foundResource.getName());
            index++;
        }

        String input;


        while (true) {
            input = scanner.nextLine();
            if (input.equals("back")) {
                System.out.println("get back to democracy panel");
                return;
            }
            else if (input.equals("gold")) {
                //todo trade gold
                trade.setTypeOfImport("gold");
                trade.setImportingObject(howMuchOrMany(scanner, other.getGold()));
                break;
            }
            else if (Pattern.matches("\\d+", input)) {
                index = Integer.parseInt(input);
                if (index >= 1 && index <= other.getFoundResources().size()) {
                    //now you have your desired resource lets see what you wanna do in return
                    Resource resource = other.getFoundResources().get(index - 1);
                    trade.setTypeOfImport("resource");
                    trade.setImportingObject(resource);
                    break;
                }
                else
                    System.out.println("invalid index");
            }
            else
                System.out.println("invalid command");
        }

        index = 1;
        System.out.println("Gold : " + you.getGold());
        System.out.println("**********");

        System.out.println("you have these resources");
        for (Resource foundResource : you.getFoundResources()) {
            System.out.println(index + "- " + foundResource.getName());
            index++;
        }

        while (true) {
            input = scanner.nextLine();
            if (input.equals("back")) {
                System.out.println("back to choose other resource");
                break;
            }
            else if (input.equals("gold")) {
                //todo trade gold
                trade.setTypeOfExport("gold");
                trade.setExportingObject(howMuchOrMany(scanner, you.getGold()));
            }
            else if (Pattern.matches("\\d+", input)) {
                //lets trade
                index = Integer.parseInt(input);
                if (index >= 1 && index <= you.getFoundResources().size()) {
                    Resource resource = you.getFoundResources().get(index - 1);
                    trade.setTypeOfExport("resource");
                    trade.setExportingObject(resource);
//                    you.addTrade(trade);
                }
                else
                    System.out.println("invalid index you idiot");
            }
            else
                System.out.println("invalid command");
        }
    }

    private int howMuchOrMany(Scanner scanner, int limit) {
        String input;
        System.out.println("there is no escaping, just enter numbers");
        System.out.println("not bigger than : " + limit);
        while (true) {
            input = scanner.nextLine();

            if (Pattern.matches("\\d+", input)) {
                int numberOfExpected = Integer.parseInt(input);
                if (numberOfExpected >= 0 && numberOfExpected <= limit) {
                    System.out.println("accepted : " + numberOfExpected);
                    return numberOfExpected;
                }
                else
                    System.out.println("fucking invalid number you idiot");
            }
            else
                System.out.println("invalid command you idiot");

        }
    }

    private void makeTrade(User you, Trade trade) {
        //fuck
    }
}
