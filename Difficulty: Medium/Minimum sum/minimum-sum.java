//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String minSum(int[] arr) {
        // code here
        Arrays.sort(arr);
        
        Queue<Integer> num1 = new LinkedList<>();
        Queue<Integer> num2 = new LinkedList<>();
        
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                if(!(arr[i] == 0 && num1.isEmpty()))
                    num1.add(arr[i]);
            }
            else{
                if(!(arr[i] == 0 && num2.isEmpty()))
                    num2.add(arr[i]);
            }
        }
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        
        while(!num1.isEmpty())
            str1.append(num1.poll());
        while(!num2.isEmpty())
            str2.append(num2.poll());
            
        if(str1.length() == 0)
            str1.append("0");
        if(str2.length() == 0)
            str2.append("0");
            
        return findSum(str1.toString(), str2.toString());
    }
    private String findSum(String str1, String str2){
        int n1=str1.length(), n2=str2.length();
        int carry=0;
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<Math.max(n1,n2) || carry>0; i++){
            int digit1 = i<n1?str1.charAt(n1-i-1)-'0':0;
            int digit2 = i<n2?str2.charAt(n2-i-1)-'0':0;
            int sum = digit1+digit2+carry;
            result.append(sum%10);
            carry=sum/10;
        }
        return result.reverse().toString();
    }
}
