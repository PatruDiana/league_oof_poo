package main;

public class Main {
    public static void main(String[] args) {
//        String input = "/home/diana/Desktop/league_of_oop/checker/checker/resources/in/fightKWL.in";
        String input = "/home/diana/Desktop/league_of_oop/checker/checker/resources/in/4x4.in";
        String output="/home/diana/Desktop/output.out";
        GameInputLoader gameInputLoader = new GameInputLoader(input, output);
//        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
         gameInputLoader.load();
         Game game = Game.getInstance();
         game.createheros();
         game.startgame();
    }
}
