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
     *
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_SLAM;
    }

    /**
     *
     * @return
     */
    public int getDamage() {
        return damage;
    }

    /**
     *
     * @param p
     */
    public void visit(final Pyromancer p) {
        float dmg = damage;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        dmg -= dmg * Constants.PYROMANCER_MODIFICATOR_S;
        int result = Math.round(dmg);
        p.setHpCurrent(result);
        p.setDamageOvertime(0, nrRoundsOvertime, true);
    }

    /**
     *
     * @param k
     */
    public void visit(final Knight k) {
        float dmg = damage;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        dmg += dmg * Constants.KNIGHT_MODIFICATOR_S;
        int result = Math.round(dmg);
        k.setHpCurrent(result);
        k.setDamageOvertime(0, nrRoundsOvertime, true);

    }

    /**
     *
     * @param r
     */
    public void visit(final Rogue r) {
        float dmg = damage;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        dmg -= dmg * Constants.ROGUE_MODIFICATOR_S;
        int result = Math.round(dmg);
        r.setHpCurrent(result);
        r.setDamageOvertime(0, nrRoundsOvertime, true);

    }

    /**
     *
     * @param w
     */
    public void visit(final Wizard w) {
        float dmg = damage;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        w.setDamageRec(dmg);
        dmg += dmg * Constants.WIZARD_MODIFICATOR_S;
        int result = Math.round(dmg);
        w.setHpCurrent(result);
        w.setDamageOvertime(0, nrRoundsOvertime, true);
    }
}
