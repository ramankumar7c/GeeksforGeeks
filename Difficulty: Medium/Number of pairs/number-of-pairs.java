//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int arr[], int brr[], int M, int N) {
        // code here
        long[] freqY = new long[5];
        
        // Count occurrences of 0, 1, 2, 3, and 4 in brr[]
        for (int y : brr) {
            if (y < 5) freqY[y]++;
        }

        // Sort brr[] to handle cases where x > 4
        Arrays.sort(brr);

        long total_pairs = 0;

        for (int x : arr) {
            if (x == 0) continue;
            if (x == 1) {
                total_pairs += freqY[0];
                continue;
            }

            long count = freqY[0] + freqY[1];

            // For x = 2, subtract cases where y = 3 or 4
            if (x == 2) {
                count += N - (upperBound(brr, x));
                count -= (freqY[3] + freqY[4]);
            } 
            // For x = 3, add cases where y = 2
            else if (x == 3) {
                count += N - (upperBound(brr, x));
                count += freqY[2];
            } 
            // For x > 3, count elements in brr[] greater than x
            else {
                count += N - (upperBound(brr, x));
            }

            total_pairs += count;
        }

        return total_pairs;
    }
    private int upperBound(int[] brr, int x) {
        int left = 0, right = brr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (brr[mid] > x) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}