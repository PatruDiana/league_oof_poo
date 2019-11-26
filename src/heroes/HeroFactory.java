package heroes;

public class HeroFactory {
    public static Hero getHero(String type, int row, int col) {
        if ("P".equalsIgnoreCase(type)) return new Pyromancer(row, col);
        else if ("K".equalsIgnoreCase(type)) return new Knight(row, col);
        else if ("W".equalsIgnoreCase(type)) return new Wizard(row, col);
        else return new Rogue(row, col);
    }
}
