package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Deflect extends Abilities implements Visitor {
    Deflect () {
      damageprocent = Constants.Percent_Deflect;
    }
    public void setDamage() {
        if (damageprocent < Constants.Maxim_Percent_Deflect - 1) {
            damageprocent += Constants.Extra_Percent_Deflect;
        }
    }
    public void setDamagereceived(int damagereceived) {
        damage = damagereceived;
    }
    @Override
    public void visit(Pyromancer p) {
        float dmgpercent = damageprocent;
        float land_bonus = land_modificator;
        if (map.Map.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.Desert_type) {
            land_bonus += Constants.Desert_Bonus;
        }
        dmgpercent = dmgpercent * land_bonus;
        dmgpercent += dmgpercent* Constants.Pyromancer_Modificator_De;
        float dmg = dmgpercent * damage;
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
        dmgpercent += dmgpercent * Constants.Knight_Modificator_De;
        float dmg = dmgpercent * damage;
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
        dmgpercent += dmgpercent * Constants.Roque_Modificator_De;
        float dmg = dmgpercent * damage;
        int result = Math.round(dmg);
        System.out.println(result);
        r.setHP(result);
    }

    @Override
    public void visit(Wizard w) {

    }
}
