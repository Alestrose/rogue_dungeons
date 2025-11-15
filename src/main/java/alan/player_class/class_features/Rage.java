package alan.player_class.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;

public class Rage extends ClassFeatureAbstract{
    private int resourceRage = 2;
    private int damageBonus = 2;
    private boolean isRaging = false;

    public Rage(){
        setClassFeatureKey(Constants.CLASS_FEATURE.RAGE);
        setClassFeatureName();
        setFeatureLevel(1);
        setDuration((byte) 100);
        setBonus(true);
        setActive(true);
        

    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        if(!caster.isWearingArmor()){
            setRaging(true);
            caster.setDamageRollIncrease(damageBonus);
            caster.getAbilities().get(Constants.ABILITY.STRENGTH).setSaveAdvantage(true);
            caster.getAbilities().get(Constants.ABILITY.STRENGTH).setCheckAdvantage(true);
        }else System.err.println("Can't do while wearing armor");
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               You can imbue yourself with a primal power called\r
               Rage, a force that grants you extraordinary might\r
               and resilience. You can enter it as a Bonus Action if\r
               you aren't wearing Heavy armor.\r
               You can enter your Rage the number of times\r
               shown for your Barbarian level in the Rages column\r
               of the Barbarian Features table. You regain one ex-\r
               pended use when you finish a Short Rest, and you\r
               regain all expended uses when you finish a Long\r
               Rest.\r
               While active, your Rage follows the rules below.\r
               Damage Resistance. You have Resistance to Blud-\r
               geoning, Piercing, and Slashing damage.\r
               Rage Damage. When you make an attack using\r
               Strength- with either a weapon or an Unarmed\r
               Strike-and deal damage to the target, you gain\r
               a bonus to the damage that increases as you gain\r
               levels as a Barbarian, as shown in the Rage Damage\r
               column of the Barbarian Features table.\r
               Strength Advantage. You have Advantage on\r
               Strength checks and Strength saving throws.\r
               No Concentration or Spells. You can't maintain\r
               Concentration, and you can't cast spells.\r
               Duration. The Rage lasts until the end of your\r
               next turn, and it ends early if you don Heavy armor\r
               or have the Incapacitated condition. If your Rage\r
               is still active on your next turn, you can extend\r
               the Rage for another round by doing one of the\r
               following:\r
               Make an attack roll against an enemy.\r
               \u2022 Force an enemy to make a saving throw.\r
               \u2022 Take a Bonus Action to extend your Rage.\r
               Each time the Rage is extended, it lasts until the end\r
               of your next turn. You can maintain a Rage for up\r
               to 10 minutes.""" //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        switch (lvl) {
            case 3 -> {setResourceRage(3); }
            case 6 -> {setResourceRage(4);}
            case 9 -> {setDamageBonus(3);}
            case 12 -> {setResourceRage(5);}
            case 16 -> {setDamageBonus(4);}
            case 17 -> {setResourceRage(6);}
            default -> {}
        }
        
    }

    /*
     * Getters and Setters
     */

    public int getResourceRage() {
        return resourceRage;
    }

    public void setResourceRage(int resourceRage) {
        this.resourceRage = resourceRage;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    public void setDamageBonus(int damageBonus) {
        this.damageBonus = damageBonus;
    }

    public boolean isRaging() {
        return isRaging;
    }

    public void setRaging(boolean isRaging) {
        this.isRaging = isRaging;
    }

    
    
    
}
