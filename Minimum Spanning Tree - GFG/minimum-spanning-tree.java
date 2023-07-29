//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
                                
                                
                                // KRUSKAL's ALGO
                                
// class Edge implements Comparable<Edge>{
//     int src, dest, wt;
//     Edge(int src, int dest, int wt){
//         this.src = src;
//         this.dest = dest;
//         this.wt = wt;
//     }
//     @Override
//     public int compareTo(Edge e2){
//         return this.wt - e2.wt;
//     }
// }

// class DisjointSet{
//     static List<Integer> rank = new ArrayList<>();
//     static List<Integer> size = new ArrayList<>();
//     static List<Integer> parent = new ArrayList<>();
//     DisjointSet(int n){
//         for(int i=0; i<=n; i++){
//             rank.add(0);
//             parent.add(i);
//             size.add(1);
//         }
//     }
    
//     static int findParent(int node){
//         if(node == parent.get(node)) return node;
        
//         int ulp = findParent(parent.get(node));
//         parent.set(node, ulp);
//         return ulp;
//     }
    
//     static void unionByRank(int u, int v){
//         int ulp_u = findParent(u);
//         int ulp_v = findParent(v);
        
//         if(ulp_u == ulp_v) return;
        
//         if(rank.get(ulp_u) < rank.get(ulp_v)){
//             parent.set(ulp_u, ulp_v);
//         }
//         else if(rank.get(ulp_v) < rank.get(ulp_v)){
//             parent.set(ulp_v, ulp_u);
//         }
//         else{
//             parent.set(ulp_v, ulp_u);
//             int rankU = rank.get(ulp_u);
//             rank.set(ulp_u, rankU + 1);
//         }
//     }
    
//     static void unionBySize(int u, int v){
//         int ulp_u = findParent(u);
//         int ulp_v = findParent(v);
        
//         if(ulp_u == ulp_v) return;
        
//         if(size.get(ulp_u) < size.get(ulp_v)){
//             parent.set(ulp_u, ulp_v);
//             size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
//         }
//         else {
//             parent.set(ulp_v, ulp_u);
//             size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
//         }
//     }
// }
    
    
// class Solution{
    // static int spanningTree(int V, int E, int edges[][]){
    //     List<Edge> adjEdges = new ArrayList<Edge>();
        
    //     for(int i=0; i<edges.length; i++){
    //         int u = edges[i][0];
    //         int v = edges[i][1];
    //         int wt = edges[i][2];
            
    //         Edge temp = new Edge(u, v, wt);
    //         adjEdges.add(temp);
    //     }
        
    //     DisjointSet ds = new DisjointSet(V);
        
    //     Collections.sort(adjEdges);
    //     int mst = 0;
        
    //     for(int i=0; i<adjEdges.size(); i++){
    //         int u = adjEdges.get(i).src;
    //         int v = adjEdges.get(i).dest;
    //         int wt = adjEdges.get(i).wt;
            
    //         if(ds.findParent(u) != ds.findParent(v)){
    //             mst += wt;
    //             // System.out.println(mst);
    //             ds.unionBySize(u, v);
    //             // ds.unionByRank(u, v);
    //         }
    //     }
    //     // System.out.println(mst);
    //     return mst;
    // }
// }
    
    
                                //   PRIM'S ALGO    
class Solution{
    static class Pair{
        int first, second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    } 
    static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    
	    for(int i=0; i<V; i++) adj.add(new ArrayList<>());
	    
	    for(int i=0; i<edges.length; i++){
	        adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
	        adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
	    }
	    
	    boolean[] vis = new boolean[V];
	    PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
	    int sum = 0;
	    
    	pq.add(new Pair(0, 0));
 	    
        
     	while(!pq.isEmpty()){
     	    int dis = pq.peek().first;
     	    int node = pq.peek().second;
     	    pq.remove();
     	        
     	    if(vis[node]) continue;
     	        
     	    vis[node] = true;
     	    sum += dis;
     	        
     	    for(int i=0; i<adj.get(node).size(); i++){
     	        int v = adj.get(node).get(i).first;
     	        int wt = adj.get(node).get(i).second;
     	            
     	        if(!vis[v]){
     	           pq.add(new Pair(wt, v));
     	           }
     	    }
        }
 	    return sum;
    }
}