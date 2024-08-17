//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/


class Solution{
    public int sizeLL(Node head){
        if(head == null){
            return 0 ;
        }
        Node curr = head ;
        int count = 0 ;
        
        while(curr !=null){
            curr = curr.next ;
            count++;
        }
        
        return count ;
    }
    public Node rotate(Node head, int k) {
       
       if(head == null){
           return null ;
       }else if ( k == 0 ){
           return head ;
       }
       
       int size = sizeLL(head);
       
       int er = k%size ;
       
        if(er == 0 ){
            return head ;
        }
       Node ptr = head ;
       
       while(er>1){
           ptr = ptr.next ;
           er-- ;
       }
       
       Node nhead = ptr.next ;
       ptr.next = null ;
       Node ptr2 = nhead ;
       
       while(ptr2.next!=null){ // this is to identify the tail 
           ptr2 = ptr2.next ;
       }
       
       ptr2.next = head ;
       
       return nhead ;
    }
}



//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }
}

// } Driver Code Ends