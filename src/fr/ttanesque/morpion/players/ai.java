package fr.ttanesque.morpion.players;

import fr.ttanesque.morpion.core.jeu;

public class ai {

    /*
    * ai side
    *
    * @param gameMatrice : a square matrix
    * */
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


    /*
    * This function check who can win in the diagonal and the numbre of case fill
    *
    * @param gameMatrice : a square matrix
    * @return {{CanWin, who, number of case fill}, ...}
    * who : 0 none, 1 player, 2ai
    * CanWin : 0 false, 1 true
    * */
    private int[] checkDiag(char[][] gameMatrice) {

    }

    /*
     * This function check who can win in the line and the numbre of case fill
     *
     * @param gameMatrice : a square matrix
     * @return {{CanWin, who, number of case fill}, ...}
     *          who : 0 none, 1 player, 2ai
     *          CanWin : 0 false, 1 true
     * */
    private int[][] checkLine(char[][] gameMatrice) {

    }
}
