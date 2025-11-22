package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class MageArmor extends SpellAbstract implements SpellInterface{

    public MageArmor(){
        setSpellName("Mage Armor");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ABJURATION);
        setAction(true);
        setRange((short) 5);
        setDuration((byte) 800);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        
        // Targets ac plus targets dexterity modifier
        int targetAcPlusDex = target.getArmorClass().getAC() + target.getAbilities().get(Constants.ABILITY.DEXTERITY).getAbilityMod();
        // 13 + targets dexterity modifier (max ac the spell could give to target)
        int spellsMaxAcBonus = 13 + target.getAbilities().get(Constants.ABILITY.DEXTERITY).getAbilityMod();

        // If the effectn of the spell would increase the targets ac, and if the target is not wearing armor; increase targets ac to 13 plus targets dexterity modifier
        if(targetAcPlusDex < spellsMaxAcBonus && !target.isWearingArmor()){
            target.setTempAcBonus(spellsMaxAcBonus);
        }
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return "You touch a willing creature who isn't wearing armor, and a protective magical force surrounds it until the spell ends. The target's base AC becomes 13 + its Dexterity modifier. The spell ends if the target dons armor or if you dismiss the spell as an action.";
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
