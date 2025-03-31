class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List <List <Integer>> ans = distinct(arr);
        List <Integer> nums = ans.get(0);
        List <Integer> times = ans.get(1);
        
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList <>());
        for(int i = 0; i < nums.size(); i++){
            add_next(output,nums,times,i);
        }
        return output;
    }

    public List <List<Integer>> distinct(int [] arr){
        List<Integer> nums = new ArrayList<>();
        List<Integer> times = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(nums.contains(arr[i])){
                int id = nums.indexOf(arr[i]);
                times.set(id,times.get(id) + 1);
            }else{
                nums.add(arr[i]);
                times.add(1);
            }
        }
        List <List<Integer>> ans = new ArrayList<>();
        ans.add(nums);
        ans.add(times);
        return ans;
    }
    
    public void add_next(
        List<List<Integer>> ans,
        List <Integer> nums,
        List <Integer> times,
        int i){
        
        int n_subsets = ans.size();
        for(int j = 0; j < times.get(i); j++){
            int n_subsets_now = ans.size();
            for(int k = 0; k < n_subsets ;k++){
                List <Integer> temp = new ArrayList<>(ans.get(n_subsets_now - 1 - k));
                temp.add(nums.get(i));
                ans.add(temp);
            }
        }
    }
}
