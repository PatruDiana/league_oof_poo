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
        float dmg = dmgpercent * Math.min(Constants.HP_Min_Drain* Constants.Hp_Pyromancer, p.getHP());
        int result = Math.round(dmg);
        System.out.println(result);
        p.setHP(result);
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
        float dmg = dmgpercent * Math.min(Constants.HP_Min_Drain* Constants.Hp_Knight, k.getHP());
        int result = Math.round(dmg);
        System.out.println(result);
        k.setHP(result);
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
        float dmg = dmgpercent * Math.min(Constants.HP_Min_Drain* Constants.Hp_Roque, r.getHP());
        int result = Math.round(dmg);
        System.out.println(result);
        r.setHP(result);
    }

    @Override
    public void visit(Wizard w) {
        float dmgpercent = damageprocent;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.Desert_type) {
            land_bonus += Constants.Desert_Bonus;
        }
        dmgpercent = dmgpercent * land_bonus;
        dmgpercent += dmgpercent* Constants.Wirzard_Modificator_Dr;
        float dmg = dmgpercent * Math.min(Constants.HP_Min_Drain* Constants.Hp_Wizard, w.getHP());
        int result = Math.round(dmg);
        System.out.println(result);
        w.setHP(result);
    }
}
