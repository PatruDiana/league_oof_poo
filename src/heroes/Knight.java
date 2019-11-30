package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;


public class Knight extends Hero {
    Knight(final int row, final int col) {
        this.row = row;
        this.col = col;
        this.hp = Constants.HP_KNIGHT;
        this.type = "K";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.hpCurrent = Constants.HP_KNIGHT;
        this.hpmax = Constants.HP_KNIGHT;
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
        hpmax += common.Constants.EXTRA_HP_KNIGHT;
        hp = hpmax;
        hpCurrent = hpmax;
    }
}
