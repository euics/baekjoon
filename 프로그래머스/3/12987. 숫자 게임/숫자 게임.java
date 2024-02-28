import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int score = 0, aIdx = 0, bIdx = 0, n = A.length;
        while(bIdx < n) {
            if(A[aIdx] < B[bIdx]) {
                score++;
                aIdx++;
                bIdx++;
            } else if(A[aIdx] > B[bIdx]) {
                bIdx++;
            } else {
                bIdx++;
            }
        }

        return score;
    }
}