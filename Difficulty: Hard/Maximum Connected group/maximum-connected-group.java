//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




class Solution {
    private int n;
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public int MaxConnection(int grid[][]) {
        // Your code here
        n = grid.length;
        Map<Integer,Integer>componentSizes = new HashMap<>();
        int componentIndex = 2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    int size = dfs(grid,i,j,componentIndex);
                    componentSizes.put(componentIndex,size);
                    componentIndex++;
                }
            }
        }
        int maxSize = componentSizes.values().stream().max(Integer::compare).orElse(0);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    Set<Integer>adjacentComponents = new HashSet<>();
                    for(int[] direction : directions){
                        int ni = i+direction[0],nj = j+direction[1];
                        if(ni>=0 && ni<n && nj>=0 && nj<n &&grid[ni][nj]>1)
                            adjacentComponents.add(grid[ni][nj]);
                    }
                    int newSize = 1;
                    for(int idx:adjacentComponents){
                        newSize += componentSizes.get(idx);
                    }
                    maxSize = Math.max(maxSize,newSize);
                }
            }
        }
        return maxSize;
    }    
    private int dfs(int[][] grid, int x, int y, int idx) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        grid[x][y] = idx;
        int size = 0;
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0], cy = current[1];
            size++;
            for (int[] direction : directions) {
                int nx = cx + direction[0], ny = cy + direction[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                    grid[nx][ny] = idx;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
        return size;
    }
}