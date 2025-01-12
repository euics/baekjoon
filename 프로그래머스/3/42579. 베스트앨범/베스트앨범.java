import java.util.*;

class Solution {
	static ArrayList<Integer> answer = new ArrayList<>();
	static Map<String, Integer> genreInfo = new HashMap<>();
	static Map<Integer, Integer> idxInfo = new HashMap<>();
	static Map<String, ArrayList<Integer>> genreIdx = new HashMap<>();

	public int[] solution(String[] genres, int[] plays) {
		for (int i = 0; i < genres.length; i++) {
			idxInfo.put(i, plays[i]);
			genreInfo.put(genres[i], genreInfo.getOrDefault(genres[i], 0) + plays[i]);
			genreIdx.putIfAbsent(genres[i], new ArrayList<Integer>());
			genreIdx.get(genres[i]).add(i);
		}

		System.out.println("idxInfo");
		for (int a : idxInfo.keySet()) {
			System.out.printf("%d %d\n", a, idxInfo.get(a));
		}
		System.out.println();

		System.out.println("genreInfo");
		for (String a : genreInfo.keySet()) {
			System.out.printf("%s %d\n", a, genreInfo.get(a));
		}
		System.out.println();

		System.out.println("genreIdx");
		for (String a : genreIdx.keySet()) {
			System.out.printf("%s ", a);
			for (int b : genreIdx.get(a)) {
				System.out.printf("%d ", b);
			}
			System.out.println();
		}
		System.out.println();

		List<String> genreInfoKeySet = new ArrayList<>(genreInfo.keySet());
		genreInfoKeySet.sort((o1, o2) -> genreInfo.get(o2).compareTo(genreInfo.get(o1)));

		for (String keySet : genreInfoKeySet) {
			genreIdx.get(keySet).sort((o1, o2) -> idxInfo.get(o2).compareTo(idxInfo.get(o1)));

			System.out.printf("%s ", keySet);
			if (genreIdx.get(keySet).size() <= 2) {
				answer.addAll(genreIdx.get(keySet));
			} else {
				int cnt = 0;

				for (int idx : genreIdx.get(keySet)) {
					answer.add(idx);
					cnt++;

					if(cnt == 2) {
						break;
					}
				}
			}

			System.out.println();
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
}