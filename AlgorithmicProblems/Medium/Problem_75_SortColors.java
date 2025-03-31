class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = i;
        while(k <= j){
            if(nums[k] == 0){
                swap(nums,i,k);
                i += 1;
            }
            if(nums[k] == 2){
                swap(nums,j,k);
                j -= 1;
            }
            else{
                k += 1;
            }
        }
    }

    public void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
