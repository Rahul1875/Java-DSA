package src.com.pack.tree;

class Nodes10{
    int data;
    Nodes10 left, right;
    Nodes10(int k){
        data = k;
        left = right = null;
    }
}

class SumLeft{
    int lsum =0;
}

public class SumofLeftTree {

    Nodes10 root;
    public static void main(String[] args){
        SumofLeftTree tree = new SumofLeftTree();
        tree.root = new Nodes10(20);
        tree.root.left = new Nodes10(9);
        tree.root.right = new Nodes10(49);
        tree.root.left.right = new Nodes10(12);
        tree.root.left.left = new Nodes10(5);
        tree.root.right.left = new Nodes10(23);
        tree.root.right.right = new Nodes10(52);
        tree.root.left.right.right = new Nodes10(12);
        tree.root.right.right.left = new Nodes10(50);
        int sum = leftSum(tree.root);
        System.out.println("Sum of Left tree "+ sum);
    }

    private static int leftSum(Nodes10 root) {
        SumLeft summ = new SumLeft();
        getSum(root,false , summ);
        return summ.lsum;
    }

    private static void getSum(Nodes10 root, boolean flag, SumLeft summ) {
        if(root==null){
            return;
        }
        if(root.left ==null && root.right==null && flag){
            summ.lsum = root.data +summ.lsum;
        }
        getSum(root.left,true,summ);
        getSum(root.right,false,summ);
    }
}
