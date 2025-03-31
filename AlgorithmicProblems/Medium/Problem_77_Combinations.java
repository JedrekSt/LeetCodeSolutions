class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List <List<Integer>> output = new ArrayList<>();
        List <Integer> prefix = new ArrayList<>();
        recurse(prefix,output,n,k,0);
        return output;
    }

    public void recurse(List<Integer> prefix, List<List<Integer>> output, int n,int k,int last){
        if( prefix.size() == k){
            output.add(prefix);
        }
        else{
            for(int q = last + 1; q <= n ;q++){
                if(n + 1 - q >= k - prefix.size()){
                    List<Integer> new_prefix = new ArrayList<>(prefix);
                    new_prefix.add(q);
                    recurse(new_prefix,output,n,k,q);
                }
            }
        }
    }
}