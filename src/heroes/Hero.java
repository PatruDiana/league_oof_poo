package heroes;

import abilities.Abilities;
import common.Constants;

import java.util.ArrayList;

public abstract class Hero implements Visitable {
    protected int row;
    protected int col;
    protected String type;
    protected int level = 0;
    protected int xp = 0;
    protected int hpmax;
    protected int hp;
    protected int damageRec;
    protected ArrayList<Abilities> abilities;
    protected int nrRoundOvertime;
    protected int damageOvertime;
    protected boolean freeze;
    protected boolean death;
    protected int hpCurrent;

    /**
     *
     * @param move
     */
    public void setMove(final Character move) {
        if (!freeze) {
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
    }

    /**
     *
     * @return
     */
    public int getCol() {
        return this.col;
    }

    /**
     *
     * @return
     */
    public int getRow() {
        return this.row;
    }

    /**
     *
     * @return
     */
    public ArrayList<Abilities> getAbilities() {
        return this.abilities;
    }

    /**
     *
     * @param damage
     */
    public void setHpCurrent(final int damage) {
        this.hpCurrent -= damage;
    }
    /**
      * @param newdamageOvertime
     * @param newnrRoundOvertime
     * @param newfreeze
     */
    public void setDamageOvertime(final int newdamageOvertime, final int newnrRoundOvertime,
                                  final boolean newfreeze) {
        this.damageOvertime = newdamageOvertime;
        this.nrRoundOvertime = newnrRoundOvertime;
        this.freeze = newfreeze;
    }
    /**
     *
     */
    public void damageOvertime() {
        if (nrRoundOvertime != 0) {
            hp -= damageOvertime;
            hpCurrent = hp;
            nrRoundOvertime--;
            if (nrRoundOvertime == 0 && freeze) {
                freeze = false;
            }
            if (hp <= 0) {
                setDeath();
            }
        }
    }

    /**
     *
     */
    public void setHP() {
        hp = hpCurrent;
        if (hp <= 0) {
            setDeath();
        }
    }

    /**
     *
     * @return
     */
    public int getHpCurrent() {
        return hpCurrent;
    }

    /**
     *
     * @return
     */
    public int getHp() {
        return hp;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param a
     */
    public void fight(final ArrayList<Abilities> a) {
        for (int i = 0; i < a.size(); i++) {
            accept(a.get(i));
        }
    }

    /**
     *
     */
    public void resetDamageRec() {
        damageRec = 0;
    }

    /**
     *
     * @return
     */
    public boolean isDeath() {
        return death;
    }

    /**
     *
     */
    public void setDeath() {
        this.death = true;
    }

    /**
     *
     * @param lvl
     */
    public void setXp(final int lvl) {
            xp += Math.max(0, Constants.MAX_XP - (level - lvl) * Constants.MULTIPLIER_XP);
            updatelevel();
    }

    /***
     *
     */
    public void updatelevel() {
        while (xp >= level * Constants.XP_UPDATE_LEVEL + Constants.XP_MIN_LEVEL) {
            level++;
            setHPmax();
            for (int i = 0; i < abilities.size(); i++) {
                abilities.get(i).setDamage();
            }
        }
    }

    /**
     *
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * @return
     */
    public String toString() {
        if (death) {
            return type + " " + "dead";
        } else {
            return type + " " + level + " " + xp + " " + hp + " " + row + " " + col;
        }
    }

    /**
     *
     * @param damageRec
     */
    public void setDamageRec(final float damageRec) {
        this.damageRec += Math.round(damageRec);
    }

    /**
     *.
     * @return
     */
    public int getDamageRec() {
        return this.damageRec;
    }
    /**
     * .
     */
    public void setHPmax() { }
    /**
     * .
     * @return
     */
    public int getHpmax() {
        return hpmax;
    }
}
