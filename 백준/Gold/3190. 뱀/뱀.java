import java.io.*;
import java.util.*;

public class Main {
    static int n, k, l;
    static int[][] arr;
    static List<int[]> snake = new ArrayList<>();
    static HashMap<Integer, String> map = new HashMap<>();
    static int[] dix = {1, 0, -1, 0}; // 동 남 서 북
    static int[] diy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            arr[y][x] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            map.put(time, direction);
        }

        solution();
    }

    private static void solution(){
        int x = 0, y = 0, time = 0, d = 0;
        snake.add(new int[]{0, 0});

        while(true){
            // 시간 재기
            time++;

            // 뱀 이동
            int nx = x + dix[d];
            int ny = y + diy[d];

            // 범위를 벗어나거나, 뱀 몸통을 만날 때 종료
            boolean flag = false;
            if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                flag = true;
            for(int i = 0; i < snake.size(); i++){
                int[] o = snake.get(i);
                if(o[0] == nx && o[1] == ny)
                    flag = true;
            }

            if(flag)
                break;

            // 사과가 있을 때, 없을 때 처리
            if(arr[ny][nx] == 1){
                arr[ny][nx] = 0;
                snake.add(new int[]{nx, ny});
            } else {
                snake.add(new int[]{nx, ny});
                snake.remove(0);
            }

            // 방향을 바꿔주는 시간을 만날 때, 방향 변경
            if(map.containsKey(time)){
                if(map.get(time).equals("D"))
                    d = (d + 1) % 4;
                else
                    d = (d + 3) % 4;
            }

            x = nx;
            y = ny;
        }

        System.out.println(time);
    }
}