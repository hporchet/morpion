package fr.ttanesque.morpion.players;

import fr.ttanesque.morpion.core.jeu;

import java.util.Scanner;

public class player {
    public static void playerTurn(char[][] gameMatrice) {

        int[] coordonate = new int[2];
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please insert your choice");
            System.out.println("x : ");
            coordonate[0] = scanner.nextInt();
            System.out.println("y : ");
            coordonate[1] = scanner.nextInt();

        } while (jeu.canBePlaced(gameMatrice, coordonate[0], coordonate[1]));
        gameMatrice[coordonate[1]][coordonate[0]] = 'X';
    }
}
