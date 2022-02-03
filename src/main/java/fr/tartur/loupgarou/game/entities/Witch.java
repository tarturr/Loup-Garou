package fr.tartur.loupgarou.game.entities;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;

import java.util.concurrent.ExecutionException;

public class Witch extends Entity {

    public Witch(User user) {
        super(EntityType.WITCH, user);
    }

    private boolean hasKilled = false;
    private boolean hasResurrected = false;

    @Override
    public void play() {
        super.user.sendMessage(super.user.getMentionTag() + ", c'est ton tour !");

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle(super.entityType.getEmoji() + " " + super.entityType.getName() + " - " + super.user.getName())
                .setDescription("\n*� toi de jouer !*\n")
                .addField("Quel est votre choix ?", "Voici les possibilit�s :\n" +
                        ((!hasKilled) ? ":knife: - Tuer un adversaire.\n" : "") +
                        ((!hasResurrected) ? ":anatomical_heart: - Ressusciter un adversaire.\n" : "") +
                        ":no_entry: - Ne rien faire.\n")
                .setColor(super.entityType.getColor())
                .setFooter("Vous incarnez " + super.entityType.getName() + "."/*, "./src/main/resources/" + super.entityType.toString().toLowerCase() + ".png"*/); // <-- FIXME
//                .setThumbnail("./src/main/resources/witch-choice.jpg"); // <-- FIXME


        try {
            super.user.sendMessage(embed).get().addReactions((!hasKilled) ? ":knife:" : null, (!hasResurrected) ? ":anatomical_heart:" : null, ":no_entry:");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
