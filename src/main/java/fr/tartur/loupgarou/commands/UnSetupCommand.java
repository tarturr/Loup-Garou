package fr.tartur.loupgarou.commands;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class UnSetupCommand implements MessageCreateListener {

    private final DiscordApi api;

    public UnSetupCommand(DiscordApi api) {
        this.api = api;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equals("*unsetup")) {
            MessageAuthor sender = event.getMessageAuthor();
            User user = (sender.asUser().isPresent()) ? sender.asUser().get() : null;

            if (sender.isServerAdmin()) {
                if (event.getServer().isPresent() && !api.getRolesByName("Participant").isEmpty()) {
                    event.getServer().get().getChannelCategories().forEach(category -> {
                        if (category.getName().equals("Parties")) category.delete();
                    });

                    event.getServer().get().getRoles().forEach(role -> {
                        if (role.getName().equals("Participant")) role.delete();
                    });

                    event.getChannel().sendMessage(":white_check_mark: La configuration a bien été désactivée ! À la prochaine !");
                }
            }
        }
    }
}
