package view;

import controller.ColorsController;
import controller.GameController;
import controller.TechController;
import enums.Colors;
import enums.RegexEnums;
import model.Improvement;
import model.Technology;
import model.Unit;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResearchMenu {

    private TechController techController;
    private GameController gameController;
    private Matcher matcher;

    public ResearchMenu(TechController techController, GameController gameController) {
        this.techController = techController;
        this.gameController = gameController;
    }

    public void run(Scanner scanner, User user) {
        System.out.println("welcome to research panel dear " + user.getUsername());
        String researchInput;
        if (user.getTechnologies() != null) {
            System.out.println("player has done this technologies");
            for (Technology technology : user.getTechnologies()) {
                System.out.println(technology.getName());
            }
        }
        while (true) {
            researchInput = scanner.nextLine();
            if (researchInput.equals("research exit"))
                return;
            else if (researchInput.equals("select technology")) {
                selectTech(user, scanner);
            }
            else if (researchInput.equals("show tree of technologies")) {
                showTree(user, scanner);
            }
        }
    }

    public void selectTech(User user, Scanner scanner) {

        ArrayList<Technology> technologies = techController.getUserResearches(user);
        int index = 1;
        for (Technology technology : technologies) {
            System.out.println(index + "- " + technology.getName());
            if (technology.getGivenImprovement() != null) {
                System.out.println("given improvements : ");
                for (Improvement improvement : technology.getGivenImprovement())
                    System.out.println("name: " + improvement.getName() + " | production: " + improvement.getProductionRate() + " | food: " + improvement.getFoodRate() + " | gold: " + improvement.getGoldRate());

            }
        }
        System.out.println("choose an index | <tech exit> to get out");
        String techInput;
        while (true) {
            techInput = scanner.nextLine();
            if (techInput.trim().equals("tech exit"))
                return;
            else if (Pattern.matches("[\\d+]", techInput)) {
                index = Integer.parseInt(techInput);
                if (index >= 1 && index <= technologies.size()) {
                    // choose the tech and research on it
                    user.setResearching(true);
                    user.setCurrentTechnology(technologies.get(index - 1));
                    user.setResearchTurnLeft(technologies.get(index - 1).getSciencePrice());
                }
                else
                    System.out.println("invalid number");
            }
            // cheat code
            else if ((matcher = RegexEnums.getMatcher(techInput, RegexEnums.ADD_RESEARCH1)) != null || (matcher = RegexEnums.getMatcher(techInput, RegexEnums.ADD_RESEARCH2)) != null) {
                index = Integer.parseInt(matcher.group("index"));
                if (index >= 1 && index <= technologies.size()) {
                    user.setResearchTurnLeft(1);
                    user.setResearching(true);
                    user.setCurrentTechnology(technologies.get(index - 1));
                    gameController.userTurnResearch(user);
                }
                else
                    System.out.println("invalid number");
            }
            else
                System.out.println("invalid command");
        }
    }

    private void showTree(User user, Scanner scanner) {
        ArrayList<Technology> prerequisites;
        System.out.println("**********");
        for (Technology ancientTechnology : techController.getAncientTechnologies()) {
            System.out.println(ancientTechnology.getName() + " :");
            if (ancientTechnology.getGivenUnits() != null) {
                System.out.println("given units :");
                for (Unit givenUnit : ancientTechnology.getGivenUnits())
                    System.out.println(givenUnit.getName());

            }
            if (ancientTechnology.getGivenImprovement() != null) {
                System.out.println("given improvements :");
                for (Improvement improvement : ancientTechnology.getGivenImprovement())
                    System.out.println(improvement.getName());

            }
            prerequisites = techController.getPrerequisitesAncientTech(ancientTechnology);
            if (prerequisites.size() >= 1) {
                System.out.println("prerequisites :");
                for (Technology prerequisite : prerequisites)
                    System.out.println(prerequisite.getName());

            }
            else
                System.out.println("this technology do not have any prerequisites");
            System.out.println("**********");
        }
    }
}
