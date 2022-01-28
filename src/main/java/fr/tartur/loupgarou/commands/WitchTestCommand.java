package fr.tartur.loupgarou.commands;

import fr.tartur.loupgarou.game.entities.Witch;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class WitchTestCommand implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessage().getContent().equals("*witch")) {

            if (event.getMessageAuthor().asUser().isPresent()) {
                Witch witch = new Witch(event.getMessageAuthor().asUser().get());
                witch.play();
            }

        }
    }
}
