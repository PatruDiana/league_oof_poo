package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;


public class Knight extends Hero {
    Knight(int row, int col) {
        this.row = row;
        this.col = col;
        this.HP = Constants.Hp_Knight;
        this.type = "K";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.HP_current = Constants.Hp_Knight;
    }


    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
