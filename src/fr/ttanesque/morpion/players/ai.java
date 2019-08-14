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
    private int[][] checkDiag(char[][] gameMatrice) {
        int[][] situation = new int[MATRICE_SIZE][3];

        int playerCase = 0;
        int aiCase = 0;

        return situation;
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
        int[][] situation = new int[MATRICE_SIZE][3];

        int playerCase = 0;
        int aiCase = 0;

        for (int i=0; i<MATRICE_SIZE; i++) {
            playerCase = 0;
            aiCase = 0;
            for (int j=0; j<MATRICE_SIZE; j++) {
                if (gameMatrice[i][j] == 'X') playerCase++;
                else if (gameMatrice[i][j] == 'O') aiCase++;
            }
            formatFill(situation, playerCase, aiCase, i);
        }

        return situation;

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
        int[][] situation = new int[MATRICE_SIZE][3];

        int playerCase = 0;
        int aiCase = 0;

        for (int i=0; i<MATRICE_SIZE; i++) {
            playerCase = 0;
            aiCase = 0;
            for (int j = 0; j < MATRICE_SIZE; j++) {
                if (gameMatrice[j][i] == 'X') playerCase++;
                else if (gameMatrice[j][i] == 'O') aiCase++;
            }
            formatFill(situation, playerCase, aiCase, i);
        }

        return situation;
    }

    /*
    * This function fill the data with the format {{CanWin, who, number of case fill}, ...}
    *                                               who : 0 none, 1 player, 2ai
    *                                               CanWin : 0 false, 1 true
    *
    * @param situation : tab who stock data
    * @param playerCase : number of filled cases by player
    * @param aiCase : number of filled cases by ai
    * @param i : the indices who data would be stocked
    * */
    private void formatFill(int[][] situation, int playerCase, int aiCase, int i) {
        //fill the line
        //canWin
        if (playerCase > 0 && aiCase > 0) situation[i][0] = 0;
        else situation[i][0] = 1;

        //who
        if (playerCase > aiCase) {
            situation[i][1] = 1; //player
        } else if (aiCase > playerCase) {
            situation[i][1] = 2; //ai
        } else if (aiCase == playerCase) {
            situation[i][1] = 3; //equality
        } else {
            situation[i][1] = 0; //none
        }

        //number of filled cases
        switch (situation[i][1]) {
            case 0:
                situation[i][2] = 0;
                break;
            case 1:
                situation[i][2] = playerCase;
                break;
            case 2:
                situation[i][2] = aiCase;
                break;
            case 3:
                situation[i][2] = playerCase; // same result
            default:
                situation[i][2] = 0;
                break;
        }
    }
}
