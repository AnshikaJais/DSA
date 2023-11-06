//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Tuple{
    int row, col, dis;
    
    Tuple(int r, int c, int d){
        row = r;
        col = c;
        dis = d;
    }
}

class Solution
{
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int[][] chefAndWells(int n,int m,char c[][])
    {
        int res[][] = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Tuple> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                res[i][j] = -1;
                
                if(c[i][j] == 'W'){
                    
                    res[i][j] = 0;
                    q.add(new Tuple(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()){
            
            int row = q.peek().row;
            int col = q.peek().col;
            int dis = q.peek().dis;
            q.poll();
            
            if(c[row][col] == 'H') res[row][col] = 2 * dis;
            
            for(int d=0; d<4; d++){
                
                int x = row + dx[d];
                int y = col + dy[d];
                
                if(isValid(x, y, n, m) && !vis[x][y] && (c[x][y] == 'H' || c[x][y] == '.')){
                    
                    vis[x][y] = true;
                    q.add(new Tuple(x, y, dis+1));
                }
            }
            
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                if(c[i][j] == '.' || c[i][j] == 'N') res[i][j] = 0;
                if(!vis[i][j] && c[i][j] == 'H') res[i][j] = -1;
            }
        }
        return res;
    }
    
    public boolean isValid(int x, int y, int n, int m){
        return (x >= 0 && y >= 0 && x < n && y < m);
    }
}