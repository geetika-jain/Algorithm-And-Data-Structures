package Grid;

import java.util.LinkedList;
import java.util.Queue;

public class MinDist {
    public static int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
    public static void main(String[] args){
        int[][] grid={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,9,0,0,0},{0,0,0,0,0,0}};
        int minDist=findMinDist(grid);
        System.out.print(minDist);
    }

    public static int findMinDist(int[][] grid){
        Node src=new Node(0,0,0);
        Queue<Node> Q=new LinkedList<>();
        Q.add(src);
        while(!Q.isEmpty()){
            Node node=Q.poll();
            if(grid[node.r][node.c]==9) return node.d;
            for(int[] d:dir){
                int x=node.r+d[0], y=node.c+d[1];
                if(x>=0 && y>=0 && x<grid.length && y<grid.length){
                    Q.add(new Node(x,y,node.d+1));
                }
            }
        }
        return -1;
    }

    public static class  Node{
        int r,c,d;
        Node(int row, int col, int dis){
            r=row;
            c=col;
            d=dis;
        }
    }
}
