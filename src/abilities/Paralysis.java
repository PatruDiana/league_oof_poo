package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.Map;

public class Paralysis extends Abilities implements Visitor {
    public Paralysis() {
        damage = Constants.DAMAGE_PARALYSIS;
        nrRoundsOvertime = Constants.NR_ROUNDS_OVERTIME_MIN;
    }

    /**
     * update the base damage of Paralysis ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_PARAYSIS;
    }

    /**
     * applying the Paralysis ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.WOODS_TYPE) {
            landBonus += common.Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        // applying the race modifier
        dmg += Constants.PYROMANCER_MODIFICATOR_P * dmg;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
        // set the damage overtime
        if (Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.WOODS_TYPE) {
            int nrRounds = Constants.NR_ROUNDS_OVERTIME_MAX;
            p.setDamageOvertime(result, nrRounds, true);
        } else {
            p.setDamageOvertime(result, nrRoundsOvertime, true);
        }
    }

    /**
     * applying the Paralysis ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        // applying the race modifier
        dmg -= Constants.KNIGHT_MODIFICATOR_P * dmg;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
        // set the damage overtime
        if (Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.WOODS_TYPE) {
            int nrRounds = Constants.NR_ROUNDS_OVERTIME_MAX;
            k.setDamageOvertime(result, nrRounds, true);
        } else {
            k.setDamageOvertime(result, nrRoundsOvertime, true);
        }

    }

    /**
     * applying the Paralysis ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.WOODS_TYPE) {
            landBonus += common.Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        // applying the race modifier
        dmg -= Constants.ROGUE_MODIFICATOR_P * dmg;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
        // set the damage overtime
        if (Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.WOODS_TYPE) {
            int nrRounds = Constants.NR_ROUNDS_OVERTIME_MAX;
            r.setDamageOvertime(result, nrRounds, true);
        } else {
            r.setDamageOvertime(result, nrRoundsOvertime, true);
        }

    }

    /**
     * applying the Paralysis ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.WOODS_TYPE) {
            landBonus += common.Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(dmg);
        // applying the race modifier
        dmg += Constants.WIZARD_MODIFICATOR_P * dmg;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);
        // set the damage overtime
        if (Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.WOODS_TYPE) {
            int nrRounds = Constants.NR_ROUNDS_OVERTIME_MAX;
            w.setDamageOvertime(result, nrRounds, true);
        } else {
            w.setDamageOvertime(result, nrRoundsOvertime, true);
        }

    }
}
