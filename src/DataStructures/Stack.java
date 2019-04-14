package DataStructures;

public class Stack {
    private Node top;

    public boolean isEmpty(){
        return top==null;
    }

    public void push(int data){
        Node node=new Node(data);
        node.next=top;
        top=node;
    }

    public int pop(){
        //if(isEmpty()) return ;
        int data=top.data;
        top=top.next;
        return data;
    }

    public int peek(){
        return top.data;
    }

    private class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
        }
    }
}
