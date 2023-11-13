//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node node, int x) {
        // Your code here
        
        Node small = new Node(-1), smallLast = small;
        Node equal = new Node(-1), equalLast = equal;
        Node large = new Node(-1), largeLast = large;
        
        while(node != null){
            
            if(node.data < x){
                smallLast.next = node;
                smallLast = smallLast.next;
            }
            else if(node.data == x){
                equalLast.next = node;
                equalLast = equalLast.next;
            }
            else{
                largeLast.next = node;
                largeLast = largeLast.next;
            }
            
            node = node.next;
        }
        
        if(equal.next != null){
            smallLast.next = equal.next;
            equalLast.next = large.next;
        }
        else{
            smallLast.next = large.next;
        }
        
        largeLast.next = null;
        return small.next;
        
        
    }
}