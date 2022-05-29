package com.tp4.rpg;

import java.util.*;


public abstract class Hero {
    private int livepoints;
    private  int armor;
    private  int weaponDamage;
    private  List<Potion> potions;
    private  List<Food> lembas;
    private Scanner sc = new Scanner(System.in);

   // constructeur par defaut



    protected Hero(int livepoints, int armor, int weaponDamage, List<Potion> potions, List<Food> lembas) {
        this.livepoints = livepoints;
        this.armor = armor;
        this.weaponDamage = weaponDamage;
        this.potions = potions;
        this.lembas = lembas;
    }

    public List<Food> getLembas() {
        return lembas;
    }

    public int getArmor() {
        return armor;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public  void attack(Enemy enemy) {

    };

    public void receiveAttack(int a) {
        if(getArmor()>0) {
            System.out.println("Voulez vous défendre ? OUI(1) NON(2)");
            int saisie = sc.nextInt();
            switch (saisie) {
                case 1 : defend(a);break;
                default: setLivepoints(getLivepoints() - a); break;
            }
        }
        else {
        setLivepoints(getLivepoints() - a);}

    }

    public void defend(int b) {
        setArmor(getArmor()-b);
    };


    public abstract  void useConsumable(Consumable consumable);

    public void usePotion() {
        setLivepoints(getLivepoints()+Potion.pvPotion);
    }

    public int getLivepoints() {
        return livepoints;
    }


    public void setLivepoints(int livepoints) {
        this.livepoints=livepoints;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

}
