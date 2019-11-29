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
     *
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_FIREBLAST;
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
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmg -= Constants.PYROMANCER_MODIFICATOR_F * dmg;
        int result = Math.round(dmg);
        p.setHpCurrent(result);
    }

    /**
     *
     * @param k
     */
    public void visit(final Knight k) {
        float dmg = damage;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmg += Constants.KNIGHT_MODIFICATOR_F * dmg;
        int result = Math.round(dmg);
        k.setHpCurrent(result);
    }

    /**
     *
     * @param r
     */
    public void visit(final Rogue r) {
        float dmg = damage;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmg -= Constants.ROGUE_MODIFICATOR_F * dmg;
        int result = Math.round(dmg);
        r.setHpCurrent(result);
    }

    /**
     *
     * @param w
     */
    public void visit(final Wizard w) {
        float dmg = damage;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        w.setDamageRec(dmg);
        dmg += common.Constants.WIZARD_MODIFICATOR_F * dmg;
        int result = Math.round(dmg);
        w.setHpCurrent(result);
    }
}
