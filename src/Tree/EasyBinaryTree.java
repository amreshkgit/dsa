package Tree;

/**
 * Refer this for BinaryTree implementation
 */
public class EasyBinaryTree {
    private TreeNode root;

    private class TreeNode{
      int data;
      TreeNode left;
      TreeNode right;

      TreeNode(int data){this.data= data;}
    }

    public void insert(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root = node1;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left  = node6;
    }

    public TreeNode insert(TreeNode root,int data){
        if(root == null){
            root = new TreeNode(data);
            return root;
        }
        if(data < root.data){
            root.left = insert(root.left,data);
        }
        if(data >= root.data){
            root.right = insert(root.right,data);
        }
        return root;
    }

    /**
     * To find the max element in the tree
     * @param root
     * @return
     */
    public int findMax(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if(left > result) {
            result = left;
        }
        if (right > result) {
            result = right;
        }

        return result;
    }
    public void inOrder(){
        inOder(root);
    }

    public void inOder(TreeNode root){
        if(root == null){
            return;
        }
        inOder(root.left);
        System.out.print(root.data +" ");
        inOder(root.right);
    }
    public void insert(int value){
        root = insert(root,value);
    }

    public static void main(String[] args) {
        EasyBinaryTree tree = new EasyBinaryTree();
       // tree.insert();
        tree.insert(5);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        //tree.insert(9);
        tree.inOrder();
       // System.out.println(tree.findMax(tree.root));
    }
}
