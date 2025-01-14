class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        boolean[] seen = new boolean[n + 1]; // Tracks numbers encountered in A or B
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            // Check if A[i] has been seen before in B
            if (seen[A[i]]) {
                commonCount++;
            }
            // Mark A[i] as seen
            seen[A[i]] = true;

            // Check if B[i] has been seen before in A
            if (seen[B[i]]) {
                commonCount++;
            }
            // Mark B[i] as seen
            seen[B[i]] = true;

            // Update the prefix common count at index i
            C[i] = commonCount;
        }

        return C;
    }
}
