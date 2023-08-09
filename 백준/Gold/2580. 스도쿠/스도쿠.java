import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        sudoku(0, 0);
    }

    private static void sudoku(int y, int x){
        if(x == 9){
            sudoku(y + 1, 0);
            return;
        }

        if(y == 9){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++)
                    System.out.print(arr[i][j] + " ");
                System.out.println();
            }
            System.exit(0);
        }

        if(arr[y][x] == 0){
            for(int value = 1; value <= 9; value++){
                if(isValid(y, x, value)){
                    arr[y][x] = value;
                    sudoku(y, x + 1);
                    arr[y][x] = 0;
                }
            }
        } else
            sudoku(y, x + 1);
    }

    private static boolean isValid(int y, int x, int value){
        for(int i = 0; i < 9; i++){
            if(arr[y][i] == value)
                return false;
            if(arr[i][x] == value)
                return false;
        }

        int set_y = (y / 3) * 3;
        int set_x = (x / 3) * 3;
        for(int i = set_y; i < set_y + 3; i++){
            for(int j = set_x; j < set_x + 3; j++){
                if(arr[i][j] == value)
                    return false;
            }
        }

        return true;
    }
}