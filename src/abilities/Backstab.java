package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Backstab extends Abilities implements Visitor {
    private int nrRounds;
    private float woodsModificator;
    Backstab() {
        damage = Constants.DAMAGE_BACKSTAB;
        nrRounds = 0;
        woodsModificator = 1;
    }

    /**
     *
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_BACKSTAB;
    }

    /**
     *
     * @param p
     */
    public void visit(final Pyromancer p) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        dmg += Constants.PYROMANCER_MODIFICATOR_B *  dmg;
        dmg = woods * dmg;
        int result = Math.round(dmg);
        p.setHpCurrent(result);
    }

    /**
     *
     * @param k
     */
    public void visit(final Knight k) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        dmg -= Constants.KNIGHT_MODIFICATOR_B * dmg;
        dmg = woods * dmg;
        int result = Math.round(dmg);
        k.setHpCurrent(result);

    }

    /**
     *
     * @param r
     */
    public void visit(final Rogue r) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        dmg += Constants.ROGUE_MODIFICATOR_B * dmg;
        dmg = woods * dmg;
        int result = Math.round(dmg);
        r.setHpCurrent(result);

    }

    /**
     *
     * @param w
     */
    public void visit(final Wizard w) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        dmg = woods * dmg;
        w.setDamageRec(dmg);
        dmg += Constants.WIZARD_MODIFICATOR_B * dmg;
        int result = Math.round(dmg);
        w.setHpCurrent(result);

    }
}
