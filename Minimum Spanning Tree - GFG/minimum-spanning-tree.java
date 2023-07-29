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