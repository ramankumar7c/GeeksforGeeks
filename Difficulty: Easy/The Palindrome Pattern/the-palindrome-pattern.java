//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);

        Solution ob = new Solution();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        // Code here
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            if(isPalindrome(arr[i]))
                return i + " R";
        }
        for(int j=0;j<n;j++)
            if(isPalindrome(getColumn(arr,j)))
                return j + " C";
                
        return "-1";
    }
    private static boolean isPalindrome(int[] array){
        int start = 0;
        int end = array.length-1;
        while(start<end){
            if(array[start] != array[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
    private static int[] getColumn(int[][] arr, int columnIndex){
        int n = arr.length;
        int[] column = new int[n];
        for(int i=0;i<n;i++)
            column[i] = arr[i][columnIndex];
        return column;
    }
}
