package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Ignite extends Abilities implements Visitor {
    Ignite() {
        damage = Constants.Damage_Ignite;
        damage_overtime = Constants.Damage_Overtime_Ignite;
        nr_rounds_overtime = Constants.Nr_Rounds_Overtime;
    }
    public void setDamage() {
        damage += Constants.Extra_Damage_Ignite;
        damage_overtime += Constants.Extra_Damage_Overtime_Ignite;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void visit(Pyromancer p) {
        float dmg = damage;
        float dmg_overtime = damage_overtime;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.Volcanic_type) {
            land_bonus += Constants.Volcanic_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg_overtime = dmg_overtime*land_bonus;
        dmg -= Constants.Pyromancer_Modificator_I*dmg;
        dmg_overtime -= Constants.Pyromancer_Modificator_I*dmg_overtime;
        int result = Math.round(dmg);
        int result_overtime = Math.round(dmg_overtime);
//        System.out.println(result);
        p.setHP(result);
        p.setDamage_overtime(result_overtime, nr_rounds_overtime);
    }

    @Override
    public void visit(Knight k) {
        float dmg = damage;
        float dmg_overtime = damage_overtime;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.Volcanic_type) {
            land_bonus += Constants.Volcanic_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg_overtime = dmg_overtime*land_bonus;
        dmg += Constants.Knight_Modificator_I*dmg;
        dmg_overtime += Constants.Knight_Modificator_I*dmg_overtime;
        int result = Math.round(dmg);
        int result_overtime = Math.round(dmg_overtime);
//        System.out.println(result);
        k.setHP(result);
        k.setDamage_overtime(result_overtime, nr_rounds_overtime);
    }

    @Override
    public void visit(Rogue r) {
        float dmg = damage;
        float dmg_overtime = damage_overtime;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.Volcanic_type) {
            land_bonus += Constants.Volcanic_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg_overtime = dmg_overtime*land_bonus;
        dmg -= Constants.Rogue_Modificator_I*dmg;
        dmg_overtime -= Constants.Rogue_Modificator_I*dmg_overtime;
        int result = Math.round(dmg);
        int result_overtime = Math.round(dmg_overtime);
//        System.out.println(result);
        r.setHP(result);
        r.setDamage_overtime(result_overtime, nr_rounds_overtime);
    }

    @Override
    public void visit(Wizard w) {
        float dmg = damage;
        float dmg_overtime = damage_overtime;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.Volcanic_type) {
            land_bonus += Constants.Volcanic_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg_overtime = dmg_overtime*land_bonus;
        dmg += Constants.Wizard_Modificator_F*dmg;
        dmg_overtime += Constants.Wizard_Modificator_I * dmg_overtime;
        int result = Math.round(dmg);
        int result_overtime = Math.round(dmg_overtime);
//        System.out.println(result);
        w.setHP(result);
        w.setDamage_overtime(result_overtime, nr_rounds_overtime);
    }

    @Override
    public String toString() {
        return "Ignite{" +
                "damage=" + damage +
                '}';
    }
}
