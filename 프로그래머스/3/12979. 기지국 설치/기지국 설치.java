class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1; // 시작 아파트 번호

        for (int station : stations) {
            int left = station - w; // 기지국의 왼쪽 경계
            if (start < left) {
                answer += countAdditionalStations(start, left - 1, w);
            }
            start = station + w + 1; // 다음 시작 아파트 번호 갱신
        }

        // 마지막 기지국 이후의 구간 처리
        if (start <= n) {
            answer += countAdditionalStations(start, n, w);
        }

        return answer;
    }

    private int countAdditionalStations(int start, int end, int w) {
        int length = end - start + 1; // 기지국이 덮지 못하는 구간의 길이
        int range = 2 * w + 1; // 하나의 기지국이 덮을 수 있는 최대 범위
        return (length + range - 1) / range; // 추가로 필요한 기지국의 수
    }
}
