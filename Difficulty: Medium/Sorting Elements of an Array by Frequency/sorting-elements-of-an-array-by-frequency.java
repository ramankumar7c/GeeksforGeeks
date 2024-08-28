//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        Map<Integer,Integer>frequencyMap = new HashMap<>();
        
        for(int num:arr)
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        
        ArrayList<Integer>resultList = new ArrayList<>();
        for(int num:arr)
            resultList.add(num);
            
        Collections.sort(resultList,(a,b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            
            if(freqA != freqB)
                return freqB - freqA;
            else
                return a-b;
        });
        return resultList;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends