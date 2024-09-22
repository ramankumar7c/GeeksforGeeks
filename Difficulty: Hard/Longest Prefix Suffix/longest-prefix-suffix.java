//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        // code here
        int n = str.length();
        if(n==0)
            return 0;
            
        int[] lpsArr = new int[n];
        int len=0;
        int i=1;
        
        while(i<n){
            if(str.charAt(i)==str.charAt(len)){
                len++;
                lpsArr[i]=len;
                i++;
            }
            else{
                if(len!=0)
                    len=lpsArr[len-1];
                else{
                    lpsArr[i]=0;
                    i++;
                }
            }
        }
        return lpsArr[n-1];
    }
}