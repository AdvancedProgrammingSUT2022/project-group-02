package handlers;

import model.*;

public abstract class Handlers {
    protected Handlers nextHandler;

    public void setNextHandler(Handlers nextHandler){
        this.nextHandler = nextHandler;
    }

    public abstract boolean handle(Worker worker, MilitaryUnit militaryUnit, Tile tile, User user);
}


