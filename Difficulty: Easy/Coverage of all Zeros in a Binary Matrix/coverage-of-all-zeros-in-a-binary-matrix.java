//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.findCoverage(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public int findCoverage(int[][] matrix) {
        int sumCoverage = 0;
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    int coverage = 0;
                    
                    if(isInBounds(matrix,i,j-1) && matrix[i][j-1]==1)
                        coverage++;
                    if(isInBounds(matrix,i,j+1) && matrix[i][j+1]==1)
                        coverage++;
                    if(isInBounds(matrix,i-1,j) && matrix[i-1][j]==1)
                        coverage++;
                    if(isInBounds(matrix,i+1,j) && matrix[i+1][j]==1)
                        coverage++;
                        
                    sumCoverage += coverage;
                }
            }
        }
        return sumCoverage;
    }
    private static boolean isInBounds(int[][] matrix, int row, int col){
        return row>= 0 && row< matrix.length && col >= 0 && col < matrix[0].length;
    }
}