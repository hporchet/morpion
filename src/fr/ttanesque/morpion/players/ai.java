package fr.ttanesque.morpion.players;

import fr.ttanesque.morpion.core.jeu;

public class ai {
    public static void aiTurn(char[][] gameMatrice) {
        if (jeu.canBePlaced(gameMatrice, 1, 1)) gameMatrice[1][1] = 'O';
    }
}
