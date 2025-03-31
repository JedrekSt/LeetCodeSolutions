class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List <List <Integer> > output = new ArrayList <>();
        output.add(new ArrayList <Integer>());
        if(nums.length != 0){
            int n;
            for(int i = 0; i < nums.length; i++){
                n = output.size();
                for(int j = 0 ; j < n ; j++){
                    List <Integer> update = new ArrayList<>(output.get(j));
                    update.add(nums[i]);
                    output.add(update);
                }
            } 
        }
        return output;
    }
}
