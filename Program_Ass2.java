import java.util.*;
import java.io.*;

public class Program_Ass2 {
    public static void main(String[] args) throws FileNotFoundException {
        File imp = new File("my_txt.txt");
        Scanner read = new Scanner(imp);
        String txt = "" ;
        int new_line = 0;

        String[] remove_list = {","," ","/","\\.","%",":","<",">","\\)","\\(","'","\"","-","\\\\","\\?","_"};
        String comb_list = String.join("|", remove_list);


        while (read.hasNextLine()) {
            txt += read.nextLine();
            new_line++;
        }

        
        System.out.println("Total Charector count: "+char_count(txt,comb_list));
        System.out.println("Total palindrome found: "+palindrome(txt));
        System.out.println("Total number of token: "+token(txt, comb_list));     
        System.out.println("Total Number of emoticon: "+emoticon(txt));     
        System.out.println("Total of new line: "+new_line);     
        longest(txt);   
             
    }

    public static int char_count(String txt,String comb_list){
        txt = txt.replaceAll(comb_list,"");
        return txt.length();
        
    }
    public static int token(String txt,String comb_list){
        StringTokenizer token = new StringTokenizer(txt," ");
        return token.countTokens();
    }
    
    public static int palindrome(String txt){
        StringTokenizer token = new StringTokenizer(txt," ");
        
        boolean palin;
        int palin_count = 0;

        while (token.hasMoreTokens()) {
            String tk = token.nextToken();
            
            if(palindrome_count(tk)){
                palin_count++;
            }     
        }
        return palin_count;
    }
    public static boolean palindrome_count(String tk){
        int left = 0;
        int right = tk.length()-1;

        while(left < right){
            if(tk.charAt(left) != tk.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static int emoticon(String txt){
        StringTokenizer token = new StringTokenizer(txt," ");
        int emo = 0;
        while (token.hasMoreTokens()) {
            String tk = token.nextToken();
            if(tk.equals(":D") || tk.equals(":)")){
                emo++;
            }
        }
        return emo;
    }
    public static void longest(String txt){
        StringTokenizer token = new StringTokenizer(txt," ");
        String tk = "" ;
        while (token.hasMoreTokens()) {
            tk = token.nextToken();
        }
        System.out.println("Longest token: "+ tk);
    }

}