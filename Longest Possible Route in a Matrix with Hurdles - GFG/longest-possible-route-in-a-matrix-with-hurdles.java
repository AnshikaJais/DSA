//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            
            int[] b = IntArray.input(br, 4);
            
            
            int[][] mat = IntMatrix.input(br, a[0], a[1]);
            
            Solution obj = new Solution();
            int res = obj.longestPath(mat,a[0],a[1],b[0],b[1],b[2],b[3]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public static int longestPath(int[][] mat,int n,int m,int xs,int ys,int xd,int yd) {
        // code here
        
        if(mat[xs][ys] == 0) return -1;
        if(xs == xd && ys == yd) return 0; 
        
        boolean[][] vis = new boolean[n][m];
        int[] res = new int[1];
        res[0] = -1;
        
        vis[xs][ys] = true;
        longestPath(res, mat[xs][ys], vis, mat, n, m, xs, ys, xd, yd);
        
        return res[0];
    }    
    
    public static void longestPath(int[] res, int currDis, boolean[][] vis, int[][] mat, int n, int m, int row, int col, int xd, int yd){
        
        
        for(int i=0; i<4; i++){
            int x = dx[i] + row;
            int y = dy[i] + col;
            
            if(isValid(x, y, n, m) && !vis[x][y] && mat[x][y] == 1){
                
                if(x == xd && y == yd){
                    res[0] = Math.max(res[0], currDis);
                }
        
                vis[x][y] = true;
                longestPath(res, currDis +1, vis, mat, n, m, x, y, xd, yd);
                vis[x][y] = false;
            }
        }
    }
    
    public static boolean isValid(int x, int y, int n, int m){
        return (x >=0 && y >= 0 && x < n && y < m);
    }
}
        
