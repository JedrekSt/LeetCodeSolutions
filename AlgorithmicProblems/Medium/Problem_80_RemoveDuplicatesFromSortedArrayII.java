class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2){
            return 2;
        }
        int garbage_st = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[garbage_st - 2]){
                nums[garbage_st] = nums[i];
                garbage_st++;
            }
        }
        return garbage_st;
    }
}
