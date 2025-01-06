class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int visited[]=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(isConnected,i,visited);
                ans++;
            }
        }
        return ans;
    }
    void dfs(int[][] isConnected,int src,int [] visited){ 
        visited[src]=1;
        for(int j=0;j<isConnected[0].length;j++){
            if(isConnected[src][j]==1 && visited[j]==0){
                dfs(isConnected,j,visited);
            }
        }
    }
}
