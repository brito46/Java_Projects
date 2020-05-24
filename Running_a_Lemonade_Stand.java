/*
Each lemonade costs $5.Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. 
You must provide the correct change to each customer.  You don't have any change in hand at first. Customer payments will be given in array
*/

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] changes = {0,0}; //change can only be a $5 or $10
        for (int i = 0; i<bills.length; i++){            
            switch(bills[i]){
                case 5:
                    changes[0] += 1; //the cost is $5 which means you have +1  $5 change
                    break;
                case 10:
                    if(changes[0] == 0) return false; //there's no $5 available, so can't give the customer change
                    else{
                        changes[1]+=1;  //you had to give away a $5 to get a +1 $10 change
                        changes[0]-=1;  
                    }
                    break;
                case 20:
                    if(changes[1]>0 && changes[0]>0){ //this means you have atleast $15 
                        changes[0]-=1;
                        changes[1]-=1;  //only two elements because $20 will never be a change
                    }
                    else if (changes[0]>=3) changes[0]-=3; //you have atleast $15 
                    
                    else return false; //there are only two cases when you'll have $15
                    break;
                default: //for any other case just skip
                        break;
            }
        }
        return true; //if it never enters the cases where it'll make it false, then you have enough change for the customers
    }
}