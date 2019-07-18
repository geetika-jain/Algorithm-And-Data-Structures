package Arrays;

public class MergeTwoSortedArrays {
    public static void merge(int[] A, int[] B){
        int n=A.length-1, b=B.length;
        int a=n-b;
        b=b-1;
        while(a>=0 && b>=0){
            if(A[a]>B[b]) {
                A[n]=A[a];
                a--;
            }
            else{
                A[n]=B[b];
                b--;
            }
            n--;
        }
        if(b>=0){
            while(b>=0){
                A[n]=B[b];
                n--;b--;
            }
        }

    }

    public static void main(String[] args){
        int[] A={2,3,5,5,5,5,5,5,5,0,0,0,0,0}, B={1,3,4,6,7};
        merge(A,B);
        for(int i=0;i<A.length;i++)
            System.out.print(A[i]);
    }
}
