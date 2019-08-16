package fr.ttanesque.morpion.players;

import fr.ttanesque.morpion.core.game;

import static fr.ttanesque.morpion.Main.MATRIX_SIZE;


public class ai {

    /*
    * ai side
    *
    * @param gameMatrix : a square matrix
    * */
    public static void aiTurn(char[][] gameMatrix) {
        if (game.canBePlaced(gameMatrix, 1, 1)) gameMatrix[1][1] = 'O';
        else {
            int[][][] result = new int[3][][];

            //fill
            result[0] = checkLine(gameMatrix);
            result[1] = checkColumn(gameMatrix);
            result[2] = checkDiag(gameMatrix);

            int[][] winTrue = new int[8][]; // [] = line column diag [] = the number ex 2 in line
            int iWinTrue = 0; // for fill correctly winTrue
            for (int j = 0; j < result.length; j++) {
                for (int i = 0; i < result[j].length; i++) {

                    // ai can win in one move
                    if (result[j][i][0] == 1 && result[j][i][1] == 2 && result[j][i][2] == MATRIX_SIZE - 1) {
                        urgentMove(gameMatrix, j, i);
                        return;
                    }
                    // player can win in one move
                    else if (result[j][i][0] == 1 && result[j][i][1] == 1 && result[j][i][2] == MATRIX_SIZE - 1) {
                        urgentMove(gameMatrix, j, i);
                        return;
                    }


                    if (result[j][i][0] == 1 && result[j][i][1] == 2) {
                        winTrue[iWinTrue] = new int[]{j, i};
                    } else if (result[j][i][0] == 1 && result[j][i][2] == 1) {
                        // low priority treatment
                        System.out.println(" low prio");
                    }
                }
            }
        }
    }

    /*
    *
    * */
    private static void urgentMove(char[][] gameMatrix, int j, int i) {
        if (j == 0) {
            for (int y = 0; y < MATRIX_SIZE; y++) {
                if (game.canBePlaced(gameMatrix, i, y)) {
                    gameMatrix[i][y] = 'O';
                    return;
                }
            }
        } else if (j == 1) {
            for (int y = 0; y < MATRIX_SIZE; y++) {
                if (game.canBePlaced(gameMatrix, i, y)) {
                    gameMatrix[i][y] = 'O';
                }
            }
        } else if (j == 2) {
            int y = 0;
            while (y < MATRIX_SIZE) {
                if (game.canBePlaced(gameMatrix, y, y)) {
                    gameMatrix[y][y] = 'O';
                }

                if (i == 0) {
                    y++;
                } else {
                    y--;
                }
            }
        } else {
            System.out.println("error in the matrix ai block line 30");
        }
    }

    /*
    * This function checks who could win the diagonal and the number of filled cases
    *
    * @param gameMatrix : a square matrix
    * @return {{CanWin, who, number of case fill}, ...}
    * who : 0 none, 1 player, 2 ai
    * CanWin : 0 false, 1 true
    * */
    private static int[][] checkDiag(char[][] gameMatrix) {
        int[][] situation = new int[2][3];

        int playerCase = 0;
        int aiCase = 0;

        for (int i = 0; i < MATRIX_SIZE; i++) {
            if (gameMatrix[i][i] == 'X') playerCase++;
            else if (gameMatrix[i][i] == 'O') aiCase++;
        }
        formatFill(situation, playerCase, aiCase, 0);

        for (int i = MATRIX_SIZE -1; i >= 0; i--) {
            if (gameMatrix[i][i] == 'X') playerCase++;
            else if (gameMatrix[i][i] == 'O') aiCase++;
        }
        formatFill(situation, playerCase, aiCase, 1);

        return situation;
    }

    /*
     * This function checks who could win the line and the number of filled cases
     *
     * @param gameMatrix : a square matrix
     * @return {{CanWin, who, number of case fill}, ...}
     *          who : 0 none, 1 player, 2 ai
     *          CanWin : 0 false, 1 true
     * */
    private static int[][] checkLine(char[][] gameMatrix) {
        int[][] situation = new int[MATRIX_SIZE][3];

        int playerCase ;
        int aiCase;

        for (int i = 0; i< MATRIX_SIZE; i++) {
            playerCase = 0;
            aiCase = 0;
            for (int j = 0; j< MATRIX_SIZE; j++) {
                if (gameMatrix[i][j] == 'X') playerCase++;
                else if (gameMatrix[i][j] == 'O') aiCase++;
            }
            formatFill(situation, playerCase, aiCase, i);
        }

        return situation;

    }

    /*
     * This function checks who could win the column and the numbre of filled case
     *
     * @param gameMatrix : a square matrix
     * @return {{CanWin, who, number of case fill}, ...}
     *          who : 0 none, 1 player, 2 ai
     *          CanWin : 0 false, 1 true
     * */
    private static int[][] checkColumn(char[][] gameMatrix) {
        int[][] situation = new int[MATRIX_SIZE][3];

        int playerCase;
        int aiCase;

        for (int i = 0; i< MATRIX_SIZE; i++) {
            playerCase = 0;
            aiCase = 0;
            for (int j = 0; j < MATRIX_SIZE; j++) {
                if (gameMatrix[j][i] == 'X') playerCase++;
                else if (gameMatrix[j][i] == 'O') aiCase++;
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
    private static void formatFill(int[][] situation, int playerCase, int aiCase, int i) {
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
