package DataStructures;

public class RankedNode {
    int node;
    RankedNode parent;
    int rank;
    boolean visited;
    int count;

    RankedNode(){
        node=-1;
        parent=null;
        rank=0;
        visited=false;
        count=0;
    }
    RankedNode(int n){
        this.node=n;
        parent=this;
        rank=0;
        count=1;
        visited=false;
    }

    public RankedNode find(){
        if(this.parent.node==this.node)
            return this;
        this.parent= this.parent.find();
        return  this.parent;
    }

    public void union(RankedNode v){
        RankedNode x=this.parent;
        RankedNode y=v.parent;

        if(x.node==y.node) return;

        if(x.rank<y.rank){
            x.parent=y.find();
            y.parent.count+=x.count;
        }
        else if(y.rank<x.rank){
            y.parent=x.find();
            x.parent.count+=y.parent.count;

        }
        else {
            x.parent = y;
            y.count += x.count;
            y.rank++;

        }
    }

    public boolean visited(){
        return this.visited;
    }

    public int rank(){
        return this.rank;
    }

    public int count(){
        return this.count;
    }
}
