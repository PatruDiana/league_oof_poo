package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Ignite extends Abilities implements Visitor {
    Ignite() {
        damage = Constants.DAMAGE_IGNITE;
        damageOvertime = Constants.DAMAGE_OVERTIME_IGNITE;
        nrRoundsOvertime = Constants.NR_ROUNDS_OVERTIME_I;
    }

    /**
     *
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_IGNITE;
        damageOvertime += Constants.EXTRA_DAMAGE_OVERTIME_IGNITE;
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
        float dmgOvertime = damageOvertime;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmgOvertime = dmgOvertime * landBonus;
        dmg -= Constants.PYROMANCER_MODIFICATOR_I * dmg;
        dmgOvertime -= Constants.PYROMANCER_MODIFICATOR_I * dmgOvertime;
        int result = Math.round(dmg);
        int resultOvertime = Math.round(dmgOvertime);
        p.setHpCurrent(result);
        p.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }

    /**
     *
     * @param k
     */
    public void visit(final Knight k) {
        float dmg = damage;
        float dmgOvertime = damageOvertime;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmgOvertime = dmgOvertime * landBonus;
        dmg += Constants.KNIGHT_MODIFICATOR_I * dmg;
        dmgOvertime += Constants.KNIGHT_MODIFICATOR_I * dmgOvertime;
        int result = Math.round(dmg);
        int resultOvertime = Math.round(dmgOvertime);
        k.setHpCurrent(result);
        k.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }

    /**
     *
     * @param r
     */
    public void visit(final Rogue r) {
        float dmg = damage;
        float dmgOvertime = damageOvertime;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmgOvertime = dmgOvertime * landBonus;
        dmg -= Constants.ROGUE_MODIFICATOR_I * dmg;
        dmgOvertime -= Constants.ROGUE_MODIFICATOR_I * dmgOvertime;
        int result = Math.round(dmg);
        int resultOvertime = Math.round(dmgOvertime);
        r.setHpCurrent(result);
        r.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }

    /**
     *
     * @param w
     */
    public void visit(final Wizard w) {
        float dmg = damage;
        float dmgOvertime = damageOvertime;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        w.setDamageRec(dmg);
        dmgOvertime = dmgOvertime * landBonus;
        dmg += Constants.WIZARD_MODIFICATOR_F * dmg;
        dmgOvertime += Constants.WIZARD_MODIFICATOR_I * dmgOvertime;
        int result = Math.round(dmg);
        int resultOvertime = Math.round(dmgOvertime);
        w.setHpCurrent(result);
        w.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }
}
