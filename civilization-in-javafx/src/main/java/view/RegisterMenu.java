package view;
import controller.ColorsController;
import controller.NetworkController;
import controller.UsersController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.Request;
import model.Response;
import model.User;
import view.enums.Colors;
import view.enums.Images;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RegisterMenu {

    private String whichMenu;
    private UsersController users = UsersController.getInstance();
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private Scene scene;
    private static Images images;
    private final HashMap<String , Boolean> availableColors = new HashMap<>();
    private boolean readFromGson = false;

    public RegisterMenu(MediaPlayer mediaPlayer, Stage stage, Scene scene, Images images){
        RegisterMenu.images = images;
        this.scene = scene;
        this.mediaPlayer = mediaPlayer;
        this.stage = stage;
    }
    public RegisterMenu(){
        availableColors.put("white" , true);
        availableColors.put("red" , true);
        availableColors.put("green" , true);
        availableColors.put("yellow" , true);
        availableColors.put("blue" , true);
        availableColors.put("purple" , true);
        availableColors.put("cyan" , true);
    }
    // provide some information for user
    private void manRegisterMenu() {
        String boldColor = Colors.YELLOW_BOLD;
        String Color = Colors.CYAN;
        System.out.println(boldColor + "to create new user :" + Colors.RESET);
        System.out.println(Color + "the order of username and nickname and password is not important");
        System.out.println("user create --username <username> --nickname <nickname> --password <password>");
        System.out.println("user create -u <username> -n <nickname> -p <password>" + Colors.RESET);
        System.out.println("**********************");
        System.out.println(boldColor + "to login :" + Colors.RESET);
        System.out.println(Color + "the order of username and password is not important");
        System.out.println("user login --username <username> --password <password>");
        System.out.println("user login -u <username> -p <password>" + Colors.RESET);
        System.out.println("**********************");
        System.out.println(Color + "press \"menu show-current\" to see the menu you are in");
        System.out.println("press \"menu exit\" to exit the menu" + Colors.RESET);
    }
    public void run(Scanner scanner) {
        /* graphic part */
        //TODO : user Color
        //TODO : user Avatar
        URL fxmlAddress = getClass().getResource("/Fxml/register-menu.fxml");
        assert fxmlAddress != null;
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(fxmlAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert root != null;
        if (!readFromGson) {
            readFromGson = true;
            ArrayList<User> usersFromJson = users.readFromJson();
            if (usersFromJson != null) users.setUsers(usersFromJson);
        }
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        scene.setRoot(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        graphicShowNoticeAndTips(root);
        graphicRegisterButtons(root);

//        String input;
//        Matcher matcher;
//        manRegisterMenu();
//        ArrayList<User> usersFromJson = users.readFromJson();
//        if (usersFromJson != null)
//            users.setUsers(usersFromJson);
//        while (true) {
//            input = scanner.nextLine();
//            //exit the game
//            if (Pattern.matches("\\s*menu\\s+exit\\s*", input)) {
//                users.writeToJson();
//                return;
//            }
//            //show current menu
//            else if (Pattern.matches("\\s*menu\\s+show-current\\s*", input))
//                System.out.println("Login Menu");
//                //register user
//            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER1)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER2)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER3)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER4)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER5)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER6)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER7)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER8)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER9)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER10)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER11)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER12)) != null) {
//                String username = matcher.group("username");
//                String nickname = matcher.group("nickname");
//                String password = matcher.group("password");
//                //check if there is a same username
//                if (!users.sameUsernameExists(username)) {
//                    //check if there is a same nickname
//                    if (!users.sameNicknameExists(nickname)) {
//                        User user = new User(username, nickname, password);
//                        System.out.println("select your Avatar Color");
//                        printRemainColors();
//                        String color = scanner.nextLine();
//                        while (!isSelectedColorValid(color)) {
//                            color = scanner.nextLine();
//                        }
//                        users.setUserColor(color, user, availableColors);
//                        users.addUser(user);
//                        System.out.println("user created successfully!");
//                    } else
//                        System.out.println("user with this nickname " + nickname + " already exists");
//                } else
//                    System.out.println("user with this username " + username + " already exists");
//            }
//            //login handling
//            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.LOGIN1)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.LOGIN2)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.LOGIN3)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.LOGIN4)) != null) {
//                String username = matcher.group("username");
//                String password = matcher.group("password");
//                User user;
//                //check if username exists and the password is correct
//                if (users.sameUsernameExists(username) && (user = users.getUserByUsername(username)).getPassword().equals(password)) {
//                    System.out.println("user logged in successfully!");
//                    new MainMenu().run(users, user, scanner);
//                } else
//                    System.out.println("Username and password didn't match!");
//            }
//            //if the user tried to change the menu
//            else if (RegexEnums.getMatcher(input, RegexEnums.CHANGE_MENU) != null)
//                System.out.println("please login first");
//            else
//                System.out.println("invalid command");
//        }

        /* end of graphic part */


//        String input;
//        Matcher matcher;
//        manRegisterMenu();
//        ArrayList<User> usersFromJson = users.readFromJson();
//        if (usersFromJson != null)
//            users.setUsers(usersFromJson);
//        while (true) {
//            input = scanner.nextLine();
//            //exit the game
//            if (Pattern.matches("\\s*menu\\s+exit\\s*", input)) {
//                users.writeToJson();
//                return;
//            }
//            //show current menu
//            else if (Pattern.matches("\\s*menu\\s+show-current\\s*", input))
//                System.out.println("Login Menu");
//                //register user
//            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER1)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER2)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER3)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER4)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER5)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER6)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER7)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER8)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER9)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER10)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER11)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.REGISTER12)) != null) {
//                String username = matcher.group("username");
//                String nickname = matcher.group("nickname");
//                String password = matcher.group("password");
//                //check if there is a same username
//                if (!users.sameUsernameExists(username)) {
//                    //check if there is a same nickname
//                    if (!users.sameNicknameExists(nickname)) {
//                        User user = new User(username, nickname, password);
//                        System.out.println("select your Avatar Color");
//                        printRemainColors();
//                        String color = scanner.nextLine();
//                        while (!isSelectedColorValid(color)) {
//                            color = scanner.nextLine();
//                        }
//                        users.setUserColor(color, user, availableColors);
//                        users.addUser(user);
//                        System.out.println("user created successfully!");
//                    } else
//                        System.out.println("user with this nickname " + nickname + " already exists");
//                } else
//                    System.out.println("user with this username " + username + " already exists");
//            }
//            //login handling
//            else if ((matcher = RegexEnums.getMatcher(input, RegexEnums.LOGIN1)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.LOGIN2)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.LOGIN3)) != null ||
//                    (matcher = RegexEnums.getMatcher(input, RegexEnums.LOGIN4)) != null) {
//                String username = matcher.group("username");
//                String password = matcher.group("password");
//                User user;
//                //check if username exists and the password is correct
//                if (users.sameUsernameExists(username) && (user = users.getUserByUsername(username)).getPassword().equals(password)) {
//                    System.out.println("user logged in successfully!");
//                    new MainMenu().run(users, user, scanner);
//                } else
//                    System.out.println("Username and password didn't match!");
//            }
//            //if the user tried to change the menu
//            else if (RegexEnums.getMatcher(input, RegexEnums.CHANGE_MENU) != null)
//                System.out.println("please login first");
//            else
//                System.out.println("invalid command");
//        }
    }

    private void printRemainColors(){
        AtomicInteger number = new AtomicInteger(1);
        availableColors.forEach((key , value) -> {
            if (value){
                String color = new ColorsController().getColorOfString(key);
                System.out.println(number + "- " + color + key + Colors.RESET);
                number.getAndIncrement();
            }
        });
    }

    private Boolean isSelectedColorValid(String color){
        if (!availableColors.containsKey(color)){
            System.out.println("The selected color is not an available color");
            return false;
        } else if (!availableColors.get(color)){
            System.out.println("The selected color is taken by another user");
            return false;
        } else return true;
    }

    private void graphicSignupController(String username, String nickname, String password, Label label){
        label.setLayoutX(640);
        label.setLayoutY(140);
        label.getStyleClass().add("register-signup-and-login-error");
        label.setEffect(new DropShadow());

        // send signup information to server and get response;
        Request request = new Request();
        request.setAction("signup");
        request.setMenu("register menu");
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("nickname", nickname);
        parameters.put("password", password);
        request.setParameters(parameters);
        Response response = NetworkController.getInstance().sendRequest(request);

        label.setText(response.getMessage());

        /*
//      check if there is a same username
        if (!users.sameUsernameExists(username)) {
//          check if there is a same nickname
            if (!users.sameNicknameExists(nickname)) {
                User user = new User(username, nickname, password);
                //TODO : delete next line after add last time win
                LocalTime lastWinTime = LocalTime.now();
                String lastWinTimeString = lastWinTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                user.setLastWinTime(lastWinTimeString);
                users.addUser(user);
                label.setText("user created successfully!");
            } else {
                label.setLayoutX(555 - nickname.length());
                label.setText("user with this nickname " + nickname + " already exists");
            }
        } else {
            label.setLayoutX(555 - username.length());
            label.setText("user with this username " + username + " already exists");
        }
        */
    }

    private void graphicLoginController(String username, String password, Label label) throws IOException {
        label.setLayoutX(650);
        label.setLayoutY(140);
        label.getStyleClass().add("register-signup-and-login-error");
        label.setEffect(new DropShadow());
        //TODO : enter MainMenu


        Request request = new Request();
        request.setAction("login");
        request.setMenu("register menu");
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("password", password);
        request.setParameters(parameters);
        Response response = NetworkController.getInstance().sendRequest(request);
        label.setText(response.getMessage());
        if (response.getStatusCode().equals("200")) {
            User user = (User)response.getParameters().get("user");
            new MainMenu(mediaPlayer, stage, scene, images, users).run(user, new Scanner(System.in));
        }
        else
            label.setLayoutX(588);
        /*
        User user;
        //check if username exists and the password is correct
        if (users.sameUsernameExists(username) && (user = users.getUserByUsername(username)).getPassword().equals(password)) {
            user.setActiveUser(true);
            label.setText("user logged in successfully!");
            new MainMenu(mediaPlayer, stage, scene, images, users).run(user, new Scanner(System.in));
        } else{
            label.setLayoutX(588);
            label.setText("Username and password didn't match!");
        }
        */


    }

    private void graphicShowNoticeAndTips(AnchorPane root){
        DropShadow dropShadow = new DropShadow();
        Label notice = new Label("NOTICE : This game is based on unreal elements! " +
                "None of the characters, places and resources necessarily exist in the real world!");
        Label tip1 = new Label("Tip1 : Do not share your username and password with anyone! it keeps your data safe.");
        Label tip2 = new Label("Tip2 : Save the game each time you want to exit the game!");
        Label tip3 = new Label("Tip3 : Use a strong password for your account to keep it safe!");
        tip1.getStyleClass().add("register-menu-tip-Style");
        tip2.getStyleClass().add("register-menu-tip-Style");
        tip3.getStyleClass().add("register-menu-tip-Style");
        notice.getStyleClass().add("register-menu-notice-Style");
        root.getChildren().add(tip1);
        root.getChildren().add(tip2);
        root.getChildren().add(tip3);
        root.getChildren().add(notice);
        notice.setLayoutY(92);
        notice.setLayoutX(15);
        tip1.setLayoutY(115);
        tip1.setLayoutX(15);
        tip2.setLayoutY(138);
        tip2.setLayoutX(15);
        tip3.setLayoutY(161);
        tip3.setLayoutX(15);
        notice.setEffect(dropShadow);
        tip1.setEffect(dropShadow);
        tip2.setEffect(dropShadow);
        tip3.setEffect(dropShadow);
    }

    private void graphicRegisterButtons(AnchorPane root){
        ImageView normalButton1 = new ImageView(images.normalMenuButton);
        ImageView normalButton2 = new ImageView(images.normalMenuButton);
        ImageView selectedButton = new ImageView(images.selectedMenuButton);
        Button signup = new Button("Signup", normalButton1);
        signup.setContentDisplay(ContentDisplay.CENTER);
        Button login = new Button("Login", normalButton2);
        login.setContentDisplay(ContentDisplay.CENTER);
        graphicInitialiseRegisterButtons(signup, login, normalButton1, normalButton2, selectedButton);
        graphicHoverButtonsEffects(signup, login, normalButton1, normalButton2, selectedButton);
        root.getChildren().add(signup);
        root.getChildren().add(login);
    }

    private void graphicHoverButtonsEffects(Button signup, Button login, ImageView normalButton1,
                                            ImageView normalButton2, ImageView selectedButton){
        DropShadow dropShadow = new DropShadow();
        signup.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            signup.setGraphic(selectedButton);
            signup.setEffect(dropShadow);
            AudioClip clickSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/sounds/click.mp3")).toExternalForm());
            clickSound.play();
        });
        signup.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            signup.setGraphic(normalButton1);
            signup.setEffect(null);
        });
        signup.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            whichMenu = "signup";
            signup.setGraphic(normalButton1);
            signup.setEffect(null);
            AudioClip clickSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/sounds/click.mp3")).toExternalForm());
            clickSound.play();
            graphicSignUp();
        });
        login.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            login.setGraphic(selectedButton);
            login.setEffect(dropShadow);
            AudioClip clickSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/sounds/click.mp3")).toExternalForm());
            clickSound.play();
        });
        login.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            login.setGraphic(normalButton2);
            login.setEffect(null);
        });
        login.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            whichMenu = "login";
            login.setGraphic(normalButton1);
            login.setEffect(null);
            AudioClip clickSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/sounds/click.mp3")).toExternalForm());
            clickSound.play();
            graphicLogin();
        });
    }

    private void graphicInitialiseRegisterButtons(Button signup, Button login, ImageView normalButton1,
                                                  ImageView normalButton2, ImageView selectedButton){
        selectedButton.setFitWidth(300);
        selectedButton.setFitHeight(35);
        login.setPrefSize(300, 35);
        signup.setPrefSize(300, 35);
        normalButton1.setFitHeight(35);
        normalButton1.setFitWidth(300);
        normalButton2.setFitHeight(35);
        normalButton2.setFitWidth(300);
        signup.setLayoutX(595);
        signup.setLayoutY(400);
        login.setLayoutX(595);
        login.setLayoutY(445);
        signup.getStyleClass().add("register-signup-and-login-button");
        login.getStyleClass().add("register-signup-and-login-button");
    }

    private void graphicSignUp(){
        URL fxmlAddress = getClass().getResource("/Fxml/register-menu.fxml");
        assert fxmlAddress != null;
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(fxmlAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert root != null;
        scene.setRoot(root);
        ImageView button1 = new ImageView(images.submitMenuButton);
        ImageView button2 = new ImageView(images.selectedMenuButton);
        ImageView button3 = new ImageView(images.normalMenuButton);
        ImageView back1 = new ImageView(images.submitMenuButton);
        ImageView back2 = new ImageView(images.selectedMenuButton);
        ImageView back3 = new ImageView(images.normalMenuButton);
        TextField username = new TextField();
        TextField nickname = new TextField();
        TextField password = new TextField();
        Label usernameLabel = new Label("username : ");
        Label nicknameLabel = new Label("nickname : ");
        Label passwordLabel = new Label("password : ");
        Button submit = new Button("Submit", button1);
        Button back = new Button("Back", back1);
        root.getChildren().add(username);
        root.getChildren().add(nickname);
        root.getChildren().add(password);
        root.getChildren().add(usernameLabel);
        root.getChildren().add(nicknameLabel);
        root.getChildren().add(passwordLabel);
        root.getChildren().add(submit);
        root.getChildren().add(back);
        graphicInitialiseSignUpBoxes(username, nickname, password, usernameLabel, nicknameLabel, passwordLabel, submit,
                button1, button2, button3, back1, back2, back3, back);
        graphicSubmitEffect(submit, button1, button2, button3, username, nickname, password, root, back1, back2, back3, back);
    }

    private void graphicInitialiseSignUpBoxes(TextField username, TextField nickname, TextField password,
                                              Label usernameLabel, Label nicknameLabel, Label passwordLabel, Button submit,
                                              ImageView button1, ImageView button2, ImageView button3, ImageView back1,
                                              ImageView back2, ImageView back3, Button back){
        username.setLayoutX(635);
        username.setLayoutY(280);
        username.setPrefHeight(40);
        username.setPrefWidth(270);
        username.setAlignment(Pos.CENTER);
        username.getStyleClass().add("register-text-field");
        nickname.setLayoutX(635);
        nickname.setLayoutY(330);
        nickname.setPrefHeight(40);
        nickname.setPrefWidth(270);
        nickname.setAlignment(Pos.CENTER);
        nickname.getStyleClass().add("register-text-field");
        password.setLayoutX(635);
        password.setLayoutY(380);
        password.setPrefHeight(40);
        password.setPrefWidth(270);
        password.setAlignment(Pos.CENTER);
        password.getStyleClass().add("register-text-field");
        usernameLabel.setLayoutX(550);
        usernameLabel.setLayoutY(285);
        usernameLabel.getStyleClass().add("register-signup-and-login-text");
        nicknameLabel.setLayoutX(550);
        nicknameLabel.setLayoutY(335);
        nicknameLabel.getStyleClass().add("register-signup-and-login-text");
        passwordLabel.setLayoutX(550);
        passwordLabel.setLayoutY(385);
        passwordLabel.getStyleClass().add("register-signup-and-login-text");
        submit.getStyleClass().add("register-signup-and-login-submit");
        submit.setContentDisplay(ContentDisplay.CENTER);
        submit.setLayoutX(550);
        submit.setLayoutY(445);
        submit.setPrefSize(355, 50);
        button1.setFitHeight(50);
        button1.setFitWidth(355);
        button2.setFitHeight(50);
        button2.setFitWidth(355);
        button3.setFitHeight(50);
        button3.setFitWidth(355);
        back1.setFitHeight(70);
        back1.setFitWidth(170);
        back2.setFitHeight(70);
        back2.setFitWidth(170);
        back3.setFitHeight(70);
        back3.setFitWidth(170);
        back.setPrefSize(170, 70);
        back.setLayoutY(775);
        back.setContentDisplay(ContentDisplay.CENTER);
        back.getStyleClass().add("back-button");
    }

    private void graphicSubmitEffect(Button submit, ImageView button1, ImageView button2, ImageView button3,
                                     TextField username, TextField nickname, TextField password, AnchorPane root,
                                     ImageView back1, ImageView back2, ImageView back3, Button back){
        Label label = new Label();
        root.getChildren().add(label);
        DropShadow dropShadow = new DropShadow();
        submit.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            submit.setGraphic(button2);
            submit.setEffect(dropShadow);
            AudioClip clickSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/sounds/click.mp3")).toExternalForm());
            clickSound.play();
        });
        submit.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            submit.setGraphic(button1);
            submit.setEffect(null);
        });
        submit.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            submit.setGraphic(button3);
            submit.setEffect(null);
            AudioClip clickSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/sounds/click.mp3")).toExternalForm());
            clickSound.play();
            if (whichMenu.equals("signup"))graphicSignupController(username.getText(), nickname.getText(), password.getText(), label);
            else if (whichMenu.equals("login")) {
                try {
                    graphicLoginController(username.getText(), password.getText(), label);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        back.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            back.setGraphic(back2);
            back.setEffect(dropShadow);
            AudioClip clickSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/sounds/click.mp3")).toExternalForm());
            clickSound.play();
        });
        back.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            back.setGraphic(back1);
            back.setEffect(null);
        });
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            back.setGraphic(back3);
            back.setEffect(null);
            AudioClip clickSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/sounds/click.mp3")).toExternalForm());
            clickSound.play();
            run(new Scanner(System.in));
        });
    }



    public void graphicLogin(){
        URL fxmlAddress = getClass().getResource("/Fxml/register-menu.fxml");
        assert fxmlAddress != null;
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(fxmlAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert root != null;
        scene.setRoot(root);
        ImageView button1 = new ImageView(images.submitMenuButton);
        ImageView button2 = new ImageView(images.selectedMenuButton);
        ImageView button3 = new ImageView(images.normalMenuButton);
        ImageView back1 = new ImageView(images.submitMenuButton);
        ImageView back2 = new ImageView(images.selectedMenuButton);
        ImageView back3 = new ImageView(images.normalMenuButton);
        TextField username = new TextField();
        TextField password = new TextField();
        Label usernameLabel = new Label("username : ");
        Label passwordLabel = new Label("password : ");
        Button submit = new Button("Submit", button1);
        Button back = new Button("Back", back1);
        root.getChildren().add(username);
        root.getChildren().add(password);
        root.getChildren().add(usernameLabel);
        root.getChildren().add(passwordLabel);
        root.getChildren().add(submit);
        root.getChildren().add(back);
        graphicInitialiseLoginBoxes(username,password, usernameLabel, passwordLabel, submit, button1, button2, button3, back1, back2, back3, back);
        graphicSubmitEffect(submit, button1, button2, button3, username, null, password, root, back1, back2, back3, back);
    }

    private void graphicInitialiseLoginBoxes(TextField username, TextField password,
                                             Label usernameLabel, Label passwordLabel, Button submit,
                                             ImageView button1, ImageView button2, ImageView button3,
                                             ImageView back1, ImageView back2, ImageView back3, Button back){
        username.setLayoutX(635);
        username.setLayoutY(280);
        username.setPrefHeight(40);
        username.setPrefWidth(270);
        username.setAlignment(Pos.CENTER);
        username.getStyleClass().add("register-text-field");
        password.setLayoutX(635);
        password.setLayoutY(330);
        password.setPrefHeight(40);
        password.setPrefWidth(270);
        password.setAlignment(Pos.CENTER);
        password.getStyleClass().add("register-text-field");
        usernameLabel.setLayoutX(550);
        usernameLabel.setLayoutY(285);
        usernameLabel.getStyleClass().add("register-signup-and-login-text");
        passwordLabel.setLayoutX(550);
        passwordLabel.setLayoutY(335);
        passwordLabel.getStyleClass().add("register-signup-and-login-text");
        submit.getStyleClass().add("register-signup-and-login-submit");
        submit.setContentDisplay(ContentDisplay.CENTER);
        submit.setLayoutX(550);
        submit.setLayoutY(390);
        submit.setPrefSize(355, 50);
        button1.setFitHeight(50);
        button1.setFitWidth(355);
        button2.setFitHeight(50);
        button2.setFitWidth(355);
        button3.setFitHeight(50);
        button3.setFitWidth(355);
        back1.setFitHeight(70);
        back1.setFitWidth(170);
        back2.setFitHeight(70);
        back2.setFitWidth(170);
        back3.setFitHeight(70);
        back3.setFitWidth(170);
        back.setPrefSize(170, 70);
        back.setLayoutY(775);
        back.setContentDisplay(ContentDisplay.CENTER);
        back.getStyleClass().add("back-button");
    }
}
