import java.io.*;
import java.util.*;

public class Main {
    static int n, maxBlock = Integer.MIN_VALUE;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
        System.out.println(maxBlock);
    }

    public static void DFS(int L){
        if(L == 5){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++)
                    maxBlock = Math.max(maxBlock, arr[i][j]);
            }

            return;
        }

        int[][] tmpArr = new int[n][n];
        for(int i = 0; i < n; i++)
            tmpArr[i] = arr[i].clone();

        for(int d = 0; d < 4; d++){
            move(d);
            DFS(L + 1);

            for(int i = 0; i < n; i++)
                arr[i] = tmpArr[i].clone();
        }
    }

    public static void move(int d){
        boolean merged = false;

        if(d == 0){ // 오른쪽
            for(int i = 0; i < n; i++){
                Deque<Integer> dq = new LinkedList<>();
                for(int j = n - 1; j >= 0; j--){
                    if(arr[i][j] != 0){
                        if(!dq.isEmpty() && dq.peekLast() == arr[i][j] && !merged) {
                            dq.addLast(dq.pollLast() * 2);
                            merged = true;
                        } else {
                            dq.addLast(arr[i][j]);
                            merged = false;
                        }

                        arr[i][j] = 0;
                    }
                }

                int idx = n - 1;
                while(!dq.isEmpty()) {
                    arr[i][idx--] = dq.pollFirst();
                    merged = false;  // reset merged flag for each cell
                }
            }
        } else if(d == 1){ // 아래
            for(int j = 0; j < n; j++){
                Deque<Integer> dq = new LinkedList<>();
                merged = false;
                for(int i = n - 1; i >= 0; i--){
                    if(arr[i][j] != 0){
                        if(!dq.isEmpty() && dq.peekLast() == arr[i][j] && !merged) {
                            dq.addLast(dq.pollLast() * 2);
                            merged = true;
                        } else {
                            dq.addLast(arr[i][j]);
                            merged = false;
                        }

                        arr[i][j] = 0;
                    }
                }

                int idx = n - 1;
                while(!dq.isEmpty()) {
                    arr[idx--][j] = dq.pollFirst();
                    merged = false;
                }
            }
        } else if(d == 2){ // 왼쪽
            for(int i = 0; i < n; i++){
                Deque<Integer> dq = new LinkedList<>();
                merged = false;
                for(int j = 0; j < n; j++){
                    if(arr[i][j] != 0){
                        if(!dq.isEmpty() && dq.peekLast() == arr[i][j] && !merged) {
                            dq.addLast(dq.pollLast() * 2);
                            merged = true;
                        } else {
                            dq.addLast(arr[i][j]);
                            merged = false;
                        }

                        arr[i][j] = 0;
                    }
                }

                int idx = 0;
                while(!dq.isEmpty()) {
                    arr[i][idx++] = dq.pollFirst();
                    merged = false;
                }
            }
        } else{ // 위쪽
            for(int j = 0; j < n; j++){
                Deque<Integer> dq = new LinkedList<>();
                merged = false;
                for(int i = 0; i < n; i++){
                    if(arr[i][j] != 0){
                        if(!dq.isEmpty() && dq.peekLast() == arr[i][j] && !merged) {
                            dq.addLast(dq.pollLast() * 2);
                            merged = true;
                        } else {
                            dq.addLast(arr[i][j]);
                            merged = false;
                        }

                        arr[i][j] = 0;
                    }
                }

                int idx = 0;
                while(!dq.isEmpty()) {
                    arr[idx++][j] = dq.pollFirst();
                    merged = false;
                }
            }
        }
    }
}
