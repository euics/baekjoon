import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] bool;
    static int countPerDanji;

    static int[] dix = {-1, 1, 0, 0};
    static int[] diy = {0, 0, -1, 1};
    static int nowX, nowY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        bool = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < n; j++)
                arr[i][j] = Character.getNumericValue(input.charAt(j));
        }

        List<Integer> countList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1 && !bool[i][j]){
                    countPerDanji = 0;
                    DFS(i, j);
                    countList.add(countPerDanji);
                }
            }
        }

        System.out.println(countList.size());

        Collections.sort(countList);
        for (Integer integer : countList)
            System.out.println(integer);
    }

    private static void DFS(int x, int y){
        bool[x][y] = true;
        countPerDanji++;

        for(int i = 0; i < 4; i++){
            nowX = x + dix[i];
            nowY = y + diy[i];

            if(nowX >= 0 && nowY >= 0 && nowX < n && nowY < n){
                if(arr[nowX][nowY] == 1 && !bool[nowX][nowY])
                    DFS(nowX, nowY);
            }
        }
    }
}
