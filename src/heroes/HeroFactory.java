package heroes;

public final class HeroFactory {
    private HeroFactory() {
        //for checkstyle
    }
    public static Hero getHero(final String type, final int row, final int col) {
        if ("P".equalsIgnoreCase(type)) {
            return new Pyromancer(row, col);
        } else if ("K".equalsIgnoreCase(type)) {
            return new Knight(row, col);
        } else if ("W".equalsIgnoreCase(type)) {
            return new Wizard(row, col);
        } else {
            return new Rogue(row, col);
        }
    }
}
