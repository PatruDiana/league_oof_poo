package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Execute extends  Abilities implements Visitor {
    public Execute() {
        damage = Constants.DAMAGE_EXECUTE;
        damageprocent = Constants.HP_LIMIT;
    }

    /**
     * update the base damage of Execute ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_EXECUTE;
        if (damageprocent < Constants.HP_MAX_LIMIT) {
            damageprocent += Constants.EXTRA_HP_LIMIT;
        }
    }

    /**
     * applying the Execute ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float hpLimit = damageprocent * p.getHpmax();
        int limit = Math.round(hpLimit);
        // checking the minimum life for fighting
        if (p.getHp() < limit) {
            p.setHpCurrent(p.getHp());
        } else {
            float dmg = damage;
            float landBonus = landModificator;
            // applying the lang type bonus
            if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.LAND_TYPE) {
                landBonus += Constants.LAND_BONUS;
            }
            dmg = dmg * landBonus;
            // applying the race modifier
            dmg += dmg * Constants.PYROMANCER_MODIFICATOR_E;
            int result = Math.round(dmg);
            // decrease of the final damage from the opponent's hp
            p.setHpCurrent(result);
        }
    }

    /**
     * applying the Execute ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float hpLimit = damageprocent * k.getHpmax();
        int limit = Math.round(hpLimit);
        // checking the minimum life for fighting
        if (k.getHp() < limit) {
            k.setHpCurrent(k.getHp());
        } else {
            float dmg = damage;
            float landBonus = landModificator;
            // applying the lang type bonus
            if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.LAND_TYPE) {
                landBonus += Constants.LAND_BONUS;
            }
            dmg = dmg * landBonus;
            // applying the race modifier
            dmg += dmg * Constants.KNIGHT_MODIFICATOR_E;
            int result = Math.round(dmg);
            // decrease of the final damage from the opponent's hp
            k.setHpCurrent(result);
        }
    }

    /**
     * applying the Execute ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float hpLimit = damageprocent * r.getHpmax();
        int limit = Math.round(hpLimit);
        // checking the minimum life for fighting
        if (r.getHp() < limit) {
            r.setHpCurrent(r.getHp());
        } else {
            float dmg = damage;
            float landBonus = landModificator;
            // applying the lang type bonus
            if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.LAND_TYPE) {
                landBonus += Constants.LAND_BONUS;
            }
            dmg = dmg * landBonus;
            // applying the race modifier
            dmg += dmg * Constants.ROGUE_MODIFICATOR_E;
            int result = Math.round(dmg);
            // decrease of the final damage from the opponent's hp
            r.setHpCurrent(result);
        }
    }

    /**
     * applying the Execute ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float hpLimit = damageprocent * w.getHpmax();
        int limit = Math.round(hpLimit);
        // checking the minimum life for fighting
        if (w.getHp() < limit) {
            w.setHpCurrent(w.getHp());
        } else {
            float dmg = damage;
            float landBonus = landModificator;
            // applying the lang type bonus
            if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.LAND_TYPE) {
                landBonus += Constants.LAND_BONUS;
            }
            dmg = dmg * landBonus;
            // setting the damage received without the race modifier for the wizard hero
            w.setDamageRec(dmg);
            // applying the race modifier
            dmg -= dmg * Constants.WIZARD_MODIFICATOR_E;
            int result = Math.round(dmg);
            // decrease of the final damage from the opponent's hp
            w.setHpCurrent(result);
        }
    }
}
