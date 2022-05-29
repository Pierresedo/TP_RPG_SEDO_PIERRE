package com.tp4.rpg;

public abstract class Enemy {
    private int lifePoints;

    protected Enemy(int lifePoints){

        this.lifePoints = lifePoints;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public abstract void attack(Hero hero);

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public abstract void receiveAttack(int a);


}


