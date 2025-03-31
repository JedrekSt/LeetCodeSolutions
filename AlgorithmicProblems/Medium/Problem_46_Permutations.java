class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> nums1 = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            nums1.add(nums[i]);
        }

        List<List<Integer>> lista = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();
        permute_rec(nums1,prefix,lista);
        return lista;
    }

    public void permute_rec(List <Integer> nums, List <Integer> prefix, List <List <Integer>> ans){
        if(nums.size() == 0){
            ans.add(prefix);
        }
        else{
            for(int i = 0 ; i < nums.size(); i++){
                List <Integer> nums2 = new ArrayList <> (nums);
                nums2.remove(i);
                List <Integer> prefix2 = new ArrayList <> (prefix);
                prefix2.add(nums.get(i));
                permute_rec(nums2, prefix2, ans);
            }
            
        }
    }
}