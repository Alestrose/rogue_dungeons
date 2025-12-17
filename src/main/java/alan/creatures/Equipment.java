package alan.creatures;

import java.util.HashMap;
import java.util.Map;

import alan.equipment.ArmorAbstract;
import alan.equipment.Item;
import alan.equipment.WeaponAbstract;
import alan.equipment.armor.ShieldArmor;

public class Equipment {
    private final static Map<Item, Integer> IVENTORY = new HashMap<>();
    private final Creature owner;
    private WeaponAbstract attackingWeapon;
    private WeaponAbstract mainHand;
    private Item offHand;
    private WeaponAbstract ranged;
    private ArmorAbstract body;
    private Item head;
    private Item cloak;
    private Item gloves;
    private Item boots;

    public Equipment(Creature owner) {
        this.owner = owner;
    }

    /*
     *  Getters and Setters
     */

    public Map<Item, Integer> getInventory() {
        return IVENTORY;
    }


    public WeaponAbstract getMainHand() {
        return mainHand;
    }

    public void setMainHand(WeaponAbstract mainHand) {
        // Will display selection of items in invenotory
        if(!mainHand.isTwoHanded()){        // Equip one handed weapon to main hand
            if(this.mainHand != null){
                addToInventory(this.mainHand, 1);
                this.mainHand = mainHand;
            }else{
                this.mainHand = mainHand;
            }
        }else{                              // Return offhand item to inventory, equip two handed weapon to main hand
            if(this.mainHand != null){
                addToInventory(this.mainHand, 1);
                addToInventory(this.offHand, 1);
                this.mainHand = mainHand;
                this.offHand = null;
            }else{
                this.mainHand = mainHand;
                addToInventory(this.offHand, 1);
                this.offHand = null;
            }
        }
    }

    public Item getOffHand() {
        return offHand;
    }

    public void setOffHand(Item offHand) {
        // Will display selection of items in invenotory
        if (offHand instanceof ShieldArmor shieldArmor) {
            owner.getArmorClass().setShieldBonus(shieldArmor.getAcBonus());
        }
        if(this.offHand != null){
            addToInventory(this.offHand, 1);
            this.offHand = offHand;
        }else{
            this.offHand = offHand;
        }
    }

    public WeaponAbstract getRanged() {
        return ranged;
    }

    public void setRanged(WeaponAbstract ranged) {
        // Will display selection of items in invenotory
        if(this.ranged != null){
            addToInventory(this.ranged, 1);
            this.ranged = ranged;
        }else{
            this.ranged = ranged;
        }
    }

    public ArmorAbstract getBody() {
        return body;
    }

    public void setBody(ArmorAbstract body) {
        // Will display selection of items in invenotory
        if(this.body != null){
            addToInventory(body, 1);
            this.body = body;
        }else{
            this.body = body;
        }
        owner.getArmorClass().setWearingArmor(true);
        owner.getArmorClass().setArmorKey(body.getArmorKey());
    }


    public Item getHead() {
        return head;
    }

    public void setHead(Item head) {
        // Will display selection of items in invenotory
        if(this.head != null){
            addToInventory(head, 1);
            this.head = head;
        }else{
            this.head = head;
        }
    }

    public Item getCloak() {
        return cloak;
    }

    public void setCloak(Item cloak) {
        // Will display selection of items in invenotory
        if(this.cloak != null){
            addToInventory(cloak, 1);
            this.cloak = cloak;
        }else{
            this.cloak = cloak;
        }
    }

    public Item getGloves() {
        return gloves;
    }

    public void setGloves(Item gloves) {
        // Will display selection of items in invenotory
        if(this.gloves != null){
            addToInventory(gloves,1);
            this.gloves = gloves;
        }else{
            this.gloves = gloves;
        }
    }

    public Item getBoots() {
        return boots;
    }

    public void setBoots(Item boots) {
        // Will display selection of items in invenotory
        if(this.boots != null){
            addToInventory(boots, 1);
            this.boots = boots;
        }else{
            this.boots = boots;
        }
    }

    public void addToInventory(Item item, int quantity){
        if (IVENTORY.containsKey(item)) {
            IVENTORY.put(item, IVENTORY.getOrDefault(item, quantity));
        }
        else{
            IVENTORY.put(item, quantity);
        }
    }

    public void removeFromInventory(Item item){
        // If more there are more than one of that item: decrement, else remove item
        if (IVENTORY.containsKey(item)) {
            IVENTORY.computeIfPresent(item, (k, v) -> v > 1 ? v - 1 : null);
        }
        else System.err.println("Item was not found in inventory");
    }

    public WeaponAbstract getAttackingWeapon() {
        return attackingWeapon;
    }

    public void setAttackingWeapon(WeaponAbstract attackingWeapon) {
        this.attackingWeapon = attackingWeapon;
    }

    
    

}
