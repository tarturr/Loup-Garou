package fr.tartur.loupgarou.game.entities;

import org.javacord.api.entity.user.User;

public abstract class Entity {

    protected final EntityType entityType;
    protected final User user;

    public Entity(EntityType entityType, User user) {
        this.entityType = entityType;
        this.user = user;
    }

    public abstract void play();

    public EntityType getEntityType() {
        return entityType;
    }

    public User getUser() {
        return user;
    }

    public void sendRole() {
        user.sendMessage(entityType.getEmoji() + " Vous �tes **" + entityType.getName() + "** !");
    }

}
