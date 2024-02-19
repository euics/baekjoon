import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();

        // 전체 토핑을 right 해시맵에 추가
        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }

        // 롤케이크를 순회하면서 토핑을 왼쪽으로 옮김
        for (int i = 0; i < topping.length; i++) {
            int currentTopping = topping[i];
            // 왼쪽 해시맵에 현재 토핑 추가
            left.put(currentTopping, left.getOrDefault(currentTopping, 0) + 1);

            // 오른쪽 해시맵에서 현재 토핑 제거
            if (right.get(currentTopping) == 1) {
                right.remove(currentTopping);
            } else {
                right.put(currentTopping, right.get(currentTopping) - 1);
            }

            // 왼쪽과 오른쪽 해시맵의 크기가 같으면 정답 카운트 증가
            if (left.size() == right.size()) {
                answer++;
            }
        }

        return answer;
    }
}
