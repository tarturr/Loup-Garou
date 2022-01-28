package fr.tartur.loupgarou.game.entities;

public enum EntityType {
    VILLAGER(":farmer:", "le villageois"),
    PSYCHIC(":crystal_ball:", "la voyante"),
    CUPIDON(":archery:", "cupidon"),
    LITTLE_GIRL(":girl:", "la petite fille"),
    CAPTAIN(":pilot:", "le capitaine"),
    THIEF(":detective:", "le voleur"),
    HUNTER(":gun:", "le chasseur"),
    WITCH(":scientist:", "la sorcière"),
    WEREWOLF(":wolf:", "le loup-garou");

    private final String emoji;
    private final String name;

    EntityType(String emoji, String name) {
        this.emoji = emoji;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmoji() {
        return emoji;
    }
}
