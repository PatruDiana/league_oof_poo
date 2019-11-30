package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Fireblast extends Abilities implements Visitor {
    Fireblast() {
        damage = Constants.DAMAGE_FIREBLAST;
    }

    /**
     * update the base damage of Fireblast ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_FIREBLAST;
    }

    /**
     * applying the Fireblast ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        // applying the race modifier
        dmg -= Constants.PYROMANCER_MODIFICATOR_F * dmg;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
    }

    /**
     * applying the Fireblast ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        // applying the race modifier
        dmg += Constants.KNIGHT_MODIFICATOR_F * dmg;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
    }

    /**
     * applying the Fireblast ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        // applying the race modifier
        dmg -= Constants.ROGUE_MODIFICATOR_F * dmg;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
    }

    /**
     * applying the Fireblast ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(dmg);
        // applying the race modifier
        dmg += common.Constants.WIZARD_MODIFICATOR_F * dmg;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);
    }
}
