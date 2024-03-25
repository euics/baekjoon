import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return binarySearch(distance, rocks, n);
    }

    public int binarySearch(int distance, int[] rocks, int n) {
        int answer = Integer.MIN_VALUE;

        int left = 0;
        int right = distance;

        while (left <= right) {
            int mid = (left + right) / 2;
            int removedRock = 0;
            int prev = 0;

            for (int rock : rocks) {
                if (rock - prev < mid) removedRock++;
                else prev = rock;
            }

            if (distance - prev < mid) removedRock++;

            if (removedRock <= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else right = mid - 1;
        }

        return answer;
    }
}