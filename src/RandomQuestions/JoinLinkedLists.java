package RandomQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JoinLinkedLists {



    public LinkedList<Integer> joinLinkedList(LinkedList a, LinkedList b, int n, int m){
        int i=n;
        while(i++<m) a.remove(n);
        a.add(n,b);
        return a;
    }

    public void main(String[] args){
        List<Integer> in= Arrays.asList(1,2,3,4,5,6,7,8,9);
        LinkedList<Integer> a=new LinkedList(in);
        LinkedList<Integer> b=new LinkedList(in);
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine().trim());
        int m=Integer.parseInt(sc.nextLine().trim());
        LinkedList result=joinLinkedList(a,b,n,m);
        System.out.println(result);
        sc.close();
    }


}
