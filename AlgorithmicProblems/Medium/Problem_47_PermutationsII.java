import java.util.ArrayList;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> remain = new ArrayList<>();
        for(int i : nums){
            remain.add(i);
        }
        remain.sort( (a, b) -> { return -1 * a.compareTo(b); } );
        List<Integer> perm = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        recursiveFill(remain,perm,output);
        return output; 
    }

    public void recursiveFill(List <Integer> remain,List<Integer> perm, List<List<Integer>> output){
        if(remain.isEmpty()){
            output.add(perm);
        }
        else{
            int i = 0;
            while( i < remain.size() ){
                int val = remain.get(i);
                List <Integer> new_remain = new ArrayList<>(remain);
                List <Integer> new_perm = new ArrayList<>(perm);
                new_remain.remove(Integer.valueOf(val));
                new_perm.add(val);
                recursiveFill(new_remain,new_perm,output);
                while(i < remain.size() && remain.get(i) == val){
                    i += 1;
                }
            }
        }
    }
}
