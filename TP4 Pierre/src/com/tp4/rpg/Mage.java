package com.tp4.rpg;

import java.util.List;

//TODO definir les potions et les lembas
public class Mage extends SpellCaster{

    public Mage() {
        super(400, List.of(), List.of());
    }

    @Override
    public void attack(Enemy enemy) {
        if(getManaPoints()<=0) {
            System.out.println("Mana insufisant , le mage ne peut attaquer");
        }
        else{
        System.out.println("Mage attack -> "+enemy);
        enemy.receiveAttack(getWeaponDamage());
        setManaPoints(getManaPoints()-50);}

        System.out.println("Il reste "+ getManaPoints()+" de Mana");

    }

    @Override
    public void defend(int a) {
        super.defend(a);
    }

    @Override
    public void useConsumable(Consumable consumable) {

    }

    @Override
    public void setManaPoints(int manaPoints) {
        super.setManaPoints(manaPoints);
    }

    @Override
    public int getManaPoints() {
        return super.getManaPoints();
    }

    @Override
    public int getDamage() {
        return super.getDamage();
    }

    @Override
    public void receiveAttack(int a) {
        super.receiveAttack(a);
    }
}
