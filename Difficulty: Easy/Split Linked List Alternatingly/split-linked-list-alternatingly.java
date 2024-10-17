//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
        // code here
        if(head == null)
            return new Node[]{null,null};
            
        Node a_head = head;
        Node b_head = head.next;
        Node a_tail = a_head;
        Node b_tail = b_head;
        
        while(a_tail != null &&  b_tail != null){
            if(a_tail.next != null){
                a_tail.next = a_tail.next.next;
                a_tail = a_tail.next;
            }
            
            if(b_tail != null && b_tail.next != null){
                b_tail.next = b_tail.next.next;
                b_tail = b_tail.next;
            }
        }
        if(a_tail != null)
            a_tail.next = null;
            
        if(b_tail != null)
            b_tail.next = null;
            
        return new Node[]{a_head,b_head};
    }
}
