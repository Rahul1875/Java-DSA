package src.com.pack.tree;

public class IsBst {

    Node2 root;
    IsBst(){
        root =null;
    }
    public static void main(String[] args){
        LeftViewBT tree = new LeftViewBT();
        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.right = new Node(10);
        tree.root.left.left =new Node(1);
        tree.root.left.right = new Node(6);
     //   tree.root.right.left = new Node(70);
        tree.root.right.right = new Node(14);
        tree.root.left.right.left =new Node(4);
        tree.root.left.right.right =new Node(7);
        if(isBST(tree.root,null,null)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }

    }



    static boolean isBST(Node root, Node l, Node r)
    {
        // Base condition
        if (root == null)
            return true;

        // if left node exist then check it has
        // correct data or not i.e. left node's data
        // should be less than root's data
        if (l != null && root.data <= l.data)
            return false;

        // if right node exist then check it has
        // correct data or not i.e. right node's data
        // should be greater than root's data
        if (r != null && root.data >= r.data)
            return false;

        // check recursively for every node.
        return isBST(root.left, l, root) &&
                isBST(root.right, root, r);
    }

}
