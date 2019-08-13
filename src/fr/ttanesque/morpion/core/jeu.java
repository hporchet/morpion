package fr.ttanesque.morpion.core;

public class jeu {

    /*
    * This function verify if the case of the matrice is empty in this case the two possible valor is X and O
    *
    * @param gameMatrice : a square matrix
    * @param x : location in the abscisse of the matrice
    * @param y : location in the ordinate of the matrice
     * */
    public static boolean canBePlaced(char[][] gameMatrice, int x, int y) {
        return gameMatrice[y][x] != 'X' || gameMatrice[y][x] != 'O';
    }

    /*
    * This function check if the game as an winner
    * 0 none, 1 fr.ttanesque.morpion.players.player win, 2 fr.ttanesque.morpion.players.ai win, 3 equality
    *
    * @param gameMatrice : a square matrix
    * */
    public static int checkEnd(char[][] gameMatrice) {
        int[] result = {column(gameMatrice), line(gameMatrice), diag(gameMatrice)};
        for (int b : result) {
            if (b != 0) return b;
        }
        if (checkEquality(gameMatrice)) return 3;
        else return 0;
    }

    private static int column(char[][] gameMatrice) {
        char lastChar = ' ';
        int checkColumn = 0; // for check it's the same symbol in the entire column

        for (int x = 0; x < gameMatrice.length; x++) {
            for (char[] a : gameMatrice) {
                if (lastChar == ' ') {
                    lastChar = a[x];
                    checkColumn = 1;
                } else if (a[x] == lastChar) checkColumn++;

                if (checkColumn == gameMatrice.length) {
                    if (lastChar == 'X') return 1; //player
                    else if (lastChar == 'O') return 2; //ai
                } else return 0;
            }
        }
        return 0; //
    }

    private static int line(char[][] gameMatrice) {
        char lastChar = ' ';
        int checkLine = 0; // for check it's the same symbol in the entire line

        for (char[] a : gameMatrice) {
            for (char x : a) {
                if (lastChar == ' ') {
                    lastChar = x;
                    checkLine = 1;
                } else if (x == lastChar) checkLine++;

                if (checkLine == gameMatrice.length) {
                    if (lastChar == 'X') return 1; // player
                    else if (lastChar == 'O') return 2; // ai
                } else return 0;
            }
        }
        return 0;
    }

    private static int diag(char[][] gameMatrice) {
        char lastChar1 = ' ';
        char lastChar2 = ' ';
        int checkDiag = 0;

        for (int i = 0; i < gameMatrice.length; i++) {
            if (lastChar1 != 'X' && lastChar1 != 'O') {
                lastChar1 = gameMatrice[i][i];
                checkDiag = 1;
            } else if (lastChar1 == gameMatrice[i][i]) checkDiag++;

            if (checkDiag == gameMatrice.length) {
                if (lastChar1 == 'X') return 1; //player
                else if (lastChar1 == 'O') return 2; //ai
            }
        }
        checkDiag = 0;
        for (int i=gameMatrice.length; i > 0; i--) {
            if (lastChar2 != 'X' && lastChar2 != 'O') {
                lastChar2 = gameMatrice[i][3 - i];
                checkDiag = 1;
            } else if (lastChar2 == gameMatrice[i][3 - i]) checkDiag++;
        }

        if (checkDiag == gameMatrice.length) {
            if (lastChar2 == 'X') return 1; //player
            else if (lastChar2 == 'O') return 2; //ai
        }

        return 0; //winner not found
    }

    private static boolean checkEquality(char[][] gameMatrice) {
        for (char[] a : gameMatrice) {
            for (char x : a) {
                if (x == ' ') return false;
            }
        } return true;
    }
}
