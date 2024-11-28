//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int myAtoi(String s) {
        // Your code here
        int idx = 0, n = s.length();
        int sign = 1;
        long res = 0;

        while (idx < n && Character.isWhitespace(s.charAt(idx)))
            idx++;
        
        if (idx < n && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            sign = (s.charAt(idx) == '-') ? -1 : 1;
            idx++;
        }

        while (idx < n && Character.isDigit(s.charAt(idx))) {
            res = res * 10 + (s.charAt(idx) - '0');
            idx++;

            if (res > Integer.MAX_VALUE)
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) (res * sign);
    }
}