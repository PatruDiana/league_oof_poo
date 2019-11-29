package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Drain extends Abilities implements Visitor {

    public Drain() {
        damageprocent = Constants.Percent_Drain;

    }
    public void setDamage() {
        damageprocent += Constants.Extra_Percent_Drain;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void visit(Pyromancer p) {
        float dmgpercent = damageprocent;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.Desert_type) {
            land_bonus += Constants.Desert_Bonus;
        }
        dmgpercent = dmgpercent * land_bonus;
        dmgpercent -= dmgpercent* Constants.Pyromancer_Modificator_Dr;
        float dmg = dmgpercent * Math.min(Constants.HP_Min_Drain* p.getHP_max(), p.getHP_current());
        int result = Math.round(dmg);
//        System.out.println(result);
        p.setHP_current(result);
    }

    @Override
    public void visit(Knight k) {
        float dmgpercent = damageprocent;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.Desert_type) {
            land_bonus += Constants.Desert_Bonus;
        }
        dmgpercent = dmgpercent * land_bonus;
        dmgpercent += dmgpercent* Constants.Knight_Modificator_Dr;
        float dmg = dmgpercent * Math.min(Constants.HP_Min_Drain* k.getHP_max(), k.getHP_current());
        int result = Math.round(dmg);
//        System.out.println(result);
        k.setHP_current(result);
    }

    @Override
    public void visit(Rogue r) {
        float dmgpercent = damageprocent;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.Desert_type) {
            land_bonus += Constants.Desert_Bonus;
        }
        dmgpercent = dmgpercent * land_bonus;
        dmgpercent -= dmgpercent* Constants.Rogue_Modificator_Dr;
        float dmg = dmgpercent * Math.min(Constants.HP_Min_Drain* r.getHP_max(), r.getHP_current());
        int result = Math.round(dmg);
//        System.out.println("DRAIN: "+  result);
        r.setHP_current(result);
    }

    @Override
    public void visit(Wizard w) {
        float dmgpercent = damageprocent;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.Desert_type) {
            land_bonus += Constants.Desert_Bonus;
        }
        dmgpercent = dmgpercent * land_bonus;
        float dmg = dmgpercent * Math.min(Constants.HP_Min_Drain* w.getHP_max(), w.getHP_current());
        w.setDamage_rec(dmg);
        dmgpercent += dmgpercent* Constants.Wirzard_Modificator_Dr;
        dmg = dmgpercent * Math.min(Constants.HP_Min_Drain* w.getHP_max(), w.getHP_current());
        int result = Math.round(dmg);
//        System.out.println(result);
        w.setHP_current(result);
    }
}
