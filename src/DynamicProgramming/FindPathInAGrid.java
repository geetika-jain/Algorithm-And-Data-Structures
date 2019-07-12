package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindPathInAGrid {
    public static ArrayList<Point> FindPath(boolean[][] matrix){
        ArrayList<Point> path=new ArrayList<>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return path;
        Set<Point> failed=new HashSet<>();
        find(matrix, matrix.length-1, matrix[0].length-1, path, failed);
        return path;
    }

    private static boolean find(boolean[][] matrix, int r, int c, ArrayList<Point> path, Set<Point> failed){
        if(r<0 || c<0 || !matrix[r][c]) return false;

        Point p=new Point(r,c);
        if(failed.contains(p)) return false;
        boolean isStart= r==0 && c==0;
        if(isStart || find(matrix, r-1,c,path,failed) || find(matrix, r,c-1,path,failed) ){
            path.add(p);
            return true;
        }
        failed.add(p);
        return false;
    }

    public static void main(String[] args){
        boolean[][] mat={{true, true, true, false},{false,true,false,false},{false,true,true,true},{false,false,true,true }};
        ArrayList<Point> ans= FindPath(mat);
        for(Point p:ans){
            System.out.println(p.r+" "+p.c);
        }
    }

    public static class Point{
        int r,c;
        Point(int x, int y){
            r=x;c=y;
        }

    }
}
