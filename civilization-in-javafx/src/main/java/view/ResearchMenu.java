package view;

import controller.GameController;
import controller.TechController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.*;
import view.enums.Images;
import view.enums.RegexEnums;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResearchMenu {

    private GameController gameController;
    private TechController techController;
    private Matcher matcher;
    private User user;
    private static Images images;

    public ResearchMenu(TechController techController, GameController gameController) {
        this.techController = techController;
        this.gameController = gameController;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setImages(Images images) {
        ResearchMenu.images = images;
    }

    public void run(Scanner scanner, User user) {
        System.out.println("welcome to research panel dear " + user.getUsername());
        System.out.println("to see technology tree press -show tree of technologies-");
        System.out.println("to research on a technology press -select technology-");
        System.out.println("cheat code in research bar is -add (--research | -r) <index> -");
        System.out.println("to terminate current tech press -terminate current-");
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
                showTree();
            }
            else if (researchInput.equals("pause current")) {
                if (user.isResearching()) {
                    user.setResearching(false);
                }
                else
                    System.out.println("you are not researching right now!");
            }
            else if (researchInput.equals("resume current")) {
                if (user.getCurrentTechnology() != null) {
                    user.setResearching(true);
                }
                else
                    System.out.println("you have not any research in queue");
            }
            else
                System.out.println("invalid command");
        }
    }

    public void selectTech(User user, Scanner scanner) {

        ArrayList<Technology> technologies = techController.getUserResearches(user);
        int index = 1;
        for (Technology technology : technologies) {
            System.out.println(index + "- " + technology.getName());
            //given units by this tech
            if (technology.getGivenUnits() != null) {
                System.out.println("given units :");
                for (Unit givenUnit : technology.getGivenUnits())
                    System.out.println(givenUnit.getName());

            }
            //given buildings by this tech
            if (technology.getGivenBuildings() != null) {
                System.out.println("given buildings :");
                for (Building building : technology.getGivenBuildings())
                    System.out.println(building.getName());

            }
            //given improvements by this tech
            if (technology.getGivenImprovement() != null) {
                System.out.println("given improvements : ");
                for (Improvement improvement : technology.getGivenImprovement())
                    System.out.println("name: " + improvement.getName() + " | production: " + improvement.getProductionRate() + " | food: " + improvement.getFoodRate() + " | gold: " + improvement.getGoldRate());

            }
            index++;
        }
        //selecting a tech to research on
        System.out.println("choose an index | <tech exit> to get out");
        String techInput;
        boolean researchBar = true;
        while (researchBar) {
            techInput = scanner.nextLine();
            if (techInput.trim().equals("bar exit"))
                researchBar = false;
            //standard code
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
                researchBar = false;
            }
            // cheat code
            else if ((matcher = RegexEnums.getMatcher(techInput, RegexEnums.ADD_RESEARCH1)) != null || (matcher = RegexEnums.getMatcher(techInput, RegexEnums.ADD_RESEARCH2)) != null) {
                index = Integer.parseInt(matcher.group("index"));
                if (index >= 1 && index <= technologies.size()) {
                    gameController.addTech(technologies.get(index - 1), user);
                    researchBar = false;
                }
                else
                    System.out.println("invalid number");
            }
            else if (techInput.equals("terminate current")) {

            }
            else
                System.out.println("invalid command");
        }
    }

    public void showTree() {
        ArrayList<Technology> prerequisites;
        System.out.println("**********");
        for (Technology technology : techController.getTechnologies()) {
            System.out.println(technology.getName() + " :");
            if (technology.getGivenUnits() != null) {
                System.out.println("given units :");
                for (Unit givenUnit : technology.getGivenUnits())
                    System.out.println(givenUnit.getName());

            }
            if (technology.getGivenBuildings() != null) {
                System.out.println("given buildings :");
                for (Building building : technology.getGivenBuildings())
                    System.out.println(building.getName());

            }
            if (technology.getGivenImprovement() != null) {
                System.out.println("given improvements :");
                for (Improvement improvement : technology.getGivenImprovement())
                    System.out.println(improvement.getName());

            }
            prerequisites = techController.getPrerequisitesTech(technology);
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

    public static void techInformation(Technology technology) {
        System.out.println(technology.getName() + " :");
        if (technology.getGivenUnits() != null) {
            System.out.println("given units :");
            for (Unit givenUnit : technology.getGivenUnits())
                System.out.println(givenUnit.getName());

        }
        if (technology.getGivenBuildings() != null) {
            System.out.println("given buildings :");
            for (Building building : technology.getGivenBuildings())
                System.out.println(building.getName());

        }
        if (technology.getGivenImprovement() != null) {
            System.out.println("given improvements :");
            for (Improvement improvement : technology.getGivenImprovement())
                System.out.println(improvement.getName());

        }
    }

    public void showGraphicTree(AnchorPane finalRoot) {
        ImageView X_Button = new ImageView(images.X_button);
        X_Button.setLayoutX(1465);
        X_Button.setLayoutY(8);
        X_Button.setFitWidth(60);
        X_Button.setFitHeight(60);
        X_Button.getStyleClass().add("top-bar-info-icon");
        Rectangle background = new Rectangle(0, 0, 1550, 1000);
        background.setFill(new Color(0, 0, 0, 0.9));
        finalRoot.getChildren().add(background);
        finalRoot.getChildren().add(X_Button);
        X_Button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            finalRoot.getChildren().remove(X_Button);
            finalRoot.getChildren().remove(background);
        });
    }
}
