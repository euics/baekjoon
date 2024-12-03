import java.util.*;
import java.io.*;

class Solution {
	static int answer = 0;

	public int solution(String skill, String[] skill_trees) {
		for (String skillTree : skill_trees) {
			Queue<Character> q = new LinkedList<>();
			
			for (char ch : skill.toCharArray()) {
				q.add(ch);
			}

			boolean bool = true;
			for (char ch : skillTree.toCharArray()) {
				if (!q.isEmpty() && q.contains(ch)) {
					if (q.peek() == ch) {
						q.poll();
					} else {
						bool = false;
					}
				}

				if (!bool) {
					break;
				}
			}

			if (bool) {
				answer++;
			}
		}

		return answer;
	}
}