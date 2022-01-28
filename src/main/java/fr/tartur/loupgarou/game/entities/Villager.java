package fr.tartur.loupgarou.game.entities;

import org.javacord.api.entity.user.User;

public class Villager extends Entity {

    public Villager(User user) {
        super(EntityType.VILLAGER, user);
    }

    @Override
    public void play() { }
}
