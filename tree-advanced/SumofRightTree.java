package src.com.pack.tree;

class Node11{
    int data;
    Node11 left, right;
    Node11(int k){
        data =k;
        left = right = null;
    }

}

class SumRight{
    int rsum=0;
}


public class SumofRightTree {


    Node11 root;
    public static void main(String[] args){
        SumofRightTree tree = new SumofRightTree();
        tree.root = new Node11(1);
        tree.root.left = new Node11(2);
        tree.root.left.left = new Node11(4);
        tree.root.left.right = new Node11(5);
        tree.root.left.left.right = new Node11(2);
        tree.root.right = new Node11(3);
        tree.root.right.right = new Node11(8);
        tree.root.right.right.left = new Node11(6);
        tree.root.right.right.right= new Node11(7);

        SumRight summ = new SumRight();

        calRSum(tree.root,false,summ);

        System.out.println("right tree sum is "+summ.rsum);

    }

    private static void calRSum(Node11 root, boolean flag, SumRight summ) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && flag) {
            summ.rsum = root.data + summ.rsum;
        }
        calRSum(root.left,false,summ);
        calRSum(root.right,true,summ);
    }
}
