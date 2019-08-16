package fr.ttanesque.morpion.core;

import static fr.ttanesque.morpion.Main.MATRICE_SIZE;

public class game {

    /*
    * This function checks if the case of the matrix is empty. possible : valor is X and O
    *
    * @param gameMatrix : a square matrix
    * @param x : location in the abscisse of the matrice
    * @param y : location in the ordinate of the matrice
     * */
    public static boolean canBePlaced(char[][] gameMatrix, int x, int y) {
        return gameMatrix[y][x] != 'X' || gameMatrix[y][x] != 'O';
    }

    /*
    * This function checks if the game as a winner
    * 0 none, 1 player win, 2 ai win, 3 equality
    *
    * @param gameMatrix : a square matrix
    * */
    public static int checkEnd(char[][] gameMatrix) {
        int[] result = {column(gameMatrix), line(gameMatrix), diag(gameMatrix)};
        for (int b : result) {
            if (b != 0) return b;
        }
        if (checkEquality(gameMatrix)) return 3;
        else return 0;
    }

    private static int column(char[][] gameMatrix) {
        char lastChar = ' ';
        int checkColumn = 0; // for checks it's the same symbol on the entire column

        for (int x = 0; x < MATRICE_SIZE; x++) {
            for (char[] a : gameMatrix) {
                if (lastChar == ' ') {
                    lastChar = a[x];
                    checkColumn = 1;
                } else if (a[x] == lastChar) checkColumn++;

                if (checkColumn == MATRICE_SIZE) {
                    if (lastChar == 'X') return 1; //player
                    else if (lastChar == 'O') return 2; //ai
                } else return 0;
            }
        }
        return 0; //
    }

    private static int line(char[][] gameMatrix) {
        char lastChar = ' ';
        int checkLine = 0; // for check it's the same symbol on the entire line

        for (char[] a : gameMatrix) {
            for (char x : a) {
                if (lastChar == ' ') {
                    lastChar = x;
                    checkLine = 1;
                } else if (x == lastChar) checkLine++;
            }
        }
        if (checkLine == MATRICE_SIZE) {
            if (lastChar == 'X') return 1; // player
            else if (lastChar == 'O') return 2; // ai
        }
        return 0;
    }

    private static int diag(char[][] gameMatrix) {
        char lastChar = ' ';
        int checkDiag = 0;

        for (int i = 0; i < MATRICE_SIZE; i++) {
            if (lastChar != 'X' && lastChar != 'O') {
                lastChar = gameMatrix[i][i];
                checkDiag = 1;
            } else if (lastChar == gameMatrix[i][i]) checkDiag++;
        }
        // if we have a winner we directly stop
        if (checkDiag == MATRICE_SIZE) {
            if (lastChar == 'X') return 1; //player
            else if (lastChar == 'O') return 2; //ai
        }
        
        //reinitialisation 
        checkDiag = 0;
        lastChar = ' ';


        for (int i=MATRICE_SIZE -1; i >= 0; i--) {
            if (lastChar != 'X' && lastChar != 'O') {
                lastChar = gameMatrix[i][2 - i];
                checkDiag = 1;
            } else if (lastChar == gameMatrix[i][2 - i]) checkDiag++;
        }

        if (checkDiag == MATRICE_SIZE) {
            if (lastChar == 'X') return 1; //player
            else if (lastChar == 'O') return 2; //ai
        }

        return 0; //winner not found
    }

    private static boolean checkEquality(char[][] gameMatrix) {
        for (char[] a : gameMatrix) {
            for (char x : a) {
                if (x == ' ') return false;
            }
        } return true;
    }
}
