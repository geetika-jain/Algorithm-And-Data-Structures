package LeetCode.Easy;

public class CountAndSay {
    public static String countAndSay(int n) {

        String s="1";
        for(int j=1;j<n;j++){
            s=read(s);
        }


        return s;
    }
    public static String read(String s){
        String res=""; int i=0;
        int a=0;
        char b;
        b = s.charAt(i);

        while(i<s.length()){

            if(s.charAt(i)==b) a++;

            else{
                res=res+a+b;
                b=s.charAt(i);
                a=1;
            }
//                if(i>=s.length()-1) break;

            i++;
        }
        return res;
    }
    public static void main(String [] args){
        System.out.println(countAndSay(4));
    }
}
