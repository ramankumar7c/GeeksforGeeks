//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        return findKth(arr1,0,arr2,0,k);
    }
    private long findKth(int[] arr1, int index1, int[] arr2, int index2,int k){
        if(index1 >= arr1.length)
            return arr2[index2+k-1];
        if(index2>=arr2.length)
            return arr1[index1+k-1];
        if(k==1)
            return Math.min(arr1[index1],arr2[index2]);
            
        int mid1=Math.min(index1+k/2-1,arr1.length-1);
        int mid2=Math.min(index2+k/2-1,arr2.length-1);
        
        if(arr1[mid1]<=arr2[mid2])
            return findKth(arr1,mid1+1,arr2,index2,k-(mid1-index1+1));
        else
            return findKth(arr1,index1,arr2,mid2+1,k-(mid2-index2+1));
    }
}