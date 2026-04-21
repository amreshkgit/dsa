package Tree;

public class FindMinMaxElementInBST {

    static class BstNode {
        int data;
        BstNode left;
        BstNode right;

        public static BstNode insert(BstNode root, int data) {
            if (root == null) {
                root = getNewNode(data);
            } else if (data <= root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }

        public static BstNode getNewNode(int data) {
            BstNode node = new BstNode();
            node.data = data;
            node.left = node.right = null;
            return node;
        }

        public static int FindMin(BstNode root){
            if(root == null){
                System.out.println("[ERROR] Tree is empty");
                return -1;
            }
           // BstNode cur = root;
            while(root.left !=null){
                root = root.left;
            }
            return  root.data;
        }

        public int FidMax(BstNode root){
            if(root == null){
                System.out.println("Tree doesn't have right child");
                return -1;
            }
            while (root.right != null){
                root = root.right;
            }
            return root.data;
        }
    }
    public static void main(String[] args) {
        //FindMinMaxElementInBST.BstNode.insert(10);

    }
}
