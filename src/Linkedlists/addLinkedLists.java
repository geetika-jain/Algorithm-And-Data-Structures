package Linkedlists;
import DataStructures.LinkedList.Node;
public class addLinkedLists {
    public Node addLists(Node l1,Node l2){
        int len1= length(l1);
        int len2= length(l2);

        if(len1>len2){
            l2=padlist(l2, len2-len1);
        }
        if(len2>len1){
            l1=padlist(l1, len2-len1);
        }

        PartialSum sum= addHelper(l1,l2);
        if(sum.carry==0){
            return sum.sum;
        }
        else{
            Node result=addBefore(sum.sum, sum.carry);
            return result;
        }

    }

    public PartialSum addHelper(Node l1, Node l2){
        if(l1==null && l2==null){
            PartialSum sum=new PartialSum();
            return sum;
        }
        PartialSum sum=addHelper(l1.next, l2.next);
        int val=l1.data +l2.data + sum.carry;

        Node finalResult= addBefore(sum.sum, val%10);
        sum.sum=finalResult;
        sum.carry=val/10;

        return sum;

    }

    public Node addBefore(Node node, int val){
        Node n=new Node(val);
        n.next=node;
        return n;
    }

    public int length(Node l){
        int len=0;
        while(l!=null){
            l=l.next;
            len++;
        }
        return len;
    }

    public Node padlist(Node n, int l){
        while(l!=0){
            Node node=new Node(0);
            node.next=n;
            n=node;
        }

        return n;
    }

    class PartialSum{
        public Node sum= new Node();
        int carry=0;

    }
}
