import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if(K >= N) {
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sensors = new int[N];
        for(int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        // 센서의 위치를 오름차순으로 정렬
        Arrays.sort(sensors);

        // 각 인접한 센서들 사이의 거리를 계산하여 거리 배열을 만듦
        int[] distances = new int[N - 1];
        for(int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        // 거리 배열을 내림차순으로 정렬
        Arrays.sort(distances);

        // 가장 큰 거리부터 K-1개만큼 제거
        int result = 0;
        for(int i = 0; i < N - K; i++) {
            result += distances[i];
        }

        System.out.println(result);
    }
}
