//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        List<List<Integer>>adj = new ArrayList<>(k);
        for(int i=0;i<k;i++)
            adj.add(new ArrayList<>());
            
        int[] inDegree = new int[k];
        
        for(int i=1;i<n;i++)
            buildGraph(adj, dict[i-1], dict[i], inDegree);
            
        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<k;i++)
            if(inDegree[i]==0)
                queue.offer(i);
                
        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()){
            int node=queue.poll();
            order.append((char)(node+'a'));
            
            for(int neighbour:adj.get(node)){
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0)
                    queue.offer(neighbour);
            }
        }
        if(order.length() != k)
            return "";
            
        return order.toString();
    }
    private void buildGraph(List<List<Integer>>adj, String str1, String str2, int[] inDegree){
        int len = Math.min(str1.length(), str2.length());
        for(int i=0;i<len;i++)
            if(str1.charAt(i) != str2.charAt(i)){
                int u = str1.charAt(i) - 'a';
                int v = str2.charAt(i) - 'a';
                adj.get(u).add(v);
                inDegree[v]++;
                break;
            }
    }
}