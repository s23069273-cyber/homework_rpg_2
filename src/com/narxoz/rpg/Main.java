package com.narxoz.rpg;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.builder.EnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.factory.*;

public class Main {
    public static void main(String[] args) {

        EnemyBuilder builder = new EnemyBuilder();
        EnemyDirector director = new EnemyDirector(builder);

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        Enemy fireBoss = director.createEliteBoss("Ancient Fire Dragon", fireFactory);
        System.out.println("--- (Original) ---");
        fireBoss.displayStatus();

        EnemyComponentFactory iceFactory = new IceComponentFactory();
        Enemy iceMinion = director.createMinion("Frost Goblin", iceFactory);
        System.out.println("\n--- New theme (Ice Theme) ---");
        iceMinion.displayStatus();

        Enemy clonedBoss = fireBoss.clone();
        if (clonedBoss != null) {
            clonedBoss.setName("Cloned Shadow Dragon");
            System.out.println("\n--- Clone created ---");
            clonedBoss.displayStatus();

            System.out.println("\n--- Is the original still intact? ---");
            fireBoss.displayStatus();
        }
    }
}
