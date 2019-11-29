package heroes;

import abilities.Abilities;

import java.util.ArrayList;

public abstract class Hero implements Visitable {
    protected int row;
    protected int col;
    protected String type;
    protected int level = 0;
    protected int XP = 0;
    protected int HP_max;
    protected int HP;
    protected int damage_rec;
    ArrayList<Abilities> abilities;
    protected int nr_round_overtime;
    protected int damage_overtime;
    protected boolean freeze;
    protected boolean death;
    protected int HP_current;
    public void setMove(Character move) {
        if (move != '_') {
            if (move == 'U') {
                this.row--;
            } else if (move == 'D') {
                this.row++;
            } else if (move == 'L') {
                this.col--;
            } else {
                this.col++;
            }
        }
    }
    public int getCol() {
        return this.col;
    }
    public int getRow() {
        return this.row;
    }
    public ArrayList<Abilities> getAbilities() {
        return this.abilities;
    }
    public void setHP_current(int damage) {
        this.HP_current -= damage;
    }
    public void setDamage_overtime(int damage_overtime, int nr_round_overtime, boolean freeze) {
        this.damage_overtime = damage_overtime;
        this.nr_round_overtime = nr_round_overtime;
        this.freeze = freeze;
//        System.out.println(damage_overtime + " " + nr_round_overtime + " " + freeze);
    }
    public void Damage_Overtime() {
        if(nr_round_overtime != 0) {
//            System.out.println("aici intra");
            HP -= damage_overtime;
            HP_current = HP;
            nr_round_overtime--;
            if(HP <= 0) {
                setDeath();
            }
        }
    }

    public void setHP() {
        HP = HP_current;
        if(HP <= 0 ) {
            setDeath();
        }
    }
    public void getDamageOvertime() {
        System.out.println(damage_overtime + " " + nr_round_overtime + " " + freeze);
    }
    public int getHP_current() {
        return HP_current;
    }

    public int getHP() {
        return HP;
    }
    public String getType() {
        return type;
    }
    public void fight(ArrayList<Abilities> a) {
        for(int i = 0; i < a.size(); i++) {
            accept(a.get(i));
        }
    }
    public void resetDamageRec() {
        damage_rec = 0;
    }

    public boolean isDeath() {
        return death;
    }

    public void setDeath() {
        this.death = true;
    }

    public void setXP(int lvl) {
            XP += Math.max(0, 200 - (level - lvl)* 40);
            updatelevel();
    }
    public void updatelevel() {
        while (XP >= level * 50 + 250) {
            level++;
            setHPmax();
            for(int i = 0; i < abilities.size(); i++) {
                abilities.get(i).setDamage();
            }
        }
    }
    public int getLevel() {
        return level;
    }

    public String toString() {
        if(death) {
            return type + " " + "dead";
        } else {
            return type + " " + level + " " + XP + " " + HP + " " + row + " " + col;
        }
    }
    public void setDamage_rec(float damage_rec) {
        this.damage_rec += Math.round(damage_rec);
    }


    public int getDamage_rec() {
        return this.damage_rec;
    }
    public void setHPmax(){

    }

}
