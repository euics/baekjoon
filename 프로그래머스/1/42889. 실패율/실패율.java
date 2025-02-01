import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Rate[] rates = new Rate[N];
        
        for(int stage = 1; stage <= N; stage++) {
            int onStage = 0, failStage = 0;
            
            for(int i = 0; i < stages.length; i++) {
                if(stage <= stages[i]) {
                    onStage++;
                    
                    if(stage == stages[i]) {
                        failStage++;
                    }
                }
            }
            
            double failureRate = 0;
            if (onStage != 0) {
                failureRate = (double) failStage / onStage;
            }
            
            rates[stage - 1] = new Rate(stage, failureRate);
        }
        
        Arrays.sort(rates);
        
        int[] answer = new int[N];
        for(int i = 0; i < rates.length; i++) {
            answer[i] = rates[i].idx;
        }
        
        return answer;
    }
}

class Rate implements Comparable<Rate> {
    int idx;
    double rate;
    
    public Rate(int idx, double rate) {
        this.idx = idx;
        this.rate = rate;
    }
    
    @Override
    public int compareTo(Rate o) {
        if(this.rate == o.rate) {
            return this.idx - o.idx;
        } else {
            return Double.compare(o.rate, this.rate);
        }
    }
}