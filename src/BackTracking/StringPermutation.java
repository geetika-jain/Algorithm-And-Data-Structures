package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static List<String> allPerm(String s){
        List<String> ans=new ArrayList<String>();

        if(s==null) return ans;
        perm(ans, "", s);
        return ans;
    }
    public static void perm(List<String> ans, String prefix, String s){
        if(s.length()==0 || s=="") {
            ans.add(prefix);
            return;
        }
        for(int i=0;i<s.length();i++){
            perm(ans, prefix+s.charAt(i), s.substring(0, i)+s.substring(i+1));
        }

    }

    public static void main(String[] args){
        List<String> result=allPerm("geat");
        for(String str: result)
            System.out.println(str);
    }
}
