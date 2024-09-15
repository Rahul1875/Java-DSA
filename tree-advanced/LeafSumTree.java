package src.com.pack.tree;

class Node12{
    int data;
    Node12 left, right;
    Node12(int k){
        data = k;
        left =right = null;
    }
}

class SumLeaf{
    int leafsum =0;
}

public class LeafSumTree {

    Node12 root;
    public static void main(String[] args){
        LeafSumTree tree = new LeafSumTree();
        tree.root = new Node12(1);
        tree.root.left = new Node12(2);
        tree.root.left.left = new Node12(4);
        tree.root.left.right = new Node12(5);
        tree.root.right = new Node12(3);
        tree.root.right.right= new Node12(7);
        tree.root.right.left = new Node12(6);
        tree.root.right.left.right =new Node12(8);

        SumLeaf summ = new SumLeaf();
        getLeafsum(tree.root,summ);
        System.out.println("leaf sum of tree " + summ.leafsum);
    }

    private static void getLeafsum(Node12 root,SumLeaf summ) {
        if(root==null){
            return;
        }
        if(root.left ==null && root.right ==null){
            summ.leafsum = summ.leafsum + root.data;
        }
        getLeafsum(root.left,summ);
        getLeafsum(root.right,summ);
    }

}
