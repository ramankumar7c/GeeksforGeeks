//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] nums) {
        // code here
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            prefix = (prefix == 0) ? nums[i] : prefix * nums[i];
            maxProduct = Math.max(maxProduct, prefix);
        }
        prefix = 1;
        
        for(int i=n-1;i>=0;i--){
            suffix = (suffix == 0) ? nums[i] : suffix * nums[i];
            maxProduct = Math.max(maxProduct,suffix);
        }
        return maxProduct;
    }
}