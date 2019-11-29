package main;

public class Main {
    public static void main(String[] args) {
//        String input = "/home/diana/Desktop/league_of_oop/checker/checker/resources/in/fightKKD.in";
//        String input = "/home/diana/Desktop/league_of_oop/checker/checker/resources/in/fightKPD.in";
//        String input = "/home/diana/Desktop/league_of_oop/checker/checker/resources/in/3x3.in";
//        String output="/home/diana/Desktop/output.out";
//        GameInputLoader gameInputLoader = new GameInputLoader(input, output);
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
         gameInputLoader.load();
         Game game = Game.getInstance();
         game.createheros();
         game.startgame();
//         game.printboard(input, output);
         game.printboard(args[0], args[1]);
    }
}
