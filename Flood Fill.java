class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }

    void dfs(int[][] image,int sr,int sc, int color,int val) {
        if( sr<0 ||sc<0|| sr >= image.length || sc>=image[0].length || image[sr][sc]!=val||image[sr][sc]==color){
            return;
        }
        image[sr][sc]=color;
        dfs(image,sr-1,sc,color,val);//up
        dfs(image,sr,sc+1,color,val);//right
        dfs(image,sr+1,sc,color,val);//down
        dfs(image,sr,sc-1,color,val);//left;
}
}
