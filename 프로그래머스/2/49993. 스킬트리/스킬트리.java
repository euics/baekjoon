import java.util.*;

class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (String skillTree : skill_trees) {
			Queue<Character> skillDictionary = new LinkedList<>();
			for (char ch : skill.toCharArray())
				skillDictionary.add(ch);

			boolean bool = true;
			for (char ch : skillTree.toCharArray()) {
				if (!skillDictionary.isEmpty() && skillDictionary.contains(ch)) {
					if(skillDictionary.peek() == ch) skillDictionary.poll();
					else bool = false;
				}
				
				if(!bool) break;
			}
			
			if(bool) answer++;
		}

		return answer;
	}
}