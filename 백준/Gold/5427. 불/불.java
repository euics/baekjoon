import java.io.*;
import java.util.*;

public class Main {
    static int t, n, m;
    static char[][] arr;
    static Queue<int[]> sangen;
    static Queue<int[]> fire;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            arr = new char[n][m];
            sangen = new LinkedList<>();
            fire = new LinkedList<>();

            for(int j = 0; j < n; j++){
                String input = br.readLine();
                for(int l = 0; l < m; l++) {
                    arr[j][l] = input.charAt(l);
                    if(arr[j][l] == '*')
                        fire.add(new int[]{l, j, 0});

                    if(arr[j][l] == '@')
                        sangen.add(new int[]{l, j, 0});
                }
            }

            System.out.println(escape());
        }
    }

    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    private static String escape(){
        while(!sangen.isEmpty()){
            int fireLength = fire.size();

            for(int i = 0; i < fireLength; i++){
                int[] cur = fire.poll();

                for(int d = 0; d < 4; d++){
                    int nx = cur[0] + dix[d];
                    int ny = cur[1] + diy[d];

                    if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                        if(arr[ny][nx] == '.' || arr[ny][nx] == '@'){
                            arr[ny][nx] = '*';
                            fire.add(new int[]{nx, ny, cur[2] + 1});
                        }
                    }
                }
            }

            int sangenLength = sangen.size();

            for(int i = 0; i < sangenLength; i++){
                int[] cur = sangen.poll();

                for(int d = 0; d < 4; d++){
                    int nx = cur[0] + dix[d];
                    int ny = cur[1] + diy[d];

                    if(nx < 0 || ny < 0 || nx >= m || ny >= n)
                        return String.valueOf(cur[2] + 1);

                    if(arr[ny][nx] == '.'){
                        arr[ny][nx] = '@';
                        sangen.add(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }

        return "IMPOSSIBLE";
    }
}