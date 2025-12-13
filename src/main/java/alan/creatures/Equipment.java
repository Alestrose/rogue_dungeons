package alan.creatures;

import java.util.ArrayDeque;
import java.util.Deque;

import alan.equipment.Item;
import alan.equipment.Weapon;

public class Equipment {
    private final Deque<Item> inventory = new ArrayDeque<>();

    private Weapon attackingWeapon;
    private Weapon mainHand;
    private Item offHand;
    private Weapon ranged;
    private Item body;
    private Item head;
    private Item cloak;
    private Item gloves;
    private Item boots;


    public Equipment() {
        
    }


    public Deque<Item> getInventory() {
        return inventory;
    }


    public Weapon getMainHand() {
        return mainHand;
    }

    public void setMainHand(Weapon mainHand) {
        // Will display selection of items in invenotory
        if (inventory.contains(mainHand)) {
            if(this.mainHand != null){
                inventory.add(this.mainHand);
                this.mainHand = mainHand;
                inventory.remove(mainHand);
            }else{
                this.mainHand = mainHand;
                inventory.remove(mainHand);
            }
        }else System.err.println(mainHand.getName() + " is not in players inventory");
    }


    public Item getOffHand() {
        return offHand;
    }


    public void setOffHand(Item offHand) {
        // Will display selection of items in invenotory
        if (inventory.contains(offHand)) {
            if(this.offHand != null){
                inventory.add(this.offHand);
                this.offHand = offHand;
                inventory.remove(offHand);
            }else{
                this.offHand = offHand;
                inventory.remove(offHand);
            }
        }else System.err.println(offHand.getName() + " is not in players inventory");
    }


    public Weapon getRanged() {
        return ranged;
    }


    public void setRanged(Weapon ranged) {
        // Will display selection of items in invenotory
        if (inventory.contains(ranged)) {
            if(this.ranged != null){
                inventory.add(this.ranged);
                this.ranged = ranged;
                inventory.remove(ranged);
            }else{
                this.ranged = ranged;
                inventory.remove(ranged);
            }
        }else System.err.println(ranged.getName() + " is not in players inventory");
    }


    public Item getBody() {
        return body;
    }


    public void setBody(Item body) {
        // Will display selection of items in invenotory
        if (inventory.contains(body)) {
            if(this.body != null){
                inventory.add(this.body);
                this.body = body;
                inventory.remove(body);
            }else{
                this.body = body;
                inventory.remove(body);
            }
        }else System.err.println(body.getName() + " is not in players inventory");
    }


    public Item getHead() {
        return head;
    }


    public void setHead(Item head) {
        // Will display selection of items in invenotory
        if (inventory.contains(head)) {
            if(this.head != null){
                inventory.add(this.head);
                this.head = head;
                inventory.remove(head);
            }else{
                this.head = head;
                inventory.remove(head);
            }
        }else System.err.println(head.getName() + " is not in players inventory");
    }


    public Item getCloak() {
        return cloak;
    }


    public void setCloak(Item cloak) {
        // Will display selection of items in invenotory
        if (inventory.contains(cloak)) {
            if(this.cloak != null){
                inventory.add(this.cloak);
                this.cloak = cloak;
                inventory.remove(cloak);
            }else{
                this.cloak = cloak;
                inventory.remove(cloak);
            }
        }else System.err.println(cloak.getName() + " is not in players inventory");
    }


    public Item getGloves() {
        return gloves;
    }


    public void setGloves(Item gloves) {
        // Will display selection of items in invenotory
        if (inventory.contains(gloves)) {
            if(this.gloves != null){
                inventory.add(this.gloves);
                this.gloves = gloves;
                inventory.remove(gloves);
            }else{
                this.gloves = gloves;
                inventory.remove(gloves);
            }
        }else System.err.println(gloves.getName() + " is not in players inventory");
    }


    public Item getBoots() {
        return boots;
    }


    public void setBoots(Item boots) {
        // Will display selection of items in invenotory
        if (inventory.contains(boots)) {
            if(this.boots != null){
                inventory.add(this.boots);
                this.boots = boots;
                inventory.remove(boots);
            }else{
                this.boots = boots;
                inventory.remove(boots);
            }
        }else System.err.println(boots.getName() + " is not in players inventory");
    }


    public Weapon getAttackingWeapon() {
        return attackingWeapon;
    }


    public void setAttackingWeapon(Weapon attackingWeapon) {
        this.attackingWeapon = attackingWeapon;
    }

    
    

}
