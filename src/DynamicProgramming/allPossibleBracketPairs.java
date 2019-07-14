package DynamicProgramming;

import java.util.ArrayList;

public class allPossibleBracketPairs {
    public static ArrayList<ArrayList<Character>> allValidPairs(int n){
        ArrayList<ArrayList<Character>> AllPairs=new ArrayList<>();
        if(n==0) return AllPairs;
        if(n==1) {
            ArrayList<Character> arr=new ArrayList<>();
            arr.add('(');
            arr.add(')');
            AllPairs.add(arr);
            return AllPairs;
        }
        else{

            AllPairs = allValidPairs(n-1);
            ArrayList<ArrayList<Character>> more =new ArrayList<>();
            for(ArrayList<Character> a:AllPairs){

                ArrayList<Character> newArr=new ArrayList<>();
                newArr.addAll(a);
                newArr.add(0,'(');
                newArr.add(newArr.size(), ')');
                if(!more.contains(newArr)) more.add(newArr);

                newArr=new ArrayList<>();
                newArr.addAll(a);
                newArr.add(0,'(');
                newArr.add(1, ')');
                if(!more.contains(newArr)) more.add(newArr);

                newArr=new ArrayList<>();
                newArr.addAll(a);
                newArr.add('(');
                newArr.add( ')');
                if(!more.contains(newArr)) more.add(newArr);

            }
            //AllPairs.addAll(more);
            return more;

        }

    }

    public static void main(String[] args){
        ArrayList<ArrayList<Character>> result= allValidPairs(5);
        for(ArrayList<Character> a:result){
            for(Character c:a){
                System.out.print(c);
            }

            System.out.println();
        }
    }
}
