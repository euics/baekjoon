import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] arr;
    static Queue<int[]> beaver;
    static Queue<int[]> water;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        beaver = new LinkedList<>();
        water = new LinkedList<>();

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = input.charAt(j);

                if(arr[i][j] == '*')
                    water.add(new int[]{j, i});

                if(arr[i][j] == 'S')
                    beaver.add(new int[]{j, i, 0});
            }
        }

        System.out.println(escape());
    }

    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    private static String escape(){
        while(!beaver.isEmpty()){
            int waterLength = water.size();

            for(int i = 0; i < waterLength; i++){
                int[] cur = water.poll();

                for(int d = 0; d < 4; d++){
                    int nx = cur[0] + dix[d];
                    int ny = cur[1] + diy[d];

                    if(nx >= 0 && ny >= 0 && nx < m && ny < n && arr[ny][nx] == '.') {
                        arr[ny][nx] = '*';
                        water.add(new int[]{nx, ny});
                    }
                }
            }

            int beaverLength = beaver.size();

            for(int i = 0; i < beaverLength; i++){
                int[] cur = beaver.poll();

                for(int d = 0; d < 4; d++){
                    int nx = cur[0] + dix[d];
                    int ny = cur[1] + diy[d];

                    if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                        if(arr[ny][nx] == 'D')
                            return String.valueOf(cur[2] + 1);
                        if(arr[ny][nx] == '.') {
                            arr[ny][nx] = 'S';
                            beaver.add(new int[]{nx, ny, cur[2] + 1});
                        }
                    }
                }
            }
        }

        return "KAKTUS";
    }
}