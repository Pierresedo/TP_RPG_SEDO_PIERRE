package com.tp4.rpg;

public class Boss extends Enemy {
    Game game = new Game();

    public Boss() {
        super(500);
    }

    @Override

    public void attack(Hero hero) {
        System.out.println("Boss attack -> "+hero);
        hero.receiveAttack(50);
    }

    @Override

    public void receiveAttack(int a) {
        setLifePoints(getLifePoints() - a);
    }

    @Override
    public int getLifePoints() {
        return super.getLifePoints();
    }
}
