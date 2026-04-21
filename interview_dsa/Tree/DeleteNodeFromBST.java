package Tree;

public class DeleteNodeFromBST {

    class BNode{
        int data;
        BNode left,right;

        public BNode(int data){
            this.data = data;
            left = right =null;
        }
    }//end of class BNode

    BNode root;

    DeleteNodeFromBST(){
        root = null;
    }

    void deleteKey(int key)
    {
        root = deleteRec(root, key);
    }

    BNode deleteRec(BNode root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else
        {
            //Case 1: No child
            //if(root.left ==null && root.right ==null){
               // root =null;
            //}
            //Case 2:  node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            //Case 3 : More than 2 child
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    int minValue(BNode root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
    void insert(int key)
    {
        root = insertRec(root, key);
    }

    void inorder()
    {
        inorderRec(root);
    }
    BNode insertRec(BNode root, int key)
    {

        /* If the tree is empty, return a new node */
        if (root == null)
        {
            root = new BNode(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    void inorderRec(BNode root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        DeleteNodeFromBST tree = new DeleteNodeFromBST();
        tree.insert(50);
        //.insert(30);
       // tree.insert(20);
        //tree.insert(40);
       // tree.insert(70);
        //tree.insert(60);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        /*System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
        tree.insert(80);*/

    }

}
