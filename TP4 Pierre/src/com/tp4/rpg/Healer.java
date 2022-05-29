package com.tp4.rpg;

import java.util.List;

//TODO definir les potions et les lembas
public class Healer extends SpellCaster{

    private int soin = 4;

    public Healer() {
        super(200, List.of(), List.of());
    }

    public void heal(Hero hero) {
        hero.setLivepoints(200);
        setManaPoints(getManaPoints()-50);
        soin-=1;
        System.out.println("Il vous reste : "+soin+" utilisations ");

    }

    @Override
    public void receiveAttack(int a) {
        super.receiveAttack(a);
    }

    @Override
    public int getManaPoints() {
        return super.getManaPoints();
    }

    @Override
    public void setManaPoints(int manaPoints) {
        super.setManaPoints(manaPoints);
    }

    @Override
    public void setLivepoints(int livepoints) {
        super.setLivepoints(livepoints);
    }

    @Override
    public int getLivepoints() {
        return super.getLivepoints();
    }

    @Override
    public void attack(Enemy enemy) {

    }
}


