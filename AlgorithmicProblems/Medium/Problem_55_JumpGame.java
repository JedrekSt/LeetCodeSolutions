class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean decision;
        int i = n - 2;
        int j;
        while(i > 0){
            if(nums[i] == 0){
                decision = false;
                j = i - 1;
                while(j >= 0){
                    if(nums[j] > (i - j)){
                        decision = true;
                        break;
                    }
                    j -= 1;
                }
                i = j;
                if(! decision){
                    return false;
                }
            }
            i -= 1;
        }
        if(n != 1 && nums[0] == 0){
            return false;
        }
        else{
            return true;
        }
    }
}
