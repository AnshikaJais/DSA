//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Pair{
        int first, second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        if(start == end) return 0;
        Queue<Pair> q = new LinkedList<>();
        int[] dis = new int[100000];
        int n = arr.length;
        Arrays.fill(dis, (int)1e9);
        
        q.add(new Pair(start, 0));
        dis[start] = 0;
        
        while(!q.isEmpty()){
            int node = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            
            for(int i=0; i<n; i++){
                int num = (arr[i] * node) % 100000;
                
                if(num == end) return steps + 1;
                
                if(steps + 1 < dis[num]){
                    dis[num] = steps + 1;
                    q.add(new Pair(num, dis[num]));
                }
            }
        }
        
        return -1;
    }
}
