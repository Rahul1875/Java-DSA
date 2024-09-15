package src.com.pack.tree;
// Java program to check if two binary tree are cousins
class CousinNode
{
    int data;
    CousinNode left, right;

    CousinNode(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    CousinNode root;

    // Recursive function to check if two Nodes are
    // siblings
    boolean isSibling(CousinNode node, CousinNode a, CousinNode b)
    {
        // Base case
        if (node == null)
            return false;

        return ((node.left == a && node.right == b) ||
                (node.left == b && node.right == a) ||
                isSibling(node.left, a, b) ||
                isSibling(node.right, a, b));
    }

    // Recursive function to find level of Node 'ptr' in
    // a binary tree
    int level(CousinNode node, CousinNode ptr, int lev)
    {
        // base cases
        if (node == null)
            return 0;

        if (node == ptr)
            return lev;

        // Return level if Node is present in left subtree
        int l = level(node.left, ptr, lev + 1);
        if (l != 0)
            return l;

        // Else search in right subtree
        return level(node.right, ptr, lev + 1);
    }

    // Returns 1 if a and b are cousins, otherwise 0
    boolean isCousin(CousinNode node, CousinNode a, CousinNode b)
    {
        // 1. The two Nodes should be on the same level
        //	 in the binary tree.
        // 2. The two Nodes should not be siblings (means
        // that they should not have the same parent
        // Node).
        return ((level(node, a, 1) == level(node, b, 1)) &&
                (!isSibling(node, a, b)));
    }

    //Driver program to test above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new CousinNode(1);
        tree.root.left = new CousinNode(2);
        tree.root.right = new CousinNode(3);
        tree.root.left.left = new CousinNode(4);
        tree.root.left.right = new CousinNode(5);
        tree.root.left.right.right = new CousinNode(15);
        tree.root.right.left = new CousinNode(6);
        tree.root.right.right = new CousinNode(7);
        tree.root.right.left.right = new CousinNode(8);

        CousinNode Node1, Node2;
        Node1 = tree.root.left.left;
        Node2 = tree.root.right.right;
        if (tree.isCousin(tree.root, Node1, Node2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

