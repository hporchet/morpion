package fr.ttanesque.morpion;



import fr.ttanesque.morpion.core.game;
import fr.ttanesque.morpion.players.ai;
import fr.ttanesque.morpion.players.player;

public class Main {

    public static final int MATRIX_SIZE = 3;
    
    public static void main(String[] args) {
        //create the game support
        char[][] gameMatrix = new char[MATRIX_SIZE][MATRIX_SIZE];

        //fill it with ' '
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                gameMatrix[i][j] = ' ';
            }
        }

        do {
            show(gameMatrix);
            player.playerTurn(gameMatrix);
            show(gameMatrix);

            int result = game.checkEnd(gameMatrix);
            if (result != 0) { //game is end
                end(result);
            } else {
                ai.aiTurn(gameMatrix);
            }


        } while (game.checkEnd(gameMatrix) == 0);
    }

    /*
     * @param gameMatrix : a squared matrix char who represent the cases of game
     * example :
     * -----
     * |X  |
     * |  O|
     * |   |
     * -----
     */
    private static void show(char[][] gameMatrice) {
        System.out.println("-----");
        for (char[] a : gameMatrice) {
            System.out.print("|");
            for (char b : a) {
                if (b == 'X' || b == 'O')System.out.print(b);
                else System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("-----");
    }

    private static void end(int i) {
        switch (i) {
            case 1:
                System.out.println("Congratulation your win");
                break;
            case 2:
                System.out.println("Game over");
                break;
            case 3:
                System.out.println("Equality");
                break;
            default:
                System.out.println("error in the matrix");
                break;
        }
    }
}
