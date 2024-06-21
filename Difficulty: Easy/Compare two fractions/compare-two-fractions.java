//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String s) {
        // Code here
        String str[] = s.replace(" ","").split(",");
        String str1 = str[0];
        String str2= str[1];
        int a = 0, b = 0;
        boolean flag = false;
        
        for(int i = 0;i<str1.length();i++){
            char c = str1.charAt(i);
            if(c == '/'){
                flag = true;
            }else if(isNum(c)){
                if(flag){
                    b = b*10+(int)c-'0';
                }else{
                    a = a*10+(int)c-'0';
                }
            }
        }
        double res1 = (double)a/(double)b;
        a = 0;
        b = 0;
        flag = false;
        for(int i = 0;i<str2.length();i++){
            char c = str2.charAt(i);
            if(c == '/'){
                flag = true;
            }else if(isNum(c)){
                if(flag){
                    b = b*10+(int)c-'0';
                }else{
                    a = a*10+(int)c-'0';
                }
            }
        }
        double res2 = (double)a/(double)b;
        if(res1>res2){
            return str[0];
        }
        if(res1<res2){
            return str[1];
        }
        else{
            return "equal";
        }
        
    }
    
    boolean isNum(char c){
        return (c>='0' && c<='9');
    }
}
