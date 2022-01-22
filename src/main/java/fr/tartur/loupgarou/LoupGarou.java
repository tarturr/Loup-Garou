package fr.tartur.loupgarou;

import fr.tartur.loupgarou.commands.SetupCommand;
import fr.tartur.loupgarou.commands.UnSetupCommand;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.*;

public class LoupGarou {

    public static void main(String[] args) {

        DiscordApi api = new DiscordApiBuilder().setToken(getToken()).login().join();
        api.addMessageCreateListener(new SetupCommand(api));
        api.addMessageCreateListener(new UnSetupCommand(api));

    }

    private static String getToken() {
        String path = "C:/Users/Arthur/Documents/Développement/discbots-token/loup-garou.txt";
        System.out.println(path);
        File token = new File(path);

        if (!token.exists()) {
            throw new RuntimeException("Le token du bot Discord n'a pas pu être trouvé ! :(");
        }

        try {
            return new BufferedReader(new FileReader(token)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
