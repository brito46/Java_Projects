import java.util.*;
/*
This function will return the most common word when given a file(paragraph(s)) and an optional list of banned words
*/
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replace(",", " ");
        paragraph = paragraph.replace("!", "");
        paragraph = paragraph.replace("?", "");
        paragraph = paragraph.replace("'", "");
        paragraph = paragraph.replace(";", "");
        paragraph = paragraph.replace(".", "");
        String[] words = paragraph.split("\\s+"); //this account for one or multiple spaces
        
        List<String> list = new ArrayList<>();
        for(String s : banned) { //going through every string in array
            list.add(s); //adding every string to list
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < words.length; i++){
            if(list.contains(words[i])) continue; //skip banned word
            
            else if(!map.containsKey(words[i])){
                map.put(words[i], 1);
            }
            
            else{
                map.replace(words[i], map.get(words[i]),map.get(words[i]) + 1 ); 
                //value +=1 if word is repeated
            }
        }
        
        List<Integer> list2 = new ArrayList<>(); //returning a list of the values of the map
        for (int i : map.values()){
            list2.add(i);
        }
        int maxx= Collections.max(list2); //returning the highest value of map  
        String ans = getKey(map, maxx); //returning key associated with highest value of map
        return ans;
    }
    public static <K, V> K getKey(Map<K, V> map, V value) { 
      
          for (Map.Entry<K, V> entry : map.entrySet()) 
      {
              if (value.equals(entry.getValue())) return entry.getKey();
            
          }
        return null;
        }
}