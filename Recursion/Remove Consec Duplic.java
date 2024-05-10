// https://www.geeksforgeeks.org/remove-consecutive-duplicates-string/

class HelloWorld {
    public static void main(String[] args) {
        String str = “aaaaabbbbbb”;
       System.out.println(
            removeDuplic(str,1,String.valueOf(str.charAt(0))));
    }
    
    static String removeDuplic(String str, int index, String res){
        if(index==str.length()) return res;
        if(str.charAt(index) != str.charAt(index-1))
            res+= String.valueOf(str.charAt(index));
       return removeDuplic(str,index+1,res);
    }
    
}
