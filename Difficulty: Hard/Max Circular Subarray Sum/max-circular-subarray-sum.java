//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {
        // Your code here
        int totalSum = 0;
        boolean allNegative = true;
        
        for(int num : arr){
            totalSum += num;
            if(num > 0)
                allNegative = false;
        }
        int maxSum = kadaneMax(arr);
        int minSum = kadaneMin(arr);
        
        if(allNegative)
            return maxSum;
            
        return Math.max(maxSum, totalSum - minSum);
    }
    private int kadaneMax(int[] arr){
        int maxSum = Integer.MIN_VALUE, currMax = 0;
        for(int num : arr){
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);
        }
        return maxSum;
    }
    private int kadaneMin(int[] arr){
        int minSum = Integer.MAX_VALUE, currMin = 0;
        for(int num : arr){
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }
        return minSum;
    }
}
