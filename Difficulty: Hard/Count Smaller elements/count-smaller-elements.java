//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    private class Pair {
        int val;
        int index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    private int[] count;
    
    private void mergeSort(Pair[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(Pair[] nums, int left, int mid, int right) {
        Pair[] temp = new Pair[right - left + 1];
        int i = left, j = mid + 1, k = 0, rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[i].val <= nums[j].val) {
                count[nums[i].index] += rightCount;
                temp[k++] = nums[i++];
            } else {
                rightCount++;
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            count[nums[i].index] += rightCount;
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }

    public int[] constructLowerArray(int[] nums) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        count = new int[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        mergeSort(pairs, 0, n - 1);
        return count;
    }
}