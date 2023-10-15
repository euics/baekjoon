import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(L == 0 && R == 0 && C == 0)
                break;


            char[][][] building = new char[L][R][C];
            Location start = null, end = null;

            for(int l = 0; l < L; l++){
                for(int r = 0; r < R; r++){
                    String input = br.readLine();

                    for(int c = 0; c < C; c++){
                        building[l][r][c] = input.charAt(c);
                        if(building[l][r][c] == 'S')
                            start = new Location(l, r, c);
                        if(building[l][r][c] == 'E')
                            end = new Location(l, r, c);
                    }
                }

                br.readLine();
            }

            int result = BFS(building, start, end, L, R, C);

            if(result == -1)
                System.out.println("Trapped!");
            else
                System.out.println("Escaped in " + result + " minute(s).");
        }
    }

    private static int BFS(char[][][] building, Location start, Location end, int L, int R, int C){
        int[] dl = new int[]{1, -1, 0, 0, 0, 0,};
        int[] dr = new int[]{0, 0, -1, 1, 0, 0};
        int[] dc = new int[]{0, 0, 0, 0, -1, 1};

        Queue<Location> q = new LinkedList<>();
        boolean[][][] bool = new boolean[L][R][C];
        q.add(start);
        bool[start.l][start.r][start.c] = true;
        int min = 0;

        while(!q.isEmpty()){
            int length = q.size();

            for(int i = 0; i < length; i++){
                Location cur = q.poll();

                if(cur.l == end.l && cur.r == end.r && cur.c == end.c)
                    return min;

                for(int d = 0; d < 6; d++){
                    int nl = cur.l + dl[d];
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if(nl >= 0 && nr >= 0 && nc >= 0 && nl < L && nr < R && nc < C && building[nl][nr][nc] != '#'){
                        if(!bool[nl][nr][nc]){
                            bool[nl][nr][nc] = true;
                            q.add(new Location(nl, nr, nc));
                        }
                    }
                }
            }

            min++;
        }

        return -1;
    }
}

class Location{
    int l, r, c;
    public Location(int l, int r, int c){
        this.l = l;
        this.r = r;
        this.c = c;
    }
}