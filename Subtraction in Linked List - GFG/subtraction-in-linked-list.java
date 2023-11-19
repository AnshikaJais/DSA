//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.subLinkedList(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* Structure of Linked list node

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

*/

class Solution
{
    static int findLength(Node head){
        
        int size = 0;
        Node curr = head;
        
        while(curr != null){
            size++;
            curr = curr.next;
        }
        
        return size;
    }
    
    static Node reverse(Node head){
        
        Node prev = null, curr = head;
        
        while(curr != null){
            
            Node next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    static Node removeLeadingZeros(Node head){
        
        while(head != null && head.data == 0) head = head.next;
        
        return head;
    }
    
    static Node subLinkedList(Node l1, Node l2)
    {
        // code here
        l1 = removeLeadingZeros(l1);
        l2 = removeLeadingZeros(l2);
        
        int l1Size = findLength(l1);
        int l2Size = findLength(l2);
        
        Node temp1 = l1, temp2 = l2;
        Node lNode = null, sNode = null;
        
        if(l1Size != l2Size){
            
            lNode = l1Size > l2Size ? l1 : l2;
            sNode = l1Size < l2Size ? l1 : l2;
        }
        
        else{
            
            while(temp1 != null && temp2 != null){
                
                if(temp1.data != temp2.data){
                    lNode = temp1.data > temp2.data ? l1 : l2;
                    sNode = temp1.data < temp2.data ? l1 : l2;
                    break;
                }
                
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        
        lNode = reverse(lNode);
        sNode = reverse(sNode);
        
        Node curr1 = lNode;
        Node curr2 = sNode;
        
        Node dummy = new Node(-1);
        Node last = dummy;
        
        int borrow = 0;
        
        while(curr1 != null){
            
            int diff = (borrow + curr1.data) - (curr2 != null ? curr2.data : 0);
            
            if(diff < 0){
                borrow = -1;
                diff += 10;
            }
            else{
                borrow = 0;
            }
            
            last.next = new Node(diff);
            last = last.next;
            
            curr1 = curr1.next;
            if(curr2 != null) curr2 = curr2.next;
        }
        
        dummy = reverse(dummy.next);
        
        while(dummy != null && dummy.data == 0) dummy = dummy.next;
        
        return dummy == null ? new Node(0) : dummy;
        
    }
}