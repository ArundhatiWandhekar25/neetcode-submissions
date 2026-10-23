class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int island=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    island++;
                    dfs(grid,i,j);
                }
            }
        }
        return island;
        
    }
    public void dfs(char[][] grid, int i, int j){
        int n=grid.length;
        int m=grid[0].length;
        int[] Dr={-1,0,1,0};
        int[] Dc={0,-1,0,1};
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0'){
            return;
        }
         grid[i][j] = '0';
         for(int d=0;d<4;d++){
            int nr=i+Dr[d];
            int nc=j+Dc[d];
            dfs(grid,nr,nc);
        }
    }
}
