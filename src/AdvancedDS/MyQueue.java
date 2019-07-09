package AdvancedDS;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int capacity;


    MyQueue(int c){
        s1=new Stack<Integer>();
        s2=new Stack<Integer>();
        capacity=c;
    }

    public static void main(String[] args){
        MyQueue Q=new MyQueue(3);
        Q.add(2);
        Q.add(3);
        Q.add(1);
        Q.add(5);
        System.out.println(Q.poll());
        System.out.println(Q.poll());
        System.out.println(Q.poll());
    }

    boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }

    boolean isFull(){
        return (s1.size() + s2.size()>= capacity);
    }

    void add(int val){
        if(!isFull()){
            s1.push(val);
        }
    }

    int poll(){
        if(isEmpty())  return 0;
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
