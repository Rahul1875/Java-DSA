package src.com.pack.tree;


class Node6{
    int data;
    Node6 left, right;
    Node6( int k ){
        data = k;
        left = right = null;
    }
}

public class TwoPart {

    Node6 root;

    public static void main(String[] args){
        TwoPart tree = new TwoPart();
        tree.root = new Node6(5);
        tree.root.left = new Node6(1);
        tree.root.right = new Node6(6);
        tree.root.left.left = new Node6(3);
        tree.root.right.left = new Node6(7);
        tree.root.right.right = new Node6(4);
        if(tree.check(tree.root)==true)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    private boolean check(Node6 node) {

        int n = count(node);

        return checkRec(node,n);

    }

    private boolean checkRec(Node6 node, int n) {

        if(node == null){
            return false;
        }
        System.out.println("count node :"+count(node));
        int z = count(node);
        if(count(node) == n-count(node)){
            return true;
        }
        return checkRec(node.left, n) || checkRec(node.right, n);
    }

    private int count(Node6 node) {

        if (node == null) {
            return 0;
        } else {
            return count(node.left) + count(node.right) + 1;
        }
    }

}
