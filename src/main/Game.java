package main;
import fileio.FileSystem;
import heroes.Hero;
import heroes.HeroFactory;
import java.util.ArrayList;

public final class Game {
    private static Game instance = null;
    private ArrayList<Hero> heroes;
    private ArrayList<String> playersinfo;
    private ArrayList<Integer> coordplayers;
    private ArrayList<Character> arraymoves;
    private int rounds;

    private Game(final ArrayList<String> playersinfo, final ArrayList<Integer> coordplayers,
                final ArrayList<Character> arraymoves, final int rounds) {
        this.playersinfo = playersinfo;
        this.heroes = new ArrayList<>(playersinfo.size());
        this.arraymoves = arraymoves;
        this.coordplayers = coordplayers;
        this.rounds = rounds;
    }

    static Game getInstance(final ArrayList<String> playersinfo,
                            final ArrayList<Integer> coordplayers,
                            final ArrayList<Character> arraymoves, final int rounds) {
        instance = new Game(playersinfo, coordplayers, arraymoves, rounds);
        return instance;
    }

    static Game getInstance() {
        return instance;
    }

    /**
     * create the heroes with the initial position.
     */
    public void createheroes() {
        int coord1 = 0;
        int coord2 = 1;
        for (int i = 0; i < playersinfo.size(); i++) {
            Hero hero = HeroFactory.getHero(playersinfo.get(i),
                    coordplayers.get(coord1), coordplayers.get(coord2));
            heroes.add(hero);
            coord1 = coord1 + 2;
            coord2 = coord1 + 1;
        }
    }

    /**
     * conducting the game itself.
     */
    public void startgame() {
        for (int i = 0; i < rounds; i++) {
            // each player moves properly on the map if it is not frozen.
            for (int j = 0; j < heroes.size(); j++) {
                Character move = arraymoves.get(0);
                heroes.get(j).setMove(move);
                arraymoves.remove(0);
            }
            // applying for overtime damage at the beginning of each round.
            for (int j = 0; j < heroes.size(); j++) {
                heroes.get(j).damageOvertime();
            }
            for (int j = 0; j < heroes.size(); j++) {
                for (int k = j + 1; k < heroes.size(); k++) {
                    // finding the opponent
                    if (heroes.get(j).getRow() == heroes.get(k).getRow()
                            && heroes.get(j).getCol() == heroes.get(k).getCol()) {
                        // checking if the two players can fight
                        if (!heroes.get(j).isDeath() && !heroes.get(k).isDeath()) {
                            // if the wizard player is the first, the opponent must attack first
                            // to set the damage received
                            if (heroes.get(j).getType().equals("W")) {
                                heroes.get(j).fight(heroes.get(k).getAbilities());
                                // set the damage reveived to Deflect ability
                                heroes.get(j).getAbilities().get(1).
                                        setDamagereceived(heroes.get(j).getDamageRec());
                                heroes.get(k).fight(heroes.get(j).getAbilities());
                            } else {
                                heroes.get(k).fight(heroes.get(j).getAbilities());
                                // check if the hero is a Wizard
                                if (heroes.get(k).getType().equals("W")) {
                                    // set the damage reveived to Deflect ability
                                    heroes.get(k).getAbilities().get(1).
                                            setDamagereceived(heroes.get(k).getDamageRec());
                                }
                                heroes.get(j).fight(heroes.get(k).getAbilities());

                            }
                            // setting the hp of the 2 players with the current one
                            heroes.get(j).setHP();
                            heroes.get(k).setHP();
                            // if he won the fight, assign the appropriate xp
                            if (heroes.get(j).isDeath()) {
                                heroes.get(k).setXp(heroes.get(j).getLevel());
                            }
                            if (heroes.get(k).isDeath()) {
                                heroes.get(j).setXp(heroes.get(k).getLevel());
                            }

                        }
                    }
                }
            }
            for (int j = 0; j < heroes.size(); j++) {
                // reset the heroes.Wizard player's overtime damage after each fight.
                if (heroes.get(j).getType().equals("W")) {
                    heroes.get(j).resetDamageRec();
                }
            }
        }
    }

    /**
     * print the final broad game
     * @param input - file input
     * @param output - file output 
     */
    public void printboard(final String input, final String output) {
        try {
            FileSystem fs = new FileSystem(input, output);
            for (int i = 0; i < heroes.size(); i++) {
                fs.writeWord(heroes.get(i).toString());
                fs.writeNewLine();
            }
            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
