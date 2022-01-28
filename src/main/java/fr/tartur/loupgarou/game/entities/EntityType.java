package fr.tartur.loupgarou.game.entities;

import java.awt.*;

public enum EntityType {
    VILLAGER(":farmer:", "le villageois", Color.decode("#E5C87A")),
    PSYCHIC(":crystal_ball:", "la voyante", Color.decode("#702D5F")),
    CUPIDON(":archery:", "cupidon", Color.decode("#0685B9")),
    LITTLE_GIRL(":girl:", "la petite fille", Color.decode("#2E2E3E")),
    CAPTAIN(":pilot:", "le capitaine", Color.decode("#EB4F2E")),
    THIEF(":detective:", "le voleur", Color.decode("#1E737D")),
    HUNTER(":gun:", "le chasseur", Color.decode("#B7A94A")),
    WITCH(":scientist:", "la sorcière", Color.decode("#DF5C26")),
    WEREWOLF(":wolf:", "le loup-garou", Color.decode("#952B33"));

    private final String emoji;
    private final String name;
    private final Color color;

    EntityType(String emoji, String name, Color color) {
        this.emoji = emoji;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getEmoji() {
        return emoji;
    }

    public Color getColor() {
        return color;
    }
}
