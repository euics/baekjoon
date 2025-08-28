import java.util.*;

class Solution {
    public int solution(int[] arr) {
        return LCM(arr);
    }

    public int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }

    public int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }

    public int LCM(int[] arr) {
        int result = arr[0];
        for (int i = 0; i < arr.length; i++) result = LCM(arr[i], result);

        return result;
    }
}