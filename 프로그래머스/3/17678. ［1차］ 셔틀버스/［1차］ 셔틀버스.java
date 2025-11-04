import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] times = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) times[i] = convert(timetable[i]);
        Arrays.sort(times);

        for (int i = 0, shuttle = convert("09:00"), idx = 0, last = -1; i < n; i++, shuttle += t) {
            int cnt = 0;

            while (idx < times.length && times[idx] <= shuttle && cnt < m) {
                last = times[idx];
                cnt++;
                idx++;
            }

            if (i == n - 1) {
                if (cnt < m) return time(shuttle);
                else return time(last - 1);
            }
        }

        return "";
    }

    public int convert(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }

    public String time(int time) {
        int hour = time / 60;
        int minute = time % 60;

        return String.format("%02d:%02d", hour, minute);
    }
}