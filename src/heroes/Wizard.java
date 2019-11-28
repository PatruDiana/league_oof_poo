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
    }


    @Override
    public void accept(Visitor v) {
            v.visit(this);
    }

    public void setDamage_rec(float damage_rec) {
        this.damage_rec += Math.round(damage_rec);
    }

    public int getDamage_rec() {
        return damage_rec;
    }
}
