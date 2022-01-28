package fr.tartur.loupgarou.game;

import fr.tartur.loupgarou.game.entities.Entity;
import fr.tartur.loupgarou.game.schedule.DayTime;

import java.util.List;

public class Game {

    private final List<Entity> users;
    private final DayTime dayTime;

    public Game(List<Entity> users, DayTime dayTime) {
        this.users = users;
        this.dayTime = dayTime;
    }
}
