package com.tp4.rpg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {

    @Test

    public void testPV() {

        Hero hero = new Hunter();
        hero.setLivepoints(20);
        Enemy enemy = new BasicEnemy();
        enemy.attack(hero);



        assertTrue(hero.getLivepoints() < 0);
    //Le héros meurt;

    }
    public boolean fourchette(int degat) { //vérifie si le dégat appartient a la fourchette de degat du Hunter(60,70)
        for(int i=60;i<70;i++)
        {
            if(i==degat)
            {
                return true;
            }
        }
        return false;
    }
    @Test
    // Les dégats sont infligées dans la bonne fourchette
    public void testDamage() {
        Hunter hunter = new Hunter();
        Enemy enemy = new BasicEnemy();
        hunter.attack(enemy);
        int degat = hunter.getDamage();
        assertTrue(fourchette(degat));
    }
    @Test
    // Lorsque le Hunter attaque le nombre de flèches diminues.
    public void testFlèche() {
        Hunter hero = new Hunter();
        Enemy enemy = new BasicEnemy();
        hero.attack(enemy);
        // Test de diminution des flèches
        assertTrue(hero.getArrow()<5);


    }

    @Test
    // Si le mage n'a pas assez de mana il ne peut pas attaquer.
    public  void testManaPoints1() {
        Mage mage = new Mage();
        Enemy enemy = new BasicEnemy();
        mage.setManaPoints(0);
        mage.attack(enemy);
        // TEst si les points de vies de l'énemi n'ont pas diminué
        assertTrue(enemy.getLifePoints()==200);
    }

    @Test
    // Quand le mage attaque sa quantité de mana dinminue

    public void testManaPoints2() {
        Mage mage = new Mage();
        int a = mage.getManaPoints();// quantité de mana avant l'attaque
        Enemy enemy = new BasicEnemy();
        mage.attack(enemy);
        int b = mage.getManaPoints(); // quantité de mana après l'attaque
        assertTrue(a!=b );
    }
}
