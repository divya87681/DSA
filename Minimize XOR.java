class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBitsInNum2 = Integer.bitCount(num2);
        int result = 0;

        // Step 1: Use set bits in num1 as much as possible
        for (int i = 31; i >= 0 && setBitsInNum2 > 0; i--) {
            if ((num1 & (1 << i)) != 0) { // Check if the bit at position i is set in num1
                result |= (1 << i); // Set the bit at position i in the result
                setBitsInNum2--;    // Decrease the count of remaining set bits
            }
        }

        // Step 2: Fill remaining set bits in the smallest positions
        for (int i = 0; i <= 31 && setBitsInNum2 > 0; i++) {
            if ((result & (1 << i)) == 0) { // Check if the bit at position i is unset in result
                result |= (1 << i); // Set the bit at position i in the result
                setBitsInNum2--;    // Decrease the count of remaining set bits
            }
        }

        return result;
    }
}
