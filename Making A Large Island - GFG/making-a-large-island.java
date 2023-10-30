//{ Driver Code Starts
import java.io.*;
import java.util.*;


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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findParent(int node){
        
        if(parent.get(node) == node) return node;
        
        int ulp = findParent(parent.get(node));
        
        parent.set(node, ulp);
        return ulp;
    }
    
    public void unionBySize(int u, int v){
        
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v) return;
        
        int sizeU = size.get(ulp_u);
        int sizeV = size.get(ulp_v);
        
        if(sizeU < sizeV){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, sizeU + sizeV);
        }
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, sizeU + sizeV);
        }
    }
}

class Solution{
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    
    public int largestIsland(int N,int[][] grid) 
    {
        // code here
        DisjointSet ds = new DisjointSet(N * N);
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                
                if(grid[i][j] == 0) continue;
                
                for(int d=0; d<4; d++){
                    
                    int x = i + dx[d];
                    int y = j + dy[d];
                    
                    if(isValid(x, y, N) && grid[x][y] == 1){
                        
                        int node = i * N + j;
                        int adjNode = x * N + y;
                        
                        ds.unionBySize(node, adjNode);
                    }
                }
                
            }
        }
        
        int mx = 0;
        boolean allOne = true;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                
                if(grid[i][j] == 1) continue;
                
                allOne = false;
                HashSet<Integer> set = new HashSet<>();
                
                for(int d=0; d<4; d++){
                    
                    int x = i + dx[d];
                    int y = j + dy[d];
                    
                    if(isValid(x, y, N) && grid[x][y] == 1){
                        set.add(ds.findParent(x * N + y));
                    }
                }
                
                int sizeTotal = 0;
                for(int par : set){
                    sizeTotal += ds.size.get(par);
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }
        
        if(allOne){
            for(int cell=0; cell<N*N; cell++) mx = Math.max(mx, ds.size.get(ds.findParent(cell)));
        }
        
        return mx;
    }
    
    public boolean isValid(int x, int y, int N){
        return (x >=0 && y >= 0 && x < N && y < N);
    }
}
