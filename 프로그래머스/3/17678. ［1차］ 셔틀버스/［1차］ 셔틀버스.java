import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] times = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) times[i] = time(timetable[i]);
        Arrays.sort(times);

        for (int i = 0, bus = time("09:00"), lastBoardTime = -1, idx = 0; i < n; i++, bus += t) {
            int cnt = 0;

            while (idx < times.length && times[idx] <= bus && cnt < m) {
                lastBoardTime = times[idx];
                idx++;
                cnt++;
            }

            if (i == n - 1) {
                if (cnt < m) return time(bus);
                else return time(lastBoardTime - 1);
            }
        }

        return "";
    }

    public int time(String s) {
        String[] a = s.split(":");
        return Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
    }

    public String time(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }
}