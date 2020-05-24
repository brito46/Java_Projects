/*
Given a 2D board and a word, determines whether The word can be constructed from the letters of any cell from the board. 
The same cell can only be used once.
*/
class Solution {
    public boolean exist(char[][] board, String word) {
    
    int row = board.length; //the number of rows 
    int col = board[0].length; //the length of any row will be the number of columns
    int z = 0;
    Map<Integer, Character> hm = new HashMap(); //creating a hashmap, where I'm storing the letters of the given board
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) { //putting every column into map for current row 
        hm.put(z,board[i][j] );
        z++;
      }
    }
    char[] words = word.toCharArray(); 
    for (int i = 0; i < words.length; i++) {
      char x = words[i];
      if (!hm.containsValue(x)) return false;  //if the board doesn't have the letter, word cannot be found
        int found = getKey(hm, x);   //to find the letter used
        hm.remove(found, x);   //cell can only be used once
       
    }
    return true;
  }
      //This API is used to return a function when you feed it the hashmap and the value mapped to it
    	public static <K, V> K getKey(Map<K, V> map, V value) { 
      
		  for (Map.Entry<K, V> entry : map.entrySet()) 
      {
			  if (value.equals(entry.getValue())) return entry.getKey();
			
		  }
        return null;
        }
}