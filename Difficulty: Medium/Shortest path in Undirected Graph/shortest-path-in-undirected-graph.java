//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
            
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int[] dist=new int[n];
        Arrays.fill(dist,-1);
        
        Queue<Integer>queue = new LinkedList<>();
        dist[src]=0;
        queue.offer(src);
        
        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int neighbour:adjList.get(node))
                if(dist[neighbour]==-1){
                    dist[neighbour]=dist[node]+1;
                    queue.offer(neighbour);
                }
        }
        return dist;
    }
}