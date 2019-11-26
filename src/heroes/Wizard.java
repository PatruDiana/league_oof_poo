package heroes;

import common.Constants;

public class Wizard extends Hero {
    Wizard(int row, int col) {
        this.row = row;
        this.col = col;
        this.HP = Constants.Hp_Wizard;
        this.type = "W";
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "row=" + row +
                ", col=" + col +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", XP=" + XP +
                ", HP=" + HP +
                '}';
    }
}
