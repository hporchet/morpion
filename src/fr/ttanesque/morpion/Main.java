package fr.ttanesque.morpion;



import fr.ttanesque.morpion.core.jeu;
import fr.ttanesque.morpion.players.ai;
import fr.ttanesque.morpion.players.player;

public class Main {

    public static void main(String[] args) {
        //create the game support
        char[][] gameMatrice = new char[3][3];
        for (char[] a : gameMatrice) {
            for (char x : a) {
                x = ' ';
            }
        }

        do {
            show(gameMatrice);
            player.playerTurn(gameMatrice);
            show(gameMatrice);

            int result = jeu.checkEnd(gameMatrice);
            if (result != 0) {
                end(result);
            } else {
                ai.aiTurn(gameMatrice);
            }


        } while (jeu.checkEnd(gameMatrice) == 0);
    }

    /*
     * @param gamMatrice : a squared matrice char who represent the case of game
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
            case 2:
                System.out.println("Game over");
            case 3:
                System.out.println("Equality");
            default:
                System.out.println("error in the matrix");
        }
    }
}
