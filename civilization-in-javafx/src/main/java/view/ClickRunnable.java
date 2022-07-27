package view;

public class ClickRunnable implements Runnable {

    private GameEnvironment gameEnvironment;

    public ClickRunnable(GameEnvironment gameEnvironment){
        this.gameEnvironment = gameEnvironment;
    }

    public void stop(boolean stop) {
        gameEnvironment.stop = stop;
    }

    @Override
    public void run() {
        gameEnvironment.mouseClickHandler();
    }
}
