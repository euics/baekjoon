import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
        }

        int answer = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int dy = -n; dy < n; dy++){
                    for(int dx = -m; dx < m; dx++){
                        if(dx == 0 && dy == 0)
                            continue;

                        // 초기값, 초기위치
                        int x = j, y = i, num = 0;
                        while(x >= 0 && x < m && y >= 0 && y < n){
                            num = num * 10 + arr[y][x];

                            if(isPerfectSquare(num))
                                answer = Math.max(answer, num);

                            y += dy;
                            x += dx;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean isPerfectSquare(int num){
        return (int)Math.sqrt(num) * (int)Math.sqrt(num) == num;
    }
}