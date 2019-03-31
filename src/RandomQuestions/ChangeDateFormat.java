package RandomQuestions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ChangeDateFormat {

    public static void changeDateFormat(String s){
        try{
            SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-DD", Locale.ENGLISH);
            //SimpleDateFormat in=new SimpleDateFormat("d[th|st|nd|rd]\\sMMM\\syyyy", Locale.ENGLISH);

            Date d=new Date();

            String res=f.format(d);
            System.out.println(res);
        }
        catch(ParseException e){

        }

    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        changeDateFormat(s);
        sc.close();
    }
}
