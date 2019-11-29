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
     *
     */
    public void setDamage() {
        damageprocent += Constants.EXTRA_PERCENT_DRAIN;
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
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        dmgpercent -= dmgpercent * Constants.PYROMANCER_MODIFICATOR_DR;
        float dmg = dmgpercent * Math.min(Constants.HP_MIN_DRAIN * p.getHpmax(), p.getHpCurrent());
        int result = Math.round(dmg);
        p.setHpCurrent(result);
    }

    /**
     *
     * @param k
     */
    public void visit(final Knight k) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        dmgpercent += dmgpercent * Constants.KNIGHT_MODIFICATOR_DR;
        float dmg = dmgpercent * Math.min(Constants.HP_MIN_DRAIN * k.getHpmax(), k.getHpCurrent());
        int result = Math.round(dmg);
        k.setHpCurrent(result);
    }

    /**
     *
     * @param r
     */
    public void visit(final Rogue r) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        dmgpercent -= dmgpercent * Constants.ROGUE_MODIFICATOR_DR;
        float dmg = dmgpercent * Math.min(Constants.HP_MIN_DRAIN * r.getHpmax(), r.getHpCurrent());
        int result = Math.round(dmg);
        r.setHpCurrent(result);
    }

    /**
     *
     * @param w
     */
    public void visit(final Wizard w) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        float dmg = dmgpercent * Math.min(Constants.HP_MIN_DRAIN * w.getHpmax(), w.getHpCurrent());
        w.setDamageRec(dmg);
        dmgpercent += dmgpercent * Constants.WIRZARD_MODIFICATOR_DR;
        dmg = dmgpercent * Math.min(Constants.HP_MIN_DRAIN * w.getHpmax(), w.getHpCurrent());
        int result = Math.round(dmg);
        w.setHpCurrent(result);
    }
}
