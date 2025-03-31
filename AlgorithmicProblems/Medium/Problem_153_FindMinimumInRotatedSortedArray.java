class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k;

        while(i < j){
            k = (i + j) /2;
            if(nums[j] > nums[k]){
                j = k;
            }else if(nums[j] < nums[k]){
                i = k + 1;
            }else{
                return nums[k + 1];
            }
        }
        return nums[i];
    }


}