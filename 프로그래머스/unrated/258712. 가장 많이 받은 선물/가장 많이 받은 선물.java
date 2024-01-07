import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[][] giftInfo = new int[n][n];

        for(String gift : gifts){
            int giver = getIndex(friends, gift.split(" ")[0]);
            int receiver = getIndex(friends, gift.split(" ")[1]);

            giftInfo[giver][receiver]++;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for(int giver = 0; giver < n; giver++){
            for(int receiver = 0; receiver < n; receiver++){
                if(giver == receiver) continue;

                int totalPresent = calculatePresent(giftInfo, giver, receiver);

                map.put(friends[giver], map.getOrDefault(friends[giver], 0) + totalPresent);
            }
        }

        int max = Integer.MIN_VALUE;
        for(String key : map.keySet()) max = Math.max(max, map.get(key));

        return max;
    }

    public int getIndex(String[] friends, String str){
        for(int i = 0; i < friends.length; i++){
            if(friends[i].equals(str)) return i;
        }

        return -1;
    }

    public int calculatePresent(int[][] giftInfo, int giver, int receiver){
        int present = 0;

        if(giftInfo[giver][receiver] > giftInfo[receiver][giver]) present++;
        else if(giftInfo[giver][receiver] == giftInfo[receiver][giver]){
            int giverPresentStock = calculatePresentStock(giftInfo, giver);
            int receiverPresentStock = calculatePresentStock(giftInfo, receiver);

            if(giverPresentStock > receiverPresentStock) present++;
        }

        return present;
    }

    public int calculatePresentStock(int[][] giftInfo, int giver){
        int give = 0, receive = 0;
        for(int i = 0; i < giftInfo.length; i++){
            give += giftInfo[giver][i];
            receive += giftInfo[i][giver];
        }

        return give - receive;
    }
}