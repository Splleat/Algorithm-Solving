import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, List<String>> clothMap = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            clothMap.computeIfAbsent(clothes[i][1], k -> new ArrayList<>()).add(clothes[i][0]);
        }
        
        for (String s : clothMap.keySet()) {
            answer *= (clothMap.get(s).size() + 1);
        }
    
        
//         for (int i = 0; i < clothMap.size(); i++) {
//             answer *= (clothMap.get(clothes[i][1]).size() + 1);
//         }
        
        answer--;
        
        return answer;
    }
}