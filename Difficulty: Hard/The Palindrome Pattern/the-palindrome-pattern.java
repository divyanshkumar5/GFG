//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

  class Solution {
    public String pattern(int[][] arr) {
         int rows=arr.length;
         int cols=arr[0].length;
         int k=0;
         int mid=cols/2;
         for(int i=0;i<rows;i++){
             int start=0;
             int last=cols-1;
             boolean flag=false;
             while(start<=mid)
             {
             if(arr[k][start]!=arr[k][last])
             {
                 flag=false;
                break;
             }
                start++;
                last--;
                flag=true;
             }
             k++;
            if(flag==true)
                return i+" "+ "R";
         }
         int l=0;
          for(int i=0;i<arr.length;i++){
             int start=0;
             int last=cols-1;
             boolean flag=false;
             while(start<=mid)
             {
             if(arr[start][l]!=arr[last][l])
             {
                 flag=false;
                break;
             }
                start++;
                last--;
                flag=true;
             }
             l++;
            if(flag==true)
                return i+" "+ "C";
         }
         return "-1";
    }
}