package Linkedlists;

import DataStructures.LinkedList.Node;
public class isPalindrome {

    public boolean isPalindrome(Node head){
        int len=length(head);
        Result p= isPalin(head, len );
        return p.result;
    }

    public Result isPalin(Node head, int len){
        if(head==null || len <=0){
            return new Result(head, true);
        }
        if(len==1){
            return new Result(head.next, true);
        }

        Result res=isPalin(head.next, len-2);
        if(!res.result || res.node==null) return res;
        res.result=(head.data==res.node.data);
        res.node=res.node.next;

        return res;
    }

    public int length(Node head){
        int i=0;
        while(head!= null){
            head=head.next;
            i++;
        }
        return i;
    }

    class Result{
        boolean result;
        Node node;
        Result(Node head, boolean b){
            this.result=b;
            this.node=head;
        }
    }
}
