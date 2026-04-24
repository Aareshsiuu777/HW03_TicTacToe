import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            clearBoard();
            String player = "X";
            boolean gameOver = false;

            while (!gameOver) {
                display();
                System.out.println("Player " + player + "'s turn.");

                int row = SafeInput.getRangedInt(input, "Enter row (1-3)", 1, 3) - 1;
                int col = SafeInput.getRangedInt(input, "Enter col (1-3)", 1, 3) - 1;

                while (!isValidMove(row, col)) {
                    System.out.println("That spot is taken! Try again.");
                    row = SafeInput.getRangedInt(input, "Enter row (1-3)", 1, 3) - 1;
                    col = SafeInput.getRangedInt(input, "Enter col (1-3)", 1, 3) - 1;
                }

                board[row][col] = player;

                if (isWin(player)) {
                    display();
                    System.out.println("Player " + player + " wins!");
                    gameOver = true;
                } else if (isTie()) {
                    display();
                    System.out.println("It's a tie!");
                    gameOver = true;
                } else {
                    if (player.equals("X")) {
                        player = "O";
                    } else {
                        player = "X";
                    }
                }
            }

            playAgain = SafeInput.getYNConfirm(input, "Play again?");
        }

        System.out.println("Thanks for playing!");
    }

    private static void clearBoard() {
        for (int r = 0; r < ROW; r++)
            for (int c = 0; c < COL; c++)
                board[r][c] = " ";
    }

    private static void display() {
        System.out.println("\n");
        System.out.println("  1   2   3");
        for (int r = 0; r < ROW; r++) {
            System.out.print((r + 1) + " ");
            for (int c = 0; c < COL; c++) {
                System.out.print(board[r][c]);
                if (c < COL - 1) System.out.print(" | ");
            }
            System.out.println();
            if (r < ROW - 1)
                System.out.println("  ---------");
        }
        System.out.println("\n");
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isRowWin(String player) {
        for (int r = 0; r < ROW; r++) {
            if (board[r][0].equals(player) &&
                    board[r][1].equals(player) &&
                    board[r][2].equals(player))
                return true;
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int c = 0; c < COL; c++) {
            if (board[0][c].equals(player) &&
                    board[1][c].equals(player) &&
                    board[2][c].equals(player))
                return true;
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        if (board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player))
            return true;
        if (board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player))
            return true;
        return false;
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isTie() {
        for (int r = 0; r < ROW; r++)
            for (int c = 0; c < COL; c++)
                if (board[r][c].equals(" "))
                    return false;
        return true;
    }
}