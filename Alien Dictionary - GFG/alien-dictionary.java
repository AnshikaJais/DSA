//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<K; i++) adj.add(new ArrayList<>());
        
        for(int i=0; i<N-1; i++){
            int j=0;
            while(j < dict[i].length() && j < dict[i+1].length()){
                char ch1 = dict[i].charAt(j);
                char ch2 = dict[i+1].charAt(j);
                if(ch1 != ch2){
                    adj.get(ch1 - 'a').add(ch2 - 'a');
                    break;
                }
                j++;
            }
        }
        
        int[] indegree = new int[K];
        for(int i=0; i<K; i++){
            for(int it : adj.get(i)) indegree[it]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<K; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        StringBuilder sb = new StringBuilder("");
        
        while(!q.isEmpty()){
            int node = q.remove();
            sb.append((char)(node + 'a'));
            
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
       
        return sb.toString();
        
        
    }
}