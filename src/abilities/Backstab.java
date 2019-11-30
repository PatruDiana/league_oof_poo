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
     * update the base damage of Backstab ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_BACKSTAB;
    }

    /**
     * applying the Backstab ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        // the possibility of a critical hit
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        // applying the race modifier
        dmg += Constants.PYROMANCER_MODIFICATOR_B *  dmg;
        dmg = woods * dmg;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
    }

    /**
     * applying the Backstab ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        // the possibility of a critical hit
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        // applying the race modifier
        dmg -= Constants.KNIGHT_MODIFICATOR_B * dmg;
        dmg = woods * dmg;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);

    }

    /**
     * applying the Backstab ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        // the possibility of a critical hit
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        // applying the race modifier
        dmg += Constants.ROGUE_MODIFICATOR_B * dmg;
        dmg = woods * dmg;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);

    }

    /**
     * applying the Backstab ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        // the possibility of a critical hit
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        // applying the lang type bonus
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        dmg = woods * dmg;
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(dmg);
        // applying the race modifier
        dmg += Constants.WIZARD_MODIFICATOR_B * dmg;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);

    }
}
