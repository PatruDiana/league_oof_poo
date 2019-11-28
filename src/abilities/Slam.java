package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Slam extends Abilities implements Visitor {
    public Slam() {
        damage = Constants.Damage_Slam;
        nr_rounds_overtime = Constants.Nr_Rounds_Overtime_S;
    }
    public void setDamage() {
        damage += Constants.Extra_Damage_Slam;
    }

    public int getDamage() {
        return damage;
    }
    @Override
    public void visit(Pyromancer p) {
        float dmg = damage;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.Land_type) {
            land_bonus += Constants.Land_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg -= dmg* Constants.Pyromancer_Modificator_S;
        int result = Math.round(dmg);
        System.out.println(result);
        p.setHP(result);
        p.setDamage_overtime(0, nr_rounds_overtime, true);
    }

    @Override
    public void visit(Knight k) {
        float dmg = damage;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.Land_type) {
            land_bonus += Constants.Land_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg += dmg* Constants.Knight_Modificator_S;
        int result = Math.round(dmg);
        System.out.println(result);
        k.setHP(result);
        k.setDamage_overtime(0, nr_rounds_overtime, true);

    }

    @Override
    public void visit(Rogue r) {
        float dmg = damage;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.Land_type) {
            land_bonus += Constants.Land_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg -= dmg* Constants.Rogue_Modificator_S;
        int result = Math.round(dmg);
        System.out.println(result);
        r.setHP(result);
        r.setDamage_overtime(0, nr_rounds_overtime, true);

    }

    @Override
    public void visit(Wizard w) {
        float dmg = damage;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.Land_type) {
            land_bonus += Constants.Land_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg += dmg* Constants.Wizard_Modificator_S;
        int result = Math.round(dmg);
        System.out.println(result);
        w.setHP(result);
        w.setDamage_overtime(0, nr_rounds_overtime, true);
    }

    @Override
    public String toString() {
        return "Slam{" +
                "damage=" + damage +
                '}';
    }
}
