package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;


public class allSequencesOfBST {
    public static ArrayList<LinkedList<Integer>> allSequences(Node root){
        ArrayList<LinkedList<Integer>> results=new ArrayList<>();

        if(root==null){
            results.add(new LinkedList<>());
            return results;
        }

        LinkedList<Integer> prefix=new LinkedList<>();
        prefix.add(root.val);

        ArrayList<LinkedList<Integer>> leftSeq=allSequences(root.left);
        ArrayList<LinkedList<Integer>> rightSeq=allSequences(root.right);

        for(LinkedList<Integer> left: leftSeq){
            for(LinkedList<Integer> right: rightSeq){
                ArrayList<LinkedList<Integer>> weaved=new ArrayList<LinkedList<Integer>>();
                weave(left, right, weaved, prefix);
                results.addAll(weaved);
            }
        }

        return results;

    }

    public static void weave(LinkedList<Integer> left, LinkedList<Integer> right,
                                                ArrayList<LinkedList<Integer>> results, LinkedList<Integer>prefix){

        if(left.size()==0   || right.size()==0){
            LinkedList<Integer> result=(LinkedList<Integer>) prefix.clone();
            result.addAll(left);
            result.addAll(right);
            results.add(result);

        }

        int headL=left.removeFirst();
        prefix.addLast(headL);
        weave(left, right, results, prefix);
        prefix.removeLast();
        left.addFirst(headL);

        int headR=right.removeFirst();
        prefix.addLast(headR);
        weave(left, right, results, prefix);
        prefix.removeLast();
        right.addFirst(headR);


    }

    public static void main(String[] args){
        Node root=new Node(4);
        root.left=new Node(1);
        root.left.right=new Node(3);
        root.right=new Node(7);
        root.right.left=new Node(6);
        root.right.right= new Node(9);
        ArrayList<LinkedList<Integer>> results= allSequences(root);
        for(LinkedList<Integer> list:results){
            for(int i:list){
                System.out.print(i+", ");
                System.out.println();
            }
        }
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
