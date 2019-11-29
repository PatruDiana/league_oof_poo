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

    public void createheros() {
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

    public void startgame() {
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < heroes.size(); j++) {
                Character move = arraymoves.get(0);
                heroes.get(j).setMove(move);
                arraymoves.remove(0);
            }
            for (int j = 0; j < heroes.size(); j++) {
                heroes.get(j).damageOvertime();
            }
            for (int j = 0; j < heroes.size(); j++) {
                for (int k = j + 1; k < heroes.size(); k++) {
                    if (heroes.get(j).getRow() == heroes.get(k).getRow()
                            && heroes.get(j).getCol() == heroes.get(k).getCol()) {
                        if (!heroes.get(j).isDeath() && !heroes.get(k).isDeath()) {
                            if (heroes.get(j).getType().equals("W")) {
                                heroes.get(j).fight(heroes.get(k).getAbilities());
                                heroes.get(j).getAbilities().get(1).
                                        setDamagereceived(heroes.get(j).getDamageRec());
                                heroes.get(k).fight(heroes.get(j).getAbilities());
                            } else {
                                heroes.get(k).fight(heroes.get(j).getAbilities());
                                if (heroes.get(k).getType().equals("W")) {
                                    heroes.get(k).getAbilities().get(1).
                                            setDamagereceived(heroes.get(k).getDamageRec());
                                }
                                heroes.get(j).fight(heroes.get(k).getAbilities());

                            }
                            heroes.get(j).setHP();
                            heroes.get(k).setHP();
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
                if (heroes.get(j).getType().equals("W")) {
                    heroes.get(j).resetDamageRec();
                }
            }
        }
    }

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
