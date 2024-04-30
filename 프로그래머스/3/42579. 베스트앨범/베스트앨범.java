import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        
        Map<String, Integer> genrePlaysInfo = new HashMap<>();
        Map<String, PriorityQueue<Genre>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            genrePlaysInfo.put(genres[i], genrePlaysInfo.getOrDefault(genres[i], 0) + plays[i]);
            if(!map.containsKey(genres[i])) map.put(genres[i], new PriorityQueue<>());
            
            map.get(genres[i]).add(new Genre(i, plays[i]));
        }
        
        List<String> keySet = new ArrayList<>(genrePlaysInfo.keySet());
        Collections.sort(keySet, (a, b) -> genrePlaysInfo.get(b).compareTo(genrePlaysInfo.get(a)));
        
        List<Integer> answer = new ArrayList<>();
        for(String key : keySet) {
            int cnt = 0;
            PriorityQueue<Genre> pq = map.get(key);
            
            while(!pq.isEmpty() && cnt < 2) {
                Genre cur = pq.poll();
                answer.add(cur.id);
                cnt++;
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

class Genre implements Comparable<Genre>{
    int id, play;
    
    public Genre(int id, int play) {
        this.id = id;
        this.play = play;
    }
    
    @Override
    public int compareTo(Genre o) {
        if(this.play == o.play) return this.id - o.id;
        else return o.play - this.play;
    }
}