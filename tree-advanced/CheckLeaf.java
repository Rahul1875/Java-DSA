package src.com.pack.tree;

class  Node5{
    int data;
    Node5 left, right;
    Node5( int k ){
        data = k;
        left = right = null;
    }
}

class Leaf{
    int leaflevel =0;
}

public class CheckLeaf {

    Node5 root;
    Leaf mylevel = new Leaf();

    public static void main(String[] args){
        CheckLeaf tree = new CheckLeaf();
        tree.root = new Node5(12);
        tree.root.left = new Node5(5);
        tree.root.left.left = new Node5(3);
        tree.root.left.right = new Node5(9);
        tree.root.left.left.left = new Node5(1);
        tree.root.left.right.left = new Node5(1);
        if (tree.check(tree.root))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
    }

    boolean check(Node5 node)
    {
        int level = 0;
        return checkUtil(node, level, mylevel);
    }

    private boolean checkUtil(Node5 root, int level , Leaf Leaf) {

        if(root==null){
            return true;
        }
        System.out.println("node.key "+root.data + "at level "+ level + "and  Leaf Level is "+Leaf.leaflevel);
        if(root.right ==null && root.left ==null){

            if(Leaf.leaflevel ==0 ){
                Leaf.leaflevel = level;
                return true;
            }
            return (Leaf.leaflevel ==level);

        }
        return (checkUtil(root.left, level+1, Leaf ) && checkUtil(root.right, level+1, Leaf));

    }

}
