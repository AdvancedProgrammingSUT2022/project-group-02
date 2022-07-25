package view;

public class ClickRunnable implements Runnable {

    private GameEnvironment gameEnvironment;

    public ClickRunnable(GameEnvironment gameEnvironment){
        this.gameEnvironment = gameEnvironment;
    }

    @Override
    public void run() {
        System.out.println(gameEnvironment.getUser().getNickname() + "clickRunnable");
        gameEnvironment.mouseClickHandler();
    }
}
