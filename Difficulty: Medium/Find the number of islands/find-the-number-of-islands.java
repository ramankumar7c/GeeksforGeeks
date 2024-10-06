//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    private int[] dx = {-1,0,1,0,1,-1,-1,1};
    private int[] dy = {0,-1,0,1,1,1,-1,-1};
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    bfs(i,j,grid,n,m);
                }
            }
        }
        return ans;
    }
    private void bfs(int x, int y, char[][] grid, int n, int m){
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        grid[x][y]='0';
        
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int curX = point[0];
            int curY = point[1];
            
            for(int k=0;k<8;k++){
                int newX = curX + dx[k];
                int newY = curY + dy[k];
                
                if(isValid(newX, newY, n,m) && grid[newX][newY]=='1'){
                    queue.add(new int[]{newX, newY});
                    grid[newX][newY]='0';
                }
            }
        }
    }
    private boolean isValid(int x, int y, int n, int m){
        return (x>=0 && x<n && y>=0 && y<m);
    }
}