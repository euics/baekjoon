import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        // 완호의 점수는 미리 저장해둡니다.
        int targetA = scores[0][0];
        int targetB = scores[0][1];
        int targetSum = targetA + targetB;

        // 정렬: 근무 태도 점수(a) 내림차순, 동료 평가 점수(b) 오름차순
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int maxScoreB = 0; // 지금까지 나온 후보 중 가장 높은 동료 점수 (커트라인)
        int higherScoreCount = 0; // 완호보다 점수 합이 높은 사람의 수
        boolean isWanhoQualified = false; // 완호가 인센티브를 받을 자격이 있는지

        for (int[] score : scores) {
            // 1. 인센티브 제외 대상 판별 (커트라인보다 동료 점수가 낮으면 탈락)
            if (score[1] < maxScoreB) {
                // 탈락자가 완호라면 여기서 바로 -1을 반환하면 안 됩니다. (동점자 문제)
                // 따라서 일단 넘어갑니다.
            } else {
                // 2. 인센티브 대상인 경우
                maxScoreB = Math.max(maxScoreB, score[1]); // 커트라인 갱신

                // 현재 통과한 사람이 완호인지 확인
                if (score[0] == targetA && score[1] == targetB) {
                    isWanhoQualified = true;
                }

                // 완호보다 총점이 높은 사람 수 카운트
                if (score[0] + score[1] > targetSum) {
                    higherScoreCount++;
                }
            }
        }

        // 3. 모든 반복이 끝난 후, 완호의 자격 여부를 최종 판단
        if (!isWanhoQualified) {
            return -1;
        }

        // 4. 최종 석차 반환
        return higherScoreCount + 1;
    }
}