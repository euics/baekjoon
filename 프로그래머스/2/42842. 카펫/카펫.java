import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        List<Integer> answer = new ArrayList<>();

        for(int y = 3; y <= brown; y++) {
            for(int x = y; x <= brown; x++) {
                if(x * y == brown + yellow && (x - 2) * (y - 2) == yellow) {
                    answer.add(x);
                    answer.add(y);
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}