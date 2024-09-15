package src.com.pack.tree;


class Node7{
    int data;
    Node7 left, right;
    Node7(int k){
        data = k;
        left = right = null;
    }

}

public class DepthOfTree {

    Node7 root ;

    public static void main(String[] args){
        DepthOfTree tree = new DepthOfTree();
        tree.root = new Node7(1);
        tree.root.left = new Node7(2);
        tree.root.right = new Node7(3);
        tree.root.left.left = new Node7(4);
        tree.root.left.right = new Node7(5);
       // tree.root.left.left.left = new Node7(8);

        System.out.println("Height of tree is : " +
                tree.maxDepth(tree.root));
    }

    private int maxDepth(Node7 root) {
        if(root ==null){
            return 0;
        }
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);

        if(ldepth>rdepth){
            return ldepth +1;
        } else return rdepth +1;
    }
}
