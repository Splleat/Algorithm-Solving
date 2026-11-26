import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> clothMap = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            clothMap.put(clothes[i][1], clothMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for (String s : clothMap.keySet()) {
            answer *= (clothMap.get(s) + 1);
        }
        
        answer--;
        
        return answer;
    }
}