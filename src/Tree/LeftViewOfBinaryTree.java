package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
    static int first_node_level = 0;
    static boolean [] visited = new boolean[3];
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
            left = right =null;
        }
    }

    TreeNode root;

    public LeftViewOfBinaryTree(){
        root = null;
    }

    public static void leftView(TreeNode root , int level) {
        //int first_node_level = 0;
        if (root == null) return;
        if (first_node_level < level) {
            System.out.print(root.data+" ");
            first_node_level = level;
        }
        leftView(root.left, level + 1);
        leftView(root.right,level+1);
    }

    public static void rightView(TreeNode root , int level) {
        //int first_node_level = 0;
        if (root == null) {
           // first_node_level =0;
            return;
        }
        if(visited[first_node_level] == false) {
            //if (first_node_level < level) {
            System.out.print(root.data + " ");
            visited[first_node_level] = true;
            first_node_level++;
        }
       // }
         rightView(root.right,level+1);
         rightView(root.left, level + 1);
    }

    public static void levelOrder(TreeNode root){
        if(root == null){return;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
             root = queue.poll();
            System.out.print(root.data+" ");
            if(root.left!=null){queue.add(root.left);}
            if(root.right!=null){queue.add(root.right);}
        }
    }

    public static void main(String[] args) {
        LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
        tree.root = new TreeNode(12);
        tree.root.left = new TreeNode(10);
        tree.root.right = new TreeNode(30);
        tree.root.right.left = new TreeNode(25);
        tree.root.right.right = new TreeNode(40);

        LeftViewOfBinaryTree.levelOrder(tree.root);
        System.out.println("\n====Left view===========");
        LeftViewOfBinaryTree.leftView(tree.root,1);
        System.out.println("\n=====Right view==========");
        first_node_level =0;
        LeftViewOfBinaryTree.rightView(tree.root,1);
    }


}
