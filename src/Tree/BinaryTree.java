package Tree;

import java.util.*;

public class BinaryTree {
    Node root;

    // Tree Node
    static class Node {
        int data, height;
        Node left, right;

        Node(){}
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to insert nodes in level order
    public Node insertLevelOrder(int[] arr, Node root,int i) {
        // Base case for recursion
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;

            // insert left child
            // to get the left child 2*i+1
            root.left = insertLevelOrder(arr, root.left,2 * i + 1); // maximum number of nodes at level is 2^i

            // insert right child
            //to get the right child 2*i+2
            root.right = insertLevelOrder(arr, root.right,2 * i + 2);
        }
        return root;
    }

    //Left Node right LNR
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    //Left right Node LRN
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }


    //Node Left right Node NLR
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void leftViewOfTheBinaryTree(Node root){
        if(root == null)return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            //run the loop to the size of len
            for(int i =0 ;i<len ;i++){
                Node node = q.poll();// deque the node from the queue
                if(i==0){
                    System.out.print(node.data+" ");
                }
                if(node.left !=null){q.add(node.left);}
                if(node.right!=null){q.add(node.right);}
            }
        }
    }

    public static void printLeftView(boolean [] levels,Node root,int curr){
       if(root == null) return;
         if(!levels[curr])
        {
            levels[curr] = true;
            System.out.print(root.data+" ");
        }
        printLeftView(levels,root.left,curr+1);    //left child called
        printLeftView(levels,root.right,curr+1);
    }

    public static void RightViewOfTheBinaryTree(Node root){
        if(root == null)return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            //run the loop to the size of len
            for(int i =0 ;i<len ;i++){
                Node node = q.poll();// deque the node from the queue
                if(i==len-1){
                    System.out.print(node.data+" ");
                }
                if(node.left !=null){q.add(node.left);}
                if(node.right!=null){q.add(node.right);}
            }
        }

    }

    /**
     *
     * Solution : Use two stack. Put root in stack1. While stack1 is not
     * empty take items from stack1 and put its child left,right in stack2.
     * Then once stack1 is empty pop from stack2 and put its child right,
     * left into stack1.
     * @param root
     */
    public static void spiralPrinting(Node root){
        if(root == null) return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){
            while (!s1.isEmpty()){
                root = s1.pop();
                System.out.print(root.data+" ");
                if(root.left!=null){s2.push(root.left);}
                if(root.right!=null){s2.push(root.right);}
            }
            while (!s2.isEmpty()){
                root = s2.pop();
                System.out.print(root.data+" ");
                if(root.right!=null){s1.push(root.right);}
                if(root.left!=null){s1.push(root.left);}
            }
        }
    }

    /**
     * top view
     * @param root
     */
    public static  void topView(Node root){
        if(root ==null){return;}

        TreeMap<Integer,Integer> map = new TreeMap<>();

        Queue<Node> qu = new LinkedList<>();
        qu.add(root);

        while (!qu.isEmpty()){
            Node node = qu.remove();
            int hd = node.height;
            if(map.get(hd) == null){
                map.put(hd,node.data);
            }
            if(node.left!=null){
                node.left.height = hd-1;
                qu.add(node.left);
            }
            if(node.right!=null){
                node.right.height = hd+1;
                qu.add(node.right);
            }
        }
        System.out.print(map.values());
    }

    /**
     * For vertical order traversal we do below steps
     * hd = horizontal distance
     * 1. For root hd =0
     * 2. For left child hd = hd(parent/root)-1
     * 3. For right child hd = hd(parent/root)+1
     *
     * Node which are at same level and at same horizontal distance then
     * if draw binary tree perfectly then these two nodes will overlap each other so, we can take only one
     * which means only one will be visible either one we can take to print
     * @param root
     */
    public static void BottomView(Node root){
        if(root ==null){return;}

        TreeMap<Integer,Integer> map = new TreeMap<>();

        Queue<Node> qu = new LinkedList<>();
        qu.add(root);

        while (!qu.isEmpty()){
            Node node = qu.remove();
            int hd = node.height;

            map.put(hd,node.data);

            if(node.left!=null){
                node.left.height = hd-1;
                qu.add(node.left);
            }
            if(node.right!=null){
                node.right.height = hd+1;
                qu.add(node.right);
            }
        }
        System.out.print(map.values());
    }

    /**
     * Diameter - it is the number of nodes on the longest path of that binary tree
     * length of the binary tree is number of nodes in that longest path
     * concept - to find the diameter of binary tree
     * diameter of binary tree = height of the left subtree + height of right subtree + root
     * Note - diameter is not always pass to root (keep in mind)
     */
    public static int diameterOfBinaryTree(Node node){
        if(node == null){return 0;}
        //start case 1. when diameter pass through root calculate left subtree Height and right subtree Height
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        //End
        //start case 2. when diameter not pass through root
        int lDiameter = diameterOfBinaryTree(node.left);
        int rDiameter = diameterOfBinaryTree(node.right);
        //End
        int fd = Math.max(lHeight+rHeight+1,Math.max(lDiameter,rDiameter));
        //Case 1 . when diameter pass through root for that this is lHeight+rHeight+1
        //case 2. when diameter is not pass through root then Math.max(lDiameter,rDiameter)
        return fd;
    }

    public static int height(Node node){
        //Base condition
        if(node == null){
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        // 1 is added for root node
        return 1 + Math.max(left,right);
        /*if(left>right){
            return 1+left;
        }else{
            return 1+right;
        }*/
    }

    /*
     * Find lowest common ancestor in binary tree.
     *
     * Time complexity O(n)
     * Space complexity O(h)
     */

    public static Node lca(Node node, int n1, int n2){
        if(node == null){
            return null;
        }
        //yadi left child ka data aur right child ka data equal return that node
        if(node.data == n1 || node.data == n2){
            return node;
        }

        Node left = lca(node.left, n1, n2);
        Node right = lca(node.right, n1, n2);

        //yadi left exist kar raha hai aur right exist kar raha root me to wo root node lca hai
        if(left != null && right != null){
            return node;
        }
        //yadi left node null nahi or right null hai to return left otherwise return right
        return left != null ? left : right;
    }

    public static void printNodesAtKDistanceFromRoot(Node node, int k) {
        if (node == null)
            return;
        if (k == 0)
            System.out.print(node.data+" ");
        else{
            printNodesAtKDistanceFromRoot(node.left, k - 1);
            printNodesAtKDistanceFromRoot(node.right, k - 1);
        }

    }

       public static boolean checkTwoBinaryTreeAreIdentical(Node n1 , Node n2){
        if(n1 == null && n2 == null)
            return true;
        if(n1 == null && n2 != null)
            return false;
        if(n1 != null && n2 == null)
            return false;
        if(n1 != null && n2 !=null) {
            if (n1.data == n2.data && checkTwoBinaryTreeAreIdentical(n1.left,n2.left) && checkTwoBinaryTreeAreIdentical(n1.right,n2.right)){
                return true;
            }
        }
        return false;
    }

    public static Node mirror(Node node){
        if(node == null)
            return null;

        mirror(node.left);
        mirror(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        return node;
    }

    public static void inorder( Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    public static void diagonalSum(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        int sum =0;
        while(!queue.isEmpty()){
            Node p = queue.poll();
            if(p == null){
                System.out.println(sum);
                queue.add(null);
                p = queue.poll();
                if(p == null) break;
            }
            sum = 0;
            while (p !=null){
                sum = sum + node.data;
                if(p.left!=null){
                    queue.add(p.left);
                }
                p = p.right;
            }
        }
    }

    public static void printVerticalOrder(Node node){
        if(node == null)return;
        int hd = 0;
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        getVerticalOrder(node,hd,m);
        for(Map.Entry<Integer,ArrayList<Integer>> cm : m.entrySet())
        {
           // cm.getValue().forEach(x-> System.out.print(x+" "));
            System.out.println(cm.getValue());
        }
    }

    private static void getVerticalOrder(Node node, int hd, TreeMap<Integer, ArrayList<Integer>> m) {
        if(node == null) return;
        if(m.get(hd) == null) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(node.data);
            m.put(hd,l);
        }else{
            ArrayList<Integer> l = m.get(hd);
            l.add(node.data);
            m.put(hd,l);
        }
        getVerticalOrder(node.left,hd-1,m);
        getVerticalOrder(node.right,hd+1,m);
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    public void maxAtEachLevel(Node root,List<Integer> largest_vals,int level){
        if(root == null)return;
        if(level == largest_vals.size()){
            largest_vals.add(root.data);
        }else{
            largest_vals.set(level,Math.max(largest_vals.get(level),root.data));
        }
        maxAtEachLevel(root.left,largest_vals,level+1);
        maxAtEachLevel(root.right,largest_vals,level+1);
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 3, 4, 5, 6,7};
        int arr1[] = { 2, 7, 5, 2, 6,5,11,5,4,9};
        int arr2[] = {2,4,1,7,8,3};
        tree.root = tree.insertLevelOrder(arr2, tree.root, 0);
        inorder(tree.root);
        System.out.println("Height of the tree : "+height(tree.root));
        //printVerticalOrder(tree.root);
        /*System.out.println("--------Left View--------");
        leftViewOfTheBinaryTree(tree.root);
        System.out.println("\n--------Right View--------");
        RightViewOfTheBinaryTree(tree.root);
        System.out.println("\n---Sprial printing---");
        spiralPrinting(tree.root);
        System.out.println("\n----Top View----");
        topView(tree.root);*/
     ///   System.out.println("\n---Bottom View-------");
      //  BottomView(tree.root);
       // System.out.println("\nDiameter of binary tree :"+diameterOfBinaryTree(tree.root));
        //Node node = lca(tree.root,4,5);
        //System.out.println("\nlowest common ancestor : "+node.data);
        //System.out.println("\n----Print node at K the distance ----");
        //printNodesAtKDistanceFromRoot(tree.root,2);
       // System.out.println("\n----Mirror tree----");
        //Node node1 = mirror(tree.root);
        //inorder(node1);
       // System.out.println("\n----Digonal sum----");
        //diagonalSum(tree.root);
        /*BinaryTree a = new BinaryTree();
        Node root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(5);
        root.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);
        root.right.right = a.createNewNode(9);
        root.right.right.left = a.createNewNode(4);
        printVerticalOrder(root);
        boolean[]levels = new boolean[height(tree.root)];
        printLeftView(levels,tree.root,0);*/
    }
}