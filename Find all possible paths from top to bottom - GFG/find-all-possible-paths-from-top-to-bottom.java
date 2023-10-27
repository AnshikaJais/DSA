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
            
            
            int[][] grid = IntMatrix.input(br, a[0], a[1]);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.findAllPossiblePaths(a[0],a[1], grid);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    static int[][] d = {{1,0},{0,1}};
    
    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n,int m, int[][] grid) {
        // code here
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        ArrayList<Integer> path = new ArrayList<>();
        
        path.add(grid[0][0]);
        
        findAllPossiblePaths(res, path, grid, n, m, 0, 0);
        
        return res;
    }
    
    public static void findAllPossiblePaths(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int[][] grid, int n, int m, int row, int col){
        
        if(row == n-1 && col == m-1){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=0; i<2; i++){
            
            int x = row + d[i][0];
            int y = col + d[i][1];
            
            // System.out.println(temp);
            
            if(isValid(x, y, n, m)){
                
                path.add(grid[x][y]);
                
                findAllPossiblePaths(res, path, grid, n, m, x, y);
                
                path.remove(path.size()-1);
            }
        }
    }
    
    public static boolean isValid(int row, int col, int n, int m){
        return (row >= 0 && col >= 0 && row < n && col < m);
    }
}
        
