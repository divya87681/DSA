import java.util.*;

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int n = words.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            char start = word.charAt(0);
            char end = word.charAt(word.length() - 1);
            prefixSum[i + 1] = prefixSum[i] + (vowels.contains(start) && vowels.contains(end) ? 1 : 0);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            result[i] = prefixSum[ri + 1] - prefixSum[li];
        }

        return result;
    }
}
