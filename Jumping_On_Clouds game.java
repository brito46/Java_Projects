/*
This game starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. 
She can jump on any cumulus cloud. She can only move one or two spaces forward. It is always possible to win the game
Determine the minimum number of jumps it will take from the starting postion to the last cloud. 
For each game, you will be given an array of clouds numbered  1 or 0. 1 are thunderheads which you have to avoid landing on.
ex1: c = {0, 1, 0, 0, 0, 1, 0} there are two available paths: 3 jumps or 4 jumps. Your code should always choose the shortest path.

ex2: c = {0, 0, 0, 0, 1, 0}; output should be 3.
*/

class Solution {
    public static int jumpingOnClouds(int[] c) {
        int n = c.length;
        int count = 0;
        int i = 0;
        
        //no more jumps can be made if c[i] is in the last element
        while(i<n-1) {  
            //in position c[n-2], you cannot move forward twice
            if (i<n-2 && c[i+2]==0) //if a two space advancement is available to jump and those two spaces ahead of i is a 0
            {
                i+=2; //you can move 2 spaces up
                count++;
                continue; //so it enters the loop again i = i
            }
            if(i != n - 1)  //if i isn't in the last element
            {
                count++; //you only could've moved one up
            }
            i++;
        }
        return count; //count recorded amount of jumps it took
    }
}