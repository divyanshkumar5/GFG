//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    static long shiftRight(long n) {
        return n << 32;
    }
    
    static long shiftLeft(long n){
        return n >> 32;
    }
    
    static long append(long n1, long n2){
        return n1 | n2;
    }
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        for(int i = 0; i < n; i++) arr1[i] = shiftRight(arr1[i]);
        for(int j = 0; j < m; j++) arr2[j] = shiftRight(arr2[j]);
        int a = 0;
        int b = 0;
        for(int i = 0; i < n + m; i++){
            int idx = i;
            long arr[];
            if (idx < n){
                arr = arr1;
            }
            else{
                idx -= n;
                arr = arr2;
            }
            if (a >= n){
                arr[idx] = append(arr[idx], shiftLeft(arr2[b]));
                b++;
            }
            else if (b >= m){
                arr[idx] = append(arr[idx], shiftLeft(arr1[a]));
                a++;
            }
            else if (arr1[a] <= arr2[b]){
                arr[idx] = append(arr[idx], shiftLeft(arr1[a]));
                a++;
            }
            else{
                arr[idx] = append(arr[idx], shiftLeft(arr2[b]));
                b++;
            }
        }
        for(int i = 0; i < n; i++) arr1[i] = shiftLeft(shiftRight(arr1[i]));
        for(int i = 0; i < m; i++) arr2[i] = shiftLeft(shiftRight(arr2[i]));
        
    }
}