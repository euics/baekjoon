import java.util.*;

class Solution {
	static Map<String, Integer> dictionary;

	public int[] solution(String msg) {
		makeDictionary();

		int key = 27, pointer = 0;
		char[] message = msg.toCharArray();
		List<Integer> answer = new ArrayList<>();
		while (pointer < message.length) {
			StringBuilder sb = new StringBuilder();
			sb.append(message[pointer]);

			while (pointer + 1 < message.length && dictionary.containsKey(sb.toString() + message[pointer + 1])) {
				sb.append(message[pointer + 1]);
				pointer++;
			}

			answer.add(dictionary.get(sb.toString()));

			if (pointer + 1 < message.length) {
				sb.append(message[pointer + 1]);
			}
			pointer++;

			dictionary.put(sb.toString(), key++);
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	public void makeDictionary() {
		dictionary = new HashMap<>();

		int key = 1;
		char value = 'A';

		for (int i = key; i <= 26; i++) {
			dictionary.put(String.valueOf((char)(value + i - 1)), i);
		}
	}
}