package heroes;

import common.Constants;

public class Rogue extends Hero {
    Rogue(int row, int col) {
        this.row = row;
        this.col = col;
        this.HP = Constants.Hp_Roque;
        this.type = "R";
    }

    @Override
    public String toString() {
        return "Rogue{" +
                "row=" + row +
                ", col=" + col +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", XP=" + XP +
                ", HP=" + HP +
                '}';
    }

    @Override
    public void accept(abilities.Visitor v) {

    }
}
