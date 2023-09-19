import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long atk = Long.parseLong(st.nextToken());
        long[][] dungeon = new long[n][3];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++)
                dungeon[i][j] = Long.parseLong(st.nextToken());
        }

        long left = 0, right = Long.MAX_VALUE;
        while(left <= right){
            long hp = (left + right) / 2;
            long curHp = hp;
            long curAtk = atk;
            boolean alive = true;

            for(int i = 0; i < n; i++){
                if(dungeon[i][0] == 1){
                    if(dungeon[i][2] % curAtk == 0)
                        curHp -= (dungeon[i][2] / curAtk - 1) * dungeon[i][1];
                    else
                        curHp -= (dungeon[i][2] / curAtk) * dungeon[i][1];

                    if(curHp <= 0)
                        alive = false;

                } else{
                    curAtk += dungeon[i][1];
                    if(curHp + dungeon[i][2] > hp)
                        curHp = hp;
                    else
                        curHp += dungeon[i][2];
                }
            }

            if(!alive)
                left = hp + 1;
            else
                right = hp - 1;
        }

        System.out.println(left);
    }
}