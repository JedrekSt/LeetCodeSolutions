class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int [] {-1,-1};
        }
        int i, j ,k;
        int j0, jk;
        i = 0;
        j = nums.length - 1;

        while(i < j) {
            k = (i + j) / 2;
            if (nums[k] < target) {
                i = k + 1;
            }else {
                j = k;
            }
        }
        if (nums[j] == target){
            j0 = j;
        }else{
            j0 = -1;
        }

        i = 0;
        j = nums.length - 1;
        while(i < j){
            k = (i + j) / 2 + 1;
            if(nums[k] <= target){
                i = k;
            }else{
                j = k - 1;
            }
        }
        if(nums[j] == target){
            jk = j;
        }else{
            jk = -1;
        }
        return new int [] {j0,jk};

    }
}
