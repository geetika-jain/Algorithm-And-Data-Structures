package DynamicProgramming;

import java.util.Arrays;

public class nSteps {
    public int nSteps(int n){
        if(n==0 ) return 1;
        int[] memo=new int[n+1];
        Arrays.fill(memo, -1);
        return nStps(n, memo);


    }

    public int nStps(int n, int[] memo){
        if(n<0) return 0;
        else if(n==0) return 1;
        else if(memo[n]==-1) {
            memo[n]=nStps(n-1, memo)+ nStps(n-2, memo)+nStps(n-3, memo);
        }
        return memo[n];

    }
}
