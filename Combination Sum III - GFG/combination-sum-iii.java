//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int K;
            K = sc.nextInt();

            int N;
            N = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.combinationSum(K, N);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            for (int i = 0; i < ans.size(); i++) {
                ArrayList<Integer> cur = ans.get(i);
                for (int j = 0; j < cur.size(); j++) {
                    System.out.print(cur.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum(int K, int N) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        combinationSum(res, new ArrayList<>(), K, N, 1);
        
        return res;
    }
    
    public static void combinationSum(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int K, int remain, int num){
        
        if(temp.size() == K && remain == 0) {
            if(res.contains(temp)) return;
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=num; i<=9; i++){
            if(i > remain) break;
            temp.add(i);
            combinationSum(res, temp, K, remain - i, i+1);
            temp.remove(temp.size()-1);
        }
    }
}