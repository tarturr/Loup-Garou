package fr.tartur.loupgarou.game.entities;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;

public class WereWolf extends Entity {

    public WereWolf(User user) {
        super(EntityType.WEREWOLF, user);
    }

    @Override
    public void play() {
        super.user.sendMessage(super.user.getMentionTag() + ", c'est ton tour !");

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle(super.entityType.getEmoji() + " " + super.entityType.getName() + " - " + super.user.getName());
    }

}