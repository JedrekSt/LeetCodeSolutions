class Solution {
    public int maxSubArray(int[] nums) {
        int iter = nums.length - 1;
        int max_sum = Integer.MIN_VALUE;
        int sum = 0;
        int buffer;

        int k = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[max] < nums[i]){
                max = i;
            }
        }
        if(nums[max] < 0){
            return nums[max];
        }

        while(iter >= 0){
            buffer = 0;
            while(iter >= 0){
                if(nums[iter] >= 0){
                    sum += nums[iter];
                    iter --;
                }else{
                    buffer = nums[iter];
                    break;
                }
            }

            if(sum > max_sum){
                max_sum = sum;
            }
            if(buffer + sum < 0){
                sum = 0;
            }else{
                sum += buffer;
            }
            iter--;
        }
        return max_sum;
        
    }

}
