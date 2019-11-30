package abilities;

import java.util.ArrayList;

public final class AbilitiesFactory {
    private AbilitiesFactory() {
        //for checkstyle
    }
    public static ArrayList<Abilities> getAbilities(final String type) {
        ArrayList<Abilities> newAbilities = new ArrayList<>(2);
        // check the hero type to assign each one the appropriate abilities
        if ("P".equalsIgnoreCase(type)) {
            Abilities ability1 = new Fireblast();
            newAbilities.add(ability1);
            Abilities ability2 = new Ignite();
            newAbilities.add(ability2);
        } else if ("K".equalsIgnoreCase(type)) {
            Abilities ability1 = new Execute();
            newAbilities.add(ability1);
            Abilities ability2 = new Slam();
            newAbilities.add(ability2);
        } else if ("W".equalsIgnoreCase(type)) {
            Abilities ability1 = new Drain();
            newAbilities.add(ability1);
            Abilities ability2 = new Deflect();
            newAbilities.add(ability2);
        } else {
            Abilities ability1 = new Backstab();
            newAbilities.add(ability1);
            Abilities ability2 = new Paralysis();
            newAbilities.add(ability2);
        }
        return newAbilities;
    }
}
