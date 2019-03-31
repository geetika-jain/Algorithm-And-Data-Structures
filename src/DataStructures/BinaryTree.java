package DataStructures;

public class BinaryTree {
    // variable to hold index in pre[] array
    static int preindex;

    static void printInorder(node root)
    {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args)
    {

        int[] pre = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int[] post = {8, 9, 4, 5, 2, 6, 7, 3, 1};

        int size = pre.length;
        node root = constructTree(pre, post, size);

        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
    }

    static class node
    {
        int data;
        node left, right;

        public node(int data)
        {
            this.data = data;
        }
    }

}
