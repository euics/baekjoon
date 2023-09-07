import java.util.*;
        import java.io.*;

public class Main {
    static int n, m, total = Integer.MAX_VALUE;
    static int[][] arr;
    static ArrayList<Coordinate> chicken = new ArrayList<>();
    static ArrayList<Coordinate> home = new ArrayList<>();
    static Coordinate[] combi;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        combi = new Coordinate[m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2)
                    chicken.add(new Coordinate(j, i));
                if(arr[i][j] == 1)
                    home.add(new Coordinate(j, i));
            }
        }

        combination(0, 0);

        System.out.println(total);
    }

    private static void combination(int L, int s){
        if(L == m){
            int sum = 0;
            for(int i = 0; i < home.size(); i++){
                int distance = Integer.MAX_VALUE;
                int homeX1 = home.get(i).x + 1;
                int homeY1 = home.get(i).y + 1;
                
                for(int j = 0; j < combi.length; j++){
                    int chickenX2 = combi[j].x + 1;
                    int chickenY2 = combi[j].y + 1;

                    distance = Math.min(distance, findDistance(homeX1, homeY1, chickenX2, chickenY2));
                }
                sum += distance;
            }

            total = Math.min(total, sum);

        } else {
            for(int i = s; i < chicken.size(); i++){
                combi[L] = chicken.get(i);
                combination(L + 1, i + 1);
            }
        }
    }

    private static int findDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

class Coordinate {
    int x, y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}