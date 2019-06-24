package DataStructures;

public class DisjointSets {
    int[] parent, rank;
    int n;
    DisjointSets(int n){
        this.n=n;
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }

    public static void main(String[] args){
        DisjointSets D=new DisjointSets(5);
        D.union(0,1);
        D.union(3,4);
        System.out.println(D.find(4));
        System.out.println(D.find(2));
        D.union(2,4);
        System.out.println(D.find(2));
        D.union(1,4);
        System.out.println(D.find(4));
    }

    int find(int i){
        if(parent[i]==i) return i;
        parent[i]=find(parent[i]);
        return parent[i];
    }

    void union(int u, int v){
        int x=find(u);
        int y=find(v);
        if(x==y) return;
        if(rank[x]>rank[y])
            parent[y]=x;
        else if(rank[y]>rank[x])
            parent[x]=y;
        else{
            parent[y]=x;
            rank[x]++;
        }

    }
}
