class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String alphabet = "abcdefghijklmnoprstuvwqxyz";
        List<List<String>> answer = new ArrayList<>();
        List<List<Integer>> answer2 = new ArrayList<>();
        for(String word : strs){
            List<Integer> num = word2num(word,alphabet);
            update(answer,answer2,num,word);
        }
        return answer;
    }

    public boolean compare(List<Integer> a, List<Integer> b){
        for(int i = 0; i < a.size(); i++){
            if(a.get(i) != b.get(i)){
                return false;
            }
        }
        return true;
    }

    public void update(List<List<String>> answer,List<List<Integer>> answer2, List<Integer> num, String word){
        boolean inside = false;
        for(int i = 0 ; i < answer.size(); i++){
            if(compare(answer2.get(i),num)){
                inside = true;
                answer.get(i).add(word);
                break;
            }
        }
        if(! inside){
            List<String> new_arr = new ArrayList<>();
            new_arr.add(word);
            answer.add(new_arr);
            answer2.add(num);
        }
    }

    public List<Integer> word2num(String word, String alphabet){
        List<Integer> out = new ArrayList<>();
        int count;
        for(int i = 0 ; i < alphabet.length(); i++){
            count = 0;
            for(int j = 0; j < word.length(); j++){
                if(alphabet.charAt(i) == word.charAt(j)){
                    count++;
                }
            }
            out.add(count);
        }
        return out;
    }
}
