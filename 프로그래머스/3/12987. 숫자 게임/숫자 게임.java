import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int score = 0, aIndex = 0, bIndex = 0;
        while(bIndex < B.length) {
            if(A[aIndex] < B[bIndex]) {
                score++;
                aIndex++;
            }

            bIndex++;
        }

        return score;
    }
}