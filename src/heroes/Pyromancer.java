package heroes;

import common.Constants;

public class Pyromancer extends Hero {
    Pyromancer(int row, int col) {
        this.row = row;
        this.col = col;
        this.HP = Constants.Hp_Pyromancer;
        this.type = "P";
    }

    @Override
    public String toString() {
        return "Pyromancer{" +
                "row=" + row +
                ", col=" + col +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", XP=" + XP +
                ", HP=" + HP +
                '}';
    }
}
