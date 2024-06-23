//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.bracketNumbers(S);
            for (int value : result) out.print(value + " ");
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        int n = str.length();
        // code here
        int[] bracketNumber = new int[n];
        int counter = 1;
        int[] bracketpos = new int[n];
        int index = 0;
        
        for(int i =0 ;i<n;i++){
            if(str.charAt(i) == '('){
                bracketNumber[i] = counter;
                bracketpos[index++] = counter;
                counter++;
            } else if(str.charAt(i) == ')'){
                bracketNumber[i] = bracketpos[--index];
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(bracketNumber[i]>0){
                result.add(bracketNumber[i]);
                
            }
        }
        return result;
    }
};