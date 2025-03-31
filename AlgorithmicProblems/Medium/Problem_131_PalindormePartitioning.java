class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        recurse(ans,partition,s,0);
        return ans;
    }

    public void recurse(List<List<String>> ans,List<String> partition, String s, int i){
        if(i >= s.length()){
            ans.add(partition);
            return;
        }else{
            for(int j = i+1 ; j < s.length()+1; j++){
                String new_part = s.substring(i,j);
                if(isPallindrome(new_part)){
                    List<String> partition2 = new ArrayList<>(partition);
                    partition2.add(new_part);
                    recurse(ans,partition2,s,j);
                }
            }
        }
    }

    public boolean isPallindrome(String s){
        int i = 0;
        int j = s.length() -1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}