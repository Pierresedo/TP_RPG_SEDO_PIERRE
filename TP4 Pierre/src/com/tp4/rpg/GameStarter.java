package com.tp4.rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameStarter {

    private final Scanner scanner = new Scanner(System.in);
    public  List<Hero> heroes = new ArrayList<>();
    private final List<Enemy> enemies = new ArrayList<>();
    private int numberOfHero;
    // Choix des ennemies
    public void chooseEnemies() {
        var nbE = ThreadLocalRandom.current().nextInt(1, numberOfHero);
        enemies.addAll(IntStream.range(0, nbE).boxed().map(unused -> new BasicEnemy()).collect(Collectors.toList()));
        enemies.add( new Boss());
    }
    // Création des héros

    private Hero createHero(int index) {
        Hero hero = null;
        switch (index) {
            case 1: hero = new Hunter(); break;
            case 2: hero = new Warrior();break;
            case 3: hero = new Mage();break;
            case 4: hero = new Healer(); break;
            default: break;
        }
        if(Objects.isNull(hero)) {
            System.out.println("Vous avez choisi un mauvais numéro: Veuillez choisir un numéro entre 1 à 4");
            return createHero(doInput(0));
        }
        return hero;
    }

    private int doInput(int index) {

        System.out.format("Veuillez choisir votre héros n° %d: Hunter(1); Warrior(2); Mage(3); Healer(4): ", index +1);
        return scanner.nextInt();
    }

    private void chooseHeroes() {
        heroes.addAll(IntStream.range(0, numberOfHero)
                .boxed()
                .map(this::doInput)
                .map(this::createHero)
                .collect(Collectors.toList()));

    }


    public void start() {
        System.out.print("Saisir le nombre de héros: ");
        numberOfHero = scanner.nextInt();
        if (numberOfHero == 0) {
            System.out.println("Minimum 1 héro");
            System.exit(0);
        }
        chooseHeroes();
        chooseEnemies();
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }
}
