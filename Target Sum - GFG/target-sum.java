//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] A , int N, int target) {
        // code here
        
        int[] res = new int[1];
        res[0] = 0;
        
        findTargetSumWays(A, target, res, 0);
        
        return res[0];
    }
    
    public static void findTargetSumWays(int[] A, int remain, int[] res, int i){
        
        if(i == A.length){
            res[0] += (remain == 0 ? 1 : 0);
            return;
        }
        
        findTargetSumWays(A, remain - A[i], res, i+1);
        findTargetSumWays(A, remain + A[i], res, i+1);
    }
};