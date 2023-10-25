//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}
// } Driver Code Ends


class solve
{
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        // your code here
        Arrays.sort(arr);
        
        ArrayList <ArrayList <Integer>> res = new ArrayList<>();
        
        AllSubsets(res, new ArrayList<>(), arr, n, 0);
        
        Collections.sort(res, new Comparator<ArrayList<Integer>>(){
            
            @Override
            public int compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
                int size = Math.min(arr1.size(), arr2.size());
                
                for(int i=0; i<size; i++){
                    int comp = arr1.get(i) - arr2.get(i);
                    if(comp != 0) return comp;
                }
                return arr1.size() - arr2.size();
            }
        });
        
        return res;
    }
    
    public static void AllSubsets(ArrayList <ArrayList <Integer>> res, ArrayList<Integer> temp, int[] arr, int n, int index){
        
        if(!res.contains(temp)) res.add(new ArrayList<>(temp));
        
        for(int i=index; i<arr.length; i++){
            temp.add(arr[i]);
            AllSubsets(res, temp, arr, n, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
