//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends
class GfG
{
    int minEle;
    Stack<Integer> s;
    ArrayList<Integer> arr;
    
    // Constructor    
    GfG()
	{
	    s = new Stack<>();
	    arr = new ArrayList<>();
	}
	
    /*returns min element from stack*/
    int getMin()
    {
	    // Your code here
	    int x = -1;
	    if(arr.size() > 0) x = arr.get(arr.size() - 1);
	    return x;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
    	// Your code here
    	int x = -1;
    	if(!s.isEmpty()){
    	    x = s.pop();
    	    arr.remove(arr.size() - 1);
    	}
    	return x;
    }

    /*push element x into the stack*/
    void push(int x)
    {
    	// Your code here
    	s.push(x);
    	if(arr.size() == 0) arr.add(x); 
    	else arr.add(Math.min(x, arr.get(arr.size() - 1)));
	}
}

