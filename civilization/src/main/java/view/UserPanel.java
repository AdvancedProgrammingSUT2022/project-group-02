package view;

import controller.GameController;
import enums.Colors;
import model.*;

public class UserPanel {
    private GameController gameController;
    public UserPanel(GameController gameController) {
        this.gameController = gameController;
    }
    public static void researchDoneNotification(User user, Technology technology) {
        System.out.println(Colors.RED + "NOTICE!!!" + Colors.RESET);
        System.out.println("Dear " + user.getColor() + user.getUsername() + Colors.RESET);
        System.out.println("you have completed research on " + user.getColor() + technology.getName() + Colors.RESET);
        if (technology.getGivenImprovement() != null) {
            System.out.println("this technology will enable you to work on this improvements :");
            for (Improvement improvement : technology.getGivenImprovement()) {
                System.out.println(Colors.BLUE + "Improvement name : " + improvement.getName());
                System.out.println("Food rate : " + improvement.getFoodRate());
                System.out.println("Production rate : " + improvement.getProductionRate());
                System.out.println("Gold rate : " + improvement.getGoldRate());
                System.out.println("price : " + improvement.getPrice() + Colors.RESET);
                if (improvement.getGivenResource() != null) {
                    for (Resource resource : improvement.getGivenResource()) {
                        System.out.println(Colors.GREEN + "Resource name : " + resource.getName());
                        System.out.println("Resource type : " + resource.getResourceType());
                        System.out.println("Food rate : " + resource.getFoodRate());
                        System.out.println("Production rate : " + resource.getProductionRate());
                        System.out.println("Gold rate : " + resource.getGoldRate() + Colors.RESET);
                    }
                }
            }
        }
        if (technology.getGivenUnits() != null) {
            System.out.println("this technology will enable you to build this units :");
            for (Unit givenUnit : technology.getGivenUnits()) {
                System.out.println(Colors.PURPLE + "Unit name : " + givenUnit.getName());
                System.out.println("Unit product price : " + givenUnit.getProductionPrice());
                System.out.println("Unit gold price : " + givenUnit.getGoldPrice());
                System.out.println("Maintain price : " + givenUnit.getMaintainGold());
                System.out.println("Combat strength : " + givenUnit.getCombatStrength());
                System.out.println("Ranged combat strength : " + givenUnit.getRangeCombatStrength());
                System.out.println("Movement point : " + givenUnit.getMP() + Colors.RESET);
            }
        }
    }
    public static void improvementDoneNotification(User user, Improvement improvement) {
        System.out.println(Colors.RED + "NOTICE!!!" + Colors.RESET);
        System.out.println("Dear " + user.getColor() + user.getUsername() + Colors.RESET);
        System.out.println("you have completed working on " + user.getColor() + improvement.getName() + Colors.RESET);
        System.out.println(Colors.YELLOW + "this improvement will give you : ");
        System.out.println("Food rate : " + improvement.getFoodRate());
        System.out.println("Production rate : " + improvement.getProductionRate());
        System.out.println("Gold rate : " + improvement.getGoldRate() + Colors.RESET);
        if (improvement.getGivenResource() != null) {
            for (Resource resource : improvement.getGivenResource()) {
                System.out.println(Colors.GREEN + "Resource name : " + resource.getName());
                System.out.println("Resource type : " + resource.getResourceType());
                System.out.println("Food rate : " + resource.getFoodRate());
                System.out.println("Production rate : " + resource.getProductionRate());
                System.out.println("Gold rate : " + resource.getGoldRate() + Colors.RESET);
            }
        }
    }
    public static void productDoneNotification(User user, City city, Product product, GameController gameController) {
        System.out.println(Colors.RED + "NOTICE!!!" + Colors.RESET);
        System.out.println("Dear " + user.getColor() + user.getUsername() + Colors.RESET);
        System.out.println("you have completed producing " + user.getColor() + product.getName() + Colors.RESET);
        Unit unit = gameController.findProductionUnit(city, product);
        if (unit != null) {
            System.out.println(Colors.PURPLE + "Unit name : " + unit.getName());
            System.out.println("Unit product price : " + unit.getProductionPrice());
            System.out.println("Unit gold price : " + unit.getGoldPrice());
            System.out.println("Maintain price : " + unit.getMaintainGold());
            System.out.println("Combat strength : " + unit.getCombatStrength());
            System.out.println("Ranged combat strength : " + unit.getRangeCombatStrength());
            System.out.println("Movement point : " + unit.getMP() + Colors.RESET);
        }
    }
}
