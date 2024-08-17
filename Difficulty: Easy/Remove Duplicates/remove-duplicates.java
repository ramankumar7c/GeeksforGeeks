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
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    String removeDups(String str) {
        // code here
        String ans = "";
        for(int i=0;i<str.length();i++){
            int j=0;
            for(j=0;j<i;j++)
                if(str.charAt(i) == str.charAt(j))
                    break;
                    
            if(i==j)
                ans+=str.charAt(i);
        }
        return ans;
    }
}