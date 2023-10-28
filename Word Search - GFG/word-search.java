//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int n = board.length;
        int m = board[0].length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m ;j++){
                if(board[i][j] == word.charAt(0)){
                    if(isWordExist(i, j, board, n, m, word, 1)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean isWordExist(int i, int j, char[][] board, int n, int m, String word, int index){
        
        if(index == word.length()) return true;
    
        char temp = board[i][j];
        board[i][j] = '!';
        
        char ch = word.charAt(index);
        
        
        for(int d=0; d<4; d++){
            
            int x = i + dx[d];
            int y = j + dy[d];
            
            if(isValid(x, y, n, m) && board[x][y] == ch){
                
                if(isWordExist(x, y, board, n, m, word, index+1)) return  true;
            }
        }
        
        board[i][j] = temp;
        
        return false;
        
    }
    
    public boolean isValid(int x, int y, int n, int m){
        return (x >=0 && y >= 0 && x < n && y < m);
    }
}