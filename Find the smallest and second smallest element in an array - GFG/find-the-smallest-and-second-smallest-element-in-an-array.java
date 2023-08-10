//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Compute obj = new Compute();
            long[] product = obj.minAnd2ndMin(a, n); 
            if(product[0]==-1)
                System.out.println(product[0]);
            else
                System.out.println(product[0]+" "+product[1]);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute 
{
    public long[] minAnd2ndMin(long a[], long n)  
    {
        long[] res = new long[2];
        if(n == 1){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        res[0] = Math.min(a[0], a[1]);
        res[1] = Math.max(a[0], a[1]);
        for(int i=2; i<n; i++){
            
            if(a[i] == res[0] || a[i] == res[1]) continue;
            
            if(a[i] < res[0]){
                res[1] = res[0];
                res[0] = a[i];
            }
            else if(a[i] < res[1]) res[1] = a[i];
        }
        
        if(res[0] == res[1]){
            res[0] = -1;
            res[1] = -1;
        }
        
        return res;
    }
}
