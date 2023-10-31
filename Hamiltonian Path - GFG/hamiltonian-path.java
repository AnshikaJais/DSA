//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++) adj.add(new ArrayList<>());
        
        for(int i=0; i<M; i++){
            
            int u = Edges.get(i).get(0) - 1;
            int v = Edges.get(i).get(1) - 1;
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[N];
        Arrays.fill(vis, false);
    
        for(int i=0; i<N; i++){
            if(!vis[i] && dfs(i, new ArrayList<>(), vis, adj)) return true;
        }
        
        return false;
    }
    
    boolean dfs(int node, ArrayList<Integer> travelledNodes, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        
        vis[node] = true;
        travelledNodes.add(node);
        
        if(travelledNodes.size() == adj.size()) return true;
        
        for(Integer it : adj.get(node)){
            
            if(!vis[it] && dfs(it, travelledNodes, vis, adj)) return true;
        }
        
        vis[node] = false;
        travelledNodes.remove(travelledNodes.size() - 1);
        
        return false;
    }
} 