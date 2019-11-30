package main;

public final class Main {
    private Main() {
        //for checkstyle
    }
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
         gameInputLoader.load();
         Game game = Game.getInstance();
         game.createheroes();
         game.startgame();
         game.printboard(args[0], args[1]);
    }
}
