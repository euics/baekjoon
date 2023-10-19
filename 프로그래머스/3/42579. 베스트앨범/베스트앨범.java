import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreSum = new HashMap<>();
        HashMap<String, PriorityQueue<Song>> genreSong = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            genreSum.put(genres[i], genreSum.getOrDefault(genres[i], 0) + plays[i]);
            
            if(!genreSong.containsKey(genres[i])){
                genreSong.put(genres[i], new PriorityQueue<Song>());
            }
            
            genreSong.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        List<String> genreRanking = new ArrayList<>(genreSum.keySet());
        Collections.sort(genreRanking, (a, b) -> genreSum.get(b).compareTo(genreSum.get(a)));
        
        List<Integer> result = new ArrayList<>();
        for(String genre : genreRanking){
            int cnt = 0;
            while(!genreSong.get(genre).isEmpty() && cnt < 2){
                result.add(genreSong.get(genre).poll().id);
                cnt++;
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}

class Song implements Comparable<Song>{
    int id, play;
    
    public Song(int id, int play){
        this.id = id;
        this.play = play;
    }
    
    @Override
    public int compareTo(Song o){
        if(this.play == o.play){
            return this.id - o.id;
        } else{
            return o.play - this.play;
        }
    }
}