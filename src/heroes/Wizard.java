package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;


public class Wizard extends Hero {
    Wizard(final int row, final int col) {
        this.row = row;
        this.col = col;
        this.hp = Constants.HP_WIZARD;
        this.type = "W";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.hpCurrent = Constants.HP_WIZARD;
        this.hpmax = Constants.HP_WIZARD;
    }

    /**
     * requires the visitor to visit the current hero.
     * @param v
     */
    public void accept(final Visitor v) {
            v.visit(this);
    }
    /**
     * set the maximum hp with the level update.
     */
    public void setHPmax() {
        hpmax += common.Constants.EXTRA_HP_WIZARD;
        hp = hpmax;
        hpCurrent = hpmax;
    }
}
