import java.util.*;
//this function can remove comments from a file(array of strings)!
class Solution {
    public List<String> removeComments(String[] source) {
        
        boolean inBlock = false; //assume no comment is there until presesnted
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList(); 
        for (String line: source) //enhaced loop to go through every string in array 
        {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) newline = new StringBuilder(); 
            //resetting the StringBuilder if no multi line comment is active
            
            while (i < line.length()) //checking to see what parts of the string I have to block
            {
                if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true; //comment is going to occur so turn on block mode
                    i++;
                } 
                else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false; //comment is stopping so turn off block mode
                    i++;
                } 
                else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break; //skip this entire string bc it'll be blocked
                } 
                else if (!inBlock) { //add characters to string if block mode is off
                    newline.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && newline.length() > 0) {
                ans.add(new String(newline));
            }
        }
        return ans;
    }
}