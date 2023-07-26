//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    class Pair{
        int row, col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    dfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }
    
    public void dfs(int row, int col, int[][] vis, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        // int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        // int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
    
        vis[row][col] = 1;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                int x = row + i;
                int y = col + j;
                if(x>=0 && x<n && y>=0 && y<m && grid[x][y] == '1' && vis[x][y] == 0){
                    dfs(x, y, vis, grid);
                }

            }
        }
    }
}