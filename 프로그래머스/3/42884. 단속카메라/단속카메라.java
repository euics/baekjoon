import java.util.*;

class Solution {
	static int answer = 0;
	static int camera = Integer.MIN_VALUE;

	public int solution(int[][] routes) {
		Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

		for (int[] route : routes) {
			if (route[0] > camera) {
				camera = route[1];
				answer++;
			}
		}

		return answer;
	}
}

/*
 [[-20,-15], [-14,-5], [-18,-13], [-5,-3]]
  -20 	-15
  	-18		  -13
  			-14		-5
  					-5		-3
*/