package src.com.pack.tree;

class Nodes9{
    int data;
    Nodes9 left, right;
    Nodes9(int k){
        data = k;
        left = right = null;
    }

}

public class SumOfTwoChild {

    Nodes9 root;
    public static void main(String[] args){

     SumOfTwoChild tree = new SumOfTwoChild();
        tree.root = new Nodes9(4);
        tree.root.left = new Nodes9(2);
        tree.root.right = new Nodes9(5);
        tree.root.left.left = new Nodes9(7);
        tree.root.left.left.left = new Nodes9(6);
        tree.root.left.left.right = new Nodes9(1);
        tree.root.left.right = new Nodes9(2);
        tree.root.right.left = new Nodes9(2);
        tree.root.right.right = new Nodes9(3);

        int sum = twoChildSum(tree.root);
        System.out.println("sum of the two child tree "+sum);

    }

    private static int twoChildSum(Nodes9 root) {

        if(root ==null){
            return 0;
        }
        if(root.left != null && root.right != null){
            return root.data + twoChildSum(root.left)+twoChildSum(root.right);
        }
        return 0;
    }
}

