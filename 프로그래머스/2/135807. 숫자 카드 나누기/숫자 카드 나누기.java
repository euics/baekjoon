import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        if(!divide(arrayA, findGCD(arrayB))) answer = Math.max(answer, findGCD(arrayB));
        if(!divide(arrayB, findGCD(arrayA))) answer = Math.max(answer, findGCD(arrayA));

        return answer;
    }

    public int findGCD(int[] array) {
        Arrays.sort(array);
        int result = array[0];

        for(int i = 1; i < array.length; i++) {
            result = GCD(result, array[i]);
            if(result == 1) break;
        }

        return result;
    }

    public int GCD(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }
    
    public boolean divide(int[] array, int num) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] % num == 0) return true;
        }
        
        return false;
    }
}