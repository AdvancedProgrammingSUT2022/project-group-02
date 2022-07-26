package view;

public class ClickRunnable implements Runnable {

    private GameEnvironment gameEnvironment;

    public ClickRunnable(GameEnvironment gameEnvironment){
        this.gameEnvironment = gameEnvironment;
    }

    @Override
    public void run() {
        gameEnvironment.mouseClickHandler();
    }
}
