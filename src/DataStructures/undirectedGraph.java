package DataStructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class undirectedGraph {
    private int V;
    private LinkedList<Integer>[] adj;

    undirectedGraph(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }

    public static void main(String[] args){
        undirectedGraph G=new undirectedGraph(5);
        G.addEdge(1,2);
        G.addEdge(2,3);
        G.addEdge(2,4);
        G.addEdge(4,0);
        G.addEdge(0,1);
        G.addEdge(0,3);

        G.BFS(0);
    }

    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    void DFS(){
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
            visited[i]=false;

        printDFS(0, visited);
    }

    void printDFS(int v, boolean[] visited){
        if(!visited[v]){
            visited[v]=true;
            Integer i;
            System.out.print(v+" ");
            Iterator<Integer> it=adj[v].iterator();
            while(it.hasNext()){
                i=it.next();
                printDFS(i,visited);
            }
        }

    }

    void BFS(int v){
        Queue<Integer> Q=new LinkedList();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
            visited[i]=false;
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
