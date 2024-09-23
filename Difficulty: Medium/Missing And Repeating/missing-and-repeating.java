//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        long sumN = (long) n*(n+1)/2;
        long sumNSquares = (long) n * (n+1)*(2*n+1)/6;
        
        long sumArr=0;
        long sumArrSquares=0;
        
        for(int i=0;i<n;i++){
            sumArr+=arr[i];
            sumArrSquares+=(long)arr[i]*arr[i];
        }
        long sumDiff=sumN-sumArr;
        long squareSumDiff=sumNSquares-sumArrSquares;
        
        long sumMissingRepeating=squareSumDiff/sumDiff;
        
        int missing = (int) (sumDiff+sumMissingRepeating)/2;
        int repeating = (int) sumMissingRepeating-missing;
        
        return new int[]{repeating,missing};
    }
}