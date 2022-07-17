package view.enums;

import javafx.scene.image.Image;

public class Images {
    public Image normalMenuButton;
    public Image selectedMenuButton;
    public Image submitMenuButton;
    public Image mainMenuButtonBackGround;
    public Image desertCell;
    public Image hillCell;
    public Image plainCell;
    public Image snowCell;
    public Image tundraCell;
    public Image grasslandCell;
    public Image jungleCell;
    public Image oceanCell;
    public Image mountainCell;
    public Image mountainCell2;

    public Images(){
        normalMenuButton = new Image(String.valueOf(getClass().getResource("/Media/buttons/Button_Down.png")));
        selectedMenuButton = new Image(String.valueOf(getClass().getResource("/Media/buttons/Button_Selected.png")));
        submitMenuButton = new Image(String.valueOf(getClass().getResource("/Media/buttons/Button_Normal.png")));
        mainMenuButtonBackGround = new Image(String.valueOf(getClass().getResource("/Media/buttons/Menu-buttons-pic.png")));
        desertCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/DesertCell.png")));
        hillCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/HillCell.png")));
        plainCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/PlainCell.png")));
        snowCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/snowCell.png")));
        tundraCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/TundraCell.png")));
        grasslandCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/GrasslandCell.png")));
        jungleCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/JungleCell.png")));
        oceanCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/OceanCell.png")));
        mountainCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/MountainCell.png")));
        mountainCell2 = new Image(String.valueOf(getClass().getResource("/Media/tiles/MountainCell2.png")));
    }
}
