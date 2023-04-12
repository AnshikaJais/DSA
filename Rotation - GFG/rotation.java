//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        int l = 0, h = n-1;
        while(l<h){
            int mid = l+(h-l)/2;
            if(mid>l && arr[mid] < arr[mid-1]) return mid;
            if(mid<h && arr[mid] > arr[mid+1]) return mid+1;
            if(arr[0] > arr[mid]) h = mid;
            else l = mid+1;
        }
        return 0;
    }
}