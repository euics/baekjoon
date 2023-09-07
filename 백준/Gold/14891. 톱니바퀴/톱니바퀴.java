import java.util.*;
import java.io.*;

public class Main {
    static int[][] gears = new int[4][8];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 4; i++){
            String input = br.readLine();
            for(int j = 0; j < 8; j++)
                gears[i][j] = input.charAt(j) - '0';
        }

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            findDir(gearNum, dir);
        }

        int score = 0;
        for(int i = 0; i < 4; i++){
            if(gears[i][0] == 1)
                score += Math.pow(2, i);
        }

        System.out.println(score);
    }

    private static void findDir(int gearNum, int dir){
        int[] directions = new int[4];
        directions[gearNum] = dir;

        for(int i = gearNum; i > 0; i--){
            if(gears[i][6] != gears[i - 1][2])
                directions[i - 1] = -directions[i];
            else
                break;
        }

        for(int i = gearNum; i < 3; i++){
            if(gears[i][2] != gears[i + 1][6])
                directions[i + 1] = -directions[i];
            else
                break;
        }

        rotate(directions);
    }

    private static void rotate(int[] directions){
        for(int i = 0; i < 4; i++){
            if(directions[i] == 1){
                int temp = gears[i][7];
                for(int j = 7; j > 0; j--)
                    gears[i][j] = gears[i][j - 1];
                gears[i][0] = temp;
            } else if(directions[i] == -1){
                int temp = gears[i][0];
                for(int j = 0; j < 7; j++)
                    gears[i][j] = gears[i][j + 1];
                gears[i][7] = temp;
            }
        }
    }
}

