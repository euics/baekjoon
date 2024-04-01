import java.util.*;

class Solution {
    static Map<String, Integer> totalPlayTime;
    static Map<String, PriorityQueue<SongInfo>> playTime;
    static List<Integer> answer = new ArrayList<>();

    public int[] solution(String[] genres, int[] plays) {
        initMap(genres, plays);
        findId(sortGenres());

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public void initMap(String[] genres, int[] plays) {
        int n = genres.length;
        totalPlayTime = new HashMap<>();
        playTime = new HashMap<>();

        for (int i = 0; i < n; i++) {
            totalPlayTime.put(genres[i], totalPlayTime.getOrDefault(genres[i], 0) + plays[i]);
            playTime.putIfAbsent(genres[i], new PriorityQueue<SongInfo>());
            playTime.get(genres[i]).add(new SongInfo(i, plays[i]));
        }
    }

    public List<String> sortGenres() {
        List<String> sortedGenres = new ArrayList<>(totalPlayTime.keySet());
        Collections.sort(sortedGenres, (a, b) -> totalPlayTime.get(b) - totalPlayTime.get(a));

        return sortedGenres;
    }

    public void findId(List<String> sortedGenres) {
        for (String genre : sortedGenres) {
            PriorityQueue<SongInfo> pq = playTime.get(genre);

            int idx = 0;
            while (!pq.isEmpty() && idx < 2) {
                answer.add(pq.poll().id);
                idx++;
            }
        }
    }
}

class SongInfo implements Comparable<SongInfo> {
    int id, plays;

    public SongInfo(int id, int plays) {
        this.id = id;
        this.plays = plays;
    }

    @Override
    public int compareTo(SongInfo o) {
        return o.plays - this.plays;
    }
}