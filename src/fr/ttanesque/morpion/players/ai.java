package fr.ttanesque.morpion.players;

import fr.ttanesque.morpion.core.jeu;

public class ai {
    public static void aiTurn(char[][] gameMatrice) {
        if (jeu.canBePlaced(gameMatrice, 1, 1)) gameMatrice[1][1] = 'O';
        else {
            for (int i=0; i<gameMatrice.length; i++) {
                for (int j=0; j<gameMatrice.length; j++) {
                    System.out.println("ok");
                }
            }
        }
    }
}
