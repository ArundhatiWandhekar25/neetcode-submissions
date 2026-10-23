class Pair{
    int x;
    int y;
    public Pair(int i,int j){
        x=i;
        y=j;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;

        int[] Dr={-1,0,1,0};
        int[] Dc={0,-1,0,1};

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int area = 0;
                   grid[i][j]=0;
                   Queue<Pair> q=new LinkedList<>();
                   q.add(new Pair(i,j));
                   
                   while(q.size()>0){
                    Pair rem=q.remove();
                     area++;
                   
                    for(int d=0;d<4;d++){
                        int nr=rem.x+Dr[d];
                        int nc=rem.y+Dc[d];
                        if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                             grid[nr][nc] = 0;
                            q.add(new Pair(nr,nc));
                        }
                    }

                   }
                    ans=Math.max(ans,area);
                }
            }
            
        }
        return ans;
        
    }
}
