//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    private static void setParent(HashMap<Node, Node> parent, Node root, int target, Node[] targetNode){
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while(!q.isEmpty()){
        
            Node curr = q.poll();
            if(curr.data == target) targetNode[0] = curr;
            
            if(curr.left != null){
                parent.put(curr.left, curr);
                q.add(curr.left);
            }
            
            if(curr.right != null){
                parent.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
    
    
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        
        // To store Parent of all nodes 
        HashMap<Node, Node> parent = new HashMap<>();
        
        // To check for visited nodes
        Set<Integer> vis = new HashSet<>();
        
        // For traversing nodes
        Queue<Node> q = new ArrayDeque<>();
        
        // For storing resultant nodes
        ArrayList<Integer> res = new ArrayList<>();
        
        Node[] targetNode = new Node[1];
        
        setParent(parent, root, target, targetNode);
        
        vis.add(target);
    
        if(targetNode[0].left != null){
            
            q.add(targetNode[0].left);
            vis.add(targetNode[0].left.data);
        }
        if(targetNode[0].right != null){
            
            q.add(targetNode[0].right);
            vis.add(targetNode[0].right.data);
        }
        if(parent.containsKey(targetNode[0])){
            
            q.add(parent.get(targetNode[0]));
            vis.add(parent.get(targetNode[0]).data);
        }
        
        while(!q.isEmpty()){
            
            // System.out.println(res);
            // System.out.println(vis);

            int size = q.size();
            for(int i=0; i<size; i++){
                
                Node curr = q.poll();
                if(k == 1) res.add(curr.data);
                
                if(curr.left != null && vis.contains(curr.left.data) == false){
                    q.add(curr.left);
                    vis.add(curr.left.data);
                }
                
                if(curr.right != null && vis.contains(curr.right.data) == false){
                    q.add(curr.right);
                    vis.add(curr.right.data);
                }
                
                if(parent.containsKey(curr) && vis.contains(parent.get(curr).data) == false){
                    q.add(parent.get(curr));
                    vis.add(parent.get(curr).data);
                }
            }
            
            k--;
        }
        
        // System.out.println(res);
        // System.out.println(vis);
        Collections.sort(res);
        return res;
        
        
    }
};