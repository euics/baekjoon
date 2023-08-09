import java.util.Scanner;

public class Main {
    static int[][] board = new int[9][9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                board[y][x] = scanner.nextInt();
            }
        }
        
        sudoku(0, 0);
    }

    public static void sudoku(int y, int x) {
        if (x == 9) {
            sudoku(y + 1, 0);
            return;
        }

        if (y == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (board[y][x] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isValid(y, x, i)) {
                    board[y][x] = i;
                    sudoku(y, x + 1);
                    board[y][x] = 0;
                }
            }
        } else {
            sudoku(y, x + 1);
        }
    }

    public static boolean isValid(int y, int x, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == value) return false;
            if (board[i][x] == value) return false;
            if (board[(y / 3) * 3 + i / 3][(x / 3) * 3 + i % 3] == value) return false;
        }
        return true;
    }
}
