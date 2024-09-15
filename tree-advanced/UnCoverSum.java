package src.com.pack.tree;

class Node3{

    int data;
    Node3 left, right;
    Node3( int k ){
        data = k;
        left = right = null;
    }
}


public class UnCoverSum {

    Node root;
    UnCoverSum(){
        root=null;
    }
    public static void main(String[] args){

        UnCoverSum unCoverSum = new UnCoverSum();
        unCoverSum.root = new Node(8);
        unCoverSum.root.left = new Node(3);
        unCoverSum.root.left.left = new Node(1);
        unCoverSum.root.left.right = new Node(6);
        unCoverSum.root.left.right.left = new Node(4);
        unCoverSum.root.left.right.right = new Node(7);
        unCoverSum.root.right = new Node(10);
        unCoverSum.root.right.right = new Node(14);
        unCoverSum.root.right.right.left = new Node(13);
        if(unCoverSum.isSumtrue(unCoverSum.root)){
            System.out.println("Sum is equal");
        }else {
            System.out.println("Sum is not equal");
        }
    }

    private boolean isSumtrue(Node root) {

        int sumUC = sumUncovered(root);
        int sumT =  sumTotal(root);
        return (sumUC == (sumT -sumUC));
    }

    private int sumTotal(Node root) {
        if(root==null){
            return 0;
        } else {
            return root.data + sumTotal(root.left) + sumTotal(root.right);
        }
    }

    private int sumUncovered(Node root) {
        int lb=0;


        int rb =0;

        lb = sumUncoveredLeft(root.left);
        rb = sumUncoveredRight(root.right);
        return root.data + lb + rb;

    }

    private int sumUncoveredRight(Node root) {
        if(root.left == null && root.right == null){
            return root.data;
        }
        if(root.right != null){
            return root.data + sumUncoveredRight(root.right);
        } else {
            return root.data + sumUncoveredRight(root.left);
        }
    }

    private int sumUncoveredLeft(Node root) {

        if(root.left == null && root.right == null){
            return root.data;
        }
        if(root.left != null) {
            return root.data + sumUncoveredLeft(root.left);
        } else {
            return root.data + sumUncoveredLeft(root.right);
        }

    }
}
