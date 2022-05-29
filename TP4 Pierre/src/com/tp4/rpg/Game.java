package com.tp4.rpg;

import com.tp4.rpg.rpg.util.InputParser;

import java.util.*;
import java.util.concurrent.*;

public class Game {

    public List<Hero> heroes= new ArrayList<>();
    private int playerTurn;
    private InputParser inputParser;
    private  GameStarter gameStarter = new GameStarter();
    Scanner sc = new Scanner(System.in);

    /**/

    public void playGame() {
        gameStarter.start();
        this.heroes = gameStarter.getHeroes();
    }

    public void generateCombat() {
        playerTurn = ThreadLocalRandom.current().nextInt(0, 1);
        while (true) {
            this.doPlay();
        }
    }

    private void doPlay() {


        if(playerTurn == 0) {
            if (enemies.isEmpty() == true) {
                System.out.println("Les Enemies  sont tous morts. Vous avez Gagné! ");
                System.exit(0);
            }

            if(heroes.isEmpty()==true) {
                System.out.println("Tous les héros sont morts. vous avez perdu!");
                System.exit(0);
            }


            Random rand = new Random();
            Hero randomHero = heroes.get(rand.nextInt(heroes.size()));
            var attackOrder = ThreadLocalRandom.current().nextInt(0, enemies.size());
            enemies.get(attackOrder).attack(randomHero);

            // Supprimer l'ennemi lorsqu'il n'a plus de lifepoints
            for (int i = 0; i < heroes.size(); i++) {
                int score = heroes.get(i).getLivepoints();
                if (score <= 0) {
                    System.out.println("Le héros : "+heroes.get(i)+"est mort");
                    heroes.remove(i);
                }
            }


            List pvListes = new ArrayList();
            for (int k = 0; k < heroes.size(); k++) {
                pvListes.add(heroes.get(k).getLivepoints());
            }
            List armorListes = new ArrayList();
            for (int k = 0; k < heroes.size(); k++) {
                armorListes.add(heroes.get(k).getArmor());
            }

            System.out.println("liste des heros : " + heroes);
            System.out.println("Liste des PV :       "+pvListes);
            System.out.println("Liste des boucliers :" +armorListes);

           /* try {
                Thread.sleep(3000L);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }*/
            playerTurn = 1;
        }

            if (enemies.isEmpty() == true) {
                System.out.println("Les Enemies  sont tous morts. Vous avez Gagné! ");
                System.exit(0);
            }

            if(heroes.isEmpty()==true) {
                System.out.println("Tous les héros sont morts. vous avez perdu!");
                System.exit(0);
            }

            if(heroes.size()==1) {

                Random rand = new Random();
                Enemy randomEnemy = enemies.get(rand.nextInt(enemies.size()));
                var attackOrder = ThreadLocalRandom.current().nextInt(0, heroes.size());
                heroes.get(attackOrder).attack(randomEnemy);
            }
            else {
                attaqueMultiple();
            }

        for(int k=0;k< enemies.size();k++) {
            int score = enemies.get(k).getLifePoints();
            if(score<=0){
                System.out.println("L'énemi : "+enemies.get(k)+" est mort");
                enemies.remove(k);

            }
        }


            //TODO Scanner laisser au player l'action de choisir le futur héros qui va attaquer

            // Supprimer les heros qui n'ont plus de livepoints



            if (enemies.isEmpty() == true) {
                System.out.println("Les Enemies  sont tous morts. Vous avez Gagné! ");
                System.exit(0);
            }
            List pvListe = new ArrayList();
            for(int k=0; k< enemies.size();k++) {
                pvListe.add(enemies.get(k).getLifePoints());
            }
                System.out.println("Listes des enemies: "+enemies);
            System.out.println(pvListe);

            System.out.println("Voulez vous utilisez vos potions (1), Bouffe(2), Non (3)");
            int consomable = sc.nextInt();
            switch (consomable) {
                case 1:
                    System.out.println("Sur quel Héros:");
                    int heroattack = sc.nextInt();
                    Hero hero = null;
                    switch (heroattack) {
                        case 1: hero = heroes.get(0);break;
                        case 2: hero = heroes.get(1);break;
                        case 3: hero = heroes.get(2);break;
                        case 4: hero = heroes.get(3); break;
                        default: break;
                    }
                    hero.usePotion();
                    break;
                case 2:
                    System.out.println("Pas accès");break;

                case 3:
                    System.out.println("OK");
            }
           /* try {
                Thread.sleep(3000L);
            } catch(InterruptedException ie) {
                Thread.currentThread().interrupt();
            }*/
            playerTurn = 0;

    }




    public void attaqueMultiple() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Avec quel heros voulez vous utilisez (1,2,....) : ");
        int heroattack = sc.nextInt();
        Hero hero = null;

        switch (heroattack) {
            case 1: hero = heroes.get(0);break;
            case 2: hero = heroes.get(1);break;
            case 3: hero = heroes.get(2);break;
            case 4: hero = heroes.get(3); break;
            default: break;
        }

        if(hero instanceof Healer==true){
            System.out.println("Quel héros voulez vous heal (1, 2,...) ?");
            int heal = sc.nextInt();
            switch (heal) {
                case 1: ((Healer) hero).heal(heroes.get(0));break;
                case 2: ((Healer) hero).heal(heroes.get(1));break;
                case 3: ((Healer) hero).heal(heroes.get(2));break;
                case 4: ((Healer) hero).heal(heroes.get(3)); break;
                default: break;
            }

        }

        else {


            System.out.println("Quel enemi voulez vous attaquez : ");
            int enemyattack = sc.nextInt();
            Enemy enemy = null;
            switch (enemyattack) {
                case 1:
                    enemy = enemies.get(0);
                    break;
                case 2:
                    enemy = enemies.get(1);
                    break;
                case 3:
                    enemy = enemies.get(2);
                    break;
                case 4:
                    enemy = enemies.get(3);
                    break;
                default:
                    break;
            }

            hero.attack(enemy);
        }

    }
    public List<Hero> getHeroes() {
        return heroes;
    }
    public List<Enemy> enemies = gameStarter.getEnemies();
}

