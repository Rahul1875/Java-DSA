package src.com.pack.tree;

public class LeftViewBT {

    Node root;
    LeftViewBT(){
        root =null;
    }
    public static void main(String[] args){
        LeftViewBT tree = new LeftViewBT();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left =new Node(40);
        tree.root.left.right = new Node(60);
        tree.root.right.left = new Node(70);
        tree.root.right.right = new Node(80);
        tree.root.left.left.right =new Node(45);
        leftViewTree(tree.root);

    }

    private static void leftViewTree(Node root) {
        if(root==null){
            return;
        }
        System.out.println(root.data);
        if(root.left!=null){
            leftViewTree(root.left);
        }
        else if(root.right!=null && isleaf(root.right)){
            leftViewTree(root.right);
        }
    }

    private static boolean isleaf(Node root) {
        if (root==null){
            return false;
        }
        if(root.right ==null && root.left ==null){
            return true;
        }
        return false;
    }
}
