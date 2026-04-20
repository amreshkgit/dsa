package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary search tree implementation and traversal
 * pre order in order post order  traversal
 */
public class BSTImplementation {

    static class BstNode{
        int data;
        BstNode left;
        BstNode right;

        public static BstNode insert(BstNode root ,int data){
            if(root ==null){
                root = getNewNode(data);
            }
            else if(data <= root.data){
                root.left = insert(root.left,data);
            }
            else {
                root.right = insert(root.right,data);
            }
            return root;
        }

        public static BstNode getNewNode(int data){
            BstNode root = new BstNode();
            root.data = data;
            root.left = root.right = null;
            return root;
        }

        /**
         * In order traversal print in asc order
         * @param root
         */
        public static void inorder(BstNode root){
            if(root == null) return;
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        /**
         * post order traversal
         * @param root
         */
        public static void postOrder(BstNode root){
            if(root ==null){return;}
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        /**
         * pre order traversal
         * @param root
         */
        public static void preOrder(BstNode root){
            if(root==null){return;}
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        /**
         * level order traversal
         * @param root
         */
        public static void levelOrderTraversal(BstNode root){
            if(root == null)return;
            Queue<BstNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                root = q.poll();//get element from front for the queue
                System.out.print(root.data+" ");
                if(root.left !=null){q.add(root.left);}
                if(root.right!=null){q.add(root.right);}
            }
        }

        public static void leftViewOfTheBinaryTree(BstNode root){
            if(root == null)return;
                Queue<BstNode> q = new LinkedList<>();
                q.add(root);
                   while (!q.isEmpty()) {
                       int len = q.size();
                       //run the loop to the size of len
                       for(int i =0 ;i<len ;i++){
                           BstNode node = q.poll();// deque the node from the queue
                           if(i==0){
                               System.out.println(root.data);
                           }
                           if(node.left !=null){q.add(root.left);}
                           if(node.right!=null){q.add(root.right);}
                       }
               }

        }
        public static void printSumLevelWise(BstNode node) {
            if (node == null)
                return;
            Queue<BstNode> q = new LinkedList<>();
            q.add(node);
            while (true) {
                int size = q.size();
                if (size == 0)
                    break;
                int sum = 0;
                while (size > 0) {
                    BstNode t = q.remove();
                    sum = sum + t.data;
                    if (t.left != null) q.add(t.left);
                    if (t.right != null) q.add(t.right);
                    size--;
                }
                System.out.println("Sum: " + sum);
            }
        }
}
    public static void main(String[] args) {
        BstNode root =null;
        root = BstNode.insert(null,7);
        root = BstNode.insert(root,6);
        root = BstNode.insert(root,4);
        //root = BstNode.insert(root,2);
        root = BstNode.insert(root,3);
        //root = BstNode.insert(root,5);
        root = BstNode.insert(root,2);
        root = BstNode.insert(root,1);
        //root = BstNode.insert(root,4);


        System.out.println("\n-------Left view of Binary tree------");
        BstNode.leftViewOfTheBinaryTree(root);
        System.out.println("-------In order--------");
        BstNode.inorder(root);
        System.out.println("\n------Post order -----");
        BstNode.postOrder(root);
        System.out.println("\n------Pre Order--------");
        BstNode.preOrder(root);
        System.out.println("\n-------Level order traversal------");
        BstNode.levelOrderTraversal(root);
        BstNode.printSumLevelWise(root);
    }
}