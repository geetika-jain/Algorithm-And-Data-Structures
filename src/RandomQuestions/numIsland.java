package RandomQuestions;

public class numIsland {
    public int numIslands(char[][] grid) {
        if(grid.length==0 ||grid[0].length==0) return 0;
        int m=grid.length;
        int n=grid[0].length;
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    DFS(grid, i,j,m,n);
                    count++;
                }

            }

        }
        return count;
    }



    void DFS(char[][] grid, int i, int j,int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        DFS(grid,i-1,j,m,n);
        DFS(grid,i,j-1,m,n);
        DFS(grid,i+1,j,m,n);
        DFS(grid,i,j+1,m,n);



    }


    public void main(String[] args){
        char[][] grid={{1,1},{1,0}};
        System.out.println(numIslands(grid));
    }
}
