import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> paths = new HashSet<>();
        int x = 0, y = 0; // 캐릭터의 현재 위치 초기화

        for (char dir : dirs.toCharArray()) {
            int nx = x, ny = y; // 다음 위치를 위한 변수

            // 명령어에 따라 다음 위치 계산
            if (dir == 'U' && y < 5) ny++;
            else if (dir == 'D' && y > -5) ny--;
            else if (dir == 'R' && x < 5) nx++;
            else if (dir == 'L' && x > -5) nx--;

            // 이동한 경로가 유효하면, 즉 위치가 변경되었으면
            if (nx != x || ny != y) {
                // 경로를 문자열로 변환하여 저장
                paths.add("" + x + y + nx + ny); // 현재 위치에서 다음 위치로의 경로
                paths.add("" + nx + ny + x + y); // 다음 위치에서 현재 위치로의 경로 (양방향 고려)
                // 위치 업데이트
                x = nx;
                y = ny;
            }
        }

        // 처음 걸어본 길의 길이는 경로 세트의 크기의 절반입니다 (각 경로가 양방향으로 저장되었기 때문)
        answer = paths.size() / 2;
        return answer;
    }
}
