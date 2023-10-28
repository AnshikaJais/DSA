//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        
        dfs(0, board, res);
        
        Collections.sort(res, new Comparator<ArrayList<Integer>>(){
            
            @Override
            public int compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
                for(int i=0; i< arr1.size(); i++){
                    int comp = arr1.get(i) - arr2.get(i);
                    if(comp != 0) return comp;
                }
                return 0;
            }
        });
        
        return res;
    }
    
    static void dfs(int col, boolean[][] board, ArrayList<ArrayList<Integer>> res){
        
        if(col == board.length){
            
            ArrayList<Integer> temp = construct(board);
            
            if(!res.contains(temp)) res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int row=0; row<board.length; row++){
            
            if(isSafe(row, col, board)){
                
                board[row][col] = true;
                dfs(col+1, board, res);
                board[row][col] = false;
            }
        }
    }
    
    static boolean isSafe(int row, int col, boolean[][] board){
        
        int x = row;
        int y = col;
        
        while(y >= 0){
            if(board[x][y]) return false;
            y--;
        }
        
        x = row;
        y = col;
        
        while(x >= 0){
            if(board[x][y]) return false;
            x--;
        }
        
        x = row;
        y = col;
        
        while(x >= 0 && y >= 0){
            if(board[x][y]) return false;
            x--;
            y--;
        }
        
        x = row;
        y = col;
        
        while(x < board.length && y >= 0){
            if(board[x][y]) return false;
            x++;
            y--;
        }
        
        return true;
    }
    
    static ArrayList<Integer> construct(boolean[][] board){
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(boolean[] row : board){
            
            for(int i=0; i<row.length; i++){
                if(row[i]){
                    temp.add(i+1);
                }
            }
        }
        return temp;
    }
}