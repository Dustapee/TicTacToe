package src;

import java.util.Scanner;

public class TicTacToe {
    private final int[][] model = new int[3][3];
    private int currentPlayer;
    private boolean winner;
    private int moves = 0;
    static Scanner scanner = new Scanner(System.in);

    private boolean updateCellBoard(int row, int col) {
        return model[row][col] == 0;
    }

    private void updateBoard() {
        for (int row = 0; row < 3; row++) {
            System.out.print("|");
            for (int col = 0; col < 3; col++) {
                System.out.print(model[row][col] + "|");
            }
            System.out.println();
        }
    }

    private void board() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        currentPlayer = 1;
        for (int row = 0; row < 3; row++) {
            System.out.print("|");
            for (int col = 0; col < 3; col++) {
                model[row][col] = 0;
                System.out.print(model[row][col] + "|");
            }
            System.out.println();
        }
    }

    public boolean checkWin(int row, int col, int n) {
        if (model[row][0] == n && model[row][1] == n && model[row][2] == n)
            return true;
        else if (model[0][col] == n && model[1][col] == n && model[2][col] == n)
            return true;
        else if (model[0][0] == n && model[1][1] == n && model[2][2] == n)
            return true;
        else return model[2][0] == n && model[1][1] == n && model[0][2] == n;
    }

    private void game() {
        int row;
        int col;
        while (!winner) {
            System.out.println("Please write the cell where you want to mark your X or O");

            row = scanner.nextInt();
            col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Please enter a valid row or column!");
                continue;
            }

            if (currentPlayer == 1) {
                if (updateCellBoard(row, col)) {
                    model[row][col] = 1;
                    moves++;
                } else {
                    System.out.println("This cell is occupied! " + model[row][col] + " player!");
                    continue;
                }
                updateBoard();
                if (checkWin(row, col, currentPlayer)) {
                    System.out.println("Congratulations!" + currentPlayer + " won!");
                    winner = true;
                }
                currentPlayer++;
            } else if (currentPlayer == 2) {
                if (updateCellBoard(row, col)) {
                    model[row][col] = 2;
                    moves++;
                }
                else {
                    System.out.println("This cell is occupied! " + model[row][col] + " player!");
                    continue;
                }
                updateBoard();
                if (checkWin(row, col, currentPlayer)) {
                    System.out.println("Congratulations!" + currentPlayer + " won!");
                    winner = true;
                }
                currentPlayer = 1;
            }
            if(moves == 9) {
                System.out.println("It's a tie!");
                return;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.board();
        game.game();
    }
}
