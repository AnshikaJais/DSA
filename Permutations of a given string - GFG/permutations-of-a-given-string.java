//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        List<String> res = new ArrayList<>();
        
        backtrack(res, S, 0, S.length() - 1);
        
        Collections.sort(res);
        
        return res;
    }
    
    public void backtrack(List<String> res, String S, int l, int r){
        
        if(l == r && !res.contains(S)){
            
            res.add(S);
            return;
        }
        
        for(int i=l; i<=r; i++){
            
            S = swap(S, l, i);
            backtrack(res, S, l+1, r);
            S = swap(S, l, i);
        }
    }
    
    public String swap(String S, int l, int i){
        
        char[] arr = S.toCharArray();
        char temp = arr[l];
        arr[l] = arr[i];
        arr[i] = temp;
        
        return String.valueOf(arr);
    }
}