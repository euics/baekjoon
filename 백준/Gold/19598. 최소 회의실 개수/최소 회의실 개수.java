import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static class Meeting implements Comparable<Meeting> {
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.start == o.start) return this.end - o.end;
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings);

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.offer(meetings[0].end);

        for (int i = 1; i < N; i++) {
            if (meetings[i].start >= rooms.peek()) {
                rooms.poll();
            }
            rooms.offer(meetings[i].end);
        }

        System.out.println(rooms.size());
    }
}
