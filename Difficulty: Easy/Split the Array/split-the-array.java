//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public static int countgroup(int arr[]) {
        // Complete the function
        int mod = 1000000007;
        int n = arr.length;
        int totalXOR = 0;
        
        for(int num:arr)
            totalXOR ^= num;
            
        if(totalXOR == 0)
            return (modularExponentiation(2,n-1,mod) - 1 + mod) % mod;
            
        return 0;
    }
    private static int modularExponentiation(int base, int exp, int mod){
        int result = 1;
        base = base % mod;
        
        while(exp>0){
            if(exp%2==1)
                result = (result * base)%mod;
                
            base = (base * base) % mod;
            exp = exp / 2;
        }
        return result;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int ans = obj.countgroup(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends