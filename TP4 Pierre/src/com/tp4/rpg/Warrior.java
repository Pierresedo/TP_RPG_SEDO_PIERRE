package com.tp4.rpg;

import java.util.List;
import java.util.Random;

public class Warrior extends Hero{
    static Random rand = new Random();
    private static final int damage = rand.nextInt(55,65);

    public Warrior() {
        super(200,100,damage, List.of(),List.of());
    }

    @Override
    public void attack(Enemy enemy) {

        System.out.println("Warrior attack -> "+ enemy);
        enemy.receiveAttack(getWeaponDamage());

    }

    @Override
    public void defend(int a) {
        super.defend(a);
    }

    @Override
    public void receiveAttack(int a) {
        super.receiveAttack(a);
    }

    @Override
    public void useConsumable(Consumable consumable) {

    }
}
