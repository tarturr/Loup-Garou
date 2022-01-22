package fr.tartur.loupgarou;

import fr.tartur.loupgarou.commands.SetupCommand;
import fr.tartur.loupgarou.commands.UnSetupCommand;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class LoupGarou {

    private static final String token = "OTM0MTYyNTIzNjk4MTM1MTQx.YesEpQ.iSNi46lJLwog5u3SdlHDQN-8h58";

    public static void main(String[] args) {

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        api.addMessageCreateListener(new SetupCommand(api));
        api.addMessageCreateListener(new UnSetupCommand(api));

    }

}
