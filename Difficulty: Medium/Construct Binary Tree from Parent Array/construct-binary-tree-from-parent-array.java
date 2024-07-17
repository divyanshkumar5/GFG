//{ Driver Code Starts
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class CreateTree {
    static ArrayList<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            Node root = ob.createTree(arr);

            printLevelOrder(root);
            System.out.println();
        }
    }

    public static void printList(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
        }
    }

    public static void printLevelOrder(Node root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            result.clear();
            printGivenLevel(root, i);
            Collections.sort(result);
            for (int j = 0; j < result.size(); j++)
                System.out.print(result.get(j) + " ");
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;

        else {

            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    public static void printGivenLevel(Node node, int level) {
        if (node == null) return;
        if (level == 1)
            result.add(node.data);
        else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }
}

// } Driver Code Ends


/*node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int parent[]) {
        // Your code here
       int n = parent.length;

        // Array to store created nodes
        Node[] created = new Node[n];

        // Initialize all nodes as null
        for (int i = 0; i < n; i++) {
            created[i] = null;
        }

        // Initialize root of the tree
        Node root = null;

        for (int i = 0; i < n; i++) {
            // Create node if not already created
            if (created[i] == null) {
                created[i] = new Node(i);
            }

            // If parent is -1, then this node is root
            if (parent[i] == -1) {
                root = created[i];
            } else {
                // If parent is not created, create parent first
                if (created[parent[i]] == null) {
                    created[parent[i]] = new Node(parent[i]);
                }

                // Assign this node to the left or right child of the parent
                Node p = created[parent[i]];
                if (p.left == null) {
                    p.left = created[i];
                } else {
                    p.right = created[i];
                }
            }
        }

        return root; 
        
    }
}
