import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(String[] book : book_time) pq.add(changeTimeFormat(book));

        Map<Integer, Integer> roomsInfo = new HashMap<>();
        int roomNumber = 1;
        while(!pq.isEmpty()) {
            int[] curTime = pq.poll();

            if(roomsInfo.size() == 0) roomsInfo.put(roomNumber++, curTime[1]);
            else changeRooms(roomsInfo, curTime, roomNumber++);
        }

        return roomsInfo.size();
    }

    public int[] changeTimeFormat(String[] book_time) {
        int[] time = new int[2];

        for(int i = 0; i < 2; i++) {
            String hour = book_time[i].split(":")[0];
            String minute = book_time[i].split(":")[1];
            if(i == 1) time[i] = Integer.parseInt(hour) * 60 + (Integer.parseInt(minute) + 10);
            else time[i] = Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
        }

        return time;
    }

    public void changeRooms(Map<Integer, Integer> roomsInfo, int[] curTime, int roomNumber) {
        boolean bool = false;

        for(int room : roomsInfo.keySet()) {
            if(roomsInfo.get(room) <= curTime[0]) {
                roomsInfo.put(room, curTime[1]);
                bool = true;
                break;
            }
        }

        if(!bool) roomsInfo.put(roomNumber, curTime[1]);
    }
}