package src.com.pack.tree;


class Nodes8{
    int data;
    Nodes8 left, right;
    Nodes8(int k){
        data = k;
        left = right = null;
    }

}

public class SumNodes {

    Nodes8 root;

    public static void main(String[] args){

        SumNodes tree = new SumNodes();
        tree.root = new Nodes8(1);
        tree.root.left = new Nodes8(2);
        tree.root.right = new Nodes8(3);
        tree.root.left.left = new Nodes8(4);
        tree.root.left.right = new Nodes8(5);
        tree.root.right.left = new Nodes8(6);
        tree.root.right.right = new Nodes8(7);
        tree.root.right.left.right = new Nodes8(8);
        int sum = addSum(tree.root);
        System.out.println("Sum of all the elements is: " + sum);
    }

    private static int addSum(Nodes8 node) {

        if(node == null){
            return 0;
        }
        return node.data + addSum(node.left) + addSum(node.right);

    }
}
