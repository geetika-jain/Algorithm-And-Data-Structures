package DynamicProgramming;

import java.util.ArrayList;

public class AllSubsets {
    public static ArrayList<ArrayList<Integer>> allSets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allSubsets;
        if(index==set.size()) {
            allSubsets=new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        }
        else{
            allSubsets=allSets(set, index+1);
            Integer item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubs= new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset: allSubsets){
                ArrayList<Integer> newsubset=new ArrayList<>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubs.add(newsubset);

            }
            allSubsets.addAll(moresubs);
        }


        return allSubsets;
    }

    public static  ArrayList<ArrayList<Integer>> allSubBit(ArrayList<Integer> set){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(set==null || set.size()==0) return result;
        int max=1<<set.size();

        for(int k=0;k<max;k++){
            ArrayList<Integer> ans=BitToSet(k, set);
            result.add(ans);
        }
        return result;

    }

    private static ArrayList<Integer> BitToSet(int k, ArrayList<Integer> set){
        ArrayList<Integer> ans= new ArrayList<>();
        if(k==0) return    ans;
        int idx=0;
        for(int i=k; i>0;i--){

            if((k&1) ==1){
                ans.add(set.get(idx));

            }
            k=k>>1;
            idx++;
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr=new int[]{1,2,3,4};

        ArrayList<Integer> list= new ArrayList<>();
        for(int i=0;i<arr.length;i++) list.add(arr[i]);
        ArrayList<ArrayList<Integer>> ans= allSets(list, 0);
        for(ArrayList<Integer> l:ans){
            for(int i:l){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }

}
