package LeetCode.Easy;
import java.io.IOException;

public class LongestCommonPrefix {

        public String longestCommonPrefix(String[] strs) {
            int i,j,p;
            String s="";
            i=0;p=0;
            j=strs.length;
            while(p < strs[1].length()){
                char c=strs[1].charAt(p);
                while(i<j){
                    if(strs[i].charAt(p) != c) return s;
                    i++;
                }
                if(i==j) s=s+c;
                p++;
            }
            return s;
        }


        public static void main(String[] args) throws IOException {
               String[] strs = {"Flow","flower","fish"};

                String ret = new LongestCommonPrefix().longestCommonPrefix(strs);

                String out = (ret);

                System.out.print(out);
            }
        }
