import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0, answer = 0;
    static char[][] arr;
    static boolean[][] bool;
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new char[12][6];
        bool = new boolean[12][6];

        for(int i = 0; i < 12; i++){
            String input = br.readLine();
            for(int j = 0; j < 6; j++)
                arr[i][j] = input.charAt(j);
        }

        while(true){
            bool = new boolean[12][6];
            boolean foundCluster = false;

            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    if(arr[i][j] != '.' && !bool[i][j]){
                        if(findCluster(j, i, arr[i][j]))
                            foundCluster = true;
                    }
                }
            }

            if(!foundCluster)
                break;

            answer++;
            fallDown();
        }

        System.out.println(answer);
    }

    private static boolean findCluster(int x, int y, char ch){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> cluster = new LinkedList<>();
        q.add(new int[]{x, y});
        bool[y][x] = true;
        while(!q.isEmpty()){
            int length = q.size();

            for(int i = 0; i < length; i++){
                int[] o = q.poll();
                cluster.add(new int[]{o[0], o[1]});

                for(int d = 0; d < 4; d++){
                    int nx = o[0] + dix[d];
                    int ny = o[1] + diy[d];

                    if(nx >= 0 && ny >= 0 && nx < 6 && ny < 12 && arr[ny][nx] == ch){
                        if(!bool[ny][nx]){
                            q.add(new int[]{nx, ny});
                            bool[ny][nx] = true;
                        }
                    }
                }
            }
        }

        if(cluster.size() >= 4){
            for(int[] point : cluster)
                arr[point[1]][point[0]] = '.';

            return true;
        }

        return false;
    }

    private static void fallDown(){
        for(int j = 0; j < 6; j++){
            Queue<Character> q = new LinkedList<>();
            for(int i = 11; i >= 0; i--){
                if(arr[i][j] != '.'){
                    q.add(arr[i][j]);
                    arr[i][j] = '.';
                }
            }

            int index = 11;
            while(!q.isEmpty()){
                arr[index--][j] = q.poll();
            }
        }
    }
}