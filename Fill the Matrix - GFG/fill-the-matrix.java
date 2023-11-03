//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
	public static int minIteration(int N, int M, int x, int y){
		//code here
		
		Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x-1, y-1});
        
        int[][] matrix = new int[N][M];
        matrix[x-1][y-1] = 1;
        
        int iterations = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            
            for(int i=0; i<size; i++){
                int row = q.peek()[0];
                int col = q.peek()[1];
                q.poll();
                
                for(int d = 0; d < 4; d++){
                    
                    int a = row + dx[d];
                    int b = col + dy[d];
                    
                    if(isValid(a, b, N, M) && matrix[a][b] == 0){
                        
                        matrix[a][b] = 1;
                        flag = true;
                        q.add(new int[] {a, b});
                    }
                }
                
            }
            if(flag) iterations++;
        }
        return iterations;
	}
	
	public static boolean isValid(int x, int y, int N, int M){
	    return (x >=0 && y >= 0 && x < N && y <M);
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends