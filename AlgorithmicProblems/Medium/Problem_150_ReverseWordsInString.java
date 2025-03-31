class Solution {
    public String reverseWords(String s) {
        Stack_ st = new Stack_();
        int i = 0;
        int n = s.length();
        while(i < n){
            String new_string = "";
            while(s.charAt(i) != ' '){
                new_string = new_string.concat(Character.toString(s.charAt(i)));
                i++;
                if(i >= n){
                    break;
                }
            }
            i++;
            if(! new_string.isEmpty()){
                st.push(new_string);
            }
        }
        String out = "";
        while(! st.empty()){
            out = out.concat(st.pop());
            if(!st.empty()){
                out = out.concat(" ");
            }
        }
        return out;
    }
}

class Stack_{
    List <String> stack;
    Stack_(){
        stack = new ArrayList<>();
    }

    public boolean empty(){
        return stack.isEmpty();
    }

    public void push(String word){
        stack.add(word);
    }

    public String pop(){
        if(empty()){
            return null;
        }else{
            String out = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return out;
        }
    }
}