package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;


public class Rogue extends Hero {
    Rogue(int row, int col) {
        this.row = row;
        this.col = col;
        this.HP = Constants.Hp_Roque;
        this.type = "R";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.HP_current = Constants.Hp_Roque;
        this.HP_max = Constants.Hp_Roque;
    }


    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    public void setHPmax() {
        HP_max += common.Constants.Extra_Hp_Rogue;
        HP = HP_max;
        HP_current = HP_max;
    }
}