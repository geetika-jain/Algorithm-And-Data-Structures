package AdvancedDS;

import java.util.HashMap;

public class LRUcache {

    private int capacity;
    private int count;
    private DLLNode head;
    private DLLNode tail;
    private HashMap<Integer, DLLNode> cache= new HashMap<Integer, DLLNode>();

    LRUcache(int c){
        this.capacity=c;
        this.count=0;
        head=new DLLNode();
        tail=new DLLNode();

        head.pre=null;
        tail.post=null;

        head.post=tail;
        tail.pre=head;

    }

    public static void main(String[] args){
        LRUcache cache=new LRUcache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(1,1);
        cache.put(3,3);
        cache.get(4);
        cache.get(2);
    }

    void addNode(DLLNode node){
        node.pre=head;
        node.post=head.post;
        head.post.pre=node;
        head.post=node;
    }

    void remove(DLLNode node){
        DLLNode pre=node.pre;
        DLLNode post= node.post;

        pre.post=post;
        post.pre=pre;
    }

    void moveToHead(DLLNode node){
        this.remove(node);
        this.addNode(node);
    }

    DLLNode tailPop(){
        DLLNode pre=tail.pre;
        pre.pre.post=tail;
        tail.pre=pre.pre;
        return pre;
    }

    public int get(int key){
        DLLNode node=cache.get(key);

        if(node==null) return -1;

        this.moveToHead(node);

        return node.val;
    }

    public void put(int key, int value){
        DLLNode node=cache.get(key);

        if(node==null){
            node=new DLLNode();
            node.key=key;
            node.val=value;
            this.addNode(node);
            this.cache.put(key, node);
            ++count;

            if(count>capacity){
                DLLNode t= this.tailPop();
                this.cache.remove(t.key);
                count--;
            }



        }
        else{
            node.val=value;
            this.moveToHead(node);
        }
    }

    class DLLNode{
        int key;
        int val;
        DLLNode pre;
        DLLNode post;
    }





}
