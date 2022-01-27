package fr.tartur.loupgarou.commands;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.ChannelCategoryBuilder;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.PermissionsBuilder;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SetupCommand implements MessageCreateListener {

    private final DiscordApi api;

    public SetupCommand(DiscordApi api) {
        this.api = api;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equals("*setup")) {
            MessageAuthor sender = event.getMessageAuthor();
            User user = (sender.asUser().isPresent()) ? sender.asUser().get() : null;

            if (sender.isServerAdmin()) {
                if (event.getServer().isPresent() && api.getRolesByName("Participant").isEmpty()) {
                    Server server = event.getServer().get();

                    CompletableFuture<Role> role = server.createRoleBuilder()
                            .setName("Participant")
                            .setColor(Color.RED)
                            .setMentionable(true)
                            .create();

                    try {
                        ChannelCategoryBuilder builder = server.createChannelCategoryBuilder()
                                .setName("Parties");

                        server.getRoles().forEach(group -> {
                            if (!group.getPermissions().getAllowedPermission().contains(PermissionType.ADMINISTRATOR)) {
                                builder.addPermissionOverwrite(
                                        group,
                                        new PermissionsBuilder()
                                                .setDenied(PermissionType.READ_MESSAGES)
                                                .build()
                                );
                            }
                        });

                        builder.addPermissionOverwrite(
                                server.getRoleById(role.get().getId()).get(),
                                new PermissionsBuilder()
                                        .setAllowed(PermissionType.READ_MESSAGES)
                                        .build()
                        );

                        builder.create();

                        event.getChannel().sendMessage(":white_check_mark: La configuration du serveur a été " +
                                "complétée avec succès ! Amusez-vous bien !");
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (user != null) {
                        event.getMessage().delete();
                        user.sendMessage(":x: **" + user.getName() + "**, la configuration est déjà activée pour ce serveur !");
                    }
                }
            } else {
                event.getMessage().delete();

                if (user != null) {
                    user.sendMessage(":no_entry_sign: **" + user.getName() + "**, vous ne pouvez pas exécuter cette commande !");
                }
            }
        }
    }
}
