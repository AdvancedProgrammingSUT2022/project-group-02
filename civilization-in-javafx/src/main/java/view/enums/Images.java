package view.enums;

import javafx.scene.image.Image;

public class Images {
    public Image normalMenuButton;
    public Image selectedMenuButton;
    public Image submitMenuButton;

    public Images(){
        normalMenuButton = new Image(String.valueOf(getClass().getResource("/Media/buttons/Button_Down.png")));
        selectedMenuButton = new Image(String.valueOf(getClass().getResource("/Media/buttons/Button_Selected.png")));
        submitMenuButton = new Image(String.valueOf(getClass().getResource("/Media/buttons/Button_Normal.png")));
    }
}
