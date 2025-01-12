class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;
        
        int balance = 0;
        int flexible = 0;

        
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                flexible++;
            } else if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) { 
                if (flexible > 0) {
                    balance++;
                    flexible--;
                } else {
                    return false;
                }
            }
        }

        balance = 0;
        flexible = 0;

        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                flexible++;
            } else if (s.charAt(i) == ')') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) { 
                if (flexible > 0) {
                    balance++;
                    flexible--;
                } else {
                    return false;
                }
            }
        }

        return true; 
    }
}

            
