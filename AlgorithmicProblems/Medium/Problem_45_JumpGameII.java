class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n];
        dp[0] = 0;
        int j;
        for(int i = 1; i < n; i++){
            findShortestDist(nums,dp,i);
        }
        return dp[n-1];
    }

    public void findShortestDist(int [] nums, int [] dp, int i){
        int j = i - 1;
        int min_val = nums.length + 1;
        int ans = -1;
        while(j >= 0){
            if(nums[j] >= i - j && dp[j] < min_val){
                min_val = dp[j];
                ans = j;
            }
            j -= 1;
        }
        if(min_val == nums.length + 1){
            dp[i] = 0;
        }
        else{
            dp[i] = min_val + 1;
        }
    }
}