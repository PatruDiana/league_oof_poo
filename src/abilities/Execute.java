package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Execute extends  Abilities implements Visitor {
    public Execute() {
        damage = Constants.Damage_Execute;
        damageprocent = Constants.Hp_Limit;
    }
    public void setDamage() {
        damage += Constants.Extra_Damage_Execute;
        if (damageprocent < Constants.Hp_Max_Limit) {
            damageprocent += Constants.Extra_HP_Limit;
        }
    }

    public int getDamage() {
        return damage;
    }
    @Override
    public void visit(Pyromancer p) {
        float hp_limit = damageprocent * Constants.Hp_Pyromancer;
        int limit = Math.round(hp_limit);
        if(p.getHP() < limit) {
            p.setHP_current(p.getHP());
        } else {
            float dmg = damage;
            float land_bonus = land_modificator;
            if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.Land_type) {
                land_bonus += Constants.Land_Bonus;
            }
            dmg = dmg * land_bonus;
            dmg += dmg * Constants.Pyromancer_Modificator_E;
            int result = Math.round(dmg);
//            System.out.println("Execute: " + result);
            p.setHP_current(result);
        }
    }

    @Override
    public void visit(Knight k) {
        float hp_limit = damageprocent * Constants.Hp_Knight;
        int limit = Math.round(hp_limit);
        if(k.getHP() < limit) {
            k.setHP_current(k.getHP());
        } else {
            float dmg = damage;
            float land_bonus = land_modificator;
            if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.Land_type) {
                land_bonus += Constants.Land_Bonus;
            }
            dmg = dmg * land_bonus;
            dmg += dmg * Constants.Knight_Modificator_E;
            int result = Math.round(dmg);
//            System.out.println(result);
            k.setHP_current(result);
        }
    }

    @Override
    public void visit(Rogue r) {
        float hp_limit = damageprocent * Constants.Hp_Roque;
        int limit = Math.round(hp_limit);
//        System.out.println(limit);
        if(r.getHP() < limit) {
            r.setHP_current(r.getHP());
        } else {
//            System.out.println("nu e ");
            float dmg = damage;
            float land_bonus = land_modificator;
            if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.Land_type) {
                land_bonus += Constants.Land_Bonus;
            }
            dmg = dmg * land_bonus;
            dmg += dmg * Constants.Rogue_Modificator_E;
            int result = Math.round(dmg);
//            System.out.println(result);
            r.setHP_current(result);
        }
    }

    @Override
    public void visit(Wizard w) {
        float hp_limit = damageprocent * Constants.Hp_Wizard;
        int limit = Math.round(hp_limit);
        if(w.getHP() < limit) {
            w.setHP_current(w.getHP());
        } else {
            float dmg = damage;
            float land_bonus = land_modificator;
            if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.Land_type) {
                land_bonus += Constants.Land_Bonus;
            }
            dmg = dmg * land_bonus;
//            System.out.println("rec " + dmg);
            w.setDamage_rec(dmg);
            dmg -= dmg * Constants.Wizard_Modificator_E;
            int result = Math.round(dmg);
//            System.out.println(result);
            w.setHP_current(result);
        }
    }

    @Override
    public String toString() {
        return "Execute{" +
                "damage=" + damage +
                '}';
    }
}
