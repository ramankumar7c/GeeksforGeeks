//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            long p[] = new long[2];
            long q[] = new long[2];
            long r[] = new long[2];
            p[0] = Long.parseLong(S[0]);
            p[1] = Long.parseLong(S[1]);
            q[0] = Long.parseLong(S[2]);
            q[1] = Long.parseLong(S[3]);
            r[0] = Long.parseLong(S[4]);
            r[1] = Long.parseLong(S[5]);
            Solution ob = new Solution();
            long ans = ob.InternalCount(p, q, r);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    long InternalCount(long p[], long q[], long r[]) {
        // code here
        long area = area(p,q,r);
        long B1 = boundaryPoints(p[0],p[1],q[0],q[1]);
        long B2 = boundaryPoints(q[0],q[1],r[0],r[1]);
        long B3 = boundaryPoints(r[0],r[1],p[0],p[1]);
        
        long B = B1+B2+B3-3;
        
        long I = area-B/2+1;
        
        return I;
    }
    long area(long p[],long q[],long r[]){
        return Math.abs(p[0]*(q[1]-r[1])+q[0]*(r[1]-p[1])+r[0]*(p[1]-q[1]))/2;
    }
    long boundaryPoints(long x1,long y1,long x2,long y2){
        return gcd(Math.abs(x2-x1),Math.abs(y2-y1))+1;
    }long gcd(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
};