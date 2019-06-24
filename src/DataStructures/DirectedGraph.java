package DataStructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraph {
    private int V;
    private LinkedList<Integer>[] adj;

    DirectedGraph(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }

    public static void main(String[] args){
        DirectedGraph G=new DirectedGraph(5);
        G.addEdge(1,2);
        //G.addEdge(2,3);
        G.addEdge(2,4);
        G.addEdge(4,0);
        //  G.addEdge(0,1);
        G.addEdge(1,3);
       G.DFS(1);
       G.BFS(0);


    }

    void addEdge(int v, int w){
        adj[v].add(w);

    }

    void DFS(int v){
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
            visited[i]=false;
        printDFS(v,visited);
        for(int i=0;i<V;i++){
            if(!visited[i]) printDFS(0, visited);
        }
        System.out.println();

    }

    void printDFS(int v, boolean[] visited){

            visited[v]=true;
            Integer i;
            System.out.print(v+" ");
            Iterator<Integer> it=adj[v].iterator();
            while(it.hasNext()){
                i=it.next();
                if(!visited[i])
                    printDFS(i,visited);
            }


    }

    void BFS(int v){
        Queue<Integer> Q=new LinkedList();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
            visited[i]=false;

        BFS(v, Q, visited);
        for(int i=0; i<V;i++){
            if(!visited[i]) BFS(i,Q,visited);
        }
        System.out.println();
    }

//    public int NoOfComponents(){
//        int count=0;
//
//        boolean visited[]=new boolean[V];
//        for(int i=0;i<V;i++)
//            visited[i]=false;
//
//        for(int i=0;i<V;i++){
//            if(!visited[i]){
//                count++;
//                printDFS(i, visited);
//            }
//        }
//
//        return count;
//    }

    void BFS(int v, Queue<Integer> Q, boolean[] visited){

        Integer i;
        Q.add(v);
        visited[v]=true;

        while(!Q.isEmpty()){
            i=Q.poll();
            System.out.print(i+" ");
            Iterator<Integer> it=adj[i].iterator() ;
            while(it.hasNext()){
                i=it.next();
                if(!visited[i]){
                    Q.add(i);
                    visited[i]=true;
                }

            }
        }
    }
}
