package TreesAndGraphs;
import java.util.Arrays;
public class JoinGraphs {
    public static int[] parent;
    public static int parent(int x){
        if(parent[x]==x) return x;
        else return parent(parent[x]);
    }
    public static void union(int x, int y){
        int parX=parent(x);
        if(parX==parent(y)) return ;
        parent[x]=y;
        union(parX, y);
    }
    public static  int join(int n, int[][] edges, int[][] costEdge){
        parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;

        for(int[] e:edges) union(e[0], e[1]);
        int cost=0;
        Arrays.sort(costEdge, (x,y)-> x[2]-y[2]);
        for(int[] edge:costEdge){
            if(parent(edge[0])!=parent(edge[1])){
                union(edge[0], edge[1]);
                cost+=edge[2];
            }
        }
        return cost;
    }
    public static void main(String[] args){
        int[][] edges=new int[][]{{1,2},{2,3},{4,5}};
        int[][] costEdges=new int[][]{{1,4,12},{1,5,4},{3,0,8},{2,0,9},{0,5,16}};
        System.out.println(join(6,edges,costEdges));
    }
}
