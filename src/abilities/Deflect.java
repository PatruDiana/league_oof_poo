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
     *
     */
    public void setDamage() {
        if (damageprocent < Constants.MAXIM_PERCENT_DEFLECT - 1) {
            damageprocent += Constants.EXTRA_PERCENT_DEFLECT;
        }
    }

    /**
     *
     * @param damagereceived
     */
    public void setDamagereceived(final int damagereceived) {
        damage = damagereceived;
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
        dmgpercent += dmgpercent * Constants.PYROMANCER_MODIFICATOR_DE;
        float dmg = dmgpercent * damage;
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
        dmgpercent += dmgpercent * Constants.KNIGHT_MODIFICATOR_DE;
        float dmg = dmgpercent * damage;
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
        dmgpercent += dmgpercent * Constants.ROQUE_MODIFICATOR_DE;
        float dmg = dmgpercent * damage;
        int result = Math.round(dmg);
        r.setHpCurrent(result);
    }

    /**
     *
     * @param w
     */
    public void visit(final Wizard w) {

    }
}
