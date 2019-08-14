package fr.ttanesque.morpion.players;

import fr.ttanesque.morpion.core.game;

import static fr.ttanesque.morpion.Main.MATRICE_SIZE;


public class ai {

    /*
    * ai side
    *
    * @param gameMatrice : a square matrix
    * */
    public static void aiTurn(char[][] gameMatrice) {
        if (game.canBePlaced(gameMatrice, 1, 1)) gameMatrice[1][1] = 'O';
        else {
            for (int i=0; i<MATRICE_SIZE; i++) {
                for (int j=0; j<MATRICE_SIZE; j++) {
                    System.out.println("ok");
                }
            }
        }
    }


    /*
    * This function checks who could win the diagonal and the number of filled cases
    *
    * @param gameMatrice : a square matrix
    * @return {{CanWin, who, number of case fill}, ...}
    * who : 0 none, 1 player, 2ai
    * CanWin : 0 false, 1 true
    * */
    private int[] checkDiag(char[][] gameMatrice) {

    }

    /*
     * This function checks who could win the line and the number of filled cases
     *
     * @param gameMatrice : a square matrix
     * @return {{CanWin, who, number of case fill}, ...}
     *          who : 0 none, 1 player, 2ai
     *          CanWin : 0 false, 1 true
     * */
    private int[][] checkLine(char[][] gameMatrice) {
        int[][] situation = new int[MATRICE_SIZE][2];
        // int[] => the line
        // [] in a line : first ai number case fill , second player number case fill

        boolean canWin;
        int playerCase = 0;
        int aiCase = 0;

        for (int i=0; i<MATRICE_SIZE; i++) {
            for (int j=0; j<MATRICE_SIZE; j++) {
                if (gameMatrice[i][j] == 'X') playerCase++;
                else if (gameMatrice[i][j] == 'O') aiCase++;
            }
            //fill the line
            if (playerCase > 0 && aiCase > 0) canWin = false;
            situation[i][0] = canWin;
            if (playerCase > aiCase) {
                situation[i][1] = 1;
            } else if (aiCase > playerCase) {
                situation[i][1] = 2;
            } else if (aiCase > 0 && playerCase > 0)

        }

    }

    /*
     * This function checks who could win the column and the numbre of filled case
     *
     * @param gameMatrice : a square matrix
     * @return {{CanWin, who, number of case fill}, ...}
     *          who : 0 none, 1 player, 2ai
     *          CanWin : 0 false, 1 true
     * */
    private int[][] checkColumn(char[][] gameMatrice) {

    }
}
