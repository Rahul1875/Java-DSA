package src.com.pack.tree;



class Node2{
    int data;
    Node2 left, right;
    Node2( int k ){
        data = k;
        left = right = null;

    }
}

public class SumTree {

    Node root;

    SumTree(){
        root = null;
    }

    public static void main(String[] args){
        SumTree tree = new SumTree();
        tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);
        if(tree.isSumTree(tree.root) != 0){
            System.out.println("The given tree satisfies children");
        } else {
            System.out.println("The given tree does not satisfies children");
        }

    }
    public int isSumTree(Node root) {

        int ls, rs;

        if(root == null || (root.left ==  null && root.right == null)){
            return 1;
        }

        ls = sum(root.left);
        rs = sum(root.right);

        if(root.data == ls+rs  && isSumTree(root.left) != 0 && isSumTree(root.right) !=0){
            return 1;
        }
        return 0;

    }

    private int sum(Node subnode) {

        if(subnode == null){
            return 0;
        }
        return sum(subnode.left) + subnode.data + sum(subnode.right);
    }

}
