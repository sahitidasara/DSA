// https://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/

import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> curr = new ArrayList<>();
        palindRecur("geekeg",0,curr,res);
        for(List item:res)
         System.out.println(item);
    }
    static boolean checkPalindrome(String str){
        StringBuilder sb = new StringBuilder(str);
        String rev = sb.reverse().toString();
        return str.equals(rev);
    }
    static void palindRecur(String str, int index,ArrayList<String> curr,ArrayList<ArrayList<String>> res){
        
        if(str.length()==index) {
            res.add(new ArrayList<String> (curr));
            return;}
        
        String temp="";
        for(int i=index;i<str.length();i++){
            temp+= str.charAt(i);
            
            if(checkPalindrome(temp)){
                curr.add(temp);
                palindRecur(str,i+1,curr,res);
                	// Remove the string from the current list - (backtracking)
				curr.remove(curr.size()-1);
            }
        }
    }
}
