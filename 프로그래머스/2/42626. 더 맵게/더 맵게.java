import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(scoville.length);
        int answer = 0;
        
        for (int i : scoville) {
            heap.offer(i);
        }
        
        while (true) {
            int a = heap.poll();

            if (a >= K) break;
            
            if (heap.isEmpty()) {
                return -1;
            }

            int b = heap.poll();

            int mixed = a + b * 2;

            heap.offer(mixed);

            answer++;
        }
        
        
        return answer;
    }
}