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
     * update the base damage of Ignite ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_IGNITE;
        damageOvertime += Constants.EXTRA_DAMAGE_OVERTIME_IGNITE;
    }

    /**
     * applying the Ignite ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float dmg = damage;
        float dmgOvertime = damageOvertime;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmgOvertime = dmgOvertime * landBonus;
        // applying the race modifier
        dmg -= Constants.PYROMANCER_MODIFICATOR_I * dmg;
        // set the damage overtime
        dmgOvertime -= Constants.PYROMANCER_MODIFICATOR_I * dmgOvertime;
        int result = Math.round(dmg);
        int resultOvertime = Math.round(dmgOvertime);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
        // setting the damage overtime on the opponent
        p.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }

    /**
     * applying the Ignite ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float dmg = damage;
        float dmgOvertime = damageOvertime;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmgOvertime = dmgOvertime * landBonus;
        // applying the race modifier
        dmg += Constants.KNIGHT_MODIFICATOR_I * dmg;
        // set the damage overtime
        dmgOvertime += Constants.KNIGHT_MODIFICATOR_I * dmgOvertime;
        int result = Math.round(dmg);
        int resultOvertime = Math.round(dmgOvertime);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
        // setting the damage overtime on the opponent
        k.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }

    /**
     * applying the Ignite ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float dmg = damage;
        float dmgOvertime = damageOvertime;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmgOvertime = dmgOvertime * landBonus;
        // applying the race modifier
        dmg -= Constants.ROGUE_MODIFICATOR_I * dmg;
        // set the damage overtime
        dmgOvertime -= Constants.ROGUE_MODIFICATOR_I * dmgOvertime;
        int result = Math.round(dmg);
        int resultOvertime = Math.round(dmgOvertime);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
        r.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }

    /**
     * applying the Ignite ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float dmg = damage;
        float dmgOvertime = damageOvertime;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(dmg);
        dmgOvertime = dmgOvertime * landBonus;
        // applying the race modifier
        dmg += Constants.WIZARD_MODIFICATOR_F * dmg;
        // set the damage overtime
        dmgOvertime += Constants.WIZARD_MODIFICATOR_I * dmgOvertime;
        int result = Math.round(dmg);
        int resultOvertime = Math.round(dmgOvertime);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);
        // setting the damage overtime on the opponent
        w.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }
}
