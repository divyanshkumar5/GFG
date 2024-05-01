//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution { 
    public Node arrangeCV(Node head) {
        Node dum = new Node('#'), tmp = dum, prev = null, curr = head, con = null; 
        while(curr != null) {
            char c = curr.data;
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {  
                tmp.next = curr;
                tmp = tmp.next;
                if(prev == null) {
                    Node p = curr.next;
                    curr.next = null;
                    curr = p;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                }
            } else {
                if(con == null)
                    con = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        tmp.next = con;
        return dum.next;
    }
}