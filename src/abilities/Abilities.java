package abilities;

public abstract class Abilities implements Visitor {
    protected int damage;
    protected int damageOvertime;
    protected int nrRoundsOvertime;
    protected float landModificator = 1;
    protected float damageprocent;
    public void setDamage() { }
    public void setDamagereceived(final int damagereceived) { }
}
