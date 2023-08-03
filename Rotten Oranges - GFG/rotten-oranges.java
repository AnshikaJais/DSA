//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    class Pair{
        int row, col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    //Function to find minimum time required to rot all oranges.
    
    public boolean isValid(int x, int y, int n, int m){
        
        return x>=0 && x<n && y>=0 && y<m;
    }
    
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        int total = 0, count = 0;
        
        Queue<Pair> q = new LinkedList<Pair>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                    count++;
                }
                if(grid[i][j] != 0) total++;
            }
        }
        // System.out.println(total);
        // System.out.println(count);
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        int time = 0;
        
        while(!q.isEmpty()){
            int flag = 0;
            int size = q.size();
            for(int i=0; i<size; i++){
                
                int row = q.peek().row;
                int col = q.peek().col;
                q.remove();
                
                for(int j=0; j<4; j++){
                    int x = row + dx[j];
                    int y = col + dy[j];
                    
                    if(isValid(x, y, n, m) && !vis[x][y] && grid[x][y] == 1){
                        flag = 1;
                        vis[x][y] = true;
                        count++;
                        q.add(new Pair(x, y));
                    }
                    
                }
            }
            time += flag;
        }
        
        return total == count ? time : -1;
    }
}