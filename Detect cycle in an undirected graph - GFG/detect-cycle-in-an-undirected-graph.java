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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    
                                           /* Using BFS*/ 
    // Function to detect cycle in an undirected graph.
    // class Pair{
    //     int node;
    //     int parent;
    //     Pair(int node, int parent){
    //         this.node = node;
    //         this.parent = parent;
    //     }
    // }
    
    
    // public boolean detectCycleByBFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        
    //     Queue<Pair> q = new LinkedList<>();
    //     q.add(new Pair(node, -1));
    //     vis[node] = true;
        
    //     while(!q.isEmpty()){
    //         int size = q.size();
            
    //         for(int i=0; i<size; i++){
    //             int curr = q.peek().node;
    //             int parent = q.peek().parent;
    //             q.remove();
                
    //             for(int it: adj.get(curr)){
    //                 if(!vis[it]){
    //                     vis[it] = true;
    //                     q.add(new Pair(it, curr));
    //                 }
    //                 else if(it != parent) return true; // cycle detected
    //             }
    //         }
    //     }
    //     return false;
        
    // }
    
    
    // public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    //     // Code here
    //     boolean[] vis = new boolean[V];
    //     Arrays.fill(vis, false);
        
    //     for(int i=0; i<V; i++){
    //         if(!vis[i] && detectCycleByBFS(i, adj, vis)) return true;
    //     }
    //     return false;
        
    // }
    
    
    
                                            /* Using DFS*/
                                            
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(detectCycleByDFS(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }
    
    public boolean detectCycleByDFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                if(detectCycleByDFS(it, node, adj, vis)) return true;
            }
            else if(it != parent) return true;
        }
        return false;
    }
    
}