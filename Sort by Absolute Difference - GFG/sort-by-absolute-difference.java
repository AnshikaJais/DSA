//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int x = Integer.parseInt(inputLine[1]);
		    
		    List<Integer> arr = new ArrayList<>();
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr.add(Integer.parseInt(inputLine[i]));
		    }
		    new Solution().sortABS(arr,n, x);
		    StringBuilder sb = new StringBuilder();
		    for(int y : arr)
		        sb.append(y+ " ");
		    System.out.println(sb.toString());
		    
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static class Pair{
        int ele;
        int diff;
        Pair(int ele, int diff){
            this.ele = ele;
            this.diff = diff;
        }
    }
    
    //Function to sort the array according to difference with given number.
    static void sortABS(List<Integer> arr, int n, int k)  
    {
        // add your code here
        // Pair[] pairs = new Pair[n];
        
        // for(int i=0; i<n; i++){
        //     pairs[i] = new Pair(arr.get(i), Math.abs(arr.get(i) - k));
        // }
        
        // Arrays.sort(pairs, (p1, p2) -> p1.diff - p2.diff);
        
        // for(int i=0; i<n; i++){
        //     arr.set(i, pairs[i].ele);
        // }
        
        Collections.sort(arr, (ele1, ele2) -> Math.abs(ele1 - k) - Math.abs(ele2 - k));
        
        return;
    }
}
