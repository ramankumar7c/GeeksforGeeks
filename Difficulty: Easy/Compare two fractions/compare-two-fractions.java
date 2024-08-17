//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
        String[] fractions = str.split(", ");
        
        String[] fraction1 = fractions[0].split("/");
        String[] fraction2 = fractions[1].split("/");
        
        int a = Integer.parseInt(fraction1[0]);
        int b = Integer.parseInt(fraction1[1]);
        int c = Integer.parseInt(fraction2[0]);
        int d = Integer.parseInt(fraction2[1]);
        
        if(a*d>b*c)
            return fractions[0];
        else if(a*d<b*c)
            return fractions[1];
        else
            return "equal";
    }
}
