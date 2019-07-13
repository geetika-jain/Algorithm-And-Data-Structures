package DynamicProgramming;

import java.util.Stack;

public class TowersOfHanoi {


    public static  void main(String[] args){
        Tower[] towers=new Tower[3];
        for(int i=0;i<3;i++){
            towers[i]=new Tower(i);
        }
        int n=5;
        for(int i=n;i>0;i--){
            towers[0].add(i);
        }

        towers[0].moveTowers(n, towers[1], towers[2]);

        while(!towers[1].disks.isEmpty()){
            System.out.println(towers[1].disks.pop());
        }

    }

    public static class Tower{
        Stack<Integer> disks;
        int index;

        Tower(int i){
            index=i;
            disks=new Stack<>();
        }

        void add(int i){
            if(!disks.isEmpty() && disks.peek()< i){
                System.out.println("Error adding  "+ i+"  to tower "+ index);
            }
            else disks.push(i);
        }

        void moveToTop( Tower dest) {
            // if(i<=0) return;
            if (!disks.isEmpty()) {
                int item = disks.pop();
                dest.disks.push(item);
            }
        }

        void moveTowers( int n, Tower dest, Tower buffer){
            if(n<=0) return;
            moveTowers(n-1, buffer, dest);
            moveToTop(dest);
            buffer.moveTowers(n-1, dest, this);
        }
    }
}
