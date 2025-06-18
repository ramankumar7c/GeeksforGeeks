/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                
                // Add the first node of this level to result
                if (i == 0) {
                    result.add(current.data);
                }
                
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }

        return result;
    }
}
