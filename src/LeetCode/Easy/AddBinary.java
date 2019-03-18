package LeetCode.Easy;

public class AddBinary {

        public String addBinary(String a, String b) {
            StringBuilder res=new StringBuilder();
            int n=a.length()-1;
            int m=b.length()-1;
            int i,j,carry;
            i=0;j=0; carry =0;
            while(n>=0 || m>=0){
                int sum=carry;
                if(n>=0) sum+=a.charAt(n--)-'0';
                if(m>=0) sum+=b.charAt(m--)-'0';
                res.append(sum%2);
                carry=sum/2;
            }
            if(carry!=0) res.append(carry);
            return res.reverse().toString();
        }
        public void main(String[] args){
            String a="00000";
            String b="00011";
            System.out.println(addBinary(a,b));
        }
}
