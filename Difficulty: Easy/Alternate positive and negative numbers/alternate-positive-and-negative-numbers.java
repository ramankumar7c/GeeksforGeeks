//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        int n = arr.size();
        int wrongIndex = -1;
        
        for(int i=0;i<n;i++){
            if(wrongIndex>=0){
                if((arr.get(wrongIndex)>=0 && arr.get(i)<0) || (arr.get(wrongIndex)<0 && arr.get(i)>=0)){
                    rightRotate(arr,wrongIndex,i);
                    
                    if(i-wrongIndex>2)
                        wrongIndex += 2;
                    else
                        wrongIndex = -1;
                }
            }
            if(wrongIndex==-1)
                if((i%2==0 && arr.get(i) < 0) || (i%2==1 && arr.get(i)>=0))
                    wrongIndex=i;
        }
    }
    private void rightRotate(ArrayList<Integer>arr, int start,int end){
        int temp=arr.get(end);
        for(int i=end;i>start;i--)
            arr.set(i,arr.get(i-1));
        arr.set(start,temp);
    }
}