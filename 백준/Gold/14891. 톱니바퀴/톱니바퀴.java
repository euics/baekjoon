import java.io.*;
import java.util.*;

public class Main {
    static int[][] gears = new int[4][8];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = input.charAt(j) - '0';
            }
        }
        
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1; // 0-based index
            int direction = Integer.parseInt(st.nextToken());
            
            rotate(gearNum, direction);
        }
        
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][0] == 1) {
                score += (int)Math.pow(2, i);
            }
        }
        
        System.out.println(score);
    }
    
    public static void rotate(int gearNum, int direction) {
        int[] directions = new int[4]; // store rotation direction for each gear
        directions[gearNum] = direction;
        
        // check left gears
        for (int i = gearNum; i > 0; i--) {
            if (gears[i][6] != gears[i - 1][2]) {
                directions[i - 1] = -directions[i];
            } else {
                break;
            }
        }
        
        // check right gears
        for (int i = gearNum; i < 3; i++) {
            if (gears[i][2] != gears[i + 1][6]) {
                directions[i + 1] = -directions[i];
            } else {
                break;
            }
        }
        
        for (int i = 0; i < 4; i++) {
            if (directions[i] == 1) {
                int temp = gears[i][7];
                for (int j = 7; j > 0; j--) {
                    gears[i][j] = gears[i][j - 1];
                }
                gears[i][0] = temp;
            } else if (directions[i] == -1) {
                int temp = gears[i][0];
                for (int j = 0; j < 7; j++) {
                    gears[i][j] = gears[i][j + 1];
                }
                gears[i][7] = temp;
            }
        }
    }
}
