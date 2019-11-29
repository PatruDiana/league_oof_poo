package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;

public class Pyromancer extends Hero {
    Pyromancer(int row, int col) {
        this.row = row;
        this.col = col;
        this.HP = Constants.Hp_Pyromancer;
        this.type = "P";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.HP_current = Constants.Hp_Pyromancer;
        this.HP_max = Constants.Hp_Pyromancer;
    }



    @Override
    public void accept(Visitor v) {
            v.visit(this);
    }
    public void setHPmax() {
        HP_max += common.Constants.Extra_Hp_Pyromancer;
        HP = HP_max;
        HP_current = HP_max;
    }
}
