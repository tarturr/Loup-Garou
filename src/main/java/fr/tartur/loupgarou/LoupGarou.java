package fr.tartur.loupgarou;

import fr.tartur.loupgarou.commands.SetupCommand;
import fr.tartur.loupgarou.commands.UnSetupCommand;
import fr.tartur.loupgarou.commands.WitchTestCommand;
import io.github.cdimascio.dotenv.Dotenv;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.*;

public class LoupGarou {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();

        DiscordApi api = new DiscordApiBuilder().setToken(dotenv.get("TOKEN")).login().join();
        api.addMessageCreateListener(new SetupCommand(api));
        api.addMessageCreateListener(new UnSetupCommand(api));
        api.addMessageCreateListener(new WitchTestCommand());

    }

}
