package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Slam extends Abilities implements Visitor {
    public Slam() {
        damage = Constants.DAMAGE_SLAM;
        nrRoundsOvertime = Constants.NR_ROUNDS_OVERTIME_S;
    }

    /**
     * update the base damage of Slam ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_SLAM;
    }

    /**
     * applying the Slam ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        // applying the race modifier
        dmg -= dmg * Constants.PYROMANCER_MODIFICATOR_S;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
        // set the damage overtime
        p.setDamageOvertime(0, nrRoundsOvertime, true);
    }

    /**
     * applying the Slam ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        // applying the race modifier
        dmg += dmg * Constants.KNIGHT_MODIFICATOR_S;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
        // set the damage overtime
        k.setDamageOvertime(0, nrRoundsOvertime, true);

    }

    /**
     * applying the Slam ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        // applying the race modifier
        dmg -= dmg * Constants.ROGUE_MODIFICATOR_S;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
        // set the damage overtime
        r.setDamageOvertime(0, nrRoundsOvertime, true);

    }

    /**
     *  applying the Slam ability to the Wizard hero type.
     *  @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(dmg);
        // applying the race modifier
        dmg += dmg * Constants.WIZARD_MODIFICATOR_S;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);
        // set the damage overtime
        w.setDamageOvertime(0, nrRoundsOvertime, true);
    }
}
