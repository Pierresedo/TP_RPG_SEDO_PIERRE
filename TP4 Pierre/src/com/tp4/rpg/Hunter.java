package com.tp4.rpg;

import java.util.List;
import java.util.Random;


public class Hunter extends Hero {
    static Random rand = new Random();
    private static final int damage = rand.nextInt(60,70);
    private int arrow;
    public int a;

    public Hunter() {
        super(200,100,damage, List.of(),List.of());
        this.arrow=5;

    }

    @Override
    public void attack(Enemy enemy) {

        System.out.println("Hunter attack -> "+enemy);
        enemy.receiveAttack(getWeaponDamage());
        arrow-=1;
        System.out.println("Il reste: "+arrow+" flèches");

    }

    @Override
    public void receiveAttack(int a) {
        super.receiveAttack(a);
    }

    @Override
    public void defend(int a) {
        super.defend(a);
    }


    @Override
    public void useConsumable(Consumable consumable) {

    }

    @Override
    public int getLivepoints() {
        return super.getLivepoints();
    }

    @Override
    public void setLivepoints(int livepoints) {
        super.setLivepoints(livepoints);
    }

    public int getArrow() {
        return arrow;
    }

    public int getDamage() {
        return damage;
    }
}
