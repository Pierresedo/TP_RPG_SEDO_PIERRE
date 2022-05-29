package com.tp4.rpg;

import java.util.List;
import java.util.Random;

public abstract class SpellCaster extends Hero  {
    private int manaPoints;
    static Random rand = new Random();
    private static final int damage = rand.nextInt(80,90);

    protected SpellCaster(int manaPoints, List<Potion> potions, List<Food> lembas) {
        super(200, 100, damage, potions, lembas);
        this.manaPoints = manaPoints;
    }

    @Override
    public void attack(Enemy enemy) {
    }

    @Override
    public void defend(int a) {
        super.defend(a);
    }

    @Override
    public void useConsumable(Consumable consumable) {

    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public int getDamage() {
        return damage;
    }
}


