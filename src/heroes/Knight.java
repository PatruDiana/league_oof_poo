package heroes;

import common.Constants;

public class Knight extends Hero {
    Knight(int row, int col) {
        this.row = row;
        this.col = col;
        this.HP = Constants.Hp_Knight;
        this.type = "K";
    }

    @Override
    public String toString() {
        return "Knight{" +
                "row=" + row +
                ", col=" + col +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", XP=" + XP +
                ", HP=" + HP +
                '}';
    }
}
