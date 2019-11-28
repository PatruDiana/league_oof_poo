package abilities;

public abstract class Abilities implements Visitor {
    protected int damage;
    protected int damage_overtime;
    protected int nr_rounds_overtime;
    protected float land_modificator = 1;
    protected float damageprocent;
    public void setDamage(){

    }
}
