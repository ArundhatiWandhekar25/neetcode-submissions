class Pair{
    int x;
    int y;
    int d;
    public Pair(int i,int j,int dist){
        x=i;
        y=j;
        d=dist;
    }
}

class Solution {
    public void islandsAndTreasure(int[][] grid) {
      int n=grid.length;
      int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==0){
                q.add(new Pair(i,j,0));
            }
        }
      }

      int[] Dr={-1,0,1,0};
      int[] Dc={0,-1,0,1};

      while(q.size()>0){
        Pair rem=q.remove();
        for(int d=0;d<4;d++){
            int nr=rem.x+Dr[d];
            int nc=rem.y+Dc[d];
           if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc] == Integer.MAX_VALUE){
                grid[nr][nc]=rem.d+1;
                q.add(new Pair(nr,nc,rem.d+1));
            }
        }
      }
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            System.out.print(grid[i][j]);
        }
        System.out.println();
      }
        
    }
}






