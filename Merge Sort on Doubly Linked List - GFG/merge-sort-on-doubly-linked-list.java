//{ Driver Code Starts
import java.util.*;
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next, prev;
    Node(int key)
    {
        data = key;
        next = prev = null;
    }
}

class Driverclass
{
    public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        int a1 = sc.nextInt();
	        Node head = new Node(a1);
	        Node temp = head;
	        
	        for (int i = 1;i < n;i++)
	        {
	            int a = sc.nextInt();
	            Node n1 = new Node(a);
	            n1.prev = temp;
	            temp.next = n1;
	            temp = n1;
	        }
	        
	        head = new LinkedList().sortDoubly(head);
	        printList(head);
	    }
	}
	public static void printList(Node node)
	{
	    Node temp = node;
	    while(node != null)
	    {
	        System.out.print(node.data + " ");
	        temp = node;
	        node = node.next;
	    }
	    System.out.println();
	    while(temp != null)
	    {
	        System.out.print(temp.data + " ");
	        temp = temp.prev;
	    }
	    System.out.println();
	}
}

// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class LinkedList
{
    //Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head)
    {
        // add your code here
        if(head == null || head.next == null) return head;
        
        Node prev = null, slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // System.out.println("slow: " + slow.data);
        
        if(slow == head) return head;
        
        if(prev != null) prev.next = null;
        
        // mergeSort
        head = sortDoubly(head);
        // slow = middle 
        slow = sortDoubly(slow);
        
        // merge
        head = merge(head, slow);
        
        return head;
    }
    
    static Node merge(Node head1, Node head2){
        
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        
        if(head1.data < head2.data){
            
            head1.next = merge(head1.next, head2);
            head1.next.prev = head1;
            head1.prev = null;
            
            return head1;
        }
        else{
            
            head2.next = merge(head1, head2.next);
            head2.next.prev = head2;
            head2.prev = null;
            
            return head2;
        }
    }
}