class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] delta = new int[n + 1]; // Difference array

        // Apply the shifts to the difference array
        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1], direction = shift[2];
            int shiftVal = direction == 1 ? 1 : -1;
            delta[start] += shiftVal;
            if (end + 1 < n) {
                delta[end + 1] -= shiftVal;
            }
        }

        // Compute cumulative shifts
        int cumulativeShift = 0;
        int[] shiftsArray = new int[n];
        for (int i = 0; i < n; i++) {
            cumulativeShift += delta[i];
            shiftsArray[i] = cumulativeShift;
        }

        // Apply the cumulative shifts to the string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            int newCharIndex = (currentChar - 'a' + shiftsArray[i]) % 26;
            if (newCharIndex < 0) {
                newCharIndex += 26; // Handle negative shifts
            }
            result.append((char) ('a' + newCharIndex));
        }

        return result.toString();
    }
}
