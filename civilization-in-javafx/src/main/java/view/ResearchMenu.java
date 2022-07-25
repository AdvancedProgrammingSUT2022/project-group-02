package view;

import controller.GameController;
import controller.TechController;
import controller.UsersController;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import model.*;
import view.enums.Images;
import view.enums.RegexEnums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResearchMenu {

    private GameController gameController;
    private TechController techController;
    private Matcher matcher;
    private User user;
    private static final Images images = Images.getInstance();

    public ResearchMenu(TechController techController, GameController gameController) {
        this.techController = techController;
        this.gameController = gameController;
    }

    public void setUser(User user) {
        this.user = user;
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
            } else if (researchInput.equals("show tree of technologies")) {
                showTree();
            } else if (researchInput.equals("pause current")) {
                if (user.isResearching()) {
                    user.setResearching(false);
                } else
                    System.out.println("you are not researching right now!");
            } else if (researchInput.equals("resume current")) {
                if (user.getCurrentTechnology() != null) {
                    user.setResearching(true);
                } else
                    System.out.println("you have not any research in queue");
            } else
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
                } else
                    System.out.println("invalid number");
                researchBar = false;
            }
            // cheat code
            else if ((matcher = RegexEnums.getMatcher(techInput, RegexEnums.ADD_RESEARCH1)) != null || (matcher = RegexEnums.getMatcher(techInput, RegexEnums.ADD_RESEARCH2)) != null) {
                index = Integer.parseInt(matcher.group("index"));
                if (index >= 1 && index <= technologies.size()) {
                    gameController.addTech(technologies.get(index - 1), user);
                    researchBar = false;
                } else
                    System.out.println("invalid number");
            } else if (techInput.equals("terminate current")) {

            } else
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

            } else
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
        background.setFill(new Color(0.38, 0.83, .84, 0.9));
        finalRoot.getChildren().add(background);
        finalRoot.getChildren().add(X_Button);
        ArrayList<Technology> technologies = UsersController.getInstance().readFromJsonTech();
        HashMap<Technology, Integer> technologyHashMap = new HashMap<>();
        for (Technology technology : technologies) {
            technologyHashMap.put(technology, technology.getLevel());
        }
        AnchorPane techRoot = new AnchorPane();
        VBox vBox = new VBox();
        for (int i = 0; i < 12; i++) {
            HBox hBox = new HBox();
            for (Technology technology : technologies) {
                AnchorPane techPane = new AnchorPane();
                techPane.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Style.css")));
                if (technology.getLevel() == i) {
                    ImageView techBackground = findTechBackground(user, technology);
                    techBackground.setId("techBackground");
                    techPane.getChildren().add(techBackground);
                    ImageView techIcon = findTechIcon(technology);
                    techIcon.setId("techIcon");
                    techPane.getChildren().add(techIcon);
                    if (technology.getGivenBuildings() != null)
<<<<<<< HEAD
                        for (Building givenBuilding : technology.getGivenBuildings()) {
                            ImageView givenBuildingIcon = findBuildingIcon(givenBuilding);
                            givenBuildingIcon.setId("buildingIcon");
                            techPane.getChildren().add(givenBuildingIcon);
                        }
                    if (technology.getGivenUnits() != null)
                        for (Unit givenUnit : technology.getGivenUnits()) {
                            ImageView givenUnitIcon = findUnitIcon(givenUnit);
                            givenUnitIcon.setId("unitIcon");
                            techPane.getChildren().add(givenUnitIcon);
                        }
=======
                    for (Building givenBuilding : technology.getGivenBuildings()) {
                        ImageView givenBuildingIcon = findBuildingIcon(givenBuilding.getName());
                        givenBuildingIcon.setId("buildingIcon");
                        techPane.getChildren().add(givenBuildingIcon);
                    }
                    if (technology.getGivenUnits() != null)
                    for (Unit givenUnit : technology.getGivenUnits()) {
                        ImageView givenUnitIcon = findUnitIcon(givenUnit.getName());
                        givenUnitIcon.setId("unitIcon");
                        techPane.getChildren().add(givenUnitIcon);
                    }
>>>>>>> e76136f83b2969e7ac64890d2e3276503c5d9d9b
                    if (technology.getGivenImprovement() != null)
                        for (Improvement givenImprovement : technology.getGivenImprovement()) {
                            ImageView givenImprovementIcon = findImprovement(givenImprovement);
                            givenImprovementIcon.setId("improvementIcon");
                            techPane.getChildren().add(givenImprovementIcon);
                        }
                    if (user.getSciencePerTurn() == 0) user.setSciencePerTurn(1);
                    int turnLeft = technology.getSciencePrice() / user.getSciencePerTurn();
                    Label turnLeftLabel = new Label(turnLeft + " turn");
                    turnLeftLabel.setId("turnLeft");
                    Label name = new Label(technology.getName());
                    name.setId("name");
                    techPane.getChildren().add(turnLeftLabel);
                    techPane.getChildren().add(name);
                }
                initialiseTechBox(techPane);
                hBox.getChildren().add(techPane);
                hBox.setAlignment(Pos.TOP_CENTER);
            }
            vBox.getChildren().add(hBox);
            vBox.setSpacing(70);
        }
        techRoot.getChildren().add(vBox);
        techRoot.setOnScroll(event -> {
            techRoot.setTranslateX(techRoot.getTranslateX() + event.getDeltaX() / 3);
            techRoot.setTranslateY(techRoot.getTranslateY() + event.getDeltaY() / 3);
        });
        lineOfTree(techRoot);
        finalRoot.getChildren().add(techRoot);
        X_Button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            finalRoot.getChildren().remove(X_Button);
            finalRoot.getChildren().remove(background);
            finalRoot.getChildren().remove(techRoot);
        });
    }

    private void lineOfTree(AnchorPane techRoot) {
        Line line1 = new Line(970, 60, 485, 132);
        Line line2 = new Line(970, 60, 805, 132);
        Line line3 = new Line(970, 60, 1125, 132);
        Line line4 = new Line(970, 60, 1445, 132);
        Line line5 = new Line(485, 195, 155, 267);
        Line line6 = new Line(485, 195, 485, 267);
        Line line7 = new Line(805, 195, 805, 267);
        Line line8 = new Line(805, 195, 1125, 267);
        Line line9 = new Line(1445, 195, 1445, 267);
        Line line10 = new Line(1445, 195, 1765, 267);
        Line line11 = new Line(1125, 328, 1275, 402);
        Line line12 = new Line(485, 325, 1600, 402);
        Line line13 = new Line(1600, 460, 1600, 535);
        Line line14 = new Line(1600, 460, 330, 532);
        Line line15 = new Line(1600, 592, 650, 666);
        Line line16 = new Line(650, 725, 485, 800);
        Line line17 = new Line(650, 725, 815, 800);
        Line line18 = new Line(485, 857, 330, 930);
        Line line19 = new Line(485, 857, 1600, 930);
        Line line20 = new Line(1600, 990, 1445, 1063);
        Line line21 = new Line(1600, 990, 815, 1063);
        Line line22 = new Line(330, 570, 330, 670);
        Line line23 = new Line(330, 725, 815, 800);
        Line line24 = new Line(815, 858, 970, 930);
        Line line25 = new Line(970, 988, 815, 1063);
        Line line26 = new Line(815, 1063, 660, 990);
        Line line27 = new Line(660, 990, 485, 1063);
        Line line28 = new Line(485, 1125, 815, 1195);
        Line line29 = new Line(815, 1195, 1130, 1125);
        Line line30 = new Line(1130, 1063, 1265, 990);
        Line line31 = new Line(1265, 930, 1130, 858);
        Line line32 = new Line(1130, 858, 660, 930);
        Line line33 = new Line(1130, 1256, 970, 1330);
        Line line34 = new Line(1130, 1256, 640, 1330);
        Line line35 = new Line(1130, 1256, 1280, 1330);
        Line line36 = new Line(640, 1389, 970, 1462);
        Line line37 = new Line(640, 1389, 1280, 1462);
        Line line38 = new Line(970, 1389, 640, 1462);
        Line line39 = new Line(640, 1462, 1280, 1389);
        Line line40 = new Line(1445, 327, 970, 400);
        Line line41 = new Line(970, 460, 1280, 532);
        Line line42 = new Line(1280, 592, 1280, 665);
        Line line43 = new Line(1280, 592, 1610, 665);
        Line line44 = new Line(1280, 725, 1115, 800);
        Line line45 = new Line(1610, 725, 1115, 800);
        Line line46 = new Line(1280, 725, 1445, 800);
        Line line47 = new Line(1445, 858, 970, 930);
        Line line48 = new Line(1765, 327, 320, 400);
        Line line49 = new Line(320, 460, 970, 532);
        Line line50 = new Line(970, 592, 1280, 665);
        Line line51 = new Line(970, 592, 970, 665);
        Line line52 = new Line(970, 725, 1445, 800);
        Line line53 = new Line(1125, 327, 670, 400);
        Line line54 = new Line(1275, 460, 670, 532);
        Line line55 = new Line(1275, 460, 970, 532);
        Line line56 = new Line(670, 593, 330, 665);

        Polyline polyline1 = new Polyline(1125, 195, 1125, 225, 1275, 225, 1275, 402);
        Polyline polyline2 = new Polyline(155, 327, 155, 490, 1600, 490, 1600, 530);
        Polyline polyline3 = new Polyline(815, 327, 815, 500, 330, 500, 330, 530);
        Polyline polyline4 = new Polyline(670, 460, 670, 480, 500, 480, 500, 630, 330, 630, 330, 665);
        Polyline polyline5 = new Polyline(1445, 1115, 1445, 1300, 640, 1300, 640, 1330);
        Polyline polyline6 = new Polyline(815, 1240, 815, 1400, 640, 1400, 640, 1460);

        techRoot.getChildren().add(line1);
        techRoot.getChildren().add(line2);
        techRoot.getChildren().add(line3);
        techRoot.getChildren().add(line4);
        techRoot.getChildren().add(line5);
        techRoot.getChildren().add(line6);
        techRoot.getChildren().add(line7);
        techRoot.getChildren().add(line8);
        techRoot.getChildren().add(line9);
        techRoot.getChildren().add(line10);
        techRoot.getChildren().add(line11);
        techRoot.getChildren().add(line12);
        techRoot.getChildren().add(line13);
        techRoot.getChildren().add(line14);
        techRoot.getChildren().add(line15);
        techRoot.getChildren().add(line16);
        techRoot.getChildren().add(line17);
        techRoot.getChildren().add(line18);
        techRoot.getChildren().add(line19);
        techRoot.getChildren().add(line20);
        techRoot.getChildren().add(line21);
        techRoot.getChildren().add(line22);
        techRoot.getChildren().add(line23);
        techRoot.getChildren().add(line24);
        techRoot.getChildren().add(line25);
        techRoot.getChildren().add(line26);
        techRoot.getChildren().add(line27);
        techRoot.getChildren().add(line28);
        techRoot.getChildren().add(line29);
        techRoot.getChildren().add(line30);
        techRoot.getChildren().add(line31);
        techRoot.getChildren().add(line32);
        techRoot.getChildren().add(line33);
        techRoot.getChildren().add(line34);
        techRoot.getChildren().add(line35);
        techRoot.getChildren().add(line36);
        techRoot.getChildren().add(line37);
        techRoot.getChildren().add(line38);
        techRoot.getChildren().add(line39);
        techRoot.getChildren().add(line40);
        techRoot.getChildren().add(line41);
        techRoot.getChildren().add(line42);
        techRoot.getChildren().add(line43);
        techRoot.getChildren().add(line44);
        techRoot.getChildren().add(line45);
        techRoot.getChildren().add(line46);
        techRoot.getChildren().add(line47);
        techRoot.getChildren().add(line48);
        techRoot.getChildren().add(line49);
        techRoot.getChildren().add(line50);
        techRoot.getChildren().add(line51);
        techRoot.getChildren().add(line52);
        techRoot.getChildren().add(line53);
        techRoot.getChildren().add(line54);
        techRoot.getChildren().add(line55);
        techRoot.getChildren().add(line56);

        techRoot.getChildren().add(polyline1);
        techRoot.getChildren().add(polyline2);
        techRoot.getChildren().add(polyline3);
        techRoot.getChildren().add(polyline4);
        techRoot.getChildren().add(polyline5);
        techRoot.getChildren().add(polyline6);
    }

    private void initialiseTechBox(AnchorPane techPane) {
        int counter = 0;
        for (Node child : techPane.getChildren()) {
            if (child.getId().equals("techBackground")) {
                child.setLayoutX(40);
                child.setLayoutY(0);
                child.resize(200, 70);
            } else if (child.getId().equals("techIcon")) {
                child.setLayoutX(40);
                child.setLayoutY(0);
                ((ImageView) child).setFitWidth(60);
                ((ImageView) child).setFitHeight(60);
            } else if (child.getId().equals("buildingIcon")) {
                child.setLayoutX(counter * 35 + 110);
                child.setLayoutY(25);
                ((ImageView) child).setFitWidth(30);
                ((ImageView) child).setFitHeight(30);
                counter++;
            } else if (child.getId().equals("unitIcon")) {
                child.setLayoutX(counter * 35 + 110);
                child.setLayoutY(22);
                ((ImageView) child).setFitWidth(35);
                ((ImageView) child).setFitHeight(35);
                counter++;
            } else if (child.getId().equals("improvementIcon")) {
                child.setLayoutX(counter * 35 + 110);
                child.setLayoutY(22);
                ((ImageView) child).setFitWidth(35);
                ((ImageView) child).setFitHeight(35);
                counter++;
            } else if (child.getId().equals("turnLeft")) {
                child.setLayoutX(250);
                child.setLayoutY(0);
                child.getStyleClass().add("research-tree");
            } else if (child.getId().equals("name")) {
                child.setLayoutX(102);
                child.setLayoutY(0);
                child.getStyleClass().add("research-tree-text");
            }
        }
    }

    private ImageView findTechBackground(User user, Technology technology) {
        if (user.getTechnologies().contains(technology))
            return new ImageView(images.completeTechBackground);
        else if (user.getCurrentTechnology() == technology)
            return new ImageView(images.inProgressTechBackground);
        else {
            if (TechController.getInstance().isTechAvailable(user, technology))
                return new ImageView(images.availableTechBackground);
            else return new ImageView(images.unCompleteTechBackground);
        }
    }

    private ImageView findTechIcon(Technology technology) {
        return switch (technology.getName()) {
            case "Agriculture" -> new ImageView(images.agriculture);
            case "Pottery" -> new ImageView(images.pottery);
            case "Animal Husbandry" -> new ImageView(images.animalHusbandry);
            case "Archery" -> new ImageView(images.archery);
            case "Mining" -> new ImageView(images.mining);
            case "Calendar" -> new ImageView(images.calendar);
            case "Writing" -> new ImageView(images.writing);
            case "Trapping" -> new ImageView(images.trapping);
            case "The Wheel" -> new ImageView(images.theWheel);
            case "Bronze Working" -> new ImageView(images.bronzeWorking);
            case "Masonry" -> new ImageView(images.masonry);
            case "Construction" -> new ImageView(images.construction);
            case "Horseback Riding" -> new ImageView(images.horsebackRiding);
            case "Iron Working" -> new ImageView(images.ironWorking);
            case "Mathematics" -> new ImageView(images.mathematics);
            case "Philosophy" -> new ImageView(images.philosophy);
            case "Chivalry" -> new ImageView(images.chivalry);
            case "Civil Service" -> new ImageView(images.civilService);
            case "Currency" -> new ImageView(images.currency);
            case "Education" -> new ImageView(images.education);
            case "Engineering" -> new ImageView(images.engineering);
            case "Machinery" -> new ImageView(images.machinery);
            case "Metal Casting" -> new ImageView(images.metalCasting);
            case "Physics" -> new ImageView(images.physics);
            case "Steel" -> new ImageView(images.steel);
            case "Theology" -> new ImageView(images.theology);
            case "Acoustics" -> new ImageView(images.acoustics);
            case "Archaeology" -> new ImageView(images.archaeology);
            case "Banking" -> new ImageView(images.banking);
            case "Chemistry" -> new ImageView(images.chemistry);
            case "Economics" -> new ImageView(images.economics);
            case "Fertilizer" -> new ImageView(images.fertilizer);
            case "Gunpowder" -> new ImageView(images.gunpowder);
            case "Metallurgy" -> new ImageView(images.metallurgy);
            case "Military Science" -> new ImageView(images.militaryScience);
            case "Printing Press" -> new ImageView(images.printingPress);
            case "Rifling" -> new ImageView(images.rifling);
            case "Scientific Theory" -> new ImageView(images.scientificTheory);
            case "Biology" -> new ImageView(images.biology);
            case "Combustion" -> new ImageView(images.combustion);
            case "Dynamite" -> new ImageView(images.dynamite);
            case "Electricity" -> new ImageView(images.electricity);
            case "Radio" -> new ImageView(images.radio);
            case "Railroad" -> new ImageView(images.railroad);
            case "Replaceable Parts" -> new ImageView(images.replaceableParts);
            case "Steam Power" -> new ImageView(images.steamPower);
            case "Telegraph" -> new ImageView(images.telegraph);
            default -> null;
        };
    }

    public static ImageView findBuildingIcon(String buildingName) {
        return switch (buildingName) {
            case "Granary" -> new ImageView(images.Granary);
            case "Library" -> new ImageView(images.Library);
            case "Water Mill" -> new ImageView(images.Watermill);
            case "Barracks" -> new ImageView(images.Barracks);
            case "Walls" -> new ImageView(images.Walls);
            case "Colosseum" -> new ImageView(images.Colosseum);
            case "Circus" -> new ImageView(images.Circus);
            case "Stable" -> new ImageView(images.Stable);
            case "Armory" -> new ImageView(images.Armory);
            case "Courthouse" -> new ImageView(images.Courthouse);
            case "Burial Tomb" -> new ImageView(images.BurialTomb);
            case "Temple" -> new ImageView(images.Temple);
            case "Castle" -> new ImageView(images.Castle);
            case "Market" -> new ImageView(images.Market);
            case "Mint" -> new ImageView(images.Mint);
            case "University" -> new ImageView(images.University);
            case "Forge" -> new ImageView(images.Forge);
            case "Workshop" -> new ImageView(images.WorkShop);
            case "Garden" -> new ImageView(images.Garden);
            case "Monastery" -> new ImageView(images.Monastery);
            case "Opera House" -> new ImageView(images.OperaHouse);
            case "Museum" -> new ImageView(images.Museum);
            case "Bank" -> new ImageView(images.Bank);
            case "Strap's Court" -> new ImageView(images.satrapCourt);
            case "Windmill" -> new ImageView(images.Windmill);
            case "Military Academy" -> new ImageView(images.MilitaryAcademy);
            case "Theater" -> new ImageView(images.Theatre);
            case "Public School" -> new ImageView(images.PublicSchool);
            case "Hospital" -> new ImageView(images.Hospital);
            case "Stock Exchange" -> new ImageView(images.StockExchange);
            case "Arsenal" -> new ImageView(images.Arsenal);
            case "Factory" -> new ImageView(images.Factory);
            case "Military Base" -> new ImageView(images.MilitaryBase);
            case "Broadcast Tower" -> new ImageView(images.BroadcastTower);
            default -> null;
        };
    }

