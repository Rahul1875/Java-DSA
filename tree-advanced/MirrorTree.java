package src.com.pack.tree;

class Node13{
    int data;
    Node13 left,right;
    Node13(int k){
        data =k;
        left=right=null;
    }
}

public class MirrorTree {
    Node13 root1, root2;

    public static void main(String[] args){
        MirrorTree tree1 = new MirrorTree();
        tree1.root1 = new Node13(1);
        tree1.root1.left = new Node13(2);
        tree1.root1.right = new Node13(3);
        tree1.root1.left.left = new Node13(4);
        tree1.root1.left.right = new Node13(5);

        MirrorTree tree2 = new MirrorTree();
        tree2.root2 = new Node13(1);
        tree2.root2.left = new Node13(3);
        tree2.root2.right = new Node13(2);
        tree2.root2.right.left = new Node13(5);
        tree2.root2.right.right = new Node13(4);

        if(isMirror(tree1.root1, tree2.root2)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static boolean isMirror(Node13 root1, Node13 root2) {
        if(root1 ==null && root2 ==null){
            return true;
        }
        if(root1 ==null || root2==null){
            return false;
        }
        return root1.data ==root2.data && isMirror(root1.left ,root2.right) && isMirror(root1.right ,root2.left);
    }
}
