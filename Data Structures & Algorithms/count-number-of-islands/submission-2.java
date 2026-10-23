class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int island=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    island++;
                   
                    int[] Dr={-1,0,1,0};
                    int[] Dc={0,-1,0,1};
                    Queue<Pair> q=new LinkedList<>();
                    q.add(new Pair(i, j));

                    grid[i][j]='0';
                    while(q.size()>0){
                        Pair rem=q.remove();
                        for(int d=0;d<4;d++){
                            int nr=rem.x+Dr[d];
                            int nc=rem.y+Dc[d];
                            if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';

                                q.add(new Pair(nr, nc));
                            }
                        }
                    }
                }
            }
        }
        return island;
    }
}
