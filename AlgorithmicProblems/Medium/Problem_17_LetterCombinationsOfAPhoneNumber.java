import java.util.HashMap;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        HashMap<Character,String> hm = get_hm();
        generate(digits,"",0,output,hm);
        if (digits.length() == 0){
            return new ArrayList<String>();
        }
        return output;
    }

    public void generate(String digits,String actual, int i, List <String> output, HashMap <Character,String> hm){
        if(i == digits.length()){
            output.add(actual);
        }
        else{
            char dig = digits.charAt(i);
            for(int k = 0; k < hm.get(dig).length(); k++ ){
                generate(digits,actual + hm.get(dig).charAt(k), i + 1,output,hm);
            }
        }
    }

    public HashMap<Character,String> get_hm(){
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        return hm;
    }


}
