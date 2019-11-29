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
     *
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_EXECUTE;
        if (damageprocent < Constants.HP_MAX_LIMIT) {
            damageprocent += Constants.EXTRA_HP_LIMIT;
        }
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
        float hpLimit = damageprocent * p.getHpmax();
        int limit = Math.round(hpLimit);
        if (p.getHp() < limit) {
            p.setHpCurrent(p.getHp());
        } else {
            float dmg = damage;
            float landBonus = landModificator;
            if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.LAND_TYPE) {
                landBonus += Constants.LAND_BONUS;
            }
            dmg = dmg * landBonus;
            dmg += dmg * Constants.PYROMANCER_MODIFICATOR_E;
            int result = Math.round(dmg);
            p.setHpCurrent(result);
        }
    }

    /**
     *
     * @param k
     */
    public void visit(final Knight k) {
        float hpLimit = damageprocent * k.getHpmax();
        int limit = Math.round(hpLimit);
        if (k.getHp() < limit) {
            k.setHpCurrent(k.getHp());
        } else {
            float dmg = damage;
            float landBonus = landModificator;
            if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.LAND_TYPE) {
                landBonus += Constants.LAND_BONUS;
            }
            dmg = dmg * landBonus;
            dmg += dmg * Constants.KNIGHT_MODIFICATOR_E;
            int result = Math.round(dmg);
            k.setHpCurrent(result);
        }
    }

    /**
     *
     * @param r
     */
    public void visit(final Rogue r) {
        float hpLimit = damageprocent * r.getHpmax();
        int limit = Math.round(hpLimit);
        if (r.getHp() < limit) {
            r.setHpCurrent(r.getHp());
        } else {
            float dmg = damage;
            float landBonus = landModificator;
            if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.LAND_TYPE) {
                landBonus += Constants.LAND_BONUS;
            }
            dmg = dmg * landBonus;
            dmg += dmg * Constants.ROGUE_MODIFICATOR_E;
            int result = Math.round(dmg);
            r.setHpCurrent(result);
        }
    }

    /**
     *
     * @param w
     */
    public void visit(final Wizard w) {
        float hpLimit = damageprocent * w.getHpmax();
        int limit = Math.round(hpLimit);
        if (w.getHp() < limit) {
            w.setHpCurrent(w.getHp());
        } else {
            float dmg = damage;
            float landBonus = landModificator;
            if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.LAND_TYPE) {
                landBonus += Constants.LAND_BONUS;
            }
            dmg = dmg * landBonus;
            w.setDamageRec(dmg);
            dmg -= dmg * Constants.WIZARD_MODIFICATOR_E;
            int result = Math.round(dmg);
            w.setHpCurrent(result);
        }
    }
}
