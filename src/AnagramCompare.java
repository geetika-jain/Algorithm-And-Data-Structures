import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AnagramCompare {

    public static List<Integer> anagramCompare(List<String> a, List<String> b){
        List<Integer> res=new ArrayList();
        int n=a.size(); int m=b.size();

        for(int j=0;j<m;j++){
            String x=a.get(j); String y=b.get(j);
            if(x.length()!=y.length()) res.add(j,-1);
            else{
                HashMap<Character,Integer> map=new HashMap<>();
                for(int i=0;i<x.length();i++){
                    if(map.containsKey(x.charAt(i))) map.put(x.charAt(i), map.get(x.charAt(i))+1);
                    else map.put(x.charAt(i),1);
                }
                for(int i=0;i<y.length();i++){
                    if(map.containsKey(y.charAt(i))) map.put(y.charAt(i), map.get(y.charAt(i))-1);
                }
                int sum=0;
                for(int z:map.values()) sum+=z;
                res.add(j,sum);
            }

        }
        return res;


    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine().trim());
        List<String> a=new ArrayList();
        List<String> b=new ArrayList();
        for(int i=0; i<n;i++)
        {   a.add(i,sc.nextLine());
        }
        int m=Integer.parseInt(sc.nextLine().trim());
        for(int i=0; i<m;i++)
        {   b.add(i,sc.nextLine());
        }
        List<Integer> result=anagramCompare(a,b);

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+", ");

        }
        sc.close();
    }
}
