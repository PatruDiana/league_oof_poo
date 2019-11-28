package main;

import heroes.Hero;
import heroes.HeroFactory;

import java.nio.file.FileSystem;
import java.util.ArrayList;

public class Game {
    private static Game instance = null;
    private ArrayList<Hero> heroes;
    private ArrayList<String> playersinfo;
    private ArrayList<Integer> coordplayers;
    private ArrayList<Character> arraymoves;
    private int rounds;

    private Game(ArrayList<String> playersinfo, ArrayList<Integer> coordplayers,
                 ArrayList<Character> arraymoves, int rounds) {
        this.playersinfo = playersinfo;
        this.heroes = new ArrayList<>(playersinfo.size());
        this.arraymoves = arraymoves;
        this.coordplayers = coordplayers;
        this.rounds = rounds;
    }

    static Game getInstance(ArrayList<String> playersinfo, ArrayList<Integer> coordplayers,
                            ArrayList<Character> arraymoves, int rounds) {
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
            Hero hero = HeroFactory.getHero(playersinfo.get(i), coordplayers.get(coord1), coordplayers.get(coord2));
            heroes.add(hero);
            coord1 = coord1 + 2;
            coord2 = coord1 + 1;
        }
    }

    public void startgame() {
//        for (int i = 0; i < heroes.size(); i++) {
//            System.out.println(heroes.get(i).toString());
//        }
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < heroes.size(); j++) {
                Character move = arraymoves.get(0);
//                System.out.println(move);
                heroes.get(j).setMove(move);
                arraymoves.remove(0);
//                for(char e : arraymoves) {
//                    System.out.println(e + " ");
//                }
//                System.out.println(heroes.get(j).toString());
            }
            for (int j = 0; j < heroes.size(); j++) {
                heroes.get(j).Damage_Overtime();
            }
            for (int j = 0; j < heroes.size(); j++) {
                for (int k = j + 1; k < heroes.size(); k++) {
                    if (heroes.get(j).getRow() == heroes.get(k).getRow() &&
                            heroes.get(j).getCol() == heroes.get(k).getCol()) {

//                        System.out.println(heroes.get(j).getRow() + " " + heroes.get(k).getCol());
                        if(!heroes.get(j).isDeath() || !heroes.get(k).isDeath()) {
                            if (heroes.get(j).getType().equals("W")) {
                                System.out.println("da");
                                heroes.get(k).fight(heroes.get(j).getAbilities());
                                heroes.get(j).fight(heroes.get(k).getAbilities());
                            } else {
                                heroes.get(j).fight(heroes.get(k).getAbilities());
                                heroes.get(k).fight(heroes.get(j).getAbilities());
                            }
                        }
//                        System.out.println(heroes.get(j).getHP_current());
//                        System.out.println(heroes.get(k).getHP_current());
                        heroes.get(j).setHP();
                        heroes.get(k).setHP();
//                        System.out.println(heroes.get(j).getHP());
//                        System.out.println(heroes.get(k).getHP());
                        if(heroes.get(j).isDeath()) {
                            heroes.get(k).setXP(heroes.get(j).getLevel());
                        }
                        if (heroes.get(k).isDeath()) {
                            heroes.get(j).setXP(heroes.get(k).getLevel());
                        }
                    }
                }
            }
            for (int j = 0; j < heroes.size(); j++) {
                if (heroes.get(j).getType().equals("W")) {
                    heroes.get(j).resetDamageRec();
                }
            }
            //to do  wizard.resetdamagerecv
            System.out.println();
            for(Hero hero : heroes) {
                System.out.println(hero.toString());
//                System.out.println(hero.isDeath());
            }
        }
    }

    public void printboard(String input, String output) {
        try {
            fileio.FileSystem fs = new fileio.FileSystem(input, output);
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