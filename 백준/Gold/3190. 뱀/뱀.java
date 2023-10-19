import java.io.*;
import java.util.*;

public class Main {
    static int n, k, l;
    static int[][] arr;
    static HashMap<Integer, Character> map = new HashMap<>();
    static ArrayList<int[]> snake = new ArrayList<>();
    static int[] dix = {1, 0, -1, 0};
    static int[] diy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[y - 1][x - 1] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            map.put(time, ch);
        }

        solution();
    }

    private static void solution(){
        int x = 0, y = 0, time = 0, d = 0;
        snake.add(new int[]{0, 0});

        while(true){
            time++;

            int nx = x + dix[d];
            int ny = y + diy[d];

            if(finish(nx, ny))
                break;

            if(arr[ny][nx] == 1){
                snake.add(new int[]{nx, ny});
                arr[ny][nx] = 0;
            } else {
                snake.add(new int[]{nx, ny});
                snake.remove(0);
            }

            if(map.containsKey(time)){
                if(map.get(time) == 'D')
                    d = (d + 1) % 4;
                else
                    d = (d + 3) % 4;
            }

            x = nx;
            y = ny;
        }

        System.out.println(time);
    }

    private static boolean finish(int nx, int ny){
        if(nx < 0 || ny < 0 || nx >= n || ny >= n)
            return true;

        for(int i = 0; i < snake.size(); i++){
            int[] o = snake.get(i);

            if(o[0] == nx && o[1] == ny)
                return true;
        }

        return false;
    }
}