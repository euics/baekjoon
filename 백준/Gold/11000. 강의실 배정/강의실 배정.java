import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 시작 시간 기준으로 정렬
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // 강의실 종료 시간을 저장할 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] pair : list){
            // 현재 수업을 넣을 수 있는 강의실이 있는지 체크
            if(!pq.isEmpty() && pq.peek() <= pair[0])
                pq.poll();
            pq.add(pair[1]);
        }

        System.out.println(pq.size());
    }
}