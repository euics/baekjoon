import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String m, String[] musicinfos) {
        int playTime = Integer.MIN_VALUE;
        String answer = "(None)";
        m = replaceSharp(m);

        for(int i = 0; i < musicinfos.length; i++) {
            int timeLength = changeTime(musicinfos[i].split(",")[1]) - changeTime(musicinfos[i].split(",")[0]);

            StringBuilder sb = new StringBuilder();
            String basicMelody = replaceSharp(musicinfos[i].split(",")[3]);
            for(int time = 0; time < timeLength; time++) sb.append(basicMelody.charAt(time % basicMelody.length()));

            if(sb.toString().contains(m) && playTime < timeLength) {
                playTime = timeLength;
                answer = musicinfos[i].split(",")[2];
            }
        }

        return answer;
    }

    public int changeTime(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }

    public String replaceSharp(String melody) {
        return melody.replace("C#", "H").replace("D#", "I")
                .replace("F#", "J").replace("G#", "K")
                .replace("A#", "L").replace("B#", "M");
    }
}