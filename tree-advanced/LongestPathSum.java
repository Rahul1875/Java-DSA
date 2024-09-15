package src.com.pack.tree;

public class LongestPathSum {
    static class Node15{
        int data;
        Node15 left,right;
        Node15(int k){
            data = k;
            left =right = null;
        }
    }
    static int maxlen =0;
    static int maxsum=0;

    public static void main(String[] args) {

        Node15 root = new Node15(4);		 /*	 4	 */
        root.left = new Node15(2);		 /*	 / \	 */
        root.right = new Node15(5);	 /*	 2 5	 */
        root.left.left = new Node15(7); /*	 / \ / \	 */
        root.left.right = new Node15(1); /* 7 1 2 3 */
        root.right.left = new Node15(2); /*	 /		 */
        root.right.right = new Node15(3); /*	 6		 */
        root.left.right.left = new Node15(6);

        System.out.println( "Sum = "
                + pathtoLeafUtil(root));
    }

    static int pathtoLeafUtil(Node15 root) {

        if(root == null){
            return 0;
        }
        maxsum = Integer.MIN_VALUE;
        maxlen = 0;
        pathtoLeaf(root, 0, 0);

        return maxsum;
    }

    static void pathtoLeaf(Node15 root, int sum, int len) {
        if (root == null) {
            if (maxlen < len) {
                maxlen = len;
                maxsum = sum;
            } else if (maxlen == len && maxsum < sum)
                maxsum = sum;
            return;
        }
       // pathtoLeaf(root.left, sum+root.data, len + 1);
        pathtoLeaf(root.left, sum+root.data, len+1);
        pathtoLeaf(root.right,sum+root.data, len+1);
    }
}

