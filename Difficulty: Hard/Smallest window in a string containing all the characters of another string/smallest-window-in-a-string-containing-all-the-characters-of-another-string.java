//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        if (p.length() > s.length()) {
            return "-1";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = 0;
        int left = 0;

        Map<Character, Integer> windowMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if (map.containsKey(ch) && windowMap.get(ch) <= map.get(ch)) {
                count++;
            }

            while (count == p.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (map.containsKey(leftChar) && windowMap.get(leftChar) < map.get(leftChar)) {
                    count--;
                }
                left++;
            }
        }

        if (startIndex == -1)
            return "-1";

        return s.substring(startIndex, startIndex + minLength);
    }
}