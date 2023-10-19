//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[adj.size()];
        int level = 0;
       

        q.add(0);
        vis[0] = true;
       
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i=0; i<size; i++){
                int curr = q.remove();
                if(curr == X) return level;
                
                for(int it : adj.get(curr)){
                    if(vis[it] == false){
                        q.add(it);
                        vis[it] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}