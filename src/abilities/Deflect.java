package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Deflect extends Abilities implements Visitor {
    Deflect() {
      damageprocent = Constants.PERCENT_DEFLECT;
    }

    /**
     * update the base damage of Deflect ability as the hero's level increases.
     */
    public void setDamage() {
        if (damageprocent < Constants.MAXIM_PERCENT_DEFLECT - 1) {
            damageprocent += Constants.EXTRA_PERCENT_DEFLECT;
        }
    }

    /**
     * set the damage received by the Wizard for Deflect ability.
     * @param damagereceived - damage received by the Wizard.
     */
    public void setDamagereceived(final int damagereceived) {
        damage = damagereceived;
    }

    /**
     * applying the Deflect ability to the Pyromancer hero type.
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
        dmgpercent += dmgpercent * Constants.PYROMANCER_MODIFICATOR_DE;
        float dmg = dmgpercent * damage;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
    }

    /**
     * applying the Deflect ability to the Knight hero type.
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
        dmgpercent += dmgpercent * Constants.KNIGHT_MODIFICATOR_DE;
        float dmg = dmgpercent * damage;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
    }

    /**
     * applying the Deflect ability to the Rogue hero type.
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
        dmgpercent += dmgpercent * Constants.ROQUE_MODIFICATOR_DE;
        float dmg = dmgpercent * damage;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
    }

    /**
     * The Deflect ability has no effect on a Wizard hero.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {

    }
}
