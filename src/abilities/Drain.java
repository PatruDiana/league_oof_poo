package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Drain extends Abilities implements Visitor {

    public Drain() {
        damageprocent = Constants.PERCENT_DRAIN;
    }

    /**
     * update the base damage of Drain ability as the hero's level increases.
     */
    public void setDamage() {
        damageprocent += Constants.EXTRA_PERCENT_DRAIN;
    }

    /**
     * applying the Drain ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        // applying the race modifier
        dmgpercent -= dmgpercent * Constants.PYROMANCER_MODIFICATOR_DR;
        float dmg = dmgpercent * Math.min(Constants.HP_MIN_DRAIN * p.getHpmax(), p.getHpCurrent());
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
    }

    /**
     * applying the Drain ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        // applying the race modifier
        dmgpercent += dmgpercent * Constants.KNIGHT_MODIFICATOR_DR;
        float dmg = dmgpercent * Math.min(Constants.HP_MIN_DRAIN * k.getHpmax(), k.getHpCurrent());
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
    }

    /**
     * applying the Drain ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        // applying the race modifier
        dmgpercent -= dmgpercent * Constants.ROGUE_MODIFICATOR_DR;
        float dmg = dmgpercent * Math.min(Constants.HP_MIN_DRAIN * r.getHpmax(), r.getHpCurrent());
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
    }

    /**
     * applying the Drain ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        float dmg = dmgpercent * Math.min(Constants.HP_MIN_DRAIN * w.getHpmax(), w.getHpCurrent());
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(dmg);
        // applying the race modifier
        dmgpercent += dmgpercent * Constants.WIRZARD_MODIFICATOR_DR;
        dmg = dmgpercent * Math.min(Constants.HP_MIN_DRAIN * w.getHpmax(), w.getHpCurrent());
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);
    }
}
