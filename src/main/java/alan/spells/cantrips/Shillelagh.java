package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Shillelagh extends SpellAbstract implements SpellInterface{

    public Shillelagh(){
        setSpellName("Shillelagh");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.TRANSMUTATION);
        setDamage_type(Constants.DAMAGE_TYPE.FORCE);
        setBonus(true);
        setRange((short) 0);
        setDuration((byte) 10);
        setDamageDie(8);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type, int spellLevel) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String descreiption() {
        return """
               A Club or Quarterstaff you are holding is imbued with nature's power. For the duration, you can use your spellcasting ability instead of Strength for the attack and damage rolls of melee attacks using that weapon, and the weapon's damage die becomes a d8. If the attack deals damage, it can be Force damage or the weapon's normal damage type (your choice).\r
               The spell ends early if you cast it again or if you let go of the weapon.\r
               Cantrip Upgrade. The weapon's damage die changes when you reach levels 5 (d10), 11 (d12), and 17 (2d6).""" //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        switch (lvl) {
            case 5 -> {setDamageDie(10);}
            case 11 -> {setDamageDie(12);}
            case 17 -> {setDamageDie(6);setQuantityOfDie(2);}
            default -> {}
        }
        
    }
    

}
