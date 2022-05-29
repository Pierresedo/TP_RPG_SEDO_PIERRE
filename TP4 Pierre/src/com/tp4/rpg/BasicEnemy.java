package com.tp4.rpg;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemy extends Enemy {
    private GameStarter game = new GameStarter();
    public List<Hero> hero = new ArrayList<>();

    public BasicEnemy() {
        super(350);
    }

   // @Override
    public void attack(Hero hero) {
        System.out.println("Basic ennemy attack -> "+hero);
        hero.receiveAttack(50);
    }

    @Override
    public int getLifePoints() {
        return super.getLifePoints();
    }

    @Override
    public void setLifePoints(int lifePoints) {
        super.setLifePoints(lifePoints);
    }

    @Override
    public void receiveAttack(int a) {
        setLifePoints(getLifePoints() - a);
    }
}