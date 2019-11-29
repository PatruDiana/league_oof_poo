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
     *
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_PARAYSIS;
    }

    /**
     *
     * @param p
     */
    public void visit(final Pyromancer p) {
        float dmg = damage;
        float landBonus = landModificator;
        if (Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.WOODS_TYPE) {
            landBonus += common.Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        dmg += Constants.PYROMANCER_MODIFICATOR_P * dmg;
        int result = Math.round(dmg);
        p.setHpCurrent(result);
        if (Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.WOODS_TYPE) {
            int nrRounds = Constants.NR_ROUNDS_OVERTIME_MAX;
            p.setDamageOvertime(result, nrRounds, true);
        } else {
            p.setDamageOvertime(result, nrRoundsOvertime, true);
        }
    }

    /**
     *
     * @param k
     */
    public void visit(final Knight k) {
        float dmg = damage;
        float landBonus = landModificator;
        if (Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        dmg -= Constants.KNIGHT_MODIFICATOR_P * dmg;
        int result = Math.round(dmg);
        k.setHpCurrent(result);
        if (Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.WOODS_TYPE) {
            int nrRounds = Constants.NR_ROUNDS_OVERTIME_MAX;
            k.setDamageOvertime(result, nrRounds, true);
        } else {
            k.setDamageOvertime(result, nrRoundsOvertime, true);
        }

    }

    /**
     *
     * @param r
     */
    public void visit(final Rogue r) {
        float dmg = damage;
        float landBonus = landModificator;
        if (Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.WOODS_TYPE) {
            landBonus += common.Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        dmg -= Constants.ROGUE_MODIFICATOR_P * dmg;
        int result = Math.round(dmg);
        r.setHpCurrent(result);
        if (Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.WOODS_TYPE) {
            int nrRounds = Constants.NR_ROUNDS_OVERTIME_MAX;
            r.setDamageOvertime(result, nrRounds, true);
        } else {
            r.setDamageOvertime(result, nrRoundsOvertime, true);
        }

    }

    /**
     *
     * @param w
     */
    public void visit(final Wizard w) {
        float dmg = damage;
        float landBonus = landModificator;
        if (Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.WOODS_TYPE) {
            landBonus += common.Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        w.setDamageRec(dmg);
        dmg += Constants.WIZARD_MODIFICATOR_P * dmg;
        int result = Math.round(dmg);
        w.setHpCurrent(result);
        if (Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.WOODS_TYPE) {
            int nrRounds = Constants.NR_ROUNDS_OVERTIME_MAX;
            w.setDamageOvertime(result, nrRounds, true);
        } else {
            w.setDamageOvertime(result, nrRoundsOvertime, true);
        }

    }
}
