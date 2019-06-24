package RandomQuestions;

public class numIsland {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                visited[i][j]=false;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    DFS(grid, i,j,visited);
                    count++;
                }

            }

        }
        return count;

    }
    boolean isSafe(char[][] grid, int i, int j, boolean[][] visited){
        return i >= 0 && i < visited.length && j >= 0 && j < visited[0].length && visited[i][j] != true && grid[i][j] == '1';
    }

    void DFS(char[][] grid, int i, int j, boolean[][] visited){
        if(isSafe(grid, i,j, visited)){
            visited[i][j]=true;
            DFS(grid,i-1,j,visited);
            DFS(grid,i,j-1,visited);
            DFS(grid,i+1,j,visited);
            DFS(grid,i,j+1,visited);
        }


    }

    public void main(String[] args){
        char[][] grid={{1,1},{1,0}};
        System.out.println(numIslands(grid));
    }
}
