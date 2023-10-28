//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int is_bleak(int n)
    {
        // Code here
        int nBits = (int)(Math.log(n) / Math.log(2));
        
        for(int i=n-nBits; i<=n; i++){
            int sum = i + CountSetBits(i);
            if(sum == n) return 0;
        }
        
        return 1;
    }
    
    public int CountSetBits(int i){
        int bits = 0;
        while(i != 0){
            if((i & 1) == 1) bits++;
            i >>= 1;
        }
        return bits;
    }
}