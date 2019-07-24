package Strings;


public class NumberToWords {
    static String[] placeValue={"Hundred ","Thousand, ", "Million, "};
    static String[] tens={"", "Ten ","Twenty ","Thirty ","Fourty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
    static String[] units={"", "One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};
    static String[] teens={"", "Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ", "Nineteen "};
    public static String ToWord(int a , int b){
        if(a==0 & b!=0) return units[b];
        if(b==0 && a!=0) return tens[a];
        if(a==1) return teens[b];
        else return tens[a]+units[b];
    }

    public static String ToWord(int a, int b, int c){
        if(a==0) return ToWord(b,c);
        else if(b==0 & c==0) return units[a]+placeValue[0];
        else return units[a]+placeValue[0]+ToWord(b,c);
    }

    public static String ToWord(int n){
        if(n==0) return "Zero";
        if(n<0) return "Negative";
        int plcV=0;
        StringBuilder str=new StringBuilder();
        while(n>0){
            System.out.println(n);
            int unit=n%10;n/=10;

            int ten=0, h=0;

            if(n>0) ten= n%10; n/=10;

            if(n>0) h=n%10; n/=10;

            if(h*100+ten*10+unit==0) {
                plcV++;continue;
            }
            if(plcV!=0) str.insert(0,placeValue[plcV]);
            str.insert(0, ToWord(h,ten,unit));
            plcV++;

        }

        return str.toString();
    }

    public static void main(String[] args){
        System.out.println(ToWord(999999999));
    }
}
