//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static Node modifyTheList(Node head){
        
        Node curr = head;
        
        int count = 0;
        
        while(curr != null){
            count++;
            curr = curr.next;
        }
        
        Node curr2 = head, head1 = null;
        
        for(int i=0; i<count/2; i++){
            Node next = curr2.next;
            curr2.next = head1;
            head1 = curr2;
            curr2 = next;
        }
        
        Node head2 = curr2, curr1 = head1;
        if(count % 2 != 0) curr2 = curr2.next;
        
        while(curr1 != null && curr2 != null){
            
            int temp = curr1.data;
            curr1.data = curr2.data - curr1.data;
            curr2.data = temp;
            
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        Node prev = head2;
        curr1 = head1;
        
        while(curr1 != null){
            Node next = curr1.next;
            curr1.next = prev;
            
            prev = curr1;
            curr1 = next;
        }
        
        return head;
        
    }
}