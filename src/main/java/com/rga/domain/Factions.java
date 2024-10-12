package com.rga.domain;

import java.util.Arrays;

public enum Factions {
    IRONBLOOD("Iron Blood"),
    SAKURAEMPIRE("Sakura Empire"),
    ROYALNAVY("Royal Navy"),
    EAGLEUNION("Eagle Union"),
    DRAGONEMPERY("Dragon Empery"),
    NORTHERNPARLIAMENT("Northern Parliament"),
    IRISORTHODOXY("Iris Orthodoxy"),
    IRISLIBRE("Iris Libre"),
    VICHIADOMINION("Vichya Dominion"),
    SARDEGNAEMPIRE("Sardegna Empire");


    private final String faction;

    Factions(String faction) {
        this.faction = faction;
    }

    public String getFactionName() {
        return faction;
    }

    public static boolean validFaction(String factionName) {
        return Arrays.stream(Factions.values())
                .anyMatch(f -> f.getFactionName().equals(factionName));
    }
}
