//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> res = new ArrayList<>();
        
        AllParenthesis(res, new StringBuilder(), 0, 0, n);
        
        return res;
    }
    
    public void AllParenthesis(List<String> res, StringBuilder sb, int leftCount, int rightCount, int n){
        
        if(leftCount == n && rightCount == n){
            res.add(sb.toString());
            return;
        }
        
        if(leftCount < n){
            
            AllParenthesis(res, sb.append("("), leftCount + 1, rightCount, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(rightCount < leftCount){
            
            AllParenthesis(res, sb.append(")"), leftCount, rightCount + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}