class Pair{
    int x;
    int y;
    int t;
    public Pair(int x,int y, int t){
        this.x=x;
        this.y=y;
        this.t=t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {

        int mintime=0;
        int fresh=0;
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int []Dr={-1,0,1,0};
        int[] Dc = {0,-1,0,1};
        while(q.size()>0){
            Pair rem=q.remove();
            mintime=rem.t;
            for(int i=0;i<4;i++){
                int nr=rem.x+Dr[i];
                int nc=rem.y+Dc[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    q.add(new Pair(nr,nc,mintime+1));
                    fresh--;
                }
            }
        }
        if(fresh==0){
            return mintime;
        }
        return -1;
        
    }
}
