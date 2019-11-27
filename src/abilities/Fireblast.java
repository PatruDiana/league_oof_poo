package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Fireblast extends Abilities implements Visitor{
    Fireblast() {
        damage = Constants.Damage_Fireblast;
    }
    public void setDamage() {
        damage += Constants.Extra_Damage_Fireblast;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void visit(Pyromancer p) {
        float dmg = damage;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.Volcanic_type) {
            land_bonus += Constants.Volcanic_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg -= Constants.Pyromancer_Modificator_F*dmg;
        int result = Math.round(dmg);
        System.out.println(result);
        p.setHP(result);
    }

    @Override
    public void visit(Knight k) {
        float dmg = damage;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.Volcanic_type) {
            land_bonus += Constants.Volcanic_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg += Constants.Knight_Modificator_F*dmg;
        int result = Math.round(dmg);
        System.out.println(result);
        k.setHP(result);
    }

    @Override
    public void visit(Rogue r) {
        float dmg = damage;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.Volcanic_type) {
            land_bonus += Constants.Volcanic_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg -= Constants.Rogue_Modificator_F*dmg;
        int result = Math.round(dmg);
        System.out.println(result);
        r.setHP(result);
    }

    @Override
    public void visit(Wizard w) {
        float dmg = damage;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.Volcanic_type) {
            land_bonus += Constants.Volcanic_Bonus;
        }
        dmg = dmg * land_bonus;
        dmg += common.Constants.Wizard_Modificator_F*dmg;
        int result = Math.round(dmg);
        System.out.println(result);
        w.setHP(result);
    }

    @Override
    public String toString() {
        return "Fireblast{" +
                "damage=" + damage +
                '}';
    }
}
