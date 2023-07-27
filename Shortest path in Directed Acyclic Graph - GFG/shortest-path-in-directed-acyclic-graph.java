//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    class Pair{
        int v;
        int wt;
        Pair(int v, int wt){
            this.v = v;
            this.wt = wt;
        }
    }
    
    public void topoSort(int node, int[] vis, ArrayList<ArrayList<Pair>> adj, Stack<Integer> st){
        vis[node] = 1;
        for(Pair it: adj.get(node)){
            if(vis[it.v] == 0) topoSort(it.v, vis, adj, st);
        }
        st.push(node);
    }
    
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		
		for(int i=0; i<N; i++){
		    ArrayList<Pair> temp = new ArrayList<Pair>();
		    adj.add(temp);
		}
		
		for(int i=0; i<M; i++){
		    adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		}
		
		int[] vis = new int[N];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<N; i++){
		    if(vis[i] == 0) topoSort(i, vis, adj, st);
		}
		

		int[] dis = new int[N];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
	    dis[0] = 0;
		while(!st.isEmpty()){
		    int node = st.pop();
		  //  System.out.println("node : " + node);
		    

		    for(int i=0; i<adj.get(node).size(); i++){
		        
		        int v = adj.get(node).get(i).v;
		        int wt = adj.get(node).get(i).wt;
		        
		      //  System.out.println(dis[v]);
		        if(dis[node] != Integer.MAX_VALUE){
		            
    		        if(dis[node] + wt < dis[v]){
    		            dis[v] = dis[node] + wt;
    		        }
		        }
		      //  System.out.println(dis[v]);
		    }
		}
		
		for(int i=0; i<N; i++){
		    if(dis[i] == Integer.MAX_VALUE) dis[i] = -1;
		}
		
		return dis;
	}
	
}