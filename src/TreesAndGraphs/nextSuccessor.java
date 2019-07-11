package TreesAndGraphs;

public class nextSuccessor {
    public static  Node nextSucc(Node n){
        if(n.right!=null){
            Node r=n.right;
            while(r.left!=null)
                r=r.left;

            return r;
        }

        else {
            Node p=n.parent, c=n;
            while(p!=null && p.left!=c){
                c=p;
                p=p.parent;

            }


             return p;

//            if(p.left==n) return p;
            //Node p= (n.parent.parent);
        }


    }

    public static void main(String[] args){         // parent nodes not assigned
        Node root=new Node(4);
        root.left=new Node(1);
        root.left.right=new Node(3);
        root.right=new Node(7);
        root.right.left=new Node(6);
        root.right.right= new Node(9);
        Node n= nextSucc(root.left);
        System.out.println(n.val);
    }

    public static class Node{
        int val;
        Node parent;
        Node left, right;
        Node(int val){
            this.val=val;
            left=null;
            right=null;
            parent=null;
        }
    }
}
