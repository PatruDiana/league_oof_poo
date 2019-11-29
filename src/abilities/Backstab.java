package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Backstab extends Abilities implements Visitor {
    private int nr_rounds;
    private float woods_modificator;
    Backstab() {
        damage = Constants.Damage_Backstab;
        nr_rounds = 0;
        woods_modificator = 1;
    }

    public void setDamage() {
        damage += Constants.Extra_Damage_Backstab;
    }

    @Override
    public void visit(Pyromancer p) {
        float woods = woods_modificator;
        float dmg = damage;
        float land_bonus = land_modificator;
        if((nr_rounds % Constants.Nr_Rounds_Backstab) == 0) {
            if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.Woods_type) {
                woods += Constants.Hit_Woods;
            }
        }
        nr_rounds++;
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.Woods_type) {
            land_bonus += Constants.Woods_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg += Constants.Pyromancer_Modificator_B*dmg;
        dmg = woods * dmg;
        int result = Math.round(dmg);
//        System.out.println("BACKSTAB" + result);
        p.setHP_current(result);
    }

    @Override
    public void visit(Knight k) {
        float woods = woods_modificator;
        float dmg = damage;
        float land_bonus = land_modificator;
        if((nr_rounds % Constants.Nr_Rounds_Backstab) == 0) {
            if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.Woods_type) {
                woods += Constants.Hit_Woods;
            }
        }
        nr_rounds++;
       // System.out.println("aici" + nr_rounds);
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.Woods_type) {
            land_bonus += Constants.Woods_Bonus;
        }
//        System.out.println("land" + land_bonus);
        dmg = dmg * land_bonus;
        dmg -= Constants.Knight_Modificator_B*dmg;
        dmg = woods * dmg;
        int result = Math.round(dmg);
//        System.out.println(result);
        k.setHP_current(result);

    }

    @Override
    public void visit(Rogue r) {
        float woods = woods_modificator;
        float dmg = damage;
        float land_bonus = land_modificator;
        if((nr_rounds % Constants.Nr_Rounds_Backstab) == 0) {
            if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.Woods_type) {
                woods += Constants.Hit_Woods;
            }
        }
        nr_rounds++;
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.Woods_type) {
            land_bonus += Constants.Woods_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg += Constants.Roque_Modificator_B*dmg;
        dmg = woods * dmg;
        int result = Math.round(dmg);
//        System.out.println(result);
        r.setHP_current(result);

    }

    @Override
    public void visit(Wizard w) {
        float woods = woods_modificator;
        float dmg = damage;
        float land_bonus = land_modificator;
        if((nr_rounds % Constants.Nr_Rounds_Backstab) == 0) {
            if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.Woods_type) {
                woods += Constants.Hit_Woods;
            }
        }
        nr_rounds++;
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.Woods_type) {
            land_bonus += Constants.Woods_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg = woods * dmg;
//        System.out.println("b fara race: "+ dmg);
        w.setDamage_rec(dmg);
        dmg += Constants.Wizard_Modificator_B*dmg;
        int result = Math.round(dmg);
//        System.out.println("Backstab: "+result);
        w.setHP_current(result);

    }
}
