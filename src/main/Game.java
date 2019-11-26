package main;

import heroes.Hero;
import heroes.HeroFactory;
import java.util.ArrayList;

public class Game {
    private static Game instance = null;
    private ArrayList<Hero> heros;
    private ArrayList<String> playersinfo;
    private ArrayList<Integer> coordplayers;
    private ArrayList<Character> arraymoves;
    private int rounds;

    private Game(ArrayList<String> playersinfo, ArrayList<Integer> coordplayers,
                 ArrayList<Character> arraymoves, int rounds){
        this.playersinfo = playersinfo;
        this.heros = new ArrayList<>(playersinfo.size());
        this.arraymoves = arraymoves;
        this.coordplayers = coordplayers;
        this.rounds= rounds;
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
            heros.add(hero);
            coord1 = coord1 + 2;
            coord2 = coord1 + 1;
        }
    }
    public void startgame() {
        for (int i = 0; i < heros.size(); i++) {
            System.out.println(heros.get(i).toString());
        }
    }
}
