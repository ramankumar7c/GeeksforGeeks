//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class DSU {
        int[] parent, rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public boolean isConnected(DSU dsu, int[] indegree, int[] outdegree) {
        int start = -1;

        for (int i = 0; i < 26; i++) {
            if (indegree[i] > 0 || outdegree[i] > 0) {
                start = i;
                break;
            }
        }

        if (start == -1) return true;

        int root = dsu.find(start);

        for (int i = 0; i < 26; i++) {
            if ((indegree[i] > 0 || outdegree[i] > 0) && dsu.find(i) != root)
                return false;
        }

        return true;
    }

    public int isCircle(String[] arr) {
        int N = arr.length;
        DSU dsu = new DSU(26);
        int[] indegree = new int[26], outdegree = new int[26];

        for (int i = 0; i < N; i++) {
            int u = arr[i].charAt(0) - 'a';
            int v = arr[i].charAt(arr[i].length() - 1) - 'a';
            dsu.union(u, v);
            outdegree[u]++;
            indegree[v]++;
        }

        for (int i = 0; i < 26; i++) {
            if (indegree[i] != outdegree[i])
                return 0;
        }

        if (!isConnected(dsu, indegree, outdegree))
            return 0;

        return 1;
    }
}
