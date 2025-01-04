import java.util.*;

class Solution {
    class Node {
        HashMap<Character, Node> child;
        boolean isEnd;

        public Node() {
            child = new HashMap<>();
            isEnd = false;
        }
    }

    private Node root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        for (String s : words) {
            insert(s);
        }
        HashSet<String> ans = new HashSet<>();
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = board[i][j];
                if (root.child.containsKey(ch)) {
                    dfs(board, i, j, ans, "", vis, root);
                }
            }
        }
        
        return new ArrayList<>(ans);  
    }

    void dfs(char[][] board, int r, int c, HashSet<String> ans, String asf, boolean[][] vis, Node node) {
        int n = board.length;
        int m = board[0].length;
        if (r < 0 || r >= n || c < 0 || c >= m || vis[r][c]) {
            return;
        }
        char ch = board[r][c];
        if (!node.child.containsKey(ch)) {
            return;
        }
        
        vis[r][c] = true;
        node = node.child.get(ch);
        asf += ch;
        
        if (node.isEnd) {
            ans.add(asf);
        }

        // Explore neighbors (up, down, left, right)
        dfs(board, r - 1, c, ans, asf, vis, node);
        dfs(board, r + 1, c, ans, asf, vis, node);
        dfs(board, r, c - 1, ans, asf, vis, node);
        dfs(board, r, c + 1, ans, asf, vis, node);
        
        vis[r][c] = false;  // Backtrack
    }

    void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.child.containsKey(ch)) {
                Node nn = new Node();
                temp.child.put(ch, nn);
            }
            temp = temp.child.get(ch);
        }
        temp.isEnd = true;
    }
}
