class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List <List<Integer>> cand = stats(candidates);
        List <List <Integer> > answer = new ArrayList <> ();
        List < Integer > prefix = new ArrayList <> ();
        recurse(answer,prefix,cand.get(1),cand.get(0),-1,target);
        return answer;
    }

    public void recurse(List<List<Integer>> ans, List<Integer> prefix, List<Integer> stats, List<Integer> distinct_nums, int i, int target){
        if(target == 0){
            ans.add(prefix);
        }else if(target > 0){
            for(int j = i + 1; j < distinct_nums.size(); j++){
                int key = distinct_nums.get(j);
                for(int s = 0; s < stats.get(j); s++){
                    List <Integer> new_prefix = cpPrefix(prefix);
                    for(int p = 0; p < s+1; p++){
                        new_prefix.add(key);
                    }
                    recurse(ans,new_prefix,stats,distinct_nums,j,target - (s + 1) * key);
                }
            }
        }else{
            return;
        }
    }

    public List<Integer> cpPrefix(List <Integer> prefix){
        List <Integer> ans = new ArrayList<>();
        for(int i = 0; i < prefix.size();i++){
            ans.add(prefix.get(i));
        }
        return ans;
    }

    public static List<List<Integer>> stats(int [] arr){
        List <Integer> nums = new ArrayList<>();
        List <Integer> freq = new ArrayList<>();
        for(int i = 0 ; i < arr.length; i++){
            if(! nums.contains(arr[i])){
                nums.add(arr[i]);
                freq.add(1);
            }else{
                int id = nums.indexOf(arr[i]);
                freq.set(id,freq.get(id) + 1);
            }
        }
        List <List <Integer>> ans = new ArrayList<>();
        ans.add(nums);
        ans.add(freq);
        return ans;
    }
}
