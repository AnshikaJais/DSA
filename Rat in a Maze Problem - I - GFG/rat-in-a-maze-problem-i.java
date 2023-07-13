//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), m, 0, 0);
        return res;
    }
    public static void backtrack(ArrayList<String> res, StringBuilder path, int[][] m, int row, int col){
        if(row < 0 || col < 0 || row == m.length || col == m.length || m[row][col] == 0){
            return;
        }
        
        if(row == m.length-1 && col == m.length-1){
            res.add(path.toString());
            return;
        }
        
        m[row][col] = 0;
        
        //Top
        backtrack(res, path.append("U"), m, row-1, col);
        path.deleteCharAt(path.length() - 1);
        //Bottom
        backtrack(res, path.append("D"), m, row+1, col);
        path.deleteCharAt(path.length() - 1);
        //Left
        backtrack(res, path.append("L"), m, row, col-1);
        path.deleteCharAt(path.length() - 1);
        //Right
        backtrack(res, path.append("R"), m, row, col+1);
        path.deleteCharAt(path.length() - 1);
        
        m[row][col] = 1;
        
    }
}