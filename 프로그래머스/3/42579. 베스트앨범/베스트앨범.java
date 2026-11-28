import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {       
        // 장르, 재생 횟수 총합
        Map<String, Integer> genreMap = new HashMap<>();
        
        // 재생 횟수 총합, 노래 목록
        Map<Integer, List<Song>> songMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }    
        
        for (int i = 0; i < genres.length; i++) {
            int key = genreMap.get(genres[i]);
            
            songMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }
        
        songMap.values().forEach(Collections::sort);
        
        List<Integer> results = new ArrayList<>();
        
        genreMap.values().stream()
            .sorted(Collections.reverseOrder())
            .forEach(play -> {
            List<Song> songList = songMap.get(play);
            
            int count = Math.min(songList.size(), 2);
            
            for (int i = 0; i < count; i++) {
                results.add(songList.get(i).number);
            }
        });
    
        return results.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    record Song(int number, int play) implements Comparable<Song> {
        
        @Override
        public int compareTo(Song other) {
            if (play == other.play) {
                return Integer.compare(number, other.number);
            }
            
            return Integer.compare(other.play, play);
        }
    }
}