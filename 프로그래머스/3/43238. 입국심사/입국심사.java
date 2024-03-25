class Solution {
    public long solution(int n, int[] times) {
        return BinarySearch(n, times);
    }

    public long getMax(int[] times) {
        long max = Integer.MIN_VALUE;

        for (int time : times) max = Math.max(max, time);

        return max;
    }

    public long BinarySearch(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        long left = 1;
        long right = (long) n * getMax(times);

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int time : times) sum += mid / time;

            if (sum >= n) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else left = mid + 1;
        }

        return answer;
    }
}