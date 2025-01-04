class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.isEmpty()){
            return new ArrayList<>();
        }
        String[] digitstoletters={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String>res=new ArrayList<>();
        res.add("");
        for(char digit:digits.toCharArray()){
            String letters=digitstoletters[digit-'0'];
            List<String>newres=new ArrayList<>();
            for(String combination:res){
                for(char letter:letters.toCharArray()){
                    newres.add(combination+letter);
                }
            }
            res=newres;
        }
        return res;
    }
}
