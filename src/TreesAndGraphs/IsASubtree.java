package TreesAndGraphs;

public class IsASubtree {
    public static boolean isSubTree(Node T1, Node T2){
        if(T1==null && T2==null) return true;
        if(T1!=null && T2==null) return true;
        if(T2!=null && T1==null) return false;

        Node n=search(T1, T2);
        if(n==null) return false;
        else return isSame(n, T2);
    }

    public static Node search(Node root, Node n){
        if(root == null || n==null)  return null;
        if(root.val==n.val) return root;
        Node l=search(root.left, n);
        Node r=search(root.right, n);
        return (l==null)? r:l;
    }

    public static  boolean isSame(Node n, Node m){
        if(n==null && m==null) return true;
        if(n==null || m==null) return false;
        if(n.val!=m.val) return false;
        return (isSame(n.left, m.left)&& isSame(n.right, m.right));
    }

    public static void main(String[] args){         // parent nodes not assigned
        Node root=new Node(4);
        root.left=new Node(1);
        root.left.right=new Node(3);
        root.right=new Node(7);
        root.right.left=new Node(6);
        root.right.right= new Node(9);

        Node T2=new Node(7);
        //T2.left=new Node(6);
        T2.right=new Node(9);
        System.out.println(isSubTree(root, T2));

    }

    public  static class Node{
        int val;
        //Node parent;
        Node left, right;
        Node(int val){
            this.val=val;
            left=null;
            right=null;
            //parent=null;
        }
    }
}
