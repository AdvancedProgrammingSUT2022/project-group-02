package view;

public class TurnRunnable implements Runnable {

    private GameEnvironment gameEnvironment;
    public TurnRunnable(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    @Override
    public void run() {
        gameEnvironment.checkNextTurn();
    }
}
