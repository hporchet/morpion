package fr.ttanesque.morpion.players;

import fr.ttanesque.morpion.core.game;

import java.util.Scanner;

public class player {

    /*
    * player side
    *
    * @param gameMatrice : a square matrix
    * */
    public static void playerTurn(char[][] gameMatrice) {

        int[] coordonate = new int[2];
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please insert your choice");
            System.out.println("x : ");
            coordonate[0] = scanner.nextInt();
            System.out.println("y : ");
            coordonate[1] = scanner.nextInt();
            if (game.canBePlaced(gameMatrice, coordonate[0], coordonate[1])) System.out.println("ok");

        } while (!game.canBePlaced(gameMatrice, coordonate[0], coordonate[1]));
        gameMatrice[coordonate[1]][coordonate[0]] = 'X';
    }
}
