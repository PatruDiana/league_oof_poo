package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;


public class Wizard extends Hero {
    private int damage_rec;
    Wizard(int row, int col) {
        this.row = row;
        this.col = col;
        this.HP = Constants.Hp_Wizard;
        this.type = "W";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.HP_current = Constants.Hp_Wizard;
        this.HP_max = Constants.Hp_Wizard;
    }


    @Override
    public void accept(Visitor v) {
            v.visit(this);
    }
    public void setHPmax() {
        HP_max += common.Constants.Extra_Hp_Wizard;
        HP = HP_max;
        HP_current = HP_max;
    }
}
