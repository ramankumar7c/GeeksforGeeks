//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        Stack<Integer>stack = new Stack<>();
        int n=mat.length;
        
        for(int i=0;i<n;i++)
            stack.push(i);
            
        while(stack.size()>1){
            int a=stack.pop();
            int b=stack.pop();
            if(mat[a][b]==1)
                stack.push(b);
            else
                stack.push(a);
        }
        int candidate = stack.pop();
        
        for(int i=0;i<n;i++){
            if(i != candidate){
                if(mat[candidate][i]==1 || mat[i][candidate]==0)
                    return -1;
            }
        }
        return candidate;
    }
}