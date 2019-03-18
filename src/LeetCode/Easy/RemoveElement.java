package LeetCode.Easy;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len=nums.length;
        int i=nums.length-1; int j=0;
        while(i>=0){
            while(nums[i]== val){
                j++;i--;len--;
                if(i<0) break;
            }
            shift(nums,i,j);
        }
        return len;
    }
    public void shift(int[] nums, int i, int j){
        for(int k=i;k<nums.length-j;k++){
            nums[k]=nums[k+j];
        }
    }
    public void main(String[] args) {
        int[] nums = {2, 2, 3, 4, 5};
        int len = removeElement(nums, 3);
        System.out.println(len);
    }
}
