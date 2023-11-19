//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node 
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class SortLL
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) 
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);
            
            printList(node);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static void addToTheLast(Node node) 
{
  if (head == null) 
  {
    head = node;
  } else 
  {
   Node temp = head;
   while (temp.next != null)
          temp = temp.next;
         temp.next = node;
  }
}
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}*/
// you have to complete this function
class GfG
{
    public static Node quickSort(Node node)
    {
        //Your code here
        if(node == null || node.next == null) return node;
        
        Node[] part = partition(node);
        
        Node leftHead = part[0];
        Node pivot = part[1];
        Node rightHead = part[2];
        
        Node lHead = quickSort(leftHead);
        Node rHead = quickSort(rightHead);
        
        pivot.next = rHead;
        if(lHead == null) return pivot;
        
        Node lTail = lHead;
        while(lTail.next != null) lTail = lTail.next;
        
        lTail.next = pivot;
        
        return lHead;
    }
    
    private static Node[] partition(Node head){
        
        Node pivot = head;
        Node curr = head.next;
        
        pivot.next = null;
        
        Node leftHead = null, leftTail = null;
        Node rightHead = null, rightTail = null;
        
        while(curr != null){
            
            Node next = curr.next;
            curr.next = null;
            
            if(pivot.data >= curr.data){
                
                if(leftHead == null){
                    leftHead = leftTail = curr;
                }
                else{
                    leftTail.next = curr;
                    leftTail = leftTail.next;
                }
            }
            else{
                
                if(rightHead == null) {
                    rightHead = rightTail = curr;
                }
                else {
                    rightTail.next = curr;
                    rightTail = rightTail.next;
                }
            }
            
            curr = next;
        }
        
        Node[] part = {leftHead, pivot, rightHead};
        
        return part;
    }
}