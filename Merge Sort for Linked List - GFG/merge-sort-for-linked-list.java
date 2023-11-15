//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head == null || head.next == null) return head;
        
        Node middle = head;
        Node last = head;
        Node prev = null;
        
        // loop to reach middle and end of list
        while(last != null && last.next != null){
            prev = middle;
            middle = middle.next;
            last = last.next.next;
        }
        
        prev.next = null;
        head = mergeSort(head);
        middle = mergeSort(middle);

        head = merge(head, middle);
        
        return head;
    }
    
    static Node merge(Node head1, Node head2){
        
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        
        if(head1.data > head2.data){
            head2.next = merge(head1, head2.next);
            return head2;
        }
        else{
            head1.next = merge(head1.next, head2);
            return head1;
        }
        
    }
}


