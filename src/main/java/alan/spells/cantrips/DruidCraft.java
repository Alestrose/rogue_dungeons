package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class DruidCraft extends SpellAbstract implements SpellInterface{

    public DruidCraft(Creature caster, Creature target, Creature[] targetList, Cell cell){
        super(caster, target, targetList, cell);
        setSpellName("Druid Craft");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.TRANSMUTATION);
        setAction(true);
        setRange((short) 30);
        setDuration((byte) 0);
    }

    @Override
    public void cast() {
        // No combat implementation
    }

    @Override
    public void castOnArea() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void castOnTarget() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void multiCast() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               Weather Sensor. You create a Tiny, harmless sensory effect that predicts what the weather will be at your location for the next 24 hours. The effect might manifest as a golden orb for clear skies, a cloud for rain, falling snowflakes for snow, and so on. This effect persists for 1 round.\r
               Bloom. You instantly make a flower blossom, a seed pod open, or a leaf bud bloom.\r
               Sensory Effect. You create a harmless sensory effect, such as falling leaves, spectral dancing fairies, a gentle breeze, the sound of an animal, or the faint odor of skunk. The effect must fit in a 5-foot Cube.\r
               Fire Play. You light or snuff out a candle, a torch, or a campfire.""" //
        //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
