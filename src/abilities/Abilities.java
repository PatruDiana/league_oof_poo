package abilities;

public abstract class Abilities implements Visitor {
    protected int damage;
    protected int damageOvertime;
    protected int nrRoundsOvertime;
    protected float landModificator = 1;
    protected float damageprocent;

    /**
     * update the base damage of each ability as the hero's level increases.
     * The method will be overwritten by each ability that has base damage.
     */
    public void setDamage() { }

    /**
     * set the damage received by the Wizard for Deflect ability.
     * The method will be overwritten bt the Deflect ability.
     * @param damagereceived- damage received by the Wizard.
     */
    public void setDamagereceived(final int damagereceived) { }
}