<<<<<<< HEAD
    private ImageView findUnitIcon(Unit unit) {
        return switch (unit.getName()) {
            case "Chariot Archer", "archer" -> new ImageView(images.chariotArcherIcon);
=======
    public static ImageView findUnitIcon(String unitName) {
        return switch (unitName) {
            case "Chariot Archer", "archer" ->  new ImageView(images.chariotArcherIcon);
>>>>>>> e76136f83b2969e7ac64890d2e3276503c5d9d9b
            case "Spearman" -> new ImageView(images.spearmanIcon);
            case "Horseman" -> new ImageView(images.horsemanIcon);
            case "Swordsman" -> new ImageView(images.swordManIcon);
            case "Catapult" -> new ImageView(images.catapultIcon);
            case "Knight" -> new ImageView(images.knightIcon);
            case "Pikeman" -> new ImageView(images.pikeManIcon);
            case "Crossbowman" -> new ImageView(images.crossbowmanIcon);
            case "Trebuchet" -> new ImageView(images.trebuchetIcon);
            case "Longswordsman" -> new ImageView(images.longSwordsmanIcon);
            case "Canon" -> new ImageView(images.canonIcon);
            case "Musketman" -> new ImageView(images.musketManIcon);
            case "Lancer" -> new ImageView(images.lancerIcon);
            case "Cavalry" -> new ImageView(images.cavalryIcon);
            case "Rifleman" -> new ImageView(images.rifleManIcon);
            case "Tank" -> new ImageView(images.tankIcon);
            case "Panzer" -> new ImageView(images.panzerIcon);
            case "Artillery" -> new ImageView(images.artilleryIcon);
            case "Infantry" -> new ImageView(images.infantryIcon);
            case "Anti-Tank Gun" -> new ImageView(images.antiTankGunIcon);
            default -> null;
        };
    }

    private ImageView findImprovement(Improvement improvement) {
        return switch (improvement.getName()) {
            case "Farm" -> new ImageView(images.Farm);
            case "Pasture" -> new ImageView(images.Pasture);
            case "Mine" -> new ImageView(images.Mine);
            case "Plantation" -> new ImageView(images.Plantation);
            case "Camp" -> new ImageView(images.Camp);
            case "Trading Post" -> new ImageView(images.TradingPost);
            case "Quarry" -> new ImageView(images.Quarry);
            case "Lumber Mill" -> new ImageView(images.LumberMill);
            case "Factory" -> new ImageView(images.ManuFactory);
            default -> null;
        };
    }
}
