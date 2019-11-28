package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import map.Map;

public class Paralysis extends Abilities implements Visitor {
    public Paralysis() {
        damage = Constants.Damage_Paralysis;
        nr_rounds_overtime = Constants.Nr_Rounds_Overtime_Min;
    }
    public void setDamage() {
        damage += Constants.Extra_Damage_Paraysis;
    }

    @Override
    public void visit(Pyromancer p) {
        float dmg = damage;
        float land_bonus = land_modificator;
        if (Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.Woods_type) {
            land_bonus += Constants.Woods_type;
        }
        dmg = dmg * land_bonus;
        dmg += Constants.Pyromancer_Modificator_P*dmg;
        int result = Math.round(dmg);
//        System.out.println(result);
        p.setHP_current(result);
        if (Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.Woods_type){
            int nr_rounds = Constants.Nr_Rounds_Overtime_Max;
            p.setDamage_overtime(0, nr_rounds, true);
        } else {
            p.setDamage_overtime(0, nr_rounds_overtime, true);
        }
    }

    @Override
    public void visit(Knight k) {
        float dmg = damage;
        System.out.println(dmg);
        float land_bonus = land_modificator;
        if (Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.Woods_type) {
            land_bonus += Constants.Woods_Bonus;
            System.out.println("intra woods");
            System.out.println(land_bonus);
        }
        dmg = dmg * land_bonus;
        dmg -= Constants.Knight_Modificator_P*dmg;
        int result = Math.round(dmg);
        System.out.println(result);
        k.setHP_current(result);
        if (Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.Woods_type){
            int nr_rounds = Constants.Nr_Rounds_Overtime_Max;
            k.setDamage_overtime(result, nr_rounds, true);
        } else {
            k.setDamage_overtime(result, nr_rounds_overtime, true);
        }

    }

    @Override
    public void visit(Rogue r) {
        float dmg = damage;
        float land_bonus = land_modificator;
        if (Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.Woods_type) {
            land_bonus += Constants.Woods_type;
        }
        dmg = dmg * land_bonus;
        dmg -= Constants.Rogue_Modificator_P*dmg;
        int result = Math.round(dmg);
//        System.out.println(result);
        r.setHP_current(result);
        if (Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.Woods_type){
            int nr_rounds = Constants.Nr_Rounds_Overtime_Max;
            r.setDamage_overtime(0, nr_rounds, true);
        } else {
            r.setDamage_overtime(0, nr_rounds_overtime, true);
        }

    }

    @Override
    public void visit(Wizard w) {
        float dmg = damage;
        float land_bonus = land_modificator;
        if (Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.Woods_type) {
            land_bonus += Constants.Woods_type;
        }
        dmg = dmg * land_bonus;
        dmg += Constants.Wizard_Modificator_P*dmg;
        int result = Math.round(dmg);
//        System.out.println(result);
        w.setHP_current(result);
        if (Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.Woods_type){
            int nr_rounds = Constants.Nr_Rounds_Overtime_Max;
            w.setDamage_overtime(0, nr_rounds, true);
        } else {
            w.setDamage_overtime(0, nr_rounds_overtime, true);
        }

    }
}
