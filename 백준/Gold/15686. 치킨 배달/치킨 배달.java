import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] arr;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> pizza = new ArrayList<>();
    static Coordinate[] pm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        pm = new Coordinate[m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)
                    house.add(new int[]{j, i});
                else if(arr[i][j] == 2)
                    pizza.add(new int[]{j, i});
            }
        }

        pizzaCombination(0, 0);

        System.out.println(answer);
    }

    private static void pizzaCombination(int L, int s){
        if(L == m){
            answer = Math.min(answer, findDistance());
        } else {
            for(int i = s; i < pizza.size(); i++){
                pm[L] = new Coordinate(pizza.get(i)[0], pizza.get(i)[1]);
                pizzaCombination(L + 1, i + 1);
            }
        }
    }

    private static int findDistance(){
        int min = 0;

        for(int i = 0; i < house.size(); i++){
            int[] cur = house.get(i);
            int minDistance = Integer.MAX_VALUE;
            for(int j = 0; j < pm.length; j++)
                minDistance = Math.min(minDistance, Math.abs(cur[0] - pm[j].x) + Math.abs(cur[1] - pm[j].y));

            min += minDistance;
        }

        return min;
    }
}

class Coordinate {
    int x, y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}