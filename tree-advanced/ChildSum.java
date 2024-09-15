package src.com.pack.tree;


class ChildNode{
    int data;
    ChildNode left, right;
    ChildNode( int k ){
        data = k;
        left = right = null;
    }
}

public class ChildSum {

    ChildNode root;

    ChildSum(){
        root = null;
    }

    public static void main(String[] args){
        ChildSum tree = new ChildSum();
        tree.root = new ChildNode(10);
        tree.root.left = new ChildNode(7);
        tree.root.right = new ChildNode(4);
        tree.root.left.left = new ChildNode(4);
        tree.root.left.right = new ChildNode(3);
        tree.root.right.right = new ChildNode(3);
        if(tree.isSumProperty(tree.root) == 0){
            System.out.println("The given tree satisfies children");
        } else {
            System.out.println("The given tree does not satisfies children");
        }

    }

    private int isSumProperty(ChildNode root) {

        int left_data = 0;
        int right_data =0;

        if(root == null || (root.left == null || root.right ==null)){
            return 0;
        }

        return (root.data-(root.left.data+root.right.data) + isSumProperty(root.left) + isSumProperty(root.right));
       /* else {
            if(root.left != null){
                left_data = root.left.data;
            }
            if (root.right != null){
                right_data = root.right.data;
            }
            if((root.data == left_data+right_data) && isSumProperty(root.left) != 0 && isSumProperty(root.right) != 0){
                return 1;
            } else return 0;
        }*/
    }


}
