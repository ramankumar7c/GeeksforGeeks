//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        long maxNumber = -1;
        long currentNumber = 0;
        boolean validNumber = true;
        boolean hasDigit = false;
        
        for(char c : sentence.toCharArray()){
            if(Character.isDigit(c)){
                hasDigit = true;
                if(c>'8')
                    validNumber = false;
                    
                currentNumber = currentNumber * 10 + (c-'0');
            }
            else{
                if(hasDigit){
                    if(validNumber)
                        maxNumber = Math.max(maxNumber,currentNumber);
                    currentNumber = 0;
                    validNumber = true;
                    hasDigit = false;
                }
            }
        }
        if(hasDigit && validNumber)
            maxNumber = Math.max(maxNumber,currentNumber);
            
        return maxNumber;
    }
}