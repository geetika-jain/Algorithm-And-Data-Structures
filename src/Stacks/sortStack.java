package Stacks;

import java.util.Stack;

public class sortStack {

    public static void sort(Stack<Integer> s){
        Stack<Integer> t=new Stack();
        while(!s.isEmpty()){
            int val=s.pop();
            while(!t.isEmpty() && t.peek()>val){
                s.push(t.pop());
            }
            t.push(val);
        }

        while(!t.isEmpty()){
            s.push(t.pop());
        }

    }
    public static void print(Stack<Integer> s){
        Stack<Integer> t=new Stack();
        while(!s.isEmpty()){
            int val=s.pop();
            System.out.println(val);
            t.push(val);
        }
        while(!t.isEmpty())
            s.push(t.pop());
    }
    public static void main(String[] args){
        Stack<Integer> stack=new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(8);
        stack.push(1);

        sort(stack);
        print(stack);

    }
}
