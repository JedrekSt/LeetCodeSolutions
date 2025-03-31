class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        recursive_sum(candidates,target,nums,output,0);
        return output;
    }

    public void recursive_sum(int [] candidates, int target, List<Integer> nums, List<List<Integer>> output, int i){
        if(target == 0){
            output.add(nums);
        }
        else if(i < candidates.length){
            int k = 0;
            while(k * candidates[i] <= target){
                List <Integer> new_nums = new ArrayList <> (nums);
                append_nums(new_nums,candidates[i], k);
                recursive_sum(candidates, target - k*candidates[i] ,new_nums, output, i+1);
                k += 1;
            }
        }
    }

    public void append_nums(List<Integer> nums,int number,int k){
        for(int i = 0; i < k; i++){
            nums.add(number);
        }
    }

}
