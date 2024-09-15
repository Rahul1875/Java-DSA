package src.com.pack.tree;

class Node16{
    int data;
    Node16 left, right;
    Node16(int k){
        data =k;
        left =right =null;
    }
}

public class LCAOne {
    Node16 root;
    public static void main(String [] args){

        LCAOne tree = new LCAOne();
        tree.root = new Node16(20);
        tree.root.left = new Node16(8);
        tree.root.right = new Node16(22);
        tree.root.left.left = new Node16(4);
        tree.root.left.right = new Node16(12);
        tree.root.left.right.left = new Node16(10);
        tree.root.left.right.right = new Node16(14);

        int n1 = 10, n2 = 14;
        Node16 t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

    }

    private Node16 lca(Node16 root, int n1, int n2) {
        if(root ==null){
            return null;
        }
        if(root.data>n1 && root.data>n2){
            return lca(root.left,n1,n2);
        }
        if(root.data<n1 && root.data<n2){
            return lca(root.right,n1,n2);
        }
        return root;
    }

}
