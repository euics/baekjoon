import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresSum = new HashMap<>();
        Map<String, PriorityQueue<SongInfo>> genreInfo = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genresSum.put(genres[i], genresSum.getOrDefault(genres[i], 0) + plays[i]);

            genreInfo.putIfAbsent(genres[i], new PriorityQueue<SongInfo>());
            genreInfo.get(genres[i]).add(new SongInfo(i, plays[i]));
        }

        List<String> genresSumList = new ArrayList<>(genresSum.keySet());
        Collections.sort(genresSumList, (a, b) -> genresSum.get(b).compareTo(genresSum.get(a)));
        List<Integer> answer = new ArrayList<>();
        
        for (String list : genresSumList) {
            int cnt = 0;
            PriorityQueue<SongInfo> pq = genreInfo.get(list);
            while (!pq.isEmpty() && cnt < 2) {
                answer.add(pq.poll().id);
                cnt++;
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

class SongInfo implements Comparable<SongInfo> {
    int id, play;

    public SongInfo(int id, int play) {
        this.id = id;
        this.play = play;
    }

    @Override
    public int compareTo(SongInfo o) {
        if (this.play == o.play) return this.id - o.id;
        else return o.play - this.play;
    }
}