import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        Map<String, Integer> genresSum = new HashMap<>();
        Map<String, PriorityQueue<SongInfo>> genresInfo = new HashMap<>();

        for(int i = 0; i < n; i++){
            genresSum.put(genres[i], genresSum.getOrDefault(genres[i], 0) + plays[i]);
            genresInfo.putIfAbsent(genres[i], new PriorityQueue<SongInfo>());
            genresInfo.get(genres[i]).add(new SongInfo(i, plays[i]));
        }

        List<String> genresRanking = new LinkedList<>(genresSum.keySet());
        Collections.sort(genresRanking, (a, b) -> genresSum.get(b).compareTo(genresSum.get(a)));

        List<Integer> answer = new ArrayList<>();
        for(String genre : genresRanking){
            int cnt = 0;
            while(!genresInfo.get(genre).isEmpty() && cnt < 2){
                answer.add(genresInfo.get(genre).poll().id);
                cnt++;
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}

class SongInfo implements Comparable<SongInfo>{
    int id, play;
    public SongInfo(int id, int play){
        this.id = id;
        this.play = play;
    }

    @Override
    public int compareTo(SongInfo o){
        if(this.play == o.play)
            return this.id - o.id;
        else
            return o.play - this.play;
    }
}